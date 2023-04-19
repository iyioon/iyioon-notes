# Linear Transformations

## Linear Transformations from $\mathbb{R}^n \text{ to } \mathbb{R}^m$

**Definition:** [PDF](MA2001-Chapter7.pdf#page=2). [Example](MA2001-Chapter7.pdf#page=3%5C%7CExample)

**Key points**:

- Linear transformation
- Linear operator
- Standard matrix (unique)
- Identity transformation
- Identity operator
- Zero transformation

[Example](MA2001-Chapter7.pdf#page=4%5C%7CExample)

### Linearity

To show that a mapping $T$ is not a linear transformation. [Example](MA2001-Chapter7.pdf#page=6%5C%7CExample)

- Show that $T(0) \neq 0$; or
- Find $v \in \mathbb{R}^n, c \in \mathbb{R}$ such that $T(c v) \neq c T(v)$; or
- Find $\boldsymbol{u}, \boldsymbol{v} \in \mathbb{R}^n$ such that $T(\boldsymbol{u}+\boldsymbol{v}) \neq T(\boldsymbol{u})+T(\boldsymbol{v})$.

[PDF](MA2001-Chapter7.pdf#page=5) 

### Representation

[PDF](MA2001-Chapter7.pdf#page=7)

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

[PDF](MA2001-Chapter7.pdf#page=8)

**General Definition**. Let $V$ and $W$ be vector spaces.

- A mapping $T: V \rightarrow W$ is a linear transformation if
$$
T(c u+d v)=c T(u)+d T(v)
$$
- for all $\boldsymbol{u}, \boldsymbol{v} \in \mathbb{R}^n$ and $c, d \in \mathbb{R}$.

Obtaining the standard matrix using v. [Example](MA2001-Chapter7.pdf#page=9%7CExample). This is a long method. It can be done in a simpler method (Changes of Bases).

### Change of Bases

[PDF](MA2001-Chapter7.pdf#page=12)

Use of Diagonalization: [PDF](MA2001-Chapter7.pdf#page=13)

### Composition

[PDF](MA2001-Chapter7.pdf#page=14)

---
## Ranges and Kernels

### Range of Linear Transformation

[PDF](MA2001-Chapter7.pdf#page=20)
Let $T: \mathbb{R}^n \rightarrow \mathbb{R}^m$ be a linear transformation. The range of $T$ is the set of all images of $T$ :

- $\mathrm{R}(T)=\left\{T(v) \mid v \in \mathbb{R}^n\right\} \subseteq \mathbb{R}^m$

**How to determine the rage of $T$?** [PDF](MA2001-Chapter7.pdf#page=22)

- The rage is given by $\mathrm{R}(T)=\operatorname{span}\left\{T\left(\boldsymbol{v}_1\right), \ldots, T\left(\boldsymbol{v}_n\right)\right\}$
  where $\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_n\right\}$ is any basis for $\mathbb{R}^n$.
- In particular. $R(T)$ is a subspace of $\mathbb{R}^m$.
- $R(T)=$ column space of $A$ (standard matrix)

**Dimension of $R(T)$:** [PDF](MA2001-Chapter7.pdf#page=23)

- $\operatorname{rank}(T)=\operatorname{dim} \mathrm{R}(T)$

[Complex Examples](MA2001-Chapter7.pdf#page=24)

### Kernel of Linear Transformation

- Let $T: \mathbb{R}^n \rightarrow \mathbb{R}^m$ be a linear transformation.
- The **kernel** of $T$ is the set of all vectors in $\mathbb{R}^n$ whose image is the zero vector in $\mathbb{R}^m$.
- $\operatorname{Ker}(T)=\left\{\boldsymbol{v} \in \mathbb{R}^n \mid T(v)=\boldsymbol{v}\right\} \subseteq \mathbb{R}^n$
- Recall that $T(0)=0$.
	- $\operatorname{Ker}(T)$ contains the zero vector in $\mathbb{R}^n$.
- [PDF](MA2001-Chapter7.pdf#page=25)

**Theorem:** Let $T: \mathbb{R}^n \rightarrow \mathbb{R}^m$ be a linear transformation and $\boldsymbol{A}$ the standard matrix for $T$. $\operatorname{Ker}(T)=$ nullspace of $\boldsymbol{A}$. [PDF](MA2001-Chapter7.pdf#page=28)

- The nullity of $T$ is defined as the dimension of $\operatorname{Ker}(T)$. $\operatorname{nullity}(T)=\operatorname{dim} \operatorname{Ker}(T)$ $=\operatorname{nullity}(\boldsymbol{A})$.

### Properties

We have proved that

1. $\mathrm{R}(T)=$ column space of $\boldsymbol{A}$.
	- $\operatorname{rank}(T)=\operatorname{rank}(\boldsymbol{A})$.
1. $\operatorname{Ker}(T)=$ nullspace of $\boldsymbol{A}$.
	- $\operatorname{nullity}(T)=\operatorname{nullity}(\boldsymbol{A})$.

Recall Dimension Theorem for Matrices. Let $T: \mathbb{R}^n \rightarrow \mathbb{R}^m$ be a linear transformation. Then

- $\operatorname{rank}(T)+\operatorname{nullity}(T)=n$.

