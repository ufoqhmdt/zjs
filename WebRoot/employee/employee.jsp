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
  <%@include file="/commons/jsp/common_header.jsp"%>
    <div class="contain">
    
    <!-- serach start -->
    	<div class="search">
			<fieldset >
				<legend><font style="color:#6D93AB; font-weight:bold;"><s:text name="查找代表" /></font></legend>
 			<div>
    			<input type="hidden" id="employeeID" name="employeeID" />
    			<label><s:text name="代表名称" /></label>
    			<input type="text" id = "employeeName" name="employeeName"/>
    			<label><s:text name="代表手机" /></label>
    			<input type="text" id = "employeeMobile" name="employeeMobile"/>
    				<button class="blue" style="cursor:pointer" onclick="searchEmployee()"><s:text name="查询"/></button>
    				<button class="blue" style="cursor:pointer" onclick="reset()"><s:text name="清除"/></button>
    			</center>
			</div>
			</fieldset>
		</div>
    
   <!-- search end -->
    <div class="jqgridList">
  	<table id="employeeList"></table>
	<div id="donePager" style="text-align: center">
	</div>
	<button class="blue" style="cursor:pointer" onclick="addEmployee()">
		<s:text name="新建" />
	</button>
	<script type="text/javascript">
var commonQuery = ctxPath + "/common/entityList.action?entityName=Employee";
jQuery("#employeeList")
		.jqGrid(
				{	
					url : commonQuery,
					datatype : "json",
					colNames : [ "<s:text name='代表ID'/>", "<s:text name='代表名称'/>","<s:text name='代表手机'/>","<s:text name='代表密码'/>","<s:text name='代表积分'/>","<s:text name='代表类型'/>","<s:text name='代表编号'/>","<s:text name='上级代表'/>","<s:text name='所属区域'/>","<s:text name='操作类型'/>" ],
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
					},{
						name : 'password',
						index : 'password',
						align : 'center',
						sortable : true
					},{
						name : 'employeePoints',
						index : 'employeePoints',
						align : 'center',
						sortable : true
					},{
						name : 'employeeTypeMapping',
						index : 'employeeTypeMapping',
						align : 'center',
						sortable : true
					},{
						name : 'employeeNumber',
						index : 'employeeNumber',
						align : 'center',
						sortable : true
					},
					{
						name : 'parentEmployeeName',
						index : 'parentEmployeeName',
						align : 'center',
						sortable : true
					},
					{
						name : 'regionName',
						index : 'regionName',
						align : 'center',
						sortable : true
					},{
						name : 'act',
						index : 'act',
						label : '操作类型',
						width : "300",
						sortable : false,
						align : 'center'
					}],
					jsonReader : {
						root : "dataRows",
						page : "page",
						total : "total",
						records : "records",
						repeatitems : false,
						id : "employeeID"
					},
					rowNum : <%=com.jung.common.Constants.DEFAULT_PAGE_SIZE%>,
					rownumbers: true,
					pager : '#donePager',
					sortname : 'employeeID',//默认排序方式
					viewrecords : true,
					sortorder : 'asc',
					caption : '<s:text name='代表'/>',
					multiselect : false,
					height : "280",
					width:"945",
					gridComplete : function() {
						jQuery("#_empty", "#employeeList").addClass(
								"nodrag nodrop");
						jQuery("#employeeList").tableDnDUpdate();
						var ids = jQuery("#employeeList").jqGrid('getDataIDs');
						for ( var i = 0; i < ids.length; i++) {
							var employeeID = ids[i];
							var updateAction="<a href=\"javascript:void(0)\" onclick=updateEmployee("+employeeID+") class=jqgridLinkStyle><s:text name='修改' /></a>";
							var permissonAction="<a href=\"javascript:void(0)\" onclick=assignPermisson("+employeeID+") class=jqgridLinkStyle><s:text name='权限' /></a>";
							var deleteAction="<a href=\"javascript:void(0)\" onclick=deleteEmployee("+employeeID+") class=jqgridLinkStyle><s:text name='删除' /></a>";
							jQuery("#employeeList").jqGrid('setRowData',
									ids[i], {
									act:updateAction+" | "+permissonAction+" | "+deleteAction
									});					
						}
						jQuery("#employeeList").closest(".ui-jqgrid-bdiv")
								.css( {
									'overflow' : 'hidden'
								});

					}
				});
</script>
</div>
  </div>
    <%@include file="/commons/jsp/common_footer.jsp"%>
  </body>
</html>
