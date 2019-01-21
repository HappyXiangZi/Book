<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="bean.*,java.util.*" %>
<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request"/>
<html>
<head>
<title>浏览图书</title>
<!-- 使用userBean动作创建TitleDaoImpl的实例,实例的名字为"dao",作用域为"request" -->
</head>
<body><h1 align="center">浏览图书</h1>
 <table align="center" bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>发布时间</td><td>价格</td>
</tr>
<%
	List list=dao.getTitles();  //得到图书列表
   Title titles=null;
   for(int i=0;i<list.size();i++){
      titles=(Title)list.get(i);  //从list中得到的是一个Object对象,要强制转换为Titles对象
%>
      <tr  bgcolor=cyan><td><a href="./ToViewTitle?isbn=<%=titles.getIsbn() %>" title="图书详情">
      <%=titles.getIsbn() %></a></td>
      <td><%=titles.getTitle() %></td>
      <td><%=titles.getEditionNumber() %></td>
      <td><%=titles.getCopyright()%></td>
      <td><%=titles.getPrice() %>  </td>
      </tr>
      <%
   }
 %>
</table>
</body>
</html>
