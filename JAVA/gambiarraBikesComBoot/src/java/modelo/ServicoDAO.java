
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.DataSource;
import modelo.Servico;


public class ServicoDAO extends DataSource{
    
    
    public ArrayList<Servico> listar() throws Exception{
       String sql = "SELECT * FROM servico";
       ArrayList<Servico> lista = new ArrayList<Servico>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Servico s = new Servico();
          s.setId(rs.getInt("id"));
          s.setEntrega(rs.getString("entrega"));
          s.setTipo(rs.getString("tipo"));
          s.setDescricao(rs.getString("descricao"));
          s.setPreco(rs.getDouble("preco"));
          
          ClienteDAO cDAO = new ClienteDAO();
          s.setCliente(cDAO.carregarPorId(rs.getInt("cliente_id")));
          
          lista.add(s);  
        }
        this.desconectar();
        return lista;
    }
    
     public void inserir(Servico s ) throws Exception{
        String sql = "INSERT INTO servico (entrega,tipo,descricao,preco,cliente_id) VALUES (?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,s.getEntrega());
        pstm.setString(2,s.getTipo());
        pstm.setString(3, s.getDescricao());
        pstm.setDouble(4, s.getPreco());
        pstm.setInt(5, s.getCliente().getId());
        pstm.execute();
        this.desconectar();
    }
     
     public void excluir(int id) throws Exception{
        String sql="DELETE FROM servico WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar(); 
    }
     
       public Servico carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM servico WHERE id=?";
        Servico s = new Servico();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            s.setId(rs.getInt("id"));
            s.setEntrega(rs.getString("entrega"));
            s.setTipo(rs.getString("tipo"));
            s.setDescricao(rs.getString("descricao"));
            s.setPreco(rs.getDouble("Preco"));
            ClienteDAO cDAO = new ClienteDAO();
            s.setCliente(cDAO.carregarPorId(rs.getInt("cliente_id")));
        }
        this.desconectar();
        return s;
    }
       
       public void alterar(Servico s) throws Exception{
        String sql = "UPDATE servico SET entrega=?,tipo=?,descricao=?,preco=?,cliente_id=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,s.getEntrega());
        pstm.setString(2,s.getTipo());
        pstm.setString(3,s.getDescricao());
        pstm.setDouble(4, s.getPreco());
        pstm.setInt(5, s.getCliente().getId());
        pstm.setInt(6, s.getId());
        pstm.execute();
        this.desconectar();
        
    }
}
