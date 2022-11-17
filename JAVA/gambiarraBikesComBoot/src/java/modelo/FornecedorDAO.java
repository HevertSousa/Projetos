
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class FornecedorDAO extends DataSource{
    public void inserir(Fornecedor f ) throws Exception{
        String sql = "INSERT INTO fornecedor (nome,endereco,telefone,cnpj) VALUES (?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,f.getNome());
        pstm.setString(2, f.getEndereco());
        pstm.setString(3, f.getTelefone());
        pstm.setString(4, f.getCnpj());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterar(Fornecedor f) throws Exception{
         String sql = "UPDATE fornecedor SET nome=?, endereco=?,telefone=?,cnpj=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getEndereco());
        pstm.setString(3, f.getTelefone());
        pstm.setString(4, f.getCnpj());
        pstm.setInt(5, f.getId());
        pstm.execute();
        this.desconectar();
        
    }
    
    public ArrayList<Fornecedor> listar() throws Exception{
       String sql = "SELECT * FROM fornecedor";
       ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Fornecedor f = new Fornecedor();
          f.setId(rs.getInt("id"));
          f.setNome(rs.getString("nome"));
          f.setEndereco(rs.getString("endereco"));
          f.setTelefone(rs.getString("telefone"));
          f.setCnpj(rs.getString("cnpj"));
          lista.add(f);  
        }
        this.desconectar();
        return lista;
    }
    
    public void excluir (int id) throws Exception{
        String sql="DELETE FROM fornecedor WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public Fornecedor carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM fornecedor WHERE id=?";
        Fornecedor f = new Fornecedor();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
       ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setEndereco(rs.getString("endereco"));
            f.setTelefone(rs.getString("telefone"));
            f.setCnpj(rs.getString("cnpj"));
            FornecedorDAO fDAO = new FornecedorDAO();
            f.setMeusProdutos(this.meusProdutos(id));
    }
        this.desconectar();
        return f;
    } 
    
    public ArrayList<Produto> meusProdutos(int produto_id) throws Exception{
        this.conectar();
        String sql = "SELECT p.* FROM produto as p, fornecedor_produto as fp WHERE p.id=fp.produto_id AND fp.fornecedor_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto_id);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Produto> lista = new ArrayList<Produto>();
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
    
    public ArrayList<Produto> meusNaoProduto(int produto_id) throws Exception{
       this.conectar();
        String sql = "SELECT p.* FROM produto as p WHERE p.id NOT IN(SELECT produto_id FROM fornecedor_produto WHERE fornecedor_id=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, produto_id);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Produto> lista = new ArrayList<Produto>();
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
    
    public void vincularProduto(int fornecedor_id,int produto_id) throws Exception{
        this.conectar();
        String sql = "INSERT INTO fornecedor_produto (fornecedor_id,produto_id) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, fornecedor_id);
        pstm.setInt(2, produto_id);
        pstm.execute();
        this.desconectar();
    }

    public void desvincularProduto(int fornecedor_id,int produto_id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM fornecedor_produto WHERE fornecedor_id=? AND produto_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, fornecedor_id);
        pstm.setInt(2, produto_id);
        pstm.execute();
        this.desconectar();
    }
    
}
