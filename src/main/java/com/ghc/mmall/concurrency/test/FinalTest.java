package com.ghc.mmall.concurrency.test;

import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/19 11:28
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Slf4j
public class FinalTest {
    private final static Integer a = 1;
    private final static String b = "2";

    private static Map<? super Integer, ? super String> map = Maps.newHashMap();

    static{
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
    }

    public static void main(String[] args) {
        map.put(2,"d");
        log.info("ssss");
    }

}
