package com.ghc.mmall.concurrency.test;

import com.ghc.mmall.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/17 18:58
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Slf4j
@ThreadSafe
public class AtomicBooleanTest {
    private static LongAdder count = new LongAdder();
    private static int clientTotal = 5000;
    private static int threadTotal = 200;
    private static final Logger logger = Logger.getGlobal();
    public static void main(String [] args) throws InterruptedException {
        logger.setLevel(Level.INFO);
        ExecutorService executor = Executors.newCachedThreadPool();
        final Semaphore  semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executor.execute(()->{
               try{
                   semaphore.acquire();
                   incr();
                   semaphore.release();
               } catch(InterruptedException e){

               }
               countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        executor.shutdown();
        logger.info("count: "+count);
    }

    public static void incr(){
        count.increment();
    }

}
