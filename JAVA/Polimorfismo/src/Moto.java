public class Moto extends Veiculo{

    private int ano;

    public Moto(String modelo, double preco, int ano) {
        super(modelo, preco);
        
    }

    public int getAno(){
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    

}