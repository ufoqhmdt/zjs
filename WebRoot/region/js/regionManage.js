var oper = $("#oper").val();

$(document).ready(function() {
	var ps = $("#parentStr").val();
	if ($("#oper").val() != "update") {
		$("#updateButton").hide();
		if ($("#oper").val() == "view") {
			var count = $("#showParent option").length;
			for ( var i = 0; i < count; i++) {
				if ($("#showParent ").get(0).options[i].value == ps) {
					$("#showParent ").get(0).options[i].selected = true;
					break;
				}
			}

			$("#saveButton").hide();
			$("input").attr("disabled", "disabled");
			$("#parentStr").attr("disabled", "disabled");
		}
	} else {
		$("#saveButton").hide();
		var count = $("#showParent option").length;
		for ( var i = 0; i < count; i++) {
			if ($("#showParent ").get(0).options[i].value == ps) {
				$("#showParent ").get(0).options[i].selected = true;
				break;
			}
		}

	}
});

function reLoad() {
	$("#wmenuName").val("");
	$("#wmenuCode").val("");
	$("#wmenuUrl").val("");
	searchCar();
}

/*按条件查询Car*/
function searchCar() {
	var wmenuName = $("#wmenuName").val();
	var wmenuCode = $("#wmenuCode").val();
	var wmenuUrl = $("#wmenuUrl").val();
	var url = ctxPath
			+ "/common/entityList.action?entityName=WMenu&queryConditions[\"wmenuName\"]="
			+ wmenuName + "&queryConditions[\"wmenuUrl\"]=" + wmenuUrl
			+ "&queryConditions[\"wmenuCode\"]=" + wmenuCode;
	jQuery("#carList").jqGrid('setGridParam', {
		page : 1,
		url : url
	}).trigger("reloadGrid");
}
