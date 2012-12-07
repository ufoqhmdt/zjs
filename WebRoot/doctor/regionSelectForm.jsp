<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/common_head.jsp"%>
<html>
	<head>
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/commons.css'/>" />
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/layer.css'/>" />
		<link rel="stylesheet"
			href="<s:url value='/commons/plugin/zTree/css/zTreeStyle/demo.css'/>"
			type="text/css" />
		<link rel="stylesheet"
			href="<s:url value='/commons/plugin/zTree/css/zTreeStyle/zTreeStyle.css'/>"
			type="text/css" />
		<script type="text/javascript"
			src="<s:url value='/region/js/region.js'/>">
</script>
		<script type="text/javascript"
			src="<s:url value='/commons/js/jquery-1.7.2.min.js'/>">
</script>
		<script type="text/javascript"
			src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.core-3.2.js'/>">
</script>
		<script type="text/javascript"
			src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.excheck-3.2.js'/>">
</script>
		<script type="text/javascript"
			src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.exedit-3.2.js'/>">
</script>
		<SCRIPT type="text/javascript">
  		
		var setting = {
			view: {
			
			},
			data: {
				key:{
					name:"regionName"
				},
				simpleData: {
					enable: true,
					idKey:'regionID',
					pIdKey:'parentID',
					rootPId:0
				}
			},
			edit: {
				drag: {
					autoExpandTrigger: true,
					isMove:true,
					inner:true
				},
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			callback: {
				onDblClick:dbClick
			}
		};
		function dbClick(event,treeId,treeNode){
			 var returnValueObject = new Object();
			 returnValueObject.regionID = treeNode.regionID;
			 returnValueObject.regionName = treeNode.regionName;
			 window.returnValue = returnValueObject;
			 window.close();
		}
		$(document).ready(function(){
			//定义节点数组，通过Ajax请求初始化数据
			var zNodes;
			jQuery.ajax({
				url : ctxPath + "/region/list.action",
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					if(res.result=="success"){
						zNodes = res.regions;
						//alert("数据初始化成功!");
					    $.fn.zTree.init($("#menuTree"), setting, zNodes);
					    zo = $.fn.zTree.getZTreeObj("menuTree");
						$.fn.zTree.getZTreeObj("menuTree").expandAll(true);
					}else{
						alert("数据初始化失败!");
					}
				},
				error : function() {
					alert("请求发生错误.");
				}
			});
			
		});
		
	</SCRIPT>
		<style type="text/css">
.ztree li span.button.add {
	margin-left: 2px;
	margin-right: -1px;
	background-position: -144px 0;
	vertical-align: top; *
	vertical-align: middle
}
</style>
	</head>

	<body>
		<div class="contain">
			<div class="search">
				<fieldset>
					<legend>
						<font style="color: #6D93AB; font-weight: bold;"><s:text
								name="地区管理" />
						</font>
					</legend>
					<div>
						<div class="zTreeDemoBackground left">
							<ul id="menuTree" class="ztree"></ul>
						</div>
						<%--  
					<div align="center">
						<button class="blue" onclick="addTopMenu()">
								<s:text name="添加一级区域" />
						</button>
						<button class="blue" onclick="expandAll()">
								<s:text name="展开所有区域" />
						</button>
					</div>
					--%>
					</div>
				</fieldset>
			</div>
		</div>

		<%--     <%@include file="/commons/jsp/page_buttom.jsp"%>	 --%>
	</body>
</html>
