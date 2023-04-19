# Diagonalization

## Motivation

Let $\boldsymbol{A}$ be a square matrix.

- Suppose there exists an invertible matrix $\boldsymbol{P}$ such that
- $\boldsymbol{P}^{-1} \boldsymbol{A P}=\boldsymbol{D}$ is a diagonal matrix.
  Then $\boldsymbol{A}=\boldsymbol{P} \boldsymbol{D} \boldsymbol{P}^{-1}$.
$$
\begin{aligned}
\boldsymbol{A}^m & =\left(\boldsymbol{P} \boldsymbol{D} \boldsymbol{P}^{-1}\right)^m \\
& =\underbrace{\left(\boldsymbol{P} \boldsymbol{D} \boldsymbol{P}^{-1}\right)\left(\boldsymbol{P D} \boldsymbol{P}^{-1}\right) \cdots\left(\boldsymbol{P} \boldsymbol{D} \boldsymbol{P}^{-1}\right)}_{m \text { times }} \\
& =\boldsymbol{P} \boldsymbol{D}\left(\boldsymbol{P}^{-1} \boldsymbol{P}\right) \boldsymbol{D}\left(\boldsymbol{P}^{-1} \boldsymbol{P}\right) \cdots\left(\boldsymbol{P}^{-1} \boldsymbol{P}\right) \boldsymbol{D} \boldsymbol{P}^{-1} \\
& =\boldsymbol{P} \underbrace{\boldsymbol{D} \cdots \boldsymbol{D} \boldsymbol{D} \boldsymbol{P}^{-1}}_{m \text { times }} \\
& =\boldsymbol{P} \boldsymbol{D}^m \boldsymbol{P}^{-1} .
\end{aligned}
$$

