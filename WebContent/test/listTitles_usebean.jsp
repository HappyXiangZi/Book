<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@page import="java.sql.*" %>
<jsp:useBean id="dbcon" class="bean.DBcon" scope="request"/>
<html>
<head>
  <title>图书列表</title>
</head>
<body>
 <table  bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>出版时间</td><td>价格</td></tr> 
<%  
 Connection dbCon= dbcon.getConnection();
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
