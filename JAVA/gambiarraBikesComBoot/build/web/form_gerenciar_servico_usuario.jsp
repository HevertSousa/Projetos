<%-- 
    Document   : form_genrenciar_servico_usuario
    Created on : 27/10/2018, 20:13:40
    Author     : Ygor
--%>

<%@page import="modelo.UsuarioDAO"%>
<%@page import="modelo.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Usuario u = new Usuario();
  ArrayList<Servico> meusNaoServicos = new ArrayList<Servico>();
 try{
     int id = Integer.parseInt(request.getParameter("id"));
     UsuarioDAO uDAO = new UsuarioDAO();
     u = uDAO.carregarPorId(id);
     meusNaoServicos = uDAO.meusNaoServicos(id);
 }catch(Exception e){
     out.print("Erro:"+e);
 }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciando Serviços Usuários</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
       <h1>Gerenciando  Serviços Usuários</h1>
        <form action="gerenciar_servico_usuario.do" method="post">
            <input type="hidden" name="op" value="vincular"/>
            <input type="hidden" name="usuario_id" value="<%=u.getId() %>"/>
            ID:<%=u.getId() %>   Nome:<%=u.getNome() %><br/>
            Serviço<select name="servico_id" size="1" required>
                <option value="">Selecione...</option>
                <%
                for(Servico s:meusNaoServicos){
                %>
                <option value="<%=s.getId() %>"><%=s.getTipo() %></option>
                <%
                }
                %>
            </select>
            <input type="submit" value="+"/>
        </form>
            
             <h1>Serviços Vinculados</h1>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>TIPO</td>
                    <td>PREÇO</td>
                    <td>DESVINCULAR</td>
                </tr>
                <%
                for(Servico su:u.getMeusServicos()){
               
                %>
                <tr>
                    <td><%=su.getId() %></td>
                    <td><%=su.getTipo() %></td>
                     <td><%=su.getPreco() %></td>
                   <td align="center"><a href="gerenciar_servico_usuario.do?op=desvincular&usuario_id=<%=u.getId() %>&servico_id=<%=su.getId() %>">X</a></td>
                </tr>
                <%
                }
                
                %>
                
            </table>  
    </body>
</html>
