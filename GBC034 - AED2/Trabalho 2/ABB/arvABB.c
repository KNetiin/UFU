#include <stdlib.h>
#include <stdio.h>
#include "arvABB.h"

Arv cria_arvore()
{
	return NULL;
}



int arvore_vazia(Arv *A)
{
	if ((*A) == NULL) return 1;
	return 0;
}

void libera_arvore(Arv *A)
{
	if ((*A) == NULL) return;
	libera_arvore(&((*A)->sae));
	libera_arvore(&((*A)->sad));
	free(*A);
	(*A) = NULL;
}

void exibe_arvore(Arv A)
{
	if (A == NULL)
	{
		printf("<>");
		return;
	}

	printf("<");
	printf("%d", A->info.idade);
	exibe_arvore(A->sae);
	exibe_arvore(A->sad);
	printf(">");
}

void exibe_ordenado(Arv A)
{
	if (A == NULL) return;
	exibe_ordenado(A->sae);
	printf("%d ", A->info.idade);
	exibe_ordenado(A->sad);
}

int insere_ord(Arv *A, reg elem)
{
	if (A == NULL) return 0;
	if ((*A) == NULL)
	{
		Arv no = (struct no*) malloc(sizeof(struct no));
		if (no == NULL) return 0;

		no->info = elem;
		no->sad = NULL;
		no->sae = NULL;
		(*A) = no;
		return 1;
	}
	if (elem.idade > (*A)->info.idade) return insere_ord(&((*A)->sad), elem);
	return insere_ord(&((*A)->sae), elem);
}

int remove_ord(Arv *A, int chave)
{
	Arv aux;
	if (A == NULL) return 0;
	if ((*A) == NULL) return 0;
	if (chave > (*A)->info.idade) return remove_ord(&((*A)->sad), chave);
	if (chave < (*A)->info.idade) return remove_ord(&((*A)->sae), chave);

	if ((*A)->sad == NULL && (*A)->sae == NULL)
	{
		free(*A);
		(*A) = NULL;
		return 1;
	}

	if ((*A)->sae != NULL && (*A)->sad == NULL)
	{
		aux = (*A);
		(*A) = (*A)->sae;
		free(aux);
		return 1;
	}

	if ((*A)->sae == NULL && (*A)->sad != NULL)
	{
		aux = (*A);
		(*A) = (*A)->sad;
		free(aux);
		return 1;
	}

	aux = (*A)->sae;
	while (aux->sad != NULL) aux = aux->sad;
	reg temp = (*A)->info;
	(*A)->info = aux->info;
	aux->info = temp;
	return remove_ord(&((*A)->sae), chave);
}

Arv busca_bin(Arv A, int chave)
{
	if (A == NULL) return NULL;
	if (A->info.idade == chave) return A;
	if (chave > A->info.idade) return busca_bin(A->sad, chave);
	return busca_bin(A->sae, chave);
}

//****************************************************************Daqui para cima, são as operações básicas**********************************************************//

reg * maior(Arv A)
{
	if (A == NULL) {
		return NULL;
	}
	if (A->sad != NULL) {
		return maior(A->sad);
	}

	return &(A->info);
}

int de_maior(Arv A) {
	int ac = 0;
	if (A == NULL) {
		return 0;             //Arvore Vazia
	}
	if (A->info.idade < 18) {
		return 0;

	}
	if (A->info.idade >= 18) {

		return 1 + de_maior(A->sad) + de_maior(A->sae);

	}

}

int qtde_nos(Arv A, int ini, int fim) {

	if (A == NULL) {
		return 0;             //Arvore Vazia
	}
	if (A->info.idade >= ini && A->info.idade <= fim) {  //Comparação se a chave do nó está dentro do intervalo

		return (1 + qtde_nos(A->sad, ini, fim) + qtde_nos(A->sae, ini, fim));

	}
	else {
		return (0 + qtde_nos(A->sad, ini, fim) + qtde_nos(A->sae, ini, fim));
	}


}

int um_filho(Arv A) {
	if (A == NULL) {
		return 0;             //Arvore Vazia
	}
	if ((A->sae != NULL && A->sad == NULL) ){  //Comparação se o nó atual possui apenas um filho a esquerda.

		return 1 + um_filho(A->sae);

	}
	else if ((A->sae == NULL && A->sad != NULL)) { //Comparação se o nó atual possui apenas um filho a direita.

		return 1 + um_filho(A->sad);
	}
	else if((A->sad != NULL) && A->sae != NULL){ //Para o caso de que o nó atual possua dois filhos.
		return 0 + um_filho(A->sad) + um_filho(A->sae);
	}
	else {   //Se o nó atual não tiver nenhum filho.
		return 0;
	}

}
//--------------------------------------------------------------------------------------------------------------------------//
int pot_2(int n)
{
	int i, ac = 1;
	for (i = 0; i < n; i++)
	{
		ac *= 2;
	}
	return ac;
}

int calc_2(int n)
{
	int i = 0;
	while (n != 0)
	{
		n = (n - 1) / 2;
		i++;
	}
	return i;
}

int altura(Arv A)
{
    if(A == NULL) return -1;
    int esq, maior;
    esq = altura(A->sae);
    maior = altura(A->sad);

    if(esq > maior) maior = esq;
    return (maior + 1);
}

int profundidade(Arv A, Arv sub)
{
    Arv *fila;
    Arv aux;
    Arv pimba = (Arv) malloc(sizeof(Arv));
    pimba->sad = NULL;
    pimba->sae = NULL;
    pimba->info.idade = -5;
    int i;
    int qt = (pot_2(altura(A) + 1) -1);
    fila = calloc(qt,sizeof(Arv));
    fila[0] = A;
    for(i = 0; (2*i + 2) < qt; i++)
    {
        aux = fila[i];
        if(aux->info.idade != -5)
        {
            if(aux->sae != NULL) fila[2*i + 1] = aux->sae;
            else fila[2*i + 1] = pimba;
            if(aux->sad != NULL) fila[2*i + 2] = aux->sad;
            else fila[2*i + 2] = pimba;
        }else
        {
            fila[2*i + 1] = pimba;
            fila[2*i + 2] = pimba;
        }
    }
    i = 0;
    while(i < qt)
    {
        if(fila[i]->info.idade != -5)
        {
            if(sub->info.idade == fila[i]->info.idade)
            {
                free(fila);
                return calc_2(i);
            }
        }
        i++;
    }
    free(fila);
    return -1;
}
//--------------------------------------------------------------------------------------------------------------------------//
/*
int completa(Arv A) {
	if (A == NULL){     //Árvore vazia
		return 0;
	}


}
*/

int altura_arv(Arv A)
{
	if (A == NULL)
		return -1;
	int esquerda = altura_arv(A->sae);
	int direita = altura_arv(A->sad);
	if (esquerda > direita)							//Verificando qual das sub_arvores possui maior altura
		return esquerda + 1;
	else
		return direita + 1;
}

Arv juntar(Arv A, Arv B){
	if (A == NULL && B == NULL) {
		return NULL;
	}
	if (A != NULL && B == NULL) {
		return A;
	}
	if (A == NULL && B != NULL) {
		return B;
	}
	if (A != NULL && B != NULL) {
		insere_ord(&A, B->info);
		juntar(A, B->sae);
		juntar(A, B->sad);
		return A;

	}

}
