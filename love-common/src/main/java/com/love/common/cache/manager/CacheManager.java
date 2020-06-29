package com.love.common.cache.manager;

import java.util.HashMap;
import java.util.Map;

import com.love.common.cache.ICacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 静态代理类<br>
 * com.icbc.emall.cache.memcached.MemcachedCacheManager<br>
 * com.icbc.emall.cache.Tair.TairCacheManager
 *
 *
 * @author 孙振岳
 */
public class CacheManager  {

	private static final Logger logger = LoggerFactory.getLogger(CacheManager.class);
	
	private static Map<String, ICacheManager> cacheManagers = new HashMap<>();
	
	private static CacheManager cacheManager = new CacheManager();
	
	private String mdbType;
	private static String cacheType;
	
	public String getMdbType() {
		return mdbType;
	}

	public void setMdbType(String mdbType) {
		this.mdbType = mdbType;
	}

	public static String getCacheType() {
		return cacheType;
	}

	public void setCacheType(String cacheType) {
		CacheManager.cacheType = cacheType;
	}	
	
	private CacheManager(){
		logger.info("CacheManager().");
	}
	
	public void init(){
		logger.info("CacheManager start");
		if(CacheManager.getInstance()==null){
			logger.error("CacheManager Must Be Created.");
			throw new IllegalArgumentException("CacheManager Must Be Created.");
		}
		//cacheManagerType 为 系统参数
		if(CacheManager.getInstance(mdbType)==null){
			logger.error("{} Must Be Created.",mdbType);
			throw new IllegalArgumentException(mdbType + " Must Be Created.");
		}
	}
	
	
	public static CacheManager newInstance(){
		return cacheManager;
	}
	
	
	/**
	 * 无参的getInstance，取出的是非持久化的CacheManager的实现类，用作缓存
	 * @return
	 */
	public static ICacheManager getInstance() {
		return getInstance(cacheType);
	}
	/**
	 * 有参的getInstance，取出的是持久化的CacheManager的实现类，用作内存数据库
	 * @return
	 */
	public static ICacheManager getInstance(String providerType) {
		return CacheManager.cacheManagers.get(providerType);
	}
	
	
	public void addInstance(String providerType, ICacheManager cacheManager) {
		CacheManager.cacheManagers.put(providerType, cacheManager);
	}


}