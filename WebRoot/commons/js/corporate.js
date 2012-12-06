/**
 * 修改岗位信息
 */
function editPost(postId) {
	if (postId != undefined && postId != "") {
		url = ctxPath + "/enterprise/toUpdatePost.action?companyPost.id="
				+ postId;
		window.location = url;
	}
}
/**
* 管理面试，跳转到简历查看页面，修改申请状态
*/
function manageInterview(applyId) {
alert("manage interview with id: " + applyId);
}
	