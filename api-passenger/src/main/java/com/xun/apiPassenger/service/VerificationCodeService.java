package com.xun.apiPassenger.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author slx
 * @ClassName VerificationCodeService
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@Service
public class VerificationCodeService {
    public String generatorCode(String passengerPhone){
        //获取验证码
        System.out.println("获取验证码");

        //存入redis
        System.out.println("存入Redis");

        //返回验证码
        JSONObject result = new JSONObject();
        result.put("code", 1);
        result.put("message", "success");
        return result.toString();
    }
}
