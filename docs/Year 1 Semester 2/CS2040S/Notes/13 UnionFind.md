# UnionFind

<span class="center-menu">[Video](https://www.youtube.com/watch?v=se_Ty3xSSSw&t=270s)</span>

| Algorithm                            | Find        | Union       |
| ------------------------------------ | ----------- | ----------- |
| quick-find                           | $O(1)$      | $O(n)$      |
| quick-union                          | $O(n)$      | $O(n)$      |
| weighted-union                       | $O(\log n)$ | $O(\log n)$ |
| path compression                     | $O(\log n)$ | $O(\log n)$            |
| weighted-union with path compression |  $\alpha(m,n)$           | $\alpha(m,n)$            |
## Dynamic Connectivity

Given a set of objects:

- Union: connect two objects
- Find: is there a path connecting the two objects?

visit [[13.UnionFind.pdf#page=12]]

## Quick Find

visit [[13.UnionFind.pdf#page=23]]

## Quick Union

visit [[13.UnionFind.pdf#page=34]]
## Weighted Union

Which tree should we make the root? Use the one with bigger size(weight) as the root. 

Resulting in maximum depth: $O(\log n)$. Explanation [[13.UnionFind.pdf#page=83]]

Running time: $O(\log n)$ to find parent. $O(1)$ merge.


## Path Compression

After find the root: set the parent of each traversed node to the root.

visit [[13.UnionFind.pdf#page=97]]
