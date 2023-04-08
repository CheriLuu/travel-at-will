package com.xun.apiPassenger.service;

import com.xun.apiPassenger.remote.ServiceVerificationcodeClient;
import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ServiceVerificationcodeClient serviceVerificationcodeClient;
    public String generatorCode(String passengerPhone){
        //获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        System.out.println("获取到的验证码为："+numberCode);

        //存入redis
        System.out.println("存入Redis");

        //返回验证码
        JSONObject result = new JSONObject();
        result.put("code", 1);
        result.put("message", "success");
        return result.toString();
    }
}
