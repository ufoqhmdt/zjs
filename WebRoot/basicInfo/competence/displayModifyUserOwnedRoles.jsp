<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>

<html>
	<head>
		<meta content="text/html; charset=UTF-8" http-equiv="content-type"></meta>
	    <link type="text/css" href="<%=path %>/basicInfo/competence/css/demo.css" rel="stylesheet">
		<script type="text/javascript"
			src="/DMS/commons/js/jquery-1.7.2.min.js">
</script>
		<script type="text/javascript">
function qd() {
	var rolecID = new Array();
	var i = 0;
	$(":checkbox[name=roleID][checked]").each(function() {
		rolecID[i] = $(this).val();
		i++;
	});
	document.getElementById("roleForUserMenus").value = rolecID;
	//需要传3个东西到先前的地方rfcName是现在选中的角色，rlcStr 是原先的角色，companyID是公司ID
	window.location.href = "<%=path%>/user_competence/modifiyUserRole.action?roleName="
			+ rolecID
			+ "&userID="
			+ '${userID}'
			+ "&userOwnRoleID="
			+ '${roleForUserMenus}';
	//$("#fm").submit();  
};
function wt() {
	var rolecID = new Array();
	var i = 0;
	$(":checkbox[name=roleID][checked]").each(function() {
		rolecID[i] = $(this).val();
		i++;
	});
	//需要传3个东西到先前的地方rfcName是现在选中的角色，rlcStr 是原先的角色，companyID是公司ID
	window.location.href = "/DMS/user_competence/displayMinChangeAssignedRoleMenus.action?roleName="
			+ rolecID
			+ "&userID="
			+ '${userID}'
			+ "&userOwnRoleID="
			+ '${roleForUserMenus}';
};
$(document).ready(function() {
	var strs = new Array();
	strs = '${roleForUserMenus}'.split(",");
	for ( var i = 0; i < strs.length; i++) {
		document.getElementById(strs[i]).checked = "true";
	}
});
</script>
<style type="text/css">
ul.ztree {
	
}
label {
	width: 65px;
}
</style>
	</head>

	<body>
<%--		<%@include file="/commons/jsp/page_head.jsp"%>--%>
		<div class="contain">
			<div style="margin: auto; width: 500px;">
				<form action="" method="post">
					<label>
						用户名称：
					</label>
					<input type="text" value="${roleName}" readonly="readonly"/>
					<br />
					<label>
						绑定角色&nbsp;&nbsp;&nbsp;&nbsp;
					</label>
					<br />
					<c:forEach items="${roleForUsers}" var="rfc">
						<input type="checkbox" name="roleID" id="${rfc.roleID}"
							value="${rfc.roleID}" />${rfc.roleSimp}<br />
					</c:forEach>

					<input type="button" value="确定" onclick="qd()" />
<%--					<input type="button" value="微调" onclick="wt()" />--%>
					<input type="button" value="返回" onclick="javascript:history.go(-1)" />
				</form>
				<form action="" method="post" id="fm">
					<input type="hidden" name="userOwnRoleID"
						value="${roleForUserMenus}" />
					<input type="hidden" name="userID" value="${userID}" />
					<input type="hidden" name="roleForUserMenus" id="roleForUserMenus"
						value="" />
					<!-- 现有的菜单 -->
				</form>
			</div>
			<div style="height: 220px">
			
			</div>
<%--			 <%@include file="/commons/jsp/page_buttom.jsp"%>--%>
	</body>
</html>