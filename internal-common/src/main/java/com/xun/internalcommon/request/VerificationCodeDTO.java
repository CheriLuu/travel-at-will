package com.xun.internalcommon.request;

import lombok.Data;

/**
 * @author slx
 * @ClassName VerificationCodeDTO
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@Data
public class VerificationCodeDTO {
    //手机号
    private String passengerPhone;
    //验证码
    private String verificationCode;
}
