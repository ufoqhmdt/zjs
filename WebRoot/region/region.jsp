<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/commons/jsp/common_head.jsp"%>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="<s:url value='/commons/css/commons.css'/>" />
    <link type="text/css" rel="stylesheet" href="<s:url value='/commons/css/layer.css'/>" />
    <link rel="stylesheet" href="<s:url value='/commons/plugin/zTree/css/zTreeStyle/demo.css'/>" type="text/css"/>
	<link rel="stylesheet" href="<s:url value='/commons/plugin/zTree/css/zTreeStyle/zTreeStyle.css'/>" type="text/css"/>
    <script type="text/javascript" src="<s:url value='/region/js/region.js'/>"></script>
    <script type="text/javascript" src="<s:url value='/commons/plugin/zTree/js/jquery-1.7.2.min.js'/>"></script>
	<script type="text/javascript" src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.core-3.2.js'/>"></script>
	<script type="text/javascript" src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.excheck-3.2.js'/>"></script>
	<script type="text/javascript" src="<s:url value='/commons/plugin/zTree/js/jquery.ztree.exedit-3.2.js'/>"></script>
  	<SCRIPT type="text/javascript">
  		
		var setting = {
			view: {
				addHoverDom: addHoverDom,
				removeHoverDom:removeHoverDom
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
				beforeDrop: beforeDrop,
				onDrop: onDrop
			}
		};
		var zo;
		function beforeDrop(treeId, treeNodes, targetNode, moveType) {
			var level = targetNode.level;
			var topLevel = <%=com.jung.common.Constants.DEFAULT_REGION_MAX_LAYER%>;
			var topInt = <%=com.jung.common.Constants.DEFAULT_REGION_MAX_TOP%>;
			if(level==0){
				if(moveType!="inner"){
					var currentLevel = treeNodes[0].level;
					if(currentLevel==0)
						return true;
					//alert(currentLevel);
					if(checkTree()>=topInt){
						alert("一级菜单不能大于 : "+topInt);
						return false;
					}
				}
			}else{
				var msg  = "菜单层级最多为 "+(topLevel)+" 层";
				if(moveType=="inner")
					topLevel = topLevel-1;
				if(level>=topLevel){
					alert(msg);
					return false;		
				}
			}
			return true;
		};
		function checkTree(){
			var treeObj = $.fn.zTree.getZTreeObj("menuTree");
			var nodes = treeObj.getNodesByParam("parentID", "0", null);
			return nodes.length;
		}
		function onDrop(event, treeId, treeNodes, targetNode, moveType) {
			var treeObj = $.fn.zTree.getZTreeObj("menuTree");
			var nodes = treeObj.transformToArray(treeObj.getNodes());
			var treeStr = JSON.stringify(nodes);
			jQuery.ajax({
				url : ctxPath + "/region/oneKey.action",
				data : {
					"regionJson" : treeStr
				},
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					if(res.result=="success"){
						/* alert("保存成功."); */
						//window.location.href=ctxPath+"/wMenu/wmenu.jsp";
					}else{
						alert("修改失败.");
					}
				},
				error : function() {
					alert("操作失败,可能是登录信息已缺失.");
				}
			});
		};
		
		function beforeRemove(treeId, treeNode) {
			if(confirm("确认删除 菜单 -- " + treeNode.regionName + " 吗？")){
			}
		}
		
		function addHoverDom(treeId, treeNode) {
			var sObj = $("#" + treeNode.tId + "_span");
			if (treeNode.editNameFlag || $("#addBtn_"+treeNode.id).length>0) return;
			var viewStr = "<span class='button edit' id='viewBtn_" + treeNode.id
				+ "' title='查看区域' onfocus='this.blur();'></span>";
			var editStr = "<span class='button edit' id='editBtn_" + treeNode.id
				+ "' title='修改区域' onfocus='this.blur();'></span>";
			var addStr = "<span class='button add' id='addBtn_" + treeNode.id
				+ "' title='添加区域' onfocus='this.blur();'></span>";
			var delStr = "<span class='button remove' id='delBtn_" + treeNode.id
				+ "' title='删除区域' onfocus='this.blur();'></span>";
			if(treeNode.regionID!=0){
				sObj.after(viewStr+editStr+addStr+delStr);
			}else{
				sObj.after(addStr);
			}
			//查看按钮事件绑定
			var btn = $("#viewBtn_"+treeNode.id);
			if (btn) btn.bind("click", 
				function(){
					window.location.href=ctxPath+"/region/view.action?regionID="+treeNode.regionID;
			});
			//修改按钮事件绑定
			var btn = $("#editBtn_"+treeNode.id);
			if (btn) btn.bind("click", 
				function(){
					window.location.href=ctxPath+"/region/prepareUpdate.action?regionID="+treeNode.regionID;
			});
			//添加按钮事件绑定
			var btn = $("#addBtn_"+treeNode.id);
			if (btn) btn.bind("click", 
				function(){
					var tempURL = ctxPath+"/region/add.action?parentStr="+treeNode.regionID;
			    	window.location.href=tempURL;
			});
			//删除按钮事件绑定
			var btn = $("#delBtn_"+treeNode.id);
			if (btn) btn.bind("click",
				function(){
					if(!treeNode.isParent){
						if(confirm("确认删除区域 [" + treeNode.regionName + "] 吗？")){
							jQuery.ajax({
								url : ctxPath + "/region/delete.action",
								data : {
									"regionID" : treeNode.regionID
								},
								type : 'POST',
								dataType : 'json',
								success : function(res) {
									if(res.result=="success"){
										window.location.href=ctxPath+"/region/region.jsp";
									}else{
										alert("删除失败.");
									}
								},
								error : function() {
									alert("操作失败,可能是登录信息已缺失.");
								}
							});
						}
						
					}else{
						alert("只能删除叶子节点");
					}
			});
		};
		function removeHoverDom(treeId, treeNode) {
			$("#viewBtn_"+treeNode.id).unbind().remove();
			$("#editBtn_"+treeNode.id).unbind().remove();
			$("#addBtn_"+treeNode.id).unbind().remove();
			$("#delBtn_"+treeNode.id).unbind().remove();
		};
		function saveTree() {
			var treeObj = $.fn.zTree.getZTreeObj("menuTree");
			var nodes = treeObj.transformToArray(treeObj.getNodes());
			var treeStr = JSON.stringify(nodes);
			jQuery.ajax({
				url : ctxPath + "/region/oneKey.action",
				data : {
					"menusJson" : treeStr
				},
				type : 'POST',
				dataType : 'json',
				success : function(res) {
					if(res.result=="success"){
						window.location.href=ctxPath+"/region/region.jsp";
						/* alert("保存成功."); */
					}else{
						alert("保存失败.");
					}
				},
				error : function() {
					alert("操作失败,可能是登录信息已缺失.");
				}
			});
		}
		function expandAll(){
			$.fn.zTree.getZTreeObj("menuTree").expandAll(true);
		}
		function addTopMenu(){
			window.location.href=ctxPath+"/region/add.action?parentStr=0";
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
						//$.fn.zTree.getZTreeObj("menuTree").expandAll(true);
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
.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
	</style>
  </head>
  
  <body>
  <%@include file="/commons/jsp/common_header.jsp"%>
      <div class="contain">
        <div class="content_wrap" style="margin: auto;padding-top: 100px;"">
			<fieldset >
			   <legend><font style="color:#6D93AB; font-weight:bold;"><s:text name="区域管理" /></font></legend>
			   <div>
<%--			   	<input type=hidden name="wContentID" id="wContentID" value="${wContentID}"></input>--%>
				    <div class="zTreeDemoBackground left">
						<ul id="menuTree" class="ztree"></ul>
		        	</div>
					<div align="center">
						<button class="blue" onclick="addTopMenu()">
								<s:text name="添加一级区域" />
						</button>
						<button class="blue" onclick="expandAll()">
								<s:text name="展开所有区域" />
						</button>
					</div>
				</div>
			</fieldset>
        </div>
     </div>
    <%@include file="/commons/jsp/common_footer.jsp"%>
  </body>
</html>
