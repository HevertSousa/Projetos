
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutoDAO extends DataSource{
    public ArrayList<Produto> listar() throws Exception{
       String sql = "SELECT * FROM produto";
       ArrayList<Produto> lista = new ArrayList<Produto>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Produto p = new Produto();
          p.setId(rs.getInt("id"));
          p.setNome(rs.getString("nome"));
          p.setValor(rs.getDouble("valor"));
          
          ModeloDAO mDAO = new ModeloDAO();
          p.setModelo(mDAO.carregarPorId(rs.getInt("modelo_id")));
          p.setQuantidade(rs.getInt("quantidade"));
          lista.add(p);  
        }
        this.desconectar();
        return lista;
    }
    
    public void inserir(Produto p ) throws Exception{
        String sql = "INSERT INTO produto (nome,valor,modelo_id,quantidade) VALUES (?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.setDouble(2, p.getValor());
        pstm.setInt(3,p.getModelo().getId());
        pstm.setInt(4,p.getQuantidade());
        pstm.execute();
        this.desconectar();
    }
    
    public void excluir(int id) throws Exception{
        String sql="DELETE FROM produto WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar(); 
    }
    
    public Produto carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM produto WHERE id=?";
        Produto p = new Produto();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setValor(rs.getDouble("valor"));
            ModeloDAO mDAO = new ModeloDAO();
            p.setModelo(mDAO.carregarPorId(rs.getInt("modelo_id")));
            p.setQuantidade(rs.getInt("quantidade"));
            p.setMeusServicos(this.meusServicos(id));
        }
        this.desconectar();
        return p;
    }
    
    public void alterar(Produto p) throws Exception{
        String sql = "UPDATE produto SET nome=?,valor=?,modelo_id=?,quantidade=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,p.getNome());
        pstm.setDouble(2, p.getValor());
        pstm.setInt(3, p.getModelo().getId());
        pstm.setInt(4, p.getQuantidade());
        pstm.setInt(5, p.getId());
        pstm.execute();
        this.desconectar();
        
    }
    
     public ArrayList<Servico> meusServicos(int produto_id) throws Exception{
        this.conectar();
        String sql = "SELECT s.* FROM servico as s, produto_servico as sp WHERE s.id=sp.servico_id AND sp.produto_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto_id);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Servico> lista = new ArrayList<Servico>();
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
     
     public ArrayList<Servico> meusNaoServicos(int produto_id) throws Exception{
        this.conectar();
        String sql = "SELECT s.* FROM servico as s WHERE s.id NOT IN(SELECT servico_id FROM produto_servico WHERE produto_id=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto_id);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Servico> lista = new ArrayList<Servico>();
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
     
      public void vincularServico(int produto_id,int servico_id) throws Exception{
        this.conectar();
        String sql = "INSERT INTO produto_servico (produto_id,servico_id) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto_id);
        pstm.setInt(2, servico_id);
        pstm.execute();
        this.desconectar();
    }

    public void desvincularServico(int produto_id,int servico_id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM produto_servico WHERE produto_id=? AND servico_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto_id);
        pstm.setInt(2, servico_id);
        pstm.execute();
        this.desconectar();
    }
    
    
    
}
