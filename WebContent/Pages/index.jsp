<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script language="javascript" type="">
	function RegsiterSubmit(){  //对用户名和密码文本框进行不为空的校验函数
		with(document.Regsiter){  //为下面语句块中的变量指明所属对象 
			var user=loginName.value;   //相当于 var user=document.Regsiter.loginName.value;
			var pass=password.value;
			if(user==null||user==""){
				alert("请填写用户名");
				}
				else if(pass==null||pass==""){
					alert("请填写密码");
					}
				else submit();
			}
		}
</script>
<%
	int code = (int)(Math.random()*10000);
	String codetostring = Integer.toString(code);
	session.setAttribute("code", codetostring);
%>
</head>
<body>
	<table>
	<tr><td><img SRC=images/top.jpg ></img></td></tr>
	<tr><td align="center">
	<p><font color="red" size="5"  style="font-family:simhei">请登录：</font><p>
	<form method="post" name="Regsiter" action="checkUser.jsp" target="_blank"><p>
                        用户名:<input type="text" name="loginName" size="20">
    <p >
                      密&nbsp; 码:<input type="password" name="password" size="20"></p>
   <p >
    验证码：<input type="text" name="inputcode"><%= code %><br>
  <input type="button" value="提交" name="B1" onclick="RegsiterSubmit()">
  <input type="reset" value="重置" name="B2">
</form>
	
	</td></tr>	
	
	</table>
	</body>
</body>
</html>