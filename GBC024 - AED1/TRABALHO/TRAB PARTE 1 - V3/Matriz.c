#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "Matriz.h"

int matriz_tamanho()
{
    int n=0;
    printf("\nDigite o tamanho do lado do labirinto:\n");
    do
    {
        fflush(stdin);
        scanf("%d",&n);
        if(n<2) printf("\nDigite um valor inteiro maior do que 1.\n");
        if(n>31) printf("\nDigite um valor inteiro menor do que 32.\n");
    }
    while(n<2 || n>31);
    return n;
}

int** matriz_alocar(int n)
{
    int i, j;
    int **M = (int**) malloc(n * sizeof(int*));

    for(i=0 ; i<n ; i++)
    {
        M[i] = (int*) malloc(n * sizeof(int));
        for(j=0 ; j<n ; j++)
        {
            M[i][j] = 9;
        }
    }
    return M;
}

void matriz_imprime(int **M, int n)
{
    int i, j, k;

    printf("\n\n\t\t\t**Labirinto**\n\n");
    for(i=0 ; i<n ; i++)
    {
        for(k=0; k<(31-n); k++)
        {
            printf(" ");
        }
        for(j=0 ; j<n ; j++)
        {
            if(M[i][j] == 0) printf("7 ");
            else if(M[i][j] == 5) printf("9 ");
            else printf("%d ", M[i][j]);
        }
        printf("\n");
    }
}

int matriz_canto(int n, int Linha, int Coluna)
{
    if(Linha == 0 && Coluna == 0) return(1);
    if(Linha == 0 && Coluna == (n-1)) return(2);
    if(Linha == (n-1) && Coluna == 0) return(3);
    if(Linha == (n-1) && Coluna == (n-1)) return(4);
    if(Linha == 0 && Coluna >= 0 && Coluna < n) return(12);
    if(Linha == (n-1) && Coluna >= 0 && Coluna < n) return(34);
    if(Coluna == 0 && Linha >= 0 && Linha < n) return(13);
    if(Coluna == (n-1) && Linha >= 0 && Linha < n) return(24);
    if(Linha < 0 || Coluna < 0 || Linha >= n || Coluna >= n) return (5);
    return(0);
}

int matriz_volta(int **M, int n, int Linha, int Coluna)
{
    int cont=0;
    int aux = matriz_canto(n,Linha,Coluna);
    if(aux == 1)
    {
        if(M[0][1] == 0) cont++;
        if(M[1][0] == 0) cont++;
        return cont;
    }
    if(aux == 2)
    {
        if(M[0][n-2] == 0) cont++;
        if(M[1][n-1] == 0) cont++;
        return cont;
    }
    if(aux == 3)
    {
        if(M[n-1][1] == 0) cont++;
        if(M[n-2][0] == 0) cont++;
        return cont;
    }
    if(aux == 4)
    {
        if(M[n-1][n-2] == 0) cont++;
        if(M[n-2][n-1] == 0) cont++;
        return cont;
    }
    if(aux == 12)
    {
        if(M[0][(Coluna+1)] == 0) cont++;
        if(M[0][(Coluna-1)] == 0) cont++;
        if(M[1][Coluna] == 0) cont++;
        return cont;
    }
    if(aux == 34)
    {
        if(M[(n-1)][(Coluna+1)] == 0) cont++;
        if(M[(n-1)][(Coluna-1)] == 0) cont++;
        if(M[(n-2)][Coluna] == 0) cont++;
        return cont;
    }
    if(aux == 13)
    {
        if(M[(Linha+1)][0] == 0) cont++;
        if(M[(Linha-1)][0] == 0) cont++;
        if(M[Linha][1] == 0) cont++;
        return cont;
    }
    if(aux == 24)
    {
        if(M[(Linha+1)][(n-1)] == 0) cont++;
        if(M[(Linha-1)][(n-1)] == 0) cont++;
        if(M[Linha][(n-2)] == 0) cont++;
        return cont;
    }
    if(aux == 0)
    {
        if(M[Linha][(Coluna+1)] == 0) cont++;
        if(M[Linha][(Coluna-1)] == 0) cont++;
        if(M[(Linha+1)][Coluna] == 0) cont++;
        if(M[(Linha-1)][Coluna] == 0) cont++;
        return cont;
    }
    if(aux == 5) return (7);
    return (-1);
}

int** matriz_reniciar(int **M, int n)
{
    int i, j;
    for(i = 0 ; i<n ; i++)
    {
        for(j = 0 ; j<n ; j++)
        {
            if(M[i][j] == 5) M[i][j] = 9;
        }
    }
    return M;
}

int matriz_retrocede(int **M, int n, int *Linha, int *Coluna)
{
    int auxp, li, co;
    auxp = matriz_canto(n,*Linha,*Coluna);

    li = *Linha;
    co = *Coluna;
    if(auxp == 1)
    {
        if(M[(*Linha+1)][*Coluna] == 0) (*Linha)++;
        else if(M[*Linha][(*Coluna+1)] == 0) (*Coluna)++;
    }
    if(auxp == 2)
    {
        if(M[(*Linha+1)][*Coluna] == 0) (*Linha)++;
        else if(M[*Linha][(*Coluna-1)] == 0) (*Coluna)--;
    }
    if(auxp == 3)
    {
        if(M[(*Linha-1)][*Coluna] == 0) (*Linha)--;
        else if(M[*Linha][(*Coluna+1)] == 0) (*Coluna)++;
    }
    if(auxp == 4)
    {
        if(M[(*Linha-1)][*Coluna] == 0) (*Linha)--;
        else if(M[*Linha][(*Coluna-1)] == 0) (*Coluna)--;
    }
    if(auxp == 12)
    {
        if(M[(*Linha+1)][*Coluna] == 0) (*Linha)++;
        else if(M[*Linha][(*Coluna+1)] == 0) (*Coluna)++;
        else if(M[*Linha][(*Coluna-1)] == 0) (*Coluna)--;
    }
    if(auxp == 34)
    {
        if(M[(*Linha-1)][*Coluna] == 0) (*Linha)--;
        else if(M[*Linha][(*Coluna+1)] == 0) (*Coluna)++;
        else if(M[*Linha][(*Coluna-1)] == 0) (*Coluna)--;
    }
    if(auxp == 13)
    {
        if(M[(*Linha-1)][*Coluna] == 0) (*Linha)--;
        else if(M[(*Linha+1)][*Coluna] == 0) (*Linha)++;
        else if(M[*Linha][(*Coluna+1)] == 0) (*Coluna)++;
    }
    if(auxp == 24)
    {
        if(M[(*Linha-1)][*Coluna] == 0) (*Linha)--;
        else if(M[(*Linha+1)][*Coluna] == 0) (*Linha)++;
        else if(M[*Linha][(*Coluna-1)] == 0) (*Coluna)--;
    }
    if(auxp == 0)
    {
        if(M[(*Linha-1)][*Coluna] == 0) (*Linha)--;
        else if(M[(*Linha+1)][*Coluna] == 0) (*Linha)++;
        else if(M[*Linha][(*Coluna+1)] == 0) (*Coluna)++;
        else if(M[*Linha][(*Coluna-1)] == 0) (*Coluna)--;
    }
    if(auxp == 5)
    {
        printf("\nERROR...RETROCEDE\n");
        return -1;
    }
    if(*Linha != li && *Coluna != co) return -1;
    if(li == *Linha && co == *Coluna) return 0;
    return 1;
}

int* matriz_possiveis(int **M, int n, int Linha, int Coluna, int *P)
{
    int k, auxp;
    P[0] = 0;
    P[1] = 0;
    P[2] = 0;
    P[3] = 0;
    auxp = matriz_canto(n,Linha,Coluna);
    //printf("\nAUXP : %d", auxp);
    if(auxp == 5)
    {
        printf("\nErro Critico, nao existe posicao");
        P[0] = -1;
        return P;
    }
    if(auxp == 1 || auxp == 2 || auxp == 12) P[0] = 0;
    else
    {
        k = matriz_volta(M,n,(Linha-1),Coluna);
        if(k == 1 && M[(Linha-1)][Coluna] == 9) P[0] = 1;
        if(k == 1 && M[(Linha-1)][Coluna] == 2) P[0] = 2;
    }
    if(auxp == 2 || auxp == 4 || auxp == 24) P[1] = 0;
    else
    {
        k = matriz_volta(M,n,Linha,(Coluna+1));
        if(k == 1 && M[Linha][(Coluna+1)] == 9) P[1] = 1;
        if(k == 1 && M[Linha][(Coluna+1)] == 2) P[1] = 2;
    }
    if(auxp == 3 || auxp == 4 || auxp == 34) P[2] = 0;
    else
    {
        k = matriz_volta(M,n,(Linha+1),Coluna);
        if(k == 1 && M[(Linha+1)][Coluna] == 9) P[2] = 1;
        if(k == 1 && M[(Linha+1)][Coluna] == 2) P[2] = 2;
    }
    if(auxp == 1 || auxp == 3 || auxp == 13) P[3] = 0;
    else
    {
        k = matriz_volta(M,n,Linha,(Coluna-1));
        if(k == 1 && M[Linha][(Coluna-1)] == 9) P[3] = 1;
        if(k == 1 && M[Linha][(Coluna-1)] == 2) P[3] = 2;
    }
    return P;
}

