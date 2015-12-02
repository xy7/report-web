<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>show tables</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<table border="1">
<br/><br/>${tableName}<br/><br/>
<tr bgcolor=#999999>
	<c:forEach items="${columnList}" var="it">
	<th>${it.columnComment}</th>
	</c:forEach>
	<th>operate</th>
</tr>
<tr>
<form action="editTableRow/insert" method="post" >
<c:forEach items="${columnList}" var="it">
<td><input type="text" name="${it.columnName}" value="" ></td>
</c:forEach>
<input type="hidden" name="tableName" value="${tableName}"/>
<td><input type="submit" value="add" /></td>
</form>
</tr>
<%
	List<String> columnList = (List<String>)request.getAttribute("columnList");

	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("dataList");
	String tableName = (String)request.getAttribute("tableName");

	for(int i=0;i<list.size();i++){
		out.println("<tr><form action=\"\" method=\"post\" >");
		Map<String, Object> m = list.get(i);
		
		Iterator<String> it = m.keySet().iterator();
		while(it.hasNext()){
			String colName = it.next();
			if(colName.equals("_id"))
				continue;
			
			Object value = m.get(colName);
			out.println("<td><input type=\"text\" name=\"" + colName + "\" value=\"" + value + "\">");
			out.println("</td>");
		}
		out.println("<input type=\"hidden\" name=\"tableName\" value=\"" + tableName + "\"/>");
		out.println("<input type=\"hidden\" name=\"_id\" value=\"" + m.get("_id") + "\"/>");
		out.println("<td><input type=\"submit\" value=\"update\" onclick=\"this.form.action='editTableRow/update';this.form.submit();\" />"
			+ "<input type=\"submit\" value=\"delete\" onclick=\"this.form.action='editTableRow/delete';this.form.submit();\" /> </td></form></tr>");
	}
%>
</table>
</body>
</html>
