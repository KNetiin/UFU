#include <stdio.h>
#include <stdlib.h>

#include "grafo.h"

int main()
{

    printf("\tTrabalho de AED2\n\nIntegrantes:\nAntonio Carlos Neto:\t 11611BCC054\nLucas Rossi Rabelo:\t 11611BCC044\nPaulo Renato C. Barbora: 11611BCC006\n");
    int tam, cont, v1,v2, baum, i, peso[4], metrica, ma_la;
    char x[30];
/*
    do
    {
        printf("\nEscolha uma Opcao:\n1 - Carregar grafo a partir de arquivo\n2 - Construir grafo a partir da quantidade de vertices\n");
        scanf("%d",&cont);
        if(cont == 1)
        {
            //
        }else if(cont == 2)
        {
            printf("Iniciando Construcao...\nDigite a quantidade de vertices: ");
            scanf("%d",&tam);
            do
            {
                printf("\nEscolha a forma de implementacao:\n1 - Matriz de Adjacencia\n2 - Lista de Adjacencia\n");
                scanf("%d",&ma_la);
                if(ma_la == 1)
                {
                    GrafoM *G1;
                    G1 = cria_grafoM(tam);
                }else if(ma_la == 2)
                {
                    Grafo *G;
                    G = cria_grafo(tam);
                }else printf("\nOpcao Invalida!");
            }while(ma_la != 1 && ma_la != 2);
        }else printf("\nOpcao Invalida!");
    }while(cont != 1 && cont != 2);
    system("cls");
*/

Grafo *G;
G = NULL;
GrafoM *G1;
tam = 5;
G1 = cria_grafoM(tam);
ma_la = 0;


    do
    {
        printf("Escolha uma das Opcoes:\n");
        printf("1  - Inserir Aresta\n2  - Remover Aresta\n3  - Consultar Aresta\n4  - Mostrar Grafo\n5  - Mostrar Numero de Vertices do Grafo\n6  - Consultar o Grau do Vertice\n7  - Verificar Adjacencia Entre Vertices\n8  - Salvar Grafo Implementado em Arquivo\n0  - Sair\n\n");
        printf("Digite Sua Opcao: ");
        scanf("%d",&cont);
        if(cont == 1)
        {
            printf("\tDigite os vertices para construir uma aresta:\n");
            printf("\tVertice 1:");
            scanf("%d",&v1);
            printf("\tVertice 2:");
            scanf("%d",&v2);
            printf("\tDigite os pesos:\n");
            ler_pesos(peso);
            if(ma_la == 1)
            {
                baum = insere_aresta(G, NULL, 1, v1, v2, peso);
            }else if(ma_la == 0)
            {
                baum = insere_aresta(NULL, G1, 0, v1, v2, peso);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
            if(baum == 0) printf("Aresta Existente\n");
            if(baum == 1) printf("Aresta Acrescentada Com Sucesso\n");
        }
        else if(cont == 2)
        {
            printf("\tDigite os vertices para remover a aresta:\n");
            printf("\tVertice 1:");
            scanf("%d",&v1);
            printf("\tVertice 2:");
            scanf("%d",&v2);
            if(ma_la == 1)
            {
                baum = remove_aresta(G, NULL, 1, v1, v2);
            }else if(ma_la == 0)
            {
                baum = remove_aresta(NULL, G1, 0, v1, v2);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
            if(baum == 1) printf("Aresta Removida\n");
            if(baum == 0) printf("Aresta Nao Existe\n");
        }
        else if(cont == 3)
        {
            printf("\tDigite os vertices para consultar a aresta:\n");
            printf("\tVertice 1:");
            scanf("%d",&v1);
            printf("\tVertice 2:");
            scanf("%d",&v2);
            if(ma_la == 1)
            {
                baum = consulta_aresta(G, NULL, 1, v1, v2, peso);
            }else if(ma_la == 0)
            {
                baum = remove_aresta(NULL, G1, 0, v1, v2);
            }else printf("\nERRO INESPERADO");
            printf("baum: %d",baum);
            if(baum == -1) printf("**ERRO**\n");
            if(baum == 1)
            {
                printf("[ ");
                for(i = 0; i < 3; i++)
                {
                    printf("%d | ",peso[i]);
                }
                printf("%d ]\n",peso[3]);
            }
            if(baum == 0) printf("Aresta Inexiste\n");
        }
        else if(cont == 4)
        {
            if(ma_la == 1)
            {
                mostra_grafo(G,NULL,1);
            }else if(ma_la == 0)
            {
                mostra_grafo(NULL,G1,0);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
        }
        else if(cont == 5)
        {
            if(ma_la == 1)
            {
                baum = numVertices(G,NULL,1);
            }else if(ma_la == 0)
            {
                baum = numVertices(NULL,G1,0);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
            else printf("%d vertice(s) presente(s) no grafo\n", baum);

        }
        else if(cont == 6)
        {
            printf("\tDigite o vertice a ter o grau consultado: ");
            scanf("%d",&v1);
//            printf("O vertice %d possui grau %d\n\n", v1, grauVertice(g,v1));
        }
        else if(cont == 8)
        {
            printf("\tDigite os vertices para que seja verificado adjacencia entre eles:\n");
            printf("\tVertice origem:");
            scanf("%d",&v1);
            printf("\tVertice destino:");
            scanf("%d",&v2);
//            baum = ehAdjacente(g,v1,v2);
            if(baum == -1) printf("Deu ruim\n\n");
            if(baum == 1) printf("Sao adjacentes\n\n");
            if(baum == 0) printf("Nao sao adjacentes\n\n");
        }
        else if(cont == 9)
        {
            printf("\tATENCAO: Verifique se o numero de vertices do grafo no arquivo corresponde ao numero de vertices inserido no comeco\n");
            printf("\tDigite o caminho do arquivo ou o nome caso esteja na mesma pasta: ");
            scanf("%s",x);
//            if(busca_arquivo(g,x) == 1)
                printf("Grafo implementado com sucesso\n\n");
        }
        else if(cont == 10)
        {
//            if(cria_arquivo(g) == 1)
                printf("Arquivo criado e escrito com sucesso\n\n");
        }
        else if(cont == 11)
        {
            printf("1 - Inserir Aresta\n2 - Verificar Aresta\n3 - Remover Aresta\n4 - Consultar Aresta\n5 - Mostrar Grafo\n6 - Mostrar Numero de vertices do grafo\n7 - Consultar o grau do vertice\n8 - Verificar adjacencia entre vertices\n9 - Implementar um grafo a partir de um arquivo\n10 - Criar um arquivo a partir de um grafo ja implementado\n11 - Mostrar opcoes\n0 - Sair\n\n");
        }
        else if(cont == 12)
        {
            printf("\tRealizando percorrimento da rede para trasmissao da mensagem:\n");
            printf("\tEscolha a metrica que guiara o percorrimento:\n");
            printf("\t\t0 - Custo\n\t\t1 - Delay\n\t\t2 - Capacidade\n\t\t3 - Trafego\n");
            printf("\tDigite a metrica escolhida:");
            scanf("%d", &metrica);
            printf("\tInsira os vertices:\n");
            printf("\tVertice 1:");
            scanf("%d",&v1);
            printf("\tVertice 2:");
            scanf("%d",&v2);
//            DFS(g, v1, v2, metrica);
        }
        else if(cont == 0)
        {
            printf("SAINDO....\n");
        }
        else printf("Opcao invalida!");
        system("PAUSE");
        system("cls");
    }while(cont != 0);

    /**-------------------------------------FIM MAIN DE GRAFO------------------------------------------------**/

    return 0;
}
