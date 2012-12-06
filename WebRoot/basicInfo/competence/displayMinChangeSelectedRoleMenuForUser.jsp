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
            });
          
           function setMenus(){
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
        	document.getElementById("lcs").value=mId;
         	$("#form").submit();
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
				<div>
					<form
						action="/DMS/user_competence/assignRoleForUserAfterMinChange.action"
						method="post" id="form">
						<input type="hidden" name="userOwnRoleID" value="${userOwnRoleID}" />
						<input type="hidden" name=roleForUserMenus
							value="${roleForUserMenus}" />
						<!-- 原先选中的模板 -->
						<input type="hidden" name="roleName" value="${roleName}" />
						<!--  公司ID-->
						<input type="hidden" name="userID" value="${userID}" />
						<!-- 现在选中的模板 -->
						<input type="hidden" name="checkedMenusID" id="lcs" />
						<!-- 该公司模板对应的菜单ID -->
						<input type="button" value="确定" onclick="setMenus()" />
						<input type="button" value="返回" onclick="javascript:history.go(-1)"/>
					</form>
				</div>
			</div>
<%--			<%@include file="/commons/jsp/page_buttom.jsp"%>--%>
	</body>
</html>
