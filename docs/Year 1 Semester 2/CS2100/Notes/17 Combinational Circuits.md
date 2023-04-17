# Combinational Circuits

## Introduction

![17 Combinational Circuits Introduction](../Attachments/17%20Combinational%20Circuits%20Introduction.png)

## Analysis Procedure

Given a combinational circuits, how do you analyze its function?

1. Label the inputs and outputs
2. Obtain the functions of intermediate points and the outputs
3. Draw the truth table
4. Deduce the functionality of the circuit

Visit [PDF](Lect17_Combinational_Circuits_full.pdf#page=5)

## Design Methods

Two different design methods for combinational circuit:

- Gate-level design method (with logic gates)
- Block-level design method (with functional blocks)

Visit [PDF](Lect17_Combinational_Circuits_full.pdf#page=6)

## Gate-level (SSI) Design

[Half Adder](Lect17_Combinational_Circuits_full.pdf#page=7%7CHalf%20Adder)
[Full Adder](Lect17_Combinational_Circuits_full.pdf#page=9%7CFull%20Adder)
[BCD to Excess-3](Lect17_Combinational_Circuits_full.pdf#page=15%7CBCD%20to%20Excess-3)
## Block-Level Design

More complex circuits can also be built using block-level method

[4-bit parallel adder](Lect17_Combinational_Circuits_full.pdf#page=19%7C4-bit%20parallel%20adder)
[BCD to Excess-3](Lect17_Combinational_Circuits_full.pdf#page=24%7CBCD%20to%20Excess-3)

## Summary

Visit [PDF](Lect17_Combinational_Circuits_full.pdf#page=26)

## Magnitude Comparator

Magnitude comparator: compares 2 unsigned values $A$ and $B$, to check if $A>B, A=B$, or $A<B$.

Visit [PDF](Lect17_Combinational_Circuits_full.pdf#page=31)

## Circuit Delays

Given a logic gate with delay $t$. If inputs are stable at times $t_1, t_2, \ldots, t_n$, then the earliest time in which the output will be stable is:
$$
\max \left(t_1, t_2, \ldots, t_n\right)+t
$$

Visit [PDF](Lect17_Combinational_Circuits_full.pdf#page=35)

### Propagation delay 

Visit [PDF](Lect17_Combinational_Circuits_full.pdf#page=37)