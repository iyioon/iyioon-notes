# Number Systems

## Repeated division & Repeated Multiply to convert decimal into binary

Repeated Multiply is for binary. Multiply the decimal points by 2.

If the binary fraction have to be only n bits, do the multiply by only n+1 for rounding.
eg 2.1 in binary:
$0.1 \times 2=0.2$
$0.2 \times 2=0.4$
$0.4 \times 2=0.8$
$0.8 \times 2=1.6$
Therefore: 0010.001

## Overflow in 1s Complement

Add the Overflow to then LSB

## Converting binary with fraction into 2s Complement

Add 1 to the end eg: 0010.100 into 2s complement is 1101.100


# MIPS

## Register in MIPS


![[Key Notes Register in Mips.png]]

### BEQ & Jump

BEQ is PC relative: Count from PC+4. given in number of instructions

Jump: Absolute. Get the target address. Throw away last 2 bits and left 4 bits. Which give 26 remaining bits.

# ISA

## Fixed length instruction

Type A: 6 opcode 5 operand 5 operand
Type B: 11 opcode 5 operand

To maximise,eg reserve 111111 for Type A. Then the total combination of Type B is $(2^6-1)\times 2^5$. $2^6-1$ represent the total number of combination of the first  6 bits in Type B as one of the combination is used by Type A.

To minimise eg reserve 111111 for Type B. The the total combination of Type B is $2^5$


## Size of the register and address

Eg if a machine have 6 registers, the size of each register is 3 bits because 2^3 is the minimum to represent all registers.

If a machine have 64 addresses, the size of address have to be log2(62)=6 to represent all addresses.

## Consensus Theorem

$$X . Y+X^{\prime} Z+Y . Z=X \cdot Y+X^{\prime} Z$$
## Circuit implementation calculating minterms

![[minterms.png]]

Don't try out everything. Here B must be 1 for F to be 1. Start there