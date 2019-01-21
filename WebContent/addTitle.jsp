<%@ page language="java"  pageEncoding="GBK"  contentType="text/html;charset=gbk"%>
<html>
  <head>
    <title>添加图书页面</title>
  </head>
  <body>
    <h1>添加图书</h1>
    <form method="post" action="./DoAddTitle">
    <table>
   	 <tr><td>Isbn号</td><td><input type="text" name="isbn"/></td></tr>
     <tr><td>书名</td><td><input type="text" name="title"/></td></tr>
     <tr><td>版本号</td><td><input type="text" name="editionNumber"/></td></tr>
     <tr><td>出版商ID</td><td><input type="text" name="publisherId"/></td></tr>
     <tr><td>价格</td><td><input type="text" name="price"/></td></tr>
     <tr><td>出版时间</td><td><input type="text" name="copyright"/></td></tr>
     <tr><td><input type="submit" value="添加"/></td></tr>
    </table>
   </form>
  </body>
</html>
	