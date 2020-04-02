package com.cocacola.yusicong.alllearning.handler;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/2
 * @time 23:18
 */
@Slf4j
public class BaseRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable task, ThreadPoolExecutor executor) {
        log.info("task rejected. " + executor.toString());
    }
}
