
package modelo;

import java.util.ArrayList;


public class Produto {
    private int id;
    private String nome;
    private Double valor;
    private Modelo modelo;
    private int quantidade;
    private ArrayList<Servico> meusServicos;
    
    public ArrayList<Servico> getMeusServicos() {
        return meusServicos;
    }

    public void setMeusServicos(ArrayList<Servico> meusServicos) {
        this.meusServicos = meusServicos;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

   

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
