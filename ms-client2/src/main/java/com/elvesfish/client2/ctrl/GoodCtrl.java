package com.elvesfish.client2.ctrl;

import com.elvesfish.client2.bean.GoodVo;
import com.elvesfish.client2.common.ResultInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/good")
@Slf4j
public class GoodCtrl {

    @GetMapping("/one")
    public ResultInfo getOne(@RequestParam(value = "goodId") String goodId) {
//        accessTimeOut();
        //db查询
        GoodVo goodVo = new GoodVo();
        goodVo.setGoodId("g" + goodId);
        goodVo.setGoodName("商品名称" + goodId);
        goodVo.setGoodType("1");
        goodVo.setGoodImage("/image/1001.png");
        log.info("商品信息成功");
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "获取一个商品信息", goodVo);
    }

    private void accessTimeOut() {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }


}
