package com.cocacola.yusicong.alllearning.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Create by idea
 * 缓存管理配置类
 *
 * @author yusicong
 * @date 2020/3/22
 * @time 22:38
 */
@Configuration
@EnableCaching
@Slf4j
public class CaffeineCacheConfig {

    /**
     * CacheManager实现类
     *
     * @return 缓存管理器
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        //缓存集合
        ArrayList<CaffeineCache> caches = new ArrayList<>();

        caches.add(new CaffeineCache("users-cache",
                Caffeine.newBuilder()
                        //缓存最大数量
                        .maximumSize(1000)
                        //设置最后一次访问后过期时间
                        .expireAfterAccess(120, TimeUnit.SECONDS)
                        .build())
        );
        cacheManager.setCaches(caches);
        return cacheManager;
    }
}
