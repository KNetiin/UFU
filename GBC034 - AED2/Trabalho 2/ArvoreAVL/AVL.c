#include <stdio.h>
#include <stdlib.h>
#include "AVL.h"

Arv cria_vazia()
{
    return NULL;
}

int arvore_vazia(Arv *A)
{
    if((*A) == NULL) return 1;
    return 0;
}

int insere_ord(Arv *A, reg elem)
{
    if(A == NULL) return 0;
    if((*A) == NULL)
    {
        Arv no = (struct no*) malloc(sizeof(struct no));
        if(no == NULL) return 0;

        no->info = elem;
        no->sad = NULL;
        no->sae = NULL;
        (*A) = no;
        return 1;
    }
    if(elem.chave > (*A)->info.chave) return insere_ord(&((*A)->sad), elem);
    return insere_ord(&((*A)->sae), elem);
}

void libera_arvore(Arv *A)
{
    if((*A) == NULL) return;
    libera_arvore(&((*A)->sae));
    libera_arvore(&((*A)->sad));
    free(*A);
    (*A) = NULL;
}

void exibe_arvore(Arv A)
{
    if(A == NULL)
    {
        printf("<>");
        return;
    }

    printf("<");
    printf("%d",A->info.chave);
    exibe_arvore(A->sae);
    exibe_arvore(A->sad);
    printf(">");
}

void exibe_ordenado(Arv A)
{
    if(A == NULL) return;
    exibe_ordenado(A->sae);
    printf("%d ", A->info.chave);
    exibe_ordenado(A->sad);
}

Arv busca_bin(Arv A, int chave)
{
    if(A == NULL) return NULL;
    if(A->info.chave == chave) return A;
    if(chave > A->info.chave) return busca_bin(A->sad,chave);
    return busca_bin(A->sae,chave);
}

int busca(Arv *A,reg elem)
{
    if(*A==NULL) return 0;
    if((*A)->info.chave==elem.chave) return 1;
    if(busca(&((*A)->sae),elem)) return 1;
    if(busca(&((*A)->sad),elem)) return 1;
    return 0;
}

int remove_ord(Arv *A, int chave)
{
    Arv aux;
    if(A == NULL) return 0;
    if((*A) == NULL) return 0;
    if(chave > (*A)->info.chave) return remove_ord(&((*A)->sad), chave);
    if(chave < (*A)->info.chave) return remove_ord(&((*A)->sae), chave);

    if((*A)->sad == NULL && (*A)->sae == NULL)
    {
        free(*A);
        (*A) = NULL;
        return 1;
    }

    if((*A)->sae != NULL && (*A)->sad == NULL)
    {
        aux = (*A);
        (*A) = (*A)->sae;
        free(aux);
        return 1;
    }

    if((*A)->sae == NULL && (*A)->sad != NULL)
    {
        aux = (*A);
        (*A) = (*A)->sad;
        free(aux);
        return 1;
    }

    aux = (*A)->sae;
    while(aux->sad != NULL) aux = aux->sad;
    reg temp = (*A)->info;
    (*A)->info = aux->info;
    aux->info = temp;
    return remove_ord(&((*A)->sae), chave);
}

int insere_AVL(Arv *A,reg elem,int *Bal)
{
    if(A==NULL)
    {
        return 0;
    }

    struct no *novo=malloc(sizeof(struct no));
    if(novo==NULL)
    {
        return 0;
    }
    novo->info=elem;
    novo->sae=NULL;
    novo->sad=NULL;
    novo->fb=0;

    if((*A)==NULL)
    {
        *A=novo;
        *Bal=1;
    }
    else if(elem.chave<=(*A)->info.chave)
    {
        insere_AVL(&((*A)->sae),elem,Bal);
        if(*Bal==1)
        {
            if((*A)->fb==1)
            {
                balancear_esq(&((*A)));
                *Bal=0;
            }
            else if((*A)->fb==0)
            {
                (*A)->fb=1;
            }
            else
            {
                (*A)->fb=0;
                *Bal=0;
            }
        }
    }
    else
    {
        insere_AVL(&((*A)->sad),elem,Bal);
        if(*Bal==1)
        {
            if((*A)->fb==-1)
            {
                balancear_dir(&((*A)));
                *Bal=0;
            }
            else if((*A)->fb==0)
            {
                (*A)->fb=-1;
            }
            else
            {
                (*A)->fb=0;
                *Bal=0;
            }
        }
    }
    return 1;
}

