#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>

typedef struct no
{
    struct no *esquerda, *direita;
    int dado;
}NO;

typedef struct 
{
    NO *raiz;
}ARVORE;

void inserir(ARVORE *arv1, int dado);
void inserirEsquerda(NO *no, int dado);
void inserirDireita(NO *no, int dado);
void imprimir(NO *raiz);
void iniciaArvore(ARVORE *arv1);


int main(){

ARVORE arv1;
int op, dado;

iniciaArvore(&arv1);
    
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
                scanf("%d", &dado);
                inserir(&arv1, dado);  
                break;
            case 2:
                printf("\nImprimindo\n");
                imprimir(arv1.raiz);
            break;
            default:
                printf("\n OPCAO INVALIDA");
                break;
            }
        }while(op != 0);


    return 0;
}

void iniciaArvore(ARVORE *arv1){
    arv1 = NULL; 
    printf("\nÁrvore inicializada");
}

void inserirDireita(NO *no, int dado){
    if(no->direita == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->dado = dado;
        novo->direita = NULL;
        novo->esquerda = NULL;
        no->direita = novo;

    }else if (dado > no->direita->dado)
    {
        inserirDireita(no->direita, dado);
    }else{
        inserirEsquerda(no->direita, dado);
    }
}
void inserirEsquerda(NO *no, int dado){
    if(no->esquerda == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->dado = dado;
        novo->direita = NULL;
        novo->esquerda = NULL;
        no->esquerda = novo;
    }else if (dado < no->dado)
    {
        inserirEsquerda(no->esquerda, dado);
    }else{
         inserirDireita(no->esquerda, dado);
    }
    
}
void inserir(ARVORE *arv1, int dado){
    if(arv1->raiz == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
        novo->dado = dado;
        novo->direita = NULL;
        novo->esquerda = NULL;
        arv1->raiz = novo;
    }else if (dado < arv1->raiz->dado)
    {
        inserirEsquerda(arv1->raiz, dado);

    }else if (dado > arv1->raiz->dado)
    {
        inserirDireita(arv1->raiz, dado);
    }  
}
void imprimir(NO *raiz){
    if(raiz != NULL){   
        imprimir(raiz->esquerda);
        printf(" - %d", raiz->dado);
        imprimir(raiz->direita);
    }
}
