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
        Node* aux2 = G->aresta[V2];

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
    return 3;
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
        if(G1->aresta[V1][V2].ad == 0) return 0;
        for(i = 0; i < 4; i++)
        {
            G1->aresta[V1][V2].peso[i] = 0;
            G1->aresta[V2][V1].peso[i] = 0;
        }
        G1->aresta[V1][V2].ad = 0;
        G1->aresta[V2][V1].ad = 0;
        G1->grau[V1]--;
        G1->grau[V2]--;
        return 1;
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

int aux_arquivo(char* x)
{
    char ch, ch1[100];
    int *v, *aux1, *peso, *visitados, num_vertices = 0, i = 0, j = 0, k, v1, v2;
    FILE* f;

    if ((f = fopen(x, "r")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (BA)");
        return -1;
    }

    visitados = (int*)calloc(50, sizeof(int));

    while(!(feof(f)))
    {
        aux1 = (int*)malloc(10*sizeof(int));
        peso = (int*)malloc(4*sizeof(int));
        v = (int*)malloc(10*sizeof(int));
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

        if(visitados[v1] == 0)
        {
            num_vertices++;
            visitados[v1] = 1;
        }
        if(visitados[v2] == 0)
        {
            num_vertices++;
            visitados[v2] = 1;
        }
        free(v);
        i=0;
        j=0;
        free(aux1);
        free(peso);
    }
    return num_vertices;
}

Grafo* busca_arquivo(char* x)
{
    char ch;
    char ch1[100];
    int* v;
    int* aux1;
    int* peso;
    int i = 0, j = 0, k;
    int v1, v2;
    FILE* f;
    int num_vertices = aux_arquivo(x);
    Grafo* G = cria_grafo(num_vertices);
    if ((f = fopen(x, "r")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (BA)");
        return NULL;
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
        insere_aresta(G, NULL,1,v1, v2, peso);
        free(v);
        i=0;
        j=0;
        free(aux1);
        free(peso);
    }
    fclose(f);
    return G;
}

GrafoM* busca_arquivoM(char* x)
{
    char ch;
    char ch1[100];
    int* v;
    int* aux1;
    int* peso;
    int i = 0, j = 0, k;
    int v1, v2;
    FILE* f;
    int num_vertices = aux_arquivo(x);
    GrafoM* G = cria_grafoM(num_vertices);
    if ((f = fopen(x, "r")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (BA)");
        return NULL;
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
        insere_aresta(NULL, G, 0,v1, v2, peso);
        free(v);
        i=0;
        j=0;
        free(aux1);
        free(peso);
    }
    fclose(f);
    return G;
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

int cria_arquivoM(GrafoM* G)
{
    FILE* p;
    char x[50];
    int i, j, k;
    printf("\tDigite o nome do arquivo a ser criado: ");
    scanf("%s",x);
    if ((p = fopen(x, "w+")) == NULL)
    {
        printf("\n**ERROR** - Erro ao Abrir Arquivo! (MAIN)");
        return -1;
    }
    for(i = 0; i < G->qv; i++)
    {
        for(j = 0; j < G->qv; j++)
        {
            if(G->aresta[i][j].ad == 1)
            {
                fprintf(p, "%d -> %d = [ ", i,j);
                for(k = 0; k < 3; k++)
                {
                    fprintf(p, "%d | ", G->aresta[i][j].peso[k]);
                }
                fprintf(p, "%d ]\n", G->aresta[i][j].peso[3]);
            }
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

void dijkstra(Grafo *G, GrafoM *G1, int n, int V, int *Rec, int tamRec, int peso, int** ant, float** dist)
{
    int i, aux, tamg;
    if(peso < 0 || peso > 3)
    {
        printf("\n**ERROR** - Numero do Peso inconsistente! (D)");
        return;
    }
    if((G == NULL && n == 1) || (G1 == NULL && n == 0))
    {
        printf("\n**ERROR** - Grafo inconsistente! (D)");
        return;
    }
    if(n == 0) tamg = G1->qv;
    if(n == 1) tamg = G->qv;
    if(V < 0 || V >= tamg)
    {
        printf("\n**ERROR** - Vertice invalido! (D)");
        return;
    }

    for(i = 0; i < tamRec; i++)
    {
        if(n == 0) menorCaminho_Grafo(NULL, G1, 0, V, ant[i], dist[i], peso);
        if(n == 1) menorCaminho_Grafo(G, NULL, 1, V, ant[i], dist[i], peso);

    }
    for(i = 0; i < tamRec; i++)
    {
        printf("\nVertice %d para Receptor %d:\n",V,Rec[i]);
        aux = Rec[i];
        while(aux != V)
        {
            printf("%d <- ",aux);
            aux = ant[i][aux];
        }
        printf("%d", V);
        printf("\n");
    }
}

int procuraMenorDistancia(float *dist, int *visitado, int NV)
{
    int i, menor = -1, primeiro = 1;
    for(i = 0; i < NV; i++)
    {
        if(dist[i] >= 0 && visitado[i] == 0)
        {
            if(primeiro)
            {
                menor = i;
                primeiro = 0;
            }
            else if(dist[menor] > dist[i])
            {
                menor = i;
            }
        }
    }
    return menor;
}

int procuraMaiorDistancia(float *dist, int *visitado, int NV)
{
    int i, maior = -1, primeiro = 1;
    for(i = 0; i < NV; i++)
    {
        if(dist[i] >= 0 && visitado[i] == 0)
        {
            if(primeiro)
            {
                maior = i;
                primeiro = 0;
            }
            else if(dist[maior] < dist[i])
            {
                maior = i;
            }
        }
    }
    return maior;
}

void menorCaminho_Grafo(Grafo *gr, GrafoM *gr1, int n, int ini, int *ant, float *dist, int pe)
{
    int i, cont, NV, ind, *visitado, u, EA = 0;
    int aux, boolean; // MAIOR
    if(n == 0) NV = gr1->qv;
    if(n == 1) NV = gr->qv;
    cont = NV;
    visitado = (int*) malloc(NV * sizeof(int));
    for(i = 0; i < NV; i++)
    {
        ant[i] = -1;
        dist[i] = -1;
        visitado[i] = 0;
    }
    dist[ini] = 0;
    while(cont > 0)
    {
        if(pe == 0 || pe == 2)
        {
            u = procuraMenorDistancia(dist, visitado, NV);
        }
        else
        {
            u = procuraMaiorDistancia(dist, visitado, NV);
        }

        if(u == -1) break;
        visitado[u] = 1;
        cont--;
        for(i = 0; i < NV ; i++)
        {
            boolean = 0; // MAIOR
            if(n == 0)
            {
                EA = ehAdjacente(NULL, gr1,0,u,i);
                if(EA == 1)
                {
                    ind = i;
                    if(dist[ind] < 0)
                    {
                        dist[ind] = dist[u] + gr1->aresta[ind][u].peso[pe];
                        ant[ind] = u;
                    }
                    else if(pe == 0 || pe == 2)
                    {
                        if(dist[ind] > dist[u] + gr1->aresta[ind][u].peso[pe])
                        {
                            dist[ind] = dist[u] + gr1->aresta[ind][u].peso[pe];
                            ant[ind] = u;
                        }
                    }
                    else
                    {
                        aux = u;
                        for(;;)
                        {
                            if(aux == ini) break;
                            aux = ant[aux];
                            if(aux == ind)
                            {
                                boolean = 1;
                            }
                        }
                        if(ind != ini && boolean == 0)
                        {
                            if(dist[ind] < dist[u] + gr1->aresta[ind][u].peso[pe])
                            {
                                dist[ind] = dist[u] + gr1->aresta[ind][u].peso[pe];
                                ant[ind] = u;
                            }
                        }
                    }
                }
            }
            if(n == 1)
            {
                EA = ehAdjacente(gr, NULL,1,u,i);
                if( EA == 1)
                {
                    ind = i;
                    if(dist[ind] < 0)
                    {
                        dist[ind] = dist[u] + peso(gr, NULL, 1, ind, u, pe);
                        ant[ind] = u;
                    }
                    else if(pe == 0 || pe == 2)
                    {
                        if(dist[ind] > dist[u] + peso(gr, NULL, 1, ind, u, pe))
                        {
                            dist[ind] = dist[u] + peso(gr, NULL, 1, ind, u, pe);
                            ant[ind] = u;
                        }
                    }
                    else
                    {
                        aux = u;
                        for(;;)
                        {
                            if(aux == ini) break;
                            aux = ant[aux];
                            if(aux == ind)
                            {
                                boolean = 1;
                            }
                        }
                        if(ind != ini && boolean == 0)
                        {
                            if(dist[ind] < dist[u] + peso(gr, NULL, 1, ind, u, pe))
                            {
                                dist[ind] = dist[u] + peso(gr, NULL, 1, ind, u, pe);
                                ant[ind] = u;
                            }
                        }
                    }
                }
            }
        }
    }
    free(visitado);
}

int peso(Grafo* G, GrafoM* G1, int n, int V1, int V2, int num)
{
    if(n == 1)
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
        if(aux != NULL && aux2 != NULL)
        {
            if(aux2 == NULL) return aux->peso[num];
            else return aux2->peso[num];
        }
        if(aux == NULL && aux2 == NULL) return -1;

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
        if(G1->aresta[V1][V2].ad == 1) return G1->aresta[V1][V2].peso[num];
        if(G1->aresta[V1][V2].ad == 0) return -1;
        return -1;
    }
    else
    {
        printf("\n**ERROR** - Numero invalido! (EA)");
        return -1;
    }
}

void custo_total(Grafo* G, GrafoM* G1, int n, int metodo, int V, int tamRec, int *Rec, float* metrica)
{
    int i, aux, anterior, v[4] = {0,1,2,3};
    *metrica = 0;
    if((G == NULL && n == 1) || (G1 == NULL && n == 0))
    {
        printf("\n**ERROR** - Grafo inconsistente! (D)");
        return;
    }
    int tamg;
    if(n == 0) tamg = G1->qv;
    if(n == 1) tamg = G->qv;
    if(V < 0 || V >= tamg)
    {
        printf("\n**ERROR** - Vertice invalido! (D)");
        return;
    }
    if(metodo == 2)
    {

        int **ant = (int**)(malloc((tamRec)*sizeof(int*)));
        if(ant == NULL)
        {
            printf("\n**ERROR** - Auxiliar! (D)");
            return;
        }
        for(i = 0; i < tamRec; i++)
        {
            ant[i] = (int*)(malloc((tamg)*sizeof(int)));
            if(ant[i] == NULL)
            {
                printf("\n**ERROR** - Auxiliar! (D)");
                return;
            }
        }
        float **dist = (float**)(malloc(tamRec*sizeof(float*)));
        if(dist == NULL)
        {
            printf("\n**ERROR** - Auxiliar! (D)");
            return;
        }
        for(i = 0; i < tamRec; i++)
        {
            dist[i] = (float*)(malloc((tamg)*sizeof(float)));
            if(dist[i] == NULL)
            {
                printf("\n**ERROR** - Auxiliar! (D)");
                return;
            }
        }
        if(n == 0)
        {
            dijkstra(NULL, G1, 0, V, Rec, tamRec, 0, ant, dist);
            GrafoM* gaux = cria_grafoM(tamg);
            if(gaux == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(NULL,gaux,0,anterior,aux,v) == 1)
                        {
                            *metrica += G1->aresta[anterior][aux].peso[0];
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(NULL,gaux,0,anterior,aux,v) == 1)
                    {
                        *metrica += G1->aresta[anterior][aux].peso[0];
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            for(i = 0; i < tamRec; i++)
            {
                free(dist[i]);
                free(ant[i]);
            }
            free(dist);
            free(ant);
            libera_grafo(NULL,&gaux,0);
            return;
        }
        if(n == 1)
        {
            dijkstra(G, NULL, 1, V, Rec, tamRec, 0, ant, dist);
            Grafo* gaux2 = cria_grafo(tamg);
            if(gaux2 == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(gaux2,NULL,1,anterior,aux,v) == 1)
                        {
                            *metrica += peso(G,NULL,1,anterior,aux,0);
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(gaux2,NULL,1,anterior,aux,v) == 1)
                    {
                        *metrica += peso(G,NULL,1,anterior,aux,0);
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            for(i = 0; i < tamRec; i++)
            {
                free(dist[i]);
                free(ant[i]);
            }
            free(dist);
            free(ant);
            libera_grafo(&gaux2,NULL,1);
            return;
        }
    }
}

void delay_max(Grafo* G, GrafoM* G1, int n, int metodo, int V, int tamRec, int *Rec, float* metrica)
{
    int i, aux, anterior, v[4] = {0,1,2,3};
    *metrica = 0;
    if((G == NULL && n == 1) || (G1 == NULL && n == 0))
    {
        printf("\n**ERROR** - Grafo inconsistente! (DM)");
        return;
    }
    int tamg;
    if(n == 0) tamg = G1->qv;
    if(n == 1) tamg = G->qv;
    if(V < 0 || V >= tamg)
    {
        printf("\n**ERROR** - Vertice invalido! (DM)");
        return;
    }
    if(metodo == 2)
    {

        int **ant = (int**)(malloc((tamRec)*sizeof(int*)));
        if(ant == NULL)
        {
            printf("\n**ERROR** - Auxiliar! (D)");
            return;
        }
        for(i = 0; i < tamRec; i++)
        {
            ant[i] = (int*)(malloc((tamg)*sizeof(int)));
            if(ant[i] == NULL)
            {
                printf("\n**ERROR** - Auxiliar! (D)");
                return;
            }
        }
        float **dist = (float**)(malloc(tamRec*sizeof(float*)));
        if(dist == NULL)
        {
            printf("\n**ERROR** - Auxiliar! (D)");
            return;
        }
        for(i = 0; i < tamRec; i++)
        {
            dist[i] = (float*)(malloc((tamg)*sizeof(float)));
            if(dist[i] == NULL)
            {
                printf("\n**ERROR** - Auxiliar! (D)");
                return;
            }
        }
        if(n == 0)
        {
            dijkstra(NULL, G1, 0, V, Rec, tamRec, 1, ant, dist);
            GrafoM* gaux = cria_grafoM(tamg);
            if(gaux == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(NULL,gaux,0,anterior,aux,v) == 1)
                        {
                            *metrica += G1->aresta[anterior][aux].peso[1];
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(NULL,gaux,0,anterior,aux,v) == 1)
                    {
                        *metrica += G1->aresta[anterior][aux].peso[1];
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            for(i = 0; i < tamRec; i++)
            {
                free(dist[i]);
                free(ant[i]);
            }
            free(dist);
            free(ant);
            libera_grafo(NULL,&gaux,0);
            return;
        }
        if(n == 1)
        {
            dijkstra(G, NULL, 1, V, Rec, tamRec, 1, ant, dist);
            Grafo* gaux2 = cria_grafo(tamg);
            if(gaux2 == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(gaux2,NULL,1,anterior,aux,v) == 1)
                        {
                            *metrica += peso(G,NULL,1,anterior,aux,1);
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(gaux2,NULL,1,anterior,aux,v) == 1)
                    {
                        *metrica += peso(G,NULL,1,anterior,aux,1);
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            for(i = 0; i < tamRec; i++)
            {
                free(dist[i]);
                free(ant[i]);
            }
            free(dist);
            free(ant);
            libera_grafo(&gaux2,NULL,1);
            return;
        }
    }
}

void enlace_max(Grafo* G, GrafoM* G1, int n, int metodo, int V, int tamRec, int *Rec, float* metrica, int mensagem)
{
    int i, aux, anterior, v[4] = {0,1,2,3};
    float z3 = 0, t4 = 0;
    *metrica = 0;
    if((G == NULL && n == 1) || (G1 == NULL && n == 0))
    {
        printf("\n**ERROR** - Grafo inconsistente! (DM)");
        return;
    }
    int tamg;
    if(n == 0) tamg = G1->qv;
    if(n == 1) tamg = G->qv;
    if(V < 0 || V >= tamg)
    {
        printf("\n**ERROR** - Vertice invalido! (DM)");
        return;
    }
    if(metodo == 2)
    {

        int **ant = (int**)(malloc((tamRec)*sizeof(int*)));
        if(ant == NULL)
        {
            printf("\n**ERROR** - Auxiliar! (D)");
            return;
        }
        for(i = 0; i < tamRec; i++)
        {
            ant[i] = (int*)(malloc((tamg)*sizeof(int)));
            if(ant[i] == NULL)
            {
                printf("\n**ERROR** - Auxiliar! (D)");
                return;
            }
        }
        float **dist = (float**)(malloc(tamRec*sizeof(float*)));
        if(dist == NULL)
        {
            printf("\n**ERROR** - Auxiliar! (D)");
            return;
        }
        for(i = 0; i < tamRec; i++)
        {
            dist[i] = (float*)(malloc((tamg)*sizeof(float)));
            if(dist[i] == NULL)
            {
                printf("\n**ERROR** - Auxiliar! (D)");
                return;
            }
        }
        if(n == 0)
        {
            /****************************CALCULANDO PESO 3*******************************/
            dijkstra(NULL, G1, 0, V, Rec, tamRec, 2, ant, dist);
            GrafoM* gaux = cria_grafoM(tamg);
            if(gaux == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(NULL,gaux,0,anterior,aux,v) == 1)
                        {
                            z3 += G1->aresta[anterior][aux].peso[2];
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(NULL,gaux,0,anterior,aux,v) == 1)
                    {
                        z3 += G1->aresta[anterior][aux].peso[2];
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            libera_grafo(NULL,&gaux,0);
            /************************FIM CALCULANDO PESO 3*******************************/
            dijkstra(NULL, G1, 0, V, Rec, tamRec, 3, ant, dist);
            GrafoM* gaux3 = cria_grafoM(tamg);
            if(gaux3 == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(NULL,gaux3,0,anterior,aux,v) == 1)
                        {
                            t4 += G1->aresta[anterior][aux].peso[3];
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(NULL,gaux3,0,anterior,aux,v) == 1)
                    {
                        t4 += G1->aresta[anterior][aux].peso[3];
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            for(i = 0; i < tamRec; i++)
            {
                free(dist[i]);
                free(ant[i]);
            }
            free(dist);
            free(ant);
            libera_grafo(NULL,&gaux3,0);
            *metrica = (t4 + mensagem)/z3;
            return;
        }
        if(n == 1)
        {
            dijkstra(G, NULL, 1, V, Rec, tamRec, 2, ant, dist);
            Grafo* gaux2 = cria_grafo(tamg);
            if(gaux2 == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(gaux2,NULL,1,anterior,aux,v) == 1)
                        {
                            z3 += peso(G,NULL,1,anterior,aux,2);
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(gaux2,NULL,1,anterior,aux,v) == 1)
                    {
                        z3 += peso(G,NULL,1,anterior,aux,2);
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            libera_grafo(&gaux2,NULL,1);

            dijkstra(G, NULL, 1, V, Rec, tamRec, 3, ant, dist);
            Grafo* gaux4 = cria_grafo(tamg);
            if(gaux4 == NULL) printf("\n**ERRO** CALCULO DE CUSTO (C)\n");
            for(i = 0; i < tamRec; i++)
            {
                aux = Rec[i];
                if(Rec[i] != V)
                {
                    while(aux != V)
                    {
                        anterior = aux;
                        aux = ant[i][aux];
                        if(insere_aresta(gaux4,NULL,1,anterior,aux,v) == 1)
                        {
                            t4 += peso(G,NULL,1,anterior,aux,3);
                            //printf("\nMETRICA : %0.2f", metrica);
                        }
                    }
                    if(insere_aresta(gaux4,NULL,1,anterior,aux,v) == 1)
                    {
                        t4 += peso(G,NULL,1,anterior,aux,3);
                        //printf("\nMETRICA : %0.2f", metrica);
                    }
                }
            }
            for(i = 0; i < tamRec; i++)
            {
                free(dist[i]);
                free(ant[i]);
            }
            free(dist);
            free(ant);
            libera_grafo(&gaux4,NULL,1);
            *metrica = (t4 + mensagem)/z3;
            return;
        }
    }
}
