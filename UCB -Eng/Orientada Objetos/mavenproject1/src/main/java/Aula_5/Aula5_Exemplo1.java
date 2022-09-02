package Aula_5;

import java.util.Scanner;

public class Aula5_Exemplo1 {
    
    
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite seu nome\n");
        p1.nome = in.nextLine();
        System.out.println("Digite o ano de nascimento\n");
        p1.dataNasc = in.nextInt();
        p1.calc(p1.dataNasc);
        System.out.println("Seu nome: "+ p1.nome);
        System.out.println("Idade: "+ p1.idade);
    }
}
