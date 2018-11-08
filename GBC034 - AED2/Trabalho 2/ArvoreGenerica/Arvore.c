#include <stdlib.h>
#include <stdio.h>
#include "Arvore.h"
#include "fila.h"

struct no
{
    int info;
    struct no* esq;
    struct no* dir;
};


Arv cria_arvore(int elem)
{
    struct no* node = (struct no*) malloc(sizeof(struct no));
    if(node == NULL)
        return NULL;

    node->info = elem;
    node->esq = NULL;
    node->dir = NULL;

    return node;
}


int insere(Arv A, Arv sa)
{
    if(A == NULL)
        return 0;

    sa->dir = A->esq;
    A->esq = sa;
    return 1;
}


void exibe_arvore(Arv A)
{
    if(A == NULL)
    {
        printf("<>");
        return;
    }

    printf("<");
    printf("%d", A->info);
    exibe_arvore(A->esq);
    exibe_arvore(A->dir);
    printf(">");
}


int busca(Arv A, int elem)
{
    if(A == NULL)
        return 0;

    if(A->info == elem)
        return 1;

    if(busca(A->esq,elem) == 1)
        return 1;

    if(busca(A->dir,elem) == 1)
        return 1;

    return 0;
}


void libera_arvore(Arv *A)
{
    if(*A == NULL)
        return;

    libera_arvore(&(*A)->esq);
    libera_arvore(&(*A)->dir);
    free(*A);

    *A = NULL;
}


int altura_arvore(Arv A)
{
    int hmax = -1; /* -1 para arv. sem filhos */
    Arv p;
    for (p=A->esq; p!=NULL; p=p->dir)
    {
        int h = altura_arvore(p);
        if (h > hmax)
            hmax = h;
    }
    return hmax + 1;
}


int pre_order(Arv A)
{
    Arv p = A;
    if(p != NULL)
    {
        printf("%d ", p->info);
        pre_order(p->esq);
        pre_order(p->dir);
        return 1;
    }
    return 0;
}


int pos_order(Arv A)
{
    Arv p = A;
    if(p != NULL)
    {
        pos_order(p->esq);
        printf("%d ", p->info);
        pos_order(p->dir);
        return 1;
    }
    return 0;
}


int percorre_nivel(Arv A)
{
    Arv p = A;
    Fila* fila = cria_Fila();

    if(p == NULL)
        return -1;
    insere_Fila(p, fila);
    printf("%d ", p->info);

    while(fila->tamanho != 0)
    {
        if(p->dir == NULL)
        {
            p = retiraPrimeiro(fila);
            while(p->esq == NULL)
            {
                if(fila->tamanho == 0 )
                    return 1;
                p = retiraPrimeiro(fila);
            }
            p = p -> esq;
            insere_Fila(p, fila);
            printf("%d ", p->info);
        }
        else
        {
            p = p -> dir;
            insere_Fila(p, fila);
            printf("%d ", p->info);
        }
    }
    return 1;
}


int nro_derivacao(Arv A)
{
    if(A == NULL)
        return 0;
    int cont = 0;
    Arv p = A;

    if(p->esq != NULL)
    {
        cont = 1 + nro_derivacao(p->esq);
        cont += nro_derivacao(p->dir);
        return cont;
    }
    else
        return nro_derivacao(p->dir);
}


int grau_arv(Arv A)
{
    if(A == NULL) return 0;
    if(A->esq == NULL) return 0;

    int maior = 1, aux2, y;
    Arv aux;
    aux = A->esq;

    aux2 = grau_arv(aux);

    while(aux->dir != NULL)
    {
        aux = aux->dir;
        y = grau_arv(aux);
        if(y > aux2) aux2 = y;
        maior++;
    }

    if(aux2 > maior) return aux2;
    return maior;
}


int grau_no(Arv A)
{
    if(A == NULL) return 0;
    if(A->esq == NULL) return 0;
    int qtd = 1;
    Arv aux = A->esq;
    while(aux->dir != NULL)
    {
        aux = aux->dir;
        qtd++;
    }
    return qtd;
}


int qtde_nos(Arv A, int grau)
{
    if(A == NULL) return 0;
    if(A->esq == NULL)
    {
        if(grau == 0) return 1;
        return 0;
    }

    Arv aux;
    aux = A->esq;
    int num;
    num = qtde_nos(aux,grau);
    if(grau_no(A) == grau) num++;
    while(aux->dir != NULL)
    {
        aux = aux->dir;
        num += qtde_nos(aux,grau);
    }
    return num;
}


int altura_no(Arv A, int elem)
{
    if(A == NULL)
        return -1;

    int aux = 0;
    if(A->info == elem)
    {
        Arv p = A;
        return altura_arvore(p);
    }
    else
    {
        aux = altura_no(A->esq, elem);
        if(aux != -1)
            return aux;
        aux = altura_no(A->dir, elem);
        if(aux != -1)
            return aux;
        return -1;
    }
}
