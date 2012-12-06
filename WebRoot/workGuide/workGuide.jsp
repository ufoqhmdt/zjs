<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="/commons/jsp/common_head.jsp"%>
<html>
  	<head>
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/common_legal.css'/>" />
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/common_job.css'/>" />
		<link type="text/css" rel="stylesheet"
			href="<s:url value='/commons/css/enterprise_news.css'/>" />
			<script>
var max_page = 0;
jQuery(document).ready(function() {
	/*新闻内容获取*/
	getNewsList(0);
});
function getNewsList(page) {
	var newsUrl = ctxPath
			+ "/common/entityList.action?entityName=News&queryConditions[\'status\']=1&rows=10&queryConditions[\'queryType\']=10&page="
			+ page;
	jQuery.ajax( {
		url : newsUrl,
		type : "POST",
		dataType : "json",
		success : function(res) {
			var newsHtml = "";
			$.each(res.dataRows, function(index, value) {
				if (value.title.length > 20) {
					value.title = value.title.substring(0, 20);
				}
				newsHtml = newsHtml + "<li><span>" + value.publishTime
						+ "</span><a href='../news/lookDetailGuide.action?id="
						+ value.id + "'>" + value.title
						+ "</a></li><div class='corporate_line'></div>";
			});
				$("#guide").html(newsHtml);
							if (max_page == 0) {
				max_page = res.total;
				$('.pagination').jqPagination( {
					max_page : max_page,
					paged : function(page) {
						getNewsList(page);
					}
				});
			}
		},
		error : function() {
			alert("操作失败,Ajax调用错误,请联系管理员");
		}
	});
}
</script>
	</head>
  <body>
  <!--个人中心内容区  -->
		<div id="center_content">
				<!-- 最上面导航 -->
				<div id="job_navigator">
					<span>您的位置：</span>
					<span onclick="redirectToURL('/index.jsp')" class=cursorPoint>首页&nbsp;>> </span>
					 <span >&nbsp;办事指引</span>
				</div>
				<div id="job_line">
					
				</div>
				<!-- 大厅主内容 -->
				<div id="main_content">
						<div id="content_logo">
							<img src="<s:url value='/commons/images/guidance.jpg'/>" />
						</div>
						<div  class=job_div>
								<div  class=job_descript_info style="top:2px;">
									<img src="<s:url value='/commons/images/partner.png'/>" />
									<span>办事指引</span>
								</div>
								<div  class=job_content style="height:180px;" id="guide">
			
								</div>	
								<div class="gigantic pagination"
										style="position: relative; float: right; top: 150px;">
										<a href="#" class="first" data-action="first">&laquo;</a>
										<a href="#" class="previous" data-action="previous">&lsaquo;</a>
										<input type="text" readonly="readonly"
											style="font-size: 14px; border: none; text-align: center; vertical-align: middle;" />
										<a href="#" class="next" data-action="next">&rsaquo;</a>
										<a href="#" class="last" data-action="last">&raquo;</a>
								</div>
					  </div>
				</div>
		</div>
  </body>
</html>
