# HW4 Written
<span class="right-menu">Moon Ji Hoon<br>A0255555X</span>
## Question 1

### 1.1 Prove that $\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \boldsymbol{v}_3\right\}$ is an orthonormal set of vectors.

Every vectors in $\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \boldsymbol{v}_3\right\}$ is is a unit vector:
<u></u>
$$
\begin{aligned}
v_1 \cdot v_1= & \left(\frac{2}{3} u_1+\frac{2}{3} u_2+\frac{1}{3} u_3\right) \cdot\left(\frac{2}{3} u_1+\frac{2}{3} u_2+\frac{1}{3} u_3\right) \\
= & \frac{4}{9} u_1 \cdot u_1+\frac{4}{9} u_1 \cdot u_2+\frac{2}{9} u_1 \cdot u_3 \\
& +\frac{4}{9} u_2 \cdot u_1+\frac{4}{9} u_2 \cdot u_2+\frac{2}{9} u_2 \cdot u_3 \\
& +\frac{2}{9} u_3\cdot u_1+\frac{2}{9} u_3 \cdot u_2+\frac{1}{9} u_3 \cdot u_3 \\
= & \frac{4}{9}+\frac{4}{9}+\frac{1}{9}=1
\end{aligned}
$$
Similarly,

$$
\begin{aligned}
&\begin{aligned}
v_2 \cdot v_2 & =\frac{1}{2} u_1 \cdot u_1+\frac{1}{2} u_2 \cdot u_2 \\
& =\frac{1}{2}+\frac{1}{2}=1
\end{aligned}\\
&\begin{aligned}
v_3 \cdot v_3 & =\frac{2}{36} u_1 \cdot u_1+\frac{2}{36} u_2 \cdot u_2+\frac{8}{9} u_3 \cdot u_3 \\
& =\frac{2}{36}+\frac{2}{36}+\frac{8}{9}=1
\end{aligned}
\end{aligned}
$$

$\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \boldsymbol{v}_3\right\}$ is orthogonal: 

$$
\begin{aligned}
v_1 \cdot v_2 & =\left(\frac{2}{3} u_1+\frac{2}{3} u_2+\frac{1}{3} u_3\right) \cdot\left(-\frac{1}{\sqrt{2}} u_1+\frac{1}{\sqrt{2}} u_2\right) \\
& =-\frac{2}{3 \sqrt{2}} u_1 \cdot u_1+\frac{2}{3 \sqrt{2}} u_2 \cdot u_2 \\
& =0 \\
v_1 \cdot v_3 & =\left(\frac{2}{3} u_1+\frac{2}{3} u_2+\frac{1}{3} u_3\right) \cdot\left(-\frac{\sqrt{2}}{6} u_1-\frac{\sqrt{2}}{6} u_2+\frac{2 \sqrt{2}}{3} u_3\right) \\
& =-\frac{2 \sqrt{2}}{18} u_1 \cdot u_1-\frac{2 \sqrt{2}}{18} u_2 \cdot u_2+\frac{2 \sqrt{2}}{9} u_3 \cdot u_3 \\
& =0 \\
v_2 \cdot v_3 & =\left(-\frac{1}{\sqrt{2}} u_1+\frac{1}{\sqrt{2}} u_2\right) \cdot\left(-\frac{\sqrt{2}}{6} u_1-\frac{\sqrt{2}}{6} u_2+\frac{2 \sqrt{2}}{3} u_3\right) \\
& =\frac{\sqrt{2}}{6 \sqrt{2}} u_1 \cdot u_1-\frac{\sqrt{2}}{6 \sqrt{2}} u_2 \cdot u_2 \\
& =0
\end{aligned}
$$

Hence $\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \boldsymbol{v}_3\right\}$ is an orthonormal set of vectors.

### 2. Prove that $\operatorname{span}\left\{\boldsymbol{u}_1, \boldsymbol{u}_2, \boldsymbol{u}_3\right\}=\operatorname{span}\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \boldsymbol{v}_3\right\}$.

$v_{1},v_{2},v_{3}$ are a linear combination of $u_{1},u_{2},u_{3}.$ Also since both set of vectors are orthonormal, they are linearly independent. Therefore, they must span the same vector space.

## Question 2

### Q 2.1

