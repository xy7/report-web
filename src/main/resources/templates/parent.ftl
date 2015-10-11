<!DOCTYPE html>

<html lang="en">
<head>
<tr>Message: ${message}</tr>
<br/>
</head>
<body>
<@block name="body">
	Date: ${time?date}
	<br>
	Time: ${time?time}
	<br>
	Message: ${message}
</@block>
</body>

</html>