package com.love.common.cache;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


/**
 * @author 孙振岳
 */
public interface ICollectionCacheManager {
	/**
	 * 根据key获取list集合
	 * @param key
	 * @return
	 */
	public List<String> lGetCache(Serializable key);
	/**
	 * 返回列表 key 中指定区间内的元素，区间以偏移量 start 和 stop 指定。
	 * 下标(index)参数 start 和 stop 都以 0 开始
	 * 负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<String> lGetCache(Serializable key, long start, long end);
	
	/**
	 * 根据key存入list集合
	 * @param key
	 * @param values
	 * @return
	 */
	public Long lPutCache(Serializable key, List<String> values);
	/**
	 * 修改list集合的下标为index的值为value
	 * @param key
	 * @param start 
	 * @param end 
	 * @return
	 */
	public String lPutCache(Serializable key, long index, String value);
	/**
	 * list集合的size
	 * @param key
	 * @return
	 */
	public Long lSize(Serializable key);
	
	/**
	 * 从队列的右边出队一个元素，如果list为空，则返回nil
	 * @param key
	 * @return
	 */
	public String rpop(Serializable key);
	/**
	 * 从队列的左边出队一个元素，如果list为空，则返回nil
	 * @param key
	 * @return
	 */
	public String lpop(Serializable key);
	
	/**
	 * 保留list集合的下标从start到end的元素
	 * @see Redis LTRIM 命令
	 * @param key
	 * @param start 
	 * @param end 
	 * @return
	 */
	public String lTrim(Serializable key, long start, long end);
	
	/**
	 * 移除list集合值为value的所有元素
	 * @param key
	 * @param start 
	 * @param end 
	 * @return
	 */
	public Long lRemCache(Serializable key, String value);
	/**
	 * 移除list集合值为value的所有元素
	 * @param key
	 * @param start 
	 * @param end 
	 * @return
	 */
	public Long lRemCache(Serializable key, int count ,String value);
	
	/**
	 * 根据key存入Set集合
	 * @param key
	 * @param values
	 * @return
	 */
	public Long sPutCache(Serializable key, Set<String> values);
	
	/**
	 * 返回Set集合的所有元素
	 * @param key
	 * @return
	 */
	public Set<String> sGetCache(Serializable key);
	/**
	 * 移除Set集合中的成员
	 * @param key
	 * @return
	 */
	public Long sRemCache(Serializable key, String... member);
	/**
	 * Set集合中是否存在member
	 * @param key
	 * @return
	 */
	public Boolean sisExists(Serializable key, String member);
	/**
	 * 检查Redis库中是否存在key
	 * @param key
	 * @return
	 */
	public Boolean isExists(Serializable key);
	/**
	 * 检查Redis库中是否存在keys的数据
	 * @param keys
	 * @return
	 */
	public Long isExists(String... keys);
	/**
	 * 删除多个key
	 * @param keys
	 * @return
	 */
	public Long removeCache(String... keys);
	/**
	 * 取出符合 pattern 的数据
	 * @param pattern
	 * @return
	 */
	public Set<String> keys(Serializable pattern);
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
	public Long getExpireTime(Serializable key);
	/**
	 * 使用LUA脚本的方法</br>
	 * @param script 脚本
	 * @param keys Redis中对应的key
	 * @param args map的key
	 * @return Object
	 */
	public Object eval(String script, List<String> keys, List<String> args);

}
