import java.util.Scanner;
public class Exercicios_Metodos {
    public static void main(String[] args) throws Exception {

        int opcao;
        try (Scanner in = new Scanner(System.in)) {
            Produto Prod1 = new Produto();
            System.out.println("EXERCÍCIOS DE MÉTODOS\n");
            System.out.println("===========================================");

            System.out.println("Escolha o execicio que quer executar: \n");

            do{
                System.out.println("Exercicio 1 = 1\nExercicio 2 = 2\nExercicio 3 = 3\nSair = 0\n");
                opcao = in.nextInt();

                if(opcao == 1){
                    System.out.println("Entre com o nome do Produto: ");
                    in.nextLine();
                    Prod1.nome = in.nextLine();
                    System.out.println("\nEntre com o valor do produto: ");
                    Prod1.valor = in.nextFloat();
                    System.out.println("\nEntre com a Quantidade: ");
                    Prod1.qtd = in.nextInt();

                    if(Prod1.qtd > 0 ){
                        Prod1.calculaDesc(Prod1.valor, Prod1.qtd);
                        Prod1.imprimir();
                    }
                }

            }while(opcao != 0);
        }

    }
}