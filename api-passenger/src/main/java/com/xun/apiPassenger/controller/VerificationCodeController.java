package com.xun.apiPassenger.controller;

import com.xun.apiPassenger.request.VerificationCodeDTO;
import com.xun.apiPassenger.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slx
 * @ClassName VerificationCodeController
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    @GetMapping("/verification-code")
    public String verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("接收到的手机号为："+passengerPhone);
        return verificationCodeService.generatorCode(passengerPhone);
    }
}
