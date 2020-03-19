package com.cocacola.yusicong.alllearning.domain.common;

import com.cocacola.yusicong.alllearning.exception.ErrorCodeEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Create by idea
 * 通用返回类型
 *
 * @author yusicong
 * @date 2020/3/17
 * @time 21:19
 */
@Data
public class ResponseResult<T> implements Serializable {

    /**
     * 本次请求是否success
     */
    private Boolean success;

    /**
     * 错误编码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 结果
     */
    private T result;

    /**
     * 返回一个success的返回类型
     *
     * @param result 需要返回的结果
     * @param <T>    泛型
     * @return success的返回结果
     */
    public static <T> ResponseResult<T> success(T result) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.TRUE);
        responseResult.setResult(result);
        return responseResult;
    }

    public static <T> ResponseResult<T> failure(String errorCode, String errorMessage) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.FALSE);
        responseResult.setCode(errorCode);
        responseResult.setMessage(errorMessage);
        return responseResult;
    }

    public static <T> ResponseResult<T> failure(ErrorCodeEnum codeEnum) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setSuccess(Boolean.FALSE);
        responseResult.setCode(codeEnum.getCode());
        responseResult.setMessage(codeEnum.getMessage());
        return responseResult;
    }
}
