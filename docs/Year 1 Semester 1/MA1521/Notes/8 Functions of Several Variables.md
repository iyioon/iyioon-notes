# 8 Functions of Several Variables
---

## 8.1 Vector Functions of One Variable

A vector-valued function $\mathbf{r}(t)$ is a mapping from its domain $D \subseteq \mathbb{R}$ to its range $R \subseteq \mathbb{V}_3$, so that for each $t \in D, \mathbf{r}(t)=\mathbf{v}$ for exactly one vector $\mathbf{v} \in \mathbb{V}_3$.
We write a vector-valued function as
$$
\mathbf{r}(t)=f(t) \mathbf{i}+g(t) \mathbf{j}+h(t) \mathbf{k}
$$
or
$$
\mathbf{r}(t)=\langle f(t), g(t), h(t)\rangle
$$
for some scalar function $f, g$ and $h$ (called the component functions of $\mathbf{r}$ ).

## 8.2 Calculus of Vector Functions

### Theorem 8.1 (Derivative of Vector-valued Function).
Let $\mathbf{r}(t)=\langle f(t), g(t), h(t)\rangle$ and suppose that the components $f, g$ and $h$ are all differentiable at $t=a$. Then $\mathbf{r}$ is differentiable at $t=a$ and its derivative is given by
$$
\mathbf{r}^{\prime}(a)=\left\langle f^{\prime}(a), g^{\prime}(a), h^{\prime}(a)\right\rangle
$$
### Theorem 8.2 (Derivative Rules).

Suppose $\mathbf{r}(t)$ and $\mathbf{s}(t)$ are differentiable vector-valued functions, $f(t)$ is a differentiable scalar function and $c$ is a scalar constant. Then
(i) $\frac{d}{d t}(\mathbf{r}(t)+\mathbf{s}(t))=\mathbf{r}^{\prime}(t)+\mathbf{s}^{\prime}(t)$
(ii) $\frac{d}{d t}(\mathbf{c r}(t))=c \mathbf{r}^{\prime}(t)$
(iii) $\frac{d}{d t} f(t) \mathbf{r}(t)=f^{\prime}(t) \mathbf{r}(t)+f(t) \mathbf{r}^{\prime}(t)$
(iv) $\frac{d}{d t} \mathbf{r}(t) \cdot \mathbf{s}(t)=\mathbf{r}^{\prime}(t) \cdot \mathbf{s}(t)+\mathbf{r}(t) \cdot \mathbf{s}^{\prime}(t)$
(v) $\frac{d}{d t}(\mathbf{r}(t) \times \mathbf{s}(t))=\mathbf{r}^{\prime}(t) \times \mathbf{s}(t)+\mathbf{r}(t) \times \mathbf{s}^{\prime}(t)$.

## 8.3 Tangent Vector and Tangent Line to a Curve

**Example 8.2**. Find the tangent line L to the curve $\mathbf{r}(t)=\langle\cos t, \sin t, t\rangle$ at $(0,1, \pi / 2)$.
**Solution**. At point $(0,1, \pi / 2), t=\pi / 2$. Since $\mathbf{r}^{\prime}(t)=\langle-\sin t, \cos t, 1\rangle$, a direction of the tangent line $L$ is
$$
\mathbf{r}^{\prime}(\pi / 2)=\langle-\sin (\pi / 2), \cos (\pi / 2), 1\rangle=\langle-1,0,1\rangle
$$
So a parametric equation of $L$ is
$$
x=0+(-1) t, \quad y=1+(0) t, \quad z=\pi / 2+(1) t,
$$
that is
$$
x=-t, \quad y=1, \quad z=\pi / 2+t .
$$

## 8.3 Arc Length of  a Space Curve

