package com.rednet.helloboot.controller;

import com.rednet.helloboot.annotatio.LogAnno;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/log")
    @LogAnno
    public String logHello(String param) {
        return "hahaha";
    }


}
