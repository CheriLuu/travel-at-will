package com.xun.internalcommon.constant;

import lombok.Data;
import lombok.Getter;

public enum CommonStatusEnum {
    //成功
    SUCCESS(1, "success"),
    //失败
    FAIL(0, "fail"),
    VERIFICATION_CODE_EXPIRE(1000, "验证码已过期"),
    VERIFICATION_CODE_ERROR(1099,"验证码不正确")
    ;
    @Getter
    private int code;
    @Getter
    private String value;

    CommonStatusEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }
}
