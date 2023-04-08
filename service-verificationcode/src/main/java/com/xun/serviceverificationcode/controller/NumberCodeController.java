package com.xun.serviceverificationcode.controller;

import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.response.NumberCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/817:58
 */
@RestController
public class NumberCodeController {
    @GetMapping("/numberCode/{size}")
    public ResponseResult numberCode(@PathVariable("size") int size) {
        System.out.println("size:"+size);
        //生成验证码
        int resultInt = (int) ((Math.random() * 9 + 1) * (Math.pow(10, size - 1)));
        System.out.println("生成的验证码为："+resultInt);
        NumberCodeResponse result = new NumberCodeResponse();
        result.setNumberCode(resultInt);
        return ResponseResult.success(result);
    }
}