int remove_AVL(Arv *A,reg elem,int * Bal)
{
    if(A==NULL || (*A)==NULL)
    {
        return 0;
    }
    if(elem.chave>(*A)->info.chave)
    {
        return remove_AVL(&((*A)->sad),elem,Bal);
    }
    else if(elem.chave<(*A)->info.chave)
    {
        return remove_AVL(&((*A)->sae),elem,Bal);
    }
    else
    {
        if((*A)->sae==NULL && (*A)->sad==NULL)
        {
            free(*A);
            *A=NULL;
            return 1;
        }
        else if((*A)->sae!=NULL && (*A)->sad==NULL)
        {
            Arv aux=malloc(sizeof(Arv));
            aux=*A;
            *A=(*A)->sae;
            free(aux);
            return 1;
        }
        else if((*A)->sae==NULL && (*A)->sad!=NULL)
        {
            Arv aux=malloc(sizeof(Arv));
            aux=*A;
            *A=(*A)->sae;
            free(aux);
            return 1;
        }
        else
        {
            Arv aux=malloc(sizeof(Arv));
            aux=(*A)->sae;
            while(aux->sad!=NULL)
            {
                aux=aux->sad;
            }
            reg temp=(*A)->info;
            (*A)->info=aux->info;
            aux->info=temp;
            return remove_AVL(&((*A)->sae),elem,Bal);
        }
    }
}

int rot_dir(Arv *pai)
{
    if((*pai)!=NULL && (*pai)->sae!=NULL)
    {
        Arv temp=(*pai)->sae;
        (*pai)->sae=temp->sad;
        temp->sad=(*pai);
        (*pai)->fb=0;
        temp->fb=0;
        *pai=temp;
        return 1;
    }
    return 0;
}

