<%@ page contentType="text/html; charset=GBK"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@include file="/commons/jsp/common_front_head.jsp"%>
<html>
	<head>
		<title><decorator:title/>
		</title>
		<link type="text/css" rel="stylesheet" media="screen"
			href="<s:url value='/commons/css/index.css'/>" />
		<decorator:head />
	</head>
	<body>
		<div id="index_top">
			<%-- <%@include file="/commons/jsp/common_top.jsp"%> --%>
		</div>
		<div id="index_content">
		<decorator:body />
		</div>
		<div id="index_bottom_index">
			<%-- <%@include file="/commons/jsp/common_bottom.jsp"%> --%>
		</div>
	</body>
</html>