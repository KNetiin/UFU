#include <stdio.h>
#include <stdlib.h>

#include "arvBin.h"
#include "arvGen.h"

int main()
{
    printf("Hello world!\n");

    Arv A, B, C, D, E, F, G, H, I;

    A = cria_arvore(1);
    B = cria_arvore(2);
    C = cria_arvore(3);
    D = cria_arvore(4);
    E = cria_arvore(5);
    F = cria_arvore(6);
    G = cria_arvore(7);
    H = cria_arvore(8);
    I = cria_arvore(9);

    insere(F,I);
    insere(F,H);
    insere(C,F);
    insere(C,E);
    insere(D,G);
    insere(A,D);
    insere(A,C);
    insere(A,B);

    exibe_arvore(A);

    libera_arvore(&A);

    /*
    Arv A = cria_arvore(3,NULL,NULL);
    A->sad = cria_arvore(4,NULL,NULL);
    A->sae = cria_arvore(5,NULL,NULL);
    Arv B = cria_arvore(2,A,NULL);

    if(busca(B, 2) == 1) printf("\nAchou o Elemento 2");
    if(busca(B, 3) == 1) printf("\nAchou o Elemento 3");
    if(busca(B, 4) == 1) printf("\nAchou o Elemento 4");
    if(busca(B, 5) == 1) printf("\nAchou o Elemento 5");
    if(busca(B, 6) == 0) printf("\nNao Achou o Elemento 6");

    if(remove_folha(&(A->sad), 4) == 1) printf("\nRemoveu o Elemento 4");
    if(remove_folha(&B, 6) == 0) printf("\nNao Removeu o Elemento 6");
    if(remove_folha(&B, 3) == 0) printf("\nNao Removeu o Elemento 3");
    if(remove_folha(&B, 5) == 1) printf("\nRemoveu o Elemento 5");
    if(remove_folha(&B, 2) == 0) printf("\nNao Removeu o Elemento 2");
    if(remove_folha(&B, 3) == 1) printf("\nRemoveu o Elemento 3");
    if(remove_folha(&B, 2) == 1) printf("\nRemoveu o Elemento 2");

    Arv A = cria_arvore(1,NULL,NULL);
    Arv C = cria_arvore(3,NULL,NULL);
    Arv B = cria_arvore(2,NULL,NULL);
    A->sad = C;
    A->sae = B;
    C->sad = cria_arvore(7,NULL,NULL);
    B->sad = cria_arvore(5,NULL,NULL);
    B->sae = cria_arvore(4,NULL,NULL);

    if(busca(A, 7) == 1) printf("\nAchou o Elemento G");

    printf("\n");
    exibe_arvore(A);
    libera_arvore(&B);
    */

    return 0;
}
