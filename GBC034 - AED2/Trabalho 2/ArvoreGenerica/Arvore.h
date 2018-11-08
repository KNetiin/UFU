#ifndef ARVORE_H_INCLUDED
#define ARVORE_H_INCLUDED

typedef struct no *Arv;

Arv cria_arvore(int elem);

int insere(Arv A, Arv sa);

void exibe_arvore(Arv A);

int busca(Arv A, int elem);

void libera_arvore(Arv *A);

int altura_arvore(Arv A);

int pre_order(Arv A);

int pos_order(Arv A);

int percorre_nivel(Arv A);

int nro_derivacao(Arv A);

int grau_arv(Arv A);

int grau_no(Arv A);

int qtde_nos(Arv A, int grau);

int altura_no(Arv A, int elem);

#endif // ARVORE_H_INCLUDED
