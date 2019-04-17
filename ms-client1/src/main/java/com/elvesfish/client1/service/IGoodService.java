package com.elvesfish.client1.service;

import com.elvesfish.client1.common.ResultInfo;
import com.elvesfish.client1.service.impl.GoodFallBack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: 170066
 * @date: 2019/4/17
 */
@FeignClient(name = "ms-client2", fallback = GoodFallBack.class)
public interface IGoodService {

    /**
     * 获取商品信息
     * 参数不对,返回类型不对,参数注解没有对上都是调用降级方法
     *
     * @param goodId
     * @return
     */
    @GetMapping("/good/one")
    ResultInfo getGoodById(@RequestParam("goodId") String goodId);
}
