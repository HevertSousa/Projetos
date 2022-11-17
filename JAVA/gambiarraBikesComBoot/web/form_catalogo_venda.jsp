<%-- 
    Document   : form_catalogo_venda
    Created on : 09/11/2018, 00:35:15
    Author     : Ygor
--%>

<%@page import="modelo.ProdutoDAO"%>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.ItemVenda"%>
<%@page import="modelo.ClienteDAO"%>
<%@page import="modelo.Cliente"%>
<%@page import="modelo.Venda"%>
<%@page import="modelo.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
ArrayList<Produto> catalogo = new ArrayList<Produto>();
Venda venda = new Venda();

try{
   String nova = request.getParameter("nova");
   if(nova.equals("sim")){
        int id = Integer.parseInt(request.getParameter("id"));
        Cliente c = new Cliente();
        ClienteDAO cDAO = new ClienteDAO();
        c = cDAO.carregarPorId(id);
        venda.setCliente(c);
        venda.setCarrinho(new ArrayList<ItemVenda>());
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        venda.setUsuario(usuario);
        session.setAttribute("venda", venda);
   }else{
        venda = (Venda) session.getAttribute("venda");
   }
   ProdutoDAO pDAO = new ProdutoDAO();
   catalogo = pDAO.listar();
    
}catch(Exception e){
    out.print("Erro:"+e);
}


%>
<!DOCTYPE html>
<html lang="pt-br">

  <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Gambiarras Bikes</title>

    <!-- Bootstrap core CSS-->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Page level plugin CSS-->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin.css" rel="stylesheet">

  </head>

  <body id="page-top">

    <nav class="navbar navbar-expand navbar-dark bg-dark static-top">

      <a class="navbar-brand mr-1" href="index.jsp">Gambiarras Bikes</a>

     

   
    

      <!-- Navbar -->
      <ul class="navbar-nav ml-auto ml-md-0">
       
       
        <li class="nav-item dropdown no-arrow">
          <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            <i class="fas fa-user-circle fa-fw"></i>
          </a>
          <div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="sair.jsp"  >Sair</a>
          </div>
        </li>
      </ul>

    </nav>

    <div id="wrapper">

      <!-- Sidebar -->
      <ul class="sidebar navbar-nav">
           
           <%@include file="menu.jsp" %>
        <li class="nav-item active">
          
            
        </li>
      
     
      </ul>

      <div id="content-wrapper">

        <div class="container-fluid">

       

         
          </div>


          <!-- DataTables Example -->
          <div class="card mb-3">
            <div class="card-header">
              
              </div>
            <div class="card-body">
              <div class="table-responsive">
       <h1>Compra --- Carrinho(<%=venda.getCarrinho().size() %>)</h1>
        Cliente:<%=venda.getCliente().getNome() %><br/>
        <h2>Catálogo</h2>
        <table>
            <%
             for(Produto prod:catalogo){
             %>    
             <tr>
                 <td>
                     <form method="post" action="gerenciar_carrinho.do">
                         <input type="hidden" name="valor" value="<%=prod.getValor() %>"/>
                         <input type="hidden" name="id_produto" value="<%=prod.getId() %>"/>
                         <input type="hidden" name="op" value="add"/>
                        <img src="imagens_prod/<%=prod.getId() %>.png"/><br/>
                        <%=prod.getNome() %><br/>
                        R$ <%=prod.getValor() %><br/>
                        Qdt.:<input type="text" name="quantidade" value="1" size="3"/><input type="submit" value="+"/>
                     </form>
                 </td>
             </tr>
            <% 
                }
            %>
        </table>
        <br/>
        <a href="listar_cliente.jsp"><input type="submit" value="Cancelar"/></a>
             
        <a href="form_fecha_carrinho.jsp"><input type="submit" value="Ver Carrinho"/></a>
              </div>
            </div>
            

        </div>
        <!-- /.container-fluid -->

        <!-- Sticky Footer -->
        <footer class="sticky-footer">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Gambiarras Bikes</span>
            </div>
          </div>
        </footer>

      </div>
      <!-- /.content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fas fa-angle-up"></i>
    </a>

   

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>

    <!-- Demo scripts for this page-->
    <script src="js/demo/datatables-demo.js"></script>
    <script src="js/demo/chart-area-demo.js"></script>

  </body>

</html>

