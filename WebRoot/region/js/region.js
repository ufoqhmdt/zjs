/**
 * 跳转到新建装运单页面
 */
function addReserve() {
	window.location.href = ctxPath + "/wMenu/addMenu.action";
}
function reset() {
	$("#regionName").val("");
	$("#menuUrl").val("");
	reload();
}

function reload() {
	var wmenuName = $("#menuName").val();
	var wmenuCode = $("#menuCode").val();
	var wmenuUrl = $("#menuUrl").val();
	var url = ctxPath
			+ "/common/entityList.action?entityName=WMenu&queryConditions[\"wmenuName\"]="
			+ wmenuName + "&queryConditions[\"wmenuUrl\"]=" + wmenuUrl
			+ "&queryConditions[\"wmenuCode\"]=" + wmenuCode;
	jQuery("#quotationList").jqGrid('setGridParam', {
		page : 1,
		url : url
	}).trigger("reloadGrid");
}

function editReserve(reserveID) {
	window.open(ctxPath + "/wMenu/editMenu.action?menu.wmenuID=" + reserveID);
}
function delReserve(reserveID) {
	if (!confirm("确认删除菜单吗?")) {
		return;
	}
	$.ajax({
		type : "POST",
		url : ctxPath + "/wMenu/delMenu.action?menu.wmenuID="+reserveID
	}).done(function(res) {
		if (res.result == "success") {
			alert("删除菜单成功.");
			reload();
		} else {
			alert("删除失败");
		}
	});
}
function viewReserve(reserveID) {
	window.open(ctxPath + "/wMenu/viewMenu.action?menu.wmenuID=" + reserveID);
}