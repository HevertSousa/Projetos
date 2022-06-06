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

int menu (void);

int main (void){
	int opcao;
	setlocale(LC_ALL, "portuguese");
	do{
		opcao = menu();
		switch(opcao){
			case 1:
				printf("\nINCLUIR\n");
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