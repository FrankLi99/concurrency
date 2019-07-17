package com.ghc.mmall.concurrency.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ：Frank Li
 * @date ：Created in 2019/7/17 14:23
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "ThreadSafe";
}
