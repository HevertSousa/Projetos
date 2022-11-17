<%-- 
    Document   : form_gerenciar_menu_perfil
    Created on : 27/10/2018, 17:24:53
    Author     : Ygor
--%>

<%@page import="modelo.PerfilDAO"%>
<%@page import="modelo.Menu"%>
<%@page import="modelo.Perfil"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Perfil p = new Perfil();
  ArrayList<Menu> menusNaoPerfil = new ArrayList<Menu>();
 try{
     int id = Integer.parseInt(request.getParameter("id"));
     PerfilDAO pDAO = new PerfilDAO();
     p = pDAO.carregarPorId(id);
     menusNaoPerfil = pDAO.menusNaoPerfil(id);
 }catch(Exception e){
     out.print("Erro:"+e);
 }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciando Menus Perfil</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
         <h1>Gerenciando Menus Perfil</h1>
        <form action="gerenciar_menu_perfil.do" method="post">
            <input type="hidden" name="op" value="vincular"/>
            <input type="hidden" name="perfil_id" value="<%=p.getId() %>"/>
            ID:<%=p.getId() %>   Nome:<%=p.getNome() %><br/>
            Menu:<select name="menu_id" size="1" required>
                <option value="">Selecione...</option>
                <%
                for(Menu m:menusNaoPerfil){
                %>
                <option value="<%=m.getId() %>"><%=m.getTitulo() %></option>
                <%
                }
                %>
            </select>
            <input type="submit" value="+"/>
        </form>
           <h1>Menus Vinculados</h1>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>TÍTULO</td>
                    <td>DESVINCULAR</td>
                </tr>
                <%
                for(Menu mp:p.getMeusMenus()){
               
                %>
                <tr>
                    <td><%=mp.getId() %></td>
                    <td><%=mp.getTitulo() %></td>
                    <td align="center"><a href="gerenciar_menu_perfil.do?op=desvincular&perfil_id=<%=p.getId() %>&menu_id=<%=mp.getId() %>">X</a></td>
                </tr>
                <%
                }
                
                %>
               
            </table>  
    </body>
</html>
