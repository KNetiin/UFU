/* -------------------------------------------------------------------------
 * This program reads a (text) data file and computes the mean, minimum,
 * maximum, and standard deviation.   The one-pass algorithm used is due to
 * B.P. Welford (Technometrics, vol. 4, no 3, August 1962.)
 *
 * NOTE: the text data file is assumed to be in a one-value-per-line format
 * with NO blank lines in the file.   The data can be either fixed point
 * (integer valued), or floating point (real valued).
 *
 * To use the program, compile it to disk to produce uvs.  Then at a command
 * line prompt, uvs can be used in three ways.
 *
 * (1) To have uvs read a disk data file, say uvs.dat (in the format above),
 * at a command line prompt use '<' redirection as:
 *
 *     uvs < uvs.dat
 *
 * (2) To have uvs filter the numerical output of a program, say test, at a
 * command line prompt use '|' pipe as:
 *
 *     test | uvs
 *
 * (3) To use uvs with keyboard input, at a command line prompt enter:
 *
 *      uvs
 *
 * Then enter the data -- one value per line -- being sure to remember to
 * signify an end-of-file.  In Unix/Linux, signify an end-of-file by
 * entering ^d (Ctrl-d) as the last line of input.
 *
 * Name              : uvs.c  (Univariate Statistics)
 * Authors           : Steve Park & Dave Geyer
 * Language          : ANSI C
 * Latest Revision   : 9-28-98
 * -------------------------------------------------------------------------
 */

#include <stdio.h>
#include <math.h>
#include <unistd.h>
#include "rngs.h"

#define LAST         100L                   /* number of jobs processed */
#define TAM          2L                     /* qtd de elementos do vetor intervalo*/
#define QT_SEED      10L                    /* qtd de rngs */

double Exponential(double m)
/* ---------------------------------------------------
* generate an Exponential random variate, use m > 0.0
* ---------------------------------------------------
*/
{
  return (-m * log(1.0 - Random()));
}

int main(void)
{
  long    index;
  double  data;
  double  sum;
  double  mean;
  double  stdev;
  double  diff;
  long seed;
  double intervalo[TAM] = {2,3};
  long count[TAM];
  double p;

  PlantSeeds(123456789L);

  for(int aux = 0; aux < QT_SEED; aux++){

    /*******************************REINICIALIZANDO AS VARIAVEIS*******************************/
    index = 0;
    sum = 0.0;
    for(int aux2 = 0; aux2 < TAM; aux2++)
      count[aux2] = 0;

    /*******************************GERANDO E GUARDANDO AS RNGS *******************************/
    SelectStream(aux);
    GetSeed(&seed);

    /*****************************GERANDO A MEDIA E O DESVIO PADRAO****************************/
    while (index < LAST) {
      data = Exponential(9);

      index++;
      if(index == 1)
        mean = data;

      diff  = data - mean;
      sum  += diff * diff * (index - 1.0) / index;
      mean += diff / index;
    }
    if(index > 0)
      stdev = sqrt(sum / index);

    /*************************CALCULANDO P(s) PARA OS VALORES DE K(s) *************************/
    SelectStream(aux);
    for(int i = 0; i < index; i++){
      data = Exponential(9);

      for(int j = 0; j < TAM; j++){
        if( fabs(data - mean) < (intervalo[j]*stdev) )
          count[j]++;
      }
    }

    if (index > 0) {
      printf("\nWelford of size %ld\n", index);
      printf("Seed ................................ = %ld\n", seed);
      printf("Mean ............................... = %7.3f\n", mean);
      printf("Standard Deviation ................. = %7.3f\n", stdev);
      for(int j = 0; j < TAM; j++){
        p = ((double) count[j]/ (double) index) ;
        printf("Proportion of Points if k = %3.0f .... = %7.3f\n",intervalo[j], p);
      }
    }
    sleep(1);
  }

  return (0);
}
