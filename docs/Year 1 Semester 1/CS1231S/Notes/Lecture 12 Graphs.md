# 10.1 Definitions and Basic Properties

**Definition 1**. If $G$ is a simple graph, the complement of $G$, denoted $\bar{G}$, is obtained as follows: the vertex set of $\bar{G}$ is identical to the vertex set of $G$. However, two distinct vertices $v$ and $w$ of $\bar{G}$ are connected by an edge if and only if $v$ and $w$ are not connected by an edge in $G$.
![c|200](../Attachment/Lecture%2012%20Graphs-4.png)

**Definition 2**. A self-complementary graph is isomorphic with its complement.
**Definition 3**. A simple circuit (cycle) of length three is called a triangle.
**Lemma 10.5.5**. Let $G$ be a simple, undirected graph. Then if there are two distinct paths from a vertex $v$ to a different vertex $w$, then $G$ contains a cycle (and hence $G$ is cyclic).

## Undirected Graph

An **undirected graph** is denoted by $G=(V, E)$ where
- $V=\left\{v_1, v_2, \cdots, v_n\right\}$ is the set of **vertices** (or **nodes**) in $G$; and
- $E=\left\{e_1, e_2, \cdots, e_k\right\}$ is the set of (undirected) **edges** in $G$.
- An (undirected) edge $e$ connecting $v_i$ and $v_j$ is denoted as $e=\left\{v_i, v_j\right\}$.


![600](../Attachment/Lecture%2012%20Graphs.png)
>An undirected **graph** $G$ consists of 2 finite sets: a nonempty set $V$ of **vertices** and a set $E$ of **edges**, where each (undirected) edge is associated with a set consisting of either one or two vertices called its **endpoints**.
>
>An edge is said to **connect** its endpoints; two vertices that are connected by an edge are called **adjacent vertices**; and a vertex that is an endpoint of a loop is said to be **adjacent to itself**.
>An edge is said to be **incident on** each of its endpoints, and two edges incident on the same endpoint are called **adjacent edges**.
>We write $e=\{v, w\}$ for an undirected edge $e$ incident on vertices $v$ and $w$

## Directed Graph

>A directed graph, or digraph, $G$, consists of 2 finite sets: a nonempty set $V$ of vertices and a set $E$ of directed edges, where each (directed) edge is associated with an ordered pair of vertices called its endpoints.
>We write $e=(v, w)$ for a directed edge $e$ from vertex $v$ to vertex $w$

![200](../Attachment/Lecture%2012%20Graphs%20Directed%20graph.png)
## Simple Graph

>A simple graph is an undirected graph that does not have any loops or parallel edges. (That is, there is at most one edge between each pair of distinct vertices.)

**Definition** 1. If $G$ is a simple graph, the **complement** of $G$, denoted $\bar{G}$, is obtained as follows: the vertex set of $\bar{G}$ is identical to the vertex set of $G$. However, two distinct vertices $v$ and $w$ of $\bar{G}$ are connected by an edge if and only if $v$ and $w$ are not connected by an edge in $G$.

## Complete Graph

>A complete graph on $n$ vertices, $n>0$, denoted $K_n$, is a simple graph with $n$ vertices and exactly one edge connecting each pair of distinct vertices.

![300](../Attachment/Lecture%2012%20Graphs%20Complete%20Graph.png)
## Bipartite Graph

>A bipartite graph (or bigraph) is a simple graph whose vertices can be divided into two disjoint sets $U$ and $V$ such that every edge connects a vertex in $U$ to one in $V$. 

![100](../Attachment/Lecture%2012%20Graphs%20Bipartite%20Graphs.png)

## Complete Bipartite Graph 

>A complete bipartite graph is a bipartite graph on two disjoint sets $U$ and $V$ such that every vertex in $U$ connects to every vertex in $V$.
>If $|U|=m$ and $|V|=n$, the complete bipartite graph is denoted as $K_{m, n}$

## Subgraph of a Graph 

>A graph $H$ is said to be a subgraph of graph $G$ if and only if every vertex in $H$ is also a vertex in $G$, every edge in $H$ is also an edge in $G$, and every edge in $H$ has the same endpoints as it has in $G$.