Visit [PDF](MA2001-Chapter6.pdf#page=2)
[Example](MA2001-Chapter6.pdf#page=3%7CExample)

## Definition

See [PDF](MA2001-Chapter6.pdf#page=4%7CPDF) First

Let $\boldsymbol{A}$ be a square matrix of order $n$.

Suppose that for some $\lambda \in \mathbb{R}$ and nonzero $v \in \mathbb{R}^n$

- $\boldsymbol{A v}=\lambda v$

$\lambda$ is called an **eigenvalue** of $\boldsymbol{A}$.
$\boldsymbol{v}$ is called an **eigenvector** of $\boldsymbol{A}$ associated with $\lambda$.

[Example](MA2001-Chapter6.pdf#page=5%7CExample)

## Characteristic Equation

**Theorem**. Let $\boldsymbol{A}$ be a square matrix.

- Then the eigenvalues of $A$ are precisely all the roots to the characteristic equation $\operatorname{det}(\lambda \boldsymbol{I}-\boldsymbol{A})=0$

[Example](MA2001-Chapter6.pdf#page=6%7CSee%20why%20&%20Example)

## Main theorem for invertible matrices

**Theorem**. Let $\boldsymbol{A}$ be a square matrix of order $n$. Then the following are equivalent:

1. $A$ is invertible.
2. The reduced row-echelon form of $\boldsymbol{A}$ is $\boldsymbol{I}_n$.
3. The homogeneous linear system $\boldsymbol{A x}=\mathbf{0}$ has only the trivial solution.
4. The linear system $\boldsymbol{A} \boldsymbol{x}=\boldsymbol{b}$ has exactly one solution.
5. $A$ is the product of elementary matrices.
6. $\operatorname{det}(\boldsymbol{A}) \neq 0$.
7. The rows of $A$ form a basis for $\mathbb{R}^n$.
8. The columns of $\boldsymbol{A}$ form a basis for $\mathbb{R}^n$.
9. $\operatorname{rank}(\boldsymbol{A})=n$.
10. 0 is not an eigenvalue of $\boldsymbol{A}$.

[Proof of number 10](MA2001-Chapter6.pdf#page=8%7CProof%20of%20number%2010)

## Upper Triangular Matrices

It is easier to find the eigenvalue for upper triangular matrices. [See why](MA2001-Chapter6.pdf#page=9%7CSee%20why)

**Theorem**. Let $\boldsymbol{A}$ be an upper (or lower) triangular matrix. Then its eigenvalues are all the diagonal entries of $\boldsymbol{A}$.

- More precisely, if $\boldsymbol{A}=\left(a_{i j}\right)_{n \times n}$ is upper triangular $\left(a_{i j}=0\right.$ if $\left.i>j\right)$ or lower triangular $\left(a_{i j}=0\right.$ if $\left.i<j\right)$
	- then the eigenvalues of $\boldsymbol{A}$ are $a_{11}, a_{22}, \ldots, a_{n n}$.

## Eigenspace

Let $\boldsymbol{A}$ be a square matrix of order $n$.

- Let $\lambda$ be an eigenvalue of $\boldsymbol{A}$.

Let $0 \neq v \in \mathbb{R}^n$. Then

- $\boldsymbol{v}$ is an eigenvector of $\boldsymbol{A}$ associated to $\lambda$
$$
\begin{aligned}
& \Leftrightarrow \boldsymbol{A} \boldsymbol{v}=\lambda \boldsymbol{v} \\
& \Leftrightarrow(\lambda \boldsymbol{I}-\boldsymbol{A}) \boldsymbol{v}=\mathbf{0} \\
&\Leftrightarrow v \text{is a nonzero vector in the nullspace of} \lambda \boldsymbol{I}-\boldsymbol{A}
\end{aligned}
$$


**Definition**. Let $\boldsymbol{A}$ be a square matrix and $\lambda$ an eigenvalue of $\boldsymbol{A}$. (Then $\lambda \boldsymbol{I}-\boldsymbol{A}$ is singular.)

- The eigenspace of $\boldsymbol{A}$ associated to $\lambda$ is the nullspace of $\lambda \boldsymbol{I}-\boldsymbol{A}$, denoted by $E_\lambda$ (or $E_{\boldsymbol{A}, \lambda}$ ).
- $E_\lambda$ consists of all the eigenvectors of $A$ associated to $\lambda$, and the zero vector 0 . Note that $\operatorname{dim} E_\lambda \geq 1$

[Example](MA2001-Chapter6.pdf#page=10%7CExample)

_SEE IMPORTANT TIP:_ [Example](MA2001-Chapter6.pdf#page=11%7CExample)

- Here, $\left(\begin{array}{ccc}2 & -1 & -1 \\ -1 & 2 & -1 \\ -1 & -1 & 2\end{array}\right)$ is singular. Also we see that $R_{1}$ and $R_{2}$ are linearly independent (They are not a constant multiple of each other). Thus we can just ignore $R_{3}$ during the calculation.

**NOTE**:
If $\boldsymbol{A}$ is singular, then 0 is an eigenvalue of $\boldsymbol{A}$, then the eigenspace $E_0$ is the nullspace of $\boldsymbol{A}$. 
[Example](MA2001-Chapter6.pdf#page=11%7CExample)

## Diagonalizable Matrices

Definition. Let $\boldsymbol{A}$ be a square matrix.

- $\boldsymbol{A}$ is called diagonalizable if there exists an invertible matrix $\boldsymbol{P}$ such that $\boldsymbol{P}^{-1} \boldsymbol{A P}$ is a diagonal matrix.

**Examples**.

$\boldsymbol{A}=\left(\begin{array}{cc}0.96 & 0.01 \\ 0.04 & 0.99\end{array}\right)$ and $\boldsymbol{P}=\left(\begin{array}{cc}0.25 & -1 \\ 1 & 1\end{array}\right)$
- Then $\boldsymbol{P}^{-1} \boldsymbol{A P}=\boldsymbol{D}=\left(\begin{array}{cc}1 & 0 \\ 0 & 0.95\end{array}\right)$.
Then $\boldsymbol{A}$ is diagonalizable.
- Note that the diagonal entries of $\boldsymbol{D}$ are the eigenvalues of $\boldsymbol{A}$.
- The columns of $\boldsymbol{P}$ are eigenvectors of $\boldsymbol{A}$ associated to these eigenvalues.

[Example](MA2001-Chapter6.pdf#page=14%7CExample)

## Criterion of Diagonalizability

$\boldsymbol{A}$ is diagonalizable $\Leftrightarrow A$ has $n$ linearly independent eigenvectors.

**Remark**. Suppose that $\boldsymbol{P}^{-1} \boldsymbol{A P}=\boldsymbol{D}$ is diagonal.
- The diagonal entries of $\boldsymbol{D}$ are eigenvalues of $\boldsymbol{A}$ :
	- $\lambda_1, \ldots, \lambda_n$, which may be repeated.
	  $\boldsymbol{D}$ is not unique unless $\boldsymbol{A}$ has only one eigenvalue.
- The columns of $\boldsymbol{P}$ are eigenvectors of $\boldsymbol{A}$ :
	- $\boldsymbol{v}_1, \ldots, \boldsymbol{v}_n$, which are linearly independent.
	- $\boldsymbol{v}_i$ is an eigenvector of $\boldsymbol{A}$ associated to $\lambda_i$.
	  $\boldsymbol{P}$ is not unique. For instance,
	- $v_i$ can be replaced by a nonzero multiple of $v_i$.

[PDF](MA2001-Chapter6.pdf#page=16)
## Algorithm of Diagonalization

[PDF](MA2001-Chapter6.pdf#page=16) - [PDF](MA2001-Chapter6.pdf#page=18)

Let $\boldsymbol{A}$ be a square matrix of order $n$.

Case 1. If $\operatorname{det}(\lambda \boldsymbol{I}-\boldsymbol{A})$ cannot be completely factorized,

- then $\boldsymbol{A}$ is not diagonalizable.

Case 2. If $\operatorname{det}(\lambda \boldsymbol{I}-\boldsymbol{A})$ can be completely factorized,

- for each $\lambda_i$, find a basis $S_i$ for its eigenspace.
- 2a. If $\left|S_i\right|<a\left(\lambda_i\right)$ for some $i$,
	- then $\boldsymbol{A}$ is not diagonalizable.
- 2b. If $\left|S_i\right|=a\left(\lambda_i\right)$ for all $i$,
	- then $\boldsymbol{A}$ is diagonalizable.
	- $S_1 \cup \cdots \cup S_k=\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_n\right\}$ is a basis for $\mathbb{R}^n$.
	- $\boldsymbol{P}=\left(\begin{array}{lll}\boldsymbol{v}_1 & \cdots & \boldsymbol{v}_n\end{array}\right)$ diagonalizes $\boldsymbol{A}$.

**Remarks**: [PDF](MA2001-Chapter6.pdf#page=17)

[Example](MA2001-Chapter6.pdf#page=19%7CExample). Here we seem that the diagonal entries of $\boldsymbol{P}^{-1} \boldsymbol{B P}$ is the eigenvalue. There is no need to calcuate.


[Example](MA2001-Chapter6.pdf#page=19%7CExample) Here we see that $A$ is lower triangular. Hence the eigenvalue are 1,2,2

[Full Working Example](MA2001-Chapter6.pdf#page=20%7CFull%20Working%20Example%20A) We see that to show $A$ is not diagonizable, we start with $\lambda=2$ for faster calculation.

**Theorem**: Let $\boldsymbol{A}$ be a square matrix of order $n$.

- If $\boldsymbol{A}$ has $n$ distinct eigenvalues,
- then $\boldsymbol{A}$ is diagonalizable.

[Proof](MA2001-Chapter6.pdf#page=23%7CProof)

## Application

[PDF](MA2001-Chapter6.pdf#page=24)

## Orthogonal Diagonalization

[PDF](MA2001-Chapter6.pdf#page=26)

**Definition**. A square matrix $A$ is called orthogonally diagonalizable if it can be diagonalized by an orthogonal matrix. That is,

- there exists an orthogonal matrix $\boldsymbol{P}$ such that
- $\boldsymbol{P}^{\mathrm{T}} \boldsymbol{A P}\left(=\boldsymbol{P}^{-1} \boldsymbol{A P}\right)$ is a diagonal matrix.

$\boldsymbol{P}$ is said to orthogonally diagonalize $\boldsymbol{A}$. This makes it easy to find $P^{-1}$ which is $P^T$
[PDF](MA2001-Chapter6.pdf#page=27)

### Classification

**Theorem**. A square matrix is orthogonally diagonalizable $\Leftrightarrow$ it is a symmetric matrix.

### Algorithm

Let $\boldsymbol{A}$ be a symmetric matrix of order $n$.

1. Find all distinct eigenvalues $\lambda_1, \lambda_2, \ldots, \lambda_k$.
2. For each eigenvalue $\lambda_i$, find an orthonormal basis for the eigenspace $E_{\lambda_i}$.
   (i) Find a basis $S_{\lambda_i}$ for $E_{\lambda_i}$.
   (ii) Use Gram-Schmidt process to transfer $S_{\lambda_i}$ to an orthonormal basis $T_{\lambda_i}$ for $E_{\lambda_i}$.
3. Let $T=T_{\lambda_1} \cup T_{\lambda_2} \cup \cdots \cup T_{\lambda_k}$,
   ० $T=\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_n\right\}$ is an orthonormal basis for $\mathbb{R}^n$.
   $\boldsymbol{P}=\left(\begin{array}{lll}\boldsymbol{v}_1 & \cdots & \boldsymbol{v}_n\end{array}\right)$ orthogonally diagonalizes $\boldsymbol{A}$.

If A is symmetric, the eigenvectors are orthogonal. So just normalized to get orthonormal vectors.

[PDF](MA2001-Chapter6.pdf#page=28)
[Example](MA2001-Chapter6.pdf#page=30%7CExample)
[Example 2](MA2001-Chapter6.pdf#page=31%7CExample%202)

## Quadratic Forms and Conic Sections

[PDF](MA2001-Chapter6.pdf#page=34)

$Q(x, y)=2 x^2+3 y^2$ is a quadratic form in $x$ and $y$.

- Let $\boldsymbol{x}=\left(\begin{array}{l}x \\ y\end{array}\right)$ and $\boldsymbol{A}=\left(\begin{array}{ll}2 & 0 \\ 0 & 3\end{array}\right)$.
- Then $Q(x, y)=\boldsymbol{x}^{\mathrm{T}} \boldsymbol{A} \boldsymbol{x}$.

$Q(x, y)=x^2+y^2-x y$ is a quadratic form in $x$ and $y$.

- Let $\boldsymbol{x}=\left(\begin{array}{l}x \\ y\end{array}\right)$ and $\boldsymbol{A}=\left(\begin{array}{cc}1 & -\frac{1}{2} \\ -\frac{1}{2} & 1\end{array}\right)$.
- Then $Q(x, y)=\boldsymbol{x}^{\mathrm{T}} \boldsymbol{A} \boldsymbol{x}$.

[PDF](MA2001-Chapter6.pdf#page=35)

### Simplification

[PDF](MA2001-Chapter6.pdf#page=36)
[Example](MA2001-Chapter6.pdf#page=37%7CExample)

### Quadratic Equation

[PDF](MA2001-Chapter6.pdf#page=38)

### Classification of Conics

[PDF](MA2001-Chapter6.pdf#page=30)

### Standard Forms

[PDF](MA2001-Chapter6.pdf#page=39)

### Classification

[PDF](MA2001-Chapter6.pdf#page=43)

### Examples

[PDF](MA2001-Chapter6.pdf#page=44)