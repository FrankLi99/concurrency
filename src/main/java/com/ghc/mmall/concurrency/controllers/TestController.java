package com.ghc.mmall.concurrency.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/17 14:33
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Controller
@Slf4j
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }


}
