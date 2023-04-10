# Matrices



To show the $i,j^{th}$ entry of a matrix for $E=(e_{ij})_{m\times m}$ times $A=(a_{ij})_{m\times n}$

- Then the $(i,j)$-entry of $EA$ is
- $e_{i 1} a_{1 j}+\cdots+e_{i m} a_{m j}$

## Special Matrices

### Diagonal matrix

A _square matrix_ is called a diagonal matrix if all its non-diagonal entries are zero.

$\boldsymbol{A}=\left(\begin{array}{cccc}a_{11} & 0 & \cdots & 0 \\ 0 & a_{22} & \cdots & 0 \\ \vdots & \vdots & \ddots & \vdots \\ 0 & 0 & \cdots & a_{n n}\end{array}\right)$

### Scalar matrix

A _diagonal matrix_ is called a scalar matrix if all its diagonal entries are the same.

$\boldsymbol{A}=\left(\begin{array}{cccc}c & 0 & \cdots & 0 \\ 0 & c & \cdots & 0 \\ \vdots & \vdots & \ddots & \vdots \\ 0 & 0 & \cdots & c\end{array}\right)$, where $c$ is a constant.

### Identity matrix

A _scalar matrix_ is called an identity matrix if all its diagonal entries are 1.
Denote the identity matrix of order $n$ (size $n \times n$ ) by $\boldsymbol{I}_n$.

$\boldsymbol{A}=\left(\begin{array}{cccc}1 & 0 & \cdots & 0 \\ 0 & 1 & \cdots & 0 \\ \vdots & \vdots & \ddots & \vdots \\ 0 & 0 & \cdots & 1\end{array}\right)$

$\boldsymbol{A}=\left(a_{i j}\right)_{n \times n}$ is identity $\Leftrightarrow a_{i j}= \begin{cases}1 & \text { if } i=j \\ 0 & \text { if } i \neq j\end{cases}$

### Zero matrix

A matrix with all entries equal to zero is a zero matrix. This does not have to be a square matrix as denoted by the absence of diagonal ... in the matrix.

$\boldsymbol{A}=\left(\begin{array}{cccccc}0 & 0 & 0 & 0 & \cdots & 0 \\ 0 & 0 & 0 & 0 & \cdots & 0 \\ \vdots & \vdots & \vdots & \vdots & & \vdots \\ 0 & 0 & 0 & 0 & \cdots & 0\end{array}\right)$

### Symmetric

A _square matrix_ is called symmetric if it is symmetric with respect to the diagonal.

$\boldsymbol{A}=\left(\begin{array}{cccccc}a_{11} & a_{12} & a_{13} & a_{14} & \cdots & a_{1 n} \\ a_{21} & a_{22} & a_{23} & a_{24} & \cdots & a_{2 n} \\ a_{31} & a_{32} & a_{33} & a_{34} & \cdots & a_{3 n} \\ a_{41} & a_{42} & a_{43} & a_{44} & \cdots & a_{4 n} \\ \vdots & \vdots & \vdots & \vdots & \ddots & \vdots \\ a_{n 1} & a_{n 2} & a_{n 3} & a_{n 4} & \cdots & a_{n n}\end{array}\right)$

$\boldsymbol{A}=\left(a_{i j}\right)_{n \times n}$ is symmetric $\Leftrightarrow a_{i j}=a_{j i}$ for all $i, j$.
(There is no restriction to the diagonal entries.)

### Upper triangular

A _square matrix_ is called upper triangular if all the entries below the diagonal are zero.

$\boldsymbol{A}=\left(\begin{array}{cccccc}a_{11} & a_{12} & a_{13} & a_{14} & \cdots & a_{1 n} \\ 0 & a_{22} & a_{23} & a_{24} & \cdots & a_{2 n} \\ 0 & 0 & a_{33} & a_{34} & \cdots & a_{3 n} \\ 0 & 0 & 0 & a_{44} & \cdots & a_{4 n} \\ \vdots & \vdots & \vdots & \vdots & \ddots & \vdots \\ 0 & 0 & 0 & 0 & \cdots & a_{n n}\end{array}\right)$

$\boldsymbol{A}=\left(a_{i j}\right)_{n \times n}$ is upper triangular $\Leftrightarrow a_{i j}=0$ if $i>j$.
(There is no restriction to the diagonal entries.)

### Lower triangular 

A _square matrix_ is called lower triangular if all the entries above the diagonal are zero.

$\boldsymbol{A}=\left(\begin{array}{cccccc}a_{11} & 0 & 0 & 0 & \cdots & 0 \\ a_{21} & a_{22} & 0 & 0 & \cdots & 0 \\ a_{31} & a_{32} & a_{33} & 0 & \cdots & 0 \\ a_{41} & a_{42} & a_{43} & a_{44} & \cdots & 0 \\ \vdots & \vdots & \vdots & \vdots & \ddots & \vdots \\ a_{n 1} & a_{n 2} & a_{n 3} & a_{n 4} & \cdots & a_{n n}\end{array}\right)$

