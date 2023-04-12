# sample3.asm
       .data 0x10000100
msg:   .asciiz "Hello"
       .text
main:  li $v0, 4
       la $a0, msg
       syscall
       lb $t0 4($a0)   
       addi $t0, $t0, -32 
       sb $t0, 4($a0)   
       syscall
       li $v0, 10
       syscall
