package com.elvesfish.consul.ctrl;

import com.elvesfish.consul.bean.ProduceVo;
import com.elvesfish.consul.common.ResultInfo;
import com.elvesfish.consul.common.TimeOutUtil;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: elvesfish
 * @date: 2019/4/26
 */
@RestController
@RequestMapping("/produce")
@Slf4j
public class ProduceCtrl {



    @GetMapping("/one")
    public ResultInfo selectOrderList(@RequestParam("produceId") String produceId) {
        TimeOutUtil.accessTimeOut(8000L);
        ProduceVo produceVo = new ProduceVo();
        produceVo.setProduceId("22" + produceId);
        produceVo.setProduceName("生产者信息");
        produceVo.setProduceType("2");
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "client produceVo ", produceVo);
    }
}
