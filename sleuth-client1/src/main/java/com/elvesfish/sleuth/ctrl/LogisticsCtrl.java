package com.elvesfish.sleuth.ctrl;

import com.elvesfish.sleuth.bean.LogisticsVo;
import com.elvesfish.sleuth.common.ResultInfo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: elvesfish
 * @date: 2019/4/19
 */
@RestController
@RequestMapping("/logistics")
@Slf4j
public class LogisticsCtrl {

    @GetMapping("/one")
    public ResultInfo getOne(@RequestParam(value = "logisticsId") String logisticsId) {
        //db查询
        LogisticsVo logisticsVo = new LogisticsVo();
        logisticsVo.setLogisticsId("l" + logisticsId);
        logisticsVo.setLogisticsName("物流名称" + logisticsId);
        logisticsVo.setLogisticsType("1");
        logisticsVo.setLogisticsAddress("小区" + logisticsId);
        return new ResultInfo(ResultInfo.SUCCESS_CODE, "获取一个物流信息", logisticsVo);
    }
}
