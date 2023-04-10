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

### 1.2 Prove that $\operatorname{span}\left\{\boldsymbol{u}_1, \boldsymbol{u}_2, \boldsymbol{u}_3\right\}=\operatorname{span}\left\{\boldsymbol{v}_1, \boldsymbol{v}_2, \boldsymbol{v}_3\right\}$.

$v_{1},v_{2},v_{3}$ are a linear combination of $u_{1},u_{2},u_{3}.$ Also since both set of vectors are orthonormal, they are linearly independent. Therefore, they must span the same vector space.

## Question 2

### 2.1

Suppose $V$ is a subspace of $\mathbb{R}^n$ with $\dim(V) = k$. Then, there exists a basis $\{v_1, v_2, \dots, v_k\}$ for $V$. Since these vectors are linearly independent, there exists a $n \times k$ matrix whose columns form an orthonormal set. 

Let $\mathbf{A}=\left[\begin{array}{c}\boldsymbol{a}_{1} \\ \vdots \\ \boldsymbol{a}_{k}\end{array}\right]$ , a  $k \times n$ matrix where the rows are the transpose of the orthonormal basis. Then, since the columns of $A^T$ form an orthonormal set, $AA^T=I_{k}$.

Next, let $w \in\mathbb{R}^n$. If $u$ is a least square solution to $A^Tx=w$, then $A^Tu$ is the projection of $w$ onto $V$.   $u$ can be calculated by 

$$\begin{align}
AA^Tx=Aw \\
u=AA^T Aw
\end{align}$$

Therefore, the projection $p=A^TAA^T Aw=A^TAw$.

### 2.2 Prove that $\left(\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}\right)^2=\boldsymbol{A}^{\mathrm{T}} \boldsymbol{A}$.

$$
\begin{align}

(A^TA)^2 &= A^TAA^TA \\ \\
&= A^TI_{k}A\\
&=A^TA
\end{align}
$$

## Question 3

### 3.1 Computer the characteristic polynomial of $A$

$$\begin{aligned} \operatorname{det}(\lambda I-A) & =\left|\begin{array}{ccc}\lambda-1 & 2 & 0 \\ -1 & \lambda+1 & 0 \\ 2 & 1 & \lambda+2\end{array}\right| \\ & =(\lambda+2)\left|\begin{array}{cc}\lambda-1 & 2 \\ -1 & \lambda+1\end{array}\right| \\ & =(\lambda+2)\left(\lambda^2-1+2\right) \\ & =(\lambda+2)\left(\lambda^2+1\right) \\ & =\lambda^3+2 \lambda^2+\lambda+2 \\ & =\left(\lambda^2+1\right)(\lambda+2)\end{aligned}$$
### 3.2 Prove that $A$ is not diagonalizable.

The eigenvalues values are $i,-i$ and $-2$. Since some of the eigenvalues are not real, $A$ is not diagonalizable.

<div style="page-break-after: always;"></div>

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

<div style="page-break-after: always;"></div>

## Question 5

### 5.1 Write down a $3 \times 3$ matrix $\boldsymbol{A}$

$$A=\left(\begin{array}{ccc}0 & 1 & 0 \\ 0 & 0 & 1 \\ 4 & 4 & -1\end{array}\right)$$

### 5.2 Without computing any eigenvectors, explain why $\boldsymbol{A}$ is diagonalizable.

$$\begin{aligned} \operatorname{det}(\lambda I-A) & =\left|\begin{array}{ccc}\lambda & -1 & 0 \\ 0 & \lambda & -1 \\ -4 & -4 & \lambda+1\end{array}\right| \\ 
& =\lambda\left|\begin{array}{cc}\lambda & -1 \\ 0 & \lambda\end{array}\right| + \left|\begin{array}{cc}0 & -1 \\ -4& \lambda+1\end{array}\right|\\ 
& = \lambda^3+\lambda^2-4 \lambda-4\end{aligned}$$
The eigenvalues values are $\lambda=-2,2,-1$. There are 3 distinct eigenvalues and since $A$ is a $3\times 3$ matrix, $A$ is diagonalizable.

### 5.3 Diagonalize $\boldsymbol{A}$

For each eigenvalues, find the bases for eigenspace:

