#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "AVL.h"

int main()
{

    printf("Trabalho de AED2\n\nIntegrantes:\nAntonio Carlos Neto:\t 11611BCC054\nLucas Rossi Rabelo:\t 11611BCC044\nPaulo Renato C. Barbosa: 11611BCC006\n\n");
    int valor, cont;

///**********************************Montagem da Arvore************************************************///
    reg p1,p2,p3,p4,p5,p6,p7;
    Arv A;
    p1.chave=120;
    p1.id=3;
    p1.capacidade=50;
    p1.local=134;

    p2.chave=110;
    p2.id=1;
    p2.capacidade=14;
    p2.local=145;

    p3.chave=150;
    p3.id=5;
    p3.capacidade=32;
    p3.local=98;

    p4.chave=100;
    p4.id=8;
    p4.capacidade=100;
    p4.local=105;

    p5.chave=130;
    p5.id=2;
    p5.capacidade=30;
    p5.local=150;

    p6.chave=200;
    p6.id=9;
    p6.capacidade=65;
    p6.local=101;

    p7.chave=80;
    p7.id=11;
    p7.capacidade=70;
    p7.local=121;

    int Bal;
    A=cria_vazia();
    insere_AVL(&A,p1,&Bal);
    insere_AVL(&A,p2,&Bal);
    insere_AVL(&A,p3,&Bal);
    insere_AVL(&A,p4,&Bal);
    insere_AVL(&A,p5,&Bal);
    insere_AVL(&A,p6,&Bal);
    insere_AVL(&A,p7,&Bal);

    A1=cria_vazia();
    insere_AVL(&A1,p1,&Bal);
    insere_AVL(&A1,p2,&Bal);
    insere_AVL(&A1,p3,&Bal);
    insere_AVL(&A1,p4,&Bal);
    insere_AVL(&A1,p5,&Bal);

///*****************************************************************************************************///

     do
    {
        printf("Escolha uma das Opcoes:\n");
        printf("1 - Ponto de rede de dados com menor trafego\n2 - Quantidade de pontos que usam metade de sua capacidade\n3 - Quantidade de nos folha da arvore\n4 - Verificar se arvore eh cheia\n5 - Verificar profundidade de determinado no\n6 - Verificar igualdade entre arvores\n7 - Inserir um novo no na arvore\n8 - Exibir arvore de forma ordenada\n0 - Sair\n\n");
        printf("Digite Sua Opcao: ");
        scanf("%d",&cont);
        if(cont == 1)
        {
            reg* aux = menor_trafego(A);
            if(aux != NULL){
                printf("\nPonto de rede(id) com menor trafego: %d", aux->id);
                printf("\n");
            }
        }
        else if(cont == 2)
        {
            printf("\nQuantidade de pontos usando menos da metade de sua capacidade: %d", qtde_ocioso(A));
            printf("\n");
        }
        else if(cont == 3)
        {
            printf("\nNumero de folhas da arvore: %d", nro_folha(A));
            printf("\n");
        }
        else if(cont == 4)
        {
            printf("\nVerificando se a arvore eh cheia: ");
            if(cheia(A) == 1)
                printf("VERDADEIRO\n");
            else
                printf("FALSO\n");
            printf("\n");
        }
        else if(cont == 5)
        {
            reg p;
            printf("Digite o trafego(chave) do no a ser analisado: ");
            scanf("%d", &p.chave);
            printf("Digite o identificador do ponto de rede a ser analisado: ");
            scanf("%d", &p.id);
            printf("Digite a capacidade do no a ser analisado: ");
            scanf("%d", &p.capacidade);
            printf("Digite a localizacao do no a ser analisado: ");
            scanf("%d", &p.local);

            printf("\nProfundidade do elemento anteriormente definido: ");
            valor = nivel_no(A,p);
            if(valor == -1)
                printf("No nao existente\n");
            else{
                printf("%d\n", valor);
            }
        }
        else if(cont == 6)
        {
            printf("\nVerificando se as arvores sao iguais: ");
            if(iguais(A,A1) == 1)
                printf("VERDADEIRO\n");
            else
                printf("FALSO\n");
            printf("\n")
        }
        else if(cont == 7)
        {
            reg p;
            printf("Digite o trafego(chave) do no a ser inserido: ");
            scanf("%d", &p.chave);
            printf("Digite o identificador do no a ser inserido: ");
            scanf("%d", &p.id);
            printf("Digite a capacidade do no a ser inserido: ");
            scanf("%d", &p.capacidade);
            printf("Digite a localizacao do no a ser inserido: ");
            scanf("%d", &p.local);
            insere_AVL(&A, p, &Bal);
        }
        else if(cont == 8)
        {
            printf("\nArvore ordenada: ");
            exibe_ordenado(A);
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


   return 0;
}
