/**
 *
 * @author Hevert.Sousa
 * Classe principal que vai controlar os dois exercícios diferentes 
 * para insersão de veículos(carro e moto) e para o controle de 
 * cds e dvds por meio de um menu principal.
 */
import java.util.*;
public class Principal {

    public static void main(String[] args) {
        
        int escolha;
        
        Scanner in = new Scanner(System.in);
         try {
            System.out.println("Escolher Exercício a ser Executado\n");
            System.out.println("==========================================");
            System.out.println("Exercício 01\nExercício 02\n");
            escolha = in.nextInt();
        }finally{
            in.close();
        }
        validaEscolha(escolha);    
}
    public static void validaEscolha(int escolha){
        
        do{
        if (escolha < 0 || escolha > 1){
            System.out.println("Escolha inválida favor selecionar novamente: ");
        }
    }while(escolha < 0 || escolha > 1);
    }
}
