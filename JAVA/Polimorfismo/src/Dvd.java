import java.util.ArrayList;
import java.util.List;

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
        List <Dvd> dvds = new ArrayList<Dvd>();
    }
}
