# 6 Sequences and Series
---

## 6.2 Finding the Limit of a Sequence

### Theorem 6.1. 

>Let $f$ be a function, and $\left\{a_n\right\}$ be a sequence such that $f(n)=a_n$ for all $n$. If $\lim _{x \rightarrow \infty} f(x)=L$, then $\lim _{n \rightarrow \infty} a_n=L$

## 6.3 Limit Laws for Sequences

If $\left\{a_n\right\}$ and $\left\{b_n\right\}$ are convergent sequences and $c$ is a constant, then we have

- $\lim _{n \rightarrow \infty} c a_n=c \lim _{n \rightarrow \infty} a_n$.
- $\lim _{n \rightarrow \infty}\left(a_n \pm b_n\right)=\lim _{n \rightarrow \infty} a_n \pm \lim _{n \rightarrow \infty} b_n$.
- $\lim _{n \rightarrow \infty} a_n b_n=\lim _{n \rightarrow \infty} a_n \lim _{n \rightarrow \infty} b_n$.
- $\lim _{n \rightarrow \infty} \frac{a_n}{b_n}=\frac{\lim _{n \rightarrow \infty} a_n}{\lim _{n \rightarrow \infty} b_n}$, if $\lim _{n \rightarrow \infty} b_n \neq 0$.

### Theorem 6.2. (Squeeze Theorem for Sequence)

> If $a_n \leq b_n \leq c_n$ for all $n$ and $\lim _{n \rightarrow \infty} a_n=\lim _{n \rightarrow \infty} c_n=L$, then $\lim _{n \rightarrow \infty} b_n=L$.

## 6.4 Series

### Theorem 6.3.

> If $\sum_{n=1}^{\infty} a_n$ and $\sum_{n=1}^{\infty} b_n$ are convergent series, so are the series $\sum_{n=1}^{\infty} c a_n$ (where $c$ is $a$ constant $)$ and $\sum_{n=1}^{\infty}\left(a_n+b_n\right)$. Moreover,
> (a) $\sum_{n=1}^{\infty} c a_n=c \sum_{n=1}^{\infty} a_n$, and
> (b) $\sum_{n=1}^{\infty}\left(a_n+b_n\right)=\sum_{n=1}^{\infty} a_n+\sum_{n=1}^{\infty} b_n$.

### Lemma 6.4. 

> If the series $\sum_{n=1}^{\infty} a_n$ is convergent, then $\lim _{n \rightarrow \infty} a_n=0$.

### Theorem 6.5. (Test for Divergence) 

> If $\lim _{n \rightarrow \infty} a_n$ does not exist or if $\lim _{n \rightarrow \infty} a_n \neq 0$, then the series $\sum_{n=1}^{\infty} a_n$ is divergent.

## 6.5 Integral Test

### Theorem 6.7. (Integral Test) 

> Let $\left\{a_n\right\}$ be a sequence of positive terms. Suppose that $a_n=f(n)$, where $f$ is a continuous, positive, decreasing function of $x$ for all $x \geq 1$. Then the series $\sum_{n=1}^{\infty} a_n$ is convergent if and only if the improper integral $\int_1^{\infty} f(x) d x$ is convergent. In other words:
> (i) If $\int_1^{\infty} f(x) d x$ is convergent, then $\sum_{n=1}^{\infty} a_n$ is convergent.
> (ii) If $\int_1^{\infty} f(x) d x$ is divergent, then $\sum_{n=1}^{\infty} a_n$ is divergent.

### Theorem 6.8. (The $p$-series)

