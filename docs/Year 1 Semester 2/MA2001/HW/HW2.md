# HW2 Written
<span class="right-menu">Moon Ji Hoon<br>A0255555X</span>

## Question 1


Let $V$ be a subset of $\mathbb{R}^n$. A subspace $V$ is of the form $\operatorname{span}(S)$:

- $0 \in V$,
- $c \in \mathbb{R}$ & $v \in V$ $\Rightarrow c v \in V$,
- $u \in V$ & $v \in V \Rightarrow u + v \in V$

Since there exists vectors $v_1, v_2 \in V$ such that $v_1-2 v_2 \notin V$, it fails the third criteria. Hence, $V$ is not a subspace of $\mathbb{R}^n$.

## Questions 2

### 1.  $\operatorname{span}\left\{\boldsymbol{u}_{\mathbf{1}}, \boldsymbol{u}_{\mathbf{2}}, \boldsymbol{u}_{\boldsymbol{3}}, \boldsymbol{u}_{\mathbf{4}}\right\}=\mathbb{R}^3$ 

$$\left(\begin{array}{cccc}-3 & 1 & 1 & 0 \\ 0 & 4 & 2 & 3 \\ 2 & 0 & -1 & -2\end{array}\right) \underset{\text { Elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{cccc}-3 & 1 & 1 & 0 \\ 0 & 4 & 2 & 3 \\ 0 & 0 & -\frac{2}{3} & -\frac{2}{5}\end{array}\right)$$

It has no zero row, hence $\operatorname{span}\left\{\boldsymbol{u}_{\mathbf{1}}, \boldsymbol{u}_{\mathbf{2}}, \boldsymbol{u}_{\boldsymbol{3}}, \boldsymbol{u}_{\mathbf{4}}\right\}=\mathbb{R}^3$

### 2. $\operatorname{span}\left\{\boldsymbol{u}_{\boldsymbol{1}}, \boldsymbol{u}_{\boldsymbol{2}}, \boldsymbol{u}_{\boldsymbol{3}}\right\}=\mathbb{R}^3$

$$\left(\begin{array}{cccc}-3 & 1 & 1 \\ 0 & 4 & 2 \\ 2 & 0 & -1 \end{array}\right) \underset{\text { Elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{cccc}-3 & 1 & 1  \\ 0 & 4 & 2 \\ 0 & 0 & -\frac{2}{3}\end{array}\right)$$

It has no zero row, hence $\operatorname{span}\left\{\boldsymbol{u}_{\boldsymbol{1}}, \boldsymbol{u}_{\boldsymbol{2}}, \boldsymbol{u}_{\boldsymbol{3}}\right\}=\mathbb{R}^3 ?$

### 3.  $\operatorname{span}\left\{\boldsymbol{u}_1, \boldsymbol{u}_2\right\}\neq\mathbb{R}^3$ 

Two vectors cannot span $\mathbb{R}^3$:

$$\left(\begin{array}{cccc}-3 & 1 \\ 0 & 4  \\ 2 & 0 \end{array}\right) \underset{\text { Elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{cccc}-3 & 1  \\ 0 & 4 \\ 0 & 0 \end{array}\right)$$

It has a zero row, hence $\operatorname{span}\left\{\boldsymbol{u}_1, \boldsymbol{u}_2\right\}\neq\mathbb{R}^3$. 

<div style="page-break-after: always;"></div>

## Question 3

Suppose  $A=\left(a_{i j}\right)_{m \times n}$ such that $Ax = 0$ for all $x \in \mathbb{R}^n$.
Let $E=\left\{\boldsymbol{e}_1, \boldsymbol{e}_2, \ldots, \boldsymbol{e}_n\right\}$ be a standard basis for $\mathbb{R}^n$. 

Then for all $e_{i}$, $Ae_{i}$ is equal to the $i^{th}$ column of $A$. Therefore every column of $A$ is zero, i.e $A=0$

## Question 4

### 1. Implicit form of $V$

$V=\{(t, 2 t, 3 t-1) \mid t \in \mathbb{R}\}$

Let $x = t$, $y=2t$, $z=3t-1$.

$$\left(\begin{array}{c|c}1 & x \\ 1 & \frac{y}{2} \\ 1 & \frac{{z+1}}{3} \end{array}\right) \underset{\text { elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{c|c}1 & x \\ 0 & \frac{y}{2}-x \\ 0 & \frac{{z+1}}{3}-x \end{array}\right)$$

The system is consistent. Therefore $\frac{y}{2}-x=0$, $\frac{{z+1}}{3}-x=0$

Implicit form: $\{(x, y, z) \mid y-2x=0\text{ } \&\text{ } z-3x=-1\}$

### 2. Is there a homogeneous linear system whose solution set is $V$ ?

No. A linear system is homogenous if every linear equation of the system is homogenous. However, there is a non-zero constant term  in $z-3x=-1$.

## Question 5

### 1. Solution set of the given homogeneous linear system is a subspace of $\mathbb{R}^5$.

Theorem: The solution set of a homogenous linear system of $n$ variables is a subspace of $\mathbb{R}^n$.

$A$ into reduced row echelon form: 

$$\left(\begin{array}{ccccc}2 & 3 & 1 & -1 & 2 \\ -2 & 0 & -2 & 1 & -1 \\ 2 & 2 & -2 & 2 & 0\end{array}\right) \underset{\text { elimination }}{\stackrel{\text { Gaussian }}{\longrightarrow}}\left(\begin{array}{ccccc}1 & 0 & 0 & \frac{2}{5} & 0 \\ 0 & 1 & 0 & -\frac{3}{10} & \frac{1}{2} \\ 0 & 0 & 1 & -\frac{9}{10} & \frac{1}{2}\end{array}\right)$$

The system has infinitely many solutions:

$(x_{1},x_{2},x_{3},x_{4},x_{5})=\left( -\frac{2}{5}s, \frac{3}{10}s-\frac{1}{2}t, \frac{9}{10}s-\frac{1}{2}t, s, t \right)$

$=s\left( -\frac{2}{5}, \frac{3}{10}, \frac{9}{10}, 1, 0 \right)+t\left( 0, -\frac{1}{2},-\frac{1}{2},0,1 \right)$

The solution space is $\operatorname{span}\left( -\frac{2}{5}, \frac{3}{10}, \frac{9}{10}, 1, 0 \right)+\left( 0, -\frac{1}{2},-\frac{1}{2},0,1 \right)$. So the solution set is a subspace of $\mathbb{R}^5$

<div style="page-break-after: always;"></div>

### 2. $\boldsymbol{A} \boldsymbol{x}=\boldsymbol{b}$, where $\boldsymbol{b}=\left(\begin{array}{c}1 \\ -2 \\ -2\end{array}\right)$

Column 3 in matrix $A$ is equal to $b$. Hence the row echelon form of the augmented matrix can be obtained by copying over the result of Gaussian elimination in column 3:

$$
\left(\begin{array}{ccccc|c}
1 & 0 & 0 & \frac{2}{5} & 0 & 0 \\
0 & 1 & 0 & -\frac{3}{10} & -\frac{1}{2} & 0\\
0 & 0 & 1 & -\frac{9}{10} & \frac{1}{2} & 1\\
\end{array}\right)
$$

The general solution to the linear system is the addition of the homogeneous solution ($Ax=0$) and the particular solution ($Ax=b$):

$$(x_{1},x_{2},x_{3},x_{4},x_{5})=\left( -\frac{2}{5}s,\frac{3}{10}s-\frac{1}{2}t, 1+\frac{9}{10}s-\frac{1}{2}t, s, t \right)$$
