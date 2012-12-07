<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
	<head>
		<title>添加用户角色</title>
		<meta content="text/html; charset=UTF-8" http-equiv="content-type"></meta>
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

		<link type="text/css"
			href="<%=path%>/basicInfo/competence/css/demo.css" rel="stylesheet">
			<link type="text/css" rel="stylesheet"
				href="<%=path%>/basicInfo/competence/css/zTreeStyle/zTreeStyle.css" />
			<link type="text/css" rel="stylesheet"
				href="<s:url value='/commons/css/commons.css'/>" />
			<link type="text/css" rel="stylesheet"
				href="<s:url value='/commons/css/layer.css'/>" />
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
           function getN(){
        	   var roleName=document.getElementById("roleName").value;
        	   if($.trim(roleName).length<1){
        		   alert("请输入角色名称！","提示");
        		   return;
        	   }
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
        	document.getElementById("mId").value=$.trim(mId);
        	$("#menuForm").submit();
        }
              function checkUserRoleName(){
        	   	var roleName=document.getElementById("roleName").value;
        	    	     jQuery.ajax({
		          url : "<%=path%>/user_competence/checkUserRoleName.action",
		          data : {
			           "roleName" : roleName
		           },
		          type : 'POST',
		          dataType : 'json',
		          success : function(res) {
			             if (res.result== "success") {
			              highColuAlert("角色名称已经存在，请重新输入！","提示");
				          return;
			             }
		          },
		          error : function() {
		        	  highColuAlert("检查角色名称错误!","提示");
		             }
	          });
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
			<div class="content_wrap" style="margin: auto;padding-top: 100px;">
				<div style="margin: auto; margin-top: 10px;">
					<form action="<%=path%>/user_competence/addRole.action"
						id="menuForm">
						角色名称:
						<input type="text" name="roleName" id="roleName"
							onchange="checkUserRoleName()" />
						<input type="hidden" id="mId" name="roleForUserMenus" />
					</form>
				</div>
				<div class="zTreeDemoBackground left" style="margin: auto;">
					<ul id="treeDemo" class="ztree">

					</ul>
				</div>
			</div>
			<input style="cursor: pointer" type="button" value="提交"
				onclick="getN()" />
			<input style="cursor: pointer" type="button" value="返回"
				onclick="javascript:history.go(-1)" />
		</div>
		    <%@include file="/commons/jsp/common_footer.jsp"%>
<%--		<%@include file="/commons/jsp/page_buttom.jsp"%>--%>
	</body>
</html>
