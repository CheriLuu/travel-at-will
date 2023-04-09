package com.xun.apiPassenger.remote;

import com.xun.internalcommon.dto.ResponseResult;
import com.xun.internalcommon.request.VerificationCodeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description //TODO
 * @Author Shilx
 * @Date 2023/4/920:06
 */
@FeignClient("service-passenger-user")
public interface ServicePassengerUserClient {
    @PostMapping(value = "/user")
    public ResponseResult logOrReg(@RequestBody VerificationCodeDTO verificationCodeDTO);
}