### Theorem $8.3$ (Arc Length Formula).
Let $C$ be the curve given by
$$
\mathbf{r}(t)=\langle f(t), g(t), h(t)\rangle, \quad a \leq t \leq b
$$
where $f^{\prime}, g^{\prime}$ and $h^{\prime}$ are continuous. If $C$ is traversed exactly once as $t$ increases from $a$ to $b$, then its length is
$$
\begin{aligned}
s &=\int_a^b \sqrt{f^{\prime}(t)^2+g^{\prime}(t)^2+h^{\prime}(t)^2} d t \\
&=\int_a^b\left\|\mathbf{r}^{\prime}(t)\right\| d t
\end{aligned}
$$

## 8.5 Functions of Two Variables

**Definition 8.3** (Level Curve).
A level curve of $f(x, y)$ is the two-dimensional graph of the equation $f(x, y)=k$ for some constant $k$.

**Definition 8.4** (Contour Plot).
A contour plot of $f(x, y)$ is a graph of numerous level curves $f(x, y)=k$, for representative values of $k$.

## 8.6 Cylinders and Quadric Surfaces

### Cylinders 

**Definition 8.5.**
A surface is a cylinder if there is a plane $P$ such that all the planes parallel to $P$ intersect the surface in the same curve (when viewed in 2-dimension).

![[8 Functions of Several Variables Cylinders.png|c|200]]


### Quadric Surface

Definition 8.6 (Quadric Surface).
A quadric surface is the graph of a second-degree equation in three variables $x, y$ and $z$ :
$$
A x^2+B y^2+C z^2+D x y+E y z+F x z+G x+H y+I z+J=0
$$
where $A, B, \ldots, J$ are constants.

![[8 Functions of Several Variables.png|c|200]]

## 8.7 Function of Three Variables

**Definition 8.10** (Level Surface).
A level surface of $f(x, y, z)$ is the three-dimensional graph of the equation $f(x, y, z)=k$ for some constant $k$.

## 8.8 Partial Derivatives

**Example 8.12**. For $f(x, y)=e^{x y}+\frac{x}{y}$, compute $f_x$ and $f_y$.
**Solution**. Treating $y$ as a constant, we have
$$
f_x(x, y)=y e^{x y}+\frac{1}{y} .
$$
Treating $x$ as a constant, we have
$$
f_y(x, y)=x e^{x y}-\frac{x}{y^2}
$$

**Example 8.13**. Find $\frac{\partial z}{\partial x}$ and $\frac{\partial z}{\partial y}$ if $z$ is defined implicitly as a function of $x$ and $y$ by the equation $x^3+y^3+z^3+6 x y z=1$
**Solution**. Take partial derivative with respect to $x$ on both sides:
$$
3 x^2+3 z^2 \frac{\partial z}{\partial x}+6 y z+6 y x \frac{\partial z}{\partial x}=0
$$
Solving for $\frac{\partial z}{\partial x}$, we have
$$
\frac{\partial z}{\partial x}=-\frac{x^2+2 y z}{z^2+2 x y}
$$
Similarly,
$$
\frac{\partial z}{\partial y}=-\frac{y^2+2 x z}{z^2+2 x y}
$$
## Higher Order Partial Derivatives

**Example 8.14**. Find all second-order partial derivatives of $f(x, y)=x^2 y-y^3+\ln x$.
**Solution**. First, we compute the first-order derivatives:
$$
\begin{aligned}
&f_x=2 x y+\frac{1}{x}, \\
&f_y=x^2-3 y^2 .
\end{aligned}
$$
Then we have
$$
\begin{aligned}
&f_{x x}=\frac{\partial}{\partial x}\left(2 x y+\frac{1}{x}\right)=2 y-\frac{1}{x^2} \\
&f_{x y}=\frac{\partial}{\partial y}\left(2 x y+\frac{1}{x}\right)=2 x \\
&f_{y x}=\frac{\partial}{\partial x}\left(x^2-3 y^2\right)=2 x \\
&f_{y y}=\frac{\partial}{\partial y}\left(x^2-3 y^2\right)=-6 y
\end{aligned}
$$

