<%-- 
    Document   : form_alterar_fornecedor
    Created on : 09/10/2018, 23:03:46
    Author     : Ygor
--%>

<%@page import="modelo.FornecedorDAO"%>
<%@page import="modelo.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Fornecedor f = new Fornecedor();
 try{
     int id = Integer.parseInt(request.getParameter("id"));
     FornecedorDAO fDAO = new FornecedorDAO();
     f = fDAO.carregarPorId(id);
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
        
   
         <h2>Alterando Fornecedor</h2>
<form method="post" action="alterar_fornecedor.do">
   <table class="table table-bordered"  width="100%" cellspacing="0">
        <tr>
        <h5>ID:<%=f.getId() %></h5><br/>
        <input type="hidden" value="<%=f.getId() %>" name="id"/>
           <td>
               <h5>Nome:</h5>
               <input type="text" value="<%=f.getNome() %>" name="nome" size="60" required/><br/>
           <td><h5>Endereço:</h5>
               <input type="text" value="<%=f.getEndereco() %>" name="endereco" size="60" required/><br/>  
        </tr>
        
          <tr> 
             <td>
                 <h5>Telefone:</h5>
                 <input type="text" value="<%=f.getTelefone() %>" name="telefone" size="60" required/><br/> 
             <td><h5>Cnpj:</h5>
                 <input type="text" value="<%=f.getCnpj() %>" name="cnpj" size="60" required/><br/>
          </tr>  
     </table>
            <input type="submit" value="Salvar"/>
</form>
 
               
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

