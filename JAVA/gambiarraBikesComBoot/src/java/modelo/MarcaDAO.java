
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MarcaDAO extends DataSource{
    
    public void inserir(Marca m ) throws Exception{
        String sql = "INSERT INTO marca (nome) VALUES (?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,m.getNome());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterar(Marca m) throws Exception{
         String sql = "UPDATE marca SET nome=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, m.getNome());
        pstm.setInt(2, m.getId());
        pstm.execute();
        this.desconectar();
        
    }
    
    public ArrayList<Marca> listar() throws Exception{
       String sql = "SELECT * FROM marca";
       ArrayList<Marca> lista = new ArrayList<Marca>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Marca m = new Marca();
          m.setId(rs.getInt("id"));
          m.setNome(rs.getString("nome"));
          lista.add(m);  
        }
        this.desconectar();
        return lista;
    }
    
    public void excluir (int id) throws Exception{
        String sql="DELETE FROM marca WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public Marca carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM marca WHERE id=?";
        Marca m = new Marca();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
       ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m.setId(rs.getInt("id"));
            m.setNome(rs.getString("nome"));
            MarcaDAO mDAO = new MarcaDAO();     
    }
        this.desconectar();
        return m;
    } 
    
    
    
}
