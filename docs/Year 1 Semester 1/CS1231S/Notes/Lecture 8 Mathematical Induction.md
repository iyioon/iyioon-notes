# Lecture 8 Mathematical Induction
---

## Induction format

Prove by induction that for all $n \in \mathbb{Z}^{+}$,
$$
1^2+2^2+\cdots+n^2=\frac{1}{6} n(n+1)(2 n+1)
$$
Answer:
1. For each $n \in \mathbb{Z}^{+}$, let $P(n) \equiv 1^2+2^2+\cdots+n^2=\frac{1}{6} n(n+1)(2 n+1)$.
2. (Basis step) $P(1)$ is true because $1^2=1=\frac{1}{6} \times 1 \times(1+1) \times(2 \times 1+1)$.
3. (Induction step)
	1. Let $k \in \mathbb{Z}^{+}$such that $P(k)$ is true, i.e. $1^2+2^2+\cdots+k^2=\frac{1}{6} n(k+1)(2 k+1)$
	2. Then $1^2+2^2+\cdots+k^2+(k+1)^2$
	3. $\quad=\frac{1}{6} k(k+1)(2 k+1)+(k+1)^2 \quad$ by the induction hypothesis
	4. $\quad=\frac{1}{6}(k+1)(k(2 k+1)+6(k+1))$
	5. $\quad=\frac{1}{6}(k+1)\left(2 k^2+7 k+6\right)$
	6. $\quad=\frac{1}{6}(k+1)(k+2)(2 k+3)$
	7. $\quad=\frac{1}{6}(k+1)((k+1)+1)(2(k+1)+1) \quad$ by basic algebra
	8. Thus $P(k+1)$ is true.
4. Therefore, $\forall n \in \mathbb{Z}^{+} P(n)$ is true by MI.

## Structural Induction

**Recursive definition of of a set $S$.**
**(base clause)** Specify that certain elements, called founders, are in $\mathrm{S}$ : if $c$ is a founder, then $c \in S$.
**(recursion clause)** Specify certain functions, called constructors, under which the set $S$ closed: if $f$ is a constructor and $x \in S$, then $f(x) \in S$.
**(minimality clause)** Membership for $S$ can always be demonstrated by (infinitely many) successive applications of the clauses above.

**Structural induction over $S$**
To prove that $\forall x \in S P(x)$ is true, where each $P(x)$ is a proposition, it suffices to: 
**(basis step)** show that $P(c)$ is true for every founder $c$; and
**(induction step)** show that $\forall x \in S(P(x) \Rightarrow P(f(x)))$ is true for every constructor $f$. In words, if all the founders satisfy a property $P$, and $P$ is preserved by all constructors, then all elements of $S$ satisfy $P$.