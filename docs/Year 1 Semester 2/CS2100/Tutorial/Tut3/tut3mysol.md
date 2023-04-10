## Question 1

### a. Translate the C code into MIPS code by keeping track of the indices.

```C
char string[size] = { ... }; // some string 
int low, high, matched;

// Translate to MIPS from this point onwards
low = 0;  
high = size-1;  
matched = 1; // assume this is a palindrome
             // In C, 1 means true and 0 means false
while ((low < high) && matched) {
	if (string[low] != string[high])
	  matched = 0; // found a mismatch 
	else {
		low++;
		high--; 
	}
}
// Variable mappings
//low -> $s0;
//high -> $s1;
//matched -> $s3;  
//base address of string[] -> $s4; 
//size -> $s5; 
```

```
			addi $s0, $zero, 0    # low=0
			addi $s1, $s5, -1     # high = size-1
			addi $s3, $zero, 1    # matched =1
loop: slt  $t0, $s0, $s1    # (low < high)?
			beq  $t0, $zero, exit # exit if (low >= high) 
			beq  $s3, $zero, exit # exit if (matched == 0)
			add  $t1, $s4, $s0    # address of string[low]
			lb   $t2, 0($t1)      # t2 = string[low]
			add  $t3, $s4, $s1    # address of string[high]
			lb   $t4, 0($t3)      # t4 = string[high]
			beq  $t2, $t4, else
			addi $s3, $zero, 0    # matched = 0
			j loop
else: addi $s0, $s0, 1      # low++
			addi $s1, $s1, -1     # high—
			j loop
exit:
```

### b.  Translate the C code into MIPS code by using the idea of “array pointer”. Basically, we keep track of the actual addresses of the elements to be accessed, rather than the indices. Refer to lecture set #8, slide 34 for an example.

```
			addi $s0, $zero, 0    # low=0
			addi $s1, $s5, -1     # high = size-1
			addi $s3, $zero, 1    # matched =1 
			add  $t1, $s4, $s0    # address of string[low]
			add  $t3, $s4, $s1    # address of string[high]
loop: slt  $t0, $t1, $t3    # compare low and high addr
			beq  $t0, $zero, exit # exit if (low >= high) 
			beq  $s3, $zero, exit # exit if (matched == 0)
			lb   $t2, 0($t1)      # t2 = string[low]
			lb   $t4, 0($t3)      # t4 = string[high]
			beq  $t2, $t4, else
			addi $s3, $zero, 0    # matched = 0
			j loop
else: addi $t1, $t1, 1      # low address increases
			addi $t3, $t3, -1     # high address decreases
			j loop
exit:
```

## Question 2

### a. You accidentally spilled coffee on your best friend’s MIPS assembly code printout. Fortunately, there are enough hints for you to reconstruct the code. Fill in the missing lines (shaded cells) below to save your friendship.

0x20110000
beq $t0 $zero exit 
addi $s1 $s1 1
0x0810000B

### b. Give a simple mathematic expression for the relationship between $s1 and $t0 as calculated in the code.

$\$s1=\log_{2}{\$t0}$

## Question 3

### a. 

```
[srl $s4, $s4, 1 ]
[lw $t1, 0($t0) ]
[slt $t9, $t1, $s1]
[beq $t9, $zero, equal]
[j end ]
[j loop] 0x0810000A
```

### b.
Immediate value = 16

### c.

```
"loopEnd" is the 18th instruction.  
So, offset from start = 17 instructions × 4 = 6810 = 4416 Address of loopEnd = 0xFFFFFFFF44  
j loopEnd = 000010 1111........ 1101 0001 = 0x0B FF FF D1
```

### d.
No. Jump specifies the target “directly”. So, two jumps to the same target will give the same encoding.