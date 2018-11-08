#include <stdlib.h>
#include <stdio.h>
#include "arvABB.h"

Arv cria_arvore()
{
    return NULL;
}

int arvore_vazia(Arv *A)
{
    if((*A) == NULL) return 1;
    return 0;
}

void libera_arvore(Arv *A)
{
    if((*A) == NULL) return;
    libera_arvore(&((*A)->sae));
    libera_arvore(&((*A)->sad));
    free(*A);
    (*A) = NULL;
}

void exibe_arvore(Arv A)
{
    if(A == NULL)
    {
        printf("<>");
        return;
    }

    printf("<");
    printf("%d",A->info.chave);
    exibe_arvore(A->sae);
    exibe_arvore(A->sad);
    printf(">");
}

void exibe_ordenado(Arv A)
{
    if(A == NULL) return;
    exibe_ordenado(A->sae);
    printf("%d ", A->info.chave);
    exibe_ordenado(A->sad);
}

int insere_ord(Arv *A, reg elem)
{
    if(A == NULL) return 0;
    if((*A) == NULL)
    {
        Arv no = (struct no*) malloc(sizeof(struct no));
        if(no == NULL) return 0;

        no->info = elem;
        no->sad = NULL;
        no->sae = NULL;
        (*A) = no;
        return 1;
    }
    if(elem.chave > (*A)->info.chave) return insere_ord(&((*A)->sad), elem);
    return insere_ord(&((*A)->sae), elem);
}

int remove_ord(Arv *A, int chave)
{
    Arv aux;
    if(A == NULL) return 0;
    if((*A) == NULL) return 0;
    if(chave > (*A)->info.chave) return remove_ord(&((*A)->sad), chave);
    if(chave < (*A)->info.chave) return remove_ord(&((*A)->sae), chave);

    if((*A)->sad == NULL && (*A)->sae == NULL)
    {
        free(*A);
        (*A) = NULL;
        return 1;
    }

    if((*A)->sae != NULL && (*A)->sad == NULL)
    {
        aux = (*A);
        (*A) = (*A)->sae;
        free(aux);
        return 1;
    }

    if((*A)->sae == NULL && (*A)->sad != NULL)
    {
        aux = (*A);
        (*A) = (*A)->sad;
        free(aux);
        return 1;
    }

    aux = (*A)->sae;
    while(aux->sad != NULL) aux = aux->sad;
    reg temp = (*A)->info;
    (*A)->info = aux->info;
    aux->info = temp;
    return remove_ord(&((*A)->sae), chave);
}

Arv busca_bin(Arv A, int chave)
{
    if(A == NULL) return NULL;
    if(A->info.chave == chave) return A;
    if(chave > A->info.chave) return busca_bin(A->sad,chave);
    return busca_bin(A->sae,chave);
}

