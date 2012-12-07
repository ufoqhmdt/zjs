function reload() {
	jQuery("#employeeList").jqGrid('setGridParam', {
		page : 1,
		url : commonQuery
	}).trigger("reloadGrid");
}
function reset(){
	$("#employeeName").attr("value",'');
	$("#employeeMobile").attr("value",'');
	reload();
}
function searchEmployee(){
	var employeeName=$("#employeeName").val();
	var employeeMobile=$("#employeeMobile").val();
	var url = ctxPath+ "/common/entityList.action?entityName=Employee";
		url=url+"&queryConditions[\"employeeName\"]="+ employeeName+"&queryConditions[\"employeeMobile\"]="+ employeeMobile;
	jQuery("#employeeList").jqGrid('setGridParam', {
		page : 1,
		url : url
	}).trigger("reloadGrid");
}
function updateEmployee(employeeID){
	var url=ctxPath+"/employee/prepareUpdate.action?employeeID="+employeeID;
	window.location.href=url;
}
function deleteEmployee(employeeID){
	if (!confirm("确认删除吗?")) {
		return;
	}
	jQuery.ajax( {
		url : ctxPath+"/employee/delete.action",
		data : {
		"employeeID":employeeID
	},
	type : 'POST',
	dataType : 'json',
	success : function(res) {
		var result = res.result;
		if (result == "success") {
			//highColuAlert('删除成功！');
			reload();
		} 
	},
	error : function() {
		//highColuAlert('操作失败,Ajax调用错误,请联系管理员');
		alert("删除失败，请确认您的操作无误！");
	}
	});
}
function addEmployee(){
	window.location.href=ctxPath+"/employee/employeeAdd.jsp";
}
function assignPermisson(employeeID){
		window.location.href=ctxPath+"/user_competence/displayUserOwnedRoles.action?userID="+employeeID;
}
function parentEmployeeSelect(){
		var url = ctxPath + "/doctor/employeeSelectForm.jsp" ;
		//url,wIDth,height
		var returnValueObject= showInputDialog(url,525, 465);
		if(returnValueObject){
			$("#parentEmployeeName").val(returnValueObject.employeeName);
			$("#parentEmployeeID").val(returnValueObject.employeeID);
		}
}
function regionSelect(){
	var url = ctxPath + "/doctor/regionSelectForm.jsp" ;
		//url,wIDth,height
		var returnValueObject= showInputDialog(url,480, 480);
			if(returnValueObject){
			$("#regionName").val(returnValueObject.regionName);
			$("#regionID").val(returnValueObject.regionID);
		}
}