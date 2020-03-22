package com.cocacola.yusicong.alllearning.exception;

import com.cocacola.yusicong.alllearning.domain.common.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create by idea
 * 全局异常捕获处理器
 *
 * @author yusicong
 * @date 2020/3/21
 * @time 17:13
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /**
     * 拦截业务类异常
     *
     * @param e 异常类型
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResponseResult businessExceptionHandle(BusinessException e) {
        log.error("捕捉到业务类异常：", e);
        return ResponseResult.failure(e.getCode(), e.getMessage());
    }


    /**
     * 拦截运行时异常
     *
     * @param e 异常类型
     */
    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseResult runTimeExceptionHandle(RuntimeException e) {
        log.error("捕捉到运行时异常：", e);
        return ResponseResult.failure(ErrorCodeEnum.UNKNOWN_ERROR.getCode(), e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ResponseResult throwableHandle(Throwable th) {
        log.error("捕捉Throwable异常：", th);
        return ResponseResult.failure(ErrorCodeEnum.SYSTEM_ERROR.getCode(), th.getMessage());
    }



}
