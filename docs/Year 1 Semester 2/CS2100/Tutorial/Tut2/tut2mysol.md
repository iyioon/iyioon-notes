## 2 Swapping

We have discussed in lecture how to swap two variables in a function:

```c
void swap(int *a, int *b) {
   int t = *a;
	*a = *b;
	*b = t; 
}
```

In the above code, a temporary variable t is used.  

A possible alternative is to use some bitwise operator to perform the swap, without using any temporary variable. Write a function to do this.

Using XOR

```c
void swap(int *a, int *b) {
    *a = *a ^ *b; // XOR
    *b = *a ^ *b;
    *a = *a ^ *b;
}
```

Using Addition

```c
void swap(int *a, int *b) {
    *a = *a + *b; // a = a+b
    *b = *a - *b; // b = a+b-b = a
    *a = *a - *b; // a = a+b-a = b
}
```

## MIPS Bitwise Operations

Implement the following in MIPS assembly. Assume that integer variables a, b and c are mapped to registers $s0, $s1 and $s2 respectively. Each part is independent of all the other parts. For bitwise instructions (e.g. ori, andi, etc), any immediate values you use should be written in binary for this question. This is optional for non-bitwise instructions (e.g. addi, etc).

Note that bit 31 is the most significant bit (MSB) on the left, and bit 0 is the least significant bit (LSB) on the right, i..e.:

| MSB |  |  |  |  | LSB |
| :---: | :---: | :---: | :---: | :---: | :---: |
| Bit 31 | Bit 30 | Bit 29 | $\dots$ | Bit 1 | Bit 0 |

**a. Set bits 2, 8, 9, 14 and 16 of b to 1. Leave all other bits unchanged.**

To set bits, we create a “mask” with 1’s in the bit positions we want to set. Since bit 16 is in the upper 16 bits of the register, we need to use lui to set it.
    
```
lui $t0, 1 # Sets bit 16 of $t0.  
ori $t0, $t0, 0b0100001100000100 # Set bits 14, 9, 8 and 2. 
or $s1, $s1, $t0
```

**b. Copy over bits 1, 3 and 7 of b into a, without changing any other bits of a.**

```
# We use the property that x AND 1 = x to copy out the values of
# bits 7, 3 and 1 of b into $t0. Note that we zero all other bits  
# so that they don’t change anything in $s0 when we OR later on. 
andi $t0, $s1, 0b0000000010001010

# We use the property of x OR 0 = x to copy in  
# the bits into a, so we prepare a by zero-ing bits 7, 3 and 1.  
# To do this we need the mask 1111111111111111 1111111101110101 
lui $t1, 0b1111111111111111  
ori $t1, $t1, 0b1111111101110101  
and $s0, $s0, $t1
    
# Now OR together a and $t0 to copy over the bits 
or $s0, $s0, $t0
```

**c. Make bits 2, 4 and 8 of c the inverse of bits 1, 3 and 7 of b (i.e. if bit 1 of b is 0, then bit 2 of c should be 1; if bit 1 of b is 1, then bit 2 of c should be 0), without changing any other bits of c.**

```
# We use the property that x XOR 1 = ~x to flip 
# the values of bits 7, 3 and 1.  
xori $t0, $s1, 0b10001010

# Zero every bit except 7, 3 and 1. 
andi $t0, $t0, 0b10001010

# Shift left one position: bit 1 becomes 0, 
# bit 1 becomes bit 2, bit 3 becomes bit 4, and bit 7 becomes bit 8.  
sll $t0, $t0, 1

# Now, to clear bits 8, 4 and 2 of c,  
# we need the mask 0b1111111111111111 1111111011101010 
lui $t1, 0b1111111111111111  
ori $t1, $t1, 0b1111111011101011  
and $s2, $s2, $t1

# and we OR the new c with $t0 
or $s2, $s2, $t0
```

## 4 MIPS Arithmetic

Write the following in MIPS Assembly, using as few instructions as possible. You may rewrite the equations if necessary to minimize instructions.

In all parts you can assume that integer variables a, b, c and d are mapped to registers $s0, $s1, $s2 and $s3 respectively. Each part is independent of the others.

**c = a + b**

```
add $s2, $s1, $s2
```

**d = a + b – c**

```
add $s3, $s0, $s1 # d = a + b
sub $s3, $s3, $s2 # d = d - c
```

**c = 2b + (a – 2)**

```
sll $s2, $s1, 1 # shift left 1 bit. c = 2b
add $s2, $s2, $s1 # c = 2b + a
addi $s2, $s2, -2 # c = 2b + a - 2
```

**d = 6a + 3(b - 2c)**

Rewrite:
$$
d=6 a+3 b-6 c
$$
Factorize out 3
$$
\begin{aligned}
& d=3(2 a+b-2 c) \\
& =3(2 a-2 c+b) \\
& =3(2(a-c)+b)
\end{aligned}
$$

```
sub $t0, $s0, $s2 # t0 = a – c
sll $t0, $t0, 1   # t0 = 2(a – c)
add $t0, $t0, $s1 # t0 = 2(a – c) + b
sll $t1, $t0, 2   # t1 = 4(2(a – c) + b)
sub $s3, $t1, $t0 # d = 3(2(a – c) + b)
```