package com.liangjun.studyspringsecurity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @desc    演示demo
* @version 1.0
* @author  Liang Jun
* @date    2020年05月11日 23:32:58
**/
@Controller
public class DemoController {

    @GetMapping("hi")
    @ResponseBody
    public String hi() {
        return "Hi, Jun";
    }
}