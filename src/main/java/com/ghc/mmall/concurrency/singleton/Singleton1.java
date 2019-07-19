package com.ghc.mmall.concurrency.singleton;

import com.ghc.mmall.concurrency.annotations.NotRecommend;
import com.ghc.mmall.concurrency.annotations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class Singleton1 {
    // 饿汉式  单例模式
    // 首先 私有构造方法
     private Singleton1(){}

     private  static Singleton1 singleton = new Singleton1();

     public static Singleton1 getInstance(){
         return singleton;
     }

}
