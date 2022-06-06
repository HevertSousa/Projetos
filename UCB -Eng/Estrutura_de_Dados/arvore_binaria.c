#include<stdio.h>
#include<stdlib.h>


typedef struct no{
    int info;
    struct no *esquerda;
    struct no *direita;
}NO;

typedef struct{
    NO *raiz;
}Arvore;

void inserirDireita(NO *no, int info){
    if(no->direita == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->info = info;
        novo->esquerda = NULL;
        novo->direita = NULL;
        no->direita = novo;
    }else{
        if(info > no->direita->info){
            inserirDireita(no->direita, info);
        }if(info < no->direita->info){
            inserirEsquerda(no->direita, info);
        }
    }
}

void inserirEsquerda(NO *no, int info){
    if(no->esquerda == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->info = info;
        novo->esquerda = NULL;
        novo->direita = NULL;
        no->esquerda = novo;
    }else{
        if(info < no->esquerda->info){
            inserirEsquerda(no->esquerda, info);
        }if(info > no->esquerda->info){
            inserirDireita(no->esquerda, info);
        }
    }
}
void inserirArvore(Arvore *arv, int info){
    if(arv->raiz == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->info = info;
        novo->esquerda = NULL;
        novo->direita = NULL;
        arv->raiz = novo;
    }else{
        if(info < arv->raiz->info){
            inserirEsquerda(arv->raiz, info);
        }if(info > arv->raiz-> info){
            inserirDireita(arv->raiz, info);
        }
    }
}

void imprimir(NO *raiz){
    if(raiz != NULL){
        imprimir(raiz->esquerda);
        printf("%d", raiz->info);
        imprimir(raiz->direita);
    }
}
int main(){

    int valor, opcao;
    Arvore arv;
    arv.raiz = NULL;

    do{
        printf("\n0 - SAIR // 1 - INSERIR // 2 - IMPRIMIR");
        scanf("%d", &opcao);

        switch(opcao){
            case 0:
                printf("\n SAIR"); 
                break;
            case 1:
                printf("\nINCLUA UM ELEMENTO NA ARVORE");
                scanf("%d", &valor);
                inserirArvore(&arv, valor);
                break;
            case 2:
                printf("\nIMPRIMIR");
                imprimir(arv.raiz);
                break;
            default:
                printf("\nOPCAO INVALIDA");
        }
    }while(opcao != 0);
    return 0;
}