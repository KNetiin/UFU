#include <stdio.h>
#include <stdlib.h>
#include "arvABB.h"

int main()
{
    printf("Hello world!\n");

    Arv A;

    A = cria_arvore();

    reg um, dois, tres, quatro;

    um.chave = 1;
//    um.curso = "comp1";
  //  um.nome = "yep1";
    dois.chave = 2;
  //  dois.curso = "comp2";
  //  dois.nome = "yep2";
    tres.chave = 3;
  //  tres.curso = "comp3";
  //  tres.nome = "yep3";
    quatro.chave = 4;
  //  quatro.curso = "comp4";
  //  quatro.nome = "yep4";


    insere_ord(&A, quatro);
    insere_ord(&A, um);
    insere_ord(&A, dois);
    insere_ord(&A, tres);
    insere_ord(&A, um);
    insere_ord(&A, dois);

    printf("\n\n");
    exibe_arvore(A);
    printf("\n\n");
    exibe_ordenado(A);

    remove_ord(&A, 4);
    remove_ord(&A, 2);
    remove_ord(&A, 1);

    printf("\n\n");
    exibe_arvore(A);
    printf("\n\n");
    exibe_ordenado(A);

    libera_arvore(&A);
    return 0;
}
