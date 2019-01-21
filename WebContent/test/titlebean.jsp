<%@ page contentType="text/html; charset=utf-8"%>
<jsp:useBean id="title" class="bean.Title" scope="page"/>
<html>
<head>
	<title>Hello</title>
</head>
<body>
	<b><center>
	<font size=4 color=red>JSP中使用Java Bean测试</font>
    </center></b>	
    <hr><br>
		<% title.setIsbn("98780011"); 
	       title.setTitle("JSP WEB原理与应用教程");
	    %>
	<i><font size="5">
      图书bean的书号=<%=title.getIsbn()%><br>
      图书bean的书名=<%=title.getTitle()%>
	</font></i>
</body>
</html>
