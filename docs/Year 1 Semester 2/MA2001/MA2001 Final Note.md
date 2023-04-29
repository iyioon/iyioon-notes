## Linear Systems

**General solution:** If $u$ is a solution to $Ax=0$, the general solution to $Ax=b$ is $u+b$.
## Matrix

**Transpose:**

- $\left(A^{\mathrm{T}}\right)^{\mathrm{T}}=A$.
- $A$ is symmetric $\Leftrightarrow A=A^{\mathrm{T}}$.
- Let $c$ be a scalar. Then $(c \boldsymbol{A})^{\mathrm{T}}=c \boldsymbol{A}^{\mathrm{T}}$.
- Let $\boldsymbol{B}$ be $m \times n$. Then $(\boldsymbol{A}+\boldsymbol{B})^{\mathrm{T}}=\boldsymbol{A}^{\mathrm{T}}+\boldsymbol{B}^{\mathrm{T}}$.
- Let $\boldsymbol{B}$ be $n \times p$. Then $(\boldsymbol{A} \boldsymbol{B})^{\mathrm{T}}=\boldsymbol{B}^{\mathrm{T}} \boldsymbol{A}^{\mathrm{T}}$.

**Determinant:**

$\begin{aligned} & \operatorname{det}(\boldsymbol{A})=\operatorname{det}\left(\boldsymbol{A}^{\mathrm{T}}\right) \\ & \operatorname{det}(\boldsymbol{A} \boldsymbol{B})=\operatorname{det}(\boldsymbol{A}) \operatorname{det}(\boldsymbol{B}) \\ & \operatorname{det}(c \boldsymbol{A})=c^n \operatorname{det}(\boldsymbol{A}), \text { where } \boldsymbol{A} \text { is } n \times n \\ & \operatorname{det}\left(\boldsymbol{A}^{-1}\right)=\operatorname{det}(\boldsymbol{A})^{-1} \text { if } \boldsymbol{A} \text { is invertible. }\end{aligned}$
Suppose a square matrix $\boldsymbol{A}$ has a zero row. Then $\operatorname{det}(\boldsymbol{A})=0$.

**Adjoint matrix:** Let $\boldsymbol{A}=\left(\begin{array}{ccc}1 & -1 & 1 \\ 0 & -1 & 0 \\ 1 & 0 & 3\end{array}\right) \cdot \operatorname{det}(\boldsymbol{A})=(-1)\left|\begin{array}{ll}1 & 1 \\ 1 & 3\end{array}\right|=-2$

$$\operatorname{adj}(\boldsymbol{A})=\left(\begin{array}{lll}A_{11} & A_{21} & A_{31} \\ A_{12} & A_{22} & A_{32} \\ A_{13} & A_{23} & A_{33}\end{array}\right)$$

**Cramer's Rule:**

$\left(\begin{array}{ccc}1 & 1 & 3 \\ 2 & -2 & 2 \\ 3 & 9 & 0\end{array}\right)\left(\begin{array}{l}x \\ y \\ z\end{array}\right)=\left(\begin{array}{l}0 \\ 4 \\ 3\end{array}\right)\text{. Det =}\left|\begin{array}{ccc}1 & 1 & 3 \\ 2 & -2 & 2 \\ 3 & 9 & 0\end{array}\right|=60$
$\begin{aligned} & \circ \quad x=\frac{\left|\begin{array}{ccc}0 & 1 & 3 \\ 4 & -2 & 2 \\ 3 & 9 & 0\end{array}\right|}{60}=\frac{132}{60}=2.2 \\ & \circ \quad y=\frac{\left|\begin{array}{lll}1 & 0 & 3 \\ 2 & 4 & 2 \\ 3 & 3 & 0\end{array}\right|}{60}=\frac{-24}{60}=-0.4 \\ & \circ \quad z=\frac{\left|\begin{array}{ccc}1 & 1 & 0 \\ 2 & -2 & 4 \\ 3 & 9 & 3\end{array}\right|}{60}=\frac{-36}{60}=-0.6 \\ & \end{aligned}$


