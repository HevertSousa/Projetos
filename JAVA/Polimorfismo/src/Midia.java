/**
 *
 * @author Hevert.Sousa
 */
public class Midia {
    private int codigo;
    private String nome;
    private double preco;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Midia(int codigo, double preco, String nome) {
    }

    public String getTipo() {
        return getClass().getName();
    }
    public void inserirDados(){
        
    }
}
