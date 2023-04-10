# Orthogonality 

<span class="right-menu">[[MA2001-Chapter5.pdf]]</span>

## Angle Between Vectors

Visit [[MA2001-Chapter5.pdf#page=6]]

## Dot Product and Matrix Multiplication

Let $\boldsymbol{u}$ and $\boldsymbol{v}$ be vectors in $\mathbb{R}^n$.

Suppose they are viewed as row vectors:
$$\boldsymbol{u}=\left(u_1, \ldots, u_n\right), \boldsymbol{v}=\left(v_1, \ldots, v_n\right)$$.
$$
\boldsymbol{u} \cdot \boldsymbol{v}=\left(u_1, \ldots, u_n\right)\left(\begin{array}{c}
v_1 \\
\vdots \\
v_n
\end{array}\right)=\boldsymbol{u} \boldsymbol{v}^{\mathrm{T}}
$$
Suppose they are viewed as column vectors:
$$
\boldsymbol{u}=\left(\begin{array}{c}
u_1 \\
\vdots \\
u_n
\end{array}\right), \boldsymbol{v}=\left(\begin{array}{c}
v_1 \\
\vdots \\
v_n
\end{array}\right) \text {. }
$$
$$
\boldsymbol{u} \cdot \boldsymbol{v}=\left(u_1, \ldots, u_n\right)\left(\begin{array}{c}
v_1 \\
\vdots \\
v_n
\end{array}\right)=\boldsymbol{u}^{\mathrm{T}} \boldsymbol{v}
$$

Visit [[MA2001-Chapter5.pdf#page=7]]

### Properties

Visit [[MA2001-Chapter5.pdf#page=8]]

## Orthogonal and Orthonormal Bases 

$S$ is called orthogonal if every pair of distinct vectors in $S$ are orthogonal:

- $\boldsymbol{v}_i \cdot \boldsymbol{v}_j=0$ for all $i \neq j$.

$S$ is called orthonormal if $S$ is orthogonal and every vector in $S$ is a unit vector.

- $\boldsymbol{v}_i \cdot \boldsymbol{v}_j= \begin{cases}0 & \text { if } i \neq j \\ 1 & \text { if } i=j\end{cases}$

If $S$ is orthonormal, then $S$ is orthogonal.
If $S$ is orthogonal, then a subset of $S$ is orthogonal. 
If $S$ is orthonormal, then a subset of $S$ is orthonormal. 
If $S$ is orthogonal, then $S \cup\{\mathbf{0}\}$ is also orthogonal. 
If $S$ is orthonormal, then $0 \notin S$.

Visit [[MA2001-Chapter5.pdf#page=10]]


### Normalizing

The process of converting an orthogonal set of _nonzero_ vectors to an orthonormal set of vectors, $\boldsymbol{u}_i \mapsto \boldsymbol{v}_i=\frac{\boldsymbol{u}_i}{\left\|\boldsymbol{u}_i\right\|}$, is called normalizing.


Visit [[MA2001-Chapter5.pdf#page=10]]

### How to check Orthogonal and Orthonormal

Let $\left\{v_1, \ldots, v_k\right\}$ (column vectors) be a subset of $\mathbb{R}^n$.

Let $\boldsymbol{A}=\left(\begin{array}{lll}\boldsymbol{v}_1 & \cdots & \boldsymbol{v}_k\end{array}\right)$. Then $\boldsymbol{A}^{\mathrm{T}}=\left(\begin{array}{c}\boldsymbol{v}_1^{\mathrm{T}} \\ \vdots \\ \boldsymbol{v}_k^{\mathrm{T}}\end{array}\right)$.

$\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}=\left(\begin{array}{ccc}\boldsymbol{v}_1 \cdot \boldsymbol{v}_1 & \cdots & \boldsymbol{v}_1 \cdot \boldsymbol{v}_k \\ \vdots & \ddots & \vdots \\ \boldsymbol{v}_k \cdot \boldsymbol{v}_1 & \cdots & \boldsymbol{v}_k \cdot \boldsymbol{v}_k\end{array}\right)=\left(\boldsymbol{v}_i \cdot \boldsymbol{v}_j\right)_{k \times k}$.

$\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_k\right\}$ is orthogonal $\Leftrightarrow \boldsymbol{v}_i \cdot \boldsymbol{v}_j=0$ for all $i \neq j$
$\Leftrightarrow \boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}$ is diagonal.

$\begin{aligned}\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_k\right\} \text { is orthonormal } & \Leftrightarrow \boldsymbol{v}_i \cdot \boldsymbol{v}_j= \begin{cases}0 & \text { if } i \neq j \\ 1 & \text { if } i=j,\end{cases} \\ & \Leftrightarrow \boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}=\boldsymbol{I}_k .\end{aligned}$
Identity.

### Linear Independency

**Theorem**. Let $S=\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \ldots, \boldsymbol{v}_k\right\}$ be an orthogonal set of nonzero vectors in $\mathbb{R}^n$.

- Then $S$ is linearly independent.

**Definition**. Let $S$ be a basis for a vector space.

- $S$ is an orthogonal basis if it is orthogonal.
- $S$ is an orthonormal basis if it is orthonormal.


Visit [[MA2001-Chapter5.pdf#page=13]]

### Properties 

What are the advantages of orthogonal basis?

Visit [[MA2001-Chapter5.pdf#page=14]]

### Finding the coordinate vector using orthogonal set

Visit [[MA2001-Chapter5.pdf#page=15]]

## Orthogonality

### How to check if a vector is orthogonal to a spanning set

Visit [[MA2001-Chapter5.pdf#page=17]]

## Projection

Visit [[MA2001-Chapter5.pdf#page=18]]

Theorem. Let $\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \ldots, \boldsymbol{v}_k\right\}$ be an orthonormal basis for a vector space $V$. The projection of $\boldsymbol{w}$ onto $V$ is

$$\left(\boldsymbol{w} \cdot \boldsymbol{v}_1\right) \boldsymbol{v}_1+\left(\boldsymbol{w} \cdot \boldsymbol{v}_2\right) \boldsymbol{v}_2+\cdots+\left(\boldsymbol{w} \cdot \boldsymbol{v}_k\right) \boldsymbol{v}_k$$

Theorem. Let $\left\{\boldsymbol{u}_1, \boldsymbol{u}_2, \ldots, \boldsymbol{u}_k\right\}$ be an orthogonal basis for a vector space $V$. The projection of $\boldsymbol{w}$ onto $V$ is

$$\left(\frac{\boldsymbol{w} \cdot \boldsymbol{u}_1}{\boldsymbol{u}_1 \cdot \boldsymbol{u}_1}\right) \boldsymbol{u}_1+\left(\frac{\boldsymbol{w} \cdot \boldsymbol{u}_2}{\boldsymbol{u}_2 \cdot \boldsymbol{u}_2}\right) \boldsymbol{u}_2+\cdots+\left(\frac{\boldsymbol{w} \cdot \boldsymbol{u}_k}{\boldsymbol{u}_k \cdot \boldsymbol{u}_k}\right) \boldsymbol{u}_k$$

Visit [[MA2001-Chapter5.pdf#page=20]]

## Gram-Schmidt Process

How to find an orthogonal basis for a given vector space? Make sure that the vectors are linearly independent. Otherwise just do the gram-schmidt process and ignore zero vector.

Visit [[MA2001-Chapter5.pdf#page=22]]

## Decomposition

Theorem. Let $\boldsymbol{A}$ be an $m \times n$ matrix whose columns are linearly independent. Then there exist

- An $m \times n$ matrix $\boldsymbol{Q}$ whose columns form an orthonormal set, and
- An invertible $n \times n$ upper triangular matrix $\boldsymbol{R}$

such that $A=Q R$.

Application: Solve linear system $\boldsymbol{A x}=\boldsymbol{b}$.

1. $(\boldsymbol{Q R}) \boldsymbol{x}=\boldsymbol{b}$.
2. $\boldsymbol{Q}^{\mathrm{T}} \boldsymbol{Q} \boldsymbol{R} \boldsymbol{x}=\boldsymbol{Q}^{\mathrm{T}} \boldsymbol{b} \Rightarrow \boldsymbol{R} \boldsymbol{x}=\boldsymbol{Q}^{\mathrm{T}} \boldsymbol{b}$.
3. Solve $\boldsymbol{x}$ by back-substitution.

## Best Approximations

Find the orthogonal basis first. Then use it to calculate P.
Visit [[MA2001-Chapter5.pdf#page=28]]

### Finding the shortest distance from a point and a plane

Visit [[MA2001-Chapter5.pdf#page=29]]

## Least Squares Solution

Finding the best approximation of Ax = b where b is not in V (column space of A).
Visit [[MA2001-Chapter5.pdf#page=30]]
[[MA2001-Chapter5.pdf#page=31|Example]]

Find a least squares solution to $A x=b$ :

1. Find an orthogonal (orthonormal) basis for $V$, the column space of $\boldsymbol{A}$.
2. Find the projection $p$ of $b$ onto $V$.
3. Solve the linear system $\boldsymbol{A x}=\boldsymbol{p}$.

Then a solution to $\boldsymbol{A x}=\boldsymbol{p}$ is a least squares solution to $\boldsymbol{A x}=\boldsymbol{b}$.

- If $\boldsymbol{A x}=\boldsymbol{b}$ is already consistent, what is the least squares solution?
	- $\boldsymbol{b}=\boldsymbol{p} \in V$. Solution = Least squares solution.

[[MA2001-Chapter5.pdf#page=33|Easier method Example]]

Theorem. (Find the least squares solutions)

- $\boldsymbol{u}$ is a least squares solution to $\boldsymbol{A x}=\boldsymbol{b}$
$\Leftrightarrow \boldsymbol{u}$ is a solution to $\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A} \boldsymbol{x}=\boldsymbol{A}^{\mathrm{T}} \boldsymbol{b}$.

This can also be used to find the projection. $\boldsymbol{p}=\boldsymbol{A} \boldsymbol{u}$. [[MA2001-Chapter5.pdf#page=37|Example]]

**In summary:**

$x$ is a LSS to $Ax=b$ **iff** $x$ is a solution to $Ax=p$ (projection) **iff** $x$ is a solution to $A^TAx=A^Tb$
## Orthogonal Matrices

$\boldsymbol{A}$ is an orthogonal matrix
$\Leftrightarrow$ columns of $\boldsymbol{A}$ form an orthonormal basis for $\mathbb{R}^n$.
$\Leftrightarrow$ rows of $\boldsymbol{A}$ form an orthonormal basis for $\mathbb{R}^n$.
$\Leftrightarrow$ $A^T=A^-1$

Advantages: Visit [[MA2001-Chapter5.pdf#page=38]]

Visit [[MA2001-Chapter5.pdf#page=40]]

### Properties

Visit [[MA2001-Chapter5.pdf#page=44]] 

More generally, for any $m \times n$ matrix $\boldsymbol{A}$ :
- $\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}=\boldsymbol{I}_n$
$\Leftrightarrow$ the columns of $\boldsymbol{A}$ form an orthonormal set.
- $\boldsymbol{A} \boldsymbol{A}^{\mathrm{T}}=\boldsymbol{I}_m$
$\Leftrightarrow$ the rows of $\boldsymbol{A}$ form an orthonormal set.

Let $S=\left\{\boldsymbol{u}_1, \ldots, \boldsymbol{u}_k\right\}$ be an orthonormal subset of $\mathbb{R}^n$.
- Let $\boldsymbol{A}=\left(\begin{array}{lll}\boldsymbol{u}_1 & \cdots & \boldsymbol{u}_k\end{array}\right)$. Then $\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}=\boldsymbol{I}_k$.
	- Let $\boldsymbol{P}$ be an $n \times n$ orthogonal matrix.
	  $(\boldsymbol{P} \boldsymbol{A})^{\mathrm{T}}(\boldsymbol{P} \boldsymbol{A})=\boldsymbol{A}^{\mathrm{T}} \boldsymbol{P}^{\mathrm{T}} \boldsymbol{P} \boldsymbol{A}=\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}=\boldsymbol{I}_k$.
- $\boldsymbol{P A}=\left(\begin{array}{lll}\boldsymbol{P} \boldsymbol{u}_1 & \cdots & \boldsymbol{P} \boldsymbol{u}_k\end{array}\right)$.
$\circ \quad\left\{\boldsymbol{P} \boldsymbol{u}_1, \ldots, \boldsymbol{P} \boldsymbol{u}_k\right\}$ is also an orthonormal set.

### Properties Transition matrix

Visit [[MA2001-Chapter5.pdf#page=45]] 

IMPORTANT EXAMPLES: Visit [[MA2001-Chapter5.pdf#page=46]] 
## Classification

Visit [[MA2001-Chapter5.pdf#page=48]] 

## Geometric Representation

Visit [[MA2001-Chapter5.pdf#page=49]] 

Rotation [[MA2001-Chapter5.pdf#page=51]]