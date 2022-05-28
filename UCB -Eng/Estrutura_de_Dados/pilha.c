#include <stdio.h> 
#include <stdlib.h>

typedef struct elemento{
    int dado;
    struct elemento *prox;
}Elemento;

typedef struct p{
     Elemento *topo;
}Pilha;

void inciar(Pilha *p){
    p->topo = NULL;
}
void empilhar(int dado, Pilha *p){
    Elemento *elem = (Elemento*)malloc(sizeof(Pilha));

    if(elem == NULL){
        printf("Erro de alocação");
    }else{
        elem->dado = dado;
        elem->prox = p->topo;
        p->topo = elem;
    }
}
void mostrarPilha(Pilha *p){
    Elemento *elem = p->topo;

    if(elem == NULL){
        printf("Pilha Vazia!!!");
    }else{
        while(elem != NULL){
            printf("\n%d", elem->dado);
            elem = elem->prox;
            printf("\n");
        }
    }
}
void desempilhar(Pilha *p){
    Elemento *elem = p->topo;

    if(elem != NULL){
        p->topo = elem->prox;
        elem->prox = NULL;
        free(elem);
    }else{
        printf("Pilha Vazia");
    }
    
}
int main(){

    Pilha *p1 = (Pilha*)malloc(sizeof(Pilha));
    inciar(p1);

    empilhar(15, p1);
    empilhar(20, p1);
    empilhar(25, p1);
    empilhar(30, p1);
    empilhar(35, p1);

    mostrarPilha(p1);
    printf("-------> Removendo o 35");
    desempilhar(p1);
    mostrarPilha((p1));

    return 0;
}