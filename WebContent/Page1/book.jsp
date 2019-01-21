<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="BookBean" class="bean1.BookBean" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookBean</title>
</head>
<body>
	<jsp:setProperty property="ISBN" name="BookBean" value="98991122"/>
	<jsp:setProperty property="title" name="BookBean" value="java web 技术与应用"/>
	书号：<jsp:getProperty property="ISBN" name="BookBean"/><br>
	书名：<jsp:getProperty property="title" name="BookBean"/><br>
</body>
</html>