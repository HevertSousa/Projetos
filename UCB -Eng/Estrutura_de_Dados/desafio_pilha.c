// desafio pilha


#include <stdio.h>

typedef struct p{

    struct p *ant;
    int p;
    struct p *prox;

}Pilha, *P_pilha;

void mostrar(Pilha *elemento){

    printf("%d\n", elemento->prox);
    if(elemento->prox != NULL){
        mostrar(elemento->prox);
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
P_pilha desempilhar(Pilha *topo){
    if (topo != NULL){
        topo->ant->prox = NULL;
        topo = topo->ant; 
    }else{
        printf("A pilha está vazia");
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
    
    // adicionando p2 na pilha 

    p1-> prox = p2;
    p2-> ant = p1;
    topo = p2; // o topo da pilha agora é o novo elemento
     mostrar(base);

     printf("\n------------------------\n");

     Pilha elemento3; 
     elemento3.ant = NULL;
     elemento3.p = 30;
     elemento3.prox = NULL;

     topo = empilharTopo(topo, &elemento3);
     mostrar(base);

     printf("\n--------------------\n");

     Pilha elemento4;
     elemento4.ant = NULL;
     elemento4.p = 40;
     elemento4.prox = NULL;

     topo = empilharTopo(topo, &elemento4);
     mostrar(base);

     printf("\n--------------\n");

     Pilha elemento5;
     elemento5.ant = NULL;
     elemento5.p = 50;
     elemento5.prox = NULL;

     topo = empilharTopo(topo, &elemento5);
     mostrar(base);

     printf("\n-----------------\n");

    return 0;
}