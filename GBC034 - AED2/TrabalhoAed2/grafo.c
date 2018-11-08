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

GrafoM* cria_grafoM(int Qnt)
{
    int i, j, k;
    if(Qnt < 1)
    {
        printf("\n**ERROR** - Quantidade de Vertice Invalida! (CGM)");
        return NULL;
    }

    GrafoM *G = (GrafoM*)(malloc(sizeof(GrafoM)));
    if(G == NULL)
    {
        printf("\n**ERROR** - Erro na Alocacao do Grafo! (CGM)");
        return NULL;
    }

    G->grau = (int*)(calloc(Qnt,sizeof(int)));
    if(G->grau == NULL)
    {
        printf("\n**ERROR** - Erro na Alocacao do Grau! (CGM)");
        free(G);
        return NULL;
    }

    G->aresta = (NodeM**)(malloc(Qnt*(sizeof(NodeM*))));
    if(G->aresta == NULL)
    {
        printf("\n**ERROR** - Erro na Alocacao da Matriz de Arestas! (CGM)");
        free(G->grau);
        free(G);
        return NULL;
    }
    for(i = 0; i < Qnt; i++)
    {
        G->aresta[i] = (NodeM*)(malloc(Qnt*(sizeof(NodeM))));
        if(G->aresta[i] == NULL)
        {
            printf("\n**ERROR** - Erro na Alocacao da Matriz de Arestas! (CGM)");
            for(j = (i - 1); j <= 0; j--)
            {
                free(G->aresta[j]);
            }
            free(G->aresta);
            free(G->grau);
            free(G);
            return NULL;
        }
    }

    for(i = 0; i < Qnt; i++)
    {
        for(j = 0; j < Qnt; j++)
        {
            G->aresta[i][j].ad = 0;
            for(k = 0; k < 4; k++)
            {
                G->aresta[i][j].peso[k] = 0;
            }
        }
    }
    G->qa = 0;
    G->qv = Qnt;
    return G;
}

void libera_grafo(Grafo** G, GrafoM** G1, int n)
{
    int i;
    if(n == 1)//Verificando se é lista de adjacencia
    {
        Node* aux = (Node*)(malloc(sizeof(Node)));
        if(aux == NULL)
        {
            printf("\n**ERROR** - Variavel Auxiliar não alocada! (LG)");
            return;
        }

        Node* ant = (Node*)(malloc(sizeof(Node)));
        if(ant == NULL)
        {
            printf("\n**ERROR** - Variavel Auxiliar não alocada! (LG)");
            return;
        }

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
    else if(n == 0) //Verificando se é MATRIZ de adjacencia
    {
        if(*G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (LG)");
            return;
        }
        for(i = 0; i < (*G1)->qv; i++)
        {
            free((*G1)->aresta[i]);
        }
        free((*G1)->aresta);
        free((*G1)->grau);
        free(*G1);
        *G1 = NULL;
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (LG)");
    }
}

int numVertices(Grafo* G, GrafoM* G1, int n)
{
    if(n == 1)
    {
        if(G == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (NV)");
            return -1;
        }
        return G->qv;
    }
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (NV)");
            return -1;
        }
        return (G1->qv);
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (NV)");
        return -1;
    }
}

int grauVertice(Grafo* G, GrafoM* G1, int n, int V)
{
    if(n == 1)
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
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (GV)");
            return -1;
        }
        if(V < 0 || V >= G1->qv)
        {
            printf("\n**ERROR** - Vertice invalido! (GV)");
            return -1;
        }
        return G1->grau[V];
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (GV)");
        return -1;
    }
}

int ehAdjacente(Grafo* G, GrafoM* G1, int n, int V1, int V2)
{
    if(n == 1)
    {
        Node* aux = G->aresta[V1];
        if(aux == NULL)
        {
            printf("\n**ERROR** - Variavel Auxiliar não alocada! (EA)");
            return -1;
        }
        Node* aux2 = G->aresta[V2];
        if(aux2 == NULL)
        {
            printf("\n**ERROR** - Variavel Auxiliar não alocada! (EA)");
            return -1;
        }
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
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (EA)");
            return -1;
        }
        if(V1 < 0 || V1 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 1 invalido! (EA)");
            return -1;
        }
        if(V2 < 0 || V2 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 2 invalido! (EA)");
            return -1;
        }
        if(G1->aresta[V1][V2].ad == 1) return 1;
        if(G1->aresta[V1][V2].ad == 0) return 0;
        return -1;
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (EA)");
        return -1;
    }
}

