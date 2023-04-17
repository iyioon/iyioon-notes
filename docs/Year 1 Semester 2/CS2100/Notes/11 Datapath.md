# The Processor: Datapath

<span class="center-menu">[](Lect11_Datapath_full.pdf#page=1%5C%7CLecture%20PDF)</span>

## Instruction Execution Cycle Overview

1. Fetch
2. Decode
3. Operand Fetch
4. Execute
5. Result Write (Store)

[Example in MIPS](Lect11_Datapath_full.pdf#page=7%5C%7CExample%20in%20MIPS)

## Fetch Stage

1. Use the PC to fetch the instruction from memory
	1. PC is a special register in the processor
2. Increment the PC by 4 (size of instruction) to get the next instruction 

[Details on the components used in the fetch stage](Lect11_Datapath_full.pdf#page=15%5C%7CDetails%20on%20the%20components%20used%20in%20the%20fetch%20stage)

## Decode Stage

- Use the 32-bit instruction passed by the fetch stage
- Read the opcode
- Read the data from the registers

[Details](Lect11_Datapath_full.pdf#page=19%5C%7CDetails)

### Reg File

This is a control signal to indicate

- writing of register
- 1 (True) = Write, 0 (False) = No Write

[Example](Lect11_Datapath_full.pdf#page=23%5C%7CExample)

- Here, addresses of the register are passed into the Read register 1, 2. 
- The contents of these register are passed from the Read data 1, 2 to the ALU
- Then, the output of ALU is passed to the Write data.

Note that for immediate instruction eg. addi, [Multiplexer](Lect11_Datapath_full.pdf#page=25%5C%7CMultiplexer) is used to put the register address to the correct register in the register file.

## ALU Stage 

Also called the **Execution stage**

[Block Diagram](Lect11_Datapath_full.pdf#page=32%5C%7CBlock%20Diagram)

Example of a [Non Branch Instruction](Lect11_Datapath_full.pdf#page=34%5C%7CNon-Branch%20Instruction)
Example of a [Branch Instruction](Lect11_Datapath_full.pdf#page=35%5C%7CBranch%20Instruction)

The PCSource is determined with $beq \cap iszero$
## Memory Stage

[Block Diagram](Lect11_Datapath_full.pdf#page=38%5C%7CBlock%20Diagram)

[Example](Lect11_Datapath_full.pdf#page=40%5C%7CExample)

==REMEMBER that MemToReg is upside down. Input 1 is on top and input 0 is below. [](Lect11_Datapath_full.pdf#page=42%5C%7CSee%20Here)==

##  Register Write Stage

[Block Diagram](Lect11_Datapath_full.pdf#page=44%5C%7CBlock%20Diagram)

[Example](Lect11_Datapath_full.pdf#page=40%5C%7CExample)
