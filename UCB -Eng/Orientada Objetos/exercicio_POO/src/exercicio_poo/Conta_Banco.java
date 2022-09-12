/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package exercicio_poo;

/**
 *
 * @author Hevert.Sousa
 */
public class Conta_Banco {
        private int cod;
        private float saldo;

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    void imprimir(){
        System.out.println("Código: "+ cod+"\n");
        System.out.println("Saldo: "+ saldo);
    }
}