![300](../Attachment/Lecture%2012%20Graphs%20Subgraph.png)
## Degree of a vertex and total degree of an undirected graph

>Let $G$ be a undirected graph and $v$ a vertex of $G$. The **degree** of $v$, denoted $\boldsymbol{\operatorname{deg}(\boldsymbol{v}})$, equals the number of edges that are incident on $v$, with an edge that is a loop counted twice.
>The **total degree of** $\boldsymbol{G}$ is the sum of the degrees of all the vertices of $G$

![200](../Attachment/Lecture%2012%20Graphs%20Degree%20of%20vertex.png)
## <mark style="background: #FF5582A6;">Theorem 10.1.1 The handshake Theorem</mark>

>If $G$ is any graph, then the sum of the degrees of all the vertices $G$ equals twice the number of edges of $G$. Specifically, if the vertices of $G$ are $v_1, v_2, \ldots, v_n$, where $n \geq 0$, then
>
>The total degree of $G=\operatorname{deg}\left(v_1\right)+\operatorname{deg}\left(v_2\right)+\ldots+\operatorname{deg}\left(v_n\right)$ $=2 \times($ the number of edges of $G$ ).
>
### <mark style="background: #FF5582A6;">Corollary 10.1.2</mark>

>The total degree of a graph is even
>

### <mark style="background: #FF5582A6;">Proposition 10.1.3</mark>

>In any graph there are an even number of vertices of odd degree.

## Indegree and outdegree of a Vertex of a Directed Graph

>Let $G=(V, E)$ be a directed graph and $v$ a vertex of $G$. The **indegree** of $v$, denoted $\operatorname{deg}^{-}(\boldsymbol{v})$, is the number of directed edges that end at $v$. The **outdegree** of $v$, denoted $\operatorname{deg}^{+}(v)$, is the number of directed edges that originate from $v$.
>Note that $\sum_{v \in V} d e g^{-}(v)=\sum_{v \in V} d e g^{+}(v)=|E|$

![300](../Attachment/Lecture%2012%20Graphs%20Indegree%20and%20Outdegree.png)

# 10.2 Trails, Paths, and Circuits

## Walk, Trail, Path, Closed Walk, Circuit, Simple Circuit

Let $G$ be a graph, and let $v$ and $w$ be vertices of $G$.
**A walk from $v$ to $w$** is a finite alternating sequence of adjacent vertices and edges of $G$. Thus a walk has the form
$$
v_0 e_1 v_1 e_2 \ldots v_{n-1} e_n v_n \text {, }
$$
where the $v^{\prime}$ 's represent vertices, the $e^{\prime}$ s represent edges, $v_0=v, v_n=w$, and for all $i \in\{1,2, \ldots, n\}, v_{i-1}$ and $v_i$ are the endpoints of $e_i$. The number of edges, $n$, is the length of the walk.

**Trivial walk** from $v$ to $v$ consists of the single vertex $v$.
**A trail from $v$ to $w$** is a walk from $v$ to $w$ that does not contain a repeated edge.
**A path from $v$ to $w$** is a trail that does not contain a repeated vertex.

A **closed walk** is a walk that starts and ends at the same vertex.
A **circuit** (or **cycle**) is a closed walk of length at least 3 that does not contain a repeated edge.

A **simple circuit** (or simple cycle) is a circuit that does not have any other repeated vertex except the first and last.
An undirected graph is **cyclic** if it contains a loop or a cycle; otherwise, it is **acyclic**.

## Connectedness

>Two vertices $v$ and $w$ of a graph $G=(V, E)$ are connected if and only if there is a walk from $v$ to $w$.
>
>The graph $G$ is connected if and only if given any two vertices $v$ and $w$ in $G$, there is a walk from $v$ to $w$. Symbolically,
>$G$ is connected iff $\forall$ vertices $v, w \in V, \exists$ a walk from $v$ to $w$.

## <mark style="background: #FF5582A6;">Lemma 10.2.1</mark>

>Let $G$ be a graph.
>a. If $G$ is connected, then any two distinct vertices of $G$ can be connected by a path.
>b. If vertices $v$ and $w$ are part of a circuit in $G$ and one edge is removed from the circuit, then there still exists a trail from $v$ to $w$ in $G$.
>c. If $G$ is connected and $G$ contains a circuit, then an edge of the circuit can be removed without disconnecting $G$.

