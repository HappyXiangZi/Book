<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@page import="java.sql.*" %>
<html>
<head>
  <title>ͼ���б�</title>
</head>
<body>
 <table  bgcolor=lightgrey>
<tr><td>ISBN</td><td>����</td><td>�汾</td><td>����ʱ��</td><td>�۸�</td></tr> 
<% 
 Class.forName("com.mysql.jdbc.Driver");
 String url="jdbc:mysql://localhost:3306/books?useUnicode=true&characterEncoding=UTF-8";
 Connection dbCon= DriverManager.getConnection(url,"root","123");
 Statement stmt=dbCon.createStatement();   
   ResultSet rs = stmt.executeQuery("select * from titles");
   while (rs.next()) {
 %>
      <tr  bgcolor=cyan>
      <td> <%=rs.getString(1) %> </td>
      <td> <%=rs.getString(2)%> </td>
      <td><%=rs.getInt("editionNumber") %></td>
       <td><%=rs.getInt(4) %></td>
      <td><%=rs.getDouble("price") %></td>
      </tr>
      <%
        }
        rs.close();
        stmt.close();
		dbCon.close();
      %>
</table>
</body>
</html>
