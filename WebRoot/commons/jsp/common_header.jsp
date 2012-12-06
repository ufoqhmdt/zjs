<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/commons/jsp/taglibs.jsp"%>
<div id="viewport"></div>
<header class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<div id="zhai-header"
				style="position: relative; margin-bottom: 60px; padding-top: 20px;">

				<div class="span3">
					<h1 class="logo">
						<a href=""><img src="${ctxPath}/commons/img/logo.png" alt="文献宅及送"></a>
					</h1>
				</div>

				<div class="menu span9 pull-right" id="headerTools"
					style="margin-left: 30px;">
					<ul class="menu-list"
						style="margin: 0px; position: relative; left: 570px;">
						<li class="menu-item"><a
							href="//gathercontent.com/how-it-works">设为首页</a></li>
						<li class="menu-item"><a href="//gathercontent.com/features">加入收藏</a>
						</li>
						<li class="menu-item highlight-item"><a
							href="//gathercontent.com/signup">Get Started Now</a></li>
					</ul>
					<form class="navbar-search" style="margin: 0 0 15px 586px;">
						<input type="text" class="search-query" placeholder="输入搜索关键字">
						<a href="//gathercontent.com/login"
							class="btn btn-inverse btn-mini">搜索</a>
					</form>
				</div>
			</div>

			<div>
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="#">中国医师协会</a>
				<div class="nav-collapse collapse">

					<ul class="nav">
						<li class="active"><a href="indexTemplate.html"><i
								class="icon-th-large"></i>网站首页</a></li>
						<li class><a href="#about"><i class="icon-barcode"></i>项目介绍</a>
						</li>
						<li><a href="projectManageTemplate.html"><i
								class="icon-camera"></i>项目管理</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-share"></i>积分兑换 <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="productTemplate.html"><i
										class="icon-glass"></i>积分兑换</a></li>
								<li><a href="#"><i class="icon-glass"></i>兑换产品管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>兑换统计</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-eject"></i>文献资料 <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="literatureTemplate.html"><i
										class="icon-glass"></i>文献资料查看</a></li>
								<li><a href="literaturePeriodManagement.html"><i
										class="icon-glass"></i>文献期数管理</a></li>
								<li><a href="literatureCategory.html"><i
										class="icon-glass"></i>文献类别管理</a></li>
								<li><a href="literatureManagement.html"><i
										class="icon-glass"></i>文献资料管理</a></li>
								<li><a href="literatureUploadManagement.html"><i
										class="icon-glass"></i>文献上传管理</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-warning-sign"></i>活动公告栏
								<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="icon-glass"></i>活动公告栏</a></li>
								<li><a href="#"><i class="icon-glass"></i>活动公告管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>网站公告管理</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-resize-small"></i>人员管理
								<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="icon-glass"></i>医师管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>销售代表管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>人员调度管理</a></li>
							</ul></li>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-retweet"></i>题目管理 <b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="icon-glass"></i>题目管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>答题统计</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="icon-resize-vertical"></i>权限管理
								<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#"><i class="icon-glass"></i>管理员帐户管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>角色管理</a></li>
								<li><a href="#"><i class="icon-glass"></i>用户角色分配</a></li>
								<li><a href="#"><i class="icon-glass"></i>角色权限分配</a></li>
							</ul></li>
					</ul>

				</div>
			</div>
		</div>
	</div>
</header>