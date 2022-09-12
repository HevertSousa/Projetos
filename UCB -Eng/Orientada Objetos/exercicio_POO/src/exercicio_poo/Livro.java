/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package exercicio_poo;

/**
 *
 * @author Hevert.Sousa
 */
public class Livro {
    private String titulo;
    private String editora;
    private int lancamento;
    private int edicao;

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @return the lancamento
     */
    public int getLancamento() {
        return lancamento;
    }

    /**
     * @param lancamento the lancamento to set
     */
    public void setLancamento(int lancamento) {
        this.lancamento = lancamento;
    }

    /**
     * @return the edicao
     */
    public int getEdicao() {
        return edicao;
    }

    /**
     * @param edicao the edicao to set
     */
    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }
    void imprimir(){
        System.out.println("DADOS DO LIVRO: \n"+"\n");
        System.out.println("TITULO: "+ titulo+"\n");
        System.out.println("EDITORA: "+ editora+"\n");
        System.out.println("ANO LANÇAMENTO: "+ lancamento+"\n");
        System.out.println("EDIÇÃO: "+ edicao+"\n");
    }
}
