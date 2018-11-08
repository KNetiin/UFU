#include <stdio.h>
#include <stdlib.h>
#include "arvABB.h"

int main()
{
	printf("Hello world!\n");

	Arv A;

	A = cria_arvore();

	Arv B;

	B = cria_arvore();

	reg um, dois, tres, quatro, cinco, seis, sete;

	um.idade = 19;
	//    um.curso = "comp1";
	//  um.nome = "yep1";
	dois.idade = 18;
	//  dois.curso = "comp2";
	//  dois.nome = "yep2";
	tres.idade = 23;
	//  tres.curso = "comp3";
	//  tres.nome = "yep3";
	quatro.idade = 18;
	//  quatro.curso = "comp4";
	//  quatro.nome = "yep4";
	cinco.idade = 32;
	seis.idade = 12;
	sete.idade = 17;


	insere_ord(&A, quatro);
	insere_ord(&A, um);
	insere_ord(&A, dois);
	insere_ord(&A, tres);
	insere_ord(&A, um);
	insere_ord(&A, cinco);
	insere_ord(&A, seis);
	insere_ord(&A, sete);

	insere_ord(&B, tres);
	insere_ord(&B, cinco);
	insere_ord(&B, sete);
	insere_ord(&B, dois);
	insere_ord(&B, seis);


	printf("\n\n");
	exibe_arvore(A);
	printf("\n\n");
	exibe_ordenado(A);



	printf("\n\n");
	exibe_arvore(A);
	printf("\n\n");
	exibe_ordenado(A);


	reg *ajuda = maior(A);
	printf("\n%d eh a maior idade!\n", ajuda->idade);

	printf("\n%d eh o numero de maiores de idade!\n", de_maior(A));

	printf("\nQuantidade de nos com a idade entre 15 e 23: ");
	printf("%d\n", qtde_nos(A, 15, 23));

	printf("\nQuantidade de nos com apenas um filho: %d\n", um_filho(A));

	printf("\nA altura da arvore eh: %d\n", altura_arv(A));
	//printf("\nA profundidade da arvore eh: %d\n", profundidade(A));

	printf("\nA profundidade deste no eh: %d\n", profundidade(A, A->sad->sad));
	printf("\n\n");
	exibe_arvore(B);
	printf("\n\n");

	A = juntar(A, B);

	printf("\n\n");
	exibe_ordenado(A);


	libera_arvore(&A);
	system("pause");
	return 0;
}
