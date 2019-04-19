package com.elvesfish.zuul.config;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: 170066
 * @date: 2019/4/18
 */
@Setter
@Getter
public class RequestContextVo {

    private Boolean retryable;
    private String proxy;
    private String serviceId;
    private String requestURI;
    private String path;
}
