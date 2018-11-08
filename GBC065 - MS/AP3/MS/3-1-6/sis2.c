/* -------------------------------------------------------------------------
 * This program - an extension of program sis1.c - simulates a simple (s,S)
 * inventory system using Equilikely distributed demands.
 *
 * Name              : sis2.c  (Simple Inventory System, version 2)
 * Authors           : Steve Park & Dave Geyer
 * Language          : ANSI C
 * Latest Revision   : 8-28-97
 * -------------------------------------------------------------------------
 */

#include <stdio.h>
#include "rng.h"

//#define s  20                        /* 's' inventory policy parameter */
#define MAXIMUM  80                        /* 'S' inventory policy parameter */
#define STOP     100                       /* number of time intervals       */
#define sqr(x)   ((x) * (x))
#define citem 8000
#define csetup 1000
#define chold 25
#define cshort 700
#define smin 1
#define smax 61


   long Equilikely(long a, long b)
/* ------------------------------------------------
 * generate an Equilikely random variate, use a < b
 * ------------------------------------------------
 */
{
  return (a + (long) ((b - a + 1) * Random()));
}


   long GetDemand(void)
/* ------------------------
 * generate the next demand
 * ------------------------
 */
{
  return (Equilikely(10, 50));
}


  int main(void)
{
  long index     = 0;                      /* time interval index     */
  long inventory = MAXIMUM;                /* current inventory level */
  long demand;                             /* amount of demand        */
  long order;                              /* amount of order         */
  struct {                                 /* sum of ...              */
    double setup;                          /*   setup instances       */
    double holding;                        /*   inventory held (+)    */
    double shortage;                       /*   inventory short (-)   */
    double order;                          /*   orders                */
    double demand;                         /*   demands               */
  } sum = {0.0, 0.0, 0.0, 0.0, 0.0};

  double dmenor;
  double smenor;
  double averageOrder;
  double setupHz;
  double averageHold;
  double averageShort;
  double costDependent;

  PutSeed(-1);//PASSANDO UM NUMERO NEGATIVO ELE PEGA DO RELOGIO
  long seed;
  GetSeed(&seed);

  for(int s = smin; s < smax; s++){
    index = 0;
    inventory = MAXIMUM;
    averageOrder = 0;
    averageHold = 0;
    averageShort = 0;
    setupHz = 0;
    costDependent = 0;
    sum.setup = 0;
    sum.holding = 0;
    sum.shortage = 0;
    sum.order = 0;
    sum.demand = 0;

    PutSeed(seed);//6789);

    while (index < STOP) {
      index++;
      if (inventory < s) {             /* place an order */
        order         = MAXIMUM - inventory;
        sum.setup++;
        sum.order    += order;
      }
      else                                   /* no order       */
        order         = 0;
      inventory      += order;               /* there is no delivery lag */
      demand          = GetDemand();
      sum.demand     += demand;
      if (inventory > demand)
        sum.holding  += (inventory - 0.5 * demand);
      else {
        sum.holding  += sqr(inventory) / (2.0 * demand);
        sum.shortage += sqr(demand - inventory) / (2.0 * demand);
      }
      inventory     -= demand;
    }

    if (inventory < MAXIMUM) {               /* force the final inventory to */
      order      = MAXIMUM - inventory;      /* match the initial inventory  */
      sum.setup++;
      sum.order += order;
      inventory += order;
    }

    averageOrder = sum.order / index;
    setupHz = sum.setup / index;
    averageHold = sum.holding / index;
    averageShort = sum.shortage / index;
    costDependent = setupHz*csetup + averageHold*chold + averageShort*cshort;

    printf("\nfor %ld time intervals ", index);
    printf("with an average demand of %6.2f\n", sum.demand / index);
    printf("and policy parameters (s, S) = (%d, %d)\n\n", s, MAXIMUM);
    printf("   average order ............ = %6.2f\n", sum.order / index);
    printf("   setup frequency .......... = %6.2f\n", sum.setup / index);
    printf("   average holding level .... = %6.2f\n", sum.holding / index);
    printf("   average shortage level ... = %6.2f\n", sum.shortage / index);
    printf("   Dependent Cost ... = %6.2f\n", costDependent);
  }
  return (0);
}
