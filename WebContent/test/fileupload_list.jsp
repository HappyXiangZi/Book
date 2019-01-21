<%@ page contentType="text/html; charset=utf-8" import="java.io.*" %>
<html>
<head>
	<title>文件目录</title>
</head>
<body>
<font size=4 color=red>已上传的文件目录列表</font><br>
<font size=5 color=blue>
<%
  String path = "d:/upfile";
    File fl = new File(path);
	File filelist[] = fl.listFiles();
	out.println("服务器上上传文件的保存路径："+path+"<br><br>"); 
	for(int i=0; i < filelist.length; i++)
	{
	  out.println((i+1)+":"+filelist[i].getName()+"&nbsp;&nbsp;<br>");
	  //如果是图片文件，可用以下语句显示图片。
	  //out.println("<img src=images\\"+filelist[i].getName()+"><br><br>");
	}
%>

</body>
</html>
