package com.elvesfish.consul.service.impl;

import com.elvesfish.consul.bean.ProduceVo;
import com.elvesfish.consul.common.ResultInfo;
import com.elvesfish.consul.service.IProduceService;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: elvesfish
 * @date: 2019/4/26
 */
@Service
@Slf4j
public class ProduceFallBackServiceImpl implements IProduceService {

    @Override
    public ResultInfo getProduceById(String produceId) {
        String errorMsg = "调用远程服务[生产者服务]失败或超时,降级处理";
        log.info("[consul-producer] fall back " + errorMsg);
        ProduceVo produceVo = new ProduceVo();
        produceVo.setProduceId("0");
        produceVo.setProduceName("生产者没有");
        produceVo.setProduceType("0");
        return new ResultInfo(ResultInfo.FAIL_CODE, errorMsg, produceVo);
    }
}