### Theorem 8.4 (Clairaut's Theorem).

Suppose $f$ is defined on a disk $D$ that contains $(a, b)$. If the functions $f_{x y}$ and $f_{y x}$ are both continuous on $D$, then
$$f_{x y}(a, b)=f_{y x}(a, b)$$

## 8.10 Tangent Planes

### Theorem 8.5 (Equation of Tangent Plane).
Suppose $f(x, y)$ has continuous first partial derivatives at $(a, b)$. A normal vector to the tangent plane is
$$
\left\langle f_x(a, b), f_y(a, b),-1\right\rangle .
$$
Further, an equation of the tangent plane is given by
$$
f_x(a, b)(x-a)+f_y(a, b)(y-b)-(z-f(a, b))=0
$$
or
$$
z=f(a, b)+f_x(a, b)(x-a)+f_y(a, b)(y-b) .
$$

## 8.11 Differentiability and Chain Rule

### Theorem 8.6 (The Chain Rule - Case 1).
Suppose that $z=f(x, y)$ is a differentiable function of $x$ and $y$, where $x=g(t)$ and $y=h(t)$ are both differentiable functions of $t$. Then, $z$ is a differentiable function of $t$ and
$$
\frac{d z}{d t}=\frac{\partial f}{\partial x} \frac{d x}{d t}+\frac{\partial f}{\partial y} \frac{d y}{d t}
$$

### Theorem 8.7 (The Chain Rule - Case 2).
Suppose that $z=f(x, y)$ is a differentiable function of $x$ and $y$, where $x=g(s, t)$ and $y=h(s, t)$ are both differentiable functions of $s$ and $t$. Then,
$$
\begin{aligned}
&\frac{\partial z}{\partial s}=\frac{\partial f}{\partial x} \frac{\partial x}{\partial s}+\frac{\partial f}{\partial y} \frac{\partial y}{\partial s} \\
&\frac{\partial z}{\partial t}=\frac{\partial f}{\partial x} \frac{\partial x}{\partial t}+\frac{\partial f}{\partial y} \frac{\partial y}{\partial t}
\end{aligned}
$$
## 8.12 Implicit Differentiation

### Theorem 8.9 (Implicit Differentiation: Two Independent Variables).
Suppose the equation $F(x, y, z)=0$, where $F$ is differentiable, defines $z$ implicitly as a differentiable function of $x$ and $y$. Then,
$$
\frac{\partial z}{\partial x}=-\frac{F_x(x, y, z)}{F_z(x, y, z)}, \quad \frac{\partial z}{\partial y}=-\frac{F_y(x, y, z)}{F_z(x, y, z)}
$$
provided $F_z(x, y, z) \neq 0$.

## 8.13 Increments and Differentials

**Definition 8.13.**
Let $z=f(x, y)$. Suppose $\Delta x$ and $\Delta y$ are increments in the independent variable $x$ and $y$ respectively.
Then the increment in $z$ is defined by
$$
\Delta z=f(x+\Delta x, y+\Delta y)-f(x, y)
$$

**Definition 8.14.**
Let $z=f(x, y)$. Suppose $\Delta x$ and $\Delta y$ are increments in the independent variable $x$ and $y$ respectively.
Then the differentials of the independent variables $x$ and $y$ are
$$
d x=\Delta x, \quad d y=\Delta y .
$$
The differential (or total differential) of the dependent variable $z$ is
$$d z=f_x(x, y) d x+f_y(x, y) d y$$
### Theorem 8.10.
Suppose $f$ is differentiable at $(a, b)$. Let $\Delta x$ and $\Delta y$ be small increments in $x$ and $y$ respectively from $(a, b)$. Then
$$
\Delta z \approx d z=f_x(a, b) d x+f_y(a, b) d y=f_x(a, b) \Delta x+f_y(a, b) \Delta y .
$$

## Directional Derivatives and the Gradient Vector

