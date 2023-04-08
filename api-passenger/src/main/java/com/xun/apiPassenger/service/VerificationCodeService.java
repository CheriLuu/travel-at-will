package com.xun.apiPassenger.service;

import com.xun.apiPassenger.remote.ServiceVerificationcodeClient;
import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.response.NumberCodeResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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
    //验证码前缀
    private String verificationCodePrefix = "passenger-verification-code-";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    public ResponseResult generatorCode(String passengerPhone){
        //获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        //存入redis
        //传入key
        String key = verificationCodePrefix + passengerPhone;
        //存入redis
        stringRedisTemplate.opsForValue().set(key, String.valueOf(numberCode), 2, TimeUnit.MINUTES);
        //通过短信服务商， 将验证码发送到手机（阿里短信服务、腾讯短信通、华信、容联等，后续开发）
        //也可以返回""值
        return ResponseResult.success();
    }
}
