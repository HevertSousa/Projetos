public class Produto {
    public String nome;
    public float valor, desconto;
    public int qtd;
    public float valorTotal;

    float calculaDesc (float valor, int qtd){
       

        if(qtd < 11 && qtd > 0){
            valorTotal = qtd*valor;
        }
        else if(qtd > 10 && qtd < 21){
            desconto = valor*(10/100);
            valorTotal = (valor - ((10/100)*valor))*qtd;
        }else if(qtd > 20 && qtd < 50){
            valorTotal = (valor - ((20/100)*valor))*qtd;
        }else if(qtd > 50){
            valorTotal = (valor - ((25/100)*valor))*qtd;
        }
        return valorTotal; 
    }
    void imprimir(){
        System.out.println("NOME: "+ nome);
        System.out.println("QUANTIDADE: "+ qtd);
        System.out.println("VALOR TOTAL: "+ valorTotal);
    }
    
}

