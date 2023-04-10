# Sequential Logic

## Introduction

![[Pasted image 20230320190046.png|300]]

**Two types of sequential circuits:**

- Synchronous: outputs change only at specific time
- Asynchronous: outputs change at any time

**Multivibrator: a class of sequential circuits**

- Bistable (2 stable states)
- Monostable or one-shot ( 1 stable state)
- Astable (no stable state)

**Bistable logic devices**

- Latches and flip-flops.
- They differ in the methods used for changing their state.

We will only be looking at **Bistable logic devices**

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=5\|PDF]]

## Memory Elements

**Memory element:** a device which can remember value indefinitely, or change value on command from its inputs.

$Q(t)$ is the current value that the memory element remembers.
$Q(t+1)$ is the next state of the memory element.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=6\|PDF]]

**Memory element with clock**

The command is only effective at a particular time. Usually it is at the rising edge (**Positive edges**) or the falling edge (**Negative edge**)

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=7\|PDF]]

**Two types of triggering activation**

- If the value is taken in the positive/negative edges, it is called **Edge-triggered**
- If the value is taken at a particular level such as the high level, it is called **Pulse triggered**

> High level is the upper horizontal sections on the pdf.

The Edge-triggered memory elements are called **Flip-flops**.

The Pulsed triggered memory elements are called **Latches** and it is active when the clock is in the `On` stage.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=8\|PDF]]

## S-R Latch 

![[19 Sequential Logic S-R Latch.png|200]] ![[19 Sequential Logic S-R Latch Block.png|200]]

Pulse triggered. It has two inputs **S** (set) and **R** (reset).

There are two complementary outputs **Q** and **Q'**.

- When $Q$ = High we say latch is in **SET** state. Achieved by $R = Low$ and $S=High$
- When $Q$ = Low, we say latch is in **RESET** state Achieved by $R = High$ and $S=Low$

When both $R$ and $S$ are LOW, there is no change in output $Q$.
When both $R$ and $S$ are HIGH, it is a invalid case and must be avoided (Drawback).

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=9\|PDF]]
Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=10\|Diagram]]
Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=11\|Characteristic table]]

Optional [[Lect19_Sequential_Logic_Part-1.pdf#page=12\|Active Low]]

## Gated S-R Latach

This is a standard [[#S-R Latch]] with enable input (EN) and 2 NAND gates

![[19 Sequential Logic Gated S-R Latch.png]]

Outputs change only when EN is high.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=13\|PDF]]

## Gated D Latch

Replace $R$ with $S'$. $D$ latch eliminates the undesirable condition of invalid state  in S-R latch.

![[19 Sequential Logic Gated D Latch.png]]

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=15\|Characteristic Table]]

## Flip-flops

Edge triggered.

- Flip-flops are synchronous bistable devices.
- Output changes state at a specified point on a triggering input called the clock.
- Change state either at the positive (rising) edge, or at the negative (falling) edge of the clock signal.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=16\|PDF]]

![[19 Sequential Logic Flip flops.png]]

The $>$ notation implies a **edge triggered** device.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=18\|PDF]]

## D Flip-flop

Same as D-Latch Except that we follow the rising edge of the clock rather than the enable. 

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=19\|PDF]]

Application: [[Lect19_Sequential_Logic_Part-1.pdf#page=20\|Parallel data transfer]]. In this example, when we want to copy over $x,y,z$ to the flip flop, we pulse the clock. Then on the falling edge of the clock signal, $Q1=X$... As long as pulse is not sent to the circuit, this value in the flip flop remains the same. 

Flip flops themselves produce power, meaning they can extend the range of the power of the combinational circuit.

Your registers are made of these flip flops. 

## J-K Flip-flop

Does not have a invalid state. Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=21|PDF]]

- $J=\mathrm{HIGH}$ and $K=\mathrm{LOW} \Rightarrow Q$ becomes HIGH (SET state) // J is equiv to S, K is equiv to R
- $K=\mathrm{HIGH}$ and $J=$ LOW $\Rightarrow Q$ becomes LOW (RESET state)
- Both $J$ and $K$ are LOW $\Rightarrow$ No change in output $Q$
- Both $J$ and $K$ are HIGH $\Rightarrow$ Toggle, meaning it will go to high when low, and low when high.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=22|Circuit & Table]]

## T Flip-flop

Single input version of the $J-K$ flip-flop, formed by tying both inputs together.