> The $p$-series $\sum_{n=1}^{\infty} \frac{1}{n^p}$ is convergent if and only if $p>1$. [](Lecture%20Notes.pdf#page=85%7Cproof)

## 6.6 The Comparison Test

### Theorem 6.9. 

> Suppose $\sum_{n=1}^{\infty} a_n$ and $\sum_{n=1}^{\infty} b_n$ are series with positive terms such that $a_n \leq b_n$ for all $n$
> (i) If $\sum_{n=1}^{\infty} b_n$ is convergent, then $\sum_{n=1}^{\infty} a_n$ is convergent.
> (ii) If $\sum_{n=1}^{\infty} a_n$ is divergent, then $\sum_{n=1}^{\infty} b_n$ is divergent.


## 6.7 The Ratio Test and Root Test

### Theorem 6.10. (The Ratio Test)

> Suppose $\sum_{n=1}^{\infty} a_n$ is a series such that $\lim _{n \rightarrow \infty}\left|\frac{a_{n+1}}{a_n}\right|=L$ (L is a finite number or $\infty$ ).
> (i) If $0 \leq L<1$, then $\sum_{n=1}^{\infty} a_n$ is absolutely convergent. That is $\sum_{n=1}^{\infty}\left|a_n\right|$ is convergent.
> (ii) If $L>1$, then $\sum_{n=1}^{\infty} a_n$ is divergent.
> (iii) If $L=1$, then the ratio test is inconclusive.

### Theorem 6.11. (The Root Test) 

> Suppose $\sum_{n=1}^{\infty} a_n$ is a series such that $\lim _{n \rightarrow \infty} \sqrt[n]{\left|a_n\right|}=L$ (L is a finite number or $\infty$ ).
> (i) If $0 \leq L<1$, then $\sum_{n=1}^{\infty} a_n$ is absolutely convergent.
> (ii) If $L>1$, then $\sum_{n=1}^{\infty} a_n$ is divergent.
> (iii) If $L=1$, then the root test is inconclusive.

## 6.8 Alternating Series

### Theorem 6.12. (The Alternating Series Test) 

If $b_n$ is a sequence of positive numbers such that
(i) $b_n$ is decreasing, and
(ii) $\lim _{n \rightarrow \infty} b_n=0$,
then the alternating series
$$
\sum_{n=1}^{\infty}(-1)^{n-1} b_n=b_1-b_2+b_3-b_4+\cdots
$$
is convergent.

## 6.9 Absolute Convergence

### Theorem 6.13. 

> If $\sum_{n=1}^{\infty}\left|a_n\right|$ is convergent, then $\sum_{n=1}^{\infty} a_n$ is convergent.

Definition 6.3. A series $\sum_{n=1}^{\infty} a_n$ is called absolutely convergent if $\sum_{n=1}^{\infty}\left|a_n\right|$ is convergent.
It is called conditionally convergent if it is convergent but not absolutely convergent.

## 6.10 Power Series

 A power series is a series of the form
$$
\sum_{n=0}^{\infty} c_n x^n=c_0+c_1 x+c_2 x^2+c_3 x^3+\cdots,
$$
where $x$ is a variable, and the $c^{\prime}$ 's are constants called coefficients of the series. For each fixed $x$, the power series is a series of numbers that we can test for convergence or divergence.
More generally, a series of the form
$$
\sum_{n=0}^{\infty} c_n(x-a)^n=c_0+c_1(x-a)+c_2(x-a)^2+c_3(x-a)^3+\cdots,
$$
is called a power series centred at $a$ or a power series about $a$.
Note that the power series $\sum_{n=0}^{\infty} c_n(x-a)^n$ always converges at $x=a$.

### Theorem 6.14.

For a given power series $\sum_{n=0}^{\infty} c_n(x-a)^n$, exactly one of the following possibilities holds:
(i) The series converges at $x=a$ only.
(ii) The series converges for all $x$.
(iii) There is a positive number $R$ such that the series converges if $|x-a|<R$ and diverges if $|x-a|>R$

The number $R$ in case (iii) is called the radius of convergence of the power series. By convention, the radius of convergence is $R=0$ in case (i) and $R=\infty$ in case (ii). The interval of convergence of a power series is the interval consisting of all values of $x$ for which the series converges. In some cases, we can compute $R$ by the following method.
If $\lim _{n \rightarrow \infty}\left|\frac{c_{n+1}}{c_n}\right|=L$ or $\lim _{n \rightarrow \infty} \sqrt[n]{\left|c_n\right|}=L$, where $L$ is a real number or $\infty$, then $R=\frac{1}{L}$

## Taylor and Maclaurin Series

### Theorem 6.16. 

If $f$ has a power series representation at $x=a$, that is
$$
f(x)=\sum_{n=0}^{\infty} c_n(x-a)^n, \quad|x-a|<R, \text { for some } R>0,
$$
then its coefficients are given by the formula
$$
c_n=\frac{f^{(n)}(a)}{n !} .
$$
If $f$ has a power series representation at $x=a$, then it is unique and has the form
$$
f(x)=\sum_{n=0}^{\infty} \frac{f^{(n)}(a)}{n !}(x-a)^n
$$
This is called the Taylor series of $f$ at $x=a$.
The Maclaurin series of $f$ is the special case of Taylor series when $a=0$ :
$$
f(x)=\sum_{n=0}^{\infty} \frac{f^{(n)}(0)}{n !} x^n
$$