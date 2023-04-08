package com.xun.apiPassenger.remote;

import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.response.NumberCodeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/819:20
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationcodeClient {
    @RequestMapping(method = RequestMethod.GET,value = "/numberCode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
