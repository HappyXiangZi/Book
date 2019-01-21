<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>输入JavaBean的属性</title>
	</head>
	<body>
		提交给bean_test1.jsp的表单:	<br>
		<form action="test\bean_test1.jsp" Method="post"><p>
				输入ISBN:	<input type=text name="paramisbn"><p>
				输入书名 :	<input type=text name="paramtitle">
				<input type=submit value="提交">
		</form>	<hr><p>

			提交给bean_test2.jsp的表单:<br>
		<form action="test\bean_test2.jsp" Method="post"><p>
				输入ISBN:	<input type=text name="isbn"><p>
				输入书名 :	<input type=text name="title">
				<input type=submit value="提交">
		</form>
	</body>
</html>
