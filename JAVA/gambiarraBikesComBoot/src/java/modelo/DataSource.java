
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
   Connection conn; 
   public void conectar() throws Exception{
       String user, password,url;
       user ="root";
       password="";
       url = "jdbc:mysql://localhost/gb";
       Class.forName("com.mysql.jdbc.Driver");
       conn =DriverManager.getConnection(url,user,password);
   }
   
   public void desconectar() throws Exception{
       if(!conn.isClosed()){
           conn.close();
       }
   }
    
}
