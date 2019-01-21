<%@ page contentType="text/html;charSet=utf-8" pageEncoding="utf-8"%>

<html>
	<head>
		<title>第一个Servlet示例</title>
	</head>
	<body>
		<form method="post" action="../servlet/HelloServlet">
			<p align="left">
				请输入姓名:
				<input type="text" name="name" size="20">
			</p>
			<input type="submit" value="提交">
		</form>
	</body>
</html>
