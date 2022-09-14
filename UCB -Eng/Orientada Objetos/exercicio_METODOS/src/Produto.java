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
            desconto = (valor*(10f/100f)*qtd);
            valorTotal = valor*qtd - desconto;
        }else if(qtd > 20 && qtd < 50){
            desconto = (valor*(20f/100f)*qtd);
            valorTotal = valor*qtd - desconto;
        }else if(qtd > 50){
            desconto = (valor*(25f/100f)*qtd);
            valorTotal = valor*qtd - desconto;
        }
        return valorTotal; 
    }
    void imprimir(){
        System.out.println("NOME: "+ nome);
        System.out.println("QUANTIDADE: "+ qtd);
        System.out.println("VALOR TOTAL: "+ valorTotal);
        System.out.println("DESCONTO TOTAL: "+ desconto);
    }
    
}

