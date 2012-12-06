<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
  	<head>
  	<link type="text/css" rel="stylesheet"  href="<s:url value='/commons/css/common_enterprise.css'/>" />
  	<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/common_legal.css'/>" />
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/common_job.css'/>" />
	</head>
	
  <body>
  <!--个人中心内容区  -->
		<div id="center_content">
				<!-- 最上面导航 -->
				<div id="enterprise_navigator">
					<span>您的位置：</span>
					<span onclick="redirectToURL('/index.jsp')" class=cursorPoint>首页&nbsp;>> </span>
					<span onclick="redirectToURL('/workGuide/workGuide.jsp')" class=cursorPoint>办事指引&nbsp;>> </span>
					 <span >&nbsp;${secondTitle}</span>
				</div>
				<div id="job_line">
					
				</div>
				<!-- 大厅主内容 -->
				<div id="main_content">
					<div id="content_logo">
					<img src="<s:url value='/commons/images/guidance.jpg'/>" />
					</div>
					<div id="about_title">
						 <span>${news.title}</span>
						 <span style="font-size:12px;">${news.sub_title}</span>
					</div>
						<div id=sub_title>
							<!-- 来源,发布日期 -->
							<div id="about_source">
								来源：${news.source} 	发布日期：${news.publishTime}
							</div>
							<div id="about_content">
								${news.content}
							</div>
						</div>
				</div>
		</div>
  </body>
</html>
