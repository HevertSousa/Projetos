<%-- 
    Document   : listar_servico
    Created on : 09/10/2018, 23:28:09
    Author     : Ygor
--%>

<%@page import="modelo.ServicoDAO"%>
<%@page import="modelo.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
            function excluir(id,nome){
                if(confirm("Tem certeza que quer excluir o serviço "+nome+"?")){
                    window.open("excluir_servico.do?id="+id,"_self");
                }
            }
        </script>
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
         <h1>Serviços(<a href="form_inserir_servico.jsp">+</a>)</h1>
            <table class="table table-bordered"  width="100%" cellspacing="0">
                <thead>
               <tr>
                <td>ID</td>
                <td>ENTREGA</td>
                <td>TIPO</td>
                <td>DESCRIÇÃO</td>
                <td>PREÇO</td>
                <td>CLIENTE</td>
                <td>OPÇÕES</td>
            </tr>
            <%
                ArrayList<Servico> lista = new ArrayList<Servico>();
                try{
                    ServicoDAO sDAO = new ServicoDAO();
                   lista = sDAO.listar();
                }catch(Exception e){
                    out.print("Erro:"+e);
                }
                for(Servico s:lista){
                %>
                <tr>
                    <td><%=s.getId() %></td>
                    <td><%=s.getEntrega() %></td>
                    <td><%=s.getTipo() %></td>
                    <td><%=s.getDescricao() %></td>
                    <td><%=s.getPreco() %></td>
                    <td><%=s.getCliente().getNome() %></td>
                     <td><a href="form_alterar_servico.jsp?id=<%=s.getId() %>"><img src="imagens/alterar.png"/></a> <a href="#" onclick="excluir(<%=s.getId() %>,'<%=s.getTipo() %>')"><img src="imagens/excluir.png"/></a></td>
                     
                </tr>
            <%
                }
                %> 
                </thead>
            </table>
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