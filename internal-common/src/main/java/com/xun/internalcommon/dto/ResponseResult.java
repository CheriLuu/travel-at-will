package com.xun.internalcommon.dto;

import com.xun.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author slx
 * @ClassName ResponseResult
 * @description: TODO
 * @date 2023年04月07日
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class ResponseResult<T> {
    private int code;
    private String message;
    private T data;
    /**
     * @MethodName 成功
     * @author slx
     * @date 2023年04月07日
     * @param data
     * @return T
     */
    public static ResponseResult<T> success(T data){
        return new ResponseResult().setCode(CommonStatusEnum.SUCCESS.getCode())
                .setMessage(CommonStatusEnum.SUCCESS.getValue())
                .setData(data);
    }

    /**
     * @MethodName 失败，统一处理
     * @author slx
     * @date 2023年04月07日
     * @param data
     * @return ResponseResult
     */
    public ResponseResult<T> fail(T data) {
        return new ResponseResult().setData(data);
    }

    /**
     * @param code,message
     * @return ResponseResult
     * @MethodName 失败，自定义的返回
     * @author slx
     * @date 2023年04月07日
     */
    public ResponseResult<T> fail(int code, String message) {
        return new ResponseResult().setCode(code).setMessage(message);
    }

    /**
     * @param code,message,data
     * @return ResponseResult
     * @MethodName 失败，自定义的返回2
     * @author slx
     * @date 2023年04月07日
     */
    public ResponseResult<T> fail(int code, String message, String data) {
        return new ResponseResult().setCode(code).setMessage(message).setData(data);
    }
}
