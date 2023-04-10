# MST

<span class="right-menu">[Video](https://youtu.be/q6jNykN7ybM) [[21.MST.pdf\|PDF]]
</span>
## Definition

**Spanning tree:**. Acyclic subset of the edges that connects all nodes. [[21.MST.pdf#page=5\|Diagram]]

**minimum spanning tree:** Is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. That is, it is a spanning tree whose sum of edge weights is as small as possible.
## Properties

> [[21.MST.pdf#page=16\|PDF]]

1. No cycles: Acyclic
2. If you cut an MST, the two pieces are both MSTs.
3. Cycle property
	- For every cycle, the maximum weight edge is not in the MST.
	- Note that smallest edge will not always be in the MST.
4. Cut property
	- For every partition of the nodes, the minimum weight edge across the cut is in the MST.
	- In other words, for all outgoing edge of a vertex, the minimum edges will be in the MST
## Generic MST Algorithm

> [[21.MST.pdf#page=55\|PDF]]

**<font style="color:#FF0000">Red</font> rule:** If C is a cycle with no red arcs, then color the max-weight edge in C red.
**<font style="color:#3258a8">Blue</font> rule:** If D is a cut with no blue arcs, then color the min-weight edge in D blue.

Apply red rule or blue rule to an arbitrary edge until no more edges can be colored.

## Prim's Algorithm

> [[21.MST.pdf#page=71\|PDF]]

Algorithm to find the minimum spanning tree using property 4:

- Start with vertex. Add it to the set. 
- Find the minimum weight outgoing edge in the set to the remaining vertices. Add the vertex to the set
- Repeat until all vertex is added.

**Data structure**: Priority queue.  [[21.MST.pdf#page=81\|PDF]]
**Time Complexity:** $O(E\log V)$  [[21.MST.pdf#page=99\|PDF]]
## Kruskal's Algorithm

> [[21.MST.pdf#page=103\|PDF]]

Algorithm to find the minimum spanning tree using property 3,4:

Sort the edges by ascending weights.
Beginning with the smallest weight edge, for each edge:
- If the two vertices are not in the same set, union the two vertices.
- If the two vertices are already in the same set, don't add.

**Data structure**: Union-Find

**Performance:**  [[21.MST.pdf#page=124\|PDF]]

- Sorting: $O(E \log E)=O(E \log V)$
- For E edges:
- Find: $O(\alpha(n))$ or $O(\log V)$
- Union: $O(\alpha(n))$ or $O(\log V)$

## Directed Minimum Spanning Tree

> [[21.MST.pdf#page=141\|PDF]]

## Maximum Spanning Tree 

1. Multiply each edge weight by -1 .
2. Run MST algorithm.
3. MST that is "most negative" is the maximum.