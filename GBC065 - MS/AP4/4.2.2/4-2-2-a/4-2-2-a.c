#include <stdio.h>
#include "rng.h"

#define N 1000L                          /* number of boxes */
#define M 2000L                          /* number of balls */

long Equilikely(long a, long b){
  return (a + (long) ((b - a + 1) * Random())); //use a < b
}

int main(void){
  long index = 0;
  long qt_balls[N];
  long boxe;
  long balls[M];
  long total = 0;
  double p;

  PutSeed(12345);

  /*********INICIALIZANDO O CONTADOR DE CADA CAIXA COM 0**********/
  for (int i = 0; i < N; i++)
    qt_balls[i] = 0;

  /*SORTEANDO UMA CAIXA PARA CADA BALL E INCREMENTANDO O CONTADOR*/
  for (int j = 0; j < M; j++) {
    boxe = Equilikely(1, N);
    qt_balls[(boxe - 1)]++;
  }

  /*********INICIALIZANDO O CONTADOR DE BALLS POR BOXES**********/
  for (int i = 0; i < M; i++)
    balls[i] = 0;

  /********CONTABILIZANDO O CONTADOR DE BALLS POR BOXES**********/
  for (int i = 0; i < N; i++)
    balls[qt_balls[i]]++;

  /*********CONTABILIZANDO A PROBABILIDADE DE CADA BALL**********/
  double teste = 0.0;
  while(total != M){
    p = (double) (balls[index])/(double) N;
    teste += p;
    printf("p[%2ld] = %5.3f\n", index, p);
    total += balls[index]*index;
    index++;
  }
  printf("TOTAL: %f\n", teste);
  return (0);
}
