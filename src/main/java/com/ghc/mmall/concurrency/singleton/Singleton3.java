package com.ghc.mmall.concurrency.singleton;

import com.ghc.mmall.concurrency.annotations.Recommend;
import com.ghc.mmall.concurrency.annotations.ThreadSafe;

/**
 *
 */
@ThreadSafe
@Recommend
public class Singleton3 {

    // 使用枚举类确保线程安全
    // 第一步 仍然是私有化构造方法
    private  Singleton3(){}

    // 第二步 提供对外访问的静态公用接口
    public static Singleton3 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    public enum  Singleton{
        INSTANCE;
        private Singleton3 singleton = null;
        Singleton(){
            singleton = new Singleton3();
        }

        public Singleton3 getInstance(){
            return singleton;
        }
    }

}