## Connected Component

A graph $H$ is a connected component of a graph $G$ if and only if
1. The graph $H$ is a subgraph of $G$;
2. The graph $\mathrm{H}$ is connected; and
3. No connected subgraph of $G$ has $H$ as a subgraph and contains vertices or edges that are not in $\mathrm{H}$.

## Euler Circuits

>Let $G$ be a graph. An Euler circuit for $G$ is a circuit that contains every vertex and traverses every edge of $G$ exactly once.

## Eulerian Graph

> An Eulerian graph is a graph that contains an Euler circuit

## <mark style="background: #FF5582A6;">Theorem 10.2.2</mark>

> If a graph has a Euler circuit, then every vertex of the graph has positive even degree
> 
> **Contrapositive**: If some vertex of a graph has odd degree, then the graph does not have an Euler circuit

## <mark style="background: #FF5582A6;">Theorem 10.2.3</mark>

> If a graph $G$ is <u>connected</u>  and the degree of every vertex of $G$ is a positive <u>even integer</u>, then $G$ has an Euler circuit.

## <mark style="background: #FF5582A6;">Theorem 10.2.4</mark>

> A graph $G$ has an Euler circuit if and only if $G$ is connected and every vertex of $G$ has positive even degree.

## Euler Trail

>Let $G$ be a graph, and let $v$ and $w$ be two distinct vertices of $G$. An Euler trail/path from $v$ to $w$ is a sequence of adjacent edges and vertices that starts at $v$, ends at $w$, passes through every vertex of $G$ at least once, and traverses every edge of $G$ exactly once.

## <mark style="background: #FF5582A6;">Corollary 10.2.5</mark>

>Let $G$ be a graph, and let $v$ and $w$ be two distinct vertices of $G$. There is an Euler trail from $v$ to $w$ if and only if $G$ is connected, $v$ and $w$ have odd degree, and all other vertices of $G$ have positive even degree.

## <mark style="background: #FF5582A6;">Hamiltonian Circuit</mark>

>Given a graph $G$, a Hamiltonian circuit for $G$ is a simple circuit that includes every vertex of $G$. (That is, every vertex appears exactly once, except for the first and the last, which are the same.)

## <mark style="background: #FF5582A6;">Hamiltonian Graph</mark>

>A Hamiltonian graph (also called Hamilton graph) is a graph that contains a Hamiltonian circuit.

## <mark style="background: #FF5582A6;">Proposition 10.2.6</mark>

If a graph $G$ has a Hamiltonian circuit, then $G$ has a subgraph $H$ with the following properties:
1. $H$ contains every vertex of $G$.
2. $H$ is connected.
3. $H$ has the same number of edges as vertices.
4. Every vertex of $H$ has degree 2 .


# 10.3 Matrix representations of Graphs

