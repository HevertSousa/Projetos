//Criar estruturas de dados utilizando alocação dinâmica de memória para fila;
/*Síntese
	Objetivo: Criar fila alocada dinamicamente
	Saída: Dados da fila
    Hevert Sousa UC19106625
    Estrutura de Dados 
    Professora Hially Rabelo  
    */
#include<stdio.h>
#include<stdlib.h>

typedef struct NO{
    struct No *prox;
    int dado;
}no;

typedef struct Fila{
    no *ini;
    no *fim;
}fila;

void inicializarFila(fila *f){
    f->ini = NULL;
    f->fim = NULL;
}
void enfileirar(int dado, fila *f ){
    no *ptr = (no*) malloc(sizeof(no));
    if(ptr == NULL){
        printf("erro de alocação");
        return;
    }else{
        ptr->dado = dado;
        ptr->prox = NULL;
        if(f->ini == NULL){
            f->ini = ptr;
        }else{
            f->fim->prox = ptr;
        }
        f->fim = ptr;
    }
}
int desenfileirar(fila *f){
    no *ptr = f->ini;
    int dado;
    if(ptr != NULL){
        f->ini = ptr->prox;
        ptr->prox = NULL;
         dado = ptr->dado;
        free(ptr);

        if(f->ini == NULL){
            f->fim = NULL;
        }
    }else{
        printf("Fila Vazia");
    }

    return dado;
}
void mostrar(fila *f){
    no *ptr = f->ini;
    if(ptr == NULL){
        printf("Lista Vazia"); 
    }else{
        while(ptr != NULL){
        printf("\n %d", ptr->dado);
        ptr = ptr->prox;
     }
    }
}
int main(){
    int dado;
    fila *f1 = (fila*) malloc(sizeof(fila));
    inicializarFila(f1);
    if(f1 == NULL){
        printf("Erro de alocação");
        exit(-1);
    }else{
        enfileirar(10, f1);
        enfileirar(20, f1);
        enfileirar(30, f1);
        enfileirar(40, f1);
        enfileirar(50, f1);
    }
    mostrar(f1);
    dado=desenfileirar(f1);
    printf("\nO item %d foi removido", dado);
    mostrar(f1);
    dado=desenfileirar(f1);
    printf("\nO item %d foi removido", dado);
    mostrar(f1);
    dado=desenfileirar(f1);
    printf("\nO item %d foi removido", dado);
    mostrar(f1);

    return 0;
}