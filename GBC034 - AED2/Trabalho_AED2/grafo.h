#ifndef GRAFO_H_INCLUDED
#define GRAFO_H_INCLUDED

typedef struct node
{
    int vertice;
    int peso[4];
    struct node* prox;
} Node;

typedef struct grafo
{
    int qa;
    int qv;
    int *grau;
    Node **aresta;

} Grafo;

Grafo* cria_grafo(int Qnt);
void libera_grafo(Grafo** G);
int numVertices(Grafo* G);
int grauVertice(Grafo* G, int V);
int ehAdjacente(Grafo* G, int V1, int V2);
int insere_aresta(Grafo *G, int V1, int V2, int* P);

#endif // GRAFO_H_INCLUDED
