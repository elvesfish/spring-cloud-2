package com.elvesfish.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.elvesfish.gateway.common.ResultInfo;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import reactor.core.publisher.Mono;

/**
 * 自定义JWT检查网关过滤器
 */
@Component
public class JwtCheckGatewayFilterFactory extends AbstractGatewayFilterFactory<JwtCheckGatewayFilterFactory.Config> {

    public JwtCheckGatewayFilterFactory() {
        super(JwtCheckGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(JwtCheckGatewayFilterFactory.Config config) {
        return (exchange, chain) -> {
            //return chain.filter(exchange);
            String jwtToken = exchange.getRequest().getHeaders().getFirst("Authorization");
            //校验jwtToken的合法性
//            if (JwtUtil.verifyToken(jwtToken) != null) {
            if (StringUtils.isNotBlank(jwtToken)) {
                //合法
                return chain.filter(exchange);
            }
            //不合法
            ServerHttpResponse response = exchange.getResponse();
            //设置headers
            HttpHeaders httpHeaders = response.getHeaders();
            httpHeaders.add("Content-Type", "application/json; charset=UTF-8");
            httpHeaders.add("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
            //设置body
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setCode("401");
            resultInfo.setMessage("未登录或登录超时");

            //参数检查
            if ("200".equals(config.getStatus())) {
                response.getHeaders().add("X-JWT-status", config.getStatus());
            }
            if ("localhost".equals(config.getUrl())) {
                response.getHeaders().add("X-JWT-url", config.getUrl());
            }

            byte[] datas = JSON.toJSONString(resultInfo).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(datas);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        };

    }

    /**
     * 配置参数
     */
    public static class Config {
        String status;
        String url;

        public Config() {
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
