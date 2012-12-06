function showInputDialog(url, width, height) {
	var style = "status:0;scroll:no;help:no;resizable:yes";
	style += ";dialogWidth:" + width + "px;dialogHeight:" + height + "px";
	var args = {
		"document" : document,
		"dialog" : "dialog",
		"self" : self
	};
	return showModalDialog(url, args, style);
}
function showInputDialogScrollable(url, width, height) {
	var style = "status:0;scroll:yes;help:no;resizable:yes";
	style += ";dialogWidth:" + width + "px;dialogHeight:" + height + "px";
	var args = {
		"document" : document,
		"dialog" : "dialog",
		"self" : self
	};
	return showModalDialog(url, args, style);
}

function showInputDialogScrollable(url, wb, width, height) {
	var style = "status:0;scroll:yes;help:no;resizable:yes";
	style += ";dialogWidth:" + width + "px;dialogHeight:" + height + "px";
	var args = {
		"document" : document,
		"dialog" : "dialog",
		"self" : self,
		"webbrowser" : wb
	};
	return showModalDialog(url, args, style);
}
