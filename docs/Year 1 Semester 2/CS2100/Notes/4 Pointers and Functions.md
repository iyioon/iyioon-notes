# Pointers and Functions

## Pointers 

Note from: [[Lect4a_Pointers_and_Functions 1.pdf]]
### Referring to the address

```c
int a = 123;
printf("a= %d\n", a); //a = 123
printf("&a = %p\n", &a); //&a = ffbff7dc
```

### Declaring Pointer variable

Syntax: `type *pointer_name;`

```c
int *a_ptr;
```

### Assigning Value to a Pointer

Example: Assigning address `a` to `a_ptr`

```c
int a = 123;
int *a_ptr; // declaring an int pointer
a_ptr = &a;
```

### Accessing Variable Through Pointer

```c
printf("a = %d\n", *a_ptr); // Is equiv to printf("a = %d\n", a);
```

### Incrementing a Pointer

![[Lect4b_Pointers_and_Functions 2.pdf#page=5]]

## Functions 

### How to use math functions

To use math functions, you need to

- Include `<math.h>` AND
- Compile your program with `-lm` option (i.e. `gcc -lm ...`)

| Function  | Arguments        | Result |
|:--------- |:---------------- |:------ |
| abs (x)   | int              | int    |
| ceil(x)   | double           | double |
| cos(x)    | double (radians) | double |
| exp(x)    | double           | double |
| fabs (x)  | double           | double |
| floor(x)  | double           | double |
| log(x)    | double           | double |
| log 10(x) | double           | double |
| ceil(x)   | double           | double |
| pow(x,y)  | double, double   | double |
| sin(x)    | double (radians) | double |
| sqr(x)    | double           | double |
| tan(x)    | double (radians) | double |

### User-Defined Functions

![[Lect4c_Pointers_and_Functions 3.pdf#page=9]]

## Passing Structure to Function

![[Lect4d_Pointers_and_Functions 4.pdf#page=3]]

## Strings

- We can turn an array of characters into a string by adding a null character `\0` at the end of the array
- A string is an array of characters, terminated by a null character `\0` (which has an ASCII value of zero)
- We can use string functions (include `<string.h>`) to manipulate strings.

### Basic

Declaration of an array of characters

- `char str[6]`;

Assigning character to an element of an array of characters

- `str[0] = 'e';`
- `str[1] = 'g';`
- `str[2] = 'g';`
- `str[3] = '\0';`

Initializer for string

- `char fruit_name[] = "apple"; // double quote produces a string followed by a null terminator (ie \0)`
- `char fruit_name[] = {'a','p','p','l','e','\0'};`

### Read Strings from stdin

#### Read

```c
fgets(str, size, stdin) // reads size – 1 char,
                        // or until newline
                        // This stores \n also in the array 
                        // Remove by changing len-1 to \0
scanf("%s", str);  // reads until white space
```

#### Print

```c
puts(str);  // terminates with newline
printf("%s\n", str);
```

### String Functions

![[Lect5b_Arrays_Strings_and_Structures 2.pdf#page=11]]