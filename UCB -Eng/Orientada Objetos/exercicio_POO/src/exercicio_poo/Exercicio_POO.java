/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicio_poo;
import java.util.Scanner;
/**
 *
 * @author Hevert.Sousa
 */
public class Exercicio_POO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Scanner in = new Scanner (System.in);
       int opcao;
       Conta_Banco conta1 = new Conta_Banco();
       Emprestimo Emp1 = new Emprestimo();
       Lampada Lamp = new Lampada();
       Livro Liv1 = new Livro();
       Pedido Ped1 = new Pedido();
       Pessoa p1 = new Pessoa();
       Produto prod = new Produto();
        
        do{
            System.out.println("Escolha o Exercicio a ser executado: \n");
            System.out.println("EX 1 = 1\nEX 2 = 2\nEX 3 = 3\nEX 4 = 4\nEX 5 = 5\nSAIR = 0");
            opcao = in.nextInt();
            
            if (opcao == 1){
                 System.out.println("A LÂMPADA ESTÁ \n1 = ACESA\n0 = APAGADA");
                 Lamp.estado = in.nextInt();
                 Lamp.estado_lampada(Lamp.estado);
            }
            if (opcao == 2){
                System.out.println("CRIANDO UMA CONTA BANCÁRIA: \n");
                System.out.println("Digite o código da conta: ");
                conta1.setCod(in.nextInt());
                System.out.println("Digite o Saldo: ");
                conta1.setSaldo(in.nextFloat());
                conta1.imprimir();
            }
            if (opcao == 3){
                System.out.println("ADICIONANDO LIVROS: \n");
                System.out.println("Digite o Titulo do Livro: ");
                in.nextLine();
                Liv1.setTitulo(in.nextLine());
                System.out.println("Digite o nome da Editora: ");
                Liv1.setEditora(in.nextLine());
                System.out.println("Digite o ano do Lançamento:");
                Liv1.setLancamento(in.nextInt());
                System.out.println("Digite o número da edição: ");
                Liv1.setEdicao(in.nextInt());
                Liv1.imprimir();
            }
            if (opcao == 4){
                
            }
            if (opcao == 5){
                
            }
            
        }while(opcao != 0 && opcao < 6);
    }
    
}
