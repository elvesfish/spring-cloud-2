package com.elvesfish.consul.ctrl;

import com.alibaba.fastjson.JSON;
import com.elvesfish.consul.bean.ProduceVo;
import com.elvesfish.consul.common.ResultInfo;
import com.elvesfish.consul.service.IProduceService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/consumer")
@Slf4j
public class ConsumerCtrl {

    @Autowired
    private IProduceService produceService;

    @GetMapping("/one")
    public ResultInfo selectOrderList(@RequestParam("id") String id) {
        log.info("消费者调用生产者服务");
        ProduceVo produceVo;
        ResultInfo resultInfo = produceService.getProduceById(id);
        if (ResultInfo.SUCCESS_CODE.equals(resultInfo.getCode())) {
            produceVo = JSON.parseObject(JSON.toJSONString(resultInfo.getData()), ProduceVo.class);
            log.info(produceVo.toString());
        } else {
            log.info("降级处理成功:" + resultInfo.getMessage());
            produceVo = (ProduceVo) resultInfo.getData();
        }
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "client produceVo", produceVo);
    }
}
