<%-- 
    Document   : form_alterar_servico
    Created on : 10/10/2018, 00:34:59
    Author     : Ygor
--%>

<%@page import="modelo.ClienteDAO"%>
<%@page import="modelo.ServicoDAO"%>
<%@page import="modelo.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Servico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
            Servico s = new Servico();
            ArrayList<Cliente> lista = new ArrayList<Cliente>();
            
            try{
                int id = Integer.parseInt(request.getParameter("id"));
                ServicoDAO sDAO = new ServicoDAO();
                s = sDAO.carregarPorId(id);
                ClienteDAO cDAO = new ClienteDAO();
                lista = cDAO.listar();
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
        
   
         <h2>Alterando Serviço</h2>
         
           
            
            
            
           
            
 <form method="post" action="alterar_servico.do">
   
   <table class="table table-bordered"  width="100%" cellspacing="0">
        <tr>
        <h5> ID:<%=s.getId() %><br/></h5>
        <input type="hidden" value="<%=s.getId() %>" name="id"/>
            <td><h5>Entrega:</h5>
           <input type="text"  value="<%=s.getEntrega() %>" name="entrega" size="30" required/><br/></td>
           <td><label><h5>Tipo:</h5></label>
		
		<select name="tipo" >
			<option value="#" selected="selected">Selecione</option>
			<option value="Pintura">Pintura</option>
			<option value="Manutenção">Manutenção</option>							
                    </select></br></td>
        </tr>
        
          <tr> 
              <td><h5>Descricao:</h5>
                  <input type="text"  value="<%=s.getDescricao() %>" name="descricao" size="30" required/><br/> 
              <td><h5>Preço:</h5>
                 <input type="text"  value="<%=s.getPreco() %>" name="preco" size="30" required/><br/>
          </tr>  
          
          <tr> 
           <td>
               <h5>Cliente:</h5>
            <select name="cliente_id" size="1" required>
                <option value="">Selecione...</option>
                <%
                    String selecao ="";
                    for(Cliente c:lista){
                        if(c.getId()==s.getCliente().getId()){
                            selecao ="selected";
                        }else{
                            selecao ="";
                        }
                    %>
                    <option value="<%=c.getId() %>" <%=selecao %>><%=c.getNome() %></option>
                    <%    
                    }
                    %>
            </select><br/>
          </td>   
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
