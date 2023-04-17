# Control

<span class="center-menu">[Lecture PDF](Lect12_Control.pdf%5C)</span>
## ALU Control

![12 Control ALUControl](../Attachments/12%20Control%20ALUControl.png)

For `subtract`, the adder performs `A+B'+1`. The 1 is from `Cin`, hence turning $B$ into two's complement.

For `NOR`, the `AND` gate performs $A'\cap b'$ which is equivalent to $(A+B)'$ (De morgan's law)

`slt` will not be discussed. (may come out in assessment)

[PDF](Lect12_Control.pdf#page=19)

## Design of ALU control unit: Multilevel Decoding

[PDF](Lect12_Control.pdf#page=22)



