#include "pilha.h"
/**Fun��o para criar a pilha**/

Stack cria_pilha(Stack *pilha)
{

    pilha->Size = 0;
    pilha->head = NULL;
    pilha->tail = NULL;


    return *pilha;

}


void adiciona_pilha(Stack *pilha, int movimento, int Linha, int Coluna)
{
    Node *celula = (Node*)malloc(sizeof(Node*)); /**Criando a c�lula da pilha**/
    celula->Movimento = movimento;
    celula->Linha = Linha;
    celula->Coluna = Coluna;
    if(pilha->head == NULL)  /**Condi��o da pilha vazia**/
    {
        pilha->head = celula;
        pilha->tail = celula;
        celula->next = NULL;
        pilha->Size++;
    }
    else
    {
        Node *aux = pilha->tail;    /**Condi��o da pilha n�o vazia**/
        pilha->tail = celula;
        aux->next = celula;
        celula->next = NULL;
        pilha->Size++;

    }
}

void remove_pilha(Stack *pilha)
{
    /**Primeiro testar se a pilha est� vazia**/
    if(pilha->head == NULL)
    {
        printf ("\nNao eh possivel remover elementos de uma lista vazia!\n");
    }
    if(pilha->head == pilha->tail)          /**Quando a pilha s� tem um elemento, e o mesmo � removido**/
    {
        pilha->Size--;
        free(pilha->head);
        pilha->head = NULL;
        pilha->tail = NULL;
    }
    else                                /**Quando a pilha tem mais de um elemento**/
    {
        Node *aux = pilha->head;
        while(aux->next->next != NULL)
        {
            aux = aux->next;
        }
        pilha->tail = aux;
        free(aux->next);
        aux->next = NULL;
        pilha->Size--;
    }

}

//void escreve_pilha(Stack *pilha)            /**Fun��o de apoio, para caso precisemos encontrar erros**/
//{
//    if(pilha->head == NULL)
//    {
//        printf ("\nA pilha esta vazia\n");
//    }
//    else
//    {
//        Node *aux = pilha->head;
//        do
//        {
//            printf ("%d\n", aux->Movimento);
//            aux = aux->next;
//
//        }
//        while(aux->next != NULL);
//        printf("%d\n", pilha->tail->Movimento); /**Gambiarra fodelosa**/
//        printf ("A pilha contem um total de %d elementos", pilha->Size);
//
//    }
//
//}

