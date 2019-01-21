<%@ page language="java"  pageEncoding="utf-8"%>
<%@ page import="bean.*,java.util.*,java.text.*,bean.BookOrder"%>

<html>
	<head>
		<title>订单信息</title>
	</head>
	<body>
		<%
			BookOrder bookOrder = (BookOrder) session.getAttribute("order");
		%>
		订书成功！本次购书订单详细信息如下：<br>
		<%
		Map cart = (Map) session.getAttribute("cart");
		double total = 0;
		if (cart == null || cart.size() == 0)
			out.println("<p>购物车当前为空!</p>");
		else {
			// 创建用于显示内容的变量
			Set cartItems = cart.keySet();
			Object[] isbn = cartItems.toArray();
			Title book;
			CartItem cartItem;
			int quantity;
			double price, subtotal;
	%>
		<table cellSpacing=0 cellPadding=0 width=490 border=1>
			<thead>
				<tr align="center">
					<th>书籍名称</th><th>数量</th><th>价格</th><th>小计</th>
				</tr>
			</thead>
			<%
				int i = 0;
					while (i < isbn.length) {
						// 计算总和
						cartItem = (CartItem) cart.get((String) isbn[i]);
						book = cartItem.getTitles();
						quantity = cartItem.getQuantity();
						price = book.getPrice();
						subtotal = quantity * price;
						total += subtotal;
						i++;
			%>
			<tr>
				<td><%=book.getTitle()%></td>
				<td align="center"><%=quantity%></td>
				<td class="right">
					<%=new DecimalFormat("0.00").format(price)%>
				</td>
				<td class="bold right">
					<%=new DecimalFormat("0.00").format(subtotal)%>
				</td>
			</tr>
			<%
				}
			%>
			<tr>
				<td colspan="4" class="bold right">
					<b>总计： </b><%=new DecimalFormat("0.00").format(total)%>
				</td>
			</tr>
		</table>
		<%
			}
		%>

<br>客户账户信息如下：<br>
		客户名：<%=bookOrder.getUsername()%><BR>
		邮编：<%=bookOrder.getZipcode()%><BR>
		电话：<%=bookOrder.getPhone()%><BR>
		信用卡号：<%=bookOrder.getCreditcard()%><BR>
		购书总额：<%=bookOrder.getTotal()%>
		<BR>
		本书店将及时发货，请注意查收。欢迎再次光临网上书店，谢谢！<br>
		<%
			session.invalidate();
		%>
	</body>
</html>
