# Arrays String and Structures

## Arrays

```c
int a[3] = {54,9,10};
```

### Scanning and printing elements

```c
#include <stdio.h>
#define MAX 5

int main(void) {
  int numbers[MAX];
  int i, sum = 0;
  
  printf("Enter %d integers: ", MAX);
  for (i = 0; i < MAX; i++) {
	  scanf("%d", &numbers[i]); // Use the address.
  }
  for (i = 0; i < MAX; i++) {
	  sum += numbers[i];
  }
  printf("Sum = %d\n", sum);
  return 0;
}
```

### Arrays and Pointers

![](Lect5a_Arrays_Strings_and_Structures%201.pdf#page=9)

### Copy array to another

```c
#define N 10
int source[N] = { 10, 20, 30, 40, 50 }; // dest = source will not work
int dest[N];
int i;
for (i = 0; i < N; i++) {
  dest[i] = source[i];
}
```

### Array parameters in Functions

Array passed into a method is a pointer. Changing the array in the method will change the array itself.

Since an array name is a pointer, the following shows the alternative syntax for array parameter in function prototype and function header in the function definition.

```c
int sumArray(int *, int); // fn prototype

// function definition
int sumArray(int *arr, int size) {
   ...
}
```

## Structures

Structures allow grouping of heterogeneous members (of different types)

### Declaring Structure Types

![](Lect5c_Arrays_Strings_and_Structures%203.pdf#page=5)

### initializing Structure Variables

![](Lect5c_Arrays_Strings_and_Structures%203.pdf#page=8)

### Passing Structure to Function

The entire structure is copied, i.e., members of the actual parameter are copied into the corresponding members of the formal parameter. Pass-by-value.

### Passing Address of Structure to Function

![](Lect5d_Arrays_Strings_and_Structures%204.pdf#page=9)

### The Arrow Operator

Expressions like `(*player_ptr).name` appear very often. Hence an alternative “shortcut” syntax is created for it.  The arrow operator (`->`)

```c
// To change a player’s name and age 
void change_name_and_age(player_t *player_ptr) { 
	strcpy(player_ptr->name, "Alexandra"); 
	player_ptr->age = 25; 
}
```

