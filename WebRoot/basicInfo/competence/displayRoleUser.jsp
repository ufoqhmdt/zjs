<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
	<head>
		<meta content="text/html; charset=UTF-8" http-equiv="content-type"></meta>
		<link type="text/css"
			href="<%=path%>/basicInfo/competence/css/demo.css" rel="stylesheet">
		
</script>
			<script type="text/javascript">
function qd() {
	var rolecID = new Array();
	var i = 0;
	$(":checkbox[name=rolecID][checked]").each(function() {
		rolecID[i] = $(this).val();
		i++;
	});
	if (rolecID.length > 0) {
		window.location.href = "<%=path%>/user_competence/displayAssignedRoleMenus.action?roleName="
				+ rolecID + "&userID=" + '${userID}';
	} else {
		alert("请先选择角色!","提示");
		return;
	}
}
function wt() {
	var rolecID = new Array();
	var i = 0;
	$(":checkbox[name=rolecID][checked]").each(function() {
		rolecID[i] = $(this).val();
		i++;
	});
	window.location.href = "<%=path%>/user_competence/displayMinChangeAssignedRoleMenus.action?roleName="
			+ rolecID + "&userID=" + '${userID}';
}
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
<%@include file="/commons/jsp/common_header.jsp"%>
		<div class="contain">
			<div style="margin: auto; width: 500px; padding-top:140px">
				<form action="">
					<label>
						代表名称：
					</label>
					<input type="text" value="${roleName}" />
					<br />
					<label>
						绑定角色&nbsp;&nbsp;&nbsp;&nbsp;
					</label>
					
					<c:forEach items="${roleForUsers}" var="rfc">
						<input type="checkbox" name="rolecID" value="${rfc.roleID}" />${rfc.roleSimp}<br />
					</c:forEach>
					<input type="hidden" name="${userID}" />
					<br />
					<input type="button" value="确定" onclick="qd()" />
					<input type="button" value="返回" onclick="javascript:history.go(-1)"/>
				</form>
			</div>
			<div style="height: 220px">

			</div>
<%@include file="/commons/jsp/common_footer.jsp"%>
	</body>
</html>