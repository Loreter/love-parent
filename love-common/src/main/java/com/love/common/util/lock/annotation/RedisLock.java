package com.love.common.util.lock.annotation;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * RedisLock
 * @author 孙振岳
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RedisLock {
    /**
     * 业务键
     *
     * @return string
     */
    String key();
    /**
     * 锁的过期秒数,默认是5秒
     *
     * @return int
     */
    int expire() default 5;

    /**
     * 尝试加锁，最多等待时间
     *
     * @return long
     */
    long waitTime() default Long.MIN_VALUE;
    /**
     * 锁的超时时间单位
     *
     * @return TimeUnit
     */
    TimeUnit timeUnit() default TimeUnit.SECONDS;
}
