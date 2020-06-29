package com.love.common.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IHashByteCacheManager {
	/**
	 * 返回哈希表 key 中，所有的域和值
	 * @param key
	 * @return
	 */
	public Map<Object, Object> hByteGetCache(Serializable key);
	/**
	 * 返回哈希表 key 中给定域 field 的值
	 * @param key
	 * @param field
	 * @return 给定域的值, 当给定域不存在或是给定 key 不存在时,返回 null 
	 */
	public Object hByteGetCache(Serializable key, Object field);
	/**
	 * 返回哈希表 key 中，一个或多个给定域的值
	 * 如果给定的域不存在于哈希表，那么返回一个 null 值
	 * 因为不存在的 key 被当作一个空哈希表来处理，所以对一个不存在的 key 进行 hmByteGet 操作将返回一个只带有 null 值的结果
	 * @param key
	 * @param field
	 * @return 一个包含多个给定域的关联值的表，表值的排列顺序和给定域参数的请求顺序一样
	 */
	public List<Object> hmByteGetCache(Serializable key, Object... fields);
	/**
	 * 将哈希表 key 中的域 field 的值设为 value
	 * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作
	 * 如果域 field 已经存在于哈希表中，旧值将被覆盖
	 * @param key
	 * @param field 元素名
	 * @param value 值
	 * @return 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 。如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回 0 。
	 */
	public boolean hBytePutCache(Serializable key, Object field, Object value);
	/**
	 * 同时将多个 field-value (域-值)对设置到哈希表 key 中.
	 * 如果 key 存在，会覆盖哈希表中已存在的域.
	 * 如果 key 不存在，一个空哈希表被创建并执行 HMSET 操作
	 * @param key
	 * @param values
	 * @return 如果命令执行成功,返回 OK, 当 key 不是哈希表(hash)类型时,返回一个错误.
	 */
	public boolean hmBytePutCache(Serializable key, Map<Object, Object> objValue);

	/**
	 * 将哈希表 key 中的域 field 的值设为 value
	 * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作
	 * 如果域 field 已经存在于哈希表中，旧值将被覆盖
	 * @param key
	 * @param field 元素名
	 * @param value 值
	 * @return 如果 field 是哈希表中的一个新建域，并且值设置成功，返回 1 。如果哈希表中域 field 已经存在且旧值已被新值覆盖，返回 0 。
	 */
	
	public boolean hmBytePutCache(Serializable key, Map<Object, Object> objValue,int expiration);
	

	/**
	 * 删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略.
	 * @param key
	 * @param field
	 * @return 被成功移除的域的数量,不包括被忽略的域.
	 */
	public Long hmByteRemoveCache(Serializable key, Object... fields);
	
	
	
}
