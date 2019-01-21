<%@ page language="java" import="java.util.*,bean.*" pageEncoding="utf-8"%>
<html>
<head>
<title>书籍信息</title>
<%
	//从session中取出属性名为titles变量的值,要进行强制转换为Titles类型,保持与保存时变量类型一致 
	Title titles = (Title) session.getAttribute("titles");
%>
</head>
<body>
<TABLE style="TEXT-ALIGN: center" cellSpacing="0" cellPadding="0"
	width="590" border="0">
<tr height="100">
	<td colspan="3"><h2>${sessionScope.titles.title}</h2></td>
</tr>
<tr>
	<td rowspan="5">
	<img style="border: thin solid black" width="80" height="120"
		src="images/${sessionScope.titles.imageFile}"
		alt="${sessionScope.titles.title}" />
	</td>
	<td class="bold" align="left">图书编号：</td>
    <td align="left">${sessionScope.titles.isbn}</td>
	</tr>
    <tr align="left">
		<td class="bold" align="left">价格：</td>
		<td align="left">${sessionScope.titles.price}</td>
	</tr>
	<tr align="left">
		<td class="bold">版本号：</td>
		<td>${sessionScope.titles.editionNumber}</td>
	</tr>
	<tr align="left">
		<td class="bold">版权：</td>
		<td>${sessionScope.titles.copyright}</td>
	</tr>
	<tr align="left">
		<td>
		<form method="post" action="./AddTitlesToCart"><p>
			<input type="submit" value="放入购物车" /></p>
		</form>
		</td>
		<td>
		<form method="get" action="viewCart.jsp"><p>
			<input type="submit" value="查看购物车" /></p>
		</form>
		</td>
	</tr>
	</table>
	</body>
</html>