**Inverse:** Let $\boldsymbol{A}, \boldsymbol{B}$ be invertible matrices of same size.

- Let $c \neq 0 . c \boldsymbol{A}$ is invertible, and $(c \boldsymbol{A})^{-1}=\frac{1}{c} \boldsymbol{A}^{-1}$.
- $\boldsymbol{A}^{\mathrm{T}}$ is invertible, and $\left(\boldsymbol{A}^{\mathrm{T}}\right)^{-1}=\left(\boldsymbol{A}^{-1}\right)^{\mathrm{T}}$.
- $\boldsymbol{A}^{-1}$ is invertible, and $\left(\boldsymbol{A}^{-1}\right)^{-1}=\boldsymbol{A}$.
- $A B$ is invertible, and $(A B)^{-1}=B^{-1} A^{-1}$.

## Vector Spaces

**To show Linearly Independent:** $c_1 \boldsymbol{v}_1+c_2 \boldsymbol{v}_2+\cdots+c_k \boldsymbol{v}_k=\mathbf{0} \Rightarrow c_1=\cdots=c_k=0$. Also can be shown by seeing the vectors as column vectors and checking if all columns are pivot.

**Dimension Theorem:** Let $A$ be a $m \times n$ matrix. Then $\operatorname{rank}(A)+\operatorname{nullity}(A)=n$


## Orthogonality

**Gram-Schmidt Process:** Let $\left\{\boldsymbol{u}_1, \boldsymbol{u}_2, \ldots, \boldsymbol{u}_k\right\}$ be a basis for a vector space $V$. 

$$\begin{aligned} & \boldsymbol{v}_1=\boldsymbol{u}_1 \\ & \boldsymbol{v}_2=\boldsymbol{u}_2-\frac{\boldsymbol{u}_2 \cdot \boldsymbol{v}_1}{\boldsymbol{v}_1 \cdot \boldsymbol{v}_1} \boldsymbol{v}_1 \\ & \boldsymbol{v}_3=\boldsymbol{u}_3-\frac{\boldsymbol{u}_3 \cdot \boldsymbol{v}_1}{\boldsymbol{v}_1 \cdot \boldsymbol{v}_1} \boldsymbol{v}_1-\frac{\boldsymbol{u}_3 \cdot \boldsymbol{v}_2}{\boldsymbol{v}_2 \cdot \boldsymbol{v}_2} \boldsymbol{v}_2 \\ & \vdots \quad \quad \quad \vdots \\ & \boldsymbol{v}_k=\boldsymbol{u}_k-\frac{\boldsymbol{u}_k \cdot \boldsymbol{v}_1}{\boldsymbol{v}_1 \cdot \boldsymbol{v}_1} \boldsymbol{v}_1-\frac{\boldsymbol{u}_k \cdot \boldsymbol{v}_2}{\boldsymbol{v}_2 \cdot \boldsymbol{v}_2} \boldsymbol{v}_2-\cdots-\frac{\boldsymbol{u}_k \cdot \boldsymbol{v}_{k-1}}{\boldsymbol{v}_{k-1} \cdot \boldsymbol{v}_{k-1}} \boldsymbol{v}_{k-1}\end{aligned}$$

Make sure to normalize if you want to find a orthonormal  basis.a

**Projection:** Let $\left\{\boldsymbol{u}_1, \boldsymbol{u}_2, \ldots, \boldsymbol{u}_k\right\}$ be an orthogonal basis for a vector space $V$. The projection of $w$ onto $V$ is

$$\left(\frac{\boldsymbol{w} \cdot \boldsymbol{u}_1}{\boldsymbol{u}_1 \cdot \boldsymbol{u}_1}\right) \boldsymbol{u}_1+\left(\frac{\boldsymbol{w} \cdot \boldsymbol{u}_2}{\boldsymbol{u}_2 \cdot \boldsymbol{u}_2}\right) \boldsymbol{u}_2+\cdots+\left(\frac{\boldsymbol{w} \cdot \boldsymbol{u}_k}{\boldsymbol{u}_k \cdot \boldsymbol{u}_k}\right) \boldsymbol{u}_k$$

