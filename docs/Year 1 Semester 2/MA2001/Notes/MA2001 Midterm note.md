# Chapter 1

## Consistency

### No Solution (Inconsistent)

There is a row in $\boldsymbol{R}$ with the form
- $\left(\begin{array}{llll}0 & 0 & \cdots & 0\end{array} \mid \otimes\right)$, where $\otimes$ is nonzero.

Or equivalently,_ the last column is a pivot column_.
Note: Such a row must be the last nonzero row of $\boldsymbol{R}$.

### One Solution (Consistent)

- The last column is a non-pivot column, and
- All other columns are pivot columns.

### Infinite Solution (Consistent)

- The last column is a non-pivot column, and
- Some other columns are non-pivot columns.

---

# Matrices

## Properties

### Basic

- Associative Law: $\boldsymbol{A}(\boldsymbol{B} \boldsymbol{C})=(\boldsymbol{A B}) \boldsymbol{C}$
- Distributive Law: $\boldsymbol{A}\left(\boldsymbol{B}_1+\boldsymbol{B}_2\right)=\boldsymbol{A B _ { 1 }}+\boldsymbol{A B _ { 2 }}$
- $c(\boldsymbol{A} \boldsymbol{B})=(c \boldsymbol{A}) \boldsymbol{B}=\boldsymbol{A}(c \boldsymbol{B})$
- $\boldsymbol{A}^m \boldsymbol{A}^n=\boldsymbol{A}^{m+n},\left(\boldsymbol{A}^m\right)^n=\boldsymbol{A}^{m n}$

### Transpose

- $\left(A^{\mathrm{T}}\right)^{\mathrm{T}}=A$.
- $A$ is symmetric $\Leftrightarrow A=A^{\mathrm{T}}$.
- Let $c$ be a scalar. Then $(c \boldsymbol{A})^{\mathrm{T}}=c \boldsymbol{A}^{\mathrm{T}}$.
- Let $\boldsymbol{B}$ be $m \times n$. Then $(\boldsymbol{A}+\boldsymbol{B})^{\mathrm{T}}=\boldsymbol{A}^{\mathrm{T}}+\boldsymbol{B}^{\mathrm{T}}$.
- Let $\boldsymbol{B}$ be $n \times p$. Then $(\boldsymbol{A} \boldsymbol{B})^{\mathrm{T}}=\boldsymbol{B}^{\mathrm{T}} \boldsymbol{A}^{\mathrm{T}}$.

<div style="page-break-after: always;"></div>

### Inverse 

Let $\boldsymbol{A}, \boldsymbol{B}$ be invertible matrices of same size.

- Let $c \neq 0 . c \boldsymbol{A}$ is invertible, and $(c \boldsymbol{A})^{-1}=\frac{1}{c} \boldsymbol{A}^{-1}$.
- $\boldsymbol{A}^{\mathrm{T}}$ is invertible, and $\left(\boldsymbol{A}^{\mathrm{T}}\right)^{-1}=\left(\boldsymbol{A}^{-1}\right)^{\mathrm{T}}$.
- $\boldsymbol{A}^{-1}$ is invertible, and $\left(\boldsymbol{A}^{-1}\right)^{-1}=\boldsymbol{A}$.
- $A B$ is invertible, and $(A B)^{-1}=B^{-1} A^{-1}$.

Let $\boldsymbol{A}$ be a square matrix. Then the followings are equivalent:

1. $\boldsymbol{A}$ is an invertible matrix.
2. Linear system $\boldsymbol{A} \boldsymbol{x}=\boldsymbol{b}$ has a unique solution.
3. Linear system $\boldsymbol{A} \boldsymbol{x}=\mathbf{0}$ has only the trivial solution.
4. The reduced row-echelon form of $\boldsymbol{A}$ is $\boldsymbol{I}$.
5. $\boldsymbol{A}$ is the product of elementary matrices.

## Elementary matrices

![[Chapter 2 Elementary Matrices.png]]

*Important Note*: $E_6 \cdots E_2 E_1 A=I$
Every elementary matrix is invertible

## Column Operations

