package com.love.common.constant;

public final class GlobalConstants {

	public final class Switch {
		
		private Switch() {
			throw new IllegalStateException("Switch is final class");
		}
		
		/**
		 * 1-开
		 */
		public static final String YES = "1";

		/**
		 * 0-关
		 */
		public static final String NO = "9";

	}

	/**
	 * @description 
	 * <span> 定义常用的特殊字符 <span>
	 * @author 李志伟
	 * @createTime 2018年4月26日 上午8:56:37
	 */
	public final class SpecialChars extends SeparatorTag {
		/**
		 * 斜线
		 */
		public static final String SLASH = "/";
		/**
		 * 反斜线
		 */
		public static final String BACK_SLASH = "\\";

	}

	/**
	 * 定义系统中常用的分隔符
	 * 
	 * @author wenyf
	 * 
	 */
	public class SeparatorTag {
		
		private SeparatorTag() {
			throw new IllegalStateException("SeparatorTag is Utility class");
		}

		/**
		 * TIP-"^"
		 */
		public static final String TIP = "^";

		/**
		 * UNDERLINE-"_"
		 */
		public static final String UNDERLINE = "_";

		/**
		 * POINT-"."
		 */
		public static final String POINT = ".";

		/**
		 * VERTICALLINE-"|"
		 */
		public static final String VERTICALLINE = "|";

		/**
		 * SIGH-"!"
		 */
		public static final String SIGH = "!";

		/**
		 * AND-"&"
		 */
		public static final String AND = "&";

		/**
		 * EQUAL-"="
		 */
		public static final String EQUAL = "=";

		/**
		 * BR-换行
		 */
		public static final String BR = "<br/>";

		/**
		 * COLON-":"
		 */
		public static final String COLON = ":";

		/**
		 * COMMA-","
		 */
		public static final String COMMA = ",";

		/**
		 * HYPHEN-"-"
		 */
		public static final String HYPHEN = "-";
		/**
		 * 大括号左边
		 */
		public static final String CURLY_BRACES_LEFT = "{";
		/**
		 * 大括号右边
		 */
		public static final String CURLY_BRACES_RIGTH = "}";
	}

	/**
	 * 是否标志名称
	 * 
	 * @author wenyf
	 * 
	 */
	public final class YesOrNo {
		
		private YesOrNo() {
			throw new IllegalStateException("YesOrNo is Final class");
		}
		/**
		 * 1-是
		 */
		public static final String YES = "1";

		/**
		 * 0-否
		 */
		public static final String NO = "0";
	}

	/**
	 * 分页信息
	 * 
	 * @author wenyf
	 * 
	 */
	public final class PageInfo {
		
		private PageInfo() {
			throw new IllegalStateException("PageInfo is Final class");
		}

		/**
		 * 20-每页20条记录
		 */
		public static final String DEFAULTPAGESIZE = "20";
	}

	/**
	 * 编码集
	 * 
	 * @author wenyf
	 * 
	 */
	public final class CodeSet {
		
		private CodeSet() {
			throw new IllegalStateException("CodeSet is Final class");
		}
		
		/**
		 * 本地编码-GBK
		 */
		public static final  String LOCALCODE = "GBK";

		/**
		 * 远程编码-ISO-8859-1
		 */
		public static final  String REMOTECODE = "ISO-8859-1";

		/**
		 * UTF-8编码
		 */
		public static final  String UTFCODE = "UTF-8";
	}

	/**
	 * 操作系统
	 */

	public final class OperatorSystem {
		
		private OperatorSystem() {
			throw new IllegalStateException("OperatorSystem is Final class");
		}
		
		// Unknow
		public static final String OTHER = "00";

		// Windows
		public static final String WINDOWS = "01";

		// android
		public static final String ANDROID = "02";

		// iphone
		public static final String IPHONE = "03";

		// ipad
		public static final String IPAD = "04";

	}

}
