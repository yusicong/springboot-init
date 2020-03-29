package com.cocacola.yusicong.alllearning.config;

import com.cocacola.yusicong.alllearning.intercepter.RateLimitInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * Create by idea
 * web配置类
 *
 * @author yusicong
 * @date 2020/3/29
 * @time 22:30
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private RateLimitInterceptor rateLimitInterceptor;

    /**
     * 向web中添加拦截器
     * 拦截所有/api 开头的请求
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimitInterceptor)
                .addPathPatterns("/api/**");
    }

    /**
     * 静态资源配置
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
