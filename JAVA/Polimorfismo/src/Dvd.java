/**
 *
 * @author Hevert.Sousa
 */
public class Dvd extends Midia {
       
       private int nFaixas;

    public int getnFaixas() {
        return nFaixas;
    }

    public void setnFaixas(int nFaixas) {
        this.nFaixas = nFaixas;
    }
    public Dvd(int codigo, double preco, String nome){
        super(codigo, preco, nome);
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
