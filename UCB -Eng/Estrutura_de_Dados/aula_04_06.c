/* Aula 04/06/2022
   Atividade Árvore Binária
   Entrega dia 12/06
   Hevert Sousa UC19106625
   Estrutura de Dados Professora Hialy
*/

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <locale.h>

typedef struct no{
    char item;
    struct no *direita;
    struct no *esquerda;
}NO;

typedef struct Arvore{
    NO *raiz;
}r;

void inicia_arvore(struct Arvore *r){
    if(r->raiz != NULL){
       NO *novo = (NO*)malloc(sizeof(NO));
        r->raiz = NULL;
       printf("Árvore alocada com sucesso!!!");

    }else{
        printf("Erro de Alocação");
    }
}

void inserir(r *dado, int item){
    if(dado->raiz == NULL){
        dado->raiz =(NO*)malloc(sizeof(NO));
        dado->raiz->direita = NULL;
        dado->raiz->esquerda = NULL;
        dado->raiz->item = item;
    }else{
        if(dado->raiz->direita->item > item){
            dado->raiz->direita = NULL;
            dado->raiz->item = item;
        }else{
            dado->raiz->esquerda = NULL;
            dado->raiz->item = item;
        }
    }
}
int main(){
    
    struct Arvore *s;
    inicia_arvore(&s);
    inserir(s, 5);
    return 0;
}