Suppose $V$ is a subspace of $\mathbb{R}^n$ with $\dim(V) = k$. Then, there exists a basis $\{v_1, v_2, \dots, v_k\}$ for $V$. Since these vectors are linearly independent, there exists a $n \times k$ matrix $A^T$ whose columns form an orthonormal set. Since the columns of $A^T$ form an orthonormal set, $AA^T=I_{k}$. 

Therefore there is a $k\times n$ matrix $A$ such that $A A^T=I_{k}$

Let $w \in\mathbb{R}^n$ and $A^T=\{a_{1},a_{2},\dots,a_{k}\}$ which is a orthonormal basis for the vector space $V$. The projection of $w$ onto $V$ is: 

$\left(\boldsymbol{w} \cdot \boldsymbol{a}_1\right) \boldsymbol{a}_1+\left(\boldsymbol{w} \cdot \boldsymbol{a}_2\right) \boldsymbol{a}_2+\cdots+\left(\boldsymbol{w} \cdot \boldsymbol{a}_k\right) \boldsymbol{a}_k$


and an invertible $k\times k$ upper triangular matrix $R$ such that $A=QR$.




## Question 3

### 3.1 Computer the characteristic polynomial of $A$

$$\begin{aligned} \operatorname{det}(\lambda I-A) & =\left|\begin{array}{ccc}\lambda-1 & -2 & 0 \\ 1 & \lambda+1 & 0 \\ -2 & -1 & \lambda+2\end{array}\right| \\ & =(\lambda+2)\left|\begin{array}{cc}\lambda-1 & -2 \\ 1 & \lambda+1\end{array}\right| \\ & =(\lambda+2)\left(\lambda^2-1+2\right) \\ & =(\lambda+2)\left(\lambda^2+1\right) \\ & =\lambda^3+2 \lambda^2+\lambda+2 \\ & =\left(\lambda^2+1\right)(\lambda+2)\end{aligned}$$
### 3.2 Prove that $A$ is not diagonalizable.

The eigenvalues values are $i,-i$ and $-2$. Since some of the eigenvalues are not real, $A$ is not diagonalizable.

## Question 4

### 4.1 Compute all eigenvalues of $\boldsymbol{A}$.

$$\boldsymbol{A}=\left(\begin{array}{ccc}-3 & 2 & -2 \\ 2 & -3 & 4 \\ 4 & -5 & 6\end{array}\right)$$

$$\operatorname{det}(A-\lambda I)=\left|\begin{array}{ccc}-3-\lambda & 2 & -2 \\ 2 & -3-\lambda & 4 \\ 4 & -5 & 6-\lambda\end{array}\right|=-\lambda^3+3 \lambda-2$$

$-\lambda^3+3 \lambda-2=-(\lambda-1) \cdot(\lambda+2) \cdot(\lambda-1)=0$

$\therefore\lambda=1,-2$

### 4.2 For each eigenvalue $\lambda$ of $\boldsymbol{A}$, compute a basis for the eigenspace $E_\lambda$.

$$\begin{aligned} & \left(\begin{array}{ccc}-4 & 2 & -2 \\ 2 & -4 & 4 \\ 4 & -5 & 5\end{array}\right) \stackrel{G \cdot E}{\longrightarrow}\left(\begin{array}{lll}1 & 0 & 0 \\ 0 & 1 & -1 \\ 0 & 0 & 0\end{array}\right) \\ & E_{1}=\operatorname{Span}\left\{\left(\begin{array}{c}0 \\ 1 \\ 1\end{array}\right)\right\}\end{aligned}$$

$$\begin{aligned} & \left(\begin{array}{ccc}-1 & 2 & -2 \\ 2 & -1 & 4 \\ 4 & -5 & 8\end{array}\right) \stackrel{G \cdot E}{\longrightarrow}\left(\begin{array}{lll}1 & 0 & 2 \\ 0 & 1 & 0 \\ 0 & 0 & 0\end{array}\right) \\ & E_{-2}=\operatorname{Span}\left\{\left(\begin{array}{c}-2 \\ 0 \\ 1\end{array}\right)\right\}\end{aligned}$$

### 4.3 Prove that $\boldsymbol{A}$ is not diagonalizable.

$\boldsymbol{A}$ has two linearly independent eigenvectors. However $A$ is a square matrix of order $3$. Therefore, $\boldsymbol{A}$ is not diagonalizable.
## Question 5

### 5.2 Without computing any eigenvectors, explain why $\boldsymbol{A}$ is diagonalizable.

$A$ is symmetric, hence it is diagonalizable.