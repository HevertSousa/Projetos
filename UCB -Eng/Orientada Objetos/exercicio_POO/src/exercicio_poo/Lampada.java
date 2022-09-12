/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package exercicio_poo;

/**
 *
 * @author Hevert.Sousa
 */
public class Lampada {
        int estado;
        
        void estado_lampada(int estado){
        System.out.println("Defina o estado da lâmpada:\n");
        if(estado == 0 ){
            System.out.println("A LÃMPADA ESTÁ APAGADA!!");
        }if(estado == 1){
            System.out.println("A LÃMPADA ESTÁ ACESA!!");  
        }if (estado > 1){
            System.out.println("OPÇÃO INVÁLIDA");
        }
    
        }
}
