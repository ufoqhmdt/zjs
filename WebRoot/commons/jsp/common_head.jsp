<%@ page language="java" import="com.jung.common.HttpReqUtil" pageEncoding="utf-8"%>
<%@ include file="/commons/jsp/taglibs.jsp"%>
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
		<link href="commons/css/bootstrap-github.css" rel="stylesheet" type="text/css" />
		<link href="commons/css/prettify.css" rel="stylesheet" type="text/css" />
		<link href="commons/css/smoothness/jquery-ui-1.9.2.custom.min.css" rel="stylesheet" type="text/css" />
		<link href="commons/css/skins/tango/skin.css" rel="stylesheet" type="text/css" />
		<link href="commons/css/main.css" rel="stylesheet" type="text/css" />

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="js/vendor/html5.js"></script>
		<![endif]-->

		<link rel="shortcut icon" href="">
	</head>

<c:set var="ctxPath" value="${pageContext.request['contextPath']}"
	scope="request" />
<!-- 全局java变量与方法区域 -->
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">

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





