package com.cocacola.yusicong.alllearning.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
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


    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //数据库类型配置
        paginationInterceptor.setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }

    /**
     * @return 开启乐观锁
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
}
