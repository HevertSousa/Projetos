/*  treino árvores binárias */

#include<stdio.h>
#include<stdlib.h>


typedef struct no{
    int valor;
    struct no *direita, *esquerda;
}NO;

typedef struct{
    NO *raiz;
}ArvB;
void inserirEsquerda(NO *no, int valor){
    if(no->esquerda == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->valor = valor;
        novo->direita = NULL;
        novo->esquerda = NULL;
        no->esquerda = novo;
    }else if (valor < no->valor)
    {
        inserirEsquerda(no->esquerda, valor);
    }else
        inserirDireita(no->esquerda, valor);
}
void inserirDireita(NO *no, int valor){
    if(no->direita == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->valor = valor;
        novo->direita = NULL;
        novo->esquerda = NULL;
        no->direita = novo;
    }else if (valor > no->direita->valor)
    {
        inserirDireita(no->direita, valor);
    }else{
        inserirEsquerda(no->direita, valor);
    }
    
}
void inserir(ArvB *arv, int valor){
    if(arv->raiz == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->valor = valor;
        novo->direita = NULL;
        novo->esquerda = NULL;
        arv->raiz = novo;
    }else{
        if(valor < arv->raiz->valor){
            inserirEsquerda(arv->raiz, valor);
        }else{
            inserirDireita(arv->raiz, valor);
        }
    }
}
void imprimir(NO *raiz){
    if(raiz != NULL){   
        imprimir(raiz->esquerda);
        printf(" - %d", raiz->valor);
        imprimir(raiz->direita);
    }
}
int main(){

    int op, valor;
    ArvB arv;
    arv.raiz = NULL;

    do{
        printf("\n 0 - SAIR // 1 - INSERIR // 2 - IMPRIMIR\n");
        scanf("%d", &op);
        system("cls");
        switch (op)
        {
        case 0 :
            printf("SAINDO");
            break;    
        case 1 :
            printf("Digite um valor:");
            scanf("%d", &valor);
            inserir(&arv, valor);  
            break;
        case 2:
            printf("\nImprimindo\n");
            imprimir(arv.raiz);
        break;
        default:
            printf("\n OPCAO INVALIDA");
            break;
        }
    }while(op != 0);

    return 0;
}