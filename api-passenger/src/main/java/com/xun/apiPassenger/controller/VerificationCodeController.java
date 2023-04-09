package com.xun.apiPassenger.controller;

import com.xun.apiPassenger.service.VerificationCodeService;
import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.request.VerificationCodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slx
 * @ClassName 验证码服务控制层
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@RestController
public class VerificationCodeController {
    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
    * @author Shilx
    * @description 接收验证码
    * @date 2023/4/9 16:40
    * @Param passengerPhone手机号
    * @return verificationCode验证码
    */
    @GetMapping("/verification-code")
    public ResponseResult verificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("接收到的手机号为："+passengerPhone);
        return verificationCodeService.generatorCode(passengerPhone);
    }
    /**
    * @author Shilx
    * @description 校验验证码
    * @date 2023/4/9 16:42
    * @Param
    * @return
    */
    @PostMapping("/verification-code-check")
    public ResponseResult checkVerificationCode(@RequestBody VerificationCodeDTO verificationCodeDTO){
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        String verificationCode = verificationCodeDTO.getVerificationCode();
        System.out.println("passengerPhone:"+passengerPhone+"verificationCode:"+verificationCode);
        return verificationCodeService.checkVerificationCode(passengerPhone, verificationCode);
    }
}