$\boldsymbol{A}=\left(a_{i j}\right)_{n \times n}$ is lower triangular $\Leftrightarrow a_{i j}=0$ if $i<j$
(There is no restriction to the diagonal entries.)



## Transpose of Matrix

### Properties

Let $\boldsymbol{A}$ be an $m \times n$ matrix.

$\left(\boldsymbol{A}^{\mathrm{T}}\right)^{\mathrm{T}}=\boldsymbol{A}$
$A$ is symmetric $\Leftrightarrow A=A^{\mathrm{T}}$.
Let $c$ be a scalar. Then $(c \boldsymbol{A})^{\mathrm{T}}=c \boldsymbol{A}^{\mathrm{T}}$.
Let $\boldsymbol{B}$ be $m \times n$. Then $(\boldsymbol{A}+\boldsymbol{B})^{\mathrm{T}}=\boldsymbol{A}^{\mathrm{T}}+\boldsymbol{B}^{\mathrm{T}}$.
Let $\boldsymbol{B}$ be $n \times p$. Then $(\boldsymbol{A} \boldsymbol{B})^{\mathrm{T}}=\boldsymbol{B}^{\mathrm{T}} \boldsymbol{A}^{\mathrm{T}}$.

## Inverse of Matrix

If there exists a _square matrix_ $\boldsymbol{B}$ of order $n$ so that

- $\boldsymbol{A B}=I_n$ land $\boldsymbol{B A}=I_n$
then $\boldsymbol{A}$ is called invertible, and $\boldsymbol{B}$ is an inverse of $\boldsymbol{A}$.

Let $\boldsymbol{A}=\left(\begin{array}{ll}a & b \\ c & d\end{array}\right)$

If $\boldsymbol{A}$ is invertible, then $\boldsymbol{A}^{-1}=\frac{1}{a d-b c}\left(\begin{array}{cc}d & -b \\ -c & a\end{array}\right)$

If $ad-bc = 0$ it is Inconsistent

### Properties

Let $\boldsymbol{A}, \boldsymbol{B}$ be invertible matrices of same size.

- Let $c \neq 0 . c \boldsymbol{A}$ is invertible, and $(c \boldsymbol{A})^{-1}=\frac{1}{c} \boldsymbol{A}^{-1}$.
- $\boldsymbol{A}^{\mathrm{T}}$ is invertible, and $\left(\boldsymbol{A}^{\mathrm{T}}\right)^{-1}=\left(\boldsymbol{A}^{-1}\right)^{\mathrm{T}}$.
- $\boldsymbol{A}^{-1}$ is invertible, and $\left(\boldsymbol{A}^{-1}\right)^{-1}=\boldsymbol{A}$.
- $A B$ is invertible, and $(A B)^{-1}=B^{-1} A^{-1}$.

Let $\boldsymbol{A}_1, \boldsymbol{A}_2, \ldots, \boldsymbol{A}_k$ be invertible matrices of same size.

- $\left(\boldsymbol{A}_1 \boldsymbol{A}_2 \cdots \boldsymbol{A}_k\right)^{-1}=\boldsymbol{A}_k^{-1} \cdots \boldsymbol{A}_2^{-1} \boldsymbol{A}_1^{-1}$.
- $\left(\boldsymbol{A}^k\right)^{-1}=\left(\boldsymbol{A}^{-1}\right)^k$

Definition. Let $A$ be an invertible matrix.

- For any positive integer $k, \boldsymbol{A}^{-k}=\left(\boldsymbol{A}^{-1}\right)^k$

Let $A$ be an invertible matrix.

- $\boldsymbol{A}^{m+n}=\boldsymbol{A}^m \boldsymbol{A}^n$ and $\left(\boldsymbol{A}^m\right)^n=\boldsymbol{A}^{m n}$

## Elementary row operation using matrix multiplication

![[Chapter 2 Elementary Matrices.png]]

