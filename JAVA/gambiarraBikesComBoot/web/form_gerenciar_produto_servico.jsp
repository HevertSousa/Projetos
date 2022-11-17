<%-- 
    Document   : form_gerenciar_produto_servico
    Created on : 27/10/2018, 18:59:47
    Author     : Ygor
--%>

<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Produto"%>
<%@page import="modelo.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Produto p = new Produto();
  ArrayList<Servico> meusNaoServicos = new ArrayList<Servico>();
 try{
     int id = Integer.parseInt(request.getParameter("id"));
     ProdutoDAO pDAO = new ProdutoDAO();
     p = pDAO.carregarPorId(id);
     meusNaoServicos = pDAO.meusNaoServicos(id);
 }catch(Exception e){
     out.print("Erro:"+e);
 }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <title>Gerenciando Serviços Produtos</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
         <h1>Gerenciando  Serviços Produtos</h1>
        <form action="gerenciar_produto_servico.do" method="post">
            <input type="hidden" name="op" value="vincular"/>
            <input type="hidden" name="produto_id" value="<%=p.getId() %>"/>
            ID:<%=p.getId() %>   Nome:<%=p.getNome() %><br/>
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
                for(Servico sp:p.getMeusServicos()){
               
                %>
                <tr>
                    <td><%=sp.getId() %></td>
                    <td><%=sp.getTipo() %></td>
                     <td><%=sp.getPreco() %></td>
                    <td align="center"><a href="gerenciar_produto_servico.do?op=desvincular&produto_id=<%=p.getId() %>&servico_id=<%=sp.getId() %>">X</a></td>
                </tr>
                <%
                }
                
                %>
                
            </table>  
           
    </body>
</html>
