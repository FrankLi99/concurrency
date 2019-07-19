package com.ghc.mmall.concurrency.singleton;

import com.ghc.mmall.concurrency.annotations.NotRecommend;
import com.ghc.mmall.concurrency.annotations.ThreadSafe;


@ThreadSafe
@NotRecommend
public class Singleton2 {
    // 懒汉式 单例模式
    // 第一步同样是需要私有化构造方法
    private Singleton2(){}

    // 1  memory= allocate()  分配对象的内存空间
    // 2  ctorInstance() 初始化对象
    // 3  instance = memory 设置 instance 指向刚分配的内存
    // 第二步 延迟给变量赋值 volatile 确保 JVM CPU 优化指令重排序不会影响线程安全
    private static volatile Singleton2 singleton = null;
    // volatile + 双重检测机制 --》 禁止对象指令重排

    // 静态工厂方法
    public static Singleton2 getInstance(){
        if(singleton==null){
            synchronized (Singleton2.class){
                // 双重同步锁 确保线程安全第一点
                if(singleton==null){
                    singleton = new Singleton2();
                }
            }
        }
        return singleton;
    }

}
