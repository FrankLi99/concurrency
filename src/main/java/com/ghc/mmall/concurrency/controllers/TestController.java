package com.ghc.mmall.concurrency.controllers;

import com.ghc.mmall.concurrency.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping(value="/threadLocal")
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return RequestHolder.getId()+"";
    }

}
