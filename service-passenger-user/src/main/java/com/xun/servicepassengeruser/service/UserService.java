package com.xun.servicepassengeruser.service;

import com.xun.internalcommon.dto.ResponseResult;
import com.xun.servicepassengeruser.dto.PassengerUser;
import com.xun.servicepassengeruser.mapper.PassengerUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/918:10
 */
@Service
public class UserService {
    @Autowired
    private PassengerUserMapper passengerUserMapper;
    public ResponseResult logOrReg(String passengerPhone) {
        System.out.println("服务被调用，手机号："+passengerPhone);
        //根据手机号查询用户信息
        Map<String, Object> map = new HashMap<>();
        map.put("passenger_phone", passengerPhone);
        List<PassengerUser> passengerUsers = passengerUserMapper.selectByMap(map);
        passengerUsers.forEach(passengerUser -> {
            System.out.println("passenger:"+passengerUser);
        });
        //判断用户信息是否存在
        //不存在，插入
        return ResponseResult.success();
    }
}
