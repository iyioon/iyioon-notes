# HW1 Written
<span class="right-menu">Moon Ji Hoon<br>A0255555X</span>
## Question 1

$$
\begin{aligned}
a x+y+z & =a^3 \\
x+a y+z & =1 \\
x+y+a z & =a
\end{aligned}
$$

**Into Augmented matrix**:
$$
\left(\begin{array}{lll|l}
a & 1 & 1 & a^3 \\
1 & a & 1 & 1 \\
1 & 1 & a & a
\end{array}\right)
$$
**Into row-echelon form**:
When $a \neq 0$ and $a \neq-1$ 
$$
\begin{aligned}
& \stackrel{R_3-R_2}{\longrightarrow}\left(\begin{array}{ccc|c}
a & 1 & 1 & a^3 \\
1 & a & 1 & 1 \\
0 & 1-a & a-1 & a-1
\end{array}\right) \\
& R_2 \longleftrightarrow R_1\left(\begin{array}{ccc|c}
1 & a & 1 & 1 \\
a & 1 & 1 & a^3 \\
0 & 1-a & a-1 & a-1
\end{array}\right) \\
& \stackrel{R_2-a R_1}{\longrightarrow}\left(\begin{array}{ccc|c}
1 & a & 1 & 1 \\
0 & 1-a^2 & 1-a & a^3-a \\
0 & 1-a & a-1 & a-1
\end{array}\right) \\
& \stackrel{(1+a) R_3}{\longrightarrow}\left(\begin{array}{ccc|c}
1 & a & 1 & 1 \\
0 & 1-a^2 & 1-a & a^3-a \\
0 & 1-a^2 & a^2-1 & a^2-1
\end{array}\right) \\
& \stackrel{R_3-R_2}{\longrightarrow}\left(\begin{array}{ccc|c}
1 & a & 1 & 1 \\
0 & 1-a^2 & 1-a & a^3-a \\
0 & 0 & a^2+a-2 & -a^3+a^2+a-1
\end{array}\right)
\end{aligned}
$$

When $a=0$, there is a unique solution.
$$
\left(\begin{array}{lll|l}
a & 1 & 1 & a^3 \\
1 & a & 1 & 1 \\
1 & 1 & a & a
\end{array}\right)=\left(\begin{array}{lll|l}
0 & 1 & 1 & 0 \\
1 & 0 & 1 & 1 \\
1 & 1 & 0 & 0
\end{array}\right)=\left(\begin{array}{lll|l}
1 & 0 & 1 & 1 \\
0 & 1 & 1 & 0 \\
0 & 0 & 1 & \frac{1}{2}
\end{array}\right)
$$

When $a=-1$, there is a unique solution.

$$
\left(\begin{array}{ccc|c}
a & 1 & 1 & a^3 \\
1 & a & 1 & 1 \\
1 & 1 & a & a
\end{array}\right)=\left(\begin{array}{ccc|c}
-1 & 1 & 1 & -1 \\
1 & -1 & 1 & 1 \\
1 & 1 & -1 & -1
\end{array}\right)=\left(\begin{array}{ccc|c}
1 & 0 & 0 & 0 \\
0 & 1 & 1 & 0 \\
0 & 0 & 1 & \frac{1}{2}
\end{array}\right)
$$

<div style="page-break-after: always;"></div>

Taking consideration when $a=0$ and $a\neq-1$,  the condition for no solution, unique solution and infinitely many solutions can be obtained:

### 1 No solution

The last column is a pivot column.

$a^2+a-2=0 ,\quad -a^3+a^2+a-1 \neq 0$
$(a+2)(a-1)=0 ,\quad  a \neq-1 ,1$

There is no solution when $a=-2$ 

### 2 A unique solution

The last column is a non-pivot column.
All other columns are pivot columns.

$a^2+a-2 \neq 0 \quad$
$1-a^2 \neq 0 \quad$ 

There is a unique solution when $a \neq 1,-2$

### 3 Infinitely many solutions

The last column is a non pivot column.
Some columns are non pivot columns.

$a^2+a-2 \neq 0$ or $a = 1$
$1-a^2 =  0$

The system has infinitely many solutions when  $a=1$ 

## Question 2

