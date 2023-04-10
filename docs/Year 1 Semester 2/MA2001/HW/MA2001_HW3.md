# HW3 Written
<span class="right-menu">Moon Ji Hoon<br>A0255555X</span>
## 1. Compute a basis for the nullspace of

$$\boldsymbol{A}=\left(\begin{array}{ccccc}2 & 2 & 0 & -2 & 3 \\ -2 & 3 & -3 & 3 & -2 \\ 0 & 4 & -3 & -2 & 3 \end{array}\right)$$
$$(\boldsymbol{A} \mid \mathbf{0}) \stackrel{\text { G.J. }}{\longrightarrow}\left(\begin{array}{lllll|l}1 & 0 & 0 & -4 & \frac{7}{2} & 0 \\ 0 & 1 & 0 & 3 & -2 & 0 \\ 0 & 0 & 1 & \frac{14}{3} & -\frac{11}{3} & 0 \end{array}\right)$$
$$\boldsymbol{A} \boldsymbol{x}=\mathbf{0} \Leftrightarrow \boldsymbol{x}=\left(\begin{array}{c}4s-\frac{7}{2}t \\ -3s+2t \\ -\frac{14}{3}s+\frac{11}{3}t \\ s \\ t\end{array}\right)=s\left(\begin{array}{c}4 \\ -3 \\ -\frac{14}{3} \\ 1 \\ 0\end{array}\right)+t\left(\begin{array}{c}-\frac{7}{2} \\ 2 \\ \frac{11}{3} \\ 0 \\ 1\end{array}\right)$$

Hence, a basis for the nullspace of $A$ is given by $\left\{\left( 4,-3,-\frac{14}{3},1,0 \right)^{\mathrm{T}},\left( -\frac{7}{2},2,\frac{11}{3},0,1 \right)^{\mathrm{T}}\right\}$.

## 2. Computer a basis for the vector space

$\text{let } V=\left\{(s-2 t,-s-2 u, 3 s+t+5 u, 3 s-2 t+4 u) \in \mathbb{R}^4 \mid s, t, u \in \mathbb{R}\right\}$

Every vector in $V$ is of the form

$$s\left(\begin{array}{c}1 \\ -1 \\ 3 \\ 3 \end{array}\right)+t\left(\begin{array}{c}-2 \\ 0 \\ 1 \\ -2 \end{array}\right)+u\left(\begin{array}{c}0 \\ -2 \\ 5 \\ 4 \end{array}\right)$$

Hence $V =\text{span}\{(1,-1,3-3),(-2,0,1,-2),(0,-2,5,4)\}$. 

To find the basis for the vector space $V$, view each vector as a row vector and form a matrix:

$$\left(\begin{array}{cccc}1 & -1 & 3 & -3 \\ -2 & 0 & 1 & -2 \\ 0 & -2 & 5 & 4\end{array}\right) \stackrel{R_2+2 R_1}{\longrightarrow}\left(\begin{array}{cccc}1 & -1 & 3 & -3 \\ 0 & -2 & 7 & -8 \\ 0 & -2 & 5 & 4\end{array}\right) \stackrel{R_3-R_2}{\longrightarrow}\left(\begin{array}{cccc}1 & -1 & 3 & -3 \\ 0 & -2 & 7 & -8 \\ 0 & 0 & -2 & 12\end{array}\right)$$

The above matrix have the same row space as $V$ and the nonzero rows are linearly independent.
Therefore, $V$ has a basis $\{(1,-1,3,-3),(0,-2,7,-8),(0,0,-2,12)\}$.

## 3. Prove that $\left\{\boldsymbol{x}, \boldsymbol{A} \boldsymbol{x}, \boldsymbol{A}^2 \boldsymbol{x}\right\}$ is linearly independent.

Suppose $\boldsymbol{A}$ is an $n \times n$ matrix and $\boldsymbol{x}$ is a vector in $\mathbb{R}^n$ such that $\boldsymbol{A}^3 \boldsymbol{x}=\mathbf{0}$ but $\boldsymbol{A}^2 \boldsymbol{x} \neq \mathbf{0}$.

Let $c_{1},c_{2},c_{3} \in \mathbb{R}$ such that 

$$c_{1}x+c_{2}Ax+c_{3}A^2x=0$$

Multiplying the equation by $A$ gives:

$$
\begin{aligned}
c_{1}Ax+c_{2}A^2x+c_{3}A^3x&=0 \\
c_{1}Ax+c_{2}A^2x&=0
\end{aligned}
$$

Multiplying the equation again by $A$ gives:

$$
\begin{aligned}
c_{1}A^2x+c_{2}A^3x&=0 \\
c_{1}A^2x&=0
\end{aligned}
$$

Since $A^2x\neq 0$, $c_{1}$ must be 0. 

Substituting back to equation $c_{1}Ax+c_{2}A^2x=0$ gives: 

$$
\begin{aligned}
c_{2}A^2x&=0
\end{aligned}
$$

Hence $c_{2}$ must be 0 as $A^2x\neq 0$

Lastly, substituting $c_{1},c_{2}$ to $c_{1}x+c_{2}Ax+c_{3}A^2x=0$ gives:

