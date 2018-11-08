#include <stdio.h>
#include <stdlib.h>

#include "grafo.h"



Grafo* cria_grafo(int Qnt)
{
    int i;
    if(Qnt < 1)
    {
        printf("\n**ERROR** - Quantidade de Vertice Invalida! (CG)");
        return NULL;
    }

    Grafo *G = (Grafo*)(malloc(sizeof(Grafo)));
    if(G == NULL)
    {
        printf("\n**ERROR** - Erro na Alocacao do Grafo! (CG)");
        return NULL;
    }

    G->grau = (int*)(calloc(Qnt,sizeof(int)));
    if(G->grau == NULL)
    {
        printf("\n**ERROR** - Erro na Alocacao do Grau! (CG)");
        free(G);
        return NULL;
    }

    G->aresta = (Node**)(malloc(Qnt*(sizeof(Node*))));
    if(G->aresta == NULL)
    {
        printf("\n**ERROR** - Erro na Alocacao do Vetor de Arestas! (CG)");
        free(G->grau);
        free(G);
        return NULL;
    }
    for(i = 0; i < Qnt; i++)
    {
        G->aresta[i] = NULL;
    }
    G->qa = 0;
    G->qv = Qnt;
    return G;
}

void libera_grafo(Grafo** G)
{
    int i;
    Node* aux = (Node*)(malloc(sizeof(Node)));
    Node* ant = (Node*)(malloc(sizeof(Node)));

    if(*G == NULL)
    {
        printf("\n**ERROR** - Grafo inconsistente! (LG)");
        return;
    }

    free((*G)->grau);
    for(i = 0; i < (*G)->qv; i++)
    {
        aux = (*G)->aresta[i];
        while(aux != NULL)
        {
            ant = aux;
            free(ant);
            aux = aux->prox;
        }
        free((*G)->aresta);
    }
    free(*G);
    *G = NULL;
}

int numVertices(Grafo* G)
{
    if(G == NULL)
    {
        printf("\n**ERROR** - Grafo inconsistente! (NV)");
        return -1;
    }
    return G->qv;
}

int grauVertice(Grafo* G, int V)
{
    if(G == NULL)
    {
        printf("\n**ERROR** - Grafo inconsistente! (GV)");
        return -1;
    }
    if(V < 0 || V >= G->qv)
    {
        printf("\n**ERROR** - Vertice invalido! (GV)");
        return -1;
    }
    return G->grau[V];
}

int ehAdjacente(Grafo* G, int V1, int V2)
{
    Node* aux = G->aresta[V1];
    Node* aux2 = G->aresta[V2];

    if(G == NULL)
    {
        printf("\n**ERROR** - Grafo inconsistente! (EA)");
        return -1;
    }
    if(V1 < 0 || V1 >= G->qv)
    {
        printf("\n**ERROR** - Vertice 1 invalido! (EA)");
        return -1;
    }
    if(V2 < 0 || V2 >= G->qv)
    {
        printf("\n**ERROR** - Vertice 2 invalido! (EA)");
        return -1;
    }

    while(aux != NULL && aux->vertice != V2)
    {
        aux = aux->prox;
    }
    while(aux2 != NULL && aux2->vertice != V1)
    {
        aux2 = aux2->prox;
    }
    if(aux != NULL && aux2 != NULL) return 1;
    if(aux == NULL && aux2 == NULL) return 0;

    printf("\n**ERROR** - Grafo Erroneamente Implementado como Grafo Nao Direcionado! (EA)");
    return -1;
}

int insere_aresta(Grafo *G, int V1, int V2, int* P)
{
    Node* aux = G->aresta[V1];
    Node* aux2 = G->aresta[V2];
    int i;

    if(G == NULL)
    {
        printf("\n**ERROR** - Grafo inconsistente! (IA)");
        return -1;
    }
    if(V1 < 0 || V1 >= G->qv)
    {
        printf("\n**ERROR** - Vertice 1 invalido! (IA)");
        return -1;
    }
    if(V2 < 0 || V2 >= G->qv)
    {
        printf("\n**ERROR** - Vertice 2 invalido! (IA)");
        return -1;
    }

    while(aux != NULL && aux->vertice != V2)
    {
        aux = aux->prox;
    }
    while(aux2 != NULL && aux->vertice != V1)
    {
        aux2 = aux2->prox;
    }

    if(aux != NULL) return 0;

    Node* no = (Node*)(malloc(sizeof(Node)));
    Node* no2 = (Node*)(malloc(sizeof(Node)));

    for(i = 0; i < 4; i++)
    {
        no->peso[i] = P[i];
        no2->peso[i] = P[i];
    }
    no->vertice = V2;
    no2->vertice = V1;
    no->prox = G->aresta[V1];
    no2->prox = G->aresta[V2];

    G->aresta[V1] = no;
    G->aresta[V2] = no2;

    G->grau[V1]++;
    G->grau[V2]++;
    G->qa++;
    return 1;
}

void mostra_adjacentes(Grafo *G, int V)
{
    int i;
    if(G == NULL)
    {
        printf("\n**ERROR** - Grafo Inconsistente\n (MA)");
        return;
    }
    if(V < 0 || V >= G->qv)
    {
        printf("\n**ERROR** - Vertice Inconsistente (MA)");
        return;
    }
    if(G->qa == 0)
    {
        printf("Grafo Vazio\n");
        return;
    }
    if(G->grau[V] == 0)
    {
        printf("Vertice Isolado\n");
        return;
    }
    Node* aux = G->aresta[V];
    while(aux != NULL)
    {
        printf("%d -> %d = [ ", V,aux->vertice);
        for(i = 0; i < 3; i++)
        {
            printf("%d | ",aux->peso[i]);
        }
        printf("%d ]\n",aux->peso[3]);
        aux = aux->prox;
    }
}

void mostra_grafo(Grafo* G)
{
    if(G == NULL)
    {
        printf("\n**ERROR** - Grafo Inconsistente\n (MG)");
        return;
    }
    if(G->qa == 0)
    {
        printf("Grafo Vazio\n");
        return;
    }
    int i;
    for(i = 0; i < G->qv; i++)
    {
        printf("\nVertice %d:\n",i);
        mostra_adjacentes(G,i);
    }
}

int busca_arquivo(Grafo* G, char* x)
{
    char ch, aux;
    char* va = (char*)malloc(sizeof(char));
    int i = 0, j = 0; v[6];
    FILE* f;

    if ((f = fopen(x, "r")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (MAIN)");
        return -1;
    }
    ch = getc(f);
    while(ch != EOF)
    {
        if(ch == '\n')



        ch = getc(f);
    }


    fclose(f);
    return 1;
}
