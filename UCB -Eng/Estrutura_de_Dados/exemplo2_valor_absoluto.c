#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

//função para calcular médias.
float calcula_absoluto(float nota1, float nota2){
     return (nota1-nota2);
    
}

int main(){


    setlocale(LC_ALL,"");

    // crie um algoritmo que receba duas notas e mostre a média entre elas
    float nota1, nota2, absoluto;

    printf("Digite a primeira nota: ");
    scanf("%f", &nota1);
    printf("Digite a segunda nota: ");
    scanf("%f", &nota2);    
    absoluto = calcula_absoluto(nota1, nota2);

    absoluto = abs(absoluto);

    printf("O valor absoluto das notas é %.2f", absoluto);

    return 0;
}