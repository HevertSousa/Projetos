
package modelo;

import java.util.ArrayList;


public class Fornecedor {
    private int id;
    private String nome;
    private String endereco;
    private String  telefone;
    private String cnpj;
    private ArrayList<Produto> meusProdutos;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Produto> getMeusProdutos() {
        return meusProdutos;
    }

    public void setMeusProdutos(ArrayList<Produto> meusProdutos) {
        this.meusProdutos = meusProdutos;
    }

  
    
    
    
}
