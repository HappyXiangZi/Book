<%@ page contentType="text/html; charset=GB2312" import="java.io.*" %>
<html>
<head>
	<title>�ļ�Ŀ¼</title>
</head>
<body>
<font size=4 color=red>���ϴ����ļ�Ŀ¼�б�</font><br>
<font size=5 color=blue>
<%
  String path = "d://upfile";
    File fl = new File(path);
	File filelist[] = fl.listFiles();
	out.println("���������ϴ��ļ��ı���·����"+path+"<br><br>"); 
	for(int i=0; i < filelist.length; i++)
	{
	  out.println((i+1)+":"+filelist[i].getName()+"&nbsp;&nbsp;<br>");
	  //�����ͼƬ�ļ����������������ʾͼƬ��
	  //out.println("<img src=images\\"+filelist[i].getName()+"><br><br>");
	}
%>

</body>
</html>
