#include <stdio.h>
#include <stdlib.h>
#include "grafo.h"

typedef struct no
{
    int vertice;
    int peso;
    struct no *prox;
}No;

struct grafo
{
    int qv, qa;
    int *grau;
    No **aresta;
};

Grafo* cria_grafo(int V)
{
    if(V < 1) return NULL;

    Grafo *G = (Grafo*)(malloc(sizeof(Grafo)));
    if(G == NULL) return NULL;

    int i;

    G->aresta = (struct no**)(malloc(V*sizeof(struct no*)));
    if(G->aresta == NULL)
    {
        free(G);
        return NULL;
    }
    for(i = 0; i < V; i++) G->aresta[i] = NULL;

    G->grau = (int*)(malloc(V*sizeof(int)));
    if(G->grau == NULL)
    {
        free(G->aresta);
        free(G);
        return NULL;
    }
    for(i = 0; i < V; i++) G->grau[i] = 0;

    G->qa = 0;
    G->qv = V;
    return G;
}

int insere_aresta(Grafo *G, int V1, int V2, int P)
{
    if(G == NULL) return -1;
    if(V1 < 0 || V1 >= G->qv) return -1;
    if(V2 < 0 || V2 >= G->qv) return -1;

    No* aux = G->aresta[V1];
    No* aux2 = G->aresta[V2];
    int i;
    for(i = 0; i < G->qv; i++)
    {
        if(aux != NULL && aux->vertice != V2) aux = aux->prox;
        if(aux2 != NULL && aux2->vertice != V1) aux2 = aux2->prox;
    }
    if(aux != NULL || aux2 != NULL) return 0;
    if(aux == NULL && aux2 != NULL)
    {
        No* node = (No*)(malloc(sizeof(No)));
        if(node == NULL) return -1;
        node->peso = P;
        node->vertice = V2;
        node->prox = G->aresta[V1];
        G->aresta[V1] = node;
    }else if(aux2 == NULL && aux != NULL)
    {
        No* node2 = (No*)(malloc(sizeof(No)));
        if(node2 == NULL) return -1;
        node2->peso = P;
        node2->vertice = V1;
        node2->prox = G->aresta[V2];
        G->aresta[V2] = node2;
    }else
    {
        No* node = (No*)(malloc(sizeof(No)));
        if(node == NULL) return -1;
        node->peso = P;
        node->vertice = V2;
        node->prox = G->aresta[V1];
        G->aresta[V1] = node;

        No* node2 = (No*)(malloc(sizeof(No)));
        if(node2 == NULL) return -1;
        node2->peso = P;
        node2->vertice = V1;
        node2->prox = G->aresta[V2];
        G->aresta[V2] = node2;
        G->qa++;
        G->grau[V2]++;
        G->grau[V1]++;
    }

    return 1;
}

int verifica_aresta(Grafo *G, int V1, int V2)
{
    if(G == NULL) return -1;
    if(V1 < 0 || V1 >= G->qv) return -1;
    if(V2 < 0 || V2 >= G->qv) return -1;

    No* aux = G->aresta[V1];
    No* aux2 = G->aresta[V2];
    int i;
    for(i = 0; i < G->qv; i++)
    {
        if(aux != NULL && aux->vertice != V2) aux = aux->prox;
        if(aux2 != NULL && aux2->vertice != V1) aux2 = aux2->prox;
    }
    if(aux != NULL && aux2 != NULL) return 1;
    else if(aux != NULL || aux2 != NULL) return -1;
    else return 0;
}

