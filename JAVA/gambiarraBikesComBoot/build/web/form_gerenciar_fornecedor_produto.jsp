<%-- 
    Document   : form_gerenciar_fornecedor_produto
    Created on : 27/10/2018, 21:58:17
    Author     : Ygor
--%>

<%@page import="modelo.FornecedorDAO"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Fornecedor f = new Fornecedor();
  ArrayList<Produto> meusNaoProdutos = new ArrayList<Produto>();
 try{
     int id = Integer.parseInt(request.getParameter("id"));
     FornecedorDAO fDAO = new FornecedorDAO();
     f = fDAO.carregarPorId(id);
     meusNaoProdutos = fDAO.meusNaoProduto(id);
 }catch(Exception e){
     out.print("Erro:"+e);
 }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciando Fornecedores Produtos</title>
    </head>
    <body>
       <h1>Gerenciando  Fornecedor Produtos</h1>
       <%@include file="menu.jsp" %>
        <form action="gerenciar_fornecedor_produto.do" method="post">
            <input type="hidden" name="op" value="vincular"/>
            <input type="hidden" name="fornecedor_id" value="<%=f.getId() %>"/>
            ID:<%=f.getId() %>   Nome:<%=f.getNome() %><br/>
            Produtos<select name="produto_id" size="1" required>
                <option value="">Selecione...</option>
                <%
                for(Produto p:meusNaoProdutos){
                %>
                <option value="<%=p.getId() %>"><%=p.getNome() %></option>
                <%
                }
                %>
            </select>
            <input type="submit" value="+"/>
        </form>
            
            <h1>Produtos Vinculados</h1>
            <table border="1">
                <tr>
                    <td>ID</td>
                    <td>NOME</td>
                    <td>MARCA</td>
                    <td>VALOR</td>
                    <td>DESVINCULAR</td>
                </tr>
                <%
                 for(Produto p:f.getMeusProdutos()){
               
                %>
                <tr>
                    <td><%=p.getId() %></td>
                    <td><%=p.getNome() %></td>
                    <td><%=p.getModelo().getNome() %></td>
                     <td><%=p.getValor() %></td>
                   <td align="center"><a href="gerenciar_fornecedor_produto.do?op=desvincular&fornecedor_id=<%=f.getId() %>&produto_id=<%=p.getId() %>">X</a></td>
                </tr>
                <%
                }
                
                %>
                
            </table>  
    </body>
</html>
