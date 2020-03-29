package com.cocacola.yusicong.alllearning.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Create by idea
 * 错误枚举
 *
 * @author yusicong
 * @date 2020/3/19
 * @time 22:33
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {
    /**
     * 0XXX成功
     */
    SUCCESS("0000", "操作成功"),
    /**
     * 1XXX参数异常
     */
    PARAM_ERROR("1001", "参数异常"),
    PARAM_NULL("1002", "参数为空"),
    PARAM_FORMAT_ERROR("1003", "参数格式不正确"),
    PARAM_VALUE_ERROR("1004", "参数值不正确"),
    /**
     * 2XXX 系统异常
     */
    SYSTEM_ERROR("2001", "服务异常"),
    UNKNOWN_ERROR("2002", "未知异常"),
    /**
     * 3XXX 业务异常
     */
    XXX("3001", "业务异常"),
    INSERT_FAILURE("3002", "新增失败"),
    UPDATE_FAILURE("3003", "更新失败"),
    DELETE_FAILURE("3004", "删除失败"),
    RATE_LIMIT_ERROR("3005", "限流异常"),

    ;
    /**
     * 错误编码
     */
    private String code;
    /**
     * 错误信息
     */
    private String message;
}
