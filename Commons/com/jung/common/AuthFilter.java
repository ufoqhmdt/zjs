package com.jung.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {
 
 public void destroy() {

 }
 /**
  * doFilter方法的第一个参数为ServletRequest对象。此对象给过滤器提供了对进入的信息（包括表单数据、cookie和HTTP请求头）的完全访问。
  * 第二个参数为ServletResponse，通常在简单的过滤器中忽略此参数。最后一个参数为FilterChain，此参数用来调用servlet或JSP页。
  */
 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
   FilterChain filterChain) throws IOException, ServletException {
   //如果处理HTTP请求，并且需要访问诸如getHeader或getCookies等在ServletRequest中无法得到的方法，就要把此request对象构造成HttpServletRequest
  HttpServletRequest request = (HttpServletRequest)servletRequest;
  HttpServletResponse response = (HttpServletResponse)servletResponse;
  String currentURL = request.getRequestURI();//取得根目录所对应的绝对路径:
  System.out.println("currentURL : "+currentURL);
  String targetURL = currentURL.substring(currentURL.indexOf("/", 0), currentURL.length());  //截取到当前文件名用于比较
  HttpSession session = request.getSession(false);
  /*
   * 后台页面必须管理员登录
   * */
  if(targetURL.indexOf("background")!=-1){
	  if (targetURL.indexOf("background/login.jsp")==-1) {//判断当前页是否是重定向以后的登录页面页面，如果是就不做session的判断，防止出现死循环
	   if (session == null || session.getAttribute("adminUsername") == null) {//*用户登录以后需手动添加session
	    response.sendRedirect(request.getContextPath() + "/background/login.jsp");//如果session为空表示用户没有登录,就重定向到login.jsp页面
	    return;
	   		}
	   }
  }
  else if(targetURL.indexOf("user/user_center.jsp")!=-1){/*用户中心*/
	  if (session == null || session.getAttribute("usertype")==null||(Integer)session.getAttribute("usertype")!=0) {
		  response.sendRedirect(request.getContextPath() + "/login.jsp?tempUrl=0");
	  }else{
		  response.sendRedirect(request.getContextPath() + "/person/enterCenter.action"+"?id="+session.getAttribute("id")+"&type="+session.getAttribute("usertype"));
	  }
  } else if(targetURL.indexOf("search/advancedSearch.jsp")!=-1){/*高级搜索*/
	  if (session == null || session.getAttribute("usertype")==null||(Integer)session.getAttribute("usertype")!=0) {
		  response.sendRedirect(request.getContextPath() + "/login.jsp?tempUrl=1");
	  }
  }else if(targetURL.indexOf("legalConsult/")!=-1){/*法务咨询模块*/
	  if (session == null || session.getAttribute("usertype")==null||(Integer)session.getAttribute("usertype")==0) {
		  if(targetURL.indexOf("legal_center")!=-1){
			  response.sendRedirect(request.getContextPath() + "/login.jsp?tempUrl=legal_center");
		  }else if(targetURL.indexOf("online_answer")!=-1){
			  response.sendRedirect(request.getContextPath() + "/login.jsp?tempUrl=2");
		  }/*else if(targetURL.indexOf("company_magazine")!=-1){
			  response.sendRedirect(request.getContextPath() + "/login.jsp?tempUrl=company_magazine");
		  }*/
	  }
  }
  else if(targetURL.indexOf("/login.jsp")!=-1){
	  if (session != null && session.getAttribute("usertype")!=null&&(Integer)session.getAttribute("usertype")==0) {
			  //response.sendRedirect(request.getContextPath() + "/person/enterCenter.action"+"?id="+session.getAttribute("id")+"&type="+session.getAttribute("usertype")); 
	  }
  }
  //加入filter链继续向下执行
  filterChain.doFilter(request, response);//.调用FilterChain对象的doFilter方法。Filter接口的doFilter方法取一个FilterChain对象作为它的一个参数。在调用此对象的doFilter方法时，激活下一个相关的过滤器。如果没有另一个过滤器与servlet或JSP页面关联，则servlet或JSP页面被激活。

 }

 public void init(FilterConfig filterConfig) throws ServletException {

 }
}
