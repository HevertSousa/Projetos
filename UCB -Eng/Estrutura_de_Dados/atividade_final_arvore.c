#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

void criarArvore(ARVORE *arv1)
{
    arv1->raiz = NULL;
    system("cls");
    printf("ARVORE INCIADA COM SUCESSO");
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
    printf("LOGRADOURO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.logradouro, 30, stdin);
    printf("\nENTRE COM O COMPLEMENTO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.complemento, 30, stdin);
    printf("\nENTRE COM O BAIRRO:\t");
    fflush(stdin);
    fgets(novo->p1.endereco.bairro, 30, stdin);
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
    if (compara == 0)
    {
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
    if (raiz != NULL)
    {
    
    imprimir(raiz->esquerda);
    printf("\nCPF: %s\t", raiz->p1.cpf);
    printf("\nNOME: %s\t", raiz->p1.nome);
    printf("\nSEXO: %s\t", raiz->p1.sexo);
    printf("\nNATURALIDADE: %s\t", raiz->p1.nomePai);
    printf("\nNOME DO PAI: %s\t", raiz->p1.nomeMae);
    printf("\nNOME DA MAE: %s\t", raiz->p1.nomeMae);
    printf("\n==================================\n");
    printf("\nDADOS DE ENDEREÇO\t");
    printf("LOGRADOURO: %s \t", raiz->p1.endereco.logradouro);
    printf("\nCOMPLEMENTO: %s \t", raiz->p1.endereco.complemento);
    printf("\n BAIRRO: %s \t", raiz->p1.endereco.bairro);
    printf("\nCIDADE: %s \t", raiz->p1.endereco.cidade);
    printf("\nESTADO: %s \t", raiz->p1.endereco.estado);
    printf("\nPAIS: %s \t", raiz->p1.endereco.pais);
    printf("\nCEP: %s \t", raiz->p1.endereco.cep);
    printf("\n==================================\n");
    printf("\nDADOS DE CONTATO:\t");
    printf("\nEMAIL: %s\t", raiz->p1.contato.email);
    printf("\nTELEFONE: %s\t", raiz->p1.contato.telefone);
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
        printf("\n=== 3 ALTERAR\t=====");
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

int main(void)
{

    char cpf[11];
    int compara, opcao;
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
                recebeDados(&arv1, 0);
            }
            else
            {
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
                    printf("O CPF já está cadastrado digite novamente");
                }
            }
            system("cls");
            break;
        case 2:
            printf("\nLISTAR\n");
            imprimir(arv1.raiz);
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
    } while (opcao != 0);

    return 0;
}