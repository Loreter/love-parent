package com.love.common.cache.constants;

public final class CacheConstants {
	
	private CacheConstants() {
	    throw new IllegalStateException("Utility class");
	}
	
	/**
	 * 分布式锁的前缀
	 */
	public static final String LOCK_PREFIX = "lock:";
	
	/**
	 * 
	 * @author kfzx-donghao01
	 * 基于redis或nos的锁机制，返回1表示加锁成功，返回0表示加锁失败
	 */
	public static final String SCRIPT_LOCK =
			"if (redis.call('SETNX',KEYS[1],ARGV[1]) == 1) then "+
				"redis.call('EXPIRE',KEYS[1],ARGV[2]);"+
					"return 1;"+
					"end;"+
					"return 0;";
}
