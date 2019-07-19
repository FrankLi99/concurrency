package com.ghc.mmall.concurrency.test;

import com.ghc.mmall.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/17 16:27
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@ThreadSafe
public class ConcurrencyTest {
    // 请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;
    public static int count = 0;
    private static final Logger logger = Logger.getGlobal();
    private static final Lock lock = new ReentrantLock();

    public static void main(String [] args) throws InterruptedException {
        logger.setLevel(Level.INFO);
        ExecutorService executor = Executors.newCachedThreadPool();
        final Semaphore  semaphore = new Semaphore(threadTotal);
        final CountDownLatch  countDownLatch = new CountDownLatch(clientTotal);
        for(int i=0;i<clientTotal;i++){
            executor.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        logger.info("count after countDownLatch...:"+count);
    }

    public  static void add(){
        if(lock.tryLock()){
//                lock.lock();
            try{
                count++;
            }finally {
                lock.unlock();
            }
            }

//        count++;
    }
}
