<#include "/macro.ftl"/>

<!-- 父模板，用于其它报表继承 -->

<!DOCTYPE html>
<html lang="en">
<head>
	<@renderHtmlHead/>
</head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<body>
	<@block name="html">
		<div class="report-query">
			<form id="queryForm" action="${ctx}/ReportEngine/report" method="post">
				<input id="reportPath" name="reportPath" value="${reportPath}" type="hidden"/>
				<input id="ctx" value="${ctx}" type="hidden"/>
				<@renderParams report.params/>
			</form>
		</div>
		
		<@block name="body">
			<div class="panel panel-default">
				<@renderBoxHeader "图形" kpis />
				<@renderTabs report.charts/>
			</div>
			
			<div class="panel panel-default">
				<@renderBoxHeader "明细数据" kpis />
				<@renderTabs report.tables/>
			</div>
		</@block>  
	</@block>  
</body>
</html>