Visit [[Lect19_Sequential_Logic_Part-1.pdf#page=23|Circuit & Table]]

## Asynchronous Inputs

Flips flop can have a asynchronous input:  [[Lect19_Sequential_Logic_Part-1.pdf#page=24|PDF]]

Asynchronous inputs affect the state of the flip-flop independent of the clock. See  [[Lect19_Sequential_Logic_Part-1.pdf#page=25|J-K flip-flop with active-low PRESET and CLEAR asynchronous inputs]]. This allows to changing state regardless of the clock cycle.

## Sequential Circuits: Analysis

Given a sequential circuit diagram, we can analyze its behaviour by deriving its state table and hence its state diagram. We use $\boldsymbol{A}(t)$ and $\boldsymbol{A}(\boldsymbol{t + 1})$ (or simply $A$ and $A^{+}$) to represent the present state and next state, respectively, of a flip-flop represented by $A$. [[Lect19_Sequential_Logic_Part-2.pdf#page=4\|PDF]]

Example: 

1. Derive the [[Lect19_Sequential_Logic_Part-2.pdf#page=5\|State equation]]
	1. E.g. Calculate the equation for D (one in the A side, can be marked DA)
	2. Since $A^+$ (next state) = DA, the equation for $A^{+}=A \cdot x+B \cdot x$
2. Create a [[Lect19_Sequential_Logic_Part-2.pdf#page=7\|State table]]
	1. Tip : find the condition for $A^+$ is 1 and fill in the next state.
3. Draw the [[Lect19_Sequential_Logic_Part-2.pdf#page=10\|State diagram]]
	1. note input/output format

[[Lect19_Sequential_Logic_Part-2.pdf#page=3\|See characteristic table]]
## Flip-flop input functions

Visit [[Lect19_Sequential_Logic_Part-2.pdf#page=12\|PDF]]

[[Lect19_Sequential_Logic_Part-2.pdf#page=14\|Example 2]] two J-K flip-flops with no output. In the state table note that next state is derived after filling in flip flop inputs. Eg. JA KA are 0 and 0 which is a no change. Hence $A^+$ is 0

[[Lect19_Sequential_Logic_Part-2.pdf#page=17\|Example 3]] two J-K flip-flops with output.



## Flip flop Excitation Table

Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=2\|PDF]]

[[Lect19_Sequential_Logic_Part-3.pdf#page=3\|Excitation tables]]: given the required transition from present state to next state, determine the flip-flop input(s).

## Designing a Sequential Circuits

Goal: Build a state machine. Our computer is a state machine.

**Design procedure:**

- Start with circuit specifications - description of circuit behaviour, usually a state diagram or state table.
- Derive the state table.
- Perform state reduction if necessary.
- Perform state assignment.
- Determine number of flip-flops and label them.
- Choose the type of flip-flop to be used.
- Derive circuit excitation and output tables from the state table.
- Derive circuit output functions and flip-flop input functions.
- Draw the logic diagram.

[[Lect19_Sequential_Logic_Part-3.pdf#page=5\|Example]]
Please remember the clocking input

[[Lect19_Sequential_Logic_Part-3.pdf#page=10\|Example 2]]

[[Lect19_Sequential_Logic_Part-3.pdf#page=13\|Example 3 with unused states]]. Be careful as it can be trapped in a loop of invalid state. This can be avoided by checking if the state is self correcting. Visit Recitation 10. Method: draw the state table of the unused states. Check if they go to a used (valid) or unused state (invalid) eventually.

## Memory

Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=17\|PDF]]

Different from memory element. This is the memory chips that are used to store programs and data.

Memory should have these properties: Fast access, large capacity, economical cost, non-volatile. However, most memory devices can not possess all these properties. Hence we organize these memories into [[Lect19_Sequential_Logic_Part-3.pdf#page=18\|Memory hierarchy]].

### Data transfer between memory and CPU

Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=19\|PDF]], [[Lect19_Sequential_Logic_Part-3.pdf#page=21\|Block Diagram]]

Recall that the memory is divided into pigeon holes and each pigeon holes has a index number called a address. If there are $k$ addressing bits, there will be $2^k$ addressable locations.

The addresses are travelled over wires called address bus. For $k$ addressable locations, the address bus must have $k$ wires to carry $k$ bits of address.

In the processor, there is a register called **Memory Address Register** that generates the addresses to be sent to memory to write or load data. 

The data to be stored on the pigeon hole is stored in the **Memory Data Register**. The data is transferred through the data bus which has width equal to 1 word in most cases. Hence in 32 machine the data bus is usually 32 bits wide.

The **control lines** Read and Write specifies the direction of the transfer of the data.

---

### Read/Write Operations

Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=22\|PDF]]

## Memory Cell

There are two types of RAM

- Static RAMs use flip-flops as the memory cells
- Dynamic RAM use capacitor charges to represent data. The simpler in circuitry, the have to be constantly refreshed.

We will look at Static RAM for this course. Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=23\|PDF]]

## Memory Arrays

Logic construction of a $4 \times 3$ RAM (with decoder and OR gates): Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=24\|PDF]]

An array of RAM chips can be combined to form larger memory: Visit [[Lect19_Sequential_Logic_Part-3.pdf#page=25\|PDF]]


