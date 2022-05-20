// desafio pilha


#include <stdio.h>

typedef struct p{

    struct p *ant;
    int p;
    struct p *prox;

}Pilha, *P_pilha;

void mostrar(Pilha *elemeno){

    printf("%d\n", elemento->prox);
    if(elemento->prox != NULL){
        mostrar(elemento->pox);
    }
}
P_pilha empilharTopo(Pilha *topo, Pilha *novo){

    if(topo != NULL){
        topo->prox = novo;
        novo->ant = topo;
        topo = novo;
    }else{
        printf("Pilha vazia \n");
    }
    return topo;
}

int main(){
    
    Pilha elemento1;
    Pilha elemento2;

    Pilha *p1;
    Pilha *p2;

    p1 = &elemento1;
    p2 = &elemento2;

    p1->ant = NULL;
    p1->p = 10;
    p1->prox = NULL;
    p2-> ant = NULL;
    p2->p = 20;
    p2->prox = NULL;

    Pilha *topo;
    Pilha *base;

    topo = &elemento1;
    base = &elemento1;
    



    return 0;
}