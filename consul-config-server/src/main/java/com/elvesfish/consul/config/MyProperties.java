package com.elvesfish.consul.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author: 170066
 * @date: 2019/4/26
 */
@RefreshScope
//@Configuration
@ConfigurationProperties("my")
public class MyProperties {

    private String prop;

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}
