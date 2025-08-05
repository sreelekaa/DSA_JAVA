<% 
String uname = request.getParameter("t1");
String pass=request.getParameter("t2");
if(uname.equals(pass))
{
	response.sendRedirect("Sucess.jsp");
}
else
{
	response.sendRedirect("Unsuccess.jsp");
}
%>