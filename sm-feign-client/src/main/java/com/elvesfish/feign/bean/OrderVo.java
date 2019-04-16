package com.elvesfish.feign.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: elvesfish
 * @date: 2019/4/16
 */
@Getter
@Setter
@Data
public class OrderVo {

    private String orderId;
    private String orderName;
    private String orderType;
}
