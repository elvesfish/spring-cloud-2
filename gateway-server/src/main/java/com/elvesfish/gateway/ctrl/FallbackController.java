package com.elvesfish.gateway.ctrl;

import com.elvesfish.gateway.common.ResultInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 *  熔断降级
 * @author: elvesfish
 * @date: 2019/4/23
 */
@RestController
@Slf4j
public class FallbackController {

    @GetMapping("/fallback")
    public ResultInfo fallback() {
        log.info("服务不可用,网关调用服务失败或者超时");
        return new ResultInfo("1000", "服务不可用,网关调用服务失败或者超时");
    }
}
