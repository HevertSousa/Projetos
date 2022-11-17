
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClienteDAO extends DataSource{
    public void inserir(Cliente c ) throws Exception{
        String sql = "INSERT INTO cliente (nome,telefone,endereco,cpf) VALUES (?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,c.getNome());
        pstm.setString(2, c.getTelefone());
        pstm.setString(3,c.getEndereco());
        pstm.setString(4, c.getCpf());
        pstm.execute();
        this.desconectar();
    }
    
    public void alterar(Cliente c) throws Exception{
        String sql = "UPDATE cliente SET nome=?, telefone=?, endereco=?,cpf=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setString(2, c.getTelefone());
        pstm.setString(3, c.getEndereco());
        pstm.setString(4, c.getCpf());
        pstm.setInt(5, c.getId());
        pstm.execute();
        this.desconectar();
        
    }
    
    public ArrayList<Cliente> listar() throws Exception{
       String sql = "SELECT * FROM cliente WHERE situacao='ativo'";
       ArrayList<Cliente> lista = new ArrayList<Cliente>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Cliente c = new Cliente();
          c.setId(rs.getInt("id"));
          c.setNome(rs.getString("nome"));
          c.setTelefone(rs.getString("telefone"));
          c.setEndereco(rs.getString("endereco"));
          c.setCpf(rs.getString("cpf"));
          lista.add(c);  
        }
        this.desconectar();
        return lista;
    }
    
    public void excluir (Cliente c) throws Exception{
        String sql = "UPDATE cliente SET situacao='desativado' WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, c.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public Cliente carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM cliente WHERE id=?";
        Cliente m = new Cliente();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
       ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m.setId(rs.getInt("id"));
            m.setNome(rs.getString("nome"));
            m.setTelefone(rs.getString("telefone"));
            m.setEndereco(rs.getString("endereco"));
            m.setCpf(rs.getString("cpf"));
               
    }
        this.desconectar();
        return m;
    } 
    
}
