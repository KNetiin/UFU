#include <stdio.h>
#include <stdlib.h>

#include "grafo.h"
//batata
int main()
{

    printf("\tTrabalho de AED2\n\nIntegrantes:\nAntonio Carlos Neto:\t 11611BCC054\nLucas Rossi Rabelo:\t 11611BCC044\nPaulo Renato C. Barbora: 11611BCC006\n");
    int tam, cont, v1,v2, baum, i, peso[4], ma_la, metrica, metodo, tamRec, j, aux, mensagem;
    float valor = 0;
    char x[30];
    GrafoM *G1 = NULL;
    Grafo *G = NULL;

    do
    {
        printf("\nEscolha uma Opcao:\n1 - Carregar grafo a partir de arquivo\n2 - Construir grafo a partir da quantidade de vertices\n");
        scanf("%d",&cont);
        if(cont == 1)
        {
           do
            {
                printf("\nEscolha a forma de implementacao:\n1 - Matriz de Adjacencia\n2 - Lista de Adjacencia\n");
                scanf("%d",&ma_la);
                ma_la--;
                if(ma_la == 0)
                {
                    printf("\tDigite o caminho do arquivo ou o nome caso esteja na mesma pasta: ");
                    scanf("%s",x);
                    G1 = busca_arquivoM(x);
                    if(G1 != NULL) printf("Grafo implementado com sucesso\n\n");
                }else if(ma_la == 1)
                {
                    printf("\tDigite o caminho do arquivo ou o nome caso esteja na mesma pasta: ");
                    scanf("%s",x);
                    G = busca_arquivo(x);
                    if(G != NULL) printf("Grafo implementado com sucesso\n\n");
                }else printf("\nOpcao Invalida!");
            }while(ma_la != 0 && ma_la != 1);
            system("PAUSE");
        }else if(cont == 2)
        {
            printf("Iniciando Construcao...\nDigite a quantidade de vertices: ");
            scanf("%d",&tam);
            do
            {
                printf("\nEscolha a forma de implementacao:\n1 - Matriz de Adjacencia\n2 - Lista de Adjacencia\n");
                scanf("%d",&ma_la);
                ma_la--;
                if(ma_la == 0)
                {
                    G1 = cria_grafoM(tam);
                }else if(ma_la == 1)
                {
                    G = cria_grafo(tam);
                }else printf("\nOpcao Invalida!");
            }while(ma_la != 0 && ma_la != 1);
        }else printf("\nOpcao Invalida!");
    }while(cont != 1 && cont != 2);
    system("cls");
    do
    {
        printf("Escolha uma das Opcoes:\n");
        printf("1  - Inserir Aresta\n2  - Remover Aresta\n3  - Consultar Aresta\n4  - Mostrar Grafo\n5  - Mostrar Numero de Vertices do Grafo\n6  - Consultar o Grau do Vertice\n7  - Verificar Adjacencia Entre Vertices\n8  - Salvar Grafo Implementado em Arquivo\n9  - Calcular Metricas\n0  - Sair\n\n");
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
                baum = consulta_aresta(NULL, G1, 0, v1, v2, peso);
            }else printf("\nERRO INESPERADO");
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
            if(ma_la == 1)
            {
                baum = grauVertice(G, NULL, 1, v1);
            }else if(ma_la == 0)
            {
                baum = grauVertice(NULL, G1, 0, v1);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
            printf("O vertice %d possui grau %d\n\n", v1, baum);
        }
        else if(cont == 7)
        {
            printf("\tDigite os vertices para que seja verificado adjacencia entre eles:\n");
            printf("\tVertice origem:");
            scanf("%d",&v1);
            printf("\tVertice destino:");
            scanf("%d",&v2);
            if(ma_la == 1)
            {
                baum = ehAdjacente(G, NULL, 1, v1, v2);
            }else if(ma_la == 0)
            {
                baum = ehAdjacente(NULL, G1, 0, v1, v2);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
            if(baum == 1) printf("Sao adjacentes\n\n");
            if(baum == 0) printf("Nao sao adjacentes\n\n");
        }
        else if(cont == 8)
        {
            if(ma_la == 1)
            {
                baum = cria_arquivo(G);
            }else if(ma_la == 0)
            {
                baum = cria_arquivoM(G1);
            }else printf("\nERRO INESPERADO");
            if(baum == -1) printf("**ERRO**\n");
            if(baum == 1) printf("Arquivo criado e escrito com sucesso\n\n");
        }
        else if(cont == 9)
        {
            printf("\nEscolha a metrica:\n1  - Custo total da arvore(peso 1)\n2  - Delay fim-a-fim maximo(peso 2)\n3  - Utilizacao maxima do enlace(peso 3 e 4)\n");
            do
            {
                scanf("%d",&metrica);
                if(metrica < 1 || metrica > 3) printf("\nNumero invalido");
            }while(metrica < 1 || metrica > 3);
            metrica--;
            printf("\n\nEscolha o metodo:\n1  - Busca em Profundidade\n2  - Busca em Largura\n3  - Codigo baseado no Dijkstra\n");
            do
            {
                scanf("%d",&metodo);
                if(metodo < 1 || metodo > 3) printf("\nNumero invalido");
            }while(metodo < 1 || metodo > 3);
            metodo--;
            system("cls");
            switch (metrica)
            {
            case 0:
                printf("Calculo da Metrica ''Custo total da arvore(peso 1)''\n");
            break;

            case 1:
                printf("Calculo da Metrica ''Delay fim-a-fim maximo(peso 2)''\n");
            break;

            case 2:
                printf("Calculo da Metrica ''Utilizacao maxima do enlace(peso 3 e 4)''\n");
            break;
            }

            switch (metodo)
            {
            case 0:
                printf("Metodo ''Busca em Profundidade''\n");
            break;

            case 1:
                printf("Metodo ''Busca em Largura''\n");
            break;

            case 2:
                printf("Metodo ''Codigo baseado no Dijkstra''\n");
            break;
            }
            printf("\nDigite o vertice Emissor: ");
            scanf("%d",&v1);

            printf("\nDigite a quantidade de Receptores: ");
            scanf("%d",&tamRec);

            int *Rec = (int*)(malloc(tamRec*sizeof(int)));
            if(Rec == NULL) printf("\n**ERRO NA ALOCAO (MAIN)**\n");
            for(j = 0; j < tamRec; j++)
            {
                printf("Digite o Receptor %d: ", j);
                scanf("%d",&aux);
                Rec[j] = aux;
            }
            if(metrica == 0)
            {
                if(ma_la == 1)
                {
                    custo_total(G, NULL, 1, metodo, v1, tamRec, Rec,&valor);
                    if(valor == -1) printf("\n**ERRO** CALCULO DO CUSTO (MAIN)\n");
                    printf("\nVALOR DA METRICA : %0.2f\n", valor);
                }else if(ma_la == 0)
                {
                    custo_total(NULL, G1, 0, metodo, v1, tamRec, Rec,&valor);
                    if(valor == -1) printf("\n**ERRO** CALCULO DO CUSTO (MAIN)\n");
                    printf("\nVALOR DA METRICA : %0.2f\n", valor);
                }
            }
            if(metrica == 1)
            {
                if(ma_la == 1)
                {
                    delay_max(G, NULL, 1, metodo, v1, tamRec, Rec,&valor);
                    if(valor == -1) printf("\n**ERRO** CALCULO DO CUSTO (MAIN)\n");
                    printf("\nVALOR DA METRICA : %0.2f\n", valor);
                }else if(ma_la == 0)
                {
                    delay_max(NULL, G1, 0, metodo, v1, tamRec, Rec,&valor);
                    if(valor == -1) printf("\n**ERRO** CALCULO DO CUSTO (MAIN)\n");
                    printf("\nVALOR DA METRICA : %0.2f\n", valor);
                }
            }
            if(metrica == 2)
            {
                printf("\nDigite o tamanho da mensagem: ");
                scanf("%d",&mensagem);
                if(ma_la == 1)
                {
                    enlace_max(G, NULL, 1, metodo, v1, tamRec, Rec,&valor,mensagem);
                    if(valor == -1) printf("\n**ERRO** CALCULO DO CUSTO (MAIN)\n");
                    printf("\nVALOR DA METRICA : %0.2f\n", valor);
                }else if(ma_la == 0)
                {
                    enlace_max(NULL, G1, 0, metodo, v1, tamRec, Rec,&valor,mensagem);
                    if(valor == -1) printf("\n**ERRO** CALCULO DO CUSTO (MAIN)\n");
                    printf("\nVALOR DA METRICA : %0.2f\n", valor);
                }
            }
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
