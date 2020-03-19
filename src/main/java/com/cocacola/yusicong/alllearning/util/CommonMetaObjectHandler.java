package com.cocacola.yusicong.alllearning.util;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Create by idea
 * 公共元数据处理器
 *
 * @author yusicong
 * @date 2020/3/19
 * @time 21:37
 */
@Slf4j
@Component
public class CommonMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("首次插入");
        this.strictInsertFill(metaObject, "created", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "modified", LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, "creator", String.class, "todo 创建人");
        this.strictInsertFill(metaObject, "operator", String.class, "todo 创建人");
        this.strictInsertFill(metaObject, "status", Integer.class, 0);
        this.strictInsertFill(metaObject, "version", Long.class, 1L);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "modified", LocalDateTime.class, LocalDateTime.now());
        this.strictUpdateFill(metaObject, "operator", String.class, "todo 更新人");

    }
}