$\boldsymbol{I} \stackrel{k C_i}{\longrightarrow} \boldsymbol{E} \Rightarrow \boldsymbol{A} \stackrel{k C_i}{\longrightarrow} \boldsymbol{A} \boldsymbol{E}$.
$\boldsymbol{I} \stackrel{C_i \leftrightarrow C_j}{\longrightarrow} \boldsymbol{E} \Rightarrow \boldsymbol{A} \stackrel{C_i \leftrightarrow C_j}{\longrightarrow} \boldsymbol{A} \boldsymbol{E}$.
$\boldsymbol{I} \stackrel{C_i+k C_j}{\longrightarrow} \boldsymbol{E} \Rightarrow \boldsymbol{A} \stackrel{C_i+k C_j}{\longrightarrow} \boldsymbol{A E}$.
## Determinant

### Cofactor Expansion

Theorem. Let $\boldsymbol{A}$ be a square matrix of order $n$.

- Let $A_{i j}$ denote the $(i, j)$-cofactor of $\boldsymbol{A}$.

Then for any $i$ and $j$,

- $\operatorname{det}(\boldsymbol{A})=a_{i 1} A_{i 1}+a_{i 2} A_{i 2}+\cdots+a_{i n} A_{i n}$.
- $\operatorname{det}(\boldsymbol{A})=a_{1 j} A_{1 j}+a_{2 j} A_{2 j}+\cdots+a_{n j} A_{n j}$

In evaluating the determinant using cofactor expansion,
expand along the row or column with the most zeros. (for ease of calculation)

### Finding Determinant

Find $\operatorname{det}(\boldsymbol{A})$ if $\boldsymbol{A}$ is a square matrix of order $n$.

- If $\boldsymbol{A}$ has a zero row/column, then $\operatorname{det}(\boldsymbol{A})=0$. (This also applies to same rows)
- If $\boldsymbol{A}$ is triangular, $\operatorname{det}(\boldsymbol{A})=a_{11} \cdots a_{n n}$.
- Suppose that $\boldsymbol{A}$ is not triangular.
	- If $n=2$, use formula $\operatorname{det}(\boldsymbol{A})=a_{11} a_{22}-a_{12} a_{21}$. 
	- If a row/coln has many 0 , use cofactor expansion. 
	- Otherwise, use ele. row operations to get REF:
		- $\operatorname{det}(\boldsymbol{E} \boldsymbol{A})=\operatorname{det}(\boldsymbol{E}) \operatorname{det}(\boldsymbol{A})$

Note the following formulas:

$\begin{aligned} & \operatorname{det}(\boldsymbol{A})=\operatorname{det}\left(\boldsymbol{A}^{\mathrm{T}}\right) \\ & \operatorname{det}(\boldsymbol{A} \boldsymbol{B})=\operatorname{det}(\boldsymbol{A}) \operatorname{det}(\boldsymbol{B}) \\ & \operatorname{det}(c \boldsymbol{A})=c^n \operatorname{det}(\boldsymbol{A}), \text { where } \boldsymbol{A} \text { is } n \times n \\ & \operatorname{det}\left(\boldsymbol{A}^{-1}\right)=\operatorname{det}(\boldsymbol{A})^{-1} \text { if } \boldsymbol{A} \text { is invertible. }\end{aligned}$
Suppose a square matrix $\boldsymbol{A}$ has a zero row. Then $\operatorname{det}(\boldsymbol{A})=0$.

### Properties

If $\boldsymbol{A} \stackrel{c R_i}{\longrightarrow} \boldsymbol{B}$, then $\operatorname{det}(\boldsymbol{B})=c \operatorname{det}(\boldsymbol{A})$.
If $\boldsymbol{A} \stackrel{R_i \leftrightarrow R_j}{\longrightarrow} \boldsymbol{B}$, then $\operatorname{det}(\boldsymbol{B})=-\operatorname{det}(\boldsymbol{A})$.
If $\boldsymbol{A} \stackrel{R_i+c R_j}{\longrightarrow} \boldsymbol{B}$, then $\operatorname{det}(\boldsymbol{B})=\operatorname{det}(\boldsymbol{A})$.

<div style="page-break-after: always;"></div>
## Adjoint Matrix

![[Midterm notes Adjoint matrix example.png]]
## Cramer's Rule

