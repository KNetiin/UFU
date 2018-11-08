#include<bits/stdc++.h>
#include <time.h>
#define qtd_tables 2

int tam_table;
int tam_table_antigo;
int *hashtable_1;
int *hashtable_2;
int *hashtable_aux;
// Array to store possible positions for a key
int pos[qtd_tables];

void rehashing(int x);
void printTable();
void initTable();
int hash(int function, int key);
void place(int key, int tableID, int cnt, int n);

void rehashing(int x)
{
    int i, j;
    tam_table_antigo = tam_table;
    tam_table = tam_table*2;

    hashtable_aux = (int*) realloc ( hashtable_aux, 2* tam_table_antigo * sizeof(int) );
    for(i = 0, j = 0 ; i < tam_table_antigo ; i++)
    {
        if(hashtable_1[i] != INT_MIN)
        {
            hashtable_aux[j] = hashtable_1[i];
            j++;
        }
        if(hashtable_2[i] != INT_MIN)
        {
            hashtable_aux[j] = hashtable_2[i];
            j++;
        }
    }
    initTable();

    for(i = 0 ; i < j; i++) place(hashtable_aux[i],0,0,tam_table);

    place(x,0,0,tam_table);
    //printTable();
}

void initTable()
{
    hashtable_1 = (int*) realloc ( hashtable_1, tam_table * sizeof(int) );
    hashtable_2 = (int*) realloc ( hashtable_2, tam_table * sizeof(int) );
    for (int i = 0 ; i < tam_table ; i++)
    {
        hashtable_1[i] = INT_MIN;
        hashtable_2[i] = INT_MIN;
    }
}

int hash(int function, int key)
{
    switch (function)
    {
        case 1: return key%tam_table;
        case 2: return (key/tam_table)%tam_table;
    }
}

/*Funcao que insere um elemento na tabela*/
void place(int key, int tableID, int cnt, int n)
{
    if (cnt == n)
    {
        //printf("%d unpositioned\n", key);
        rehashing(key);
        return;
    }

    pos[0] = hash(1, key);
    pos[1] = hash(2, key);

    if( (hashtable_1[pos[0]] == key) || (hashtable_2[pos[1]] == key) )
    {
        //printf("\nChave duplicada!!!");
        return;
    }

    if(tableID == 0)
    {
        if (hashtable_1[pos[tableID]] != INT_MIN)
        {
            int dis = hashtable_1[pos[tableID]];
            hashtable_1[pos[tableID]] = key;
            place(dis, (tableID+1)%qtd_tables, cnt+1, n);
        }
        else hashtable_1[pos[tableID]] = key;
    }

    if(tableID == 1)
    {
        if (hashtable_2[pos[tableID]] != INT_MIN)
        {
            int dis = hashtable_2[pos[tableID]];
            hashtable_2[pos[tableID]] = key;
            place(dis, (tableID+1)%qtd_tables, cnt+1, n);
        }
        else hashtable_2[pos[tableID]] = key;
    }
}

/* Funcao que imprime o conteudo das tabelas */
void printTable()
{
    printf("Tabelas Hash:\n");

    printf("\n 1# |");
    for (int j=0; j<tam_table; j++)
    {
        if(hashtable_1[j] == INT_MIN)
        {
            printf("----|");
        }
        else
        {
            printf("%04d|", hashtable_1[j]);
        }
    }
    printf("\n 2# |");
    for (int j=0; j<tam_table; j++)
    {
        if(hashtable_2[j] == INT_MIN)
        {
            printf("----|");
        }
        else
        {
            printf("%04d|", hashtable_2[j]);
        }
    }
    printf("\n");
}

int main()
{
    int x = 0;
    tam_table = 11;
    tam_table_antigo = 0;
    clock_t t[2];
    

    initTable();

    while((fscanf (stdin, "%d", &x)) != EOF)
    {
	t[0] = clock();
        place(x , 0 , 0 , tam_table );
	t[1] = clock();       
	//printTable();
	printf("%g\n", ((t[1] - t[0])*1000.0 / CLOCKS_PER_SEC));
	
    }
	
	free(hashtable_1);
	free(hashtable_2);
	
    return 0;
}
