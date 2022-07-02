/* 
Hevert Sousa UC19106625
Estrutura de Dados 
Professora Hialy

Construir uma árvore binária para armazenar registros de dados pessoais
Cada registro, ou pessoa registrada deverá conter as seguintes informações 
Dados Pessoais: nome, cpf, sexo, data de nascimento, naturalidade, nome pai, nome mae  
Dados Endereço: logradouro, número, complemento, bairro, cidade, CEP, estado, pais
Dados Contato: e-mail, telefone. 
    Para atividade final da disciplina adicionar também a exclusão na árvore binária 
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Estruturas da árvore e dos dados do programa*/
typedef struct ENDERECO
{
    char logradouro[30], complemento[15], bairro[15], cidade[20], estado[15], pais[15], cep[8];
    int numero;
} end;

typedef struct contato
{
    char email[30], telefone[15];
} cont;

typedef struct PESSOA
{
    char nome[30], cpf[11], sexo[10], natural[15], nomePai[30], nomeMae[30];
    end endereco;
    cont contato;
} pessoa;

typedef struct no
{
    struct no *esquerda, *direita;
    pessoa p1;
} NO;

typedef struct
{
    NO *raiz;
} ARVORE;

/* Funções de CRUD e menu do programa*/

void criarArvore(ARVORE *arv1)
{
    arv1->raiz = NULL;
    system("cls");

}

