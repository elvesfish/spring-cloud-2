package com.elvesfish.zuul.config;

import com.alibaba.fastjson.JSONObject;
import com.elvesfish.zuul.common.ResultInfo;
import com.netflix.zuul.context.RequestContext;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * 网关服务熔断降级处理
 */
@Component
@Slf4j
public class ZuulFallBack implements FallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String s, Throwable throwable) {
        return build("gateway fall back");
    }

    public ClientHttpResponse build(String message) {
        return new ClientHttpResponse() {

            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream(JSONObject.toJSONString(getMessage()).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                //和body中的内容编码一致，否则容易乱码
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }

            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
             * 不应该把api的404,500等问题抛给客户端
             * 网关和api服务集群对于客户端来说是黑盒子
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

        };
    }

    /**
     * 获取更精确的路由故障问题描述
     */
    private ResultInfo getMessage() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String result = null;
        Boolean retryable = (Boolean) ctx.get("retryable");
        String proxy = (String) ctx.get("proxy");
        String serviceId = (String) ctx.get("serviceId");
        String requestURI = (String) ctx.get("requestURI");

        HttpServletRequest request = ctx.getRequest();
        String path = "未知";
        if (request != null) {
            path = request.getServletPath();
        }

        RequestContextVo requestContextVo = new RequestContextVo();
        requestContextVo.setProxy(proxy);
        requestContextVo.setRetryable(retryable);
        requestContextVo.setServiceId(serviceId);
        requestContextVo.setRequestURI(requestURI);
        requestContextVo.setPath(path);

        log.info(JSONObject.toJSONString(requestContextVo));

        result = String.format("目标服务不可用,服务ID:[%s],接口:[%s]", serviceId, path);

        return new ResultInfo(ResultInfo.FAIL_CODE, result, requestContextVo);
    }
}
