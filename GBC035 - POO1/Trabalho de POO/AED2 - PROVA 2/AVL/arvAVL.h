#ifndef ARVAVL_H_INCLUDED
#define ARVAVL_H_INCLUDED

typedef struct registro
{
    int chave;
    char nome[30];
    char curso[30];
}reg;

struct no
{
    reg info;
    int fb;
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

#endif // ARVAVL_H_INCLUDED
