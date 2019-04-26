package com.elvesfish.consul.common;

import lombok.extern.slf4j.Slf4j;

/**
 * @author: elvesfish
 * @date: 2019/4/26
 */
@Slf4j
public class TimeOutUtil {

    public static void accessTimeOut(Long timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
