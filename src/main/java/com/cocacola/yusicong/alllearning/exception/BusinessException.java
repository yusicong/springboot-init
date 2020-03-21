package com.cocacola.yusicong.alllearning.exception;

import lombok.Getter;

/**
 * Create by idea
 * 业务类异常
 *
 * @author yusicong
 * @date 2020/3/21
 * @time 17:23
 */
public class BusinessException extends RuntimeException {

    @Getter
    private final String code;

    /**
     * 根据异常枚举类构造业务类异常
     *
     * @param errorCodeEnum 异常枚举类
     */
    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage());
        this.code = errorCodeEnum.getCode();
    }

    /**
     * 自定义消息体构造业务类异常
     *
     * @param errorCodeEnum 异常枚举类
     * @param errorMessage  异常信息
     */
    public BusinessException(ErrorCodeEnum errorCodeEnum, String errorMessage) {
        super(errorMessage);
        this.code = errorCodeEnum.getCode();
    }

    /**
     * 根据异常构造业务类异常
     *
     * @param errorCodeEnum 异常枚举类
     * @param throwable     异常
     */
    public BusinessException(ErrorCodeEnum errorCodeEnum, Throwable throwable) {
        super(throwable);
        this.code = errorCodeEnum.getCode();
    }
}
