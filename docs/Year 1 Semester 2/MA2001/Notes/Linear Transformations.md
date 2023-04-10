# Linear Transformations

## Linear Transformations from $\mathbb{R}^n \text{ to } \mathbb{R}^m$

**Definition:** [[MA2001-Chapter7.pdf#page=2]]. [[MA2001-Chapter7.pdf#page=3\|Example]]

**Key points**:

- Linear transformation
- Linear operator
- Standard matrix (unique)
- Identity transformation
- Identity operator
- Zero transformation

[[MA2001-Chapter7.pdf#page=4\|Example]]

### Linearity

To show that a mapping $T$ is not a linear transformation. [[MA2001-Chapter7.pdf#page=6\|Example]]

- Show that $T(0) \neq 0$; or
- Find $v \in \mathbb{R}^n, c \in \mathbb{R}$ such that $T(c v) \neq c T(v)$; or
- Find $\boldsymbol{u}, \boldsymbol{v} \in \mathbb{R}^n$ such that $T(\boldsymbol{u}+\boldsymbol{v}) \neq T(\boldsymbol{u})+T(\boldsymbol{v})$.

[[MA2001-Chapter7.pdf#page=5]] 

### Representation

[[MA2001-Chapter7.pdf#page=7]]

$$
T\left(\left(\begin{array}{l}
1 \\
0
\end{array}\right)\right)=\left(\begin{array}{l}
1 \\
2 \\
3
\end{array}\right), T\left(\left(\begin{array}{l}
0 \\
1
\end{array}\right)\right)=\left(\begin{array}{l}
4 \\
5 \\
6
\end{array}\right)
$$
The standard matrix for $T$ is $\left(\begin{array}{ll}1 & 4 \\ 2 & 5 \\ 3 & 6\end{array}\right)$.

[[MA2001-Chapter7.pdf#page=8]]

**General Definition**. Let $V$ and $W$ be vector spaces.

- A mapping $T: V \rightarrow W$ is a linear transformation if
$$
T(c u+d v)=c T(u)+d T(v)
$$
- for all $\boldsymbol{u}, \boldsymbol{v} \in \mathbb{R}^n$ and $c, d \in \mathbb{R}$.

Obtaining the standard matrix using v. [[MA2001-Chapter7.pdf#page=9|Example]]. This is a long method. It can be done in a simpler method (Changes of Bases).

### Change of Bases

[[MA2001-Chapter7.pdf#page=12]]

Use of Diagonalization: [[MA2001-Chapter7.pdf#page=13]]

### Composition

[[MA2001-Chapter7.pdf#page=14]]

