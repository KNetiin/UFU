#include <stdio.h>
#include <stdlib.h>
#include "Arvore.h"
#include "fila.h"

int main()
{
    printf("Trabalho de AED2\n\nIntegrantes:\nAntonio Carlos Neto:\t 11611BCC054\nLucas Rossi Rabelo:\t 11611BCC044\nPaulo Renato C. Barbosa: 11611BCC006\n\n");
    int valor, cont;

///**********************************Montagem da Arvore************************************************///
    Arv A = cria_arvore(0);
    Arv B = cria_arvore(1);
    Arv C = cria_arvore(2);
    Arv D = cria_arvore(3);
    Arv E = cria_arvore(4);
    Arv F = cria_arvore(5);
    Arv G = cria_arvore(6);
    Arv H = cria_arvore(7);
    Arv I = cria_arvore(8);

    insere(F,I);
    insere(F,H);
    insere(E,G);
    insere(C,F);
    insere(C,E);
    insere(B,D);
    insere(A,C);
    insere(A,B);
///*****************************************************************************************************///



    do
    {
        printf("Escolha uma das Opcoes:\n");
        printf("1  - Realizar percorrimento pre-ordem\n2  - Realizar percorrimento pos-ordem\n3  - Realizar percorrimento em nivel\n4  - Verificar numero de nos de derivacao\n5  - Verificar grau da arvore\n6  - Verificar quantidade de nos com determinado grau\n7  - Verificar altura de dado elemento\n8  - Exibir arvore\n0  - Sair\n\n");
        printf("Digite Sua Opcao: ");
        scanf("%d",&cont);
        if(cont == 1)
        {
            printf("\nIniciando percorrimento pre-ordem...\n");
            if(pre_order(A) == 0)
                printf("\nArvore vazia\n");
            else
            {
                printf("\n");
            }
        }
        else if(cont == 2)
        {
            printf("\nIniciando percorrimento pos-ordem...\n");
            if(pos_order(A) == 0)
                printf("\nArvore vazia\n");
            else
            {
                printf("\n");
            }
        }
        else if(cont == 3)
        {
            printf("\nIniciando percorrimento em nivel...\n");
            if(percorre_nivel(A) == -1)
                printf("\nArvore vazia\n");
            else
            {
                percorre_nivel(A);
                printf("\n");
            }
        }
        else if(cont == 4)
        {
            printf("\nQuantidade de nos de derivacao da arvore: ");
            nro_derivacao(A);
            printf("\n");
        }
        else if(cont == 5)
        {
            printf("\nGrau da arvore: ");
            grau_arv(A);
            printf("\n");
        }
        else if(cont == 6)
        {
            printf("Digite o grau a ser buscado na arvore: ");
            scanf("%d", &valor);
            printf("\nQuantidade de nos da arvore que possui grau %d: ", valor);
            qtde_nos(A,valor);
            printf("\n");
        }
        else if(cont == 7)
        {
            printf("Digite o elemento a ser utilizado como referencia na arvore: ");
            scanf("%d", &valor);
            printf("\nAltura do elemento %d na arvore: ", valor);
            altura_no(A, valor);
            printf("\n");
        }
        else if(cont == 8)
        {
            printf("Exibindo arvore: ");
            exibe_arvore(A);
            printf("\n");

        }
        else if(cont == 0)
        {
            printf("SAINDO....\n");
        }
        else printf("Opcao invalida!");
        system("PAUSE");
        system("cls");
    }
    while(cont != 0);
    return 0;

}
