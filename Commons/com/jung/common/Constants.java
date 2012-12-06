package com.jung.common;



/**
 * 常量定义类.
 * 
 * @version Revision: V1.0 2012-8-22 上午12:25:22
 * @author GuoJun mailto: jackson@highcolu.com
 */
public class Constants {

	/**
	 * 一些常用的常量. ADD BY：Junsheng Ji. ZERO : 0, ONE : 1, TWO : 2, THREE : 3, FOUR
	 * : 4, FIVE : 5, NORMAL:0, INVILID:1
	 */
	public static class Number {

		public static final Integer ZERO = 0;
		public static final Integer ONE = 1;
		public static final Integer TWO = 2;
		public static final Integer THREE = 3;
		public static final Integer FOUR = 4;
		public static final Integer FIVE = 5;

		// add by xie xiumei
		public static final Integer NORMAL = 0;
		public static final Integer INVILID = 1;
	}

	/**
	 * 分页行数大小键值定义常量.
	 */
	public static final String PAGE_SIZE = ".page.size";
	/**
	 * 默认的数据分页行数.
	 */
	public static final Integer DEFAULT_PAGE_SIZE = 10;

	/**
	 * 基本数据类型字符串数据常量定义.
	 */
	public static final String[] BASE_DATA_TYPE = new String[] { "Integer",
			"int", "Long", "long", "Boolean", "bool", "BigDecimal", "String",
			"Date", "Double", "double", "Float", "float" };

	public static class ReturnCode {
		/**
		 * 定义操作成功与否及错误相关信息代码 001 操作成功 002 操作失败 003 用户名重名
		 */
		public static final String OPER_SUCCESS = "001";
		public static final String OPER_FAIL = "002";
		public static final String USER_NAME_SAME = "003";
	}

	public static class WorkFlowConst {
		public static final String PROCESS_DEPLOYEE_NAME_BUY = "workFlowDemo";
	}

	public static class CompetenceConst {
		public static final String FIRST_MENU_LEVEL = "1";
		public static final String SECOND_MENU_LEVEL = "2";
		public static final String THIRD_MENU_LEVEL = "3";
		public static final String FOUR_MENU_LEVEL = "4";
		public static final String MODIFY_YES_INFLUENCE_USER = "yes";
		public static final String MODIFY_NO_INFLUENCE_USER = "no";
	}
	public static class VoteConst{
		public static final String WRITE_NEXT_QUESTION = "yes";
	}


	// 单据状态内部类
	public static class Status {
		public static Integer NEW = 0;// 全新
		public static Integer TEMPSAVE = 1;// 暂存
		public static Integer APPROVE = 2;// 已审核
		public static Integer DISABLE = 3;// 停用
	}


	// 销售类型
	public static class SaleType {
		public static Integer RETAIL = 0;// 零售
		public static Integer WHOLESALE = 1;// 批发
	}

	// 客户类型
	public static class CustomerType {
		public static Integer COMPANY = 0;// 公司
		public static Integer PERSON = 1;// 个人
	}
}