![[MA2001 Midterm note cramer's rule example.png]]

Note 60 here is the determinant.

<div style="page-break-after: always;"></div>

---

# Vector Spaces

## Implicit & Explicit Forms

### Implicit form example

$V=\{(t, 2 t, 3 t-1) \mid t \in \mathbb{R}\}$

Let $x = t$, $y=2t$, $z=3t-1$.

$$\left(\begin{array}{c|c}1 & x \\ 1 & \frac{y}{2} \\ 1 & \frac{{z+1}}{3} \end{array}\right) \underset{\text { elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{c|c}1 & x \\ 0 & \frac{y}{2}-x \\ 0 & \frac{{z+1}}{3}-x \end{array}\right)$$

The system is consistent. Therefore $\frac{y}{2}-x=0$, $\frac{{z+1}}{3}-x=0$

Implicit form: $\{(x, y, z) \mid y-2x=0\text{ } \&\text{ } z-3x=-1\}$

### Explicit form example

$\left\{\begin{array}{l}x+y+z=0 \\ x-y+2 z=1\end{array}\right.$

$\left(\begin{array}{ccc|c}1 & 1 & 1 & 0 \\ 1 & -1 & 2 & 1\end{array}\right) \stackrel{R_2+(-1) R_1}{\longrightarrow}\left(\begin{array}{ccc|c}1 & 1 & 1 & 0 \\ 0 & -2 & 1 & 1\end{array}\right)$

$x=\frac{1}{2}-\frac{3}{2} t, y=-\frac{1}{2}+\frac{1}{2} t, z=t$, where $t \in \mathbb{R}$.

An explicit form of the solution set is

- $\left\{\left(\frac{1}{2}-\frac{3}{2} t,-\frac{1}{2}+\frac{1}{2} t, t\right) \mid t \in \mathbb{R}\right\}$.
## Criterion for $\operatorname{span}(S)=\mathbb{R}^n$

Let $S=\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \ldots, \boldsymbol{v}_k\right\} \subseteq \mathbb{R}^n$.

1. View each $\boldsymbol{v}_j$ as a column vector.
2. Let $\boldsymbol{A}=\left(\begin{array}{llll}\boldsymbol{v}_1 & \boldsymbol{v}_2 & \cdots & \boldsymbol{v}_k\end{array}\right)$.
3. Find a row-echelon form $\boldsymbol{R}$ of $\boldsymbol{A}$.
	- If $\boldsymbol{R}$ has a zero row, then $\operatorname{span}(S) \neq \mathbb{R}^n$.
	- If $\boldsymbol{R}$ has no zero row, then $\operatorname{span}(S)=\mathbb{R}^n$.

Example.
$$
\begin{aligned}
& \left(\begin{array}{lll}
1 & 1 & 0 \\
0 & 1 & 1 \\
1 & 0 & 1
\end{array}\right) \underset{\text { Elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{lll}
1 & 1 & 0 \\
0 & 1 & 1 \\
0 & 0 & 2
\end{array}\right) . \\
& \therefore \operatorname{span}\{(1,0,1),(1,1,0),(0,1,1)\}=\mathbb{R}^3 .
\end{aligned}
$$

Also if $k<n$, then $\operatorname{span}(S) \neq \mathbb{R}^n$.
## Properties of Linear Spans

- Since $\mathbf{0} \in \operatorname{span}(S), \operatorname{span}(S) \neq \varnothing$.
- $v \in \operatorname{span}(S)$ and $c \in \mathbb{R} \Rightarrow c \boldsymbol{v} \in \operatorname{span}(S)$.
	- $\operatorname{span}(S)$ is closed under scalar multiplication.
- $\boldsymbol{u} \in \operatorname{span}(S)$ and $\boldsymbol{v} \in \operatorname{span}(S) \Rightarrow \boldsymbol{u}+\boldsymbol{v} \in \operatorname{span}(S)$.
	- $\operatorname{span}(S)$ is closed under addition.

### Example 

![[MA2001 Midterm note example Linear span.png]]
## Subspaces 

Recall that a subspace $V$ is of the form $\operatorname{span}(S)$. Then
- $\mathbf{0} \in V$,
- $c \in \mathbb{R} \& \boldsymbol{v} \in V \Rightarrow c \boldsymbol{v} \in V$,
- $\boldsymbol{u} \in V \& \boldsymbol{v} \in V \Rightarrow \boldsymbol{u}+\boldsymbol{v} \in V$.
If any of the above fails, then $V$ is not a subspace (of $\mathbb{R}^n$ ).

