# Lecture 13 Trees
---
# 10.5 Trees

## Definition: Tree

(The graph is assumed to be undirected here.)

- A **graph** is said to be **circuit-free** if and only if it has no circuits.
- A graph is called a **tree** if and only if it is circuit-free and connected.
- A **trivial tree** is a graph that consists of a single vertex.
- A graph is called a **forest** if and only if it is circuit-free and not connected.

## <mark style="background: #FF5582A6;">Lemma 10.5.1</mark>

> Any non-trivial tree has at least one vertex of degree 1.
> [[Proofs#Lemma 10.5.1|Proof]]

## Terminal vertex (leaf) and internal vertex

Let $T$ be a tree. If $T$ has only one or two vertices, then each is called a terminal vertex (or leaf). If $T$ has at least three vertices, then a vertex of degree 1 in $T$ is called a terminal vertex (or leaf), and a vertex of degree greater than 1 in $T$ is called an internal vertex.

## <mark style="background: #FF5582A6;">Theorem 10.5.2</mark>

> Any tree with $n$ vertices $(n>0)$ has $n-1$ edges.
> [[Proofs#Theorem 10.5.2|Proof]]

## <mark style="background: #FF5582A6;">Lemma 10.5.3</mark>

>If $G$ is any connected graph, $C$ is any circuit in $G$, and one of the edges of $C$ is removed from $G$, then the graph that remains is still connected.

Essentially, the reason why Lemma $10.5 .3$ is true is that any two vertices in a circuit are connected by <u>2 distinct paths</u>. It is possible to draw the graph so that one of these goes "clockwise" and the other goes "counter-clockwise" around the circuit.

## <mark style="background: #FF5582A6;">Theorem 10.5.4</mark>

> If $G$ is a connected graph with $n$ vertices and $n-1$ edges, then $G$ is a tree.
> [[Proofs#Theorem 10.5.4|Proof]]

# 10.6 Rooted Tress

## Definitions: Rooted Tree, Level, Height

- A **rooted tree** is a tree in which there is one vertex that is distinguished from the others and is called the root.
- The **level** of a vertex is the number of edges along the unique path between it and the **root**.
- The **height** of a rooted tree is the maximum level of any vertex of the tree.

## Definitions: Child, Parent, Sibling, Ancestor, Descendant

Given the root or any internal vertex $v$ of a rooted tree, the children of $v$ are all those vertices that are adjacent to $v$ and are one level farther away from the root than $v$.

If $w$ is a child of $v$, then $v$ is called the **parent** of $w$, and two distinct vertices that are both children of the same parent are called **siblings**.

Given two distinct vertices $v$ and $w$, if $v$ lies on the unique path between $w$ and the root, then $v$ is an **ancestor** of $w$, and $w$ is a **descendant** of $v$.

## Binary Trees

### Definitions: Binary Tree, Full Binary Tree

A **binary tree** is a rooted tree in which every parent has at most two children. Each child is designated either a **left child** or a **right child** (but not both), and every parent has at most one left child and one right child. 

A **full binary tree** is a binary tree in which each parent has exactly two children.

### Definitions: Left Subtree, Right Subtree

Given any parent $v$ in a binary tree $T$, if $v$ has a left child, then the **left subtree** of $v$ is the binary tree whose root is the left child of $v$, whose vertices consist of the left child of $v$ and all its descendants, and whose edges consist of all those edges of $T$ that connect the vertices of the left subtree.

The **right subtree** of $v$ is defined analogously.

### <mark style="background: #FF5582A6;">Theorem 10.6.1: Full Binary Tree Theorem</mark>

If $T$ is a full binary tree with $k$ internal vertices, then $T$ has a total of $2 k+1$ vertices and has $k+1$ terminal vertices (leaves).
[[Proofs#Theorem 10.6.1: Full Binary Tree Theorem|Proof]]

### <mark style="background: #FF5582A6;">Theorem 10.6.2</mark>

For non-negative integers $h$, if $T$ is any binary tree with height $h$ and $t$ terminal vertices (leaves), then
$$
t \leq 2^h
$$
Equivalently,
$$
\log _2 t \leq h
$$
This theorem says that the maximum number of terminal vertices (leaves) of a binary tree of height $h$ is $2^h$. Alternatively, a binary tree with $t$ terminal vertices (leaves) has height of at least $\log _2 t$.
[[Proofs#Theorem 10.6.2|Proof]]

## Binary Tree Traversal

### Breadth-First Search

it starts at the  root and visits its adjacent vertices, and then moves to the next level.

![[Lecture 13 Trees Pre-order Traversal.png|c|300]]
### Breadth-First Search (Preorder, Inorder, Postorder)

![[Lecture 13 Trees Breath first search.png|c|400]]



# 10.7 Spanning Trees and Shortest Paths

## Spanning Tree

A spanning tree for a graph $G$ is a subgraph of $G$ that contains every vertex of $G$ and is a tree.

![[Lecture 13 Trees Spanning Tree.png|c|300]]

### <mark style="background: #FF5582A6;">Proposition 10.7.1</mark>

1. Every connected graph has a spanning tree.
2. Any two spanning trees for a graph have the same number of edges.

## Weighted Graph, Minimum Spanning Tree

A **weighted graph** is a graph for which each edge has an associated positive real number **weight** . The sum of the weights of all the edges is the **total weight** of the graph.

A **minimum spanning tree** for a connected weighted graph is a spanning tree that has the least possible total weight compared to all other spanning trees for the graph.

If $G$ is a weighted graph and $e$ is an edge of $G$, then $\boldsymbol{w}(\boldsymbol{e})$ denotes the weight of $e$ and $\boldsymbol{w}(\boldsymbol{G})$ denotes the total weight of $G$.

![[Lecture 13 Trees.png|c|200]]
The graph of the routes allowed by the Federal Aviation Authority shown in Figure can be annotated by adding the distances (in miles) between each pair of cities. This is called a weighted graph.

## Kruskal’s Algorithm

In Kruskal’s algorithm, the edges of a connected weighted graph are examined one by one in order of increasing weight. At each stage the edge being examined is added to what will become the minimum spanning tree, provided that this addition does not create a circuit. After n – 1 edges have been added (where n is the number of vertices of the graph), these edges, together with the vertices of the graph, form a minimum spanning tree for the graph.

Input: G a connected weighted graph with n vertices
Algorithm:  
1. Initialize T to have all the vertices of G and no edges.  
2. Let E be the set of all edges of G, and let m = 0.  
3. While (m < n – 1)  
	1. Find an edge e in E of least weight.  
	2. Delete e from E.  
	3. If addition of e to the edge set of T does not produce a circuit, then add e to the edge set of T and set m = m + 1  
4. End while

Output: T T is a minimum spanning tree for G

When Kruskal's algorithm is used on a graph in which some edges have the same weight as others, more than one minimum spanning tree can occur as output.

To make the output unique, the edges of the graph can be placed in an array and edges having the same weight can be added in the order they appear in the array.

## Prim’s Algorithm

Algorithm 10.7.2 Prim
Input: $G$ a connected weighted graph with $n$ vertices
Algorithm:
1. Pick a vertex $v$ of $G$ and let $T$ be the graph with this vertex only.
2. Let $V$ be the set of all vertices of $G$ except $v$.
3. For $i=1$ to $n-1$
	1. Find an edge $e$ of $G$ such that (1) $e$ connects $T$ to one of the vertices in $V$, and (2) $e$ has the least weight of all edges connecting $T$ to a vertex in $V$. Let $w$ be the endpoint of $e$ that is in $V$.
	2. Add $e$ and $w$ to the edge and vertex sets of $T$, and delete $w$ from $V$.

Output: $T$ $T$ is a minimum spanning tree for $G$