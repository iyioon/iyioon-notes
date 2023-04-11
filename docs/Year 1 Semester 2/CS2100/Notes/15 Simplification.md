# 15_Simplification

## Half Adder

**Half adder** is a circuit that adds 2 single bits (X,Y) to produce a result of 2 bits (C,S)

Visit [](Lect15_Simplification_full.pdf#page=8)

## Gray Code

- Only a single bit change from one value to the next

### Generating a Gray code sequence:

Start with:
$$\begin{align}
0000 \\
0001 \\
\end{align}
$$

Make a mirror image:

$$\begin{align}
0000 \\
0001 \\
0001 \\
0000
\end{align}
$$

Change the second image to the right

$$\begin{align}
0000 \\
0001 \\
0011 \\
0010
\end{align}
$$

Make a mirror image again and change the third bit to the right. Repeat.

Visit [](Lect15_Simplification_full.pdf#page=10)

## Karnaugh-map (K-map)


**Karnaugh-map (K-map)** is an abstract form of Venn diagram, organised as a matrix of squares, where

- Each square represents a minterm
- Two adjacent squares represent minterms that differ by exactly one literal

Visit [](Lect15_Simplification_full.pdf#page=14)


## How to use K-maps 

Visit [](Lect15_Simplification_full.pdf#page=27)


## Pls and EPIs

Visit [](Lect15_Simplification_full.pdf#page=34)

max size = 4


## Finding simplified SOP Expression

Visit [](Lect15_Simplification_full.pdf#page=39)

## Finding simplified POS Expression

Visit [](Lect15_Simplification_full.pdf#page=44)

Start with F' (complement)
Apply the K-map technique
Complement the boolean expression obtained

## Don't-Care Conditions


Visit [](Lect15_Simplification_full.pdf#page=46)