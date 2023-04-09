package com.xun.servicepassengeruser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/917:51
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "service-passenger-user";
    }
}
