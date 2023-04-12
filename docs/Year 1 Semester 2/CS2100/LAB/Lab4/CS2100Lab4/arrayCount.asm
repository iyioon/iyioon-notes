# arrayCount.asm
  .data 
arrayA: .word 1, 2, 3, 4, 5, 6, 7, 8   # arrayA has 8 values
count:  .word 0             # dummy value

  .text
main:
    # code to setup the variable mappings

    la $t0, arrayA          # Address of arrayA stored on $t0
    la  $t8, count          # Address of count stored on $t8

    # code for reading in the user value X

    li   $v0, 5             # system call code for read_int
    syscall                 # read_int
    add  $t1, $zero, $v0    # Store input in $t1
    addi $t5, $t1, -1       # Store the mask in $t5

    # code for looping the array
    addi $s0, $zero, 0      # n
    addi $s1, $zero, 0      # i
    addi $s2, $zero, 8      # End point

loop: 
   bge $s1, $s2, end    
   sll $s3, $s1, 2          # $s3 = i * 4
   add $s4, $t0, $s3        # $s4 <- &arrayA[i]
   lw  $s5, 0($s4)          # $s5 <- arrayA[i]
   and $s6, $s5, $t5        # $s6 = arrayA[i] % mask
   bne $s6, $zero, skip
   addi $s0, $s0, 1         # n++
skip:
   addi $s1, $s1, 1         # i++
   j loop

    # code for printing result
end:
    li   $v0, 1             # system call code for print_int
    add  $a0, $zero, $s0    # integer to print
    syscall                 # print the integer

    # code for sotring result
    sw  $s0, 0($t8)         

    # code for terminating program
    li  $v0, 10
    syscall
