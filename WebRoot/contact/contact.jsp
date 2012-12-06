<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
  	<head><%--
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/user.css'/>" />
		--%><link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/common_enterprise.css'/>" />
	</head>
  <body>
  <!--个人中心内容区  -->
		<div id="center_content">
				<!-- 最上面导航 -->
				<div id="enterprise_navigator">
					<span>您的位置：</span>
					<span onclick="redirectToURL('/index.jsp')" class=cursorPoint>首页&nbsp;>> </span>
					 <span >&nbsp; 联系我们</span>
				</div>
				<div id="enterprise_line">
					
				</div>
				<!-- 大厅主内容 -->
				<div id="main_content">
							<div id="content_logo">
							<img src="<s:url value='/commons/images/contact_us.jpg'/>" />
							</div>
							<div id="about_content" style="top:30px;">
									<%--<img src="<s:url value='/commons/images/contimg.jpg'/>" />--%><%--
									${news.content}--%>
									 <table width="100%" border="0" cellspacing="0" cellpadding="0">
								        <tr>
								          <td height="80">&nbsp;</td>
								        </tr>
								      </table>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
								        <tr>
								          <td style="padding-left:30px;"><img src="../commons/images/contact3.jpg" /></td>
								        </tr>
								      </table>
								      <table width="100%" border="0" cellspacing="0" cellpadding="0">
								        <tr>
								          <td style="background:url(../commons/images/contact.jpg) 18px top no-repeat; height:260px; padding:0px 5px 0px 300px; line-height:32px; font-size:15px; color:#333333; font-family:'微软雅黑', '黑体';">公司总机：62861160<br />
								            　　　　－金桥分公司：58541503<br />
								            　　　　－闵行分公司：64631481<br />
								            传真电话：62861160<br />
								            我们的工作时间：上午9：00 下午 17：00（双休日和节假日除外）<br />
								          联系信箱：<a href="mailto:zhidian@hr.sh.cn">zhidian@hr.sh.cn</a><br /></td>
								        </tr>
								      </table>
							</div>
				</div>
		</div>
  </body>
</html>
