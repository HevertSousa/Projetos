package JAVA;


import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args){
        
        Scanner entrada = new Scanner(System.in);
        int cod, anoAtual = 2022, anoNasc, anoIngresso;

        System.out.println("Entre com seus dados: \n");
        System.out.println("Entre com o codigo do funcionário:\n");
        cod = entrada.nextInt();
        System.out.println("Ano de nascimeno: \n");
        anoNasc = entrada.nextInt();
        System.out.println("\n Ano de ingresso na empresa: ");
        anoIngresso = entrada.nextInt();

        int idade = anoAtual - anoNasc;
        int anosTrabalhados = anoAtual - anoIngresso;

        System.out.println("Código: "+ cod);
        System.out.println("Idade: "+ idade);
        System.out.println("Tempo de Trabalho: "+ anosTrabalhados);

        if(idade>65){
            System.out.println("PODE SE APOSENTAR");
        }else if(idade > 60 || anosTrabalhados >=25){
            System.out.println("PODE SE APOSENTAR");
        }else{
            System.out.println("NÃO CUMPRE OS REQUISITOS PARA SE APOSENTAR");
        }
    }
}
