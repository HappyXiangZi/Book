<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
	</head>

	<body>
		<font color="blue" size="3">当前用户:<%=request.getSession().getAttribute("userName") %></font><hr>
       <font color="red" size="4"  style="font-family:simhei">前台系统</font><hr>
		<a href=ToViewBooks target=main>浏览图书</a>
		<br><br>
        <font color="red" size="4"  style="font-family:simhei">后台系统</font>		
        <hr>
		<a href=listBook.jsp target=main>书架维护</a>	
	</body>
</html>
