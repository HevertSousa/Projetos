/**
 *
 * @author Hevert.Sousa
 */
import java.util.ArrayList;
import java.util.List;
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
        List <Cd> cds = new ArrayList<Cd>();

    }
}
