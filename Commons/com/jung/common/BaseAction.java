/**
 * 
 */
package com.jung.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hp.util.ListPage;
import com.hp.util.PageContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7092517565006491462L;

	public static String SUCCESS = "success";

	public static String FAIL = "fail";

	public static String ERROR = "error";

	public static String NULL = "null";

	private String subMenuName = "";

	private String mainMenuName = "";

	/**
	 * @return
	 */
	public String getMainMenuName() {
		return mainMenuName;
	}

	/**
	 * @param mainMenuName
	 */
	public void setMainMenuName(String mainMenuName) {
		this.mainMenuName = mainMenuName;
	}

	/**
	 * @return
	 */
	public String getSubMenuName() {
		return subMenuName;
	}

	/**
	 * @param subMenuName
	 */
	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	/**
	 * 创建分页上下文环境.
	 * 
	 * @param pageContext
	 *            分页上下文
	 * @param result
	 *            结果列表
	 * @param pageSize
	 *            分页大小
	 * @return
	 */
	protected PageContext createPageContext(PageContext pageContext,
			List result, int pageSize) {
		if (pageContext != null) {
			if (pageContext.getPageNumber() != 0) {
				pageContext.setPage(new ListPage(result, pageContext
						.getPageNumber(), pageSize));
			} else {
				pageContext.setPage(new ListPage(result, 0, pageSize));
			}
		}
		return pageContext;
	}

	public static final String USER_ID = "userid";
	public static final String USER_NAME = "username";
	public static final String USER_TYPE = "usertype";

	/**
	 * 获取登录session中的用户id
	 * */
	protected Integer getLoginUserId() {
		Integer userId = ConvertUtil.toInt(ActionContext.getContext().getSession()
				.get(USER_ID));
		return userId;
	}

	/**
	 * 获取登录session
	 * */
	protected Map<String, Object> getLoginUserSession() {
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put(USER_NAME, ActionContext.getContext().getSession().get(
				USER_NAME));
		ret.put(USER_ID, ActionContext.getContext().getSession().get(USER_ID));
		ret.put(USER_TYPE, ActionContext.getContext().getSession().get(
				USER_TYPE));
		return ret;
	}

	/**
	 * 设置登录session
	 * */
	protected void setLoginSession(String username, Integer userid, int usertype) {
		ActionContext.getContext().getSession().put(USER_NAME, username);
		ActionContext.getContext().getSession().put(USER_ID, userid);
		ActionContext.getContext().getSession().put(USER_TYPE, usertype);
	}
}
