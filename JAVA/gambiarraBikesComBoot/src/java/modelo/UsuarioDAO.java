
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class UsuarioDAO extends DataSource{
    
    public ArrayList<Usuario> listar() throws Exception{
       String sql = "SELECT * FROM usuario WHERE situacao ='ativo'";
       ArrayList<Usuario> lista = new ArrayList<Usuario>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Usuario u = new Usuario();
          u.setId(rs.getInt("id"));
          u.setNome(rs.getString("nome"));
          u.setIdade(rs.getInt("idade"));
          u.setSexo(rs.getString("sexo"));
          u.setCpf(rs.getString("cpf"));
          u.setEndereco(rs.getString("endereco"));
          u.setTelefone(rs.getString("telefone"));
          u.setEmail(rs.getString("email"));
          u.setLogin(rs.getString("login"));
          u.setSenha(rs.getString("senha"));
          PerfilDAO uDAO = new PerfilDAO();
          u.setPerfil(uDAO.carregarPorId(rs.getInt("perfil_id")));
          
          lista.add(u);  
        }
        this.desconectar();
        return lista;
    }
    
    
    public void inserir(Usuario u ) throws Exception{
        String sql = "INSERT INTO usuario (nome,idade,sexo,cpf,endereco,telefone,email,login,senha,perfil_id) VALUES (?,?,?,?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,u.getNome());
        pstm.setInt(2, u.getIdade());
        pstm.setString(3,u.getSexo());
        pstm.setString(4, u.getCpf());
        pstm.setString(5, u.getEndereco());
        pstm.setString(6, u.getTelefone());
        pstm.setString(7, u.getEmail());
        pstm.setString(8, u.getLogin());
        pstm.setString(9, u.getSenha());
        pstm.setInt(10, u.getPerfil().getId());
        pstm.execute();
        this.desconectar();
    }
    
    public void excluir(Usuario u) throws Exception{
        String sql = "UPDATE usuario SET situacao ='desativo' WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, u.getId());
        pstm.execute();
        this.desconectar();
    }
    
    
    public Usuario carregarPorId(int id) throws Exception{
        String sql = "SELECT * FROM usuario WHERE id=?";
        Usuario u = new Usuario();
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
          u.setId(rs.getInt("id"));
          u.setNome(rs.getString("nome"));
          u.setIdade(rs.getInt("idade"));
          u.setSexo(rs.getString("sexo"));
          u.setCpf(rs.getString("cpf"));
          u.setEndereco(rs.getString("endereco"));
          u.setTelefone(rs.getString("telefone"));
          u.setEmail(rs.getString("email"));
          u.setLogin(rs.getString("login"));
          u.setSenha(rs.getString("senha"));
          PerfilDAO uDAO = new PerfilDAO();
          u.setPerfil(uDAO.carregarPorId(rs.getInt("perfil_id")));
          u.setMeusServicos(this.meusServicos(id));
        }
        this.desconectar();
        return u;
    }
    
    public void alterar(Usuario u) throws Exception{
        String sql = "UPDATE usuario SET nome=?,idade=?,sexo=?,cpf=?,endereco=?,telefone=?,email=?,login=?,senha=?,perfil_id=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,u.getNome());
        pstm.setInt(2, u.getIdade());
        pstm.setString(3,u.getSexo());
        pstm.setString(4, u.getCpf());
        pstm.setString(5, u.getEndereco());
        pstm.setString(6, u.getTelefone());
        pstm.setString(7, u.getEmail());
        pstm.setString(8, u.getLogin());
        pstm.setString(9, u.getSenha());
        pstm.setInt(10, u.getPerfil().getId());
        pstm.setInt(11, u.getId());
        pstm.execute();
        this.desconectar();
    }
    
     public ArrayList<Servico> meusServicos(int usuario_id) throws Exception{
        this.conectar();
        String sql = "SELECT s.* FROM servico as s, servico_usuario as su WHERE s.id=su.servico_id AND su.usuario_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, usuario_id);
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
    
     public ArrayList<Servico> meusNaoServicos(int usuario_id) throws Exception{
        this.conectar();
         String sql = "SELECT s.* FROM servico as s WHERE s.id NOT IN(SELECT servico_id FROM servico_usuario WHERE usuario_id=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, usuario_id);
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
     
     public void vincularServico(int usuario_id,int servico_id) throws Exception{
        this.conectar();
        String sql = "INSERT INTO servico_usuario (usuario_id,servico_id) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, usuario_id);
        pstm.setInt(2, servico_id);
        pstm.execute();
        this.desconectar();
    }

    public void desvincularServico(int usuario_id,int servico_id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM servico_usuario WHERE usuario_id=? AND servico_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, usuario_id);
        pstm.setInt(2, servico_id);
        pstm.execute();
        this.desconectar();
    }
    
    public boolean loginExiste(int id,String login) throws Exception{
        this.conectar();
        String sql = "SELECT * FROM usuario WHERE login=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if(rs.getInt("id")==id){
                return false;
            }else{
                return true;
            }
        }
        this.desconectar();
        return false;
    }
    
    
    public Usuario logar(String login,String senha) throws Exception{
        this.conectar();
        Usuario u = new Usuario();
        String sql = "SELECT * FROM usuario WHERE login=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if(senha.equals(rs.getString("senha"))){
                u.setId(rs.getInt("id"));
                u.setNome(rs.getString("nome"));
                u.setIdade(rs.getInt("idade"));
                u.setSexo(rs.getString("sexo"));
                u.setCpf(rs.getString("cpf"));
                u.setEndereco(rs.getString("endereco"));
                u.setTelefone(rs.getString("telefone"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                PerfilDAO uDAO = new PerfilDAO();
                u.setPerfil(uDAO.carregarPorId(rs.getInt("perfil_id")));
            }
        }
        this.desconectar();
        return u;
    }
}
