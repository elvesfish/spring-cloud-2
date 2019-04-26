package com.elvesfish.consul.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: elvesfish
 * @date: 2019/4/26
 */
@Getter
@Setter
@Data
public class ProduceVo {

    private String produceId;
    private String produceName;
    private String produceType;
}
