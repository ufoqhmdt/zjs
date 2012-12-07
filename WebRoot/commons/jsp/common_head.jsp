<%@ page language="java" import="com.jung.common.HttpReqUtil" pageEncoding="utf-8"%>
<%@ include file="/commons/jsp/taglibs.jsp"%>
<!-- 全局java变量与方法区域 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<!DOCTYPE html>
<html lang="cn">
	<head>
		<meta charset="utf-8">
		<title>文献宅及送</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="文献宅及送">
		<meta name="author" content="gwfy">
		<style type="text/css">
			body {
				padding-top: 128px;
			}
		</style>
		<link href="<%=path%>/commons/css/bootstrap-github.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/commons/css/prettify.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/commons/css/smoothness/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/commons/css/skins/tango/skin.css" rel="stylesheet" type="text/css" />
		<link href="<%=path%>/commons/css/main.css" rel="stylesheet" type="text/css" />

		<link type="text/css" rel="stylesheet" media="screen" href="<s:url value='/commons/plugin/jquery.ui.themes/smoothness/jquery-ui-1.8.20.custom.css'/>" />
		<link type="text/css" rel="stylesheet" media="screen" href="<s:url value='/commons/plugin/jqgrid/ui.jqgrid.css'/>" />
		<link type="text/css" rel="stylesheet" media="screen" href="<s:url value='/commons/plugin/jqPagination/css/jqpagination.css'/>" />
		<link rel="stylesheet" type="text/css" href="<s:url value='/commons/plugin/DatePicker/skin/default/datepicker.css'/>"  />
		<link type="text/css" rel="stylesheet" media="screen" href="<s:url value='/commons/plugin/alert/css/alert.css'/>" />
		<!-- javascript lib file -->
		<script type="text/javascript" src="<s:url value='/commons/js/common.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/js/jquery-1.7.2.min.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/js/jquery-ui-1.8.14.custom.min.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/plugin/jqgrid/i18n/grid.locale-cn.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/plugin/jqgrid/jquery.tablednd.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/plugin/jqgrid/jquery.jqgrid.min.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/plugin/jqPagination/js/jquery.jqpagination.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/plugin/alert/jquery.alert.js'/>"></script>
		<script language="JavaScript" type="text/javascript" src="<s:url value='/commons/plugin/DatePicker/WdatePicker.js'/>"></script>
		
		<!-- Add by Luxinglin -->
		<script type="text/javascript" src="<s:url value='/commons/js/function.js'/>"></script>
		<script type="text/javascript" src="<s:url value='/commons/js/jquery.form.js'/>"></script>
		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="js/vendor/html5.js"></script>
		<![endif]-->

		<link rel="shortcut icon" href="">
	</head>

<c:set var="ctxPath" value="${pageContext.request['contextPath']}"
	scope="request" />


<!-- 全局javascript变量与方法区域 -->
<script language="JavaScript" type="text/javascript">
	var defaultServerAddress = '<%=basePath%>';
	var defaultAddress = '<%=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()%>';
	var contextPath = '<%=request.getContextPath()%>';
	var __backURL = '<%=request.getHeader("Referer")%>';
	var ctxPath = "${ctxPath}";
	console.log("defaultServerAddress:"+defaultServerAddress)
	console.log("defaultAddress:"+defaultAddress)
	console.log("contextPath:"+contextPath)
	console.log("__backURL:"+__backURL)
	console.log("ctxPath:"+ctxPath)
</script>