### Theorem 8.11 (Computing Directional Derivative).
If $f(x, y)$ is a differentiable function, then $f$ has a directional derivative in the direction of any unit vector $\mathbf{u}=\langle a, b\rangle$ and
$$
D_{\mathbf{u}} f(x, y)=f_x(x, y) a+f_y(x, y) b .
$$
We can rewrite it in terms of vectors:
$$
D_{\mathbf{u}} f(x, y)=\left\langle f_x, f_y\right\rangle \cdot\langle a, b\rangle=\left\langle f_x, f_y\right\rangle \cdot \mathbf{u}
$$

**Definition 8.16** (Gradient).
The gradient of $f(x, y)$ is the vector-valued function
$$
\nabla f(x, y)=\left\langle f_x, f_y\right\rangle=f_x \mathbf{i}+f_y \mathbf{j}=\frac{\partial f}{\partial x} \mathbf{i}+\frac{\partial f}{\partial y} \mathbf{j}
$$
provided both partial derivatives exist.

**Example 8.23**. Find the directional derivative of the function $f(x, y)=x^2 y^3-4 y$ at the point $(2,-1)$ in the direction of the vector $\mathbf{v}=2 \mathbf{i}+5 \mathbf{j}$.
Solution. First compute the gradient vector at $(2,-1)$ :
$$
\nabla f(x, y)=2 x y^3 \mathbf{i}+\left(3 x^2 y^2-4\right) \mathbf{j}
$$
$$
\nabla f(2,-1)=-4 \mathbf{i}+8 \mathbf{j} .
$$
Notice $\mathbf{v}$ is <font style="color:#FF0000">NOT a unit vector</font>, since
$$
\|\mathbf{v}\|=\sqrt{2^2+5^2}=\sqrt{29} \text {. }
$$
The unit vector in the direction of $\mathbf{v}$ is
$$
\mathbf{u}=\frac{\mathbf{v}}{\|v\|}=\frac{2}{\sqrt{29}} \mathbf{i}+\frac{5}{\sqrt{29}} \mathbf{j}
$$
Therefore
$$
\begin{aligned}
D_{\mathbf{u}} f(2,-1) &=\nabla f(2,-1) \cdot \mathbf{u} \\
&=\langle-4,8\rangle \cdot\left\langle\frac{2}{\sqrt{29}}, \frac{5}{\sqrt{29}}\right\rangle \\
&=\frac{32}{\sqrt{29}} .
\end{aligned}
$$
### Theorem 8.12 (Computing 3-D Directional Derivative).
$$
D_{\mathbf{u}} f\left(x_0, y_0, z_0\right)=\nabla f(x, y, z) \cdot \mathbf{u}
$$
where
$$
\nabla f=\left\langle f_x, f_y, f_z\right\rangle=\frac{\partial f}{\partial x} \mathbf{i}+\frac{\partial f}{\partial y} \mathbf{j}+\frac{\partial f}{\partial z} \mathbf{k}
$$
is the gradient vector.

### Theorem 8.13 (Level Curve vs $\nabla f$ ).

Suppose $f(x, y)$ is differentiable function of $x$ and $y$ at $\left(x_0, y_0\right)$.
Suppose $\nabla f\left(x_0, y_0\right) \neq 0$. Then $\nabla f\left(x_0, y_0\right)$ is perpendicular/normal to the level curve $f(x, y)=k$ at the point $\left(x_0, y_0\right)$ where $f\left(x_0, y_0\right)=k$.

### Theorem 8.14 (Level Surface vs $\nabla f)$.

