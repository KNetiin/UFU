#include <stdio.h>
#include <stdlib.h>

#define exp 0.00004539992D
#define inicio 0L
#define fim 21L

double potencia(int x){
  double resultado = 1;
  for(int i = 0; i < x; i++)
    resultado *= 10;
  return resultado;
}

double fatorial(int x){
  double resultado = 1;
  for(int i = 2; i <= x; i++){
    resultado *= i;
  }
  return resultado;
}

int main(void){
  double pot;
  double fat;
  double top;

  for(int i = inicio; i <= fim; i++){
    fat = fatorial(i);
    pot = potencia(i);
    top = exp*pot;
    printf("f(%ld) ~= %7.3f\n", i, (top/fat));
  }
  return 1;
}
