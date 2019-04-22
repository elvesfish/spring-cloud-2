package com.elvesfish.client1.service.impl;


import com.elvesfish.client1.bean.LogisticsVo;
import com.elvesfish.client1.common.ResultInfo;
import com.elvesfish.client1.service.ILogisticsService;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LogisticsFallBack implements ILogisticsService {

    @Override
    public ResultInfo getLogisticsById(String logisticsId) {
        String errorMsg = "调用远程服务[物流服务]失败或超时,降级处理";
        log.info("[sleuth-client1] fall back " + errorMsg);

        LogisticsVo logisticsVo = new LogisticsVo();
        logisticsVo.setLogisticsId("0");
        logisticsVo.setLogisticsName("默认物流名称");
        logisticsVo.setLogisticsType("0");
        logisticsVo.setLogisticsAddress("默认地址");
        return new ResultInfo(ResultInfo.FAIL_CODE, errorMsg, logisticsVo);
    }
}
