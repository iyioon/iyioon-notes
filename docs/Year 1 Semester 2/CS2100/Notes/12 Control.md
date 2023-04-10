# Control

<span class="center-menu">[[Lect12_Control.pdf\|Lecture PDF]]</span>
## ALU Control

![[12 Control ALUControl.png]]

For `subtract`, the adder performs `A+B'+1`. The 1 is from `Cin`, hence turning $B$ into two's complement.

For `NOR`, the `AND` gate performs $A'\cap b'$ which is equivalent to $(A+B)'$ (De morgan's law)

`slt` will not be discussed. (may come out in assessment)

[[Lect12_Control.pdf#page=19]]

## Design of ALU control unit: Multilevel Decoding

[[Lect12_Control.pdf#page=22]]



