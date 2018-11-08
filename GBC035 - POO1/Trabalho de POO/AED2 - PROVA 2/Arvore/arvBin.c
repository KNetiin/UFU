/*
#include "arvBin.h"
#include <stdlib.h>
#include <stdio.h>

Arv cria_vazia()
{
    return NULL;
}

Arv cria_arvore(int elem, Arv esq, Arv dir)
{
    Arv raiz = (struct no*) malloc(sizeof (struct no));
    if(raiz == NULL) return NULL;
    raiz->info = elem;
    raiz->sae = esq;
    raiz->sad = dir;
    return raiz;
}

int arvore_vazia(Arv A)
{
    if(A == NULL) return 1;
    return 0;
}

void libera_arvore(Arv *A)
{
    if(*A == NULL) return;
    libera_arvore(&((*A)->sae));
    libera_arvore(&((*A)->sad));
    free(*A);
    *A = NULL;
}

int busca(Arv A, int elem)
{
    if(A == NULL) return 0;
    if(A->info == elem) return 1;

    if(busca(A->sae,elem) == 1) return 1;
    if(busca(A->sad,elem) == 1) return 1;
    return 0;
}

int remove_folha(Arv* A, int elem)
{
    if((*A) == NULL) return 0;

    if((*A)->info == elem)
    {
        if(((*A)->sae == NULL) && ((*A)->sad == NULL))
        {
            free((*A));
            *A = NULL;
            return 1;
        }
        return 0;
    }
    if(remove_folha(&((*A)->sae), elem) == 1) return 1;
    if(remove_folha(&((*A)->sad), elem) == 1) return 1;
    return 0;
}

void exibe_arvore(Arv A)
{
    if(A == NULL)
    {
        printf("<>");
        return;
    }
    printf("<%d",A->info);
    exibe_arvore(A->sae);
    exibe_arvore(A->sad);
    printf(">");
}
*/
