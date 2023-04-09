package com.xun.servicepassengeruser.controller;

import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.request.VerificationCodeDTO;
import com.xun.servicepassengeruser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/918:02
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResponseResult logOrRegistry(@RequestBody VerificationCodeDTO verificationCodeDTO) {
        String passengerPhone = verificationCodeDTO.getPassengerPhone();
        System.out.println("passengerPhone:"+passengerPhone);
        return ResponseResult.success();
    }
}
