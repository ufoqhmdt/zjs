package com.jung.common;

import com.hp.util.PageContext;

/**
 *  @Description: TODO
 *  @version Revision: V1.0 2012-10-15 下午3:33:04
 *  @author GuoJun mailto: jackson@highcolu.com
 */
public class PageContextNew extends PageContext {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = -8995101258904856855L;
	/*
	 * 页数
	 */
	private Integer total = 0;
	/*
	 * 总记录数
	 */
	private Integer records = 0;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	
}
