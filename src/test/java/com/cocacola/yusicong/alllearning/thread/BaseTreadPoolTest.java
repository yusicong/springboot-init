package com.cocacola.yusicong.alllearning.thread;

import com.cocacola.yusicong.alllearning.factory.BaseThreadFactory;
import com.cocacola.yusicong.alllearning.handler.BaseRejectHandler;
import com.cocacola.yusicong.alllearning.task.BaseTask;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Create by idea
 *
 * @author yusicong
 * @date 2020/4/2
 * @time 23:20
 */
public class BaseTreadPoolTest {
    public static void main(String[] args) {
        //缓存队列设置为固定长度。方便测试
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(2);

        BaseThreadFactory f1 = new BaseThreadFactory("第一机房");
        BaseThreadFactory f2 = new BaseThreadFactory("第二机房");
        BaseRejectHandler handler = new BaseRejectHandler();
        //核心线程数设置为1 最大线程数设置为2 方便测试
        ThreadPoolExecutor threadPoolFirst = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f1, handler);
        ThreadPoolExecutor threadPoolSecond = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, f2, handler);

        //创建400个任务线程
        BaseTask task = new BaseTask();
        for (int i = 0; i < 400; i++) {
            threadPoolFirst.execute(task);
            threadPoolSecond.execute(task);
        }
    }
}
