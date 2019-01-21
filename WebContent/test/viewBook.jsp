<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
<title>图书列表</title>
<!-- 使用userBean动作创建TitleDaoImpl的实例，实例的名字为"dao"，作用域为"request" -->
<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request"/>
</head>
<body><h1 align="center">浏览图书</h1>
 <table align="center" bgcolor=lightgrey>
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>发布时间</td><td>价格</td>
</tr>
<c:forEach var="titles" items="${requestScope.dao.titles}" >
   <tr  bgcolor=cyan><td><a href="../toViewTitle1?isbn=${titles.isbn }" title="单击显示详细信息">
      ${titles.isbn}</a></td>
      <td>${titles.title}</td>
      <td>${titles.editionNumber}</td>
      <td>${titles.copyright}</td>
      <td>${titles.price} </td>
    </tr>
   </c:forEach>
</table>
</body>
</html>
