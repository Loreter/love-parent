package com.love.common.util;

/**
 * @author 孙振岳
 */
public class GeneratorIdUtils {



    public static String nextId(){
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(0,0);
        return String.valueOf(snowflakeIdWorker.nextId());
    }
}
