#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "Matriz.h"

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
    return 0;
}
