package com.love.common.cache;

import java.io.Serializable;

public interface ICounterCacheManager {

	/**
	 * 把键为key的value加1
	 * @param key
	 * @return
	 */
	public Long incr(Serializable key);
	/**
	 * 把键为key的value加integer(可为负数)
	 * @param key
	 * @param integer
	 * @return
	 */
	public Long incr(Serializable key, long integer);
	/**
	 * 把键为key的value加value(可为负数)
	 * @param key
	 * @param value
	 * @return
	 */
	public Double incr(Serializable key, double value);
	
	/**
	 * 当value为负数时能减少field的值
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 */
	public Long hIncr(Serializable key, String field, long value);
	/**
	 * 把键为key的value减1
	 * @param key
	 * @return
	 */
	public Long decr(Serializable key) ;
	/**
	 * 把键为key的value减value(可为负数)
	 * @param key
	 * @param integer
	 * @return
	 */
	public Long decr(Serializable key, long integer);
}
