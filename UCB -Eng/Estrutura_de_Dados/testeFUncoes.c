#include <stdio.h>
#include <locale.h>
#include <stdlib.h>

typedef struct NO{
	struct NO *direita;
	struct NO *esquerda;
	struct NO *raiz;
	int dado;
}NO;

void iniciaArvore(NO *raiz){
	raiz = NULL;
	printf("Arvore iniciada");
}

void inserirDado(NO *arv1, int dado){

	if(arv1->raiz == NULL){
		NO *novo  = (NO*)malloc(sizeof(NO));
		novo->dado = dado;
		novo->esquerda = NULL;
		novo->direita = NULL;
		arv1->raiz = novo;
	}else if(arv1->raiz->dado > dado){
		NO *novo  = (NO*)malloc(sizeof(NO));
		novo->dado = dado;
        novo->esquerda = NULL;
        novo->direita = NULL;
        arv1->esquerda = novo;
	}else if(arv1->raiz->dado < dado){
		NO *novo  = (NO*)malloc(sizeof(NO));
		novo->dado = dado;
        novo->esquerda = NULL;
        novo->direita = NULL;
        arv1->direita = novo;
	}
}
void imprimir(NO *raiz){
	if(raiz != NULL){
		imprimir(raiz->esquerda);
		printf("DADO: %d", raiz->dado);
		imprimir(raiz->direita);
	}else{
		printf("Sem informações na árvore");
	}
}
int main(){
	setlocale(LC_ALL, "");
	
	int dado, opcao;
	NO arv1;
	
	iniciaArvore(&arv1);
	do{	
		printf("Inserir Números na árvore");
		printf("\nNUMERO: ");
		scanf("%d", &dado);
		inserirDado(&arv1, dado);
		printf("\nDigite 2 para inserir elementos na árvore: ");
		scanf("%d", &opcao);
		system("cls");
	}while(opcao != 0);
	
	imprimir(arv1.raiz);
	
	system("pause");
	
	return 0;
}