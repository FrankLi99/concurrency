package com.ghc.mmall.concurrency.threadLocal;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/19 14:32
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class RequestHolder {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    public static void remove(){
        requestHolder.remove();
    }
}
