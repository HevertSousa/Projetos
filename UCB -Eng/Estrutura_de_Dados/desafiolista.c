/*
Síntese fazer uma lista alocada dinamicamente
Hevert Sousa UC19106625
Estrutura de Dados
Professora Hially Rabelo
*/

#include<stdio.h>
#include<stdlib.h>

typedef struct NO{
    struct No *prox;
}no;

typedef struct{
    no *fim;
    int dado;
}lista;

void inicializarLista(lista *l1){
    l1->fim = NULL;
}
void inserirItem(int dado, lista *l1){
    lista *l1 = (lista*) malloc(sizeof(lista));
    if(l1 == NULL){
        printf("Erro de ALocaçãoa");
    }else{
        l1->dado = dado;
        l1->fim = NULL;
    }
}
int removerDaLista(lista *l1){
    lista *l1 = l1->fim;
    
    if(l1 == NULL){
        printf("Lista Vazia");
    }else{

    }

}

int main(){
    return 0;
}