int remove_aresta(Grafo *G, int V1, int V2)
{
    if(G == NULL) return -1;
    if(V1 < 0 || V1 >= G->qv) return -1;
    if(V2 < 0 || V2 >= G->qv) return -1;

    No* aux = G->aresta[V1];
    No* aux2 = G->aresta[V2];
    No* ant = NULL;
    No* ant2 = NULL;
    int i;
    for(i = 0; i < G->qv; i++)
    {
        if(aux != NULL && aux->vertice != V2)
        {
            ant = aux;
            aux = aux->prox;
        }
        if(aux2 != NULL && aux2->vertice != V1)
        {
            ant2 = aux2;
            aux2 = aux2->prox;
        }
    }
    if(aux == NULL && aux2 == NULL) return 0;
    if(ant == NULL) G->aresta[V1] = aux->prox;
    else ant = aux->prox;
    if(ant2 == NULL) G->aresta[V2] = aux2->prox;
    else ant2 = aux2->prox;
    free(aux);
    G->qa--;
    G->grau[V1]--;
    G->grau[V2]--;
    return 1;
}

int consulta_aresta(Grafo *G, int V1, int V2, int *P)
{
    if(G == NULL) return -1;
    if(V1 < 0 || V1 >= G->qv) return -1;
    if(V2 < 0 || V2 >= G->qv) return -1;

    No* aux = G->aresta[V1];
    No* aux2 = G->aresta[V2];
    int i;
    for(i = 0; i < G->qv; i++)
    {
        if(aux != NULL && aux->vertice != V2) aux = aux->prox;
        if(aux2 != NULL && aux2->vertice != V1) aux2 = aux2->prox;
    }
    if(aux != NULL && aux2 != NULL)
    {
        *P = aux->peso;
        return 1;
    }
    else if(aux != NULL || aux2 != NULL) return -1;
    else return 0;
}

void libera_grafo(Grafo **G)
{
    int i;
    No *aux = NULL;
    No *aux2 = NULL;
    for(i = 0; i < (*G)->qv; i++)
    {
        aux = (*G)->aresta[i];
        while(aux != NULL)
        {
            aux2 = aux;
            aux = aux->prox;
            free(aux2);
        }
    }
    free((*G)->aresta);
    free((*G)->grau);
    free(*G);
    *G = NULL;
}

void mostra_adjacentes(Grafo *G, int V)
{
    if(G == NULL || V < 0 || V >= G->qv) printf("Grafo ou Vertice Inconsistente\n");
    else if(G->qa == 0) printf("Grafo Vazio\n");
    else if(G->grau[V] == 0) printf("Vertice Isolado\n");
    else
    {
        No* aux = G->aresta[V];
        while(aux != NULL)
        {
            printf("%d -> %d = %d\n", V,aux->vertice,aux->peso);
            aux = aux->prox;
        }
    }
}

void mostra_grafo(Grafo* G)
{
    if(G == NULL) printf("Grafo Inconsistente\n");
    else if(G->qa == 0) printf("Grafo Vazio\n");
    else
    {
        int i;
        for(i = 0; i < G->qv; i++)
        {
            printf("\nVertice %d:\n",i);
            mostra_adjacentes(G,i);
        }
    }
}

/**-----------------------------------------PERCORRIMENTO DE GRAFO------------------------------------------------**/
void busca_profundidade(Grafo *G, int V, int *visitado)
{
    visitado[V] = 1;
    printf("%d ->", V);
    No* aux = (No*)(malloc(sizeof(No)));
    aux = G->aresta[V];
    while(aux != NULL)
    {
        if(visitado[aux->vertice] == 0)
        {
            //printf("%d -> %d\n",V,aux->vertice);
            busca_profundidade(G,aux->vertice,visitado);
        }else aux = aux->prox;
    }
}

void dfs(Grafo *G, int V)
{
    int *visitado = (int*)(malloc((G->qv)*sizeof(int)));
    if(visitado == NULL) printf("ERROR! Vetor visitado");
    else
    {
        int i;
        for(i = 0; i < G->qv; i++)
        {
            visitado[i] = 0;
        }
        busca_profundidade(G,V,visitado);
        //printf("Grafo");
        //for(i = 0; i < G->qv; i++) printf("%d,",visitado[i]);
    }
}

