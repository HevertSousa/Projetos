public class Carro extends Veiculo{

 private double km; 

    public Carro(String modelo, double preco, double km){
        super(modelo, preco);
    }
    public double getKm(){
        return km;
    }
    public void setKm(double km){
        this.km = km;
    }
    public void inserirDados(){
        
    }
}