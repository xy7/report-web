<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Product Analysis System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 默认皮肤 -->
<link id="bs-css" href="${ctx}/css/skin/bootstrap-cerulean.css" rel="stylesheet" media="screen">
<link rel="shortcut icon" href="${ctx}/img/favicon.ico">
<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

.menu-li {
	height: 25px;
	margin: 10px 0 0 0;
	list-style-type: none;
}

.menu-li a {
	text-decoration: none;
}
.on-click{
font-weight:bold;
color:red;
}
.menu-click{
font-weight:normal;
color:red;
}
.on-menu-click{
font-weight:bold;
color:red;
}
.title{
font-size:15px;
font-weight:bold;
color:#2FABE9;
}
.select-font{
color:#2FABE9;
}
</style>

</head>

<body>
	<!-- 在在dynamic-page.js中，切换皮肤需求引用 -->
	<input type="hidden" id="ctx" value="${ctx}">
	<!-- topbar starts -->
	
	<!-- topbar ends -->
	<div class="container-fluid">
		<div class="row-fluid">

			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">主菜单</li>
						
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>应用</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
									<a href="${ctx}/ReportEngine/report?reportPath=/app/summary/report&app_id=${param.app_id}#" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">概览</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
									<a href="${ctx}/ReportEngine/report?reportPath=/app/app_trend/report&app_id=${param.app_id}#" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">运营报表</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>实时数据</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/realtime/realtime_channel/report&app_id=${param.app_id}&parent_event_id=" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">分渠道实时监控</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/realtime/realtime_server/report&app_id=${param.app_id}&parent_event_id=" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">分服实时监控</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>自定义事件</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/event/event_list/report&app_id=${param.app_id}&parent_event_id=" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">自定义事件</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/event/funnel_list/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">事件转化漏斗</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>渠道</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/channel/channel_list/report&app_id=${param.app_id}&parent_channel_id=" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">渠道概况</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>在线统计</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/online/online_trend/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">在线趋势</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/online/online_struct/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">在线结构</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/online/online_server/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">分服在线</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/online/online_habit/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">在线习惯</span>
										</a>
									</li>
								</ol>
							</li>
							
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>设备机型</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/terminal/device/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">设备机型</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/terminal/screen/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">设备屏幕</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/terminal/area/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">区域</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>付费统计</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/recharge/summary/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">付费概况</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/recharge/server/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">分服付费</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/recharge/dis/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">付费结构</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/recharge/ltv/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">LTV</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>留存统计</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/retained/new_retained/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">新增日留存</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/retained/retained_rate/report&app_id=${param.app_id}" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">留存率</span>
										</a>
									</li>
								</ol>
							</li>
							
							<li class="menu-clazz">
								<a href="javascript:;">
									<i class="${parent.node.icon}"></i>
									<span>后台</span>
								</a>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/tasklog/tasklog_list/report" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">每日任务</span>
										</a>
									</li>
								</ol>
								<ol>
									<li class="menu-li menu-click" id="">
										<a href="${ctx}/ReportEngine/report?reportPath=/st_app_channel_data/report&app_id=${param.app_id}&data_type=ip_city" target="mainFrame">
											<i class="icon-hand-right"></i>
											<span class="hidden-tablet">各种维度数据</span>
										</a>
									</li>
								</ol>
							</li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<!-- left menu ends -->


			<div id="content" class="span10">
				<script type="text/javascript">
					function onLoadIframe(iframe) {
						iframe.height = iframe.contentWindow.document.documentElement.scrollHeight;
					}
				</script>
				<iframe width="100%" id="mainFrame"
					src="${ctx}/ReportEngine/report?reportPath=/app/summary/report&app_id=${param.app_id}" scrolling="auto"
					name="mainFrame" frameborder="0" height="50" padding="0" margin="0"
					onload="onLoadIframe(this)" onreadystatechange="onLoadIframe(this)">
				</iframe>
			</div>
		</div>

		<hr>

		<footer>
			<p class="pull-left">
				&copy; <a href="javascript:void(0)"></a> 2015
			</p>
			<p class="pull-right">
				Powered by: <a href="javascript:void(0)"> 珠海西山居</a>
			</p>
		</footer>

	</div>
	<!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<script src="${ctx}/js/jquery.min.js?version=2.1.1"></script>
	<!-- 在dynamic-page.js中, 用到了jquery-ui的sortable拖曳特效 -->
	<script src="${ctx}/js/jquery-ui.custom.min.js"></script>
	<%-- <script src="${ctx}/js/ReportTools.js"></script> --%>
	<script src="${ctx}/js/bootstrap.min.js"></script>
	<script src="${ctx}/js/dynamic-page.js"></script>

	<script src="/js/highcharts/highcharts.js"></script>
	<script src="/js/highcharts/modules/exporting.js"></script>


	<script src="/js/highcharts/highchartsUtil.js"></script>


    <iframe src="${ctx}/ReportEngine/cleanParamCookies"  style="position:absolute; top:-10px; width:1px; height:1px"/>
</body>
</html>
