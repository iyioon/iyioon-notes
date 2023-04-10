# Limit

- $\lim _{x \rightarrow c} \frac{\sin (g(x))}{g(x)}=\lim _{x \rightarrow c} \frac{g(x)}{\sin (g(x))}=1$,
- $\lim _{x \rightarrow c} \frac{\tan (g(x))}{g(x)}=\lim _{x \rightarrow c} \frac{g(x)}{\tan (g(x))}=1$.
# Differentiation: Parametric equation

$x=f(t) \text { and } y=g(t),(t \text { is the parameter })$

- $\frac{d y}{d x}=\frac{d y}{d t} \div \frac{d x}{d t}=\frac{g^{\prime}(t)}{f^{\prime}(t)}$
- $\frac{d^2 y}{d x^2}=\frac{d}{d t}\left(\frac{d y}{d x}\right) \div \frac{d x}{d t}=\frac{\frac{d}{d t}\left(\frac{g^{\prime}(t)}{f^{\prime}(t)}\right)}{f^{\prime}(t)}=\frac{g^{\prime \prime}(t) f^{\prime}(t)-g^{\prime}(t) f^{\prime \prime}(t)}{f^{\prime}(t)^3}$

# Integrals

1. $\int(a x+b)^n d x=\frac{(a x+b)^{n+1}}{(n+1) a}+C \quad(n \neq-1)$
2. $\int \frac{1}{a x+b} d x=\frac{1}{a} \ln |a x+b|+C$
3. $\int e^{a x+b} d x=\frac{1}{a} e^{a x+b}+C$
4. $\int \sin (a x+b) d x=-\frac{1}{a} \cos (a x+b)+C$
5. $\int \cos (a x+b) d x=\frac{1}{a} \sin (a x+b)+C$
6. $\int \tan (a x+b) d x=\frac{1}{a} \ln |\sec (a x+b)|+C$
7. $\int \sec (a x+b) d x=\frac{1}{a} \ln |\sec (a x+b)+\tan (a x+b)|+C$
8. $\int \csc (a x+b) d x=-\frac{1}{a} \ln |\csc (a x+b)+\cot (a x+b)|+c$
9. $\int \cot (a x+b) d x=-\frac{1}{a} \ln |\csc (a x+b)|+C$
10. $\int \sec ^2(a x+b) d x=\frac{1}{a} \tan (a x+b)+C$
11. $\int \csc ^2(a x+b) d x=-\frac{1}{a} \cot (a x+b)+C$
12. $\int \sec (a x+b) \tan (a x+b) d x=\frac{1}{a} \sec (a x+b)+C$
13. $\int \csc (a x+b) \cot (a x+b) d x=-\frac{1}{a} \csc (a x+b)+C$
14. $\int \frac{1}{a^2+(x+b)^2} d x=\frac{1}{a} \tan ^{-1}\left(\frac{x+b}{a}\right)+C$
15. $\int \frac{1}{\sqrt{a^2-(x+b)^2}} d x=\sin ^{-1}\left(\frac{x+b}{a}\right)+C$
16. $\int \frac{-1}{\sqrt{a^2-(x+b)^2}} d x=\cos ^{-1}\left(\frac{x+b}{a}\right)+C$
17. $\int \frac{1}{a^2-(x+b)^2} d x=\frac{1}{2 a} \ln \left|\frac{x+b+a}{x+b-a}\right|+C$
18. $\int \frac{1}{(x+b)^2-a^2} d x=\frac{1}{2 a} \ln \left|\frac{x+b-a}{x+b+a}\right|+C$
19. $\int \frac{1}{\sqrt{(x+b)^2+a^2}} d x=\ln \left|(x+b)+\sqrt{(x+b)^2+a^2}\right|+C$
20. $\int \frac{1}{\sqrt{(x+b)^2-a^2}} d x=\ln \left|(x+b)+\sqrt{(x+b)^2-a^2}\right|+C$
21. $\int \sqrt{a^2-x^2} d x=\frac{x}{2} \sqrt{a^2-x^2}+\frac{a^2}{2} \sin ^{-1} \frac{x}{a}+C$
22. $\int \sqrt{x^2-a^2} d x=\frac{x}{2} \sqrt{x^2-a^2}-\frac{a^2}{2} \ln \left|x+\sqrt{x^2-a^2}\right|+C$

Trigonometric Identities Useful for Integration

1. $\sec ^2 x-1=\tan ^2 x$
2. $\csc ^2 x-1=\cot ^2 x$
3. $\sin A \cos A=\frac{1}{2} \sin 2 A$
4. $\cos ^2 A=\frac{1}{2}(1+\cos 2 A)$
5. $\sin ^2 A=\frac{1}{2}(1-\cos 2 A)$
6. $\sin A \cos B=\frac{1}{2}(\sin (A+B)+\sin (A-B))$
7. $\cos A \sin B=\frac{1}{2}(\sin (A+B)-\sin (A-B))$
8. $\cos A \cos B=\frac{1}{2}(\cos (A+B)+\cos (A-B))$
9. $\sin A \sin B=-\frac{1}{2}(\cos (A+B)-\cos (A-B))$

