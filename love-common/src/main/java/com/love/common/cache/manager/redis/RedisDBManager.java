package com.love.common.cache.manager.redis;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import com.love.common.cache.ICacheManager;
import com.love.common.constant.GlobalConstants;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;


import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.Protocol;


/**
 * @author 孙振岳
 */
public class RedisDBManager implements ICacheManager {
	protected static final String REDIS_RESULT_OK = "OK";

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private static final String IP_PORT_REGX = "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)[:]\\d{1,5}\\s*$"; 
	private static final String HOST = "localhost"; 
	private static final int PORT = Protocol.DEFAULT_PORT;
	protected JedisCluster jedisCluster;
	private Map<Integer, String > shaCache = new HashMap<>();
	private static final int DEFAULT_MAX_REDIRECTIONS = 5;

	protected static RedisSerializer<Object> redisSerializer = new JdkSerializationRedisSerializer(); 
	
	public RedisDBManager(String managerName) {
		this.managerName = managerName; 
	}
	
	private String managerName;
	
	public void init(String nodes, int maxIdle,int maxTotal, int timeout, int maxWaitMillis, String password, boolean testOnBorrow) {
		logger.info("RedisManager init start");
		if (null == jedisCluster) {
			validAttr(nodes, "redis cluster init failed, nodes is null");
			List<String> jedisClusterNodes = Arrays.asList(nodes.split(GlobalConstants.SeparatorTag.COMMA));
			Set<HostAndPort> jedisClusterNode = parseHostAndPort(jedisClusterNodes);
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxIdle(maxIdle);
			jedisPoolConfig.setMaxTotal(maxTotal);
			jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
			jedisPoolConfig.setTestOnBorrow(testOnBorrow);
			if(StringUtils.isBlank(password)){
				jedisCluster = new JedisCluster(jedisClusterNode, timeout, jedisPoolConfig);
			} else {
				jedisCluster = new JedisCluster(jedisClusterNode, timeout, timeout, DEFAULT_MAX_REDIRECTIONS, password, jedisPoolConfig);
			}
		}
		logger.info("RedisManager init end");
	}
	
	private void validAttr(String attr, String log) {
		if (StringUtils.isBlank(attr)) {
			logger.error(log);
			throw new IllegalArgumentException(log);
		}
	}
	
	private Set<HostAndPort> parseHostAndPort(List<String> serverList) {
		
		Set<HostAndPort> hapSet = new HashSet<>();
		if (CollectionUtils.isNotEmpty(serverList)) {
			for (int i = 0; i < serverList.size(); i++) {
				String val = serverList.get(i);
				boolean isIpPort = Pattern.compile(IP_PORT_REGX).matcher(val).matches();
				
				if (!isIpPort) {
					throw new IllegalArgumentException("ip 或者 port 不合法");
				} 
				String[] hostAndPort = val.split(GlobalConstants.SeparatorTag.COLON);
				
				HostAndPort hap = new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1]));
				
