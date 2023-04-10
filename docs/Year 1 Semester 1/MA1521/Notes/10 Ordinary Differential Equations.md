
# 10 Ordinary Differential Equations
---
## 10.1 First Order Ordinary Differential Equations

Let $y$ be a function of $x$. An equation involving $x,y$ and at least one derivative of $y$ is called an ordinary differential equation (ODE). The order of an ODE is the order of the highest derivative that occurs in the equation. We consider only first order ordinary differential equations.

### Separable ODE

A separable first order ODE is of the form
$$\frac{dy}{dx}=f(x)g(y)$$
Separating the variables
$$\frac{1}{g(y)}dy = f(x)dx$$
Integrating both sides,
$$\int\frac{1}{g(y)dy}=\int f(x)dx+C$$

## 10.2 Reduction to Separable Form

Certain first order differential equations are not separable but can be made separable by a simple change of variables.

>This holds for equations of the form
>$$y'=g(\frac{y}{x})$$
>where $g$ is any function of $\frac{y}{x}$. Let $v=\frac{y}{x}$, then $y=vx$ and $y'=v+xv'$. Then the equation $y'=g(\frac{y}{x})$ can be written as $v+xv'=g(v)$, which is separable. That is $\frac{dv}{g(v)-v}=\frac{dx}{x}$.
>
>[](Examples.md#10.5%20Reduction%20to%20Separable%20Form%7CExample)

>A differential equation of the form $y^{\prime}=f(a x+b y+c)$ where $f$ is continuous and $b \neq 0$ (if $b=0$, the equation is separable) can be solved by setting $u=a x+b y+c$.
>
>[](Examples.md#10.6%20Reduction%20to%20Separable%20Form%7CExample)

Write $z=a x+b y+c$. Then
$$
\frac{d z}{d x}=a+b \frac{d y}{d x} \Leftrightarrow \frac{d y}{d x}=\frac{1}{b}\left(\frac{d z}{d x}-a\right)
$$
Hence, we get
$$
\frac{1}{b}\left(\frac{d z}{d x}-a\right)=f(z) \Leftrightarrow \frac{d z}{d x}=f(z) b+a .
$$
It is now separable, and we need to solve
$$\int \frac{d z}{b f(z)+a}=\int d x=x$$

## Exact Equations

In some cases, the differential equation is in a nice form called exact equations. The equation $f(x, y)+g(x, y) \frac{d y}{d x}$ can be expressed in the form of $h(x, y)$ such that $h_x=f(x, y)$ and $h_y=g(x, y)$; and we can write
$$
h_x+h_y \frac{d y}{d x}=\frac{d z}{d x} \text { where } z=h(x, y)
$$
**Example**: Solve $2 x y-9 x^2+\left(2 y+x^2+1\right) \frac{d y}{d x}=1+x$
**Solution**: Assume there is a function $h(x, y)$ such that
$$
h_x=2 x y-9 x^2=h_x \text { and } h_y=2 y+x^2+1 .
$$
Integrate $2 x y-9 x^2$ with respect to $x$ and treat $y$ as a constant, we get
$$
h(x, y)=x^2 y-3 x^3+g(y) .
$$
Compute $h_y$ and set
$$
x^2+g^{\prime}(y)=2 y+x^2+1
$$
Hence, we get $g^{\prime}(y)=2 y+1$ and $g(y)=y^2+y$. Then, we obtain
$$
h(x, y)=x^2 y-3 x^3+y^2+y
$$
Therefore
$$
2 x y-9 x^2+\left(2 y+x^2+1\right) \frac{d y}{d x}=\frac{d}{d x} h(x, y)
$$
Hence the answer is,
$$
x^2 y-3 x^3+y^2+y=x+\frac{x^2}{2}+C
$$

## 10.3 Linear First Order ODE

A linear first order ODE is of the form
$$\frac{d y}{d x}+P(x) y=Q(x)$$
where $Q(x)$ is not identically zero. Note that the above ODE is separable if $P(x)$ is identically equal to $Q(x)$. This is the *standard form* of a linear first order ODE.

Let $I(x)=e^{\int P(x) d x}$. We call $I(x)$ an integrating factor. Multiplying both sides of the above ODE by $I(x)$, we get
$$
\frac{d y}{d x} e^{\int P(x) d x}+P(x) e^{\int P(x) d x} y=Q(x) e^{\int P(x) d x} .
$$
But
$$
\frac{d y}{d x} e^{\int P(x) d x}+P(x) e^{\int P(x) d x} y=\frac{d}{d x}\left(y e^{\int P(x) d x}\right),
$$
which can be shown by applying the product rule and the Fundamental Theorem of Calculus. Hence,
$$
\frac{d}{d x}\left(y e^{\int P(x) d x}\right)=Q(x) e^{\int P(x) d x} .
$$
We have thus shown that
$$
\frac{d}{d x}(y \cdot I(x))=Q(x) \cdot I(x) .
$$
Integrating both sides gives
$$
y \cdot I(x)=\int Q(x) \cdot I(x) d x
$$
from which the solution for $y$ can be obtained.

[](Examples.md#10.7%20Linear%20First%20Order%20ODE%7CExample)

## 10.4 The Bernoulli Equation

An ODE in the form
$$
y^{\prime}+p(x) y=q(x) y^n,
$$
where $n \neq 0,1$, is called the Bernoulli equation. The functions $p(x)$ and $q(x)$ are continuous functions on an interval $J$.

Step 1: divide by $y^n$ :  $y^{\prime}y^{-n}+p(x)y^{1-n}=q(x)$

Step 2: Let $u=y^{1-n}$. 
$$\begin{array}{l}
&u'= (1-n)y^{-n}y'\\
&\frac{u'}{1-n} = y^{-n}y'\\
&\frac{u'}{1-n}+p(x)u =q(x)\\
&u^{\prime}+(1-n) p(x) u=(1-n) q(x)
\end{array}$$
This is a first order linear ODE.

## 10.5 Application of ODE

[](Examples.md#Applications%20of%20ODE%7CQuestions%20can%20be%20found%20here)

## 10.6 Malthus Model of Population

**Not in exam**

## 10.7 Euler's Method

> Numerical method in approximating a first order ODE

Given a differential equation $\frac{d y}{d x}=$ $f(x, y)$ and an initial condition $y\left(x_0\right)=y_0$, we can approximate the solution $y=y(x)$ by its linearization
$$
L(x)=y\left(x_0\right)+y^{\prime}\left(x_0\right)\left(x-x_0\right) \text { or } L(x)=y_0+f\left(x_0, y_0\right)\left(x-x_0\right)
$$

![c|400](../Attachments/10%20Ordinary%20Differential%20Equations.png)
![c|400](../Attachments/10%20Ordinary%20Differential%20Equations-1.png)

**Example 10.14**. Use Euler's method to solve
$$
y^{\prime}=1+y, y(0)=1,
$$
on the interval $[0,1]$ starting at $x_0=0$ by taking $h=0.1$. Find the approximate value of $y(1)$ and compare it with the exact value.

**Solution**. 

$$
\begin{array}{l}
y(0) = 1 \\
y(0.1) = y(0)+y'(0)\times 0.1 \\
\quad y'(0) = 1 + y(0) = 2 \\
\quad 1+2\times_{}0.1=1.2 \\
y(0.2) = y(0.1)+y'(0.1)\times 0.1 \\
= 1.2 + 2.2 \times 0.1 = 1.42  \\
\dots
\end{array}
$$

## 10.8 2nd Order Linear Equations with Constant Coefficients


## 10.9 Method of Undetermined Coefficients

