# The Processor: Datapath

<span class="center-menu">[[Lect11_Datapath_full.pdf#page=1\|Lecture PDF]]</span>

## Instruction Execution Cycle Overview

1. Fetch
2. Decode
3. Operand Fetch
4. Execute
5. Result Write (Store)

[[Lect11_Datapath_full.pdf#page=7\|Example in MIPS]]

## Fetch Stage

1. Use the PC to fetch the instruction from memory
	1. PC is a special register in the processor
2. Increment the PC by 4 (size of instruction) to get the next instruction 

[[Lect11_Datapath_full.pdf#page=15\|Details on the components used in the fetch stage]]

## Decode Stage

- Use the 32-bit instruction passed by the fetch stage
- Read the opcode
- Read the data from the registers

[[Lect11_Datapath_full.pdf#page=19\|Details]]

### Reg File

This is a control signal to indicate

- writing of register
- 1 (True) = Write, 0 (False) = No Write

[[Lect11_Datapath_full.pdf#page=23\|Example]]

- Here, addresses of the register are passed into the Read register 1, 2. 
- The contents of these register are passed from the Read data 1, 2 to the ALU
- Then, the output of ALU is passed to the Write data.

Note that for immediate instruction eg. addi, [[Lect11_Datapath_full.pdf#page=25\|Multiplexer]] is used to put the register address to the correct register in the register file.

## ALU Stage 

Also called the **Execution stage**

[[Lect11_Datapath_full.pdf#page=32\|Block Diagram]]

Example of a [[Lect11_Datapath_full.pdf#page=34\|Non-Branch Instruction]]
Example of a [[Lect11_Datapath_full.pdf#page=35\|Branch Instruction]]

The PCSource is determined with $beq \cap iszero$
## Memory Stage

[[Lect11_Datapath_full.pdf#page=38\|Block Diagram]]

[[Lect11_Datapath_full.pdf#page=40\|Example]]

==REMEMBER that MemToReg is upside down. Input 1 is on top and input 0 is below. [[Lect11_Datapath_full.pdf#page=42\|See Here]]==

##  Register Write Stage

[[Lect11_Datapath_full.pdf#page=44\|Block Diagram]]

[[Lect11_Datapath_full.pdf#page=40\|Example]]
