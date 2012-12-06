package com.jung.common;


/**
 *  @Description: 用ThreadLocal提供一个存储线程内变量的地方. 客户端代码可以用静态方法存储和获取线程内变量,
 *  不需要依赖于HttpSession.  web层的Controller可通过此处向business层传入user_id之类的变量
 *  @version Revision: V1.0 2012-9-3 下午02:09:22
 *  @author GuoJun mailto: jackson@highcolu.com
 *   
 */
public class SystemSession {
	private static final ThreadLocal<Object> local = new ThreadLocal<Object>();  
	private static final ThreadLocal<Object> local2 = new ThreadLocal<Object>();  
	
	private static final ThreadLocal<Object> localOther = new ThreadLocal<Object>();  
//    public static void setUser(User user) {  
//        local.set(user);  
//    }  
//    public static User getUser() {  
//    	if(local.get()==null){
//    		return null;
//    	}
//        return (User)local.get();  
//    }  
    public static void setLocales(Object locales){
    	local2.set(locales);
    }
    public static Object getLocales(){
    	//临时解决方案
    	if(local2.get()==null){
    		return "zh_CN";
    	}
    	return local2.get(); 
    }
    public static void setOther(Object other){
    	localOther.set(other);
    }
    public static Object getOther(){
    	return localOther.get(); 
    }
}
