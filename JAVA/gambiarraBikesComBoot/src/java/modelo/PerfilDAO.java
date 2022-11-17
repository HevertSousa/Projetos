/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class PerfilDAO extends DataSource{
    public void inserir(Perfil p) throws Exception{
        this.conectar();
        String sql = "INSERT INTO perfil (nome,descricao) VALUES(?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getDescricao());
        pstm.execute();
        this.desconectar();
    }
    public ArrayList<Perfil> listar() throws Exception{
        this.conectar();
        String sql = "SELECT * FROM perfil";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        while (rs.next()) {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    public void excluir(int id) throws Exception{
        this.conectar();
        String sql = "DELETE FROM perfil WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public Perfil carregarPorId(int id) throws Exception{
        this.conectar();
        String sql = "SELECT * FROM perfil WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        Perfil p = new Perfil();
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setMeusMenus(this.menusPerfil(id));
          
        }
        this.desconectar();
        return p;
    }
    public void alterar(Perfil p) throws Exception{
        this.conectar();
        String sql = "UPDATE perfil SET nome=?,descricao=? WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getDescricao());
        pstm.setInt(3, p.getId());
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Menu> menusPerfil(int perfil_id) throws Exception{
        this.conectar();
        String sql = "SELECT m.* FROM menu as m, perfil_menu as pm WHERE m.id=pm.menu_id AND pm.perfil_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, perfil_id);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        while (rs.next()) {
           Menu m = new Menu();
           m.setId(rs.getInt("id"));
           m.setIcone(rs.getString("icone"));
           m.setLink(rs.getString("link"));
           m.setTitulo(rs.getString("titulo"));
           lista.add(m);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Menu> menusNaoPerfil(int perfil_id) throws Exception{
       this.conectar();
        String sql = "SELECT m.* FROM menu as m WHERE m.id NOT IN(SELECT menu_id FROM perfil_menu WHERE perfil_id=?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, perfil_id);
        ResultSet rs = pstm.executeQuery();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        while (rs.next()) {        
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setIcone(rs.getString("icone"));
            m.setLink(rs.getString("link"));
            m.setTitulo(rs.getString("titulo"));
            lista.add(m);            
        }
        this.desconectar();
        return lista;
    }
    
    public void vincularMenu (int perfil_id,int menu_id) throws Exception{
        this.conectar();
        String sql = "INSERT INTO perfil_menu (perfil_id, menu_id) VALUES (?, ?);";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, perfil_id);
        pstm.setInt(2, menu_id);
        pstm.execute();
        this.desconectar();
    }
    
    public void desvincularMenu(int perfil_id, int menu_id)throws Exception {
        this.conectar();
        String sql =  "DELETE FROM perfil_menu WHERE perfil_id = ? AND menu_id = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, perfil_id);
        pstm.setInt(2, menu_id);
        pstm.execute();
        this.desconectar();
    }
    
     
}
