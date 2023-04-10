# Hashing

<span class="right-menu">[Video Part 1](https://youtu.be/zN_z7Kwfy_o) [[14.Hashing1.pdf\|PDF]]
[Video Part 2](https://youtu.be/j_G_d8oHuq8) [[15.Hashing2.pdf\|PDF]]
[Video Part 3](https://youtu.be/qxRIPSXrpb8) [[16.Hashing3.pdf\|PDF]]
[Video Part 4](https://www.youtube.com/watch?v=AfIhojjMetk)[[17.Hashing4GraphsIntro.pdf\|PDF]]
</span>
## Introduction

**Hashing** implements a abstract datatype called a Symbol Table.

```java
public interface SymbolTable
	void insert(Key k, Value v) //insert(k,v) into table
	Value search(Key k)         //get balue paired with k
	void delete(Key k)          //remove key k (and value)
	boolean contains(Key k)     // is there a value for k?
	int size()                  //number of (k,v) pairs
```

These are symbol table used throughout computer science. [[14.Hashing1.pdf#page=7|➜PDF]]

- Dictionary
- Phone Book
- Internet DNS
- Java compiler

Suppose you implement a symbol table with an AVL tree. 

- Cost of insertion $C_{I}=O(\log n)$ 
- Cost of search $C_{s}=O(\log n)$

The objective is to implement a symbol table with a constant cost.

-  $C_{I}=O(1)$ 
-  $C_{s}=O(1)$

However, this means that the sorting cost takes $O(n^2)$ unlike an AVL tree that takes $O(n\log n)$.
Symbol table is not _comparison based_.

## Direct Access Tables

One of the most obvious method of constructing such data structure is through Direct Access Table.

**Example**: (2, item1), (8, item2), (5, item3)

![[14 Hashing Direct Access Table.png|200]]

Assume keys are distinct.

**Problem**:

- Keys are integers

This cannot be solved by treating everything as a sequence of bits as the size of the array will become too large. For example, to store english words:

- 26 letters -> 5 bits/letter
- Longest word = 34 letters
- 34 * 5 bits = 170 bits
- Size of the array required to store all english words  = $2^{170}$ $\approx$ number of atoms in observable universe

This is why Hash Tables are used.
## Hash Functions

**Objective**: Given $U$ possible keys (eg $2^{170}$ ) and $n$ number of actual keys, map $n$ keys to $m \approx n$buckets.

![[14 Hashing Hask Function mapping.png|500]]

**Define hash function** $\mathrm{h}: \mathrm{U} \rightarrow\{1 . . m\}$

- Store key $k$ in bucket $\mathrm{h}(k)$
- Time complexity:
	- Time to compute $\mathrm{h}$ + Time to access bucket (time to access the location in memory)
- Usually: assume hash function has cost 1 to compute.

## Collisions

We say that two distinct keys $k_1$ and $k_2$ collide if:
$$
\mathrm{h}\left(k_1\right)=\mathrm{h}\left(k_2\right)
$$

>Collision is unavoidable when using a hash function:

- The table size is smaller than the universe size
- The pigeonhole principle says:
	- There must exist two keys that map to the same bucket
	- Some keys must collide!

### Coping with Collision

**Idea**: choose a new, better hash functions

- Hard to find.
- Requires re-copying the table.
- Eventually, there will be another collision.

**Idea**: [[#Chaining]] 

- Put both items in the same bucket!

**Idea**: open addressing

- Find another bucket for the new item.

## Chaining

Each bucket contains a linked list of items:

![[14 Hashing Chaining.png|300]]

**Total space**: $O(m+n)$ where $m$ is the number of slots in the hash table and $n$ is the number of keys inserted.

### Operations

**`insert(key,value)`**

- Calculate `h(key)`
- Lookup `h(key)` and add `(key,value)` to the linked list.
- worst-case cost: $O(1+\operatorname{cost}(\mathrm{h}))$ where $\operatorname{cost}(\mathrm{h})$ is the cost of computing the hash function. Note that the element is added to the head of the linked list.

**`search(key)`**

- Calculate `h(key)`
- Search for `(key,value)` in the linked list 
- Expected search time: $O\left( 1+\frac{n}{m} \right)=O(1)$.  [[14.1 Analysis of chaining#Expected Search time|Calculation]]
- worst-case cost: $O(n+\operatorname{cost}(\mathrm{h}))$. When all the keys are in the same bucked in the linked list.

**`Delete(key)`**

1.  Calculate hash of key.
2.  Let L be the linked list in the specified bucket.
3.  Search for item in linked list L.
4.  Delete item from linked list L.
5. Cost = $O\left( 1+\frac{n}{m} \right)$

### Analysis of chaining

Visit [[14.1 Analysis of chaining]]

## Java hashing

How do we implement Hashing in Java? Java provides a interface:

`java.util.Map<Key,Value>` (Refer to [java documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Map.html))

- No duplicate keys are allowed
- No mutable keys
	- If you use an object as a key, then you can't modify that object later

Note that `Map` is a interface. Hence it cannot be instantiated. Instead, `HashMap` can be used.

```java
Map<String,Integer> ageMap = new HashMap<String,Integer>();
```

### How is hash value calculated from the key?

Java Object supports the method `int hashCode()`. The integer returned by this method is used by Java to calculate the hash value (`hash = hashcode % buckets.length`). Hence, the subclass must modify the `hashCode()` method to obey the following rules:

- Always returns the same value, if the object hasn't changed
- If two objects are equal, then they return the same hashCode (Other way around is recommended)

Overriding the `hashCode()` method is _necessary_ as default java implementation `hashCode` returns the memory location of the object, hence every object hashes to a different location.

Furthermore, you _must_ override `.equals` to be consistent with hashCode. This is because the `get` method in HashMap returns the value from the key only if `key.equals(k)` where k is the object found in the HashMap. Refer to [[15.Hashing2.pdf#page=89]]

Visit [[15.Hashing2.pdf#page=73]] for how Java Library Classes calculates hashCode.
## Designing Hash Functions

Goal: find a hash function whose values look random. There are two techniques

- Division Method
- Multiplication Method

### Division Method

The hash value is calculated by $\mathrm{h}(k)=k \bmod m$

To minimize the collision:

- Choose prime number
- Not too close to a power of 2
- Not too close to a power of 10

**Advantage**: Easy
**Disadvantage**: Not always the most effective, Division is slow

Visit [[15.Hashing2.pdf#page=96]] for bad $m$ values. 

If all keys and $m$ is divisible by $d$, then the value returned by the hash function will always be divisible by $d$. Hence only the slots divisible by $d$ will be occupied ie every 1 out of $d$ slots will be filled.

### Multiplication Method

- Fix table size: $m=2^r$, for some constant $r$.
- Fix word size: $w$, size of a key in bits.
- Fix (odd) constant A.
$$
h(k)=(A k) \bmod 2^w \gg(w-r)
$$

Visit [[15.Hashing2.pdf#page=105]] for explanation

**Advantage**: 

- Faster than Division method. 
	- Multiplication, shifting faster than division
- Works reasonably well when A is an odd integer $>2^{w-1}$
	- Odd: if it is even, then lose at least one bit's worth
	- Big enough: use all the bits in A.

## Table Resizing

[[16.Hashing3.pdf]]

We showed that the expected search time: $\mathrm{O}(1+n / m)$ and the optimal size: $m=\Theta(n)$

- if $(\mathrm{m}<2 \mathrm{n})$ : too many collisions.
- if $(\mathrm{m}>10 \mathrm{n})$ : too much wasted space.

In general we don't know $n$ in advance. Hence we grow and shrink the table as necessary:

1. Choose new table size $m$
2. Choose new hash function $h$
	1. Hash function depends on table size!
	2. Remember: $h: \mathrm{U} \rightarrow\{1 . . m\}$
3. For each item in the old hash table
	1. Compute new hash function
	2. Copy item to new bucket

### Growing the table

- Let $m_1$ be the size of the old hash table.
- Let $m_2$ be the size of the new hash table.
- Let $n$ be the number of elements in the hash table.

Then the cost:

- Scanning old hash table: $\mathrm{O}\left(m_1\right)$
- Creating new hash table: $\mathrm{O}\left(m_2\right)$
- Inserting each element in new hash table: $\mathrm{O}(1)$
- Total: $\mathrm{O}\left(m_1+m_2+n\right)$

What is the cost of inserting $n$ items by incrementing $m$ by 1? $O(n^2)$
[[16.Hashing3.pdf#page=25]]

This is to large. Hence we double the table size instead given us $O(n)$
[[16.Hashing3.pdf#page=27]]

- Most insertions: $\mathrm{O}(1)$
- Some insertions: linear cost (expensive)
- Average cost: $\mathrm{O}(1)$

How about squaring table size. Visit [[16.Hashing3.pdf#page=30]]

### Shrinking the table

Occurs during deletion of many items. 

-   If (n == m), then m = 2m.
-   If (n < m/4), then m = m/2.
    
-   After every change: the table is half full, half empty.
-   Every time you double a table of size m, at least m/2 new items were added since last change.
-   Every time you shrink a table of size m, at least m/4 items were deleted since last change.

### Summary 

-  When table is full, double the size.
-  When table is 3⁄4 empty, half the size.
-  Most operations areO(1).
-  Some operations costO(n).
-   On average, operations costO(1).

## Sets

Goal is to store a collection of keys. [[16.Hashing3.pdf#page=50|Java Abstract Data Type]]. This interface can be implemented with a hash table. [[16.Hashing3.pdf#page=52|Example|]]. 

**Disadvantage**: Too much space (buckets)

**Solution**: Use a fingerprint - only store/send $m$ bits. [[16.Hashing3.pdf#page=56|Example|]]. 

## Fingerprint Hash Table

If there are [[#Collisions]], it may sometimes report true. False Positive.

**Spam example**: it is better to store in the Fingerprint Hash Table:

1. ==The set of good e-mail addresses.==
2. The set of bad e-mail addresses
3. It does not matter.

It may be better to mistakenly accept a few SPAM e-mails than to accidentally reject an e-mail from my mother!

## Bloom Filter

Bloom Filter is used to solve the problem above by using two hash functions.

![[14 Hashing Bloom FIlter.png|400]]

## Open Addressing

**On collision** Probe a sequence of buckets until you find an empty one. 
Unlike chaining, we cannot insert more items if the bucket is already full.

Example: [[17.Hashing4GraphsIntro.pdf#page=11|Linear Probing]] - Find the next empty bucket linearly.

To achieve this, the **hash function** has to be re-defined:

$$
\mathrm{h}(\mathrm{key}, \mathrm{i}): \mathrm{U} \rightarrow\{1 . . \mathrm{m}\}
$$

In the case of [[17.Hashing4GraphsIntro.pdf#page=13|Linear Probing]]:

$$
\mathrm{h}(\mathrm{k}, i)=\mathrm{h}(\mathrm{k}, 1)+(i-1) \bmod m
$$

Note that $(i-1)\operatorname{mod}m$ is used start again from index 0 when $(i-1)>m$
[[17.Hashing4GraphsIntro.pdf#page=15|Code]]

### Search(key)

[[17.Hashing4GraphsIntro.pdf#page=17|Code]]

### Delete(key)

- Find the key to delete
- Remove it from the table
- ==Set the bucket to Deleted== (Tombstone value)

> Searching literates until it finds a empty bucket. Setting the bucket to null breaks the searching algorithm, hence the bucket is set to deleted.

### Hash Functions

**Uniform Hashing Assumption:**

- Every key is equally likely to be mapped to every **permutation**, independent of every other key.

### Linear Probing

**Problem**: If there is a cluster, then there is a higher probability that the next $h(k)$ will hit the cluster. [[17.Hashing4GraphsIntro.pdf#page=34|PDF]].

**Advantages:** Faster. Easier to access nearby array cells. [[17.Hashing4GraphsIntro.pdf#page=36|PDF]].

### Double Hashing

- Start with two ordinary hash functions $\mathrm{f}(k), \mathrm{g}(k)$.
- Define new hash functions:
	- $\mathrm{h}(k, i)=\mathrm{f}(k)+i \cdot \mathrm{g}(k) \bmod m$

[[17.Hashing4GraphsIntro.pdf#page=38|Proof]]

### Performance

**Claim**: For $n$ items, in a table of size $m$, assuming uniform hashing, the expected cost of an operation is:
$$
\frac{1}{1-\alpha}
$$

[[17.Hashing4GraphsIntro.pdf#page=45|Proof]]

[[17.Hashing4GraphsIntro.pdf#page=55|Advantages & Disadvantages]]
