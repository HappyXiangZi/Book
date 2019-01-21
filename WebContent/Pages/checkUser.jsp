<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="db" class="bean.DBcon" scope="request"></jsp:useBean>
<html>
<head>
	<title>登录验证页面[checkUser.jsp]</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");//解决post提交的中文乱码
    String name=request.getParameter("loginName");  
    String password=request.getParameter("password"); 
    String realCode = (String)request.getSession().getAttribute("code");
    String inputCode = request.getParameter("inputcode");
%>
           你输入的用户名是：<%=name %><br><br>
<%
	Connection con =db.getConnection();
	Statement stmt = con.createStatement();
	String sql="select * from userinfo";  //对userinfo表的查询
	sql+= " where loginname='"+name+"' and password='"+password+"'";
	ResultSet rs = stmt.executeQuery(sql); 
	if(realCode.equals(inputCode)){
		if (rs.next()) 	//验证通过
		{ 
		    session.setAttribute("userName",name); //将用户名保存到session中
	        response.sendRedirect("main.jsp");
		 }
		
	   else {  //验证未通过
	       out.print("无此用户或密码有误，登录失败！<br><br>");
	       out.print("<a href='index.html'>重新登录<//a>");
	    } 
	}else{
		out.print("验证码错误");
	}
%>
</body>
</html>
