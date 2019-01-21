<%@ page contentType="text/html;charSet=GBK" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>用户名</title>
<script language="javascript" type="">
	function RegsiterSubmit(){  //对用户名和密码文本框进行不为空的校验函数
		with(document.Regsiter){  
			var user=loginName.value;   //相当于document.Regsiter. var user=loginName.value;
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
</head> 
<body>
<form method="post" name="Regsiter" action="chechUser1.jsp" target=>
  <p align="left">
  用户名:<input type="text" name="loginName" size="20"></p>
  <p align="left">
  密&nbsp; 码:<input type="password" name="password" size="20"></p>
  <p align="left">
  <input type="button" value="提交" name="B1" onclick="RegsiterSubmit()">
  <input type="reset" value="重置" name="B2"></p>
</form>
</body>
</html>
