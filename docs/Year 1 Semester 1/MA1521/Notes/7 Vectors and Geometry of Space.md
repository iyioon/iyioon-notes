# 7 Vectors and Geometry of Space
---

## 7.1 The 3D-Coordinate System

### Theorem 7.1 Distance Formula

The distance $\left|P_1 P_2\right|$ between the points $P_1\left(x_1, y_1, z_1\right)$ and $P_2\left(x_2, y_2, z_2\right)$ is
$$
\left|P_1 P_2\right|=\sqrt{\left(x_2-x_1\right)^2+\left(y_2-y_1\right)^2+\left(z_2-z_1\right)^2}
$$

### Theorem 7.2 Equation of a Sphere

An equation of a sphere with center $C(h, k, l)$ and radius $r$ is
$$
(x-h)^2+(y-k)^2+(z-l)^2=r^2 .
$$

## 7.3 The Dot Product

The dot product of two vectors $\mathbf{a}=\left\langle a_1, a_2, a_3\right\rangle$ and $\mathbf{b}=\left\langle b_1, b_2, b_3\right\rangle$ is defined to be
$$
\mathbf{a} \cdot \mathbf{b}=a_1 b_1+a_2 b_2+a_3 b_3
$$
### Theorem 7.7.

Let $\theta$ be the angle between nonzero vectors $\mathbf{a}$ and $\mathbf{b}$. Then
$$\mathbf{a} \cdot \mathbf{b}=\|\mathbf{a}\| \mid \mathbf{b} \| \cos \theta$$
Two vectors $\mathbf{a}$ and $\mathbf{b}$ are orthogonal if and only if $\mathbf{a} \cdot \mathbf{b}=0$.

## 7.4 Projections

$$\operatorname{proj}_{\mathbf{a}} \mathbf{b}=\operatorname{comp}_{\mathbf{a}} \mathbf{b} \times \frac{\mathbf{a}}{\|\mathrm{a}\|}=\left(\frac{\mathbf{a} \cdot \mathbf{b}}{\|\mathrm{a}\|}\right) \frac{\mathbf{a}}{\|\mathbf{a}\|}=\frac{\mathbf{a} \cdot \mathbf{b}}{\|\mathrm{a}\|^2} \mathbf{a}=\frac{\mathbf{a} \cdot \mathbf{b}}{\mathbf{a} \cdot \mathbf{a}} \mathbf{a}$$
![[7 Vectors and Geometry of Space Projection.png|c|200]]
### Theorem 7.9 Distance from a point to a plane.

The (shortest) distance from a point $P\left(x_0, y_0, z_0\right)$ to the plane ax $+b y+c z=d$ is given by
$$
\frac{\left|a x_0+b y_0+c z_0-d\right|}{\sqrt{a^2+b^2+c^2}}
$$

## 7.5 The Cross Product

$$\begin{aligned} \mathbf{a} \times \mathbf{b} &=\left|\begin{array}{ccc}\mathbf{i} & \mathbf{j} & \mathbf{k} \\ a_1 & a_2 & a_3 \\ b_1 & b_2 & b_3\end{array}\right| \\ &=\left|\begin{array}{ll}a_2 & a_3 \\ b_2 & b_3\end{array}\right| \mathbf{i}-\left|\begin{array}{ll}a_1 & a_3 \\ b_1 & b_3\end{array}\right| \mathbf{j}+\left|\begin{array}{cc}a_1 & a_2 \\ b_1 & b_2\end{array}\right| \mathbf{k} \\ &=\left(a_2 b_3-a_3 b_2\right) \mathbf{i}-\left(a_1 b_3-a_3 b_1\right) \mathbf{j}+\left(a_1 b_2-a_2 b_1\right) \mathbf{k} . \end{aligned}$$
The vector $\mathbf{a} \times \mathbf{b}$ is orthogonal to both $\mathbf{a}$ and $\mathbf{b}$.

![[7 Vectors and Geometry of Space Cross Product.png|c|200]]
<p align="center">Right hand rule</p>

### Theorem 7.11.

If $\theta$ is the angle between $\mathbf{a}$ and $\mathbf{b}$ then
$$
\|\mathbf{a} \times \mathbf{b}\|=\|\mathbf{a}\|\|\mathbf{b}\| \sin \theta
$$

We can use cross product
- <font style="color:#3258a8">to find the area of a parallelogram</font> (the one above)
- <font style="color:#3258a8">to find the distance from a point to a line in </font>$\mathbb{R}^3$.

The distance from $Q$ to the line through $P$ and $R$ is
$$
\|\overrightarrow{\boldsymbol{P Q}}\| \sin \theta=\frac{\| \overrightarrow{\mathbf{P Q}} \times \overrightarrow{\mathbf{P R} \|}}{\| \overrightarrow{\boldsymbol{P R} \|}}
$$
![[7 Vectors and Geometry of Space.png|c|300]]

## Lines

We can write the vector equation in the component form:
$$
\mathbf{v}=\langle a, b, c\rangle, \mathbf{r}_0=\left\langle x_0, y_0, z_0\right\rangle, \mathbf{r}=\langle x, y, z\rangle .
$$
Two vectors are equal if and only if the corresponding components are equal. Therefore, we have
$$
\begin{gathered}
\mathbf{r}=\mathbf{r}_0+t \mathbf{v} \\
\langle x, y, z\rangle=\left\langle x_0, y_0, z_0\right\rangle+t\langle a, b, c\rangle .
\end{gathered}
$$

### Theorem 7.13 Parametric Equation of Line

$$
x=x_0+a t, \quad y=y_0+b t, \quad z=z_0+c t
$$
Usually the parameter $t$ (in the parametric equation of line) takes values on the entire $\mathbb{R}$ or an interval $I$.
The numbers $a, b$ and $c$ are called <font style="color:#FF0000">direction numbers</font> of the line $L$.
The vector equation and parametric equations of a line are not unique.
If we change the point $\mathbf{r}_0$ or the parameter $t$ or choose a different parallel vector $\mathbf{v}$, then the equations change. Therefore, direction numbers are not unique.


## 7.7. Planes

### Theorem 7.14 Vector Equation of Plane

$$
\mathbf{n} \cdot\left(\mathbf{r}-\mathbf{r}_0\right)=0
$$
which can be written as
$$
\mathbf{n} \cdot \mathbf{r}=\mathbf{n} \cdot \mathbf{r}_0
$$

To obtain a scalar equation for the plane, write the vectors in component form and equate corresponding components:
$$
\mathbf{n}=\langle a, b, c\rangle, \quad \mathbf{r}=\langle x, y, z\rangle, \quad \mathbf{r}_0=\left\langle x_0, y_0, z_0\right\rangle .
$$
Then $\mathbf{n} \cdot \mathbf{r}=\mathbf{n} \cdot \mathbf{r}_0$ becomes
$$
\begin{gathered}
\langle a, b, c\rangle \cdot\langle x, y, z\rangle=\langle a, b, c\rangle \cdot\left\langle x_0, y_0, z_0\right\rangle \\
a x+b y+c z=a x_0+b y_0+c z_0
\end{gathered}
$$

### Theorem 7.15 Linear Equation of Plane

$$
a x+b y+c z+d=0,
$$
where
$$
d=-\left(a x_0+b y_0+c z_0\right)
$$

