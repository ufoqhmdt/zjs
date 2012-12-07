<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
  <head>
	<script
			src="<%=path%>/doctor/js/doctor.js"
			type="text/javascript">
		</script>
  </head>
  
  <body>
<%--    <%@include file="/commons/jsp/page_head.jsp"%>--%>
  <%@include file="/commons/jsp/common_header.jsp"%>
    <div class="contain">
    
    <!-- serach start -->
    	<div class="search">
			<fieldset >
				<legend><font style="color:#6D93AB; font-weight:bold;"><s:text name="查找医师" /></font></legend>
 			<div>
    			<input type="hidden" id="doctorID" name="doctorID" />
    			<label><s:text name="医师名称" /></label>
    			<input type="text" id = "doctorName" name="doctorName"/>
    			<label><s:text name="医师手机" /></label>
    			<input type="text" id = "doctorMobile" name="doctorMobile"/>
    				<button class="blue" style="cursor:pointer" onclick="searchDoctor()"><s:text name="查询"/></button>
    				<button class="blue" style="cursor:pointer" onclick="reset()"><s:text name="清除"/></button>
    			</center>
			</div>
			</fieldset>
		</div>
    
   <!-- search end -->
    <div class="jqgridList">
  	<table id="doctorList"></table>
	<div id="donePager" style="text-align: center">
	</div>
	<button class="blue" style="cursor:pointer" onclick="addDoctor()">
		<s:text name="新建" />
	</button>
	<script type="text/javascript">
var commonQuery = ctxPath + "/common/entityList.action?entityName=Doctor";
jQuery("#doctorList")
		.jqGrid(
				{	
					url : commonQuery,
					datatype : "json",
					colNames : [ "<s:text name='医师ID'/>", "<s:text name='医师名称'/>","<s:text name='医师手机'/>","<s:text name='医师职称'/>","<s:text name=' 医师积分'/>","<s:text name='医师状态'/>","<s:text name='目标科室'/>","<s:text name='关联代表'/>","<s:text name='所属地区'/>","<s:text name='操作类型'/>" ],
					colModel : [ 
					{
						name : 'doctorID',
						index : 'doctorID',
						align : 'center',
					},{
						name : 'doctorName',
						index : 'doctorName',
						align : 'center',
						sortable : true
					},{
						name : 'doctorMobile',
						index : 'doctorMobile',
						align : 'center',
						sortable : true
					},{
						name : 'doctorJobTitle',
						index : 'doctorJobTitle',
						align : 'center',
						sortable : true
					},{
						name : 'doctorPoints',
						index : 'doctorPoints',
						align : 'center',
						sortable : true
					},{
						name : 'doctorStatusMapping',
						index : 'doctorStatusMapping',
						align : 'center',
						sortable : true
					},{
						name : 'doctorTargetDept',
						index : 'doctorTargetDept',
						align : 'center',
						sortable : true
					},{
						name : 'employeeName',
						index : 'employeeName',
						align : 'center',
						sortable : true
					},{
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
						id : "doctorID"
					},
					rowNum : <%=com.jung.common.Constants.DEFAULT_PAGE_SIZE%>,
					rownumbers: true,
					pager : '#donePager',
					sortname : 'doctorID',//默认排序方式
					viewrecords : true,
					sortorder : 'asc',
					caption : '<s:text name='医师'/>',
					multiselect : false,
					height : "280",
					width:"945",
					gridComplete : function() {
						jQuery("#_empty", "#doctorList").addClass(
								"nodrag nodrop");
						jQuery("#doctorList").tableDnDUpdate();
						var ids = jQuery("#doctorList").jqGrid('getDataIDs');
						for ( var i = 0; i < ids.length; i++) {
							var doctorID = ids[i];
							var updateAction="<a href=\"javascript:void(0)\" onclick=updateDoctor("+doctorID+") class=jqgridLinkStyle><s:text name='修改' /></a>";
							var deleteAction="<a href=\"javascript:void(0)\" onclick=deleteDoctor("+doctorID+") class=jqgridLinkStyle><s:text name='删除' /></a>";
							jQuery("#doctorList").jqGrid('setRowData',
									ids[i], {
									act:updateAction+" | "+deleteAction
									});					
						}
						jQuery("#doctorList").closest(".ui-jqgrid-bdiv")
								.css( {
									'overflow' : 'hidden'
								});

					}
				});
</script>
</div>
  </div>
<%--    <%@include file="/commons/jsp/page_buttom.jsp"%>--%>
<%@include file="/commons/jsp/common_footer.jsp"%>
  </body>
</html>
