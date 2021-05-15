package com.sqin.servicesms.controller;

/*
 * @Author Sheng Qin
 * @Description
 * @Date 23:32 2021/5/11
 **/

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/myController")
public class MyController {

    @RequestMapping("/hello")
    public String hello() {
        return "world";
    }

}
