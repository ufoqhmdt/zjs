package com.jung.common;

import java.io.Serializable;
import java.util.Map;

import com.hp.util.PageContext;

/**
 *适用于jquery grid查询的服务接口.
 *
 *@version $Revision: 1.1 $ 2012-3-19
 *@author GuoJun mailto: guojun828@126.com
 */
public interface JqueryGridService extends Serializable {
	/**
	 * 实体分页查询方法，根据分页的上下文得到下一页实体数据
	 * @param pageContext 当前分页上下文环境
	 * @param queryConditions 查询条件,用键值对方式传递
	 * @param orderProperty  需要排序的属性
	 * @param orderMode  排序方式asc,desc
	 * @return
	 */
	public PageContext getEntityPage(PageContext pageContext,
			Map<String, String> queryConditions, String orderProperty,
			String orderMode);
	
	/**
	 * 自审接口方法，用于判断该服务类型是否支持某种类型的实体jquery grid 服务
	 * @param entityName 实体名称
	 * @return
	 */
	public boolean support(String entityName);


}
