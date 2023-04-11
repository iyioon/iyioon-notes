# 20_Pipelining

## Introduction

> [PDF](Lect20_Pipelining1_full.pdf#page=3)

In the previous MIPS, the data propagates through each component. However, to achieve concurrency, we must have buffers so that when the new instruction is loaded, the next stage is not effected.
## MIPS Pipeline Stages

> [PDF](Lect20_Pipelining1_full.pdf#page=11)

Recall that Mips instruction has five Execution Stages:

**IF**: Instruction Fetch
**ID**: Instruction Decode and Register Read
**Ex**: Execute an operation or calculate an address
**MEM**: Access an operand in data memory
**WB**: Write back the result into a register

Also recall the the datapath:  [PDF](Lect20_Pipelining1_full.pdf#page=12%7CPDF). Each of the stage will take 1 clock cycle as shown [PDF](Lect20_Pipelining1_full.pdf#page=13%7Chere) (each box takes 1). Note that if there is two instruction, then eg, IF of the next instruction can only be executed after the first IF. Same with the rest.  
## Pipeline Datapath

> [PDF](Lect20_Pipelining1_full.pdf#page=14)

In order to achieve the pipelining there are changes that need to be made on the datapath. 

When there is no pipeline (**Single-cycle implementation**):

- Update to the PC, register file, data memory are all done at the end of a clock cycle

In contrast, during the **Pipeline implementation**:

- Each of the five stages are executed in one clock cycle
- Data required for each stage needs to be stored separately using [registers](Lect20_Pipelining1_full.pdf#page=15%7Cpipeline%20registers)

---

### Pipeline registers

[PDF](Lect20_Pipelining1_full.pdf#page=16%7CCollections%20of%20pipeline%20registers):

- Example: The IF/ID registers stores the instruction, and the PC+4 value

Refer to [PDF](Lect20_Pipelining1_full.pdf#page=17%7CPDF) of how each stages work. Note that in the **WB Stage**, the address which the value need to be stored is incorrect. This is because the write register will hold the address from the other instruction. [PDF](Lect20_Pipelining1_full.pdf#page=22%7CPDF). To solve this, the “Write register” number from ID/EX will be carried forward through EX/MEM to MEM/WB pipeline register for use in WB stage. Hence the corrected datapath should look like:  [PDF](Lect20_Pipelining1_full.pdf#page=23%7CPDF)
## Pipeline Control

> [PDF](Lect20_Pipelining1_full.pdf#page=24)

The control signal also have to be carried forward from one stage to another to implement the pipeline. [PDF](Lect20_Pipelining1_full.pdf#page=27%7CPDF). See that the branch signal is in the MEM stage. This is because it has to be used during the next stage.


## Pipeline Performance

> [PDF](Lect20_Pipelining1_full.pdf#page=29)

This is the performance (number of clock cycle) in a ideal pipeline where there are no Hazards.

[PDF](Lect20_Pipelining1_full.pdf#page=33%7CReview%20Questions)

## Hazards

> [PDF](Lect21_Pipelining2_full.pdf#page=4)

Hazards are problems that prevent next instruction from immediately following previous instruction.

There are three types of Hazards. Structural, Data and Control. The last two are instruction dependencies.


## Structural Hazards

> [PDF](Lect21_Pipelining2_full.pdf#page=6)

Example is where two instruction is attempting to access the memory at the same time. One solution is with [stall](Lect21_Pipelining2_full.pdf#page=7%7Cstall) (Delay the instruction). However, this could lead to a another structural hazard.

Other solution is by splitting the memory into Data and Instruction memory. [PDF](Lect21_Pipelining2_full.pdf#page=8%7CPDF)

In this structural hazard [example](Lect21_Pipelining2_full.pdf#page=9%7Cexample), Reg is being accessed by two instructions. Since Registers are very fast memory, it is possible to split the cycle into half. [PDF](Lect21_Pipelining2_full.pdf#page=10%7CPDF)
## Instruction Dependencies

> [PDF](Lect21_Pipelining2_full.pdf#page=11)

**Data Dependency**: When different instructions accesses (read/write) the same register. Only [Raw](Lect21_Pipelining2_full.pdf#page=12%7CRaw) Data dependency cause pipeline hazards. This will be discussed in the next section. To determine the dependency of two instruction, see the overlapping address. then see what is done to the address. Eg, `$1` is both in the two instructions. i1 writes to `$1` and i2 reads from `$1`. Hence RAW.

**Control Dependency**: When the execution of an instruction depends on another instruction

Failure to handle dependencies can affect program correctness!


## RAW Data Hazards

> [PDF](Lect21_Pipelining2_full.pdf#page=14)

In the example: 

- The `sub $2, $ 1, $3` instruction only writes the value in `$s2` at clock cycle 5. However, the `and $12, $2, $ 5`  instruction needs to read the `$s2` register at clock cycle 3.
- To solve this. the value calculated by the ALU can be **forwarded** to the ALU in the next instruction. See [PDF](Lect21_Pipelining2_full.pdf#page=16%7CPDF).

However, this solution does not work for LOAD Instruction Solution : [Example](Lect21_Pipelining2_full.pdf#page=18%7CExample).
To solve this, we have to put a [stall](Lect21_Pipelining2_full.pdf#page=19%7Cstall).

In summary, RAW Data Hazards can be solved by **forwarding**. If there is a load instruction, **Stall** is also used. The detailed processed will not be discussed in this module. Visit [Exercise](Lect21_Pipelining2_full.pdf#page=20%7CExercise).
## Control Hazards

> [PDF](Lect21_Pipelining2_full.pdf#page=26)

Recall `j` or `beq` instruction. During pipelining the instruction after jump can always be allowed to be executed. Hence we have to solve this problem. [Example](Lect21_Pipelining2_full.pdf#page=27%7CExample).

One simple solution is adding delays. [Example](Lect21_Pipelining2_full.pdf#page=31%7CExample). This wastes 3 clock cycle. This is too heavy. Other solutions include:

- Early Branch Resolution
- Branch Prediction
- Delayed Branching

Usually Early Branch Resolution is always used, and then combined with one of the two remaining methods.

[PDF](Lect21_Pipelining2_full.pdf#page=32%7CPDF)

## Early Branch

> [PDF](Lect21_Pipelining2_full.pdf#page=33)

Make decision in ID stage instead of MEM. [PDF](Lect21_Pipelining2_full.pdf#page=34%7CPDF)
Achieve reduction from 3 to 1 clock cycle delay. [PDF](Lect21_Pipelining2_full.pdf#page=35%7CPDF)

- However if the register involved in the comparison is produced by preceding instruction, There is a additional delay (stall). [PDF](Lect21_Pipelining2_full.pdf#page=37%7CPDF)
- The problem is worse with load followed by branch. [PDF](Lect21_Pipelining2_full.pdf#page=38%7CPDF)

## Branch Prediction

> [PDF](Lect21_Pipelining2_full.pdf#page=39)

There are many branch prediction schemes. Assume branch is taken, assume branch is not taken.

In this section, all branches are assumed to be not taken. Then when the actual branch outcome is known:

- Not taken: [Guessed correctly](Lect21_Pipelining2_full.pdf#page=40%7CGuessed%20correctly) -> No pipeline stall 
- Taken:  [Guessed wrongly](Lect21_Pipelining2_full.pdf#page=41%7CGuessed%20wrongly) -> Wrong instructions in the pipeline -> Flush successor instruction from the pipeline. 

Note that early branch is done, hence the decision is made at the ID stage.

[Example](Lect21_Pipelining2_full.pdf#page=42%7CExample)

**Example from Quiz 20-21:** How many cycles are needed to execute the  program with forwarding, assume branch-NOT-taken prediction strategy, branch decision made at MEM, whereas the actual branch in the code is taken.

```
		lw  $s2, 0($s1)
		bne $s2, $s3, L1
		sub $s0, $s4, $s5
L1: add $s0, $s0, $s3
```

|  | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   | 9   | 10  | 11  |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `lw`  | F   | D   | E   | M   | W   |     |     |     |     |     |     |
| `bne` |     | F   | D   |     | E   | M   | W   |     |     |     |     |
| `sub` |     |     | F   |     | D   | E   | X   | X   |     |     |     |
| `add` |     |     |     | F   |     | D   | X   | X   | X   |     |     |
| `add` |     |     |     |     |     |     | F   | D   | E   | M   | W    |

There are two key things to know here:

- In the $4^{\text{th}}$ row (add), the decode is not after Fetch because the previous instruction Decode cycle has not finished. In other words it can only be executed when the previous instruction is in Execute stage.
- Note that there are two add instruction. This is because before the branch decision is made in cycle 6 (MEM), the processor continues with the instructions after. Then when the clock cycle reaches 7, it stopes and move on to the L1 instruction which is again, the add instruction.
## Delayed Branch

> [PDF](Lect21_Pipelining2_full.pdf#page=45)

Move non-control dependent instructions into the X slots following a branch. [Example](Lect21_Pipelining2_full.pdf#page=46%7CExample)

[Best and Worst case](Lect21_Pipelining2_full.pdf#page=47%7CBest%20and%20Worst%20case)

