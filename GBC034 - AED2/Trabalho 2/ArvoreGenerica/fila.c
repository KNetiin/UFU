#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

Fila* cria_Fila ()
{
    Fila* fila = (Fila*)malloc(sizeof(Fila));
    if(fila == NULL)
    {
        printf("Erro de alocacao");
        return;
    }
    fila->fim = NULL;
    fila->inicio = fila->fim;
    fila->tamanho = 0;
    return fila;
}

void insere_Fila(Arv y, Fila* fila)
{
    Node *x = (Node*) malloc (sizeof(Node));
    if(x == NULL)
    {
        printf("Erro de alocacao");
        return;
    }
    if(fila->tamanho == 0)
    {
        x->vertice = y;
        fila->inicio = x;
        fila->fim = x;
        x->next = NULL;
        fila->tamanho ++;
    }
    else
    {
        x->vertice = y;
        fila->fim->next = x;
        x->next = NULL;
        fila->fim = x;
        fila->tamanho ++;
    }
}

Arv retiraPrimeiro (Fila* fila)
{
    if(fila == NULL)
        return NULL;
    Node* aux = fila->inicio;
    Arv p = fila->inicio->vertice;
    fila->inicio = fila->inicio->next;
    free(aux);
    fila->tamanho --;
    return p;
}

void imprimeFila (Fila fila)
{
    Node *x = (Node*) malloc (sizeof(Node));
    if(x == NULL)
    {
        printf("Erro de alocacao");
        return;
    }
    int i = 0;
    x = fila.inicio;
    for(i=0; i<fila.tamanho; i++)
    {
        if(i== fila.tamanho-1)
            printf("[%d]-->null\n", x->vertice);
        else
        {
            printf("[%d]-->", x->vertice);
            x = x->next;
        }
    }
}
