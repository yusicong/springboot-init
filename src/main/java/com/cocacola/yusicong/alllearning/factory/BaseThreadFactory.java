package com.cocacola.yusicong.alllearning.factory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/2
 * @time 22:50
 */
@Slf4j
public class BaseThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    /**
     * 定义线程池的名称 方便jstack排查线程问题
     *
     * @param whatFeatureOfGroup 线程成分组
     */
    public BaseThreadFactory(String whatFeatureOfGroup) {
        this.namePrefix = "BaseThreadFactory" + whatFeatureOfGroup + "-Worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        //stackSize默认值0 JVM会忽略掉这个参数  尽量不要修改此参数， 作用和范围取决于平台，在不同的JVM上使用此参数，跨平台迁移时，如果以前已设定了对应值，需要检查是否需要修改这个参数。
        Thread thread = new Thread(null, task, name, 0);
        log.info(thread.getName());
        return thread;
    }
}
