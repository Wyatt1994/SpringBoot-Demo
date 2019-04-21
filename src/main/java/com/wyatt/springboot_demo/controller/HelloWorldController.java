package com.wyatt.springboot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ASUS on 2019/4/18.
 */

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello(){
        return "hello wyatt";
    }
}
