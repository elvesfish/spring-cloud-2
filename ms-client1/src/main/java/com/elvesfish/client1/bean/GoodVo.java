package com.elvesfish.client1.bean;

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
public class GoodVo {

    private String goodId;
    private String goodName;
    private String goodType;
    private String goodImage;
}
