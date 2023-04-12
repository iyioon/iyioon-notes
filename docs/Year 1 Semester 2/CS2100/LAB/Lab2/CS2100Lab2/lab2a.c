#include <stdio.h>

void display(int);

int main() {
	int ageArray[] = { 2, 15, 4 , 1};
	display(ageArray[0]);
  int size = sizeof(ageArray)/4;
  printf("Size of the array is %d\n",size);
	return 0;
}

void display(int age) {
	printf("%d\n", age);
}
