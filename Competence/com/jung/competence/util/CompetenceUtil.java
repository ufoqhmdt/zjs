package com.jung.competence.util;

import java.util.ArrayList;
import java.util.List;

import com.jung.competence.model.RoleLinkUser;
import com.jung.competence.model.ViewMenuTree;
import com.jung.employee.model.Employee;
import com.opensymphony.xwork2.ActionContext;
/**
 * 
*  @Description: 权限工具类
*  @version Revision: V1.0 2012-10-20 下午04:01:38
*  @author YINYU mailto: yinyu@highcolu.com
 */
public class CompetenceUtil {
  
	
	/**
	 * 用符号包装字符串
	 * @param string
	 * @return [xxx],{xxx}
	 */
	public static String addSymbol(String string,char left,char right) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(left);
		stringBuffer.append(string);
		stringBuffer.append(right);
		return stringBuffer.toString();
	}
	/**
	 * 
	*  @Description: 将字符串组合成1,2,3,4
	*  @param:@param list
	*  @param:@return 1,2,3,4
	*  @author YinYu mailto: yinyu@highcolu.com
	 */
	public static String appendComma(List<?> list){
		StringBuffer IDs = new StringBuffer();
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				if(list.get(i) instanceof ViewMenuTree){
					IDs.append(((ViewMenuTree) list.get(i)).getMenuID());
					if (i < list.size() - 1) {
						IDs.append(",");
					}
				}
				else if(list.get(i) instanceof RoleLinkUser){
					IDs.append(((RoleLinkUser) list.get(i)).getRoleID());
					if (i < list.size() - 1) {
						IDs.append(",");
					}
				}
			}
		}
		return IDs.toString()!= null?IDs.toString() :"";
	}
	public static Employee getEmployee(){
		return (Employee) ActionContext.getContext().getSession().get("employee");
	}
}
