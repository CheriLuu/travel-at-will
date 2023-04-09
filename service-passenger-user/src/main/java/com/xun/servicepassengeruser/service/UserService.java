package com.xun.servicepassengeruser.service;

import com.xun.internalcommon.dto.ResponseResult;
import org.springframework.stereotype.Service;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/918:10
 */
@Service
public class UserService {
    public ResponseResult logOrReg(String passengerPhone) {
        System.out.println("服务被调用，手机号："+passengerPhone);
        //根据手机号查询用户信息
        //判断用户信息是否存在
        //不存在，插入
        return ResponseResult.success();
    }
}