$$
A=\left(\begin{array}{ccc}
b & b & 1 \\
a & -a & 0 \\
a - 2 & a+1 & 0
\end{array}\right)
$$
$$
\begin{aligned}
\operatorname{det}(A) & =b\left|\begin{array}{cc}
-a & 0 \\
a+1 & 0
\end{array}\right|-b\left|\begin{array}{cc}
a & 0 \\
a-2 & 0
\end{array}\right|+\left|\begin{array}{cc}
a & -a \\
a-2 & a+1
\end{array}\right| \\
& =b(0-0)-b(0-0)+\left(a^2+a-(-a^2+2 a)\right) \\
& =2a^2-a \\
& =a(2a-1)
\end{aligned}
$$
$A$ is invertible iff  $\det(\mathrm{A}) \neq 0$.
Hence $a \neq 0,a \neq \frac{1}{2} \quad b \in \mathbb{R}$.

<div style="page-break-after: always;"></div>

## Question 3

$$
\begin{aligned}
B & =\left(\begin{array}{ccc}
1 & -1 & 0 \\
0 & 1 & 0 \\
0 & 0 & 1
\end{array}\right)^{-1}\left(\begin{array}{lll}
0 & 0 & 1 \\
0 & 1 & 0 \\
1 & 0 & 0
\end{array}\right)^{-1}\left(\begin{array}{lll}
1 & 0 & 0 \\
0 & 1 & 0 \\
0 & 0 & 2
\end{array}\right)^{-1} A \\
& =\left(\begin{array}{lll}
1 & 1 & 0 \\
0 & 1 & 0 \\
0 & 0 & 1
\end{array}\right)\left(\begin{array}{lll}
0 & 0 & 1 \\
0 & 1 & 0 \\
1 & 0 & 0
\end{array}\right)\left(\begin{array}{lll}
1 & 0 & 0 \\
0 & 1 & 0 \\
0 & 0 & \frac{1}{2}
\end{array}\right) A
\end{aligned}
$$

Hence, $B$ can be obtained with the following elementary row operations on $A$:

1. $\frac{1}{2}R_{3}$
2. $R_{1}\leftrightarrow R_{3}$
3. $R_{1}+R_{2}$

## Question 4

Suppose $A=\left(a_{i j}\right)_{m \times n}$ and $B=\left(b_{i j}\right)_{n \times p}$.

Then, the $(i, j)$-entry of $A B: \sum_{k=1}^n a_{i k} b_{k j}$.

1. Suppose $A$ has a zero row.
	1. Then there exists $i_0$ such that $a_{i_0 j}=0$ for all $j$. 
	2. Thus the $\left(i_0, j\right)$-entry of $A B: \sum_{k=1}^n a_{i_0 k} b_{k j}=0$ for all $j$. 
2. Therefore $AB$ has a zero row as well.

## Question 5

Since $A$ is a square matrix, for every square matrix $B$ of order $n$: 
$$\operatorname{det}(A B)=\operatorname{det}(A) \operatorname{det}(B)=0 \times \operatorname{det}(B)=0$$
Hence $A B$ is singular.

## Question 6

$$A=\left(\begin{array}{lll}0 & 0 & 1 \\ 0 & 0 & 0 \\ 0 & 0 & 0\end{array}\right)$$

<div style="page-break-after: always;"></div>

## Question 7

$$
A=\left(\begin{array}{ll}
1 & 0 \\
0 & 0
\end{array}\right)
$$
$\operatorname{det}(A)=0$, hence $A$ is not invertible.
Therefore $A$ is not a product of elementary matrices.

## Question 8

If $A$ and $B$ are symmetric, $A=A^{T}$ and $B=B^{T}$. Therefore: 
$$
(A+B)^{T}=A^{T}+B^{T}=A+B
$$

## Question 9

### 1. $A$ is a square matrix

Suppose $A=\left(a_{i j}\right)_{n \times m}$ such that $A^T=kA$.

1. $A^T$ has size $m \times n$. 
2. Hence the size of $kA$ ($n\times m$) has to be equal to $m\times n$
3. Therefore $n=m$.
4. $A$ is a square matrix.


### 2.  $k = 1$ or $k = -1$

$$\begin{aligned} & A^T=k A \\ & \left(A^T\right)^T=(k A)^T \\ & A=k A^T \\ & A=k^2 A \\ & k=\pm 1\end{aligned}$$

