package com.elvesfish.feign.service.impl;

import com.elvesfish.feign.bean.OrderVo;
import com.elvesfish.feign.common.ResultInfo;
import com.elvesfish.feign.service.IOrderService;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OrderFallBack implements IOrderService {

    @Override
    public ResultInfo getOrderList() {
        String errorMsg = "调用远程接口[订单调用服务]失败或超时,降级处理";
        log.error("order fall back " + errorMsg);
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId("0");
        orderVo.setOrderName("空白");
        orderVo.setOrderType("1");
        return new ResultInfo(ResultInfo.FAIL_CODE, errorMsg, orderVo);
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
