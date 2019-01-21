<%@page import="bean.TraceLogger"%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=utf-8" %>
<jsp:useBean id="db" class="bean.DBcon" scope="request"/>
<html>
<head>
	<title>登录验证页面[checkUser.jsp]</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");//解决post提交的中文乱码
    String name=request.getParameter("loginName");  
    String password=request.getParameter("password"); 
    String checkcode=request.getParameter("checkcode");
    String piccode=request.getSession().getAttribute("piccode").toString();
%>
           你输入的用户名是：<%=name %><br><br>
<%
	Connection con =db.getConnection();
	Statement stmt = con.createStatement();
	String sql="select * from userinfo";  //对userinfo表的查询
	sql+= " where loginname='"+name+"' and password='"+password+"'";
	ResultSet rs = stmt.executeQuery(sql); 
	
	
	if (checkcode.equals(piccode)) 	//验证通过
	{ 
		if (rs.next()) 	//验证通过
		{ 
		    session.setAttribute("userName",name); //将用户名保存到session中
	        response.sendRedirect("main.jsp");
		    TraceLogger.info(name+" 登录成功！");
		 }
		
	   else {  //验证未通过
	       out.print("无此用户或密码有误，登录失败！<br><br>");
	       out.print("<a href='index.jsp'>重新登录<//a>");
	    } 
	 }else {  //验证未通过
       out.print("<font color=red>遗憾！验证码错误有误，登录失败！</font><br>");
       out.print("<a href='index.jsp'>重新登录<//a>");
    } 

%>
</body>
</html>
