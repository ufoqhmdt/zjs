function reload() {
	jQuery("#doctorList").jqGrid('setGridParam', {
		page : 1,
		url : commonQuery
	}).trigger("reloadGrid");
}
function reset() {
	$("#doctorName").attr("value", '');
	$("#doctorMobile").attr("value", '');
	reload();
}
function searchDoctor() {
	var doctorName = $("#doctorName").val();
	var doctorMobile = $("#doctorMobile").val();
	var url = ctxPath + "/common/entityList.action?entityName=Doctor";
		url = url + "&queryConditions[\"doctorName\"]=" + doctorName+"&queryConditions[\"doctorMobile\"]=" + doctorMobile;
	jQuery("#doctorList").jqGrid('setGridParam', {
		page : 1,
		url : url
	}).trigger("reloadGrid");
}
function updateDoctor(doctorID) {
	var url = ctxPath + "/doctor/prepareUpdate.action?doctorID="
			+ doctorID;
	window.location.href = url;
}
function deleteDoctor(doctorID) {
	if (!confirm("确认删除吗?")) {
		return;
	}
	jQuery.ajax( {
		url : ctxPath + "/doctor/delete.action",
		data : {
			"doctorID" : doctorID
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
function addDoctor() {
	window.location.href = ctxPath + "/doctor/doctorAdd.jsp";
}
function employeeSelect() {
	var url = ctxPath + "/doctor/employeeSelectForm.jsp";
	//url,wIDth,height
	var returnValueObject = showInputDialog(url, 480, 380);
	if (returnValueObject) {
		$("#employeeName").val(returnValueObject.employeeName);
		$("#employeeID").val(returnValueObject.employeeID);
	}
}
function regionSelect() {
	var url = ctxPath + "/doctor/regionSelectForm.jsp";
	//url,wIDth,height
	var returnValueObject = showInputDialog(url, 480, 380);
	if (returnValueObject) {
		$("#regionName").val(returnValueObject.regionName);
		$("#regionID").val(returnValueObject.regionID);
	}
}