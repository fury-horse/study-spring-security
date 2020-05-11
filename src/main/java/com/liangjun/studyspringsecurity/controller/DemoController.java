package com.liangjun.studyspringsecurity.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* @desc    演示demo
* @version 1.0
* @author  Liang Jun
* @date    2020年05月11日 23:32:58
**/
@RestController
public class DemoController {

    @GetMapping("hi")
    public String hi() {
        return "Hi, Jun";
    }
}