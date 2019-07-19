package com.ghc.mmall.concurrency.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/18 10:30
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class JoinTest {

    public static void main(String [] args){
        Thread work1Thread = new Thread(new Workder());
        work1Thread.setName("work1Thread");
        Thread work2Thread = new Thread(new Workder());
        work2Thread.setName("work2Thread");

        List<Thread> threads = new ArrayList<>();
        threads.add(work1Thread);
        threads.add(work2Thread);
        for(Thread thread:threads){
            thread.start();
        }
        for(Thread thread:threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread work3Thread = new Thread(new Workder());
        work3Thread.setName("work3Thread");
        work3Thread.start();
//        System.out.println(Thread.currentThread().getName()+" ");


    }
}

class Workder implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"--> 开始工作");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName()+"--> 第一阶段完成了");
        }catch(InterruptedException e){

        }

    }
}

class CountDownSlatch{


}
