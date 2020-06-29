package com.love.common.cache;


/**
 * 
 * @author zippoy(mashupeye@gmail.com)<br>
 *         2013-8-28 上午10:43:56<br>
 * 	Remark:<br>
 *	
 * 
 */
public enum CachePage {
	/**
	 * 首页
	 */
	INDEX_PAGE,
	/**
	 * 列表页
	 */
	PRODUCT_VIEW_PAGE,
	/**
	 * 详细页
	 */
	PRODUCT_PAGE,
	/**
	 * 商品搜索页
	 */
	SEARCH_PRODUCT_PAGE,
	/**
	 * 商铺搜索页
	 */
	SEARCH_STORE_PAGE,
	/**
	 * 所有页面
	 */
	ALL_PAGE,
	/**
	 * 其他参数,不起作用
	 */
	NOVALUE;


	public static CachePage getCachePage(String s) {
		try {
			return valueOf(s.toUpperCase());
		} catch (Exception ex) {
			return NOVALUE;
		}
	}
}