int insere_aresta(Grafo *G, GrafoM* G1, int n, int V1, int V2, int* P)
{
    int i;
    if(n == 1)
    {
        Node* aux = G->aresta[V1];
        if(aux == NULL)
        {
            printf("\n**ERROR** - Variavel Auxiliar não alocada! (IA)");
            return -1;
        }
        Node* aux2 = G->aresta[V2];
        if(aux == NULL)
        {
            printf("\n**ERROR** - Variavel Auxiliar não alocada! (IA)");
            return -1;
        }

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
        while(aux2 != NULL && aux2->vertice != V1)
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
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (IA)");
            return -1;
        }
        if(V1 < 0 || V1 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 1 invalido! (IA)");
            return -1;
        }
        if(V2 < 0 || V2 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 2 invalido! (IA)");
            return -1;
        }
        if(G1->aresta[V1][V2].ad == 1) return 0;
        G1->aresta[V1][V2].ad = 1;
        G1->aresta[V2][V1].ad = 1;
        for(i = 0; i < 4; i++)
        {
            G1->aresta[V1][V2].peso[i] = P[i];
            G1->aresta[V2][V1].peso[i] = P[i];
        }
        G1->grau[V1]++;
        G1->grau[V2]++;
        G1->qa++;
        return 1;
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (EA)");
        return -1;
    }
}

int consulta_aresta(Grafo *G, GrafoM* G1, int n, int V1, int V2, int* P)
{
    int i;
    if(n == 1)
    {
        if(G == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (CA)");
            return -1;
        }
        if(V1 < 0 || V1 >= G->qv)
        {
            printf("\n**ERROR** - Vertice 1 invalido! (CA)");
            return -1;
        }
        if(V2 < 0 || V2 >= G->qv)
        {
            printf("\n**ERROR** - Vertice 2 invalido! (CA)");
            return -1;
        }

        Node* aux = G->aresta[V1];
        Node* aux2 = G->aresta[V2];
        for(i = 0; i < G->qv; i++)
        {
            if(aux != NULL && aux->vertice != V2) aux = aux->prox;
            if(aux2 != NULL && aux2->vertice != V1) aux2 = aux2->prox;
        }
        if(aux != NULL && aux2 != NULL)
        {
            for(i = 0; i<4; i++)
            {
                P[i] = aux->peso[i];
            }
            return 1;
        }
        else if(aux != NULL || aux2 != NULL) return -1;
        else return 0;
    }
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (CA)");
            return -1;
        }
        if(V1 < 0 || V1 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 1 invalido! (CA)");
            return -1;
        }
        if(V2 < 0 || V2 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 2 invalido! (CA)");
            return -1;
        }
        if(G1->aresta[V1][V2].ad == 0) return 0;
        if(G1->aresta[V1][V2].ad == 1)
        {
            for(i = 0; i < G1->qv; i++)
            {
                P[i] = G1->aresta[V1][V2].peso[i];
            }
            return 1;
        }
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (CA)");
        return -1;
    }
}

int remove_aresta(Grafo* G, GrafoM* G1, int n, int V1, int V2)
{
    int i;
    if(n == 1)
    {
        if(G == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (RA)");
            return -1;
        }
        if(V1 < 0 || V1 >= G->qv)
        {
            printf("\n**ERROR** - Vertice 1 invalido! (RA)");
            return -1;
        }
        if(V2 < 0 || V2 >= G->qv)
        {
            printf("\n**ERROR** - Vertice 2 invalido! (RA)");
            return -1;
        }

        Node* aux = G->aresta[V1];
        Node* aux2 = G->aresta[V2];
        Node* ant = NULL;
        Node* ant2 = NULL;
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
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo inconsistente! (EA)");
            return -1;
        }
        if(V1 < 0 || V1 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 1 invalido! (EA)");
            return -1;
        }
        if(V2 < 0 || V2 >= G1->qv)
        {
            printf("\n**ERROR** - Vertice 2 invalido! (EA)");
            return -1;
        }
        for(i = 0; i < G1->qv; i++)
        {
            G1->aresta[V1][V2].peso[i] = 0;
            G1->aresta[V2][V1].peso[i] = 0;
        }
        G1->aresta[V1][V2].ad = 0;
        G1->aresta[V2][V1].ad = 0;
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (RA)");
        return -1;
    }
}

void mostra_adjacentes(Grafo* G, GrafoM* G1, int n, int V)
{
    int i;
    if(n == 1)
    {

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
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo Inconsistente\n (MA)");
            return;
        }
        if(V < 0 || V >= G1->qv)
        {
            printf("\n**ERROR** - Vertice Inconsistente (MA)");
            return;
        }
        if(G1->qa == 0)
        {
            printf("Grafo Vazio\n");
            return;
        }
        if(G1->grau[V] == 0)
        {
            printf("Vertice Isolado\n");
            return;
        }
        int j;
        for(j = 0; j < G1->qv; j++)
        {
            if(G1->aresta[V][j].ad == 1)
            {
                printf("%d -> %d = [ ", V,j);
                for(i = 0; i < 3; i++)
                {
                    printf("%d | ",G1->aresta[V][j].peso[i]);
                }
                printf("%d ]\n",G1->aresta[V][j].peso[3]);
            }
        }
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (RA)");
    }
}

