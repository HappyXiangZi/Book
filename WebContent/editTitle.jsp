<%@ page language="java" import="bean.*" pageEncoding="gbk"%>
<html>
  <head>
    <title>�޸�ͼ��ҳ��</title>
    <%
    	//��request������ȡ������title��ֵ 
        Title title=(Title)request.getAttribute("title");
    %>
  </head>
  <body>
    <h1>�޸�ͼ��</h1>
    <form method="post" action="./DoSaveEditTitle">
    <table>
   	 <tr><td>Isbn��</td>
        <td><input type="text" name="isbn" readOnly="true" 
   	         value="<%=title.getIsbn() %>"/></td>
     </tr>
     <tr><td>����</td><td><input type="text" name="title" 
     value="<%=title.getTitle()%>"/></td></tr>
     <tr><td>����ͼ���ļ�����</td><td><input type="text" name="imageFile" 
     value="<%=title.getImageFile() %>"/></td></tr>
     <tr><td>�汾��</td><td><input type="text" name="editionNumber"
     value="<%=title.getEditionNumber() %>"/></td></tr>
     <tr><td>������ID</td><td><input type="text" name="publisherId" readOnly="true" 
     value="<%=title.getPublisherId() %>"/></td></tr>
     <tr><td>�۸�</td><td><input type="text" name="price" 
     value="<%=title.getPrice()%>"/></td></tr>
     <tr><td>��Ȩ</td><td><input type="text" name="copyright" 
     value="<%=title.getCopyright() %>"/></td></tr>
     <tr><td><input type="submit" value="����"/></td></tr>
    </table>
    </form><br>
    <a href="uploadfile.jsp?isbn=<%=title.getIsbn()%>">�ϴ�ͼ�����ͼƬ�ļ�</a> <br> <br>   
    <a href="uploadfile_show.jsp?isbn=<%=title.getIsbn()%>">�鿴ͼ�����ͼƬ�ļ�</a>
  </body>
</html>
	