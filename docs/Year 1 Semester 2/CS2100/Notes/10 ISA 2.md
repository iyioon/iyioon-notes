# ISA

## Fixed length instruction

Type A: 6 opcode 5 operand 5 operand
Type B: 11 opcode 5 operand

To maximise,eg reserve 111111 for Type A. Then the total combination of Type B is $(2^6-1)\times 2^5$. $2^6-1$ represent the total number of combination of the first  6 bits in Type B as one of the combination is used by Type A.

To minimise eg reserve 111111 for Type B. The the total combination of Type B is $2^5$
