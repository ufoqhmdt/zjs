<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
	<head>
		<title>修改用户角色</title>
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
	check : {
		enable : true,
		nocheckInherit : true
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
                $("#1").attr("checked","true");
            });
           function updateRC(){
        	
        	var mId="";
        	var treeObj=$.fn.zTree.getZTreeObj("treeDemo");
        	nodes=treeObj.getCheckedNodes(true);
        	for(var i=0;i<nodes.length;i++){
        		if(mId!=""){
        			mId = mId+","+nodes[i].id;    
        		}
        		else{
        			mId = nodes[i].id;
        		}  
        	}
        	document.getElementById("mId").value=mId;
        	$("#menuForm").submit();
        }
           function deleteRoleForUser(){
        	     if (!confirm("确认删除吗?")) {
						return;
				}
            	window.location.href = "<%=path%>/user_competence/deleteRoleForUser.action?roleID="+'${roleID}'+"&userID="+'${userID}';
           }
        </script>
		<style type="text/css">
ul.ztree {
	
}
</style>
	</head>

	<body>
<%--		<%@include file="/commons/jsp/page_head.jsp"%>--%>
<%@include file="/commons/jsp/common_header.jsp"%>
		<div class="contain">
			<div class="content_wrap" style="margin: auto;padding-top:120px">
				<div style="margin: auto; margin-top: 10px;">
					<form
						action="<%=path%>/user_competence/modifyRoleOwnedMenus.action"
						id="menuForm">
						角色名称:
						<input type="text" name="roleName" value="${roleName}" />
						<input type="hidden" id="mId" name="roleForUserMenus" />
						<input type="hidden" id="modifyCode" name="modifyCode" />
						<input type="hidden" name=roleID value="${roleID}" />
							<input type="hidden" name=userID value="${userID}" />
						<input type="hidden" name="checkedMenusID"
							value="${checkedMenusID}" />
					</form>
				</div>
				<div class="zTreeDemoBackground left" style="margin: auto;">
					<ul id="treeDemo" class="ztree">

					</ul>
				</div>

			</div>
			<br />
			<br />
			<div style="margin: auto; width: 600px; margin-top: 10px;">
<%--				<label style="font-size: 12px; width: 200px;">--%>
<%--					修改角色是否影响使用该角色的用户--%>
<%--				</label>--%>
<%--				<input type="radio" name="rcff" value="yes" />--%>
<%--				是--%>
<%--				<input type="radio" name="rcff" value="no" />--%>
<%--				否--%>
				<input style="cursor:pointer" type="button" value="修改" onclick="updateRC()" />
<%--				<input style="cursor:pointer" type="button" value="删除" onclick="deleteRoleForUser()" />--%>
				<input style="cursor:pointer" type="button" value="返回" onclick="javascript:history.go(-1)" />
			</div>
		</div>
<%--		<%@include file="/commons/jsp/page_buttom.jsp"%>--%>
<%@include file="/commons/jsp/common_footer.jsp"%>
	</body>
</html>
