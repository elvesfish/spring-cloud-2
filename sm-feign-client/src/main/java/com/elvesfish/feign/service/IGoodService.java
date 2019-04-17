package com.elvesfish.feign.service;

import com.elvesfish.feign.common.ResultInfo;
import com.elvesfish.feign.conf.MFeignConfig;
import com.elvesfish.feign.service.impl.GoodFallBack;
import com.elvesfish.feign.service.impl.OrderFallBack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ms-client2", configuration = MFeignConfig.class, fallback = GoodFallBack.class)
public interface IGoodService {

    @GetMapping("/good/one")
    ResultInfo getGoodOne();

}
