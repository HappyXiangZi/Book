<%@ page language="java"  pageEncoding="GBK"  contentType="text/html;charset=gbk"%>
<html>
  <head>
    <title>���ͼ��ҳ��</title>
  </head>
  <body>
    <h1>���ͼ��</h1>
    <form method="post" action="./DoAddTitle">
    <table>
   	 <tr><td>Isbn��</td><td><input type="text" name="isbn"/></td></tr>
     <tr><td>����</td><td><input type="text" name="title"/></td></tr>
     <tr><td>�汾��</td><td><input type="text" name="editionNumber"/></td></tr>
     <tr><td>������ID</td><td><input type="text" name="publisherId"/></td></tr>
     <tr><td>�۸�</td><td><input type="text" name="price"/></td></tr>
     <tr><td>����ʱ��</td><td><input type="text" name="copyright"/></td></tr>
     <tr><td><input type="submit" value="���"/></td></tr>
    </table>
   </form>
  </body>
</html>
	