#ifndef ARVABB_H_INCLUDED
#define ARVABB_H_INCLUDED

typedef struct registro
{
	int idade;
	char nome[30];
	char curso[30];
}reg;

struct no
{
	reg info;
	struct no *sae;
	struct no *sad;
};

typedef struct no *Arv;

Arv busca_bin(Arv A, int chave);

int remove_ord(Arv *A, int chave);

int insere_ord(Arv *A, reg elem);

void exibe_ordenado(Arv A);

void exibe_arvore(Arv A);

void libera_arvore(Arv *A);

Arv cria_arvore();

reg *maior(Arv A);

int de_maior(Arv A);

int qtde_nos(Arv A, int ini, int fim);

int um_filho(Arv A);

int completa(Arv A);

int altura_arv(Arv A);

Arv juntar(Arv A, Arv B);

//int pot_2(int n);

//int calc_2(int n);

//int profundidade(Arv A, Arv sub);

#endif // ARVABB_H_INCLUDED
