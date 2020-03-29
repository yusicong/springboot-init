package com.cocacola.yusicong.alllearning.intercepter;

import com.cocacola.yusicong.alllearning.exception.BusinessException;
import com.cocacola.yusicong.alllearning.exception.ErrorCodeEnum;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/3/29
 * @time 22:21
 */
@Slf4j
@Component
public class RateLimitInterceptor implements HandlerInterceptor {

    /**
     * 限流器实例（QPS限制为10）
     */
    private static final RateLimiter rateLimiter = RateLimiter.create(10);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!rateLimiter.tryAcquire()) {
            log.error("请求被限流!");
            throw new BusinessException(ErrorCodeEnum.RATE_LIMIT_ERROR);
        }
        return true;
    }
}
