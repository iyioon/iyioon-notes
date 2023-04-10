# Dynamic Programming

<span class="right-menu">[Video](https://youtu.be/xSHOtb_RAJE) [[22.DynamicProgrammingIntro.pdf\|PDF]]</span>

## Basics

> [[22.DynamicProgrammingIntro.pdf\|PDF]] Optimal solution can be constructed from optimal solutions to smaller sub-problems

**Overlapping sub-problems:** The same smaller problem is used to solve multiple different bigger problems.

![[22 Dynamic Programming Basics.png|500]]

### Basic Strategy: Bottom up dynamic programming

![[22 Dynamic Programming Bottom up.png|500]]

### Basic Strategy: Top down dynamic programming

![[22 Dynamic Programming Top down.png|500]]


These are just brief concepts. We will understand them with various examples in the upcoming sections.

- [[#Longest Increasing Subsequence]]
- [[#Bounded Prize Collecting]]
- [[#Vertex Cover on a Tree]]
- [[#All-Pairs Shortest Paths]]

## Longest Increasing Subsequence

> [[22.DynamicProgrammingIntro.pdf#page=20]]

**Problem:**. You are give an sequence of integers. Your goal is to find the increasing subsequence of maximum length.

<span class="center-menu">{8,<font style="color:#FF0000">3</font>,6,<font style="color:#FF0000">4</font>,<font style="color:#FF0000">5</font>,<font style="color:#FF0000">7</font>,7} </span>

### DAG Solution

> One way to find such maximum length is with [[17 Graphs#Directed Acyclic Graphs\|DAG]]. 

For each nodes, draw a directed array to any other nodes with greater value.

![[22 Dynamic Programming LIS DAG.png|400]]

**STEP 1:** Topological sort
**STEP 2:**  Calculate longest path - DAG_SSSP. LIS = max(LP)+1
**Performance:** Longest path takes $O(V+E)=O(n^2)$ , Run longest path $n$ times $O(n^3)$

This is inefficient. We don't have to run it n times because to find the maximum path for a node, the maximum path for other connected node have to be solved. This is a example of a overlapping subproblems.

### Using a bottom up approach

Start with the smallest sub-problem:

![[22 Dynamic Programming.png|500]]

Move to the next node and examine all outgoing edges and find the maximum. Its largest path will be 1 +  the maximum of the outgoing edge:

![[22 Dynamic Programming-1.png|450]]

Continue for all nodes:

![[22 Dynamic Programming-2.png|500]]

Performance: $O(n^2)$

### Dynamic Programming Recipe

In summary the dynamic programming recipe consist of the following steps:

- **Step 1:** Identify optimal substructure
	- E.g, LIS can be built from suffix LIS
- **Step 2:** Define sub-problems
	- E.g., $S[i]=\operatorname{LIS}(A[i . . n])$ starting at $A[i]$
- **Step 3:** Solve problem using sub-problems
	- E.g., $S[i]=\left(\max _{(i, j) \in E} S[j]\right)+1$
- **Step 4:** Write (pseudo)code
	- E.g. [[22.DynamicProgrammingIntro.pdf#page=46|Code]]
## Bounded Prize Collecting


## Vertex Cover on a Tree

## All-Pairs Shortest Paths

