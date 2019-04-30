package com.elvesfish.consul.ctrl;

//import com.elvesfish.consul.config.MyProperties;

//import org.springframework.beans.factory.annotation.Autowired;
import com.elvesfish.consul.config.MyProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: elvesfish
 * @date: 2019/4/26
 */
@RestController
public class TestCtrl {

    @Autowired
    private MyProperties properties;

//    @Value("${my.prop}")
//    String value;

//    @GetMapping("/getConfigFromValue")
//    public String getConfigFromValue() {
//        return value;
//    }

    @GetMapping("/getConfigFromProperty")
    public String getConfigFromProperty() {
        return properties.getProp();
    }


}
