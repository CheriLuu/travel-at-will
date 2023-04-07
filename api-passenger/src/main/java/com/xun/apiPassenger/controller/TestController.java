package com.xun.apiPassenger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slx
 * @ClassName TestController
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "api passenger test";
    }
}
