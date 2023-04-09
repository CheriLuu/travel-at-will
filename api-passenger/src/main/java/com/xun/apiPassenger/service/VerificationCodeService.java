package com.xun.apiPassenger.service;

import com.xun.apiPassenger.remote.ServiceVerificationcodeClient;
import com.xun.internalcommon.constant.CommonStatusEnum;
import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.dto.TokenResponse;
import com.xun.internalcommon.response.NumberCodeResponse;
import org.apache.commons.lang.StringUtils;
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
    /**
    * @author Shilx
    * @description 生成验证码
    * @date 2023/4/9 16:44
    * @Param passengerPhone手机号
    * @return verificationCode验证码
    */
    public ResponseResult generatorCode(String passengerPhone){
        //获取验证码
        ResponseResult<NumberCodeResponse> numberCodeResponse = serviceVerificationcodeClient.getNumberCode(6);
        int numberCode = numberCodeResponse.getData().getNumberCode();
        //存入redis
        //传入key
        String key = generatorKeyByPassengerPhone(passengerPhone);
        //存入redis
        stringRedisTemplate.opsForValue().set(key, String.valueOf(numberCode), 2, TimeUnit.MINUTES);
        //通过短信服务商， 将验证码发送到手机（阿里短信服务、腾讯短信通、华信、容联等，后续开发）
        //也可以返回""值
        return ResponseResult.success();
    }
    /**
    * @author Shilx
    * @description 生成redis中的key
    * @date 2023/4/9 17:08
    * @Param
    * @return 
    */
    private String generatorKeyByPassengerPhone(String passengerPhone){
        return verificationCodePrefix + passengerPhone;
    }
    /**
    * @author Shilx
    * @description 校验验证码
    * @date 2023/4/9 16:45
    * @Param
    * @return
    */
    public ResponseResult checkVerificationCode(String passengerPhone,String verificationCode){
        //读取验证码
        //生成key
        String key = generatorKeyByPassengerPhone(passengerPhone);
        //根据key获取value
        String redisValue = stringRedisTemplate.opsForValue().get(key);
        //校验验证码
        //验证码过期
        if (StringUtils.isBlank(redisValue)) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_EXPIRE.getCode(), CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        //验证码不正确
        if (!redisValue.trim().equals(verificationCode.trim())) {
            return ResponseResult.fail(CommonStatusEnum.VERIFICATION_CODE_ERROR.getCode(), CommonStatusEnum.VERIFICATION_CODE_ERROR.getValue());
        }
        //判断用户是否存在
        System.out.println("当前用户存在");
        //颁发令牌
        System.out.println("颁发令牌");
        //响应token
        TokenResponse token = new TokenResponse();
        token.setToken("token");
        return ResponseResult.success(token);
    }
}
