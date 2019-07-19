package com.ghc.mmall.concurrency.test;

import com.ghc.mmall.concurrency.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/17 18:42
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Slf4j
@ThreadSafe
public class AtomicExample {
    private static final AtomicReference<Integer> atomicReference = new AtomicReference<>();

    // 更新 某个实例的 某个字段 的原子性操作
    private static AtomicIntegerFieldUpdater<AtomicExample> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExample.class,"count");

    // AtomicStampReference  : CAS 的 ABA 问题 ， 会加上版本号
    @Getter
    public volatile int count = 100;

    private static AtomicExample example = new AtomicExample();

    public static void main(String [] args){
        if (updater.compareAndSet(example, 100, 120)){

        }
    }


}
