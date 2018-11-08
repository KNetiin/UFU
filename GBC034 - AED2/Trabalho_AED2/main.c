#include <stdio.h>
#include <stdlib.h>

#include "grafo.h"

int main()
{
    /*
    printf("Grafo Nao Direcionado implementado com lista de adjacencias\n");
    printf("Nome: Antonio Carlos Neto\n");

    int tam, cont, v1,v2, baum, i, peso[4];
    printf("Iniciando Construcao\nDigite a quantidade de vertices: ");
    scanf("%d",&tam);
    Grafo *g;
    g = cria_grafo(tam);

    printf("\n\nESCOLHA UMA DAS OPCOES:\n");
    printf("1 - Inserir Aresta\n2 - Verificar Aresta\n3 - Remover Aresta\n4 - Consultar Aresta\n5 - Motrar Grafo\n6 - Mostrar Opcoes\n7 - Imprimir Busca de Profundidade\n0 - Sair\n\n");
    while(cont != 0)
    {
        scanf("%d",&cont);
        if(cont == 1)
        {
            printf("Digite os vertices para construir uma aresta:\n");
            printf("Vertice 1:");
            scanf("%d",&v1);
            printf("Vertice 2:");
            scanf("%d",&v2);
            printf("Digite as metricas:");
            for(i = 0; i < 4; i++)
                scanf("%d",&peso[i]);
            baum = insere_aresta(g,v1,v2,peso);
            if(baum == -1) printf("Deu ruim\n");
            if(baum == 0) printf("Aresta existente\n");
            if(baum == 1) printf("Aresta acrescentada com sucesso\n");
        }else if(cont == 2)
        {
            printf("Digite os vertices para verificar se existe a aresta:\n");
            printf("Vertice 1:");
            scanf("%d",&v1);
            printf("Vertice 2:");
            scanf("%d",&v2);
            baum = ehAdjacente(g,v1,v2);
            if(baum == -1) printf("Deu ruim\n");
            if(baum == 1) printf("Aresta existente\n");
            if(baum == 0) printf("Aresta nao existe\n");
        }else if(cont == 3)
        {
            printf("Digite os vertices para remover a aresta:\n");
            printf("Vertice origem:");
            scanf("%d",&v1);
            printf("Vertice destino:");
            scanf("%d",&v2);
            baum = remove_aresta(g,v1,v2);
            if(baum == -1) printf("Deu ruim\n");
            if(baum == 1) printf("Aresta removida\n");
            if(baum == 0) printf("Aresta nao existe\n");
        }else if(cont == 4)
        {
            printf("Digite os vertices para consultar a aresta:\n");
            printf("Vertice 1:");
            scanf("%d",&v1);
            printf("Vertice 2:");
            scanf("%d",&v2);
            baum = consulta_aresta(g,v1,v2,(&peso));
            if(baum == -1) printf("Deu ruim\n");
            if(baum == 1) printf("Peso: %d\n",peso);
            if(baum == 0) printf("Aresta nao existe\n");
        }else if(cont == 5)
        {
            mostra_grafo(g);
        }else if(cont == 6)
        {
            printf("1 - Inserir Aresta\n2 - Verificar Aresta\n3 - Remover Aresta\n4 - Consultar Aresta\n5 - Motrar Grafo\n6 - Mostrar Opcoes\n0 - Sair\n\n");
        }else if(cont == 0)
        {
            printf("SAINDO....\n");
        }else if(cont == 7)
        {
           // dfs(g,1);
        }else printf("Opcao invalida!");
    }
*/
    /**-------------------------------------FIM MAIN DE GRAFO------------------------------------------------**/

   // libera_grafo(&g);

    int i;
    char x[30] = "trabalho_aed2.txt";
    i = busca_arquivo(x);

    return 0;
}
