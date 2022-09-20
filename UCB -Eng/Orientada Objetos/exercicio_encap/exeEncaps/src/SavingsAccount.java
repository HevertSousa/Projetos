public class SavingsAccount {

    private float annualInterestRate;
    private float savingsBalance = 0.0f;
    private int i;
    public float getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void setAnnualInterestRate(float annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public float getSavingBalance(){
        return savingsBalance;
    }
    public void setSavingBalance(float savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public float calculateMonthlyInterest(float valor){
       
        for(i = 0; i < 12; i++ ){
            savingsBalance = (savingsBalance*annualInterestRate)+savingsBalance;
            System.out.println("Valor no mês: "+ i+1 +" = "+ savingsBalance);    
        }
        return savingsBalance;
    }

    public void modifyInterestRate(float novaTaxa){
        annualInterestRate = novaTaxa/100f;
    }

    public void consultarSaldo(){
        System.out.println("Saldo Atual: "+ savingsBalance);
    }

}