$\begin{aligned}
&\text { Trigonometric Substitution }\\
&\begin{array}{|c|c|c|}
\hline \text { Expression } & \text { Substitution } & \text { Identity involved } \\
\hline \sqrt{a^2-(x+b)^2} & x+b=a \sin \theta,-\frac{\pi}{2} \leq \theta \leq \frac{\pi}{2} & 1-\sin ^2 \theta=\cos ^2 \theta \\
\hline \sqrt{a^2+(x+b)^2} & x+b=a \tan \theta,-\frac{\pi}{2}<\theta<\frac{\pi}{2} & 1+\tan ^2 \theta=\sec ^2 \theta \\
\hline \sqrt{(x+b)^2-a^2} & x+b=a \sec \theta, 0<\theta<\frac{\pi}{2} \text { or } \pi \leq \theta<\frac{3 \pi}{2} & \sec ^2 \theta-1=\tan ^2 \theta \\
\hline
\end{array}
\end{aligned}$

# Sequences and Series

If the series $\sum_{n=1}^{\infty} a_n$ is convergent, then $\lim _{n \rightarrow \infty} a_n=0$.

If $\lim _{n \rightarrow \infty} a_n$ does not exist or if $\lim _{n \rightarrow \infty} a_n \neq 0$, then the series $\sum_{n=1}^{\infty} a_n$ is divergent.

**Integral Test**
Let $\left\{a_n\right\}$ be a sequence of positive terms. Suppose that $a_n=f(n)$, where $f$ is a continuous, positive, decreasing function of $x$ for
all $x \geq 1$. Then the series $\sum_{n=1}^{\infty} a_n$ is convergent if and only if the improper integral $\int_1^{\infty} f(x) d x$ is convergent. In other words:
(i) If $\int_1^{\infty} f(x) d x$ is convergent, then $\sum_{n=1}^{\infty} a_n$ is convergent.
(ii) If $\int_1^{\infty} f(x) d x$ is divergent, then $\sum_{n=1}^{\infty} a_n$ is divergent.

**The $p$-series**
The $p$-series $\sum_{n=1}^{\infty} \frac{1}{n^p}$ is convergent if and only if $p>1$. [[Lecture Notes.pdf#page=85|proof]]

**The Ratio Test**
Suppose $\sum_{n=1}^{\infty} a_n$ is a series such that $\lim _{n \rightarrow \infty}\left|\frac{a_{n+1}}{a_n}\right|=L$ (L is a finite number or $\infty$ ).
(i) If $0 \leq L<1$, then $\sum_{n=1}^{\infty} a_n$ is absolutely convergent. That is $\sum_{n=1}^{\infty}\left|a_n\right|$ is convergent.
(ii) If $L>1$, then $\sum_{n=1}^{\infty} a_n$ is divergent.
(iii) If $L=1$, then the ratio test is inconclusive.

**The Root Test**
Suppose $\sum_{n=1}^{\infty} a_n$ is a series such that $\lim _{n \rightarrow \infty} \sqrt[n]{\left|a_n\right|}=L$ (L is a finite number or $\infty$ ).
(i) If $0 \leq L<1$, then $\sum_{n=1}^{\infty} a_n$ is absolutely convergent.
(ii) If $L>1$, then $\sum_{n=1}^{\infty} a_n$ is divergent.
(iii) If $L=1$, then the root test is inconclusive.

**The Alternating Series Test** 
If $b_n$ is a sequence of positive numbers such that
(i) $b_n$ is decreasing, and
(ii) $\lim _{n \rightarrow \infty} b_n=0$,
then the alternating series
$$
\sum_{n=1}^{\infty}(-1)^{n-1} b_n=b_1-b_2+b_3-b_4+\cdots
$$
is convergent.

**Absolute Convergence**
If $\sum_{n=1}^{\infty}\left|a_n\right|$ is convergent, then $\sum_{n=1}^{\infty} a_n$ is convergent.
A series $\sum_{n=1}^{\infty} a_n$ is called absolutely convergent if $\sum_{n=1}^{\infty}\left|a_n\right|$ is convergent.
It is called conditionally convergent if it is convergent but not absolutely convergent.

**Power Series**
To find radius of convergence, use <u>root test</u> and <u>ratio test</u> to get $L$, then $R=\frac{1}{L}$.
To find interval of convergence, get $R$ and do convergence test for each $-R$ and $R$ to get the boundary

**Taylor series of $f$ at $x=a$.**
$f(x)=\sum_{n=0}^{\infty} \frac{f^{(n)}(a)}{n !}(x-a)^n$

**Maclaurin series**
$f(x)=\sum_{n=0}^{\infty} \frac{f^{(n)}(0)}{n !} x^n$

