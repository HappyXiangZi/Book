<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@page import="bean.DBcon,java.sql.*,java.util.*" %>
<html>
<head>
  <title>数据库表信息</title>
</head>
<body>
<% 
   Connection con=DBcon.getConnection();
   Statement stmt=con.createStatement();
   DatabaseMetaData dbmd=con.getMetaData();
    //ResultSet rs=dbmd.getCatalogs();//获取类别   
    //ResultSet rs=dbmd.getSchemas(); //获取模式      
   String types[]={"TABLE","VIEW"};   
   ResultSet rs=dbmd.getTables("books", null, null, types);//获取MySQL表信息       
   //以下部分为结果集解析  
   ResultSetMetaData rsmd=rs.getMetaData();   
   int size=rsmd.getColumnCount();   
     while(rs.next())   
       {   
         for(int i=1;i<=size;i++) out.print(rsmd.getColumnName(i)+":"+ rs.getString(i)+" ");   
            out.print("<br>");   
        }   
        DBcon.closeResultSet(rs);
		DBcon.closeConnection(con);
      %>
</body>
</html>