**Projection (other method): **Suppose $V=\operatorname{span}\left\{\boldsymbol{a}_1, \ldots, \boldsymbol{a}_n\right\}$.

- Write $\boldsymbol{A}=\left(\begin{array}{lll}\boldsymbol{a}_1 & \cdots & \boldsymbol{a}_n\end{array}\right)$, each $\boldsymbol{a}_j$ is a column vector.
- Find a least squares solution $\boldsymbol{u}$ to $\boldsymbol{A x}=\boldsymbol{b}$. i.e., a solution $\boldsymbol{u}$ to $\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A} \boldsymbol{x}=\boldsymbol{A}^{\mathrm{T}} \boldsymbol{b}$.
- The projection of $\boldsymbol{b}$ onto $V$ is $\boldsymbol{p}=\boldsymbol{A} \boldsymbol{u}$.

**To find the shortest distance from $u$ point to $V$:** 

1. Find the orthogonal basis
2. Find the projection of $u$ onto $V$
3. Find the distance $\mid \mid Av-u\mid \mid$ where $v$ is the LSS

**Least Square Solution of $Ax=b$:**

- Find the column space of $A$
- Find the projection of $b$ onto the column space
- Solve $Ax=p$
- Or just solve $A^TAx=A^Tb$

**Orthogonal matrix:** Square matrix $A$ is called an orthogonal matrix if $A^TA=I$. Equivalently $A^{-1}=A^T$.

$\Leftrightarrow$ columns of $\boldsymbol{A}$ form an orthonormal basis for $\mathbb{R}^n$.
$\Leftrightarrow$ rows of $\boldsymbol{A}$ form an orthonormal basis for $\mathbb{R}^n$.

<div style="page-break-after: always;"></div>

## Diagonalization

**Eigenvalue and Eigenvector:** $Av=\lambda v$ 

**Algebraic Multiplicities:** The algebraic multiplicity always adds up to n.

**Diagonalization:** Let $\boldsymbol{A}$ be a square matrix of order $n$.
1. Solve $\operatorname{det}(\lambda \boldsymbol{I}-\boldsymbol{A})=0$ to find eigenvalues of $\boldsymbol{A}$.
2. For each eigenvalue $\lambda_i$ of $\boldsymbol{A}$,
   - find a basis $S_i$ for the eigenspace $E_{\lambda_i}$.
$$
\begin{aligned}
& \boldsymbol{A} \text { is diagonalizable } \Leftrightarrow\left|S_1\right|+\cdots+\left|S_k\right|=n, \\
& \boldsymbol{A} \text { is not diagonalizable } \Leftrightarrow\left|S_1\right|+\cdots+\left|S_k\right|<n .
\end{aligned}
$$

Suppose $\boldsymbol{A}$ is diagonalizable. Then
- $S_1 \cup \cdots \cup S_k=\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_n\right\}$ is a basis for $\mathbb{R}^n$.
- $\boldsymbol{A}$ is diagonalized by $\boldsymbol{P}=\left(\begin{array}{lll}\boldsymbol{v}_1 & \cdots & \boldsymbol{v}_n\end{array}\right)$.

<u>Key things to know:</u>  For $\boldsymbol{P}^{-1} \boldsymbol{A} \boldsymbol{P}=\boldsymbol{D}$, if we want to calculate for $\boldsymbol{A^n}$, $\boldsymbol{P}$ stays the same but $\boldsymbol{D^n}$.

**Orthogonally diagonalize symmetric matrix:** Find eigenvalues $\to$ find orthonormal basis for each eigenspace by Gram-Schmidt Process.

## Linear Transformation

**Standard Matrix:** $T(\boldsymbol{x})=\boldsymbol{A x}$