Suppose $F(x, y, z)$ is differentiable function of $x, y$ and $z$ at $\left(x_0, y_0, z_0\right)$. Suppose $S$ is the level surface $F(x, y, z)=k$ containing $\left(x_0, y_0, z_0\right)$. Let $C$ be any curve that lies on $S$ and passes through $\left(x_0, y_0, z_0\right)$. Let $\mathbf{r}(t)$ be a parametric equation of $C$ such that $\mathbf{r}\left(t_0\right)=\left\langle x_0, y_0, z_0\right\rangle$.
Suppose $\nabla F\left(x_0, y_0, z_0\right) \neq \mathbf{0}$. Then
$$
\nabla F\left(x_0, y_0, z_0\right) \cdot \mathbf{r}^{\prime}\left(t_0\right)=0,
$$
That is, the $\nabla F\left(x_0, y_0, z_0\right)$ is perpendicular/normal to tangent vector $\mathbf{r}^{\prime}\left(t_0\right)$ to any curve $C$ on the surface $S$ that passes through $\left(x_0, y_0, z_0\right)$.

### Theorem 8.15 (Tangent Plane to Level Surface).

$$
\nabla F\left(x_0, y_0, z_0\right) \cdot\left\langle x-x_0, y-y_0, z-z_0\right\rangle=0
$$
or equivalently,
$$
F_x\left(x_0, y_0, z_0\right)\left(x-x_0\right)+F_y\left(x_0, y_0, z_0\right)\left(y-y_0\right)+F_z\left(x_0, y_0, z_0\right)\left(z-z_0\right)=0
$$

### Theorem 8.16 (Maximizing Rate of Increase/Decrease of $f$ ).

Suppose $f$ is a differentiable function of two or three variables. Let $P$ denote a given point. Assume $\nabla f(P) \neq 0$. Let $\mathbf{u}$ be a unit vector making an angle $\theta$ with $\nabla f$. Then
$$
D_{\mathbf{u}} f(P)=\|\nabla f(P)\| \cos \theta .
$$
Moreover,
- $\nabla f(P)$ points in the direction of maximum rate of increase of $f$ at $P$ (maximum value of $D_{\mathbf{u}} f(P)$ is $\|\nabla f(P)\|$
- $-\nabla f(P)$ points in the direction of maximum rate of decrease of $f$ at $P$ (minimum value of $D_{\mathbf{u}} f(P)$ is $\left.-\|\nabla f(P)\|\right)$

## 8.1.5 Extrema of Functions of Two Variables

### Theorem 8.1.7 

If $f$ has a local maximum or minimum at $(a, b)$ and the first-order derivatives of $f$ exist there, then
$$
f_x(a, b)=f_y(a, b)=0
$$

**Definition 8.20** (Critical or Stationary Point).
Let $f(x, y): D \rightarrow \mathbb{R}$. Then a point $(a, b)$ is called a critical point of $f$ if
- $f_x(a, b)=0$ and $f_y(a, b)=0, O R$
- one of the partial derivatives does not exist.

**Definition 8.21** (Saddle Point).
Let $f(x, y): D \rightarrow \mathbb{R}$. Then
A point $(a, b)$ is called a saddle point of $f$ if
- it is a critical point of $f, A N D$
- every open disk centered at $(a, b)$ contains points $(x, y) \in D$ for which $f(x, y)<f(a, b)$ and points $(x, y) \in D$ for which $f(x, y)>f(a, b)$.

### Theorem 8.18 (Second Derivative Test).

Suppose $f(x, y)$ has continuous second-order partial derivatives on some open disk centered at $(a, b)$. Suppose $f_x(a, b)=f_y(a, b)=0$ (that is $(a, b)$ is a critical point). Define the discriminant $D$ for the point $(a, b)$ by
$$
D=D(a, b)=f_{x x}(a, b) f_{y y}(a, b)-\left[f_{x y}(a, b)\right]^2 .
$$
(a) If $D>0$ and $f_{x x}(a, b)>0$, then $f(a, b)$ is a local minimum.
(b) If $D>0$ and $f_{x x}(a, b)<0$, then $f(a, b)$ is a local maximum.
(c) If $D<0$, then $(a, b)$ is a saddle point of $f$.
(d) If $D=0$, then no conclusion can be drawn.