$$c_{3}A^2x=0$$
$c_{3}$ must be 0 as $A^2x\neq 0$.

Since $c_{1}=c_{2}=c_{3}=0$, the equation has only a trivial solution. 
$\{x,Ax,A^2x\}$ is linearly independent.

## 4. Suppose $M$ is the matrix $\left(\begin{array}{l|l}\boldsymbol{A} & \boldsymbol{B} \\ \hline \boldsymbol{C} & \boldsymbol{D}\end{array}\right)$ with blocks $\boldsymbol{A}, \boldsymbol{B}, \boldsymbol{C}, \boldsymbol{D}$.

### 1. For each of the following 3 cases, write down $1 \times 1$ matrices $\boldsymbol{A}, \boldsymbol{B}, \boldsymbol{C}, \boldsymbol{D}$ and nullity $(\boldsymbol{A})$, nullity $(\boldsymbol{M})$ such that:

1.   Let $\boldsymbol{A}=\begin{pmatrix}1\end{pmatrix}$ and $\boldsymbol{M}=\left(\begin{array}{ll}\boldsymbol{A} & \boldsymbol{B} \\ \boldsymbol{C} & \boldsymbol{D}\end{array}\right)=\left(\begin{array}{ll}1 & 0 \\ 0 & 0\end{array}\right)$. Then nullity $(\boldsymbol{A})=0$ and nullity $(\boldsymbol{M})=1$, so nullity $(\boldsymbol{M})>\operatorname{nullity}(\boldsymbol{A})$.
    
2.  Let $\boldsymbol{A}=\begin{pmatrix}1\end{pmatrix}$ and $\boldsymbol{M}=\left(\begin{array}{ll}\boldsymbol{A} & \boldsymbol{B} \\ \boldsymbol{C} & \boldsymbol{D}\end{array}\right)=\left(\begin{array}{ll}1 & 0 \\ 0 & 1\end{array}\right)$. Then nullity $(\boldsymbol{A})=0$ and nullity $(\boldsymbol{M})=0$, so nullity $(\boldsymbol{M})=\operatorname{nullity}(\boldsymbol{A})$.
    
3.  Let $\boldsymbol{A}=\begin{pmatrix}0\end{pmatrix}$ and $\boldsymbol{M}=\left(\begin{array}{ll}\boldsymbol{A} & \boldsymbol{B} \\ \boldsymbol{C} & \boldsymbol{D}\end{array}\right)=\left(\begin{array}{ll}0 & 1 \\ 1 & 0\end{array}\right)$. Then nullity $(\boldsymbol{A})=1$ and nullity $(\boldsymbol{M})=0$, so nullity $(\boldsymbol{M})<\operatorname{nullity}(\boldsymbol{A})$.

### 2. Prove that in general, $\operatorname{rank}(M) \geq \operatorname{rank}(\boldsymbol{A})$.

$\boldsymbol{A}$ is a $1 \times 1$ matrix, hence rank($A$) $\leq 1$.
$\boldsymbol{M}$ is a $2 \times 2$ matrix, hence rank($A$) $\leq 2$.

If $\boldsymbol{A}$ is a non zero matrix, the row-echelon form of $\boldsymbol{M}$ is: 

 $$\left(\begin{array}{ll}A & B \\ C & D\end{array}\right) \stackrel{R_2-\frac{C}{A} R_1}{\longrightarrow}\left(\begin{array}{ll}A & B \\ 0 & D-\frac{C B}{A}\end{array}\right)$$
 
Hence rank($M$) $\geq 1$.

If $\boldsymbol{A}=0$ , 

$$\boldsymbol{M}=\left(\begin{array}{ll}\boldsymbol{0} & \boldsymbol{B} \\ \boldsymbol{C} & \boldsymbol{D}\end{array}\right)$$

Hence, rank($M$) $\geq 0$.

In both cases, $\operatorname{rank}(M) \geq \operatorname{rank}(A)$.
## 5. Suppose $\boldsymbol{A}$ is an $m \times n$ matrix. Prove that if $\boldsymbol{A} \boldsymbol{x}=\mathbf{0}$ has a unique solution, then for every $\boldsymbol{b}$ in $\mathbb{R}^n$, the system $\boldsymbol{A}^{\mathrm{T}} \boldsymbol{u}=\boldsymbol{b}$ is consistent.


Suppose $Ax=0$ has a unique solution. Then:

- nullity of $A$ is 0 
- rank($A)=n$ (Dimension Theorem)

Since rank($A)=n$, all columns of $A$ are pivot columns. 

Also, $\operatorname{rank}(A^{\text{T}})=\operatorname{rank}(A)=n$ which implies that all rows of $A^{\mathrm{T}}$ contains a pivot.

Therefore, $\operatorname{rank}(A^{\mathrm{T}} \mid b) = \operatorname{rank}(A^{\mathrm{T}})$ as there will not be additional pivot column for $(A^{\mathrm{T}} \mid b)$
Hence $A^{\mathrm{T}} u=b$ is consistent every $b$ in $\mathbb{R}^n$

