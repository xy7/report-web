<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>show tables</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

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
	<br/><br/>${message}<br/><br/>
	<table>
	<c:forEach items="${list}" var="it">
	<tr>
		<td>${it.tableComment}</td>
		<td><form action="/editTableData/${it.tableName}" method="get">
			<input type="submit" value="edit data" />
		</form></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
