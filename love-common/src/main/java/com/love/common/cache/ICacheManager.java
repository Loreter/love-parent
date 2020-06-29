package com.love.common.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.JedisPubSub;

/**
 *
 * @author zippoy(mashupeye@gmail.com)<br>
 *         2013-8-7 上午10:44:36<br>
 * 	Remark:<br>
 *
 *
 */
public interface ICacheManager extends ICollectionCacheManager , ICounterCacheManager , IHashCacheManager , IHashByteCacheManager{
	
	/**
	 * CacheManager的名字
	 * @return
	 */
	public String getManagerName();

	/**
	 * 使用cacheKey取得value
	 * 
	 * @param cacheKey
	 * @return
	 */
	public Object getCache(Serializable cacheKey);
	
	/**
	 * 使用一组key获取一个Map类型的结果，map的key就是那个List key
	 * 
	 * @param keys
	 * @return
	 */
	public Map<Serializable,Object> mGetCache(List<Serializable> keys);
	
	/**
	 * 放入缓存，使用系统级别的失效时间和版本号
	 * 
	 * @param cacheKey
	 * @param objValue
	 * @return
	 */
	public boolean putCache(Serializable cacheKey, Object objValue);
	
	/**
	 * 放入缓存，使用入参的失效时间和系统级别的版本号
	 * 
	 * @param cacheKey
	 * @param objValue
	 * @param expiration
	 * @return
	 */
	public boolean putCache(Serializable cacheKey, Object objValue, int expiration);
	
	
	/**
	 * 以Map的key为key保存Map集合的数据
	 * @param objects
	 */
	public void mPutCache(Map<Serializable, Object> objects);
	
	  
	/**
	 * 移除某一个key
	 * 
	 * @param cacheKey
	 */
	public void removeCache(Serializable cacheKey);
	

	public void destroy();

	/**
	 * 计数器，将key对应的数值加value，
	 * 
	 * @param key
	 * @param value 要对key对应的值加的数
	 * @return
	 */
	public Integer incr(Serializable key, int value);
	

	/**
	 * 计数器，将key对应的数值加value,并增加超时时间
	 * 
	 * @param key
	 * @param value 要对key对应的值加的数
	 * @param expiration 过期时间
	 * @return
	 */
	public Integer incr(Serializable key, int value, int expiration);
	

	/**
	 * 计数器，将key对应的数值减value
	 *
	 * @param key
	 * @param value 要对key对应的值减的数
	 * @return
	 */
	public Integer decr(Serializable key, int value);
	

	/**
	 * 计数器，将key对应的数值减value,并增加超时时间
	 * 
	 * @param key
	 * @param value 要对key对应的值减的数
	 * @param expiration 过期时间
	 * @return
	 */
	public Integer decr(Serializable key, int value, int expiration);

	/**
	 * 给key设置超时时间
	 * @param key
	 * @param expiration
	 * @return
	 */
	public Long expire(Serializable key, int expiration);
	
	/**
	 * 将key的值设为value,当且仅当key不存在。若给定的key已经存在，则不作任何操作,返回0表示已经存在，返回1表示放入成功
	 * @param key
	 * @param value
	 * @return
	 */
	Long setnx(Serializable key, String value);

	Long publish(String channel, String message);

	void subscribe(JedisPubSub jedisPubSub, String channel);
	
}