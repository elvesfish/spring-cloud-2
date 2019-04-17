package com.elvesfish.feign.ctrl;

import com.alibaba.fastjson.JSON;
import com.elvesfish.feign.bean.GoodVo;
import com.elvesfish.feign.bean.OrderVo;
import com.elvesfish.feign.common.ResultInfo;
import com.elvesfish.feign.service.IGoodService;
import com.elvesfish.feign.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@RefreshScope
@Slf4j
public class UserCtrl {

    @Value("${customer.name}")
    String customerName;

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IGoodService goodService;

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
        if (ResultInfo.SUCCESS_CODE.equals(resultInfo.getCode())) {
            OrderVo orderVo = JSON.parseObject(JSON.toJSONString(resultInfo.getData()), OrderVo.class);
            log.info(orderVo.toString());
        } else {
            log.info("降级处理成功:" + resultInfo.getMessage());
        }
        return resultInfo;
    }

    @GetMapping("/good")
    public ResultInfo selectGood() {
        ResultInfo resultInfo = goodService.getGoodOne();
        if (ResultInfo.SUCCESS_CODE.equals(resultInfo.getCode())) {
            GoodVo goodVo = JSON.parseObject(JSON.toJSONString(resultInfo.getData()), GoodVo.class);
            log.info(goodVo.toString());
        } else {
            log.info("降级处理成功:" + resultInfo.getMessage());
        }
        return resultInfo;
    }

    @GetMapping("/test-pro")
    public ResultInfo testProperties() {
        log.info("customerName:" + customerName);
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "返回配置中心文件的值", customerName);
    }


}
