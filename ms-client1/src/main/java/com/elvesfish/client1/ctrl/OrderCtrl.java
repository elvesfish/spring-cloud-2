package com.elvesfish.client1.ctrl;

import com.alibaba.fastjson.JSON;
import com.elvesfish.client1.bean.GoodVo;
import com.elvesfish.client1.bean.OrderVo;
import com.elvesfish.client1.common.ResultInfo;
import com.elvesfish.client1.service.IGoodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderCtrl {

    @Autowired
    private IGoodService goodService;

    @GetMapping("/list")
    public ResultInfo selectOrderList() {
        System.out.println(" client1 order list");
//        try {
//            Thread.sleep(10000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        OrderVo orderVo = new OrderVo();
        orderVo.setOrderId("1");
        orderVo.setOrderName("订单信息");
        orderVo.setOrderType("2");
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "client Order ", orderVo);
    }

    /**
     * 订单获取商品信息
     *
     * @param goodId
     * @return
     */
    @GetMapping("/good")
    public ResultInfo selectOrderGoodInfo(@RequestParam("goodId") String goodId) {
//        accessTimeOut(6000L);
        ResultInfo resultInfo = goodService.getGoodById(goodId);
        if (ResultInfo.SUCCESS_CODE.equals(resultInfo.getCode())) {
            GoodVo goodVo = JSON.parseObject(JSON.toJSONString(resultInfo.getData()), GoodVo.class);
            log.info(goodVo.toString());
        } else {
            log.info("降级处理成功:" + resultInfo.getMessage());
        }
        return resultInfo;
    }

    private void accessTimeOut(Long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }


}
