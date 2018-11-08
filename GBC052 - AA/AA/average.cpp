#include <stdio.h>
#include <stdlib.h>

int main(){
	int count = 0;
	float x;
	float average = 0;
	
	while((fscanf(stdin, "%f",&x)) != EOF){
		
		average += x;
		count++;
		
	}
	printf ("O total de elementos lidos foi %d\n",count);
	printf ("A media de tempo foi: %f\n", average/count);

	return 0;

}
