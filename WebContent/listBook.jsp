<%@ page language="java" contentType="text/html; charset=gbk" pageEncoding="gbk"%>
<%@page import="bean.*, java.util.*" %>
<jsp:useBean id="dao" class="bean.TitleDaoImpl" scope="request"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>���ά��</title>
</head>
<body>
<h1 align="center">���ά��</h1>
 <table  bgcolor=lightgrey>
<tr><td>ISBN</td><td>����</td><td>�汾</td><td>����ʱ��</td><td>�۸�</td>
</tr>
 
<%
 	List list=dao.getTitles();// �õ�ͼ���б���������list��
    
    Title titles=null;
    for(int i=0;i<list.size();i++){
       titles=(Title)list.get(i);  //��list�еõ�����һ��Object����,Ҫǿ��ת��ΪTitles����
 %>
      <tr  bgcolor=cyan>
      <td><a href="./ToEditTitle?isbn=<%=titles.getIsbn() %>" title="��������༭">
      <%=titles.getIsbn() %></a></td>
      <td> <%=titles.getTitle()%> </td>
      <td><%=titles.getEditionNumber() %></td>
      <td><%=titles.getCopyright()%></td>
      <td><%=titles.getPrice() %>      </td>
      <td><a href="./DoDeleteTitle?isbn=<%=titles.getIsbn()%>">ɾ��</a></td>
      </tr>
      <%
   }
 %>
</table><br>
<a href="addTitle.jsp">���ͼ��</a><br>
 
</body>
</html>
