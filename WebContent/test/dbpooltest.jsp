<%@ page language="java" import="java.util.*,java.sql.*,javax.naming.*,javax.sql.DataSource" 
pageEncoding="utf-8"%>
<html>
    <body>
<table  bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>出版时间</td><td>价格</td></tr> 
      <%
       InitialContext ctx;  
       PreparedStatement pstmt = null;  
       Connection conn = null;  
       String sql = "select * from titles";  
         ctx = new InitialContext();              
         DataSource ds=(DataSource)ctx.lookup("java:comp/env/jdbc/booksdb");  
         conn = ds.getConnection();  
         pstmt = conn.prepareStatement(sql);  
         ResultSet rs = pstmt.executeQuery();  
         out.println("使用数据库连接池访问图书表的结果<br>");  
         while (rs.next()) {
 %>
      <tr  bgcolor=cyan>
      <td> <%=rs.getString(1) %> </td>
      <td> <%=rs.getString(2)%> </td>
      <td><%=rs.getInt("editionNumber") %></td>
       <td><%=rs.getInt(4) %></td>
      <td><%=rs.getDouble("price") %></td>
      </tr>
<%} 
    conn.close();
    conn=null;
%>
   </body>
</html>
