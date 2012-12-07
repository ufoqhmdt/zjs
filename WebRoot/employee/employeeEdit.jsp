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
	src="<s:url value='/employee/js/employee.js'/>"></script>
	
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
		<s:form action="employee/update.action" method="post">
		<div class="search">
			<div align="right">
				
				</div>
			<fieldset >
				<legend>
					<font style="color:#6D93AB; font-weight:bold;"><s:text
							name="代表修改"/> </font>
				</legend>
				<div align="center">
					<label><s:text name="代表名称"></s:text></label>
					<s:hidden name="employeeID" id="employeeID" value="%{employee.employeeID}"></s:hidden>
					<s:textfield name="employee.employeeName" value="%{employee.employeeName}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="代表类型"></s:text></label>
					<s:select name="employee.employeeType" list="#{1:'MR',2:'DSM',3:'PS',4:'MARKET'}"  label="abc" listKey="key" listValue="value"  headerKey="0" headerValue="%{employee.employeeType}"/>
				</div>
				<div align="center">
					<label><s:text name="代表手机"></s:text></label>
					<s:textfield name="employee.employeeMobile" value="%{employee.employeeMobile}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="所在地区"></s:text></label>
					<s:hidden name="regionID" id="regionID"></s:hidden>
					<s:textfield name="employee.region.regionName" onclick="regionSelect()" readonly="true" id="regionName" value="%{employee.region.regionName}"></s:textfield>
				</div>
			
				<div align="center">
					<label><s:text name="代表编号"></s:text></label>
					<s:textfield name="employee.employeeNumber" value="%{employee.employeeNumber}"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="上级代表"></s:text></label>
					<s:hidden name="parentEmployeeID" id="parentEmployeeID"></s:hidden>
					<s:textfield name="employee.parentEmployee.employeeName" readonly="true" onclick="parentEmployeeSelect()" id="parentEmployeeName" value="%{employee.parentEmployee.employeeName}"></s:textfield>
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
