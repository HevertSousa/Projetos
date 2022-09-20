import java.util.*;
public class exeEncaps {
    public static void main(String[] args) throws Exception {
        
        try (Scanner in = new Scanner (System.in)) {
        }
        SavingsAccount saver1 = new SavingsAccount();
        SavingsAccount saver2 = new SavingsAccount();


        saver1.setSavingBalance(2000.00f);
        saver2.setSavingBalance(3000.00f);;

        System.out.println("Definindo Taxa de juros: ");

        System.out.println("Entre com a nova Taxa de Juros: ");
        saver1.setAnnualInterestRate(4f);
        saver2.setAnnualInterestRate(4f);
        saver1.modifyInterestRate(saver1.getAnnualInterestRate());
        saver2.modifyInterestRate(saver2.getAnnualInterestRate());
        System.out.println("Calculando Rendimentos:\n ");
        saver1.calculateMonthlyInterest(saver1.getSavingBalance());
        saver2.calculateMonthlyInterest(saver2.getSavingBalance());



    }
}
