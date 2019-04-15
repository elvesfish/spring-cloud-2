package com.elvesfish.feign.service.impl;

import com.elvesfish.feign.common.ResultInfo;
import com.elvesfish.feign.service.IOrderService;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderFallBack implements IOrderService {

    @Override
    public ResultInfo getOrderList() {
        log.info("order fall back ");
        return new ResultInfo(ResultInfo.FAIL_CODE, "调用远程接口[订单调用服务]失败或超时");
    }

    @Override
    public String hello(String name) {
        log.info("fall back hello:" + name);
        return null;
    }

    @Override
    public String getOne(String helloId) {
        log.info("fall back getOne:" + helloId);
        return null;
    }
}
