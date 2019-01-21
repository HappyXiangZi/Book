<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<jsp:useBean id = "title" class = "bean.Title" scope ="page"/>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <base href="<%=basePath%>">
  </head>
  <body>
       逐个设置Bean对象属性的测试结果：<br>
   <%request.setCharacterEncoding("utf-8"); %>
   <jsp:setProperty name= "title" property = "isbn" param = "paramisbn"/>
   <jsp:setProperty name = "title" property = "title" param = "paramtitle"/>
   <jsp:setProperty name= "title" property="copyright" value="98780010-18-1" />
      书号：<jsp:getProperty name="title" property="isbn"/><br>
      书名：<jsp:getProperty name="title" property="title"/><br>
      版权号：<jsp:getProperty name="title" property="copyright"/>

  </body>
</html>
