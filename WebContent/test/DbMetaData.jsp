<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@page import="bean.DBcon,java.sql.*,java.util.*" %>
<html>
<head>
  <title>���ݿ����Ϣ</title>
</head>
<body>
<% 
   Connection con=DBcon.getConnection();
   Statement stmt=con.createStatement();
   DatabaseMetaData dbmd=con.getMetaData();
    //ResultSet rs=dbmd.getCatalogs();//��ȡ���   
    //ResultSet rs=dbmd.getSchemas(); //��ȡģʽ      
   String types[]={"TABLE","VIEW"};   
   ResultSet rs=dbmd.getTables("books", null, null, types);//��ȡMySQL����Ϣ       
   //���²���Ϊ���������  
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
