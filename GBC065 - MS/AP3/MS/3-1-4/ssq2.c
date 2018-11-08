
/* -------------------------------------------------------------------------
 * This program - an extension of program ssq1.c - simulates a single-server
 * FIFO service node using Exponentially distributed interarrival times and
 * Uniformly distributed service times (i.e. a M/U/1 queue).
 *
 * Name              : ssq2.c  (Single Server Queue, version 2)
 * Author            : Steve Park & Dave Geyer
 * Language          : ANSI C
 * Latest Revision   : 9-11-98
 * -------------------------------------------------------------------------
 */

#include <stdio.h>
#include <math.h>
#include "rng.h"

#define LAST         1000L                   /* number of jobs processed */
#define START        0.0                      /* initial time             */

#define A 1.3D
#define B 2.3D //A < B
#define M 2.0D //m > 0.0

double Exponential()
{
  return (-M * log(1.0 - Random()));
}

double Uniform()
{
  return (A + (B - A) * Random());
}

double GetArrival(void)
{
  static double arrival = START;

  arrival += Exponential();
  return (arrival);
}

double GetService(void)
{
  return (Uniform());
}


  int main(void)
{
  long   index     = 0;                         /* job index            */
  double arrival   = START;                     /* time of arrival      */
  double delay;                                 /* delay in queue       */
  double service;                               /* service time         */
  double wait;                                  /* delay + service      */
  double departure = START;                     /* time of departure    */
  struct {                                      /* sum of ...           */
    double delay;                               /*   delay times        */
    double wait;                                /*   wait times         */
    double service;                             /*   service times      */
    double interarrival;                        /*   interarrival times */
  } sum = {0.0, 0.0, 0.0};

  int count = 0;

  PutSeed(12345);
  //PutSeed(54321);
  //PutSeed(2121212);


  while (index < LAST) {
    count++;                                     /*VARIAVEL COUNT*/
    index++;
    arrival      = GetArrival();
    if (arrival < departure)
      delay      = departure - arrival;         /* delay in queue    */
    else
      delay      = 0.0;                         /* no delay          */
    service      = GetService();
    wait         = delay + service;
    departure    = arrival + wait;              /* time of departure */
    sum.delay   += delay;
    sum.wait    += wait;
    sum.service += service;
    //if( (count % 20) == 0 )
      //printf("%6.2f\n", sum.wait / index);
  }
  sum.interarrival = arrival - START;

  printf("\nfor %ld jobs\n", index);
  printf("   average interarrival time = %6.2f\n", sum.interarrival / index);
  printf("   average wait ............ = %6.2f\n", sum.wait / index);
  printf("   average delay ........... = %6.2f\n", sum.delay / index);
  printf("   average service time .... = %6.2f\n", sum.service / index);
  printf("   average # in the node ... = %6.2f\n", sum.wait / departure);
  printf("   average # in the queue .. = %6.2f\n", sum.delay / departure);
  printf("   utilization ............. = %6.2f\n", sum.service / departure);

  return (0);
}
