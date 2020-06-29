package com.love.common.cache.manager.redis;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.love.common.cache.ICacheManager;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;


import redis.clients.jedis.JedisPubSub;

/**
 *
 * @author 孙振岳
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class RedisCacheManager implements ICacheManager {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	private String managerName;
	
	public RedisCacheManager(String managerName) {
		this.managerName = managerName; 
	}
	
	
	@Override
	public String getManagerName() {
		return managerName;
	}
	
	@Override
	public Object getCache(Serializable cacheKey) {
		logger.debug("[RedisCache]-The getCache key is {}", cacheKey);
		Object result = redisTemplate.opsForValue().get(cacheKey);

		//clusterKeySlot
		logger.debug("[RedisCache]-The getCache result is {}", result);
		return result;
	}
	
	@Override
	public Map<Serializable, Object> mGetCache(List<Serializable> keys) {
		Map<Serializable, Object> map = new HashMap<>();
		for (Serializable key : keys) {
			// key
			logger.debug("[RedisCache]-The mGetCache key is {}", key);
			Object value = null;
			DataType type = redisTemplate.type(key);
			switch (type){
				case NONE:
					break;
				case STRING:
					value = this.getCache(key);
					map.put(key, value);
					break;
				case LIST:
					value = this.lGetCache(key);
					map.put(key, value);
					break;
				case SET:
					value = this.sGetCache(key);
					map.put(key, value);
					break;
				case HASH:
					value = this.hGetCache(key);
					map.put(key, value);
					break;
			default:
				break;
			}
		}
		return map;
	}
	
	@Override
	public void mPutCache(Map<Serializable, Object> objects) {
		if(MapUtils.isEmpty(objects)){
			throw new IllegalArgumentException("params is null");
		}
		logger.info("The mPutCache objects size is {}", objects.size());
		for (Entry<Serializable, Object> entry : objects.entrySet()) {
			Object value = entry.getValue();
			try {
				if (value instanceof List) {
					List<String> values = (List<String>)value;
					this.lPutCache(entry.getKey(), values);
				} else if (value instanceof Set) {
					Set<String> values = (Set<String>)value;
					this.sPutCache(entry.getKey(), values);
				} else if (value instanceof Map) {
					Map<String, String> values = (Map<String, String>)value;
					this.hmPutCache(entry.getKey(), values);
				} else {
					this.putCache(entry.getKey(), value);
				}
			} catch (ClassCastException e) {
				if (logger.isErrorEnabled()) {
					logger.error("The mPutCache error, the key is {}", entry.getKey(), e);
				}
			}
		}
	}
	
	@Override
	public boolean putCache(Serializable cacheKey, Object objValue) {
		logger.debug("[RedisCache]-The putCache key is {}", cacheKey);
		redisTemplate.opsForValue().set(String.valueOf(cacheKey), objValue, 600, TimeUnit.SECONDS);
		return true;
	}
	
	
	@Override
	public boolean putCache(Serializable cacheKey, Object objValue, int expiration) {
		if(expiration <= 0){
			redisTemplate.opsForValue().set(String.valueOf(cacheKey), objValue);
		}else{
			redisTemplate.opsForValue().set(String.valueOf(cacheKey), objValue, expiration, TimeUnit.SECONDS);
		}
		logger.debug("[RedisCache]-The putCache key is {}, expiration is {}, objValue is {}",cacheKey, expiration, objValue);
		return true;
	}

	
	@Override
	public void removeCache(Serializable cacheKey) {
		logger.debug("[RedisCache]-The removeCache key is {}", cacheKey);
		redisTemplate.delete(String.valueOf(cacheKey));
	}
	
	
	@Override
	public void destroy() {
		logger.error("暂不支持该接口-----destroy");
		throw new UnsupportedOperationException();
	}
	
	@Override
	public Integer incr(Serializable key, int value) {
		return this.incr(key, value, 0);
	}

	@Override
	public Integer incr(Serializable key, int value, int expiration) {
		int result = redisTemplate.opsForValue().increment(String.valueOf(key), value).intValue();
		if(expiration > 0){
			this.expire(key, expiration);
		}
		logger.debug("The incr key is {}, value is {}, expiration is {}, the incr result is {}", key , value, expiration, result);
		return result;
	}
	
	
	@Override
	public Integer decr(Serializable key, int value) {
		return this.decr(key, value, 0);
	}

	@Override
	public Integer decr(Serializable key, int value, int expiration) {
		int result = redisTemplate.opsForValue().increment(String.valueOf(key), -value).intValue();
		if(expiration > 0){
			this.expire(key, expiration);
		}
		logger.debug("The decr key is {}, value is {}, expiration is {}, the decr result is {}", key , value, expiration, result);
		return result;
		
	}
	
	/*************************************** counter *******************************************/

	@Override
	public Long incr(Serializable key) {
		return redisTemplate.opsForValue().increment(String.valueOf(key), 1);
	}

	@Override
	public Long incr(Serializable key, long integer) {
		return redisTemplate.opsForValue().increment(String.valueOf(key), integer);
	}

	@Override
	public Double incr(Serializable key, double value) {
		return redisTemplate.opsForValue().increment(String.valueOf(key), value);
	}

	@Override
	public Long hIncr(Serializable key, String field, long value) {
		return redisTemplate.opsForHash().increment(String.valueOf(key), field, value);
	}

	@Override
	public Long decr(Serializable key) {
		return redisTemplate.opsForValue().increment(String.valueOf(key), -1);
	}

	@Override
	public Long decr(Serializable key, long integer) {
		return redisTemplate.opsForValue().increment(String.valueOf(key), -integer);
	}
	
	/*************************************** Collection ******************************************/

	@Override
	public List<String> lGetCache(Serializable key) {
		return lGetCache(key, 0, -1);
	}

	@Override
	public List<String> lGetCache(Serializable key, long start, long end) {
		logger.debug("[RedisCache]-The lGetCache key is {}, start {} end {}", key, start, end);
		return redisTemplate.opsForList().range(String.valueOf(key), start, end);
	}

	@Override
	public Long lPutCache(Serializable key, List<String> values) {
		logger.debug("[RedisCache]-The lPutCache key is {}, values is {}", key, values);
		return redisTemplate.opsForList().rightPushAll(key, values);
	}

	@Override
	public String lPutCache(Serializable key, long index, String value) {
		logger.debug("The lPutCache key is {}, index is {} , value is {}", key, index, value);
		redisTemplate.opsForList().set(key, index, value);
		return "OK";
	}

	@Override
	public Long lSize(Serializable key) {
		logger.debug("The lSize key is {}", key);
		return redisTemplate.opsForList().size(key);
	}

	@Override
	public String rpop(Serializable key) {
		logger.debug("The lSize key is {}", key);
		return (String) redisTemplate.opsForList().rightPop(key);
	}


	@Override
	public String lpop(Serializable key) {
		logger.debug("The lSize key is {}", key);
		return (String) redisTemplate.opsForList().leftPop(key);
	}
	
	@Override
	public String lTrim(Serializable key, long start, long end) {
		logger.debug("The lTrim key is {}, start {} end {}", key, start, end);
		redisTemplate.opsForList().trim(key, start, end);
		return "OK";
	}
	
	@Override
	public Long lRemCache(Serializable key, String value) {
		return lRemCache(key, 0, value);
	}

	@Override
	public Long lRemCache(Serializable key, int count, String value) {
		logger.debug("key is {}, count {}, value is {}", key, count, value);
		return redisTemplate.opsForList().remove(key, count, value);
	}

	@Override
	public Long sPutCache(Serializable key, Set<String> values) {
		return redisTemplate.opsForSet().add(key, values.toArray(new Object[values.size()]));
	}
	
	@Override
	public Set<String> sGetCache(Serializable key) {
		return redisTemplate.opsForSet().members(key);
	}

	@Override
	public Long sRemCache(Serializable key, String... member) {
		return redisTemplate.opsForSet().remove(key, Arrays.asList(member).toArray(new Object[member.length]));
	}

	@Override
	public Boolean sisExists(Serializable key, String member) {
		return redisTemplate.opsForSet().isMember(key, member);
	}
	
	@Override
	public Boolean isExists(Serializable key){
		return redisTemplate.hasKey(key);
	}
	
	@Override
	public Long isExists(String... keys){
		Boolean result = redisTemplate.hasKey(keys);
		if(result){
			return 1L;
		}
		return 0L;
	}

	@Override
	public Long removeCache(String... keys){
		redisTemplate.delete(keys);
		return Long.valueOf(keys.length);
	}
	
	/*************************************** Hash ******************************************/

	@Override
	public Map<String, String> hGetCache(Serializable key) {
		logger.debug("The hGetCache key is {}", key);
		return redisTemplate.opsForHash().entries(key);
	}

	@Override
	public String hGetCache(Serializable key, String field) {
		logger.debug("The hGetCache key is {}, field is {}", key, field);
		return (String) redisTemplate.opsForHash().get(key, field);
	}

	@Override
	public List<String> hmGetCache(Serializable key, String... fields) {
		logger.debug("The hmGetCache key is {}, fields is {}", key, fields);
		return redisTemplate.opsForHash().multiGet(key, Arrays.asList(fields));
	}
	
	@Override
	public Long hPutCache(Serializable key, String field, String value) {
		logger.debug("The hPutCache key is {}, field is {}, value is {}", key, field, value);
		redisTemplate.opsForHash().put(key, field, value);
		return 1L;
	}

	@Override
	public String hmPutCache(Serializable key, Map<String, String> values) {
		logger.debug("The hmPutCache key is {}", key);
		redisTemplate.opsForHash().putAll(key, values);
		return "OK";
	}

	@Override
	public Long hRemoveCache(Serializable key, String... fields) {
		logger.debug("The hRemoveCache key is {}, fields is {}", key, fields);
		return redisTemplate.opsForHash().delete(key, Arrays.asList(fields).toArray(new Object[fields.length]));
	}
	/*************************************** keys ******************************************/
	
	@Override
	public Set<String> keys(Serializable pattern) {
		logger.error("暂不支持该接口-----keys");
		throw new UnsupportedOperationException();
	}
	

	/*************************************** properties ******************************************/
	
	/**
	 * 以秒为单位，返回给定 key 的剩余生存时间</br>
	 * <p>
	 * 当 key 不存在时, 返回 -2</br>
	 * 当 key 存在但没有设置剩余生存时间时，返回 -1</br>
	 * 否则，以秒为单位，返回 key 的剩余生存时间</br>
	 * </p>
	 * @param key
	 * @return Long
	 */
	@Override
	public Long getExpireTime(Serializable key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}

	
	/**
	 * 使用LUA脚本的方法</br>
	 * @param script 脚本
	 * @param keys key
	 * @param args map的key
	 * @return Object
	 */
	@Override
	public Object eval(String script, List<String> keys, List<String> args) {
		logger.error("暂不支持该接口-----eval");
		throw new UnsupportedOperationException();
	}

	@Override
	public Long setnx(Serializable key, String value){
		Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value);
		if(result){
			return 1L;
		}
		return 0L;
	}
	

	@Override
	public Long expire(Serializable key, int expiration) {
		redisTemplate.expire(key, expiration, TimeUnit.SECONDS);
		return Long.valueOf(expiration);
	}

	
	/***************************************  ******************************************/
	
	@Override
	public Map<Object, Object> hByteGetCache(Serializable key) {
		logger.debug("The hByteGetCache key is {}", key);
		return redisTemplate.opsForHash().entries(key);
	}

	@Override
	public Object hByteGetCache(Serializable key, Object field) {
		logger.debug("The hByteGetCache key is {}, field is {}", key, field);
		return redisTemplate.opsForHash().get(key, field);
	}

	@Override
	public List<Object> hmByteGetCache(Serializable key, Object... fields) {
		logger.debug("The hmByteGetCache key is {}, fields is {}", key, fields);
		return redisTemplate.opsForHash().multiGet(key, Arrays.asList(fields));
	}

	@Override
	public boolean hBytePutCache(Serializable key, Object field, Object value) {
		logger.debug("The hBytePutCache key is {}, field is {}, value is {}", key, field, value);
		redisTemplate.opsForHash().put(key, field, value);
		return true;
	}

	@Override
	public boolean hmBytePutCache(Serializable key, Map<Object, Object> objValue) {
		return hmBytePutCache(key,objValue,0);
		
	}

	@Override
	public boolean hmBytePutCache(Serializable key, Map<Object, Object> objValue, int expiration) {
		logger.debug("The hmBytePutCache key is {}", key);
		redisTemplate.opsForHash().putAll(key, objValue);
		if(expiration > 0) {
			this.expire(key, expiration);
		}
		return true;
	}

	@Override
	public Long hmByteRemoveCache(Serializable key, Object... fields) {
		return redisTemplate.opsForHash().delete(key, fields);
	}


	@Override
	public Long publish(String channel, String message) {
		logger.error("暂不支持该接口-----publish");
		throw new UnsupportedOperationException();
	}


	@Override
	public void subscribe(JedisPubSub jedisPubSub, String channel) {
		logger.error("暂不支持该接口-----subscribe");
		throw new UnsupportedOperationException();
	}

}
