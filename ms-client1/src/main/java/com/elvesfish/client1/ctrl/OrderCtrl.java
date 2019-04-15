package com.elvesfish.client1.ctrl;

import com.elvesfish.client1.common.ResultInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderCtrl {

    @GetMapping("/list")
    public ResultInfo selectOrderList() {
        System.out.println(" client1 order list");
//        try {
//            Thread.sleep(10000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "client Order ");
    }
}