## Matrix
> An $m \times n$ (read " $m$ by $n^{\prime \prime}$ ) matrix A over a set $S$ is a rectangular array of elements of $S$ arranged into $m$ rows and $n$ columns.
> We write $\mathbf{A}=\left(a_{i j}\right) \text {. }$

## Matrices and Directed Graphs

![c|500](../Attachment/Lecture%2012%20Graphs-1.png)
>Let $G$ be a directed graph with ordered vertices $v_1, v_2, \ldots v_n$. The adjacency matrix of $\boldsymbol{G}$ is the $n \times n$ matrix $\mathbf{A}=\left(a_{i j}\right)$ over the set of non-negative integers such that
>$a_{i j}=$ the number of arrows from $v_i$ to $v_j$ for all $i, j=1,2, \ldots, n$.

## Matrices and Undirected Graphs

>Let $G$ be an undirected graph with ordered vertices $v_1, v_2, \ldots v_n$. The adjacency matrix of $\boldsymbol{G}$ is the $n \times n$ matrix $\mathbf{A}=\left(a_{i j}\right)$ over the set of nonnegative integers such that
>$a_{i j}=$ the number of edges connecting $v_i$ and $v_j$ for all $i, j=1,2, \ldots, n$.

![c|400](../Attachment/Lecture%2012%20Graphs-2.png)
## Symmetric Matrix

> An $n \times n$ square matrix $\mathrm{A}=\left(a_{i j}\right)$ is called symmetric if, and only if, $a_{i j}=a_{j i}$ for all $i, j=1,2, \ldots, n$.

## Identity Matrix

For each positive integer $n$, the $n \times n$ identity matrix, denoted $I_n=\left(\delta_{i j}\right)$ or just I (if the size of the matrix is obvious from context), is the $n \times n$ matrix in which all the entries in the main diagonal are 1's and all other entries are 0's. In other words,
$$
\delta_{i j}=\left\{\begin{array}{ll}
1, & \text { if } i=j \\
0, & \text { if } i \neq j
\end{array} \quad \text { for all } i, j=1,2, \ldots, n\right.
$$

## $n^{th}$ Power of a Matrix

>For any $n \times n$ matrix $\mathbf{A}$, the powers of $\mathbf{A}$ are defined as follows:
>$\mathbf{A}^0=\mathbf{I}$ where $\mathbf{I}$ is the $n \times n$ identity matrix
>$\mathbf{A}^n=\mathbf{A ~ A}^{n-1}$ for all integers $n \geq 1$


## <mark style="background: #FF5582A6;">Theorem 10.3.2</mark> Counting Walks of Length $N$

>If $G$ is a graph with vertices $v_1, v_2, \ldots, v_m$ and $\mathbf{A}$ is the adjacency matrix of $G$, then for each positive integer $n$ and for all integers $i, j$ $=1,2, \ldots, m$
>the $i j$-th entry of $\mathbf{A}^n=$ the number of walks of length $n$ from $v_i$ to $v_j$.

# 10.4 Isomorphisms of Graphs/Planar Graphs

## Isomorphism of Graphs

>Let $G=\left(V_G, E_G\right)$ and $G^{\prime}=\left(V_{G^{\prime}}, E_{G \prime}\right)$ be two graphs.
>$G$ is isomorphic to $G^{\prime}$, denoted $G \cong G^{\prime}$, if and only if there exist bijections $g: V_G \rightarrow V_{G^{\prime}}$ and $h: E_G \rightarrow E_{G^{\prime}}$ that preserve the edge-endpoint functions of $G$ and $G^{\prime}$ in the sense that for all $v \in V_G$ and $e \in E_G$,
>$v$ is an endpoint of $e \Leftrightarrow g(v)$ is an endpoint of $h(e)$.

Alternative definition
Let $G=\left(V_G, E_G\right)$ and $G^{\prime}=\left(V_{G^{\prime}}, E_G\right)$ be two graphs.
$\boldsymbol{G}$ is isomorphic to $\boldsymbol{G}^{\prime}$ if and only if there exists a permutation $\pi: V_G \rightarrow V_{G^{\prime}}$ such that $\{u, v\} \in E_G \Leftrightarrow\{\pi(u), \pi(v)\} \in E_{G \prime}$

![c|300](../Attachment/Lecture%2012%20Graphs%20Isomorphic.png)

### <mark style="background: #FF5582A6;">Theorem 10.4.1 Graph Isomorphism is an Equivalence Relation</mark>

> Let $S$ be a set of graphs and let $\cong$ be the relation of graph isomorphism on $S$. Then $\cong$ is an equivalence relation on $S$.

**Definition** 2. A **self-complementary** graph is isomorphic with its complement.
## Planar Graph

> A planar graph is a graph that can be drawn on a (two-dimensional) plane without edges crossing.

### Kuratowski's Theorem:

>A finite graph is planar if and only if it does not contain a subgraph that is a subdivision of the complete graph $K_5$ or the complete bipartite graph $K_{3,3}$.

![c|200](../Attachment/Lecture%2012%20Graphs%20Kuratowski's%20Theorem.png)


### Euler's Formula

>For a connected planar simple graph $G=(V, E)$ with $e=|E|$ and $v=|V|$, if we let $f$ be the number of faces, then
$$
f=e-v+2
$$
![c|300](../Attachment/Lecture%2012%20Graphs%20Euler's%20Formula.png)

