package com.elvesfish.client1.service.impl;


import com.elvesfish.client1.bean.GoodVo;
import com.elvesfish.client1.common.ResultInfo;
import com.elvesfish.client1.service.IGoodService;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class GoodFallBack implements IGoodService {

    @Override
    public ResultInfo getGoodById(String goodId) {
        String errorMsg = "调用远程服务[商品服务]失败或超时,降级处理";
        log.info("[ms-client2] fall back " + errorMsg);
        GoodVo goodVo = new GoodVo();
        goodVo.setGoodId("0");
        goodVo.setGoodName("默认商品名称");
        goodVo.setGoodType("1");
        goodVo.setGoodImage("/image/1.png");
        return new ResultInfo(ResultInfo.FAIL_CODE, errorMsg, goodVo);
    }
}
