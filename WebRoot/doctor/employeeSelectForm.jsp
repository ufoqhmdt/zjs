<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
<head>
<script
			src="<%=path%>/employee/js/employee.js"
			type="text/javascript">
		</script>
</head>
	<body>
		<div class="search">
			<fieldset>
				<legend>
					<font style="color: #6D93AB; font-weight: bold;"><s:text
							name="查找代表" />
					</font>
				</legend>
				<div>
					<input type="hidden" id="employeeID" name="employeeID" />
					<label>
						<s:text name="代表名称" />
					</label>
					<input type="text" id="employeeName" name="employeeName" style="width:80px"/>
					<label>
						<s:text name="代表手机" />
					</label>
					<input type="text" id="employeeMobile" name="employeeMobile" style="width:80px"/>
					<button class="blue" style="cursor: pointer"
						onclick="searchEmployee()">
						<s:text name="查询" />
					</button>
					<button class="blue" style="cursor: pointer" onclick="reset()">
						<s:text name="清除" />
					</button>
					</center>
				</div>
			</fieldset>
		</div>
		<div class="jqgridList">
			<table id="employeeList"></table>
			<div id="donePager" style="text-align: center">
			</div>
		</div>
		<script type="text/javascript">
function dbClickHandler(id) {
	var rowdata = jQuery("#employeeList").jqGrid('getRowData', id);
	var employeeName = rowdata["employeeName"];
	var returnValueObject = new Object();
	returnValueObject.employeeID = id;
	returnValueObject.employeeName = employeeName;
	window.returnValue = returnValueObject;
	window.close();
}
var commonQuery = ctxPath + "/common/entityList.action?entityName=Employee";jQuery("#employeeList")
		.jqGrid(
				{	
					url : commonQuery,
					datatype : "json",
					colNames : [ "<s:text name='代表ID'/>", "<s:text name='代表名称'/>","<s:text name='代表手机'/>"],
					colModel : [ 
					{
						name : 'employeeID',
						index : 'employeeID',
						align : 'center',
					},{
						name : 'employeeName',
						index : 'employeeName',
						align : 'center',
						sortable : true
					},{
						name : 'employeeMobile',
						index : 'employeeMobile',
						align : 'center',
						sortable : true
					}],
					jsonReader : {
						root : "dataRows",
						page : "page",
						total : "total",
						records : "records",
						repeatitems : false,
						id : "employeeID"
					},
					rowNum : 10,
					recordpos: 'hidden',
					rownumbers: true,
					pager : '#donePager',
					sortname : 'employeeID',//默认排序方式
					viewrecords : true,
					sortorder : 'desc',
					caption : 'DCH型号',
					multiselect : false,
					height : "300",
					width:"450",
					ondblClickRow : dbClickHandler,
					gridComplete : function() {
						jQuery("#_empty", "#employeeList").addClass(
								"nodrag nodrop");
						jQuery("#employeeList").tableDnDUpdate();
						var ids = jQuery("#employeeList").jqGrid('getDataIDs');
						for ( var i = 0; i < ids.length; i++) {
							var dchCarModelID = ids[i];						
						}
						jQuery("#employeeList").closest(".ui-jqgrid-bdiv")
								.css( {
									'overflow' : 'hidden'
								});

					}
				});
</script>
	</body>
</html>