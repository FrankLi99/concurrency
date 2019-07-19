package com.ghc.mmall.concurrency.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/18 11:30
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class CountDownSlatchTest {
    private static final CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String [] args){
        Thread worker1 = new Thread(new Worker(countDownLatch),"worker1");
        Thread worker2 = new Thread(new Worker(countDownLatch), "worker2");
        Thread worker3 = new Thread(new Worker(countDownLatch), "worker3");
        List<Thread> threads = new ArrayList<>(3);
        threads.add(worker1);
        threads.add(worker2);
        threads.add(worker3);
        for(Thread thread:threads){
            thread.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class Worker implements Runnable{
    private CountDownLatch countDownLatch;

    Worker(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+"--> 开始第一阶段任务...");
        try{
            Thread.sleep(2000);
            countDownLatch.countDown();
            System.out.println(Thread.currentThread().getName()+"--> 结束第一阶段任务...");
        }catch (InterruptedException e){

        }

        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName()+"--> 开始第二阶段任务...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"--> 结束第二阶段任务...");
    }

}