NO recebeDados(ARVORE *arv1, int compara)
{

    NO *novo = (NO *)malloc(sizeof(NO));
    fflush(stdin);
    printf("\nENTRE COM O CPF:\t");
    fflush(stdin);
    fgets(novo->p1.cpf, 11, stdin);
    printf("\nENTRE COM O NOME DA PESSOA:\t");
    fflush(stdin);
    fgets(novo->p1.nome, 30, stdin);
    printf("\nENTRE COM O SEXO:\t");
    fflush(stdin);
    fgets(novo->p1.sexo, 10, stdin);
    printf("\nENTRE COM A NATURALIDADE:\t");
    fflush(stdin);
    fgets(novo->p1.natural, 15, stdin);
    printf("\nENTRE COM O NOME DO PAI:\t");
    fflush(stdin);
    fgets(novo->p1.nomePai, 30, stdin);
    printf("\nENTRE COM O NOME DA MAE:\t");
    fflush(stdin);
    fgets(novo->p1.nomeMae, 30, stdin);
    fflush(stdin);
    system("cls");
    printf("\nENTRE COM O ENDEREÇO:\t");
    printf("\nLOGRADOURO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.logradouro, 30, stdin);
    printf("\nENTRE COM O COMPLEMENTO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.complemento, 30, stdin);
    printf("\nENTRE COM O BAIRRO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.bairro, 30, stdin);
    printf("\nENTRE COM O NUMERO:\t");
    fflush(stdin);
    scanf("%d", &novo->p1.endereco.numero);
    printf("\nENTRE COM A CIDADE:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.cidade, 30, stdin);
    printf("\nENTRE COM O ESTADO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.estado, 30, stdin);
    printf("\nENTRE COM O PAIS:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.pais, 30, stdin);
    printf("\nENTRE COM O CEP:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.cep, 30, stdin);
    fflush(stdin);
    system("cls");
    printf("\nENTRE COM OS DADOS DE CONTATO:\t");
    printf("\nENTRE COM O EMAIL:\t");
    fflush(stdin);
    fgets(novo->p1.contato.email, 30, stdin);
    printf("\nENTRE COM O TELEFONE:\t");
    fflush(stdin);
    fgets(novo->p1.contato.telefone, 15, stdin);
    if(arv1->raiz == NULL){
        novo->direita = NULL;
        novo->esquerda = NULL;
        arv1->raiz = novo;
    }
     else if (compara > 0)
    {
        novo->direita = NULL;
        novo->esquerda = NULL;
        arv1->raiz->esquerda = novo;
    }
    else if (compara < 0)
    {
        novo->direita = NULL;
        novo->esquerda = NULL;
        arv1->raiz->direita = novo;
    }
}

void imprimir(NO *raiz)
{
    if (raiz != NULL) {
        
        imprimir(raiz->esquerda);
        printf("==================================\n");
        printf("\nCPF: %s", raiz->p1.cpf);
        printf("\nNOME: %s", raiz->p1.nome);
        printf("\nSEXO: %s", raiz->p1.sexo);
        printf("\nNATURALIDADE: %s", raiz->p1.natural);
        printf("\nNOME DO PAI: %s", raiz->p1.nomePai);
        printf("\nNOME DA MAE: %s", raiz->p1.nomeMae);
        printf("DADOS DE ENDERECO");
        printf("\nLOGRADOURO: %s ", raiz->p1.endereco.logradouro);
        printf("\nCOMPLEMENTO: %s ", raiz->p1.endereco.complemento);
        printf("\nNUMERO: %d", raiz->p1.endereco.numero);
        printf("\nBAIRRO: %s ", raiz->p1.endereco.bairro);
        printf("\nCIDADE: %s ", raiz->p1.endereco.cidade);
        printf("\nESTADO: %s ", raiz->p1.endereco.estado);
        printf("\nPAIS: %s ", raiz->p1.endereco.pais);
        printf("\nCEP: %s ", raiz->p1.endereco.cep);
        printf("DADOS DE CONTATO:");
        printf("\nEMAIL: %s", raiz->p1.contato.email);
        printf("\nTELEFONE: %s", raiz->p1.contato.telefone);
        imprimir(raiz->direita);
    }
}

int quantidadeDeNos(NO *raiz){
    if(raiz == NULL){
        return 0;
    }else{
        return 1+quantidadeDeNos(raiz->esquerda) + quantidadeDeNos(raiz->direita); 
    }
}

int menu(void)
{
    int opcao;
    do
    {

        printf("\n=====================");
        printf("\n|**MENU DE SELECAO**|");
        printf("\n=====================");
        printf("\n=== 1 INCLUIR\t=====");
        printf("\n=== 2 LISTAR\t=====");
        printf("\n=== 3 BUSCAR\t=====");
        printf("\n=== 4 EXCLUIR\t=====");
        printf("\n=== 5 DESTRUIR\t=====");
        printf("\n=== 0 SAIR\t=====");
        printf("\n=====================\n");
        fflush(stdin);
        scanf("%d", &opcao);
        if (opcao < 0 || opcao > 5)
        {
            system("cls");
            
            printf("\n\n***ATENCAO ENTRE COM UMA OPCAO VALIDA!!!");
        }
    } while (opcao < 0 || opcao > 5);
    system("cls");
    return opcao;
}

NO *buscar(NO *raiz, char cpf[11]){
    int compara;

    while (raiz != NULL)
    {
          compara = strcmp(cpf, raiz->p1.cpf);
          if (compara == 0)
                {
                   return raiz;
                }
    }
    return NULL;
}

NO* remover(NO *raiz, char cpf[11]) {
  if (raiz != NULL) {
  	if (strcmp(raiz->p1.cpf, cpf) == 0) {
      if (raiz->esquerda == NULL && raiz->direita == NULL) {
        free(raiz);
        printf("Elemento folha removido: %s !\n", cpf);
        return NULL;
      } else if(strcmp(raiz->esquerda->p1.cpf, cpf) == 0) {
        if (raiz->esquerda != NULL && raiz->direita != NULL) {
	        pessoa p2;
	          NO *aux = raiz->esquerda;
	          while (aux->direita != NULL){ 
	          	  aux = aux->direita;
			  }
	          p2 = raiz->p1;
	          raiz->p1 = aux->p1;
	          aux->p1 = p2;
	          printf("Elemento trocado: %s !\n", cpf);
	          raiz->esquerda = remover(raiz->esquerda, cpf);
	          return raiz;
        } else {
          NO *aux;
          if (raiz->esquerda != NULL){
          	 aux = raiz->esquerda;
		  }else {
		  	 aux = raiz->direita;
		  }
          free(raiz);
          printf("Elemento com 1 filho removido: %s !\n", cpf);
          return aux;
        }
      }
    } else {
      if (strcmp(raiz->esquerda->p1.cpf, cpf) < 0)
        raiz->esquerda = remover(raiz->esquerda, cpf);
      else
        raiz->direita = remover(raiz->direita->p1.cpf, cpf);
      return raiz;
    }
    
  } else {
    printf("Valor nao encontrado!\n");
    return NULL;
  }
}

	/* Função principal do programa*/

int main(void)
{

    char cpf[11];
    int compara = 0, opcao;
    NO *busca, *raiz = NULL; 
    ARVORE arv1;
    criarArvore(&arv1);
    do
    {
        opcao = menu();
        switch (opcao)
        {
        case 1:
            printf("\nINCLUIR\n");
            if (arv1.raiz == NULL)
            {
                recebeDados(&arv1, compara);
            }
            else
            {
                printf("\nDigite o CPF que quer incluir:\t ");
                fflush(stdin);
                fgets(cpf, 11, stdin);
                compara = strcmp(cpf, arv1.raiz->p1.cpf);
                if (compara > 0)
                {
                    recebeDados(&arv1, compara);
                }
                else if (compara < 0)
                {
                    recebeDados(&arv1, compara);
                }
                else if (compara == 0)
                {
                    system("cls");
                    printf("O CPF ja esta cadastrado digite novamente");
                }
            }
            system("cls");
            break;
        case 2:
            printf("\nLISTAR\n");
            if(arv1.raiz == NULL){
                printf("Árvore VAZIA!!!\n");
            }else{
                imprimir(arv1.raiz);
            }
            break;
        case 3:
            printf("\nBUSCAR\n");
                printf("\n\tDigite o CPF procurado: ");
                fflush(stdin);
                fgets(cpf, 11, stdin);
                busca = buscar(arv1.raiz, cpf);
                if (busca) {
                    printf("\n\tValor encontrado:\n");
                imprimir(busca);
                } else{
                    printf("\n\tValor nao encontrado!\n");
                } 
            break;
        case 4:
            printf("\nEXCLUIR\n");
                printf("\t");
                printf("\n\tDigite o CPF a ser removido: ");
                fflush(stdin);
                fgets(cpf, 11, stdin);
                raiz = remover(arv1.raiz, cpf);
            break;
        case 5:
            printf("\nDESTRUIR\n");
            break;
        case 6:
            printf("\nSAIR\n");
            break;
        }
    } while (opcao != 0);

    return 0;
}