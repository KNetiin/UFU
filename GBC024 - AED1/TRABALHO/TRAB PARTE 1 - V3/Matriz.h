#ifndef MATRIZ_H_INCLUDED
#define MATRIZ_H_INCLUDED

//FUNÇÕES

int matriz_tamanho();
int** matriz_alocar(int n);
void matriz_imprime(int **M, int n);
int matriz_canto(int n, int Linha, int Coluna);
int matriz_volta(int **M, int n, int Linha, int Coluna);
int** matriz_reniciar(int **M, int n);
int matriz_retrocede(int **M, int n, int *Linha, int *Coluna);
int* matriz_possiveis(int **M, int n, int Linha, int Coluna, int *P);
int** matriz_caminho(int **M, int n, int Linha, int Coluna, int Linha1, int Coluna1, int *P);

#endif // MATRIZ_H_INCLUDED
