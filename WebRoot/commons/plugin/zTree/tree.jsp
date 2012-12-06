<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<TITLE> ZTREE DEMO - Simple Data</TITLE>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" media="screen" href="<s:url value='/commons/plugin/zTree/css/zTreeStyle/zTreeStyle.css'/>" />
<link type="text/css" rel="stylesheet" media="screen" href="<s:url value='/background/resources/css/background_top_bottom.css'/>" />
<script type="text/javascript" src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.core-3.1.js'/>"></script>
	<SCRIPT type="text/javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		var zNodes =[
		    { id:0, pId:-1, name:"公司网站管理系统", open:true,icon:"images/computer.png"},
			{ id:1, pId:0, name:"系统管理",icon:"images/folder.png"},
			{ id:2, pId:0, name:"用户管理",icon:"images/folder.png"},
			{ id:3, pId:0, name:"关键字管理", isParent:false,icon:"images/folder.png"},
			{ id:4, pId:0, name:"会员管理",icon:"images/folder.png"},
			{ id:5, pId:0, name:"企业用户管理",icon:"images/folder.png"},
			{ id:6, pId:0, name:"新闻管理",icon:"images/folder.png"},
			{ id:7, pId:0, name:"服务管理",icon:"images/folder.png"},
			{ id:8, pId:0, name:"法务咨询管理",icon:"images/folder.png"},
			{ id:9, pId:0, name:"个人求职管理",icon:"images/folder.png"},
			{ id:10, pId:0, name:"企业招聘管理",icon:"images/folder.png"},
			{ id:11, pId:1, name:"系统管理孩子节点1",icon:"images/folder.png"},
			{ id:12, pId:1, name:"系统管理孩子节点2",icon:"images/folder.png"},
			{ id:13, pId:1, name:"系统管理孩子节点3",icon:"images/folder.png"},
			{ id:14, pId:2, name:"用户管理孩子节点1",icon:"images/folder.png"},
			{ id:15, pId:2, name:"用户管理孩子节点2",icon:"images/folder.png"},
			{ id:16, pId:2, name:"用户管理孩子节点3",icon:"images/folder.png"},
			{ id:17, pId:3, name:"关键字管理孩子节点1",icon:"images/folder.png"},
			{ id:18, pId:3, name:"关键字管理孩子节点2",icon:"images/folder.png"},
			{ id:19, pId:3, name:"关键字管理孩子节点3",icon:"images/folder.png"},
			{ id:20, pId:4, name:"会员管理孩子节点1",icon:"images/folder.png"},
			{ id:21, pId:4, name:"会员管理孩子节点2",icon:"images/folder.png"},
			{ id:22, pId:4, name:"会员管理孩子节点3",icon:"images/folder.png"}
		];

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		</script>
</head>
<body>

	<div id="content">
		
			<div id="content_center">
					<div id="navigator_background">
						    <img src="<s:url value='/background/resources/common/images/navigator_background.png'/>" alt="logo" />
					</div>
					<div id="navigator_tree">
					<ul id="treeDemo" class="ztree"></ul>
					</div>
			</div>
		
			
	</div>
	
</body>
</html>