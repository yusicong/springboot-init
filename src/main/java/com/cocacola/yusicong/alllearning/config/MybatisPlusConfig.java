package com.cocacola.yusicong.alllearning.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create by idea
 * MybatisPlus配置
 *
 * @author yusicong
 * @date 2020/3/19
 * @time 22:02
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * @return 开启乐观锁
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
