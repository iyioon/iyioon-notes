# 9 Double Integrals
---
## 9.1 Riemann Sum

**Objective:** We now seek to find volume under a surface and we arrive at the definition of a double integral.

Review [](4%20Integrals.md#4.6%20Riemann%20Sums%20and%20Definite%20Integrals%7CRiemann%20Sum)

---
## 9.2 Volume and Double Integral

Suppose $f(x,y)$ is a function of two variables defined on a close rectangle
$$R=[a,b]\times[c,d]=\{(x,y)\in \mathbb{R^{2}}:a\leq x\leq b,c\leq y\leq d\}$$

Let $S$ the volume of the solid that lies above $R$ and under the graph of $f$.
![c|300](../Attachments/Screen%20Shot%202022-10-25%20at%202.20.04%20PM.png)

**Definition. Double integral**
The double integral of $f$ over the rectangle $R$ is
$$\iint_Rf(x,y)dA=\lim_{m,n\to\infty}\sum\limits_{i=1}^{m} \sum\limits_{j=1}^{n}f(x_{ij}^*,y_{ij}^*)\Delta A$$

provided the limit exists and is the same of any choice of the sample points $(x_{ij}^*,y_{ij}^*)$ in $R_{ij}$, for $1 \leq i \leq m, 1 \leq j\leq n.$
When this happens, we say that $f$ is integratable over $R$.

**Volume as a Double Integral**
$$V = \iint_Rf(x,y)dA$$

**Properties of double integral:**
1. $\iint_R(f(x,y)+g(x,y))dA = \iint_Rf(x,y)dA + \iint_Rg(x,y)dA$
2. $\iint_Rcf(x,y)dA = c\iint_Rf(x,y)dA$
3. If $f(x,y)\geq g(x,y)$ for all $(x,y)\in R$, then
$\iint_R f(x, y) d A \geq \iint_R g(x, y) d A$

---
## 9.3 Iterated Double Integral

**Definition. Iterated Integral**
$$
\int_a^b \int_c^d f(x, y) d y d x
$$
means we first integrate with respect to $y$ from $c$ to $d$ (keeping $x$ fixed) and then with respect to $x$ from a to $b$.
$$
\int_c^d \int_a^b f(x, y) d x d y
$$
means we first integrate with respect to $x$ from a to $b$ (keeping $y$ fixed) and then with respect to $y$ from $c$ to $d$.

**Method**
$$\int_a^b \int_c^d f(x, y) d y d x=\int_a^b\left[\int_c^d f(x, y) d y\right] d x$$

**Fubini's Theorem**
If $f$ is continuous on the rectangle $R=[a, b] \times[c, d]$, then
$$
\iint_R f(x, y) d A=\int_a^b \int_c^d f(x, y) d y d x=\int_c^d \int_a^b f(x, y) d x d y
$$
More generally, this is true if we assume that $f$ is bounded on $R, f$ is discontinuous only on a finite number of smooth curves, and the iterated integrals exist.

---
## 9.4 Special Case

Sometimes $f(x, y)$ can be factored as the product of a function of $x$ only and a function of $y$ only. That is
$$
f(x, y)=g(x) h(y) .
$$
Then Fubini's Theorem gives
$$
\begin{aligned}
\iint_R f(x, y) d A &=\int_c^d \int_a^b g(x) h(y) d x d y \\
&=\int_c^d\left[\int_a^b g(x) h(y) d x\right] d y
\end{aligned}
$$
In the inner integral, $y$ is a constant, so $h(y)$ is a constant and we can write
$$
\begin{aligned}
\iint_R f(x, y) d A &=\int_c^d\left[h(y) \int_a^b g(x) d x\right] d y \\
&=\left(\int_a^b g(x) d x\right)\left(\int_c^d h(y) d y\right)
\end{aligned}
$$
since $\int_a^b g(x) d x$ is a constant.

---
## 9.5 Double Integral over General Region

**Definition. Type I Region**
A plane region $D$ is said to be of Type $I$ if it lies between the graphs of two continuous functions of $x$, that is,
$$
D=\left\{(x, y): a \leq x \leq b, g_1(x) \leq y \leq g_2(x)\right\}
$$
where $g_1(x)$ and $g_2(x)$ are continuous on $[a, b]$.
![c|500](../Attachments/Screen%20Shot%202022-10-25%20at%2012.19.28%20PM.png)
$$\iint_D f(x, y) d A=\int_a^b \int_{g_1(x)}^{g_2(x)} f(x, y) d y d x$$

**Definition. Type II Region**
A plane region $D$ is said to be of Type II if it lies between the graphs of two continuous functions of $y$, that is,
$$
D=\left\{(x, y): c \leq y \leq d, h_1(y) \leq x \leq h_2(y)\right\}
$$
where $h_1(y)$ and $h_2(y)$ are continuous on $[c, d]$.
![c|250](../Attachments/Screen%20Shot%202022-10-25%20at%2012.33.32%20PM.png)
$$
\iint_D f(x, y) d A=\int_c^d \int_{h_1(y)}^{h_2(y)} f(x, y) d x d y
$$
---
## 9.6 Decomposing Domain into Smaller Domains
$$
\iint_D f(x, y) d A=\iint_{D_1} f(x, y) d A+\cdots+\iint_{D_n} f(x, y) d A .
$$

---
## 9.7 Properties of Double Integral
1.
$$
\iint_D[f(x, y)+g(x, y)] d A=\iint_D f(x, y) d A+\iint_D g(x, y) d A
$$
2.
$$
\iint_D c f(x, y) d A=c \iint_D f(x, y) d A
$$
3.
If $f(x, y) \geq g(x, y)$ for all $(x, y) \in D$ then
$$
\iint_D f(x, y) d A \geq \iint_D g(x, y) d A
$$

---
## 9.8 An Application-Finding Area
We can use double integral to compute area of a region $D$ on the plane:

Let $f(x, y)=1$ over a given region $D$. Then the area of $D$ is
$$
A(D)=\iint_D 1 d A
$$
![c|400](../Attachments/Screen%20Shot%202022-10-25%20at%202.39.13%20PM.png)

---
## 9.9 Double Integrals in Polar Coordinates
Change to Polar Coordinates in Double Integral If $f$ is continuous on a polar rectangle $R$ given by
$$
R=\{(r, \theta): 0 \leq a \leq r \leq b, \alpha \leq \theta \leq \beta\}
$$
where $0 \leq \beta-\alpha \leq 2 \pi$, then
$$
\iint_R f(x, y) d A=\int_\alpha^\beta \int_a^b f(r \cos \theta, r \sin \theta) r d r d \theta
$$
The formula says that we convert from rectangle to polar coordinates in a double integral by:
- writing $x=r \cos \theta, y=r \sin \theta$
- using the appropriate limits of integration for $r$ and $\theta$
- replacing $d A$ by $r d r d \theta$ (<font style="color:#FF0000">do not forget the additional $r$ in $r d r d \theta$ </font>)

**Example** Evaluate $\iint_R\left(3 x+4 y^2\right) d A$ where $R$ is the region in the upper half-plane bounded by the circles $x^2+y^2=1$ and $x^2+y^2=4$.

**Solution**
The region $R$ is shown below:
![c|400](../Attachments/Screen%20Shot%202022-10-25%20at%202.49.23%20PM.png)
So
$$
R=\{(r, \theta): 1 \leq r \leq 2,0 \leq \theta \leq \pi\} .
$$
Changing to polar coordinates for double integral, we have
$$
\begin{aligned}
\iint_R\left(3 x+4 y^2\right) d A &=\int_0^\pi \int_1^2\left(3 r \cos \theta+4 r^2 \sin ^2 \theta\right) r d r d \theta \\
&=\int_0^\pi \int_1^2\left(3 r^2 \cos \theta+4 r^3 \sin ^2 \theta\right) d r d \theta \\
&=\int_0^\pi\left[r^3 \cos \theta+r^4 \sin ^2 \theta\right]_{r=1}^{r=2} d \theta \\
\iint_R\left(3 x+4 y^2\right) d A &=\int_0^\pi\left(7 \cos \theta+15 \sin ^2 \theta\right) d \theta \\
&=\int_0^\pi\left[7 \cos \theta+\frac{15}{2}(1-\cos 2 \theta)\right] d \theta \\
&=\left[7 \sin \theta+\frac{15 \theta}{2}-\frac{15}{4} \sin 2 \theta\right]_0^\pi \\
&=\frac{15 \pi}{2} .
\end{aligned}
$$
---
## 9.10 Surface Area

$$\iint_Dds= \iint_{D}\sqrt[]{f_x^2+f_y^2+1}dA$$

**Example:**
Find the surface area of the part of the plane $3 x+2 y+-z=6$ that lies in the first octant.
![c|400](../Attachments/Screen%20Shot%202022-10-25%20at%208.33.25%20AM.png)
**Method**
Interpret the function as two variable $x$ and $y$ 
$$
\begin{align*}
3x+2y=6\\
y=\frac{6-3x}{2}\\\\

\end{align*}
$$
$$
\begin{align*}
f_{x}=3\\
f_{y}=2\\
\end{align*}
$$
$$\iint_Dds= \int_0^2\int_0^\frac{6-3x}{2}\sqrt[]{-3^2+-2^2+1}dA$$

---

