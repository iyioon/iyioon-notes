# Cache

## Introduction

Recall that in a computer, the processor access the memory to perform a load or store operation. 

![[22 Cache Data Transfer.png|300]]

However, the speed at which these data are travelled are slow. For instance, 

 - A 1GHz Processor implies that it takes 1ns per clock cycle.
 - 50ns for DRAM access implies that it takes 50 processor clock cycles per memory access.
 - This speed difference is cased by a faster development of the CPU speed compared to the DRAM access speed. See this [[Lect22_Cache1_full.pdf#page=7|Graph]]. 
 
Such performance difference is unfavorable. Therefore, we must find faster memory technology ie cache.  

There are two kinds of memory technology: **DRAM** and **SRAM**

![[22 Cache Two types of RAM.png]]

| SRAM                           | DRAM                           |
| ------------------------------ | ------------------------------ |
| 6 transistors per memory cell  | 1 transistor per memory cell   |
| Low density                    | Hight density                  |
| Fast access latency of 0.5-5ns | Slow access latency of 50-70ns |
| More costly                    | Less costly                    |
| Uses flip flops                | Used in main memory                               |

SRAM is normally used for cache. Besides these memory there are secondary memory such as [[Lect22_Cache1_full.pdf#page=9|Magnetic Disk]]. 

In [[Lect22_Cache1_full.pdf#page=10|summary]]: 

|           |  Capacity   | Latency | Cost/GB  |
|:---------:|:-----------:|:-------:|:--------:|
| Register  | 100 s Bytes |  20ps   | \$\$\$\$ |
|   SRAM    |   100sKB    | 0.5-5ns |  \$\$\$  |
|   DRAM    |  100 s MB   | 50-70ns |    \$    |
| Hard Disk |   100sGB    | 5-20ms  |  Cents   |
|   Ideal   |     1GB     |   1ns   |  Cheap   |


## Cache: The Basic Idea

Imagine that bookshelf are the memory. You want the read the book, but every time you want to read a another book, you are forced to put back the current book to its bookshelf.

One solution is to take books that are likely to be needed soon and place them nearby on a desk. This way, you can save time moving back and forth. This is the basic principle of how cache work:

- Keep the frequently and recently used data in **smaller but faster** memory
- Refer to bigger and slower memory only when you cannot find data/instruction in the faster memory

Why does this work? 

**Principle of Locality:** Program accesses only a small portion of the memory address space within a small time interval.

### Types of Locality

**Temporal locality:** If an item is referenced, it will tend to be referenced again soon. E.g., variable in a loop

**Spatial locality:** If an item is referenced, nearby items will tend to be referenced soon. E.g., you access the 1st, 2nd... element in a array.

[[Lect22_Cache1_full.pdf#page=17|Diagram]]. Our aim is to capture the working set and keep it in the memory closet to CPU

### Cache location

To improve the access time of the data, **cache** (SRAM) memory is placed in between the processor and the memory (DRAM). 

![[22 Cache Cache Location.png|500]]

### Memory Access Time

Cache works by bringing extra "books" that may be needed soon. Hence there is a probability involved. [[Lect22_Cache1_full.pdf#page=19|Diagram]]. Lets say the processor tries to access a data. It can either be in the cache (hit) or in the memory (miss).

**Hit**: Data is in cache (e.g., X)

- Hit rate: Fraction of memory accesses that hit
- Hit time: Time to access cache

**Miss**: Data is not in cache (e.g., Y)

- Miss rate $=1-$ Hit rate
- Miss penalty: Time to replace cache block + hit time

Hit time $<$ Miss penalty

<font style="color:#3258a8">$$\text{Average access time} = \text{hit rate} \times\text{hit time}+(1-\text{Hit rate})\times\text{Miss penalty}$$</font>

**Example calculation:** Suppose our on-chip SRAM (cache) has 0.8 ns access time, but the fastest DRAM (main memory) we can get has an access time of $10 n s$. How high a hit rate do we need to sustain an average access time of $1 \mathrm{~ns} ?$

Let $h$ be the desired hit rate.
$$
\begin{aligned}
& 1=0.8 h+(1-h) \times(10+0.8) \\
& =0.8 h+10.8-10.8 h \\
& 10 h=9.8 \rightarrow h=0.98
\end{aligned}
$$
Hence we need a hit rate of $98 \%$.

## Memory to Cache Mapping

Recall that a word of data is transferred from the memory to the processor. But when we have a cache, we will transfer more than one word of data because we want to bring in more "books" from the "library" to put it on the "desk". This amount of data is called the **cache block/Line**

- **Cache Block/Line:** Unit of transfer between memory and cache
- Block size is typically one or more word
	- e.g.: 16-byte block $\cong 4$-word block (MIPS)
	- 32-byte block $\cong 8$-word block 

![[22 Cache Memory to Cache Mapping.png]]

**Block number** is the left 2 bits for the example above.
**Block offset** is the remaining bits.

## Direct Mapped Cache

In the previous section, we have divided the memory address into two portions: **Block number** and **offset**. Now lets takes the block number and map them to the cache index. This can be achieved by dividing the block number again into two portions: **tag number** and  **cache index**

![[22 Cache Direct mapped cache.png]]

If number of Cache Blocks = $2^M \to$ the last M bits of the block number is the **cache index**. E.g. Cache has $2^2=4$ blocks $\to$ last 2 bits of the block number is the cache index.

Multiple memory blocks can map to the same cache block $\to$ Same cache index. However, they have unique **tag number:** Tag = Block number / Number of Cache Blocks. (Integer division). This is used to determine where the data in the cache is from. 

In summary the memory address is divided into the following sections.

![[22 Cache Directed Mapped summary.png|400]]

### Cache Structure

In the cache, along with the data block, it also contains the following administrative information (overheads):

- **Tag** of the memory block.
- **Valid bit** indicating whether the cache line contains valid data.

When the computers starts, cache is normally filled with random data. Hence it is possible for the tag to coincidently match with the searching tag. This is why valid bit is used to ensure the real data is in the cache.

With this information, cache hit can be determined with

```
(Valid[index] = True) AND (Tag[index] = Tag[memory address])
```

**For example**: 

![[22 Cache Mapping example.png]]


With this, lets say we want to determine the cache hit for a particular memory address of the data you are looking for. 

![[22 Cache Circuitry.png]]

1. Use the index to go to the correct row in the cache. E.g. 2
2. Determine if the data is in the cache by checking 
	1. valid.
	2. Tag in the row is equal to the given Tag.
3. If it is a hit
	1. Use the offset to determine the word you need. E.g the left 2 bits from the offset.

### Reading Data Example

To explore further how the directed mapped cache works, see this [[Lect22_Cache1_full.pdf#page=30|example]]:

Given a [[#Direct Mapped Cache|Direct Mapped]] 16KB cache: 16-byte blocks $\times$ 1024 cache blocks. Trace the following memory accesses:

![[22 Cache Reading data.png|400]]

Lets begin with the first address.

![[22 Cache.png|400]]

**Step 1:** Check Cache Block at index 1
**Step 2:** Data i block 1 is invalid (Cold/Compulsory Miss)

![[22 Cache-1.png|600]]

**Step 3:** Load 16 bytes from memory; Set Tag and Valid bit

![[22 Cache-2.png|600]]

**Step 4:** Return Word 1 (byte offset = 4) to Register

See [[Lect22_Cache1_full.pdf#page=36|here]] for the remaining addresses.

### Summary

![[22 Cache-3.png]]

See [[Lect22_Cache1_full.pdf#page=53|here]] for another example.
## Types of Cache Misses

**Compulsory misses**

- On the first access to a block; the block must be brought into the cache
- Also called cold start misses or first reference misses

**Conflict misses**

- Occur in the case of direct mapped cache or set associative cache, when several blocks are mapped to the same block/set
- Also called collision misses or interference misses

**Capacity misses**

- Occur when blocks are discarded from cache as cache cannot contain all blocks needed

## Writing Data

When we want to write data to the memory, we must consider the fact that the data is in both the memory and the cache. In this [[Lect22_Cache1_full.pdf#page=62|example]] when we write a data to a cache, it does not reflect the data in the memory. Cache and main memory are inconsistent!

**Solution 1:** Write-through cache (easy but slow)

- Write data both to cache and to main memory

**Solution 2:** Write-back cache (more popular)

- Only write to cache
- Write to main memory only when cache block is replaced (evicted) 

## Write - Through Cache

**Problem:** Write will operate at the speed of main memory

![[22 Cache-4.png|300]]

**Solution:** Put a write buffer between cache and main memory

- Processor: writes data to cache + write buffer
- Memory controller: write contents of the buffer to memory
- This allows the processor to continue on, instead of waiting for the write operation on the DRAM completes.

## Write - Back Cache

**Problem:** We need a way to indicated whether the data has been changed in the cache. Otherwise the only option is to write back for every evicted cache blocks which is wasteful. 

**Solution:** Add an additional bit (**Dirty bit**) to each cache block. Write operation will change dirty bit to 1. Then, when a cache block is replaced, only write back to memory if dirty bit is 1

## Handling Cache Misses

On a **Read Miss**

- Data loaded into cache and then load from there to register 

**Write Miss** option 1: Write allocate

- Load the complete block into cache
- Change only the required word in cache
- Write to main memory depends on write policy (either write back or write through)

**Write Miss** option 2: Write around

- Do not load the block to cache
- Write directly to main memory only

In summary: 

![[22 Cache-5.png]]

**Reading**: Large and Fast: Exploiting Memory Hierarchy.

- Chapter 7 sections 7.1 – 7.2 (3rd edition)
- Chapter 5 sections 5.1 – 5.2 (4th edition)

## Block Size Trade - off

Recall that:

$$\text{Average access time} = \text{hit rate} \times\text{hit time}+(1-\text{Hit rate})\times\text{Miss penalty}$$

Using larger block size has trade offs:

- Takes advantage of spatial locality
- Larger miss penalty: Takes longer time to fill up the block
- If block size is too big relative to cache size $\to$ too few cache blocks $\to$ miss rate will go up

![[22 Cache-6.png]]

[[Lect23_Cache2_full.pdf#page=5|Another diagram]]

## Set Associative (SA) Cache

SA Cache is a another type of cache used to solve conflict misses. See [[#Types of Cache Misses]] for recap. 

SA cache can have N-way. N refers to number of blocks in each set. Within the set, a memory block can be placed in any of the N cache blocks in the set. [[Lect23_Cache2_full.pdf#page=8|PDF]]. For instance a 2-way Set Associative Cache looks as follows:

![[22 Cache-7.png]]

There is a need to search both blocks to look for the memory block.

### Mapping

Just like the [[#Direct Mapped Cache]] we have to map the addresses to the cache.

![[22 Cache-8.png|500]]

### Example

![[22 Cache-9.png|500]]

![[22 Cache-10.png]]


### Advantage

Lets compare SA Cache with Direct Mapped Cache to see how it avoids conflict Miss. In the Direct Mapped Cache:

![[22 Cache-11.png|500]]


However in the SA Cache:

![[22 Cache-12.png|500]]

![[22 Cache-13.png|400]]

### Example 2

Visit [[Lect23_Cache2_full.pdf#page=17]] For detailed example

## Fully Associative (FA) Cache

A memory block can be placed in any location in the cache

**Key idea:** Memory block placement is no longer restricted by cache index or cache set index

- Can be placed in any BUT
- Need to search all cache blocks for memory access

### Mapping

In FA Cache there is only two portions. The tag and the Offset

![[22 Cache-14.png]]

### Example

- 4KB cache size and 16-Byte block size
- Compare every tags (256) and valid bits in parallel

![[22 Cache-15.png|500]]

### Performance

1. Cold/compulsory miss remains the same irrespective of cache size/associativity.
2. For the same cache size, conflict miss goes down with increasing associativity.
3. Conflict miss is 0 for FA caches.
4. For the same cache size, capacity miss remains the same irrespective of associativity.
5. Capacity miss decreases with increasing cache size .

## Block Replacement Policy

This only applies to the [[#Set Associative (SA) Cache]] and [[#Fully Associative (FA) Cache]] because

- Can choose where to place a memory block
- Potentially replacing another cache block if full
- Need block replacement policy

**Least Recently Used (LRU)** is one type of block replacement policy 

- How: For cache hit, record the cache block that was accessed
	- When replacing a block, choose one which has not been accessed for the longest time
- Why: Temporal locality

**Example:** Lets say that the following memory accesses are done: `0 4 8 12 4 16 12 0 4` in a 4-way SA cache. Figure below shows the <u>data structure</u> (not the cache) to keep track which one is most recently used. By the time `0 4 8 12` is accessed, we see that in the first line, 12 is the most recently used and 0 is the least recently used.

![[22 Cache-16.png|400]]

Then when the next access `4` is performed, it should move up the data structure shown by the second line. Next when `16` is accessed, it is a miss, hence the LRU (`0`) is chosen to evicted illustrated by the 3rd line.

**Draw back for LRU**

- Hard to keep track if there are many choices.

**Other replacement policies:**

- First in first out (FIFO)
- Random replacement (RR)
- Least frequently used (LFU)

Visit [[Lect23_Cache2_full.pdf#page=31]] for comparison using example.
## Summary

Visit [[Lect23_Cache2_full.pdf#page=35]]


## Exploration: Multilevel Cache

It is possible to separate the cache into

- Data caches
- Instruction cach

It is also possible to have different level of caches.

Visit [[Lect23_Cache2_full.pdf#page=38]]