int rot_esq(Arv *pai)
{
    if(*pai!=NULL && (*pai)->sad!=NULL)
    {
        Arv temp=(*pai)->sad;
        (*pai)->sad=temp->sae;
        temp->sae=(*pai);
        (*pai)->fb=0;
        temp->fb=0;
        *pai=temp;
        return 1;
    }
    return 0;
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

int rot_dir_esq(Arv *pai)
{

    if(*pai != NULL && (*pai)->sae != NULL)
    {

        Arv filho_esq = (*pai)->sae;

        Arv neto_dir = filho_esq->sad;

        filho_esq->sad = neto_dir->sae;

        neto_dir->sae = filho_esq;

        (*pai)->sae = neto_dir->sad;
        neto_dir->sad = *pai;

        if(neto_dir->fb == -1)
        {
            (*pai)->fb = 0;
            filho_esq->fb = 1;
        }
        else if(neto_dir->fb == 1)
        {
            (*pai)->fb = -1;
            filho_esq->fb = 0;
        }
        else
        {
            (*pai)->fb = 0;
            filho_esq->fb = 0;
        }
        neto_dir->fb = 0;
        *pai = neto_dir;
        return 1;
    }
    return 0;
}

int rot_esq_dir(Arv *pai)
{

    if(*pai != NULL && (*pai)->sad != NULL)
    {

        Arv filho_dir = (*pai)->sad;

        Arv neto_esq = filho_dir->sae;

        filho_dir->sae = neto_esq->sad;

        neto_esq->sad = filho_dir;

        (*pai)->sad = neto_esq->sae;
        neto_esq->sae = *pai;

        if(neto_esq->fb == -1)
        {
            (*pai)->fb = 1;
            filho_dir->fb = 0;
        }
        else if(neto_esq->fb == 1)
        {
            (*pai)->fb = 0;
            filho_dir->fb = -1;
        }
        else
        {
            (*pai)->fb = 0;
            filho_dir->fb = 0;
        }
        neto_esq->fb = 0;
        *pai = neto_esq;
        return 1;
    }
    return 0;
}

int balancear_esq(Arv *A)
{
    Arv B=(*A)->sae;
    if(B->fb>0)
    {
        return rot_dir(&((*A)));
    }
    else
        return rot_dir_esq(&((*A)));
}

int balancear_dir(Arv *A)
{
    Arv B=(*A)->sad;
    if(B->fb<0)
    {
        return rot_esq(&((*A)));
    }
    else
        return rot_esq_dir(&((*A)));
}

reg *menor_trafego(Arv A)
{
    if(A == NULL) return NULL;
    reg *menor1, *menor2;
    menor1 = NULL;
    menor2 = NULL;

    if(A->sae != NULL) menor1 = menor_trafego(A->sae);
    if(A->sad != NULL) menor2 = menor_trafego(A->sad);
    if(menor1 == NULL && menor2 == NULL) return &(A->info);
    if(menor1 != NULL && menor2 == NULL)
    {
        if((*menor1).chave < A->info.chave) return menor1;
        return &(A->info);
    }
    if(menor1 == NULL && menor2 != NULL)
    {
        if((*menor2).chave < A->info.chave) return menor2;
        return &(A->info);
    }
    if((*menor1).chave < A->info.chave && (*menor1).chave < (*menor2).chave) return menor1;
    if((*menor2).chave < A->info.chave && (*menor2).chave < (*menor1).chave) return menor2;
    return &(A->info);
}

int qtde_ocioso(Arv A)
{
    int pain = 0;
    if(A == NULL) return 0;
    if(A->info.chave < (A->info.capacidade)/2) pain = 1;
    return (qtde_ocioso(A->sad) + qtde_ocioso(A->sae) + pain);
}

int nro_folha(Arv A)
{
    if(A == NULL) return 0;
    if(A->sad == NULL && A->sae == NULL) return 1;
    return (nro_folha(A->sad) + nro_folha(A->sae));
}

int nivel_no(Arv A, reg elem)
{
    Arv *fila;
    Arv aux;
    int i;
    int qt = (pot_2(altura(A) + 1) -1);
    fila = calloc(qt,sizeof(Arv));
    fila[0] = A;
    for(i = 0; (2*i + 2) < qt; i++)
    {
        aux = fila[i];
        if(aux->sae != NULL) fila[2*i + 1] = aux->sae;
        if(aux->sad != NULL) fila[2*i + 2] = aux->sad;
    }
    i = 0;
    while(i < qt)
    {
        if((elem.chave == fila[i]->info.chave) && (elem.id == fila[i]->info.id) && (elem.local == fila[i]->info.local) && (elem.capacidade == fila[i]->info.capacidade))
        {
            free(fila);
            return calc_2(i);
        }
        i++;
    }
    free(fila);
    return -1;
}

int profundidade(Arv A, Arv sub)
{
    Arv *fila;
    Arv aux;
    int i;
    int qt = (pot_2(altura(A) + 1) -1);
    fila = calloc(qt,sizeof(Arv));
    fila[0] = A;
    for(i = 0; (2*i + 2) < qt; i++)
    {
        aux = fila[i];
        if(aux->sae != NULL) fila[2*i + 1] = aux->sae;
        if(aux->sad != NULL) fila[2*i + 2] = aux->sad;
    }
    i = 0;
    while(i < qt)
    {
        if(sub == fila[i])
        {
            free(fila);
            return calc_2(i);
        }
        i++;
    }
    free(fila);
    return 0;
}

int calc_2(int n)
{
    int i = 0;
    while(n != 0)
    {
        n = (n - 1)/2;
        i++;
    }
    return i;
}

int pot_2(int n)
{
    int i, ac = 1;
    for(i = 0; i < n; i++)
    {
        ac *= 2;
    }
    return ac;
}

int nro_no(Arv A)
{
    if(A == NULL) return 0;
    return (nro_no(A->sae) + nro_no(A->sad) + 1);
}

int cheia(Arv A)
{
    if(nro_no(A) == (pot_2(altura(A) + 1) -1)) return 1;
    return 0;
}

int igual(reg elem, reg fila)
{
    if((elem.chave == fila.chave) && (elem.id == fila.id) && (elem.local == fila.local) && (elem.capacidade == fila.capacidade)) return 1;
    return 0;
}

int iguais(Arv A1, Arv A2)
{
    if(A1 == NULL && A2 == NULL) return 1;
    if(igual(A1->info,A2->info) == 0) return 0;
    if(iguais(A1->sae,A2->sae) == 0) return 0;
    if(iguais(A1->sad,A2->sad) == 0) return 0;
    return 1;
}