**Property:** $T \circ S: \mathbb{R}^n \rightarrow \mathbb{R}^k$ is a linear transformation and its standard matrix is $\boldsymbol{B} \boldsymbol{A}$.

**Range:** $T\left(\left(\begin{array}{l}x \\ y\end{array}\right)\right)=\left(\begin{array}{c}x+y \\ y \\ x\end{array}\right)$ 

- Use the standard basis:
  $T\left(\left(\begin{array}{l}1 \\ 0\end{array}\right)\right)=\left(\begin{array}{l}1 \\ 0 \\ 1\end{array}\right), \quad T\left(\left(\begin{array}{l}0 \\ 1\end{array}\right)\right)=\left(\begin{array}{l}1 \\ 1 \\ 0\end{array}\right)$.
  $R(T)=\operatorname{span}\left\{\left(\begin{array}{l}1 \\ 0 \\ 1\end{array}\right),\left(\begin{array}{l}1 \\ 1 \\ 0\end{array}\right)\right\}$

$\mathrm{R}(T)=$ column space of $\boldsymbol{A}$. 
$\operatorname{rank}(T)=\operatorname{dim} \mathrm{R}(T)=\operatorname{dim}$ (coln space of $\boldsymbol{A})=\operatorname{rank}(\boldsymbol{A})$

**Kernel:** $\operatorname{Ker}(T)=\left\{\boldsymbol{v} \in \mathbb{R}^n \mid T(\boldsymbol{v})=\boldsymbol{0}\right\} \subseteq \mathbb{R}^n$

**Properties:**

- $\mathrm{R}(T)=$ column space of $\boldsymbol{A}$.
	- $\operatorname{rank}(T)=\operatorname{rank}(\boldsymbol{A})$.
- $\operatorname{Ker}(T)=$ nullspace of $\boldsymbol{A}$.
	- $\operatorname{nullity}(T)=\operatorname{nullity}(\boldsymbol{A})$.
- Recall Dimension Theorem for Matrices:
	- $\operatorname{rank}(\boldsymbol{A})+\operatorname{nullity}(\boldsymbol{A})=$ number of colns of $\boldsymbol{A}=n$.
	- $\therefore \operatorname{rank}(T)+\operatorname{nullity}(T)=n=$ dimension of domain.
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
11. For standard matrix $\boldsymbol{A}$ of $T$: $\boldsymbol{A} = \operatorname{Ker}(T)={0}$

## Examples

Consider the vector equation
$$
c_1 \boldsymbol{w}_1+c_2 \boldsymbol{w}_2+c_3 \boldsymbol{w}_3=\mathbf{0}
$$
Substituting $w_1=v_1+2 v_2, w_2=v_2+2 v_3$ and $w_3=v_3$ into $(\dagger)$, we have
$$
\begin{aligned}
& c_1\left(\boldsymbol{v}_{\mathbf{1}}+2 \boldsymbol{v}_{\mathbf{2}}\right)+c_2\left(\boldsymbol{v}_{\mathbf{2}}+2 \boldsymbol{v}_{\mathbf{3}}\right)+c_3 \boldsymbol{v}_{\mathbf{3}}=\mathbf{0} \\
\Rightarrow \quad & c_1 \boldsymbol{v}_{\mathbf{1}}+\left(2 c_1+c_2\right) \boldsymbol{v}_{\mathbf{2}}+\left(2 c_2+c_3\right) \boldsymbol{v}_{\mathbf{1}}=\mathbf{0} .
\end{aligned}
$$
Since $S$ is linearly independent, the coefficients in the equation ( $\ddagger$ ) must be all zero, i.e.
$$
\left\{\begin{aligned}
c_1 & =0 \\
2 c_1+c_2 & =0 \\
2 c_2+c_3 & =0
\end{aligned}\right.
$$
which implies $c_1=0, c_2=0, c_3=0$.
Since the equation $(\dagger)$ has only the trivial solution, $T$ is linearly independent.
On the other hand, $|T|=|S|=\operatorname{dim}(W)$. We conclude that $T$ is a basis for $W$.