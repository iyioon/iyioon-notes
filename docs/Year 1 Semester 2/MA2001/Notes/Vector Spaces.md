# Vector Spaces

<span class="center-menu">[MA2001-Chapter3](MA2001-Chapter3.pdf)</span>
## Vector

The arrow from the origin $O$ to the point $P$ is called a vector, denoted by $\overrightarrow{O P}=v=(a, b)$.

Its length is $\|\boldsymbol{v}\|=\sqrt{v_1^2+v_2^2}$

## Euclidean Spaces

The Euclidean $n$-space (or simply $n$-space) is the set of all $n$-vectors of real numbers.

$\mathbb{R}^n=\left\{\left(v_1, v_2, \ldots, v_n\right) \mid v_1, v_2, \ldots, v_n \in \mathbb{R}\right\}$
$\boldsymbol{v} \in \mathbb{R}^n$ if and only if $\boldsymbol{v}$ is of the form
$\boldsymbol{v}=\left(v_1, v_2, \ldots, v_n\right)$ for real numbers $v_1, v_2, \ldots, v_n$.

## Implicit and Explicit Forms

Visit [](MA2001-Chapter3.pdf#page=9)

## Linear Combination 

Visit [](MA2001-Chapter3.pdf#page=13)

![Chapter 3 Linear combination Example](../Attachments/Chapter%203%20Linear%20combination%20Example.png)

Treat the vectors as column vectors.

## Linear Span

The set of all linear combination

Visit [](MA2001-Chapter3.pdf#page=15)

### Criterion for $\operatorname{span}(S)=\mathbb{R}^n$

Visit [](MA2001-Chapter3.pdf#page=17)

Let $S=\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \ldots, \boldsymbol{v}_k\right\} \subseteq \mathbb{R}^n$.
1. View each $\boldsymbol{v}_j$ as a column vector.
2. Let $\boldsymbol{A}=\left(\begin{array}{llll}\boldsymbol{v}_1 & \boldsymbol{v}_2 & \cdots & \boldsymbol{v}_k\end{array}\right)$.
3. Find a row-echelon form $\boldsymbol{R}$ of $\boldsymbol{A}$.
	- If $\boldsymbol{R}$ has a zero row, then $\operatorname{span}(S) \neq \mathbb{R}^n$.
	- If $\boldsymbol{R}$ has no zero row, then $\operatorname{span}(S)=\mathbb{R}^n$.

### Properties of Linear Spans

Visit [](MA2001-Chapter3.pdf#page=19)

### To show $span ({u_{1},u_{2},\dots)=span({v_{1},v_{2}\dots})}$ 

[](MA2001-Chapter3.pdf#page=22%7CExample)

## Subspaces

Visit [](MA2001-Chapter3.pdf#page=23)

In the form Let $V_1=\{(a+4 b, a) \mid a, b \in \mathbb{R}\}$. [](MA2001-Chapter3.pdf#page=24%7CExample)

In the form Let $V_2=\{(x, y, z) \mid x+y-z=0\}$.[](MA2001-Chapter3.pdf#page=24%7CExample)

_Important_ Recall that a subspace $V$ is of the form $\operatorname{span}(S)$. Then

- $\mathbf{0} \in V$,
- $c \in \mathbb{R} \& \boldsymbol{v} \in V \Rightarrow c \boldsymbol{v} \in V$,
- $\boldsymbol{u} \in V \& v \in V \Rightarrow \boldsymbol{u}+\boldsymbol{v} \in V$.

If any of the above fails, then $V$ is not a subspace (of $\mathbb{R}^n$ ). [](MA2001-Chapter3.pdf#page=24)

### Solution Space

Visit [](MA2001-Chapter3.pdf#page=26)

## Linear Independence


Visit [](MA2001-Chapter3.pdf#page=29)

[](MA2001-Chapter3.pdf#page=30%5C%7CProperties)

## Vector Spaces

Visit [](MA2001-Chapter3.pdf#page=34)

Definition. A set $V$ is called a _vector space_ if

- $V$ is a subspace of $\mathbb{R}^n$ for some positive integer $n$.

If $W$ and $V$ are vector spaces such that $W \subseteq V$,

- then $W$ is a _subspace_ of $V$.

## Bases

Visit [](MA2001-Chapter3.pdf#page=34)

Definition. Let $S=\left\{\boldsymbol{v}_1, \ldots, \boldsymbol{v}_k\right\}$ be a subset of a vector space $V$. Then $S$ is called a basis (plural bases) for $V$ if

- $S$ is linearly independent, and $\operatorname{span}(S)=V$.

**Example**
Let $S=\{(1,1,1,1),(0,0,1,2),(-1,0,0,1)\}$.

- Let $|S|$ be the number of vectors in $S$. Then $|S|=3$.
- So $\operatorname{span}(S) \neq \mathbb{R}^4$; thus $S$ is NOT a basis for $\mathbb{R}^4$.

[](MA2001-Chapter3.pdf#page=36%5C%7CProperties)

## Coordinate Vector

Visit [](MA2001-Chapter3.pdf#page=37)

**Definition**. Let $S=\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \ldots, \boldsymbol{v}_k\right\}$ be a basis for a vector space $V$.

- For every $\boldsymbol{v} \in V$, there exist unique $c_1, \ldots, c_k \in \mathbb{R}$ s.t.
	- $\boldsymbol{v}=c_1 \boldsymbol{v}_1+c_2 \boldsymbol{v}_2+\cdots+c_k \boldsymbol{v}_k$.
	  $c_1, c_2, \ldots, c_k$ are the coordinates of $v$ relative to $S$.
	- $\left(c_1, c_2, \ldots, c_k\right)$ is the coordinate vector of $\boldsymbol{v}$ relative to the basis $S$, denoted by $(\boldsymbol{v})_S$.

The order matters

## Standard Basis

Visit [](MA2001-Chapter3.pdf#page=39)


## Criterion for Bases

Visit [](MA2001-Chapter3.pdf#page=42)

Theorem. Let $\boldsymbol{A}$ be a square matrix of order $n$. Then the following are equivalent:

1. $\boldsymbol{A}$ is invertible.
2. $\boldsymbol{A x}=\boldsymbol{b}$ has a unique solution.
3. $\boldsymbol{A x}=\mathbf{0}$ has only the trivial solution.
4. The reduced row-echelon form of $A$ is $I_n$.
5. $\boldsymbol{A}$ is a product of elementary matrices.
6. $\operatorname{det}(\boldsymbol{A}) \neq 0$.
7. The rows of $\boldsymbol{A}$ form a basis for $\mathbb{R}^n$.
8. The columns of $\boldsymbol{A}$ form a basis for $\mathbb{R}^n$.
## Dimension

$\operatorname{dim}(V+W)=\operatorname{dim}(V)+\operatorname{dim}(W)-\operatorname{dim}(V \cap W)$. See example [](linear-algebra-concepts-and-techniques-on-euclidean-spaces.pdf#page=134%7CQ43%20&%2044)

Visit [](MA2001-Chapter3.pdf#page=43)

Number of non pivots.

## Transition Matrices

Visit [](MA2001-Chapter3.pdf#page=48)

[](MA2001-Chapter3.pdf#page=50%7CExample) of using transition matrix to get the coordinate vector relative to...
[](linear-algebra-concepts-and-techniques-on-euclidean-spaces.pdf#page=135%7CGood%20example%20Q49)
## Row Spaces and Column Spaces

Visit [](MA2001-Chapter4.pdf#page=2)

### How to find basis

Visit [](MA2001-Chapter4.pdf#page=9)

**Using Row Space:** View the vectors as row vector. Turn it into REF. The non zero rows of REF form the basis. However the basis are now different vectors.

**Using Column Space**:

![Vector Spaces Using Column Space to find the basis](../Attachments/Vector%20Spaces%20Using%20Column%20Space%20to%20find%20the%20basis.png)

### How to extend $S$ to a basis for $R^n$

Visit [](MA2001-Chapter4.pdf#page=10)

### Consistency

Visit [](MA2001-Chapter4.pdf#page=11)


## Rank

Visit [](MA2001-Chapter4.pdf#page=12)

**Theorem:** The dimension of the row space of $A$ = the dimension of the column space of $A$.

_Rank_ of A, denoted by rank($A$): the dimension of the row (or column) space of $A$

- rank ($A$) = rank($A^T$)
- rank($A$) = 0
- $\operatorname{rank}(\boldsymbol{A}) \leq m$ and $\operatorname{rank}(\boldsymbol{A}) \leq n$
	- $\operatorname{rank}(\boldsymbol{A}) \leq \min \{m, n\}$.
	- $\boldsymbol{A}$ is called full rank if $\operatorname{rank}(\boldsymbol{A})=\min \{m, n\}$.
- A square matrix $A$ is of full rank $\Leftrightarrow A$ is invertible.

### Rank & Consistency of Linear System

The inconsistency can also be determined by the rank.

Suppose $Ax=b$. 
- If $b$ belong to the column space of $A$ then, rank($A$) = rank($A|b$)
- Else rank($A$) = rank($A|b$)+1

Visit [](MA2001-Chapter4.pdf#page=14)

### Properties

Visit [](MA2001-Chapter4.pdf#page=15)

## Null Space and Nullity

The nullspace of $A$ is the solution space of $\boldsymbol{A x}=\mathbf{0}$ 

The dimension of the nullspace is called the nullity of $\boldsymbol{A}$, denoted by nullity $(\boldsymbol{A})$.

**Notation**. From now on, unless otherwise stated,
vectors in nullspace are viewed as column vectors.

Visit [](MA2001-Chapter4.pdf#page=16)

### Dimension Theorem

Theorem. Let $\boldsymbol{A}$ be an $m \times n$ matrix. Then
$$
\operatorname{rank}(\boldsymbol{A})+\operatorname{nullity}(\boldsymbol{A})=n \text {. }
$$

Visit [](MA2001-Chapter4.pdf#page=17)


### Inhomogeneous Linear System

Visit [](MA2001-Chapter4.pdf#page=19)
