package com.elvesfish.client1.ctrl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hello")
@RefreshScope
@Slf4j
public class HelloCtrl {

    @Value("${foo}")
    String foo;

    @GetMapping("/list")
    public String selectHello(@RequestParam String name) {
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        return "client Hello " + name;
    }

    @GetMapping("/one")
    public String getOne(@RequestParam(value = "helloId") String helloId) {
        return "client one helloId:" + helloId;
    }

    /**
     * 1.测试 config-server配置文件数据
     * 2.修改后配置文件需要更新
     * http://localhost:8082/actuator/refresh 请求方式:POST 表示手动刷新配置文件信息
     *
     * @return
     */
    @GetMapping("/test-pro")
    public String testProperties() {
        log.info("properties foo:" + foo);
        return "properties:" + foo;
    }

}
