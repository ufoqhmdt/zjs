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
	src="<s:url value='/region/js/regionManage.js'/>"></script>
	
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
		<s:form action="region/add.action" method="post">
		<div class="search">
			<div align="right">
					<button class="blue" type="button"
						onclick="javascript:history.go(-1)">
						<s:text name="返回" />
					</button>
				</div>
			<fieldset>
				<legend>
					<font style="color:#6D93AB; font-weight:bold;"><s:text
							name="区域管理" /> </font>
				</legend>
				<div align="center">
					<label><s:text name="区域类型"></s:text></label>
					<s:select name="region.regionType" list="#{1:'大区',2:'地区',3:'医院',4:'科室'}"  label="abc" listKey="key" listValue="value"  headerKey="0" headerValue=""/>
				</div>
				<div align="center">
					<label><s:text name="区域名称"></s:text></label>
					<s:hidden name="region.regionID"></s:hidden>
					<s:textfield name="region.regionName"></s:textfield>
				</div>
					<div align="center">
					<label><s:text name="编号"></s:text></label>
					<s:textfield name="region.hospitalNumber"></s:textfield>
				</div>
				<div align="center">
					<label><s:text name="上级区域"></s:text></label>
					<s:hidden name="region.parentID"></s:hidden>
					<s:textfield name="region.parentRegion.regionName" readonly="true"></s:textfield>
				</div>
				<div align="center">
					<button class="blue" style="cursor:pointer" type="submit" id="saveButton">
						<s:text name="保存" />
					</button>
					<button class="blue" style="cursor:pointer" type="submit" id="updateButton">
						<s:text name="修改" />
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
