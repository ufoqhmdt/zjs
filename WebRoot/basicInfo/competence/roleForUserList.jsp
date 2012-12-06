<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
  <head>
	<link type="text/css" rel="stylesheet" href="<s:url value='/basicInfo/company/css/company_list.css'/>" />
	<script
			src="<%=path%>/basicInfo/competence/js/user_competence.js"
			type="text/javascript">
		</script>
		<script type="text/javascript" src="<s:url value='/commons/js/commonSelectForm.js'/>"></script>
  </head>
  
  <body>
<%--    <%@include file="/commons/jsp/page_head.jsp"%>--%>
    <div class="contain">
    
    <!-- serach start -->
    	<div class="search">
			<fieldset >
				<legend><font style="color:#6D93AB; font-weight:bold;"><s:text name="查找用户角色" /></font></legend>
 			<div>
    			<input type="hidden" id="roleID" name="roleID" />
    			<label><s:text name="角色名称" /></label>
    			<input type="text" id = "roleSimp" name="roleSimp"/>
    				<button class="blue" style="cursor:pointer" onclick="searchRoleForUser()"><s:text name="查询"/></button>
    				<button class="blue" style="cursor:pointer" onclick="reset()"><s:text name="清除"/></button>
    			</center>
			</div>
			</fieldset>
		</div>
    
   <!-- search end -->
    <div class="jqgridList">
  	<table id="roleForUserList"></table>
	<div id="donePager" style="text-align: center">
	</div>
	<button class="blue" style="cursor:pointer" onclick="addRoleForUser()">
		<s:text name="新建" />
	</button>
	<script type="text/javascript">
var commonQuery = ctxPath + "/common/entityList.action?entityName=RoleForUser";
jQuery("#roleForUserList")
		.jqGrid(
				{	
					url : commonQuery,
					datatype : "json",
					colNames : [ "<s:text name='角色ID'/>", "<s:text name='角色名称'/>","<s:text name='操作类型'/>" ],
					colModel : [ 
					{
						name : 'roleID',
						index : 'roleID',
						align : 'center',
					},{
						name : 'roleSimp',
						index : 'roleSimp',
						editable : true,
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
						id : "roleID"
					},
					rowNum : <%=com.jung.common.Constants.DEFAULT_PAGE_SIZE%>,
					rownumbers: true,
					pager : '#donePager',
					sortname : 'roleID',//默认排序方式
					viewrecords : true,
					sortorder : 'asc',
					caption : '<s:text name='用户角色'/>',
					multiselect : false,
					height : "280",
					width:"945",
					gridComplete : function() {
						jQuery("#_empty", "#roleForUserList").addClass(
								"nodrag nodrop");
						jQuery("#roleForUserList").tableDnDUpdate();
						var ids = jQuery("#roleForUserList").jqGrid('getDataIDs');
						for ( var i = 0; i < ids.length; i++) {
							var rolecID = ids[i];
								+rolecID+")>"+"<s:text name='alter' />"+"</button>";
							var updateAction="<a href=\"javascript:void(0)\" onclick=updateRoleForUser("+rolecID+") class=jqgridLinkStyle><s:text name='修改' /></a>";
								+rolecID+")>"+"<s:text name='delete' />"+"</button>";
							var deleteAction="<a href=\"javascript:void(0)\" onclick=deleteRoleForUser("+rolecID+") class=jqgridLinkStyle><s:text name='删除' /></a>";
							jQuery("#roleForUserList").jqGrid('setRowData',
									ids[i], {
									act:updateAction+" | "+deleteAction
									});					
						}
						jQuery("#roleForUserList").closest(".ui-jqgrid-bdiv")
								.css( {
									'overflow' : 'hidden'
								});

					}
				});
</script>
</div>
  </div>
<%--    <%@include file="/commons/jsp/page_buttom.jsp"%>--%>
  </body>
</html>