int** matriz_caminho(int **M, int n, int Linha, int Coluna, int Linha1, int Coluna1, int *P)
{

    int p2 = (n*n)/4, li, co, uno = 0;
    int i, j, k, MM = 0, c, c2, ra, retrocede = 0, vezes = 1;

    srand((unsigned)time(NULL));

    /*********************************COMEÇO GERAR CAMINHO TOTALMENTE ALEATORIO************************/
    while(M[Linha][Coluna] != 2)
        //for(j = 0 ; j < p2 ; j++)
    {
        //system("PAUSE");
        //printf("\n%d",vezes);

        /****************************Inicialização das Varáveis********************/
        MM = 0;
        c = 0;
        c2 = 0;
        li = Linha;
        co = Coluna;
        P = matriz_possiveis(M,n,Linha,Coluna,P);
        vezes++;

        for(j = 0 ; j < 4 ; j++)
        {
            if(P[j] == 2)
            {
                MM = (j+1);
                uno = 1;
            }
        }
        if(P[0] == -1)
        {
            printf("\nError em Posicao");
            break;
        }
        if(vezes>=p2 && MM == 0)
        {
            if(Linha == Linha1)
            {
                P[0] = 0;
                P[2] = 0;
            }
            else
            {
                if(Linha > Linha1) P[3] = 0;
                else P[0] = 0;
            }
            if(Coluna == Coluna1)
            {
                P[1] = 0;
                P[3] = 0;
            }
            else
            {
                if(Coluna > Coluna1) P[1] = 0;
                else P[3] = 0;
                }
        }
        for(i = 0 ; i < 4 ; i++)
        {
            if(P[i] == 1) c++;
        }
        if(c == 0 && MM == 0)
        {
            //printf("\n ENTRO EM C == 0");
            M[Linha][Coluna] = 5;
            retrocede = matriz_retrocede(M,n,&Linha,&Coluna);
            vezes--;
            if(retrocede == -1) printf("\n EH NECESSARIO RENICIAR");//reniciar
            if(retrocede == 0)
            {
                Linha = li;
                Coluna = co;
                //error
                printf("\nError, Retrocede");
            }
        }
        else if(MM == 0)
        {
            {
                ra = rand()%c;
                //printf("\n RAND : %d  C : %d ",ra, c );
                for(k = 0 ; c2 <= ra ; k++)
                {
                    if(P[k] == 1) c2++;
                }
                if(MM == 0) MM = k;
            }
        }
        //printf("\n\n Posicao a mover %d",MM);
        switch (MM)
        {
        case 1:
            Linha--;
            break;

        case 2:
            Coluna++;
            break;

        case 3:
            Linha++;
            break;

        case 4:
            Coluna--;
            break;

        default:
            ;

        }
        //printf("\nSwitch case.");*/
        //printf("\nLinha : %d, Coluna : %d", Linha, Coluna);
        //if(M[Linha][Coluna] == 2) {printf("\n\n**********finish*******");break; }
        if(uno == 0) M[Linha][Coluna] = 0;
        //matriz_imprime(M,n);
    }
    //printf("\n\n Saiu do WHILE");
   // M = matriz_reniciar(M,n);
    /*********************************FIM GERAR CAMINHO TOTALMENTE ALEATORIO************************/
//
//    while(M[Linha][Coluna] != 2)
//    {
//        P = matriz_possiveis(M,n,Linha,Coluna,P);
//        if(Linha == Linha1)
//        {
//            P[0] = 0;
//            P[2] = 0;
//        }
//        else
//        {
//            if(Linha > Linha1) P[3] = 0;
//            else P[0] = 0;
//        }
//        if(Coluna == Coluna1)
//        {
//            P[1] = 0;
//            P[3] = 0;
//        }
//        else
//        {
//            if(Coluna > Coluna1) P[1] = 0;
//            else P[3] = 0
//            }
//
//    }
    return M;
}