[[MA2001-Chapter2.pdf#page=29|Example]]

*Important Note*: $E_6 \cdots E_2 E_1 A=I$
Every elementary matrix is invertible
## From one matrix to another 

Suppose for elementary matrices $\boldsymbol{E}_i$,

- $\boldsymbol{B}=\boldsymbol{E}_k \boldsymbol{E}_{k-1} \cdots \boldsymbol{E}_2 \boldsymbol{E}_1 \boldsymbol{A}$
- $\boldsymbol{A} \stackrel{\boldsymbol{E}_1}{\longrightarrow} \bullet \stackrel{\boldsymbol{E}_2}{\longrightarrow} \bullet \rightarrow \cdots \rightarrow \bullet \stackrel{\boldsymbol{E}_{k-1}}{\longrightarrow} \bullet \stackrel{\boldsymbol{E}_k}{\longrightarrow} \boldsymbol{B}$
- $\boldsymbol{A} \stackrel{E_1^{-1}}{\longleftarrow} \bullet \stackrel{E_2^{-1}}{\longleftarrow} \bullet \leftarrow \cdots \leftarrow \bullet \stackrel{E_{k-1}^{-1}}{\longleftarrow} \bullet \stackrel{E_k^{-1}}{\longleftarrow} \boldsymbol{B}$

$\therefore \quad \boldsymbol{A}=\boldsymbol{E}_1^{-1} \boldsymbol{E}_2^{-1} \cdots \boldsymbol{E}_{k-1}^{-1} \boldsymbol{E}_k^{-1} \boldsymbol{B}$

## Theorem for Invertible Matrices

==Let $\boldsymbol{A}$ be a square matrix. Then the followings are equivalent:==

1. $\boldsymbol{A}$ is an invertible matrix.
2. Linear system $\boldsymbol{A} \boldsymbol{x}=\boldsymbol{b}$ has a unique solution.
3. Linear system $\boldsymbol{A} \boldsymbol{x}=\mathbf{0}$ has only the trivial solution.
4. The reduced row-echelon form of $\boldsymbol{A}$ is $\boldsymbol{I}$.
5. $\boldsymbol{A}$ is the product of elementary matrices.

[[MA2001-Chapter2.pdf#page=45|Proof]]

## Find Inverse

From [[MA2001-Chapter2.pdf#page=46|Page 46]]

Let $A$ be an invertible matrix of order $n$. Its reduced row-echelon form is $I_n$.

There exist elementary matrices $\boldsymbol{E}_i$ such that

- $\boldsymbol{E}_k \cdots \boldsymbol{E}_2 \boldsymbol{E}_1 \boldsymbol{A}=\boldsymbol{I}_n$.
Then $\boldsymbol{E}_k \cdots \boldsymbol{E}_2 \boldsymbol{E}_1=\boldsymbol{A}^{-1}$.

Consider the $n \times 2 n$ matrix $(\boldsymbol{A} \mid \boldsymbol{I})$.

Apply the ele. row oper. corresponding to $\boldsymbol{E}_1, \ldots, \boldsymbol{E}_k$ :
$$
\begin{aligned}
\left(\boldsymbol{A} \mid \boldsymbol{I}_n\right) & \stackrel{\boldsymbol{E}_1}{\longrightarrow}\left(\boldsymbol{E}_1 \boldsymbol{A} \mid \boldsymbol{E}_1\right) \\
& \stackrel{\boldsymbol{E}_2}{\longrightarrow}\left(\boldsymbol{E}_2 \boldsymbol{E}_1 \boldsymbol{A} \mid \boldsymbol{E}_2 \boldsymbol{E}_1\right) \\
& \rightarrow \cdots \rightarrow \cdots \\
& \stackrel{\boldsymbol{E}_k}{\longrightarrow}\left(\boldsymbol{E}_k \cdots \boldsymbol{E}_2 \boldsymbol{E}_1 \boldsymbol{A} \mid \boldsymbol{E}_k \cdots \boldsymbol{E}_2 \boldsymbol{E}_1\right) \\
& =\left(\boldsymbol{I}_n \mid \boldsymbol{A}^{-1}\right)
\end{aligned}
$$

This is the reduced row-echelon form of $(A|I )$

### Column Operations

Let $\boldsymbol{A}$ be an $m \times n$ matrix, and $\boldsymbol{E}$ an $n \times n$ elementary matrix. Then
- The post-multiplication of $\boldsymbol{E}$ to $\boldsymbol{A}$
$\Leftrightarrow$ Corresponding elementary column operation to $\boldsymbol{A}$.
- $\boldsymbol{I} \stackrel{k C_i}{\longrightarrow} \boldsymbol{E} \Rightarrow \boldsymbol{A} \stackrel{k C_i}{\longrightarrow} \boldsymbol{A} \boldsymbol{E}$.
- $\boldsymbol{I} \stackrel{C_i \leftrightarrow C_j}{\longrightarrow} \boldsymbol{E} \Rightarrow \boldsymbol{A} \stackrel{C_i \leftrightarrow C_j}{\longrightarrow} \boldsymbol{A} \boldsymbol{E}$.
- $\boldsymbol{I} \stackrel{C_i+k C_j}{\longrightarrow} \boldsymbol{E} \Rightarrow \boldsymbol{A} \stackrel{C_i+k C_j}{\longrightarrow} \boldsymbol{A} \boldsymbol{E}$.

## Determinant

### Elementary Row Operation

Get the determinant of $A$ from multiplying the determinant of $E_{1},E_{2}\dots$
[[MA2001-Chapter2.pdf#page=61|page=61]]

### Properties

- Theorem. $\operatorname{det}(\boldsymbol{I})=1$. For any square matrices,
	- If $\boldsymbol{A} \stackrel{c R_i}{\longrightarrow} \boldsymbol{B}$, then $\operatorname{det}(\boldsymbol{B})=c \operatorname{det}(\boldsymbol{A})$.
		- In particular, If $\boldsymbol{I} \stackrel{c R_i}{\longrightarrow} \boldsymbol{E}$, then $\operatorname{det}(\boldsymbol{E})=c$.
	- If $\boldsymbol{A} \stackrel{R_i \leftrightarrow R_j}{\longrightarrow} \boldsymbol{B}$, then $\operatorname{det}(\boldsymbol{B})=-\operatorname{det}(\boldsymbol{A})$.
		- In particular, if $\boldsymbol{I} \stackrel{R_i \leftrightarrow R_j}{\longrightarrow} \boldsymbol{E}$, then $\operatorname{det}(\boldsymbol{E})=-1$.
	- If $\boldsymbol{A} \stackrel{R_i+c R_j}{\longrightarrow} \boldsymbol{B}$, then $\operatorname{det}(\boldsymbol{B})=\operatorname{det}(\boldsymbol{A})$.
		- In particular, if $\boldsymbol{I} \stackrel{R_i+c R_j}{\longrightarrow} \boldsymbol{E}$, then $\operatorname{det}(\boldsymbol{E})=1$.
- Theorem. Let $\boldsymbol{A}$ be a square matrix.
	- For any elementary matrix $\boldsymbol{E}$ of the same order,
		- $\operatorname{det}(\boldsymbol{E} \boldsymbol{A})=\operatorname{det}(\boldsymbol{E}) \operatorname{det}(\boldsymbol{A})$.

[[MA2001-Chapter2.pdf#page=63|More Properties]]

### Cofactor Expansion

Theorem. Let $\boldsymbol{A}$ be a square matrix of order $n$.

- Let $A_{i j}$ denote the $(i, j)$-cofactor of $\boldsymbol{A}$.

Then for any $i$ and $j$,

- $\operatorname{det}(\boldsymbol{A})=a_{i 1} A_{i 1}+a_{i 2} A_{i 2}+\cdots+a_{i n} A_{i n}$.
- $\operatorname{det}(\boldsymbol{A})=a_{1 j} A_{1 j}+a_{2 j} A_{2 j}+\cdots+a_{n j} A_{n j}$

In evaluating the determinant using cofactor expansion,
expand along the row or column with the most zeros. (for ease of calculation)

[[MA2001-Chapter2.pdf#page=69|Example]]
[[#Cofactor]]

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

[[MA2001-Chapter2.pdf#page=70|Example]]

## Adjoint Matrix

[[MA2001-Chapter2.pdf#page=71]]


## Cramer's Rule

Let $\boldsymbol{A}$ be an invertible matrix of order $n$.

- For every column matrix $\boldsymbol{b}$ of size $n \times 1$, the linear system $\boldsymbol{A} \boldsymbol{x}=\boldsymbol{b}$ has a unique solution
- $\boldsymbol{x}=\frac{1}{\operatorname{det}(\boldsymbol{A})}\left(\begin{array}{c}\operatorname{det}\left(\boldsymbol{A}_1\right) \\ \vdots \\ \operatorname{det}\left(\boldsymbol{A}_n\right)\end{array}\right)$
- $\boldsymbol{A}_j$ is obtained from $\boldsymbol{A}$ by replacing its $j$ th column by $\boldsymbol{b}$.

Example. Let $\boldsymbol{A}=\left(\begin{array}{ll}a_{11} & a_{12} \\ a_{21} & a_{22}\end{array}\right)$ and $\boldsymbol{b}=\left(\begin{array}{l}b_1 \\ b_2\end{array}\right)$.
- Suppose that $\boldsymbol{A}$ is invertible. $\boldsymbol{A} \boldsymbol{x}=\boldsymbol{b}$ implies
$\boldsymbol{x}=\frac{1}{\left|\begin{array}{ll}a_{11} & a_{12} \\ a_{21} & a_{22}\end{array}\right|}\left(\begin{array}{ll}\left|\begin{array}{ll}b_1 & a_{12} \\ b_2 & a_{22}\end{array}\right| \\ \left|\begin{array}{ll}a_{11} & b_1 \\ a_{21} & b_2\end{array}\right|\end{array}\right)$

[[MA2001-Chapter2.pdf#page=74|Example]]

---

# Appendix

## Cofactor 

[[MA2001-Chapter2.pdf#page=57]]