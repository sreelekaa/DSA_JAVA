<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% import="mypackage.Class" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>heyyy</h1>
<%=25*100 %>
<br/>
<%= new java.util.Date() %>
<br/>
<%
for(int i=0;i<=10;i++){
	out.print(i+"<br/>");
}
%>
<br/>
<%!
int  add(int a,int b)
{
	return(a+b);
}
%>
<br/>
<%= add(100,200) %>
<br/>
<%= mypackage.Class.Multiplication(10,20) %>
</body>
</html>