/**
 * 
 */
package com.jung.common;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.json.annotations.JSON;

import com.hp.util.PageContext;


/**
 *jquery grid 公共查询action，包含基本的所有对象列表查询.
 * 
 *@version $Revision: 1.1 $ 2011-10-7
 *@author GuoJun mailto: jun.guo2@hp.com
 */
public class JqueryGridAction extends BaseAction {
	/**
	 * .
	 */
	private static final long serialVersionUID = -1L;

	private static final Log log = LogFactory.getLog(JqueryGridAction.class);

	/**
	 * 总页数.
	 */
	private Integer total = 0;

	/**
	 * 总记录数.
	 */
	private Integer records = 0;

	/**
	 * 当前页数.
	 */
	private Integer page = 0;

	/**
	 * 排序字段名称.
	 */
	private String sidx = "";

	/**
	 * 排序方式.
	 */
	private String sord = "desc";

	/**
	 * 每页数量.
	 */
	private Integer rows;

	/**
	 * 查询的实体名称.
	 */
	private String entityName;

	/**
	 * jquery grid 查询服务工厂.
	 */
	private JqueryGridServiceFactory factory;

	/**
	 * 分页的上下文.
	 */
	private PageContext pageContext;

	/**
	 * 查询结果列表.
	 */
	private List<Map<String, Object>> dataRows = new ArrayList<Map<String, Object>>();

	/**
	 * 每种实体一页记录数配置.
	 */
	private Properties propertyPageConfig;

	/**
	 * 查询条件.
	 */
	private Map<String, String> queryConditions;

	/**
	 * @return pageContext
	 */
	@JSON(serialize = false)
	public PageContext getPageContext() {
		if (this.pageContext == null)
			this.pageContext = new PageContext();
		return pageContext;
	}

	/**
	 * @param pageContext
	 *            要设置的 pageContext
	 */
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	/**
	 * @return dataRows
	 */
	public List<Map<String, Object>> getDataRows() {
		return dataRows;
	}

	/**
	 * @param dataRows
	 *            要设置的 dataRows
	 */
	public void setDataRows(List<Map<String, Object>> dataRows) {
		this.dataRows = dataRows;
	}

	/**
	 * @return queryConditions
	 */
	public Map<String, String> getQueryConditions() {
		if (queryConditions == null)
			queryConditions = new HashMap<String, String>();
		return queryConditions;
	}

	/**
	 * @param queryConditions
	 *            要设置的 queryConditions
	 */
	public void setQueryConditions(Map<String, String> queryConditions) {
		this.queryConditions = queryConditions;
	}

	/**
	 * @return rows
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            要设置的 rows
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return propertyPageConfig
	 */
	public Properties getPropertyPageConfig() {
		return propertyPageConfig;
	}

	/**
	 * @param propertyPageConfig
	 *            要设置的 propertyPageConfig
	 */
	public void setPropertyPageConfig(Properties propertyPageConfig) {
		this.propertyPageConfig = propertyPageConfig;
	}

	/**
	 * @return sidx
	 */
	public String getSidx() {
		return sidx;
	}

	/**
	 * @param sidx
	 *            要设置的 sidx
	 */
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	/**
	 * @return sord
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord
	 *            要设置的 sord
	 */
	public void setSord(String sord) {
		this.sord = sord;
	}

	/**
	 * @return
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @return
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @return
	 */
	public Integer getRecords() {
		return records;
	}

	/**
	 * @param total
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @param records
	 */
	public void setRecords(Integer records) {
		this.records = records;
	}

	/**
	 * @param factory
	 *            要设置的 factory
	 */
	public void setFactory(JqueryGridServiceFactory factory) {
		this.factory = factory;
	}

	/**
	 * @return entityName
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * @param entityName
	 *            要设置的 entityName
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() {
		dataRows = new ArrayList<Map<String, Object>>();
		decodeQueryCondition();
		JqueryGridService service = factory.getJqueryGridService(entityName);
		if (this.rows == null || this.rows <= 0) {
			// 预设分页大小为默认值
			int pagesize = Constants.DEFAULT_PAGE_SIZE;
			this.getPageContext().setPageSize(pagesize);
		} else
			this.getPageContext().setPageSize(rows);
		this.getPageContext().setPageNumber(page > 0 ? page - 1 : 0);
		// 获取支持当前查询的实体类型的查询服务接口定义
		try {
			pageContext = service.getEntityPage(getPageContext(), queryConditions, sidx, sord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (pageContext != null && pageContext.getPage() != null) {
			this.total = pageContext.getPage().getLastPageNumber();
			this.records = pageContext.getPage().getTotalNumberOfElements();
		}
		List entityList = this.getPageContext().getPage().getThisPageElements();
		if (entityList != null && entityList.size() > 0) {
			for (int i = 0; i < entityList.size(); i++) {
				Map<String, Object> dataitem = new HashMap<String, Object>();
				Object entity = entityList.get(i);
				// set rows
				Field[] fields = entity.getClass().getDeclaredFields();
				fields = removeStaticProperty(fields);
				int fieldLength = fields.length;
				for (int j = 0; j < fieldLength; j++) {
					try {
						String getMethodName = "get" + fields[j].getName().substring(0, 1).toUpperCase() + fields[j].getName().substring(1);
						Method getMethod = entity.getClass().getMethod(getMethodName, new Class[] {});
						String returnType = getMethod.getReturnType().getSimpleName();
						if (checkBaseDataType(returnType)) {
							if( getMethod.invoke(entity, new Object[] {})!=null){
								String fieldValue = getMethod.invoke(entity, new Object[] {}).toString();
								dataitem.put(fields[j].getName(), fieldValue);
							}else{
								dataitem.put(fields[j].getName(), "");
							}
						
						}
					} catch (Exception e) {
						log.error(e);
					}
				}
				dataRows.add(dataitem);

			}
		}
		return SUCCESS;

	}

	/**
	 * 解码可能带有中文的查询条件,重置%26为&符号.
	 */
	private boolean decodeQueryCondition() {
		if (this.queryConditions != null) {
			for (Iterator iter = this.queryConditions.keySet().iterator(); iter.hasNext();) {
				String key = (String) iter.next();
				try {
					String inputString = this.queryConditions.get(key);
					inputString = inputString.replaceAll("%26", "&");
					//查询中到"_"和"%"不需要加转义字符
					/*
					inputString = inputString.replaceAll("%", "\\\\%");
					inputString = inputString.replaceAll("_", "\\\\_");
					*/
					this.queryConditions.put(key, new String(inputString.getBytes("ISO-8859-1"), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					log.error(e);
					return false;
				}

			}
		}
		return true;
	}

	/**
	 * 检查返回类型是否为基本数据类型.
	 * 
	 * @param returnType
	 * @return
	 */
	private boolean checkBaseDataType(String returnType) {
		for (int i = 0; i < Constants.BASE_DATA_TYPE.length; i++) {
			if (Constants.BASE_DATA_TYPE[i].equals(returnType))
				return true;

		}
		return false;
	}
	/**
	 * 避免代理生成静态属性方法
	 * @param fields
	 * @return
	 */
	private static Field[] removeStaticProperty(Field[] fields) {
		Field[] tempFields = new Field[fields.length];
		int count = 0;
		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getModifiers() <= Modifier.PRIVATE) {
				tempFields[count] = fields[i];
				count++;
			}
		}
		Field[] returnFields = new Field[count];
		for (int i = 0; i < count; i++) {
			returnFields[i] = tempFields[i];
		}
		return returnFields;

	}

}
