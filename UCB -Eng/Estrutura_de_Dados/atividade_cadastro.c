/* 
Hevert Sousa UC19106625
Estrutura de Dados 
Professora Hialy

Contruir uma árvore binária para armazenar registros de dados pessoais
Cada registro, ou pessoa registrada deverá conter as seguintes informações 
Dados Pessoais: nome, cpf, sexo, data de nascimento, naturalidade, nome pai, nome mae  
Dados Endereço: logradouro, número, complemento, bairro, cidade, CEP, estado, pais
Dados Contato: e-mail, telefone. 

*/

#include<stdio.h>
#include<stdlib.h>
#include<locale.h>
#include<string.h>

typedef struct endereco{
    char logradouro[30], complemento[15], bairro[15], cidade[20], estado[15], pais[15], cep[8];
    int numero;
}END;
typedef struct contato{
    char email[30], telefone[15];
}CONT;

typedef struct pessoa{
    char nome[30], cpf[11], sexo[10], natural[15], nomePai[30], nomeMae[30];
    END *end;
    CONT *cont;
}P;

typedef struct no{
    struct no *direita, *esquerda;
    P *p1;
}NO;

typedef struct{
    NO *raiz;
}ARVORE;

void incializarArvore(ARVORE *arv1){
    if(arv1->raiz != NULL){
        arv1->raiz = NULL;
        printf("\nARVORE INICIALIZADA!!");
    }else{
        printf("\n ERRO DE ALOCAÇÃO");
    }
}
int menu (void){
	int opcao;
	do{		
			printf("\n=====================");
			printf("\n|**MENU DE SELEÇÃO**|");
			printf("\n=====================");
			printf("\n=== 1 INCLUIR\t=====");
			printf("\n=== 2 LISTAR\t=====");
			printf("\n=== 3 ALTERAR\t=====");
			printf("\n=== 4 EXCLUIR\t=====");
			printf("\n=== 5 DESTRUIR\t=====");
			printf("\n=== 0 SAIR\t=====");
			printf("\n=====================\n");
			fflush(stdin);
			scanf("%d", &opcao);
			if(opcao < 0 || opcao > 5){
				system("cls");
				printf("\n\n***ATENÇÃO ENTRE COM UMA OPÇÃO VÁLIDA!!!");
			}
	}while(opcao < 0 || opcao > 5); 
	system("cls");
	return opcao;
}

