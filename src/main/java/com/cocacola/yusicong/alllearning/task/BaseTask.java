package com.cocacola.yusicong.alllearning.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/2
 * @time 23:15
 */
@Slf4j
public class BaseTask implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        log.info("running_" + count.getAndIncrement());
    }
}
