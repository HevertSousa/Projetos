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
        Carro car = new Carro("Modelo1", 2.0, 15.25);
        Moto mot = new Moto("Modelo1", 25.00, 2010);
         try {
            System.out.println("Escolher Exercício a ser Executado\n");
            System.out.println("==========================================");
            System.out.println("Exercício 01\nExercício 02\n");
            escolha = in.nextInt();
        }finally{
            in.close();
        }
        validaEscolha(escolha);
        if(escolha == 1){
            System.out.println("Adicionar Carro ou Moto:\n");
            System.out.println("CARRO : 1\nMOTO : 2");
            escolha = in.nextInt();
            validaEscolha(escolha);
            if(escolha == 1){
                List <Carro> carros = new ArrayList<Carro>();
                    System.out.println("Digite os dados do Carro: \n");
                    car.setModelo(in.nextLine());
                    car.setPreco(in.nextDouble());
                    car.setKm(in.nextDouble());
                    carros.add(car);
            }else if(escolha == 2){
                List <Moto> motos = new ArrayList<Moto>();
                    System.out.println("Digite os dados da Moto: \n");
                    
                    mot.setModelo(in.nextLine());
                    mot.setPreco(in.nextDouble());
                    mot.setAno(in.nextInt());
                    motos.add(mot);
            }
        }    
}
    public static void validaEscolha(int escolha){ 
        do{
        if (escolha < 0 || escolha > 1){
            System.out.println("Escolha inválida favor selecionar novamente: ");
        }
    }while(escolha < 0 || escolha > 1);
    }
}
