<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/jsp/taglibs.jsp"%>
<%@include file="/commons/jsp/common_head.jsp"%>
<body>
	<%@include file="/commons/jsp/common_header.jsp"%>
	<section class="container" id="container">
		<%@include file="index_content.jsp"%><%-- 自定义内容部分 --%>
	</section>
	<%@include file="/commons/jsp/common_footer.jsp"%>
	<script>
			var mycarousel_itemList = [{
				url : ctxPath+"/commons/img/ad01.png",
				title : "Flower1"
			}, {
				url : ctxPath+"/commons/img/ad02.png",
				title : "Flower2"
			}, {
				url : ctxPath+"/commons/img/ad03.png",
				title : "Flower3"
			}, {
				url : ctxPath+"/commons/img/ad04.png",
				title : "Flower4"
			}, {
				url : ctxPath+"/commons/img/ad01.png",
				title : "Flower1"
			}, {
				url : ctxPath+"/commons/img/ad02.png",
				title : "Flower2"
			}, {
				url : ctxPath+"/commons/img/ad03.png",
				title : "Flower3"
			}, {
				url : ctxPath+"/commons/img/ad04.png",
				title : "Flower4"
			}, {
				url : ctxPath+"/commons/img/ad01.png",
				title : "Flower1"
			}, {
				url : ctxPath+"/commons/img/ad02.png",
				title : "Flower2"
			}, {
				url : ctxPath+"/commons/img/ad03.png",
				title : "Flower3"
			}, {
				url : ctxPath+"/commons/img/ad04.png",
				title : "Flower4"
			}, {
				url : ctxPath+"/commons/img/ad01.png",
				title : "Flower1"
			}, {
				url : ctxPath+"/commons/img/ad01.png",
				title : "Flower1"
			}];

			function mycarousel_itemLoadCallback(carousel, state) {
				for (var i = carousel.first; i <= carousel.last; i++) {
					if (carousel.has(i)) {
						continue;
					}

					if (i > mycarousel_itemList.length) {
						break;
					}

					carousel.add(i, mycarousel_getItemHTML(mycarousel_itemList[i - 1]));
				}
			};

			function mycarousel_getItemHTML(item) {
				return '<img src="' + item.url + '" width="75" height="75" alt="' + item.url + '" />';
			};

			jQuery(function() {
				$("#regionProgressContent").sortable();
				$("#regionProgressContent").disableSelection();

				$("#regionProgressContent li").addClass("btn");

				jQuery('#zhaicarousel').jcarousel({
					scroll : 1,
					auto : 3,
					wrap : 'circular',

					size : mycarousel_itemList.length,
					itemLoadCallback : {
						onBeforeAnimation : mycarousel_itemLoadCallback
					}
				});
			})
		</script>
</body>
</html>
