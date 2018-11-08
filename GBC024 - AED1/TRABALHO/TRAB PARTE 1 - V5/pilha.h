#include <stdio.h>
#include <stdlib.h>

typedef struct Node{

    int             Movimento;
    int             Linha;
    int             Coluna;
    struct Node     *next;

}Node;


typedef struct Stack{
    int     Size;
    Node    *head;
    Node    *tail;

}Stack;


Stack cria_pilha(Stack *pilha);

void adiciona_pilha(Stack *pilha, int movimento, int Linha, int Coluna);

void remove_pilha(Stack *pilha);

void escreve_pilha(Stack *pilha);