$$\begin{aligned} & \left(\begin{array}{ccc}-2 & -1 & 0 \\ 0 & -2 & -1 \\ -4 & -4 & -1\end{array}\right) \stackrel{G \cdot E}{\longrightarrow}\left(\begin{array}{lll}1 & 0 & -\frac{1}{4} \\ 0 & 1 & \frac{1}{2} \\ 0 & 0 & 0\end{array}\right) \\ & E_{-2}=\operatorname{Span}\left\{\left(\begin{array}{l} \frac{1}{4} \\ -\frac{1}{2} \\ 1\end{array}\right)\right\}\end{aligned}$$

$$\begin{aligned} & \left(\begin{array}{ccc}2 & -1 & 0 \\ 0 & 2 & -1 \\ -4 & -4 & 3\end{array}\right) \stackrel{G \cdot E}{\longrightarrow}\left(\begin{array}{lll}1 & 0 & -\frac{1}{4} \\ 0 & 1 & -\frac{1}{2} \\ 0 & 0 & 0\end{array}\right) \\ & E_{2}=\operatorname{Span}\left\{\left(\begin{array}{l} \frac{1}{4} \\ \frac{1}{2} \\ 1\end{array}\right)\right\}\end{aligned}$$

$$\begin{aligned} & \left(\begin{array}{ccc}-1 & -1 & 0 \\ 0 & -1 & -1 \\ -4 & -4 & 0\end{array}\right) \stackrel{G \cdot E}{\longrightarrow}\left(\begin{array}{lll}1 & 0 & -1 \\ 0 & 1 & 1 \\ 0 & 0 & 0\end{array}\right) \\ & E_{-1}=\operatorname{Span}\left\{\left(\begin{array}{l} 1 \\ -1 \\ 1\end{array}\right)\right\}\end{aligned}$$
Next, $\boldsymbol{P}=\left(\begin{array}{ccc} \frac{1}{4} & \frac{1}{4} & 1 \\ -\frac{1}{2} & \frac{1}{2} & -1 \\ 1 & 1 & 1\end{array}\right)$. Then $\boldsymbol{P}^{-1} \boldsymbol{A P}=\left(\begin{array}{lll}-2 & 0 & 0 \\ 0 & 2 & 0 \\ 0 & 0 & -1\end{array}\right)$.
### 5.4 Use the previous parts to derive a (non-recursive) formula for $a_n$ in terms of $n$.


$$
\left(\begin{array}{l}
a_{n+1} \\
a_{n+2} \\
a_{n+3}
\end{array}\right)=A\left(\begin{array}{l}
a_n \\
a_{n+1} \\
a_{n+2}
\end{array}\right)=A^{n+1}\left(\begin{array}{l}
a_0 \\
a_1 \\
a_2
\end{array}\right)=PD^{n+1}P^{-1}\left(\begin{array}{l}
0 \\
0 \\
1
\end{array}\right)
$$
$$
= \left(\begin{array}{ccc}
\frac{1}{4} & \frac{1}{4} & 1 \\
-\frac{1}{2} & \frac{1}{2} & -1 \\
1 & 1 & 1
\end{array}\right)\left(\begin{array}{ccc}
(-2)^{n+1} & 0 & 0 \\
0 & 2^{n+1} & 0 \\
0 & 0 & (-1)^{n+1}
\end{array}\right)\left(\begin{array}{ccc}
-2 & -1 & 1 \\
\frac{2}{3} & 1 & \frac{1}{3} \\
\frac{4}{3} & 0 & -\frac{1}{3}
\end{array}\right)\left(\begin{array}{l}
0 \\
0 \\
1
\end{array}\right)
$$
$$
=\left(\begin{array}{c}
-\frac{-2\left(2^{n-1}-(-1)^{n+1}\right)+3(-2)^n}{6} \\
\frac{2^n+(-1)^{n+1}+3(-2)^n}{3} \\
\frac{3(-2)^{n+1}-2^{n+1}-(-1)^{n+1}}{3}
\end{array}\right)
$$

Substituting the result to  $a_{n+3}=-a_{n+2}+4 a_{n+1}+4 a_n$ gives

$$
a_{n}=\frac{-9(-2)^n+2^n-2^{n+2}+4(-1)^{n+1}+3(-2)^{n+1}}{12}
$$

### 5.5 Is $\boldsymbol{A}$ orthogonally diagonalizable?

No because it is not symmetric.