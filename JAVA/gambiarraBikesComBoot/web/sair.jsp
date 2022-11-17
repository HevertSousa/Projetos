<%-- 
    Document   : sair
    Created on : 05/11/2018, 22:25:33
    Author     : Ygor
--%>

<%

session.removeAttribute("usuario");
response.sendRedirect("login.jsp");

%>