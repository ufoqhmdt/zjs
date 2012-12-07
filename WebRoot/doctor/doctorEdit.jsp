<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/common_head.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="<s:url value='/commons/css/commons.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<s:url value='/commons/css/layer.css'/>" />
<script type="text/javascript"
	src="<s:url value='/doctor/js/doctor.js'/>"></script>
	
<style type="text/css">
#carfB {
	background: -moz-linear-gradient(center top, #70C9E3 0%, #39A0BE 100%)
		repeat scroll 0 0 transparent;
}
.ui-jqgrid tr.jqgrow td {
	height: 25px;
}
.ui-widget {
	font-family: Lucida Grande;
}
</style>
</head>

<body>
  <%@include file="/commons/jsp/common_header.jsp"%>
	<div class="contain">
		<s:form action="doctor/update.action" method="post">
		<div class="search">
			<div align="right">
				</div>
			<fieldset >
				<legend>
					<font style="color:#6D93AB; font-weight:bold;"><s:text
							name="医师修改"/> </font>
				</legend>
				<div align="center">
					<label><s:text name="医师名称"></s:text></label>
					<s:hidden name="doctorID" id="doctorID" value="%{doctor.doctorID}"></s:hidden>
					<s:textfield name="doctor.doctorName" value="%{doctor.doctorName}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="医师手机"></s:text></label>
					<s:textfield name="doctor.doctorMobile" value="%{doctor.doctorMobile}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="所属地区"></s:text></label>
					<s:hidden name="regionID" id="regionID"></s:hidden>
					<s:textfield name="doctor.region.regionName" onclick="regionSelect()" readonly="true" id="regionName" value="%{doctor.region.regionName}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="医师职称"></s:text></label>
					<s:textfield name="doctor.doctorJobTitle" value="%{doctor.doctorJobTitle}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="目标科室"></s:text></label>
					<s:textfield name="doctor.doctorTargetDept" value="%{doctor.doctorTargetDept}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="关联代表"></s:text></label>
					<s:hidden name="employeeID" id="employeeID"></s:hidden>
					<s:textfield name="doctor.employeeMR.employeeName" readonly="true" onclick="employeeSelect()" id="employeeName" value="%{doctor.employeeMR.employeeName}"></s:textfield>
				</div>
				<div align="center">
					<button class="blue" style="cursor:pointer" type="submit" id="updateButton">
						<s:text name="修改" />
					</button>
					<button class="blue" type="button"
						onclick="javascript:history.go(-1)">
						<s:text name="返回" />
					</button>
					<s:actionerror />
				</div>
			</fieldset>
			
		</div>
		
		</s:form>
	</div>
<%@include file="/commons/jsp/common_footer.jsp"%>
</body>
</html>
