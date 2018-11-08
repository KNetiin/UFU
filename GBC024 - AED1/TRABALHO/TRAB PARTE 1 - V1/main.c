/** TRABALHO DE AED
    NOME :  ANTONIO CARLOS NETO
            LUCAS ROSSI RABELO
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "Matriz.h"
#include "pilha.h"

int main(int argc, char **argv)
{
    int n/**, i, aux = 0**/;
    int **M;

    int *P = (int*) malloc( 4 * sizeof(int));
    n = matriz_tamanho();
    M = matriz_alocar(n);
    matriz_imprime(M,n);

    /****************************************PONTO INICIO*******************************************/
    int Linha=0, Coluna=0, auxi=0;
    printf("\nDigite onde estarah o comeco do labirinto:\n");
    do
    {
        printf("Linha: ");
        fflush(stdin);
        scanf("%d",&Linha);
        printf("Coluna: ");
        fflush(stdin);
        scanf("%d",&Coluna);
        auxi = matriz_canto(n,Linha,Coluna);
        if(auxi == 0) printf("\nDigite valores para o ponto estar no canto do Labirinto.\n");
        if(auxi == 5)
        {
            printf("\nValores invalidos, Digite outros valores.\n");
            auxi = 0;
        }
    }
    while(auxi == 0);
    M[Linha][Coluna] = 0;
    /************************************************************************************************/

    /****************************************PONTO FINAL*********************************************/
    int Linha1=0, Coluna1=0, auxf=0;
    printf("\nDigite onde estarah o final do labirinto:\n");
    do
    {
        printf("Linha: ");
        fflush(stdin);
        scanf("%d",&Linha1);
        printf("Coluna: ");
        fflush(stdin);
        scanf("%d",&Coluna1);
        auxf = matriz_canto(n,Linha1,Coluna1);
        if(auxf == 0) printf("\nDigite valores para o ponto estar no canto do Labirinto.\n");
        if(auxf == 5)
        {
            printf("\nValores invalidos, Digite outros valores.\n");
            auxf = 0;
        }
        if(Linha == Linha1 && Coluna == Coluna1)
        {
            printf("\nInicio igual o Final, Digite outros valores.\n");
            auxf = 0;
        }
    }
    while(auxf == 0);
    M[Linha1][Coluna1] = 2;
    /************************************************************************************************/
    matriz_imprime(M,n);
    M = matriz_caminho(M,n,Linha,Coluna,Linha1,Coluna1,P);
    matriz_imprime(M,n);
    M = matriz_C_aleatorio(M,n,Linha,Coluna,Linha1,Coluna1,P);
    matriz_imprime(M,n);

    /**********************************************RESOLVENDO LABIRINTO******************************/
    int k = 0, k1 = 0, funfa;
    Stack Pilha;
    Pilha = cria_pilha(&Pilha);

    while(1)
    {
        printf("\n");
        system("PAUSE");

        k = matriz_volta(M,n,Linha,Coluna);
        k1 = matriz_voltaH(M,n,Linha,Coluna,2);
        if(k1 == 1)
        {
            M[Linha][Coluna] = 4;
            break;
        }

        if(k == 0)
        {
            if(M[Linha][Coluna] == 0)
            {
                M[Linha][Coluna] = 4;
            }
            else if(M[Linha][Coluna] == 6)
            {
                remove_pilha(&Pilha);
                Linha = Pilha.tail->Linha;
                Coluna = Pilha.tail->Coluna;
            }else
            {
                Linha = Pilha.tail->Linha;
                Coluna = Pilha.tail->Coluna;
            }
        }
        if(k == 1 && M[Linha][Coluna] != 6) funfa = matriz_percorreH(M,n,&Linha,&Coluna,P,0);
        if(k > 1 || M[Linha][Coluna] == 6 )
        {
            printf("\n\nENTROU NO K>1");
            P = matriz_possiveis2(M,n,Linha,Coluna,P);
            if(P[0] == 1)
            {
                M[Linha][Coluna] = 6;
                adiciona_pilha(&Pilha,12,Linha,Coluna);
                Linha--;
                M[Linha][Coluna] = 4;
                printf("\n\n0");
            }
            else if(P[1] == 1)
            {
                M[Linha][Coluna] = 6;
                adiciona_pilha(&Pilha,3,Linha,Coluna);
                Coluna++;
                M[Linha][Coluna] = 4;
                printf("\n\n1");
            }
            else if(P[2] == 1)
            {
                M[Linha][Coluna] = 6;
                adiciona_pilha(&Pilha,6,Linha,Coluna);
                Linha++;
                M[Linha][Coluna] = 4;
                printf("\n\n2");
            }
            else if(P[3] == 1)
            {
                M[Linha][Coluna] = 6;
                adiciona_pilha(&Pilha,9,Linha,Coluna);
                Coluna--;
                M[Linha][Coluna] = 4;
                printf("\n\n3");
            }
        }
        matriz_imprime(M,n);
    }
    matriz_imprime(M,n);
    printf("\n\n:)***************FIM DO LABIRINTO***************:)\n\n");

    return 0;
}
