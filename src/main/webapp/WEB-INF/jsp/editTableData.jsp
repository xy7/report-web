<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>

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
<table border="1">
<br/><br/>${tableName}<br/><br/>
<tr bgcolor=#999999>
	<c:forEach items="${columnList}" var="it">
		<th>${it.columnComment}</th>
	</c:forEach>
</tr>

<%
	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("dataList");

	for(int i=0;i<list.size();i++){
		out.println("<tr>");
		Map<String, Object> m = list.get(i);
		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()){
			out.println("<td>");
			String colName = it.next();
			out.println(m.get(colName));
			out.println("</td>");
		}
		out.println("</tr>");
	}
%>
</table>
</body>
</html>