void incluir(ARVORE *arv1){
    
    int compara;

    if(arv1->raiz == NULL){
        NO *novo = (NO*)malloc(sizeof(NO));
         printf("\nENTRE COM O NOME DA PESSOA:\t");
        fgets(novo->p1->nome, 30, stdin);
         printf("\nENTRE COM O CPF:\t");
        fgets(novo->p1->cpf, 11, stdin);
         printf("\nENTRE COM O SEXO:\t");
        fgets(novo->p1->sexo, 10, stdin);
         printf("\nENTRE COM A NATURALIDADE:\t");
        fgets(novo->p1->natural, 15, stdin);
         printf("\nENTRE COM O NOME DO PAI:\t");
        fgets(novo->p1->nomePai, 30, stdin);
         printf("\nENTRE COM O NOME DA MAE:\t");
        fgets(novo->p1->nomeMae, 30, stdin);
         printf("\nENTRE COM O ENDEREÇO:\t");
         printf("LOGRADOURO:\t");
        fgets(novo->p1->end->logradouro, 30, stdin);
         printf("\nENTRE COM O COMPLEMENTO:\t");
        fgets(novo->p1->end->complemento, 30, stdin);
         printf("\nENTRE COM O BAIRRO:\t");
        fgets(novo->p1->end->bairro, 30, stdin);
         printf("\nENTRE COM A CIDADE:\t");
        fgets(novo->p1->end->cidade, 30, stdin);
         printf("\nENTRE COM O ESTADO:\t");
        fgets(novo->p1->end->estado, 30, stdin);
         printf("\nENTRE COM O PAIS:\t");
        fgets(novo->p1->end->pais, 30, stdin);
         printf("\nENTRE COM O CEP:\t");
        fgets(novo->p1->end->cep, 30, stdin);
         printf("\nENTRE COM OS DADOS DE CONTATO:\t");
         printf("\nENTRE COM O EMAIL:\t");
        fgets(novo->p1->cont->email, 30, stdin);
         printf("\nENTRE COM O TELEFONE:\t");
        fgets(novo->p1->cont->telefone, 15, stdin);
        novo->direita = NULL; novo->esquerda = NULL;
        arv1->raiz = novo;
    }else{

      do{    
        compara = strcmp(novo->p1->cpf, arv1->raiz->p1->cpf);
            if (compara < 0 )
            {
                incluirEsquerda(arv1->raiz);
            }else if (compara > 0)
            {
                incluirDireita(arv1->raiz);
            }
            if(compara == 0){
                system("cls");
                printf("O CPF já está cadastrado digite novamente");
            }
        }while(compara != 0);

    }
}
void incluirEsquerda(NO *no){
         int compara;
        if(no->esquerda == NULL){
            NO *novo = (NO*)malloc(sizeof(NO));
            printf("\nENTRE COM O NOME DA PESSOA:\t");
            fgets(novo->p1->nome, 30, stdin);
            printf("\nENTRE COM O CPF:\t");
            fgets(novo->p1->cpf, 11, stdin);
            printf("\nENTRE COM O SEXO:\t");
            fgets(novo->p1->sexo, 10, stdin);
            printf("\nENTRE COM A NATURALIDADE:\t");
            fgets(novo->p1->natural, 15, stdin);
            printf("\nENTRE COM O NOME DO PAI:\t");
            fgets(novo->p1->nomePai, 30, stdin);
            printf("\nENTRE COM O NOME DA MAE:\t");
            fgets(novo->p1->nomeMae, 30, stdin);
            printf("\nENTRE COM O ENDEREÇO:\t");
            printf("LOGRADOURO:\t");
            fgets(novo->p1->end->logradouro, 30, stdin);
            printf("\nENTRE COM O COMPLEMENTO:\t");
            fgets(novo->p1->end->complemento, 30, stdin);
            printf("\nENTRE COM O BAIRRO:\t");
            fgets(novo->p1->end->bairro, 30, stdin);
            printf("\nENTRE COM A CIDADE:\t");
            fgets(novo->p1->end->cidade, 30, stdin);
            printf("\nENTRE COM O ESTADO:\t");
            fgets(novo->p1->end->estado, 30, stdin);
            printf("\nENTRE COM O PAIS:\t");
            fgets(novo->p1->end->pais, 30, stdin);
            printf("\nENTRE COM O CEP:\t");
            fgets(novo->p1->end->cep, 30, stdin);
            printf("\nENTRE COM OS DADOS DE CONTATO:\t");
            printf("\nENTRE COM O EMAIL:\t");
            fgets(novo->p1->cont->email, 30, stdin);
            printf("\nENTRE COM O TELEFONE:\t");
            fgets(novo->p1->cont->telefone, 15, stdin);
            novo->direita = NULL; novo->esquerda = NULL;
            
        }else{
             do{    
        compara = strcmp(&novo->p1->cpf, &no->p1->cpf);
            if (compara < 0 )
            {
                incluirEsquerda(no->esquerda);
            }else if (compara > 0)
            {
                incluirDireita(no->direita);
            }
            if(compara == 0){
                system("cls");
                printf("O CPF já está cadastrado digite novamente");
            }
        }while(compara != 0);
        }
        
}
void incluirDireita(NO *no){
    int compara;
        if(no->direita == NULL){
         NO *novo = (NO*)malloc(sizeof(NO));
         printf("\nENTRE COM O NOME DA PESSOA:\t");
        fgets(novo->p1->nome, 30, stdin);
         printf("\nENTRE COM O CPF:\t");
        fgets(novo->p1->cpf, 11, stdin);
         printf("\nENTRE COM O SEXO:\t");
        fgets(novo->p1->sexo, 10, stdin);
         printf("\nENTRE COM A NATURALIDADE:\t");
        fgets(novo->p1->natural, 15, stdin);
         printf("\nENTRE COM O NOME DO PAI:\t");
        fgets(novo->p1->nomePai, 30, stdin);
         printf("\nENTRE COM O NOME DA MAE:\t");
        fgets(novo->p1->nomeMae, 30, stdin);
         printf("\nENTRE COM O ENDEREÇO:\t");
         printf("LOGRADOURO:\t");
        fgets(novo->p1->end->logradouro, 30, stdin);
         printf("\nENTRE COM O COMPLEMENTO:\t");
        fgets(novo->p1->end->complemento, 30, stdin);
         printf("\nENTRE COM O BAIRRO:\t");
        fgets(novo->p1->end->bairro, 30, stdin);
         printf("\nENTRE COM A CIDADE:\t");
        fgets(novo->p1->end->cidade, 30, stdin);
         printf("\nENTRE COM O ESTADO:\t");
        fgets(novo->p1->end->estado, 30, stdin);
         printf("\nENTRE COM O PAIS:\t");
        fgets(novo->p1->end->pais, 30, stdin);
         printf("\nENTRE COM O CEP:\t");
        fgets(novo->p1->end->cep, 30, stdin);
         printf("\nENTRE COM OS DADOS DE CONTATO:\t");
         printf("\nENTRE COM O EMAIL:\t");
        fgets(novo->p1->cont->email, 30, stdin);
         printf("\nENTRE COM O TELEFONE:\t");
        fgets(novo->p1->cont->telefone, 15, stdin);
        novo->direita = NULL; novo->esquerda = NULL;
            
        }else{
           do{    
                compara = strcmp(novo->p1->cpf, no->p1->cpf);
            if (compara < 0 )
            {
                incluirEsquerda(no->direita);
            }else if (compara > 0)
            {
                incluirDireita(no->direita);
            }
            if(compara == 0){
                system("cls");
                printf("O CPF já está cadastrado digite novamente");
            }
        }while(compara != 0);
        }
        

}
void listar(){

}

int main(){

    ARVORE arv1;
    int opcao;
    incializarArvore(&arv1);

    	do{
		opcao = menu();
		switch(opcao){
			case 1:
				printf("\nINCLUIR\n");
                incluir(&arv1);
				system("cls");
				break;
			case 2:
				printf("\nLISTAR\n");
				break;
			case 3:
				printf("\nALTERAR\n");
				break;
			case 4:
				printf("\nEXCLUIR\n");
				break;
			case 5:
				printf("\nDESTRUIR\n");
				break;
			case 6:
				printf("\nSAIR\n");
				break;
		}
	}while(opcao != 0);

    return 0;
}