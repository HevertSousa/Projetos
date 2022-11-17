<%-- 
    Document   : menu
    Created on : 05/11/2018, 22:24:42
    Author     : Ygor
--%>

<%@page import="modelo.Menu"%>
<%@page import="modelo.Menu"%>
<%@page import="modelo.Usuario"%>

<%
  try{
  
      Usuario uLogado = (Usuario) session.getAttribute("usuario");
      
      for(Menu mu:uLogado.getPerfil().getMeusMenus()){%>
      <ol  ><li>
              <% out.print("<a id ='menu' href='"+mu.getLink()+"'>"+mu.getTitulo()+"</a> ");%>
          </li><br>
        </ol>  
      <%}%>

      <p id="menu"> <% out.print("  Bem-vindo "+uLogado.getNome());%> </p> 
  <% }catch(Exception e){
      response.sendRedirect("login.jsp");
  }  

%>
