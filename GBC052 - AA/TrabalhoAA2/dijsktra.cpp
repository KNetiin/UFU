#include <stdio.h>
#include <limits.h>

#define V 9

int printSolution(int dist[], int n)
{
   printf("Vertex   Distance from Source\n");
   for (int i = 0; i < V; i++)
      printf("%d tt %d\n", i, dist[i]);
}

int minDistance(int dist[], bool sptSet[])///---------O(V)
{
   // Initialize min value
   int min = INT_MAX, min_index;///-------------------O(1)

   for (int v = 0; v < V; v++)///---------------------O(V)
     if (sptSet[v] == false && dist[v] <= min)///---O(c*V)
         min = dist[v], min_index = v;///-----------O(c*V)

   return min_index;
}

void dijkstra(int graph[V][V], int src)///----------O(V*V)
{
     int dist[V];///----------------------------------O(V)
     bool sptSet[V];///-------------------------------O(V)

     for (int i = 0; i < V; i++)///-------------------O(V)
        dist[i] = INT_MAX, sptSet[i] = false;///----O(c*V)

     dist[src] = 0;///--------------------------------O(1)

     for (int count = 0; count < V-1; count++)///-----O(V)
     {
       int u = minDistance(dist, sptSet);///----------O(V)
       sptSet[u] = true;///---------------------------O(1)
       for (int v = 0; v < V; v++)///-----------------O(V)
         if (!sptSet[v] && graph[u][v] && dist[u] != INT_MAX
                        && dist[u]+graph[u][v] < dist[v])
            dist[v] = dist[u] + graph[u][v];///-----O(c*V)
     }
     printSolution(dist, V);
}

// driver program to test above function
int main()
{
   /* Let us create the example graph discussed above */
   int graph[V][V] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                      {4, 0, 8, 0, 0, 0, 0, 11, 0},
                      {0, 8, 0, 7, 0, 4, 0, 0, 2},
                      {0, 0, 7, 0, 9, 14, 0, 0, 0},
                      {0, 0, 0, 9, 0, 10, 0, 0, 0},
                      {0, 0, 4, 14, 10, 0, 2, 0, 0},
                      {0, 0, 0, 0, 0, 2, 0, 1, 6},
                      {8, 11, 0, 0, 0, 0, 1, 0, 7},
                      {0, 0, 2, 0, 0, 0, 6, 7, 0}
                     };

    dijkstra(graph, 0);

    return 0;
}
