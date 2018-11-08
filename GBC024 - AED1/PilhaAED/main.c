#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

int main()
{
    Stack pilha;
    pilha = cria_pilha(&pilha);
    int x = 9;
    adiciona_pilha(&pilha,x);

    x = 60;
    adiciona_pilha(&pilha,x);
    adiciona_pilha(&pilha,8);

    escreve_pilha(&pilha);

    return 0;
}
