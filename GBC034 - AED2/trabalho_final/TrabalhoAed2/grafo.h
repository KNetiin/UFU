#ifndef GRAFO_H_INCLUDED
#define GRAFO_H_INCLUDED


/**********************************STRUCT GRAFO, IMPLEMENTADO EM LISTA DE ADJACÊNCIA***********************************/
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
/*********************************************************FIM**********************************************************/

/**********************************STRUCT GRAFO, IMPLEMENTADO EM MATRIZ DE ADJACÊNCIA**********************************/
typedef struct nodeM
{
    int ad;
    int peso[4];
} NodeM;

typedef struct grafoM
{
    int qv, qa;
    int *grau;
    NodeM **aresta;
}GrafoM;
/*********************************************************FIM**********************************************************/

Grafo* cria_grafo(int Qnt);

GrafoM* cria_grafoM(int Qnt);

void libera_grafo(Grafo** G, GrafoM**G1, int n);

int numVertices(Grafo* G, GrafoM* G1, int n);

int grauVertice(Grafo* G, GrafoM* G1, int n, int V);

int ehAdjacente(Grafo* G, GrafoM* G1, int n, int V1, int V2);

int insere_aresta(Grafo *G, GrafoM* G1, int n, int V1, int V2, int* P);

int consulta_aresta(Grafo *G, GrafoM* G1, int n, int V1, int V2, int* P);

int remove_aresta(Grafo* G, GrafoM* G1, int n, int V1, int V2);

void mostra_adjacentes(Grafo* G, GrafoM* G1, int n, int V);

void mostra_grafo(Grafo* G, GrafoM* G1, int n);

void ler_pesos(int* P);

int aux_arquivo(char* x);

Grafo* busca_arquivo(char* x);

GrafoM* busca_arquivoM(char* x);

int cria_arquivoM(GrafoM* G);

int cria_arquivo(Grafo* G);

void dijkstra(Grafo *G, GrafoM *G1, int n, int V, int *Rec, int tamRec, int peso, int** ant, float** dist);

int procuraMenorDistancia(float *dist, int *visitado, int NV);

int procuraMaiorDistancia(float *dist, int *visitado, int NV);

void menorCaminho_Grafo(Grafo *gr, GrafoM *gr1, int n, int ini, int *ant, float *dist, int pe);

int peso(Grafo* G, GrafoM* G1, int n, int V1, int V2, int num);

void custo_total(Grafo* G, GrafoM* G1, int n, int metodo, int V, int tamRec, int *Rec, float* metrica);

void delay_max(Grafo* G, GrafoM* G1, int n, int metodo, int V, int tamRec, int *Rec, float* metrica);

void enlace_max(Grafo* G, GrafoM* G1, int n, int metodo, int V, int tamRec, int *Rec, float* metrica, int mensagem);

#endif // GRAFO_H_INCLUDED
