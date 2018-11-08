#ifndef FILA_H_INCLUDED
#define FILA_H_INCLUDED
#include "Arvore.h"

typedef struct Node* Apontador;
typedef struct Node
{
    Arv vertice;
    Apontador next;
} Node;

typedef struct Fila
{
    Apontador inicio, fim;
    int tamanho;
} Fila;


Fila* cria_Fila ();

void insere_Fila(Arv y, Fila* fila);

void imprimeFila (Fila fila);

Arv retiraPrimeiro (Fila* fila);
#endif // FILA_H_INCLUDED
