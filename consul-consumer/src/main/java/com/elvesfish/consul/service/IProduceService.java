package com.elvesfish.consul.service;


import com.elvesfish.consul.common.ResultInfo;
import com.elvesfish.consul.service.impl.ProduceFallBackServiceImpl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: elvesfish
 * @date: 2019/4/17
 */
@FeignClient(name = "consul-producer", fallback = ProduceFallBackServiceImpl.class)
public interface IProduceService {

    /**
     * 获取生产者信息
     * 参数不对,返回类型不对,参数注解没有对上都是调用降级方法
     *
     * @param produceId
     * @return
     */
    @GetMapping("/produce/one")
    ResultInfo getProduceById(@RequestParam("produceId") String produceId);
}
