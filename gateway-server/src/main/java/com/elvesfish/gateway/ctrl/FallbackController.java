package com.elvesfish.gateway.ctrl;

import com.elvesfish.gateway.common.ResultInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  熔断降级
 * @author: elvesfish
 * @date: 2019/4/23
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public ResultInfo fallback() {
        return new ResultInfo("1000", "服务不可用,网关调用服务失败或者超时");
    }
}
