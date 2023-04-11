# 19_Sequential Logic

## Introduction

![300](../Attachments/Pasted%20image%2020230320190046.png)

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

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=5%5C%7CPDF)

## Memory Elements

**Memory element:** a device which can remember value indefinitely, or change value on command from its inputs.

$Q(t)$ is the current value that the memory element remembers.
$Q(t+1)$ is the next state of the memory element.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=6%5C%7CPDF)

**Memory element with clock**

The command is only effective at a particular time. Usually it is at the rising edge (**Positive edges**) or the falling edge (**Negative edge**)

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=7%5C%7CPDF)

**Two types of triggering activation**

- If the value is taken in the positive/negative edges, it is called **Edge-triggered**
- If the value is taken at a particular level such as the high level, it is called **Pulse triggered**

> High level is the upper horizontal sections on the pdf.

The Edge-triggered memory elements are called **Flip-flops**.

The Pulsed triggered memory elements are called **Latches** and it is active when the clock is in the `On` stage.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=8%5C%7CPDF)

## S-R Latch 

![200](../Attachments/19%20Sequential%20Logic%20S-R%20Latch.png) ![200](../Attachments/19%20Sequential%20Logic%20S-R%20Latch%20Block.png)

Pulse triggered. It has two inputs **S** (set) and **R** (reset).

There are two complementary outputs **Q** and **Q'**.

- When $Q$ = High we say latch is in **SET** state. Achieved by $R = Low$ and $S=High$
- When $Q$ = Low, we say latch is in **RESET** state Achieved by $R = High$ and $S=Low$

When both $R$ and $S$ are LOW, there is no change in output $Q$.
When both $R$ and $S$ are HIGH, it is a invalid case and must be avoided (Drawback).

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=9%5C%7CPDF)
Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=10%5C%7CDiagram)
Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=11%5C%7CCharacteristic%20table)

Optional [](Lect19_Sequential_Logic_Part-1.pdf#page=12%5C%7CActive%20Low)

## Gated S-R Latach

This is a standard [S-R Latch](#S-R%20Latch) with enable input (EN) and 2 NAND gates

![19 Sequential Logic Gated S-R Latch](../Attachments/19%20Sequential%20Logic%20Gated%20S-R%20Latch.png)

Outputs change only when EN is high.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=13%5C%7CPDF)

## Gated D Latch

Replace $R$ with $S'$. $D$ latch eliminates the undesirable condition of invalid state  in S-R latch.

![19 Sequential Logic Gated D Latch](../Attachments/19%20Sequential%20Logic%20Gated%20D%20Latch.png)

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=15%5C%7CCharacteristic%20Table)

## Flip-flops

Edge triggered.

- Flip-flops are synchronous bistable devices.
- Output changes state at a specified point on a triggering input called the clock.
- Change state either at the positive (rising) edge, or at the negative (falling) edge of the clock signal.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=16%5C%7CPDF)

![19 Sequential Logic Flip flops](../Attachments/19%20Sequential%20Logic%20Flip%20flops.png)

The $>$ notation implies a **edge triggered** device.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=18%5C%7CPDF)

## D Flip-flop

Same as D-Latch Except that we follow the rising edge of the clock rather than the enable. 

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=19%5C%7CPDF)

Application: [](Lect19_Sequential_Logic_Part-1.pdf#page=20%5C%7CParallel%20data%20transfer). In this example, when we want to copy over $x,y,z$ to the flip flop, we pulse the clock. Then on the falling edge of the clock signal, $Q1=X$... As long as pulse is not sent to the circuit, this value in the flip flop remains the same. 

Flip flops themselves produce power, meaning they can extend the range of the power of the combinational circuit.

Your registers are made of these flip flops. 

## J-K Flip-flop

Does not have a invalid state. Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=21%7CPDF)

- $J=\mathrm{HIGH}$ and $K=\mathrm{LOW} \Rightarrow Q$ becomes HIGH (SET state) // J is equiv to S, K is equiv to R
- $K=\mathrm{HIGH}$ and $J=$ LOW $\Rightarrow Q$ becomes LOW (RESET state)
- Both $J$ and $K$ are LOW $\Rightarrow$ No change in output $Q$
- Both $J$ and $K$ are HIGH $\Rightarrow$ Toggle, meaning it will go to high when low, and low when high.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=22%7CCircuit%20&%20Table)

## T Flip-flop

Single input version of the $J-K$ flip-flop, formed by tying both inputs together.

