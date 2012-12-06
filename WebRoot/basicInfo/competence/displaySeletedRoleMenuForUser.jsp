<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
	<head>
		<meta content="text/html; charset=UTF-8" http-equiv="content-type"></meta>
		<link type="text/css"
			href="<%=path%>/basicInfo/competence/css/demo.css" rel="stylesheet">
			<link type="text/css" rel="stylesheet"
				href="<%=path%>/basicInfo/competence/css/zTreeStyle/zTreeStyle.css" />
			<script type="text/javascript"
				src="<%=path%>/commons/js/jquery-1.7.2.min.js">
			</script>
		<script type="text/javascript"
			src="<%=path%>/basicInfo/competence/js/jquery.ztree.core-3.2.js">
		</script>
		<script
			src="<%=path%>/basicInfo/competence/js/jquery.ztree.excheck-3.2.js"
			type="text/javascript">
		</script>
		<script
			src="<%=path%>/basicInfo/competence/js/jquery.ztree.exedit-3.2.js"
			type="text/javascript">
		</script>
		<script type="text/javascript">

var setting = {
	view : {
		dblClickExpand : true

	},
	data : {
		simpleData : {
			enable : true
		}
	}
};
$(document).ready(function(){
            	var zNodes = ${menuTree};
                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                zTree = $.fn.zTree.getZTreeObj("treeDemo");
            });
           function tj(){
        	 //  alert($(":hidden[name=rfcName]").val());
        	 //  alert($(":hidden[name=rfcMenus]").val());
           }
        </script>
		<style type="text/css">
ul.ztree {
	
}
</style>
	</head>

	<body>
<%--		<%@include file="/commons/jsp/page_head.jsp"%>--%>
		<div class="contain">
			<div class="content_wrap" style="margin: auto;">
				<div class="zTreeDemoBackground left" style="margin: auto;">
					<ul id="treeDemo" class="ztree">

					</ul>
				</div>
				<form action="<%=path%>/user_competence/assignRoleForUser.action"
					method="post">
					<input type="hidden" name="roleForUserMenus"
						value="${roleForUserMenus}" />
					<input type="hidden" name="roleName" value="${roleName}" />
					<input type="hidden" name="userID" value="${userID}" />

					<input type="submit" value="确定" />
				    <input type="button" value="返回" onclick="javascript:history.go(-1)"/>
				</form>
			</div>
<%--			<%@include file="/commons/jsp/page_buttom.jsp"%>--%>
	</body>
</html>
