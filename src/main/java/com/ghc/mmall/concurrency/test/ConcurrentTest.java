package com.ghc.mmall.concurrency.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/17 17:34
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Slf4j
public class ConcurrentTest {
    private static final Logger logger = Logger.getGlobal();
    private static final int base= (int)Math.pow(10,3);
    public static int clientTotal = 5*base;
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger(0);
    private static LongAdder countLong = new LongAdder();

    public static void main(String [] args) throws InterruptedException {
        logger.setLevel(Level.INFO);
        ExecutorService executor = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal); // 一次并发 200 个线程
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal); // 使用 倒计时器 闭锁

        for(int i=0;i<clientTotal;i++){
            // 每次循环添加一个新线程 到 线程池中

            //  使用 java 8 的 lambda  表达式
            executor.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            });
//            countDownLatch.countDown(); // 每 一个线程 添加完成 则 计数减一
        }
//        countDownLatch.await();
        logger.info("count after count down latch..."+count);
    }


    public static void add(){
        count.incrementAndGet();
    }

}
