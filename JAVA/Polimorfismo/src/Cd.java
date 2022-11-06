/**
 *
 * @author Hevert.Sousa
 */
public class Cd extends Midia{
       
    public Cd(int codigo, double preco, String nome) {
        super(codigo, preco, nome);
    }

    private int nMusicas;

    public int getnMusicas() {
        return nMusicas;
    }

    public void setnMusicas(int nMusicas) {
        this.nMusicas = nMusicas;
    }
    @Override
    public String getTipo(){
        return  getClass().getName();
    }
    @Override
    public void inserirDados(){
        System.out.println("Cadastrando Novo DVD \n");
        System.out.println("Código do DVD: ");
        System.out.println("");
        System.out.println("");
    }
}
