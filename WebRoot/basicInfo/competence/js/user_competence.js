function reload() {
	jQuery("#roleForUserList").jqGrid('setGridParam', {
		page : 1,
		url : commonQuery
	}).trigger("reloadGrid");
}
function reset(){
	$("#roleSimp").attr("value",'');
	reload();
}
function searchRoleForUser(){
	var roleName=$("#roleSimp").val();
	var url = ctxPath+ "/common/entityList.action?entityName=RoleForUser";
	if(roleName){
		url=url+"&queryConditions[\"roleSimp\"]="+ roleName;
	}
	jQuery("#roleForUserList").jqGrid('setGridParam', {
		page : 1,
		url : url
	}).trigger("reloadGrid");
}
function updateRoleForUser(roleID){
	var url=ctxPath+"/user_competence/displayRoleOwnedMenus.action?roleID="+roleID;
	window.location.href=url;
}
function deleteRoleForUser(rolecID){
	if (!confirm("确认删除吗?")) {
		return;
	}
	window.location.href=ctxPath+"/user_competence/deleteRoleForUser.action?roleID="+rolecID;
}
function addRoleForUser(){
	window.location.href=ctxPath+"/user_competence/getAllMenu.action";
}