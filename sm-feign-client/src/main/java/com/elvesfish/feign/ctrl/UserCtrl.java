package com.elvesfish.feign.ctrl;

import com.elvesfish.feign.common.ResultInfo;
import com.elvesfish.feign.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserCtrl {

    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    public String selectUser() {
        log.info("结果:" + orderService.hello("test"));
        return "hello";
    }

    @GetMapping("/one/{helloId}")
    public String selectUserOne(@PathVariable("helloId") String helloId) {
        orderService.getOne(helloId);
        return "hello id:" + helloId;
    }

    @GetMapping("/order")
    public ResultInfo selectOrder() {
        ResultInfo resultInfo = orderService.getOrderList();
        log.info(resultInfo.getCode() + "," + resultInfo.getMessage());
        return resultInfo;
    }

}
