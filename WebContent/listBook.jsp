<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@page import="bean.*, java.util.*" %>
<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>书架维护</title>
</head>
<body>
<h1 align="center">书架维护</h1>
 <table  bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>发布时间</td><td>价格</td>
</tr>
 
<%
 	List list=dao.getTitles();// 得到图书列表至集合类list中
    
    Title titles=null;
    for(int i=0;i<list.size();i++){
       titles=(Title)list.get(i);  //从list中得到的是一个Object对象,要强制转换为Titles对象
 %>
      <tr  bgcolor=cyan>
      <td><a href="./ToEditTitle?isbn=<%=titles.getIsbn() %>" title="单击进入编辑">
      <%=titles.getIsbn() %></a></td>
      <td> <%=titles.getTitle()%> </td>
      <td><%=titles.getEditionNumber() %></td>
      <td><%=titles.getCopyright()%></td>
      <td><%=titles.getPrice() %>      </td>
      <td><a href="./DoDeleteTitle?isbn=<%=titles.getIsbn()%>">删除</a></td>
      </tr>
      <%
   }
 %>
</table><br>
<a href="addTitle.jsp">添加图书</a><br>
 
</body>
</html>
