/**
 * 
 */
package com.jung.common;

import java.io.Serializable;
import java.util.List;

/**
 *JqueryGridService服务工厂类,用于定位一个实体对应的查询服务接口.
 *
 *@version $Revision: 1.1 $ 2010-3-19
 *@author Guo,Jun mailto: guojun828@126.com
 */
public class JqueryGridServiceFactory implements Serializable {
	
	
	/**
	 * serial UID.
	 */
	private static final long serialVersionUID = -1L;
	/**
	 * 已经实现的jqueryGridService服务列表.
	 */
	private List<JqueryGridService> jqueryGridServices;
	
	/**
	 * @param jqueryGridServices 要设置的 jqueryGridServices.
	 */
	public void setJqueryGridServices(List<JqueryGridService> jqueryGridServices) {
		this.jqueryGridServices = jqueryGridServices;
	}

	/**
	 * 取得某种实体类型的jqueryGridService的服务实现.
	 * @param entityName
	 * @return
	 */
	public JqueryGridService getJqueryGridService(String entityName){
		if(jqueryGridServices!=null&entityName!=null){
			for (int i = 0; i < jqueryGridServices.size(); i++) {
				JqueryGridService service=jqueryGridServices.get(i);
				if(service.support(entityName))
					return service;
			}
		}
		return null;
	}

}