Visit [](Lect19_Sequential_Logic_Part-1.pdf#page=23%7CCircuit%20&%20Table)

## Asynchronous Inputs

Flips flop can have a asynchronous input:  [](Lect19_Sequential_Logic_Part-1.pdf#page=24%7CPDF)

Asynchronous inputs affect the state of the flip-flop independent of the clock. See  [](Lect19_Sequential_Logic_Part-1.pdf#page=25%7CJ-K%20flip-flop%20with%20active-low%20PRESET%20and%20CLEAR%20asynchronous%20inputs). This allows to changing state regardless of the clock cycle.

## Sequential Circuits: Analysis

Given a sequential circuit diagram, we can analyze its behaviour by deriving its state table and hence its state diagram. We use $\boldsymbol{A}(t)$ and $\boldsymbol{A}(\boldsymbol{t + 1})$ (or simply $A$ and $A^{+}$) to represent the present state and next state, respectively, of a flip-flop represented by $A$. [](Lect19_Sequential_Logic_Part-2.pdf#page=4%5C%7CPDF)

Example: 

1. Derive the [](Lect19_Sequential_Logic_Part-2.pdf#page=5%5C%7CState%20equation)
	1. E.g. Calculate the equation for D (one in the A side, can be marked DA)
	2. Since $A^+$ (next state) = DA, the equation for $A^{+}=A \cdot x+B \cdot x$
2. Create a [](Lect19_Sequential_Logic_Part-2.pdf#page=7%5C%7CState%20table)
	1. Tip : find the condition for $A^+$ is 1 and fill in the next state.
3. Draw the [](Lect19_Sequential_Logic_Part-2.pdf#page=10%5C%7CState%20diagram)
	1. note input/output format

[](Lect19_Sequential_Logic_Part-2.pdf#page=3%5C%7CSee%20characteristic%20table)
## Flip-flop input functions

Visit [](Lect19_Sequential_Logic_Part-2.pdf#page=12%5C%7CPDF)

[](Lect19_Sequential_Logic_Part-2.pdf#page=14%5C%7CExample%202) two J-K flip-flops with no output. In the state table note that next state is derived after filling in flip flop inputs. Eg. JA KA are 0 and 0 which is a no change. Hence $A^+$ is 0

[](Lect19_Sequential_Logic_Part-2.pdf#page=17%5C%7CExample%203) two J-K flip-flops with output.



## Flip flop Excitation Table

Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=2%5C%7CPDF)

[](Lect19_Sequential_Logic_Part-3.pdf#page=3%5C%7CExcitation%20tables): given the required transition from present state to next state, determine the flip-flop input(s).

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

[](Lect19_Sequential_Logic_Part-3.pdf#page=5%5C%7CExample)
Please remember the clocking input

[](Lect19_Sequential_Logic_Part-3.pdf#page=10%5C%7CExample%202)

[](Lect19_Sequential_Logic_Part-3.pdf#page=13%5C%7CExample%203%20with%20unused%20states). Be careful as it can be trapped in a loop of invalid state. This can be avoided by checking if the state is self correcting. Visit Recitation 10. Method: draw the state table of the unused states. Check if they go to a used (valid) or unused state (invalid) eventually.

## Memory

Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=17%5C%7CPDF)

Different from memory element. This is the memory chips that are used to store programs and data.

Memory should have these properties: Fast access, large capacity, economical cost, non-volatile. However, most memory devices can not possess all these properties. Hence we organize these memories into [](Lect19_Sequential_Logic_Part-3.pdf#page=18%5C%7CMemory%20hierarchy).

### Data transfer between memory and CPU

Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=19%5C%7CPDF), [](Lect19_Sequential_Logic_Part-3.pdf#page=21%5C%7CBlock%20Diagram)

Recall that the memory is divided into pigeon holes and each pigeon holes has a index number called a address. If there are $k$ addressing bits, there will be $2^k$ addressable locations.

The addresses are travelled over wires called address bus. For $k$ addressable locations, the address bus must have $k$ wires to carry $k$ bits of address.

In the processor, there is a register called **Memory Address Register** that generates the addresses to be sent to memory to write or load data. 

The data to be stored on the pigeon hole is stored in the **Memory Data Register**. The data is transferred through the data bus which has width equal to 1 word in most cases. Hence in 32 machine the data bus is usually 32 bits wide.

The **control lines** Read and Write specifies the direction of the transfer of the data.

---

### Read/Write Operations

Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=22%5C%7CPDF)

## Memory Cell

There are two types of RAM

- Static RAMs use flip-flops as the memory cells
- Dynamic RAM use capacitor charges to represent data. The simpler in circuitry, the have to be constantly refreshed.

We will look at Static RAM for this course. Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=23%5C%7CPDF)

## Memory Arrays

Logic construction of a $4 \times 3$ RAM (with decoder and OR gates): Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=24%5C%7CPDF)

An array of RAM chips can be combined to form larger memory: Visit [](Lect19_Sequential_Logic_Part-3.pdf#page=25%5C%7CPDF)


