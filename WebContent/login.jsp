<%@ page contentType="text/html;charSet=GBK" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>�û���</title>
<script language="javascript" type="">
	function RegsiterSubmit(){  //���û����������ı�����в�Ϊ�յ�У�麯��
		with(document.Regsiter){  
			var user=loginName.value;   //�൱��document.Regsiter. var user=loginName.value;
			var pass=password.value;
			if(user==null||user==""){
				alert("����д�û���");
				}
				else if(pass==null||pass==""){
					alert("����д����");
					}
				else submit();
			}
		}
</script>
</head> 
<body>
<form method="post" name="Regsiter" action="chechUser1.jsp" target=>
  <p align="left">
  �û���:<input type="text" name="loginName" size="20"></p>
  <p align="left">
  ��&nbsp; ��:<input type="password" name="password" size="20"></p>
  <p align="left">
  <input type="button" value="�ύ" name="B1" onclick="RegsiterSubmit()">
  <input type="reset" value="����" name="B2"></p>
</form>
</body>
</html>
