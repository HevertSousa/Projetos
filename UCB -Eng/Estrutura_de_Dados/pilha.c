#include <stdio.h> 
#include <stdlib.h>

typedef struct elemento{
    int dado;
     Elemento *prox;
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

int main(){

    Pilha *p1 = (Pilha*)malloc(sizeof(Pilha));
    inciar(p1);

    return 0;
}