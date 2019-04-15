package com.elvesfish.feign.service;

import com.elvesfish.feign.common.ResultInfo;
import com.elvesfish.feign.conf.MFeignConfig;
import com.elvesfish.feign.service.impl.OrderFallBack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-client1", configuration = MFeignConfig.class, fallback = OrderFallBack.class)
public interface IOrderService {

    @GetMapping("/order/list")
    ResultInfo getOrderList();

    @GetMapping("/hello/list")
    String hello(@RequestParam(value = "name") String name);

    @GetMapping("/hello/one")
    String getOne(@RequestParam(value = "helloId") String helloId);
}
