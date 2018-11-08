#ifndef ARVGEN_H_INCLUDED
#define ARVGEN_H_INCLUDED

struct no
{
    int info;
    struct no *sae;
    struct no *sad;
};

typedef struct no *Arv;

Arv cria_arvore(int elem);
int insere(Arv A, Arv sa);
int arvore_vazia(Arv A);
void libera_arvore(Arv *A);
int busca(Arv A, int elem);
int remove_folha(Arv* A, int elem);
void exibe_arvore(Arv A);

#endif // ARVGEN_H_INCLUDED