void mostra_grafo(Grafo* G, GrafoM* G1, int n)
{
    int i;
    if(n == 1)
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

        for(i = 0; i < G->qv; i++)
        {
            printf("\nVertice %d:\n",i);
            mostra_adjacentes(G,NULL,1,i);
        }
        printf("\n");
    }
    else if(n == 0)
    {
        if(G1 == NULL)
        {
            printf("\n**ERROR** - Grafo Inconsistente\n (MG)");
            return;
        }
        if(G1->qa == 0)
        {
            printf("Grafo Vazio\n");
            return;
        }
        for(i = 0; i < G1->qv; i++)
        {
            printf("\nVertice %d:\n",i);
            mostra_adjacentes(NULL,G1,0,i);
        }
        printf("\n");
    }
}

int busca_arquivo(Grafo* G, char* x)
{
    char ch;
    char ch1[100];
    int* v;
    int* aux1;
    int* peso;
    int i = 0, j = 0, k;
    int v1, v2;
    FILE* f;

    if ((f = fopen(x, "r")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (BA)");
        return -1;
    }
    while(!(feof(f)))
    {
        v = (int*)malloc(10*sizeof(int));
        aux1 = (int*)malloc(10*sizeof(int));
        peso = (int*)malloc(4*sizeof(int));

        fgets(ch1,(sizeof(ch1))-1, f);

        for(k=0; k<(sizeof(ch1))-1; k++)
        {
            ch = ch1[k];
            if(ch == '\n') break;
            if(ch>47 && ch<58)
            {
                v[i] = atoi(&ch);
                if(ch1[k+1]<48 || ch1[k+1]>57)
                {
                    aux1[j] = v[i];
                    j++;
                }
                i++;
            }
        }
        v1 = aux1[0];
        v2 = aux1[1];
        for(i = 0; i<4; i++)
        {
            peso[i] = aux1[i+2];
        }
//        insere_aresta(G, v1, v2, peso);
        free(v);
        i=0;
        j=0;
        free(aux1);
        free(peso);
    }
    fclose(f);
    return 1;
}

int cria_arquivo(Grafo* G)
{
    FILE* p;
    char x[50];
    int i, j;
    printf("\tDigite o nome do arquivo a ser criado: ");
    scanf("%s",x);

    if ((p = fopen(x, "w+")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (MAIN)");
        return -1;
    }
    //int s=12;
    //fprintf(p,"%d",s);

    for(i = 0; i < G->qv; i++)
    {
        Node* aux = G->aresta[i];
        while(aux != NULL)
        {
            fprintf(p, "%d -> %d = [ ", i,aux->vertice);

            for(j = 0; j < 3; j++)
            {
                fprintf(p, "%d | ",aux->peso[j]);
            }
            fprintf(p, "%d ]\n",aux->peso[3]);
            aux = aux->prox;
        }
    }
    return 1;
}

void ler_pesos(int *P)
{
    printf("\t\tCusto:");
    scanf("%d",&P[0]);
    printf("\t\tDelay:");
    scanf("%d",&P[1]);
    printf("\t\tCapacidade:");
    scanf("%d",&P[2]);
    printf("\t\tTrafego:");
    scanf("%d",&P[3]);
}

int sair=0;
int auxiliar=0;

void busca_profundidade(Grafo* grafo, int V, int V2, int metrica, int* visitados, int* caminho)
{
    visitados[V] = 1;
    //printf("%d->",V);
    caminho[auxiliar] = V;
    auxiliar++;
    Node* aux = (Node*)malloc(sizeof(Node));
    aux = grafo->aresta[V];
    while(aux != NULL && sair != 1)
    {
        if(visitados[aux->vertice] == 0)
            busca_profundidade(grafo,aux->vertice,V2,metrica,visitados,caminho);
        else
        {
            aux=aux->prox;
            if(aux->vertice == V2)
            {
                //auxiliar++;
                //printf("%d", aux->vertice);
                caminho[auxiliar] = aux->vertice;
                sair = 1;
            }
        }
    }
}



void DFS (Grafo* grafo, int V, int V2, int metrica)
{
    int* visitados = (int*) calloc (grafo->qv, sizeof(int));
    int* caminho = (int*) calloc(grafo->qv, sizeof(int));
    int i;
    float distancia = 0;
    busca_profundidade(grafo, V, V2, metrica, visitados, caminho);
    for(i=0; i<=auxiliar; i++)
    {
        printf("%d", caminho[i]);
        distancia += grafo->aresta[caminho[i]]->peso[metrica];
    }
    printf("       Distancia percorrida: %f", distancia);
    printf("\n");
    auxiliar = 0;
}
