#ifndef AVL_H_INCLUDED
#define AVL_H_INCLUDED

struct registro
{
    int chave;
    int id;
    int capacidade;
    int local;
};

typedef struct registro reg;

struct no
{
    reg info;
    struct no *sae;
    struct no *sad;
    int fb;
};

typedef struct no *Arv;

Arv cria_vazia();

int arvore_vazia(Arv *A);

int insere_ord(Arv *A, reg elem);

void libera_arvore(Arv *A);

void exibe_arvore(Arv A);

void exibe_ordenado(Arv A);

Arv busca_bin(Arv A, int chave);

int busca(Arv *A,reg elem);

int remove_ord(Arv *A, int chave);

int insere_AVL(Arv *A,reg elem,int *Bal);

int remove_AVL(Arv *A,reg elem,int * Bal);

int rot_dir(Arv *pai);

int rot_esq(Arv *pai);

int rot_dir_esq(Arv *pai);

int rot_esq_dir(Arv *pai);

int altura(Arv A);

int balancear_esq(Arv *A);

int balancear_dir(Arv *A);

reg *menor_trafego(Arv A);

int qtde_ocioso(Arv A);

int nro_folha(Arv A);

int nivel_no(Arv A, reg elem);

int profundidade(Arv A, Arv sub);

int calc_2(int n);

int pot_2(int n);

int cheia(Arv A);

#endif // AVL_H_INCLUDED
