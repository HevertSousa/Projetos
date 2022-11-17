/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ygor
 */
public class VendaDAO extends DataSource{
    public int inserir(Venda v) throws Exception{
        this.conectar();
        String sql = "INSERT INTO venda (data_venda,usuario_id,cliente_id) VALUES(now(),?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, v.getUsuario().getId());
        pstm.setInt(2, v.getCliente().getId());
        pstm.execute();
        ResultSet rs = pstm.getGeneratedKeys();
        if(rs.next()){
            v.setId(rs.getInt(1));
        }
        for(ItemVenda item:v.getCarrinho()){
            String sql_item = "INSERT INTO item_venda (venda_id,produto_id,quantidade,valor) VALUES(?,?,?,?)";
            PreparedStatement pstm_item = conn.prepareStatement(sql_item);
            pstm_item.setInt(1, v.getId());
            pstm_item.setInt(2, item.getProduto().getId());
            pstm_item.setDouble(3, item.getQuantidade());
            pstm_item.setDouble(4, item.getValor());
            pstm_item.execute();
        }
        this.desconectar();
        return v.getId();
    }
    
    public Venda carregarPorId(int id) throws Exception{
        this.conectar();
        Venda v = new Venda();
        String sql = "SELECT * FROM venda WHERE id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            v.setId(rs.getInt("id"));
            v.setData_venda(rs.getDate("data_venda"));
            v.setData_entrega(rs.getDate("data_entrega"));
            v.setData_pagamento(rs.getDate("data_pagamento"));
            ClienteDAO cDAO = new ClienteDAO();
            v.setCliente(cDAO.carregarPorId(rs.getInt("cliente_id")));
            UsuarioDAO uDAO = new UsuarioDAO();
            v.setUsuario(uDAO.carregarPorId(rs.getInt("usuario_id")));
            v.setCarrinho(carregaItensVenda(id));
        }
        this.desconectar();
        return v;
    }
    
    public ArrayList<ItemVenda> carregaItensVenda(int venda_id) throws Exception{
        this.conectar();
        ArrayList<ItemVenda> lista = new ArrayList<ItemVenda>();
        String sql = "SELECT * FROM item_venda WHERE venda_id=?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, venda_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            ItemVenda item = new ItemVenda();
            item.setId(rs.getInt("id"));
            ProdutoDAO pDAO = new ProdutoDAO();
            item.setProduto(pDAO.carregarPorId(rs.getInt("produto_id")));
            item.setQuantidade(rs.getDouble("quantidade"));
            item.setValor(rs.getDouble("valor"));
            lista.add(item);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Venda> listar() throws Exception{
       String sql = "SELECT * FROM venda ";
       ArrayList<Venda> lista = new ArrayList<Venda>();
       this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
          Venda v = new Venda();
          v.setId(rs.getInt("id"));
          v.setData_venda(rs.getDate("data_venda"));
          v.setData_pagamento(rs.getDate("data_pagamento"));
          v.setData_entrega(rs.getDate("data_entrega"));
          ClienteDAO cDAO = new ClienteDAO();
          v.setCliente(cDAO.carregarPorId(rs.getInt("cliente_id")));
          UsuarioDAO uDAO = new UsuarioDAO();
          v.setUsuario(uDAO.carregarPorId(rs.getInt("usuario_id")));
          lista.add(v);  
        }
        this.desconectar();
        return lista;
    }
    
}
