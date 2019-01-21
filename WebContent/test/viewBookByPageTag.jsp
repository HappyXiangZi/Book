<%@ page language="java" contentType="text/html; charset=utf-8"    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="/WEB-INF/page-common.tld" prefix="page"%>
<html>
<head>
<title>图书列表</title>
</head>
<body><h1 align="center">浏览图书</h1>
<form action="./ToViewBooks">
 <table align="center" bgcolor=lightgrey width="800">
<tr><td>ISBN</td><td>书名</td><td>版本</td><td>发布时间</td><td>价格</td>
</tr>
<c:forEach var="titles" items="${requestScope.pageResult.list}" >
   <tr  bgcolor=cyan><td><a href="./ToViewTitle?isbn=${titles.isbn }" title="单击显示详细信息">
      ${titles.isbn}</a></td>
      <td>${titles.title}</td>
      <td>${titles.editionNumber}</td>
      <td>${titles.copyright}</td>
      <td>${titles.price} </td>
      </tr>
   </c:forEach>
</table>
<table align="center">
<tr><td><page:pager/></td></tr>
 </table>
  </form>
</body>
</html>
