
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ModeloDAO extends DataSource{
    
     public ArrayList<Modelo> listar() throws Exception{
       String sql = "SELECT * FROM modelo";
       ArrayList<Modelo> lista = new ArrayList<Modelo>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Modelo m = new Modelo();
          m.setId(rs.getInt("id"));
          m.setNome(rs.getString("nome"));
          m.setDescricao(rs.getString("descricao"));
          MarcaDAO maDAO = new MarcaDAO();
          m.setMarca(maDAO.carregarPorId(rs.getInt("marca_id")));
          lista.add(m);  
        }
        this.desconectar();
        return lista;
    }
     
     public void inserir(Modelo m ) throws Exception{
        String sql = "INSERT INTO modelo (nome,descricao,marca_id) VALUES (?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,m.getNome());
        pstm.setString(2, m.getDescricao());
        pstm.setInt(3, m.getMarca().getId());
        pstm.execute();
        this.desconectar();
    }
     
      public void excluir(int id) throws Exception{
        String sql="DELETE FROM modelo WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar(); 
    }
      
      public void alterar(Modelo m) throws Exception{
        String sql = "UPDATE modelo SET nome=?,descricao=?,marca_id=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,m.getNome());
        pstm.setString(2,m.getDescricao());
        pstm.setInt(3, m.getMarca().getId());
        pstm.setInt(4, m.getId());
        pstm.execute();
        this.desconectar();
        
    }
      
      public Modelo carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM modelo WHERE id=?";
        Modelo m = new Modelo();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m.setId(rs.getInt("id"));
            m.setNome(rs.getString("nome"));
            m.setDescricao(rs.getString("descricao"));
            MarcaDAO maDAO = new MarcaDAO();
            m.setMarca(maDAO.carregarPorId(rs.getInt("marca_id")));
        }
        this.desconectar();
        return m;
    }
    
}
