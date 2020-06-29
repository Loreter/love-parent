package com.love.common.cache;

/**
 * 
 * @author zippoy(mashupeye@gmail.com)<br>
 *         2013-8-28 上午10:44:48<br>
 * 	Remark:<br>
 *		
 * 
 */
public enum FlushCache {
	/**
	 * 刷新当前链接的缓存
	 */
	THIS_LINK_INCLUDE_PARAM,
	/**
	 * 刷新当前页面缓存,如所有商品列表页
	 */
	THIS_TYPE_PAGE,
	/**
	 * 刷新所有缓存
	 */
	ALL_PAGE_NO_USE,
	/**
	 * 后台显示缓存统计信息
	 */
	INFO,
	/**
	 * 其他参数,不起作用
	 */
	NOVALUE;

	public static FlushCache getFlushCache(String s) {
		try {
			return valueOf(s.toUpperCase());
		} catch (Exception ex) {
			return NOVALUE;
		}
	}
}
