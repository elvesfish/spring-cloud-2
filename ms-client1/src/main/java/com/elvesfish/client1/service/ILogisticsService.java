package com.elvesfish.client1.service;

import com.elvesfish.client1.common.ResultInfo;
import com.elvesfish.client1.service.impl.LogisticsFallBack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: elvesfish
 * @date: 2019/4/22
 */
@FeignClient(name = "sleuth-client1", fallback = LogisticsFallBack.class)
public interface ILogisticsService {

    /**
     * 获取物流信息
     * 参数不对,返回类型不对,参数注解没有对上都是调用降级方法
     *
     * @param logisticsId
     * @return
     */
    @GetMapping("/logistics/one")
    ResultInfo getLogisticsById(@RequestParam("logisticsId") String logisticsId);
}