				hapSet.add(hap);
			}
		} else {
			HostAndPort hap = new HostAndPort(HOST, PORT);
			hapSet.add(hap);
		}
		return hapSet;
	}
	
	@Override
	public String getManagerName() {
		return managerName;
	}
	
	
	@Override
	public Object getCache(Serializable cacheKey) {
		if (logger.isInfoEnabled()) {
			logger.info("key is {}", cacheKey);
		}
		return jedisCluster.get(String.valueOf(cacheKey));
	}
	

	@Override
	public Map<Serializable, Object> mGetCache(List<Serializable> keys) {
		Map<Serializable, Object> map = new HashMap<>();
		for (Serializable cacheKey : keys) {
			String key = String.valueOf(cacheKey);
			// key
			if (logger.isInfoEnabled()) {
				logger.info("key is {}", key);
			}
			Object value = null;
			// value的类型
			String type = jedisCluster.type(key);
			if ("string".equalsIgnoreCase(type)) {
				value = jedisCluster.get(key);
			}
			if ("list".equalsIgnoreCase(type)) {
				value = jedisCluster.lrange(key, 0, -1);
			}
			if ("set".equalsIgnoreCase(type)) {
				value = jedisCluster.smembers(key);
			}
			if ("hash".equalsIgnoreCase(type)) {
				value = jedisCluster.hgetAll(key);
			}
			map.put(cacheKey, value);
		}
		return map;
	}
	
	@SuppressWarnings("unchecked")
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
		logger.debug("The putCache key is {}, value is {}", cacheKey , objValue);
		if (!(objValue instanceof String)){
			throw new IllegalArgumentException("objValue type must be String");
		}
		String rs = jedisCluster.set(String.valueOf(cacheKey), String.valueOf(objValue));
		logger.debug("The putCache result is {}", rs);
		return StringUtils.equalsIgnoreCase(REDIS_RESULT_OK, rs);
	}


	@Override
	public boolean putCache(Serializable cacheKey, Object objValue, int expiration) {
		if (!(objValue instanceof String)){
			throw new IllegalArgumentException("objValue type must be String");
		}
		String rs = jedisCluster.setex(String.valueOf(cacheKey), expiration, String.valueOf(objValue));
		logger.debug("The putCache key is {}, value is {}, expiration is {}, the putCache result is {}", cacheKey , objValue, expiration, rs);
		return StringUtils.equalsIgnoreCase(REDIS_RESULT_OK, rs);
	}


	@Override
	public void removeCache(Serializable cacheKey) {
		logger.debug("The removeCache key is {}", cacheKey);
		jedisCluster.del(String.valueOf(cacheKey));
	}


	@Override
	public void destroy() {
		if (jedisCluster != null) {
			jedisCluster.close();
		}
		jedisCluster = null;
	}


	@Override
	public Integer incr(Serializable key, int value) {
		return this.incr(key, value, 0);
	}

	@Override
	public Integer incr(Serializable key, int value, int expiration) {
		int result = jedisCluster.incrBy(String.valueOf(key), value).intValue();
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
		int result = jedisCluster.decrBy(String.valueOf(key), value).intValue();
		if(expiration > 0){
			this.expire(key, expiration);
		}
		logger.debug("The decr key is {}, value is {}, expiration is {}, the decr result is {}", key , value, expiration, result);
		return result;
	}

	/*************************************** counter *******************************************/

	@Override
	public Long incr(Serializable key) {
		return jedisCluster.incr(String.valueOf(key));
	}

	@Override
	public Long incr(Serializable key, long integer) {
		return jedisCluster.incrBy(String.valueOf(key), integer);
	}

	@Override
	public Double incr(Serializable key, double value) {
		return jedisCluster.incrByFloat(String.valueOf(key), value);
	}

	@Override
	public Long hIncr(Serializable key, String field, long value) {
		return jedisCluster.hincrBy(String.valueOf(key), field, value);
	}

	@Override
	public Long decr(Serializable key) {
		Long rs = jedisCluster.decr(String.valueOf(key));
		if (logger.isInfoEnabled()) {
			logger.info("key is {}, the decr result is {}", key, rs);
		}
		return rs;
	}

	@Override
	public Long decr(Serializable key, long integer) {
		Long rs = jedisCluster.decrBy(String.valueOf(key), integer);
		if (logger.isInfoEnabled()) {
			logger.info("key is {}, decr value is {}, the decr result is {}", key, integer, rs);
		}
		return rs;
	}
	/*************************************** Collection ******************************************/

	@Override
	public List<String> lGetCache(Serializable key) {
		return lGetCache(key, 0, -1);
	}

	@Override
	public List<String> lGetCache(Serializable key, long start, long end) {
		if (logger.isInfoEnabled()) {
			logger.info("The lGetCache key is {}, start {} end {}", key, start, end);
		}
		return jedisCluster.lrange(String.valueOf(key), start, end);
	}

	@Override
	public Long lPutCache(Serializable key, List<String> values) {
		if (logger.isInfoEnabled()) {
			logger.info("The lPutCache key is {}", key); 
		}
		return jedisCluster.rpush(String.valueOf(key), values.toArray(new String[values.size()]));
	}

	@Override
	public String lPutCache(Serializable key, long index, String value) {
		if (logger.isInfoEnabled()) {
			logger.info("The lPutCache key is {}, index is {} , value is {}", key, index, value);
		}
		return jedisCluster.lset(String.valueOf(key), index, value);
	}

	@Override
	public Long lSize(Serializable key) {
		if (logger.isInfoEnabled()) {
			logger.info("The lSize key is {}", key);
		}
		return jedisCluster.llen(String.valueOf(key));
	}

	@Override
	public String rpop(Serializable key) {
		if (logger.isInfoEnabled()) {
			logger.info("The lSize key is {}", key);
		}
		return jedisCluster.rpop(String.valueOf(key));
	}

	@Override
	public String lpop(Serializable key) {
		if (logger.isInfoEnabled()) {
			logger.info("The lSize key is {}", key);
		}
		return jedisCluster.lpop(String.valueOf(key));
	}
	
	@Override
	public String lTrim(Serializable key, long start, long end) {
		if (logger.isInfoEnabled()) {
			logger.info("The lTrim key is {}, start {} end {}", key, start, end);
		}
		return jedisCluster.ltrim(String.valueOf(key), start, end);
	}

	@Override
	public Long lRemCache(Serializable key, String value) {
		return lRemCache(key, 0, value);
	}

	@Override
	public Long lRemCache(Serializable key, int count, String value) {
		if (logger.isInfoEnabled()) {
			logger.info("key is {}, count {}, value is {}", key, count, value);
		}
		return jedisCluster.lrem(String.valueOf(key), count, value);
	}

	@Override
	public Long sPutCache(Serializable key, Set<String> values) {
		return jedisCluster.sadd(String.valueOf(key), values.toArray(new String[values.size()]));
	}

	@Override
	public Set<String> sGetCache(Serializable key) {
		return jedisCluster.smembers(String.valueOf(key));
	}

	@Override
	public Long sRemCache(Serializable key, String... member) {
		return jedisCluster.srem(String.valueOf(key), member);
	}

	@Override
	public Boolean sisExists(Serializable key, String member) {
		return jedisCluster.sismember(String.valueOf(key), member);
	}
	
	@Override
	public Boolean isExists(Serializable key){
		return jedisCluster.exists(String.valueOf(key));
	}
	
	@Override
	public Long isExists(String... keys){
		return jedisCluster.exists(keys);
	}

	@Override
	public Long removeCache(String... keys){
		return jedisCluster.del(keys);
	}
	
	/*************************************** Hash ******************************************/

	@Override
	public Map<String, String> hGetCache(Serializable key) {
		if(logger.isInfoEnabled()){
			logger.info("The hGetCache key is {}", key);
		}
		return jedisCluster.hgetAll(String.valueOf(key));
	}

	@Override
	public String hGetCache(Serializable key, String field) {
		if (logger.isInfoEnabled()) {
			logger.info("The hGetCache key is {}, field is {}", key, field);		
		}
		return jedisCluster.hget(String.valueOf(key), field);
	}

	@Override
	public List<String> hmGetCache(Serializable key, String... fields) {
		if (logger.isInfoEnabled()) {
			logger.info("The hmGetCache key is {}, fields is {}", key, fields);
		}
		return jedisCluster.hmget(String.valueOf(key), fields);
	}

	@Override
	public Long hPutCache(Serializable key, String field, String value) {
		if (logger.isInfoEnabled()) {
			logger.info("The hPutCache key is {}, field is {}, value is {}", key, field, value);
		}
		return jedisCluster.hset(String.valueOf(key), field, value);
	}

	@Override
	public String hmPutCache(Serializable key, Map<String, String> values) {
		if (logger.isInfoEnabled()) {
			logger.info("The hmPutCache key is {}", key);
		}
		return jedisCluster.hmset(String.valueOf(key), values);
	}

	@Override
	public Long hRemoveCache(Serializable key, String... fields) {
		if (logger.isInfoEnabled()) {
			logger.info("The hRemoveCache key is {}, fields is {}", key, fields);
		}
		return jedisCluster.hdel(String.valueOf(key), fields);
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
		return jedisCluster.ttl(String.valueOf(key));
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
		int hashCode = script.hashCode();
		String sha = shaCache.get(hashCode);
		final String shas = sha;
		Object result = null;
		String key = "";
		if (CollectionUtils.isNotEmpty(keys) && keys.size() == 1){
			key = keys.get(0);
		}else {
			throw new IllegalArgumentException("[RedisClusterCacheManager:eval] 参数 keys不能为null或Empty或长度不为1");
		}
		if (StringUtils.isNotBlank(shas)){
			boolean flag = jedisCluster.scriptExists(shas, key);
			if (flag){
				result = jedisCluster.evalsha(shas, keys, args);
			} else {
				sha = jedisCluster.scriptLoad(script, key);
				result = jedisCluster.eval(script, keys, args);
				shaCache.put(hashCode, sha);
			}
		} else {
			sha = jedisCluster.scriptLoad(script, key);
			result = jedisCluster.eval(script, keys, args);
			shaCache.put(hashCode, sha);
		}
		return result;
	}

	@Override
	public Long setnx(Serializable key, String value){
		return jedisCluster.setnx(String.valueOf(key), value);
	}
	

	@Override
	public Long expire(Serializable key, int expiration) {
		return jedisCluster.expire(String.valueOf(key), expiration);
	}

	
	/*************************************** 暂不支持的接口 ******************************************/
	
	@Override
	public Map<Object, Object> hByteGetCache(Serializable key) {
		logger.error("暂不支持该接口-----hByteGetCache");
		throw new UnsupportedOperationException();
	}

	@Override
	public Object hByteGetCache(Serializable key, Object field) {
		logger.error("暂不支持该接口-----hByteGetCache");
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Object> hmByteGetCache(Serializable key, Object... fields) {
		logger.error("暂不支持该接口-----hmByteGetCache");
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hBytePutCache(Serializable key, Object field, Object value) {
		logger.error("暂不支持该接口-----hBytePutCache");
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hmBytePutCache(Serializable key, Map<Object, Object> objValue) {
		logger.error("暂不支持该接口-----hmBytePutCache");
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hmBytePutCache(Serializable key, Map<Object, Object> objValue, int expiration) {
		logger.error("暂不支持该接口-----hmBytePutCache");
		throw new UnsupportedOperationException();
	}

	@Override
	public Long hmByteRemoveCache(Serializable key, Object... fields) {
		logger.error("暂不支持该接口-----hmByteRemoveCache");
		throw new UnsupportedOperationException();
	}
	
	/*************************************** 发布订阅的接口 ******************************************/
	@Override
	public Long publish(String channel, String message) {
		return jedisCluster.publish(channel, message);
	}
	@Override
	public void subscribe(JedisPubSub jedisPubSub, String channel) {
		jedisCluster.subscribe(jedisPubSub, channel);
	}
}
