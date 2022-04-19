#include <stdio.h>
#include <locale.h>

float calculaMedia(float nota1, float nota2){
     return (nota1+nota2)/2;
    
}

int main(){


    setlocale(LC_ALL,"");

    // crie um algoritmo que receba duas notas e mostre a média entre elas
    float nota1, nota2, media;

    printf("Digite a primeira nota: ");
    scanf("%f", &nota1);
    printf("Digite a segunda nota: ");
    scanf("%f", &nota2);
    media = calculaMedia(nota1, nota2);

    printf("A média das notas é %.2f", media);

    return 0;
}