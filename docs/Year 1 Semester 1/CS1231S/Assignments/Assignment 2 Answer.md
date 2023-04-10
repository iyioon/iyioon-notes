<p align="right"><b>Moon Ji Hoon <br>TG10C</b></p>

# Question 1
(a) $(2,2) \notin S$

1. Since $(0,0) \in S,(1,1) \in S$ (by base clause)
	1. $(2,1)\in S$ (By the recursion clause)
3. Since there is only one $(n,x+y)\in S$ for each $n$ 
	1. and when $n = 2$ , $(2,1)\in S$
4.  $(2,2) \notin S$

(b) $(10,55) \in S$

1.  $(0,0) \in S,(1,1) \in S$ (by base clause)
2. $(2,1)\in S$ (by the recursion clause)
3. $(3,2)\in S$ (by the recursion clause)
4. $(4,3)\in S$ (by the recursion clause)
5. $(5,5)\in S$ (by the recursion clause)
6. $(6,8)\in S$ (by the recursion clause)
7. $(7,13)\in S$ (by the recursion clause)
8. $(8,21)\in S$ (by the recursion clause)
9. $(9,34)\in S$ (by the recursion clause)
10. $(10,55)\in S$ (by the recursion clause)

(c) $S$ represents the set of ordered pairs where each element $(a,b)$ represents the value of Fibonacci number $b$ at an index $a$. 


# Question 2

1. Let $P(n)\equiv \left(x^{2}|(x+1)^n-n x-1\right) \text { for all integers } n \geq 2$  
2. Basis step:
	1. $(x+1)^2-2x-1$
	2. $=x^{2}+2x+1-2x-1=x^2$ (by basic algebra)
	3. Since $x^2$ is divisible by $x^2$, $P(2)$ is true.
4.  Assume $P(k)$ is true for $k\geq2$
	1. This means that $(x+1)^{k}-kx-1= rx^2$ for some integer $r$ (by def of divisibility)
2. Inductive step: (To show $P(k+1)$ is true)
	1. $P(k+1)=(x+1)^{k+1}-(k+1)x-1$ 
	2. $=(x+1)^k(x+1)-kx-x-1$
	3. $=(x+1)^kx+(x+1)^k-kx-x-1$
	4. $=\left((x+1)^k-kx-1\right)+x(x+1)^k-x$
	5. $=rx^2+x(x+1)^k-x$ (by induction hypothesis)
	6. $=rx^2+x\left((x+1)^k-1\right)$
	7. $=rx^2+x\left((x+1)^k-kx-1+kx\right)$
	8. $=rx^2+x\left(rx^2+kx\right)$ (by induction hypothesis)
	9. $=rx^2+x^2(rx+k)$
	10. $=x^2\left(r+(rx+k)\right)$ (by basic algebra)
	11. Since $x^2|(x+1)^{k+1}-(k+1)x-1$, therefore $P(k+1)$ is true
12. Therefore, $P(n)$ is true for all integers $n\geq2$

# Question 3

(a) No, $f$ is not a surjection

1. Assume $f$ is a surjection and let $y\in \mathbb{R}$
2. Then $\exists x\in A$ such that $\frac{x+1}{x-1}=y$  (by the definition of surjection)
3. Then, $x = \frac{y+1}{y-1}\in A$ (by basic algebra)
4. However, when $y=1$ which is an element in the co-domain $\mathbb{R}$
	1. $x = \frac{2}{0}$ which is undefined
2. Since $x$ does not exist, $f$ is not a surjection

(b)

1. (To show $g$ is injective)
	1. Let $(x_{1},y_{1}),(x_{2},y_{2})\in S$ such that $g(x_1,y_1)=g(x_2,y_2)$
	2. Then $\left(\frac{y_1+2}{x_1-2}, \frac{1}{x_1-2}\right)=\left(\frac{y_2+2}{x_2-2}, \frac{1}{x_2-2}\right)$
		1. $\frac{1}{x_1-2}=\frac{1}{x_2-2}$ (by the definition of Ordered Pairs)
			1. $x_{2}-2=x_{1}-2$
			2. $x_2=x_1$ (by basic algebra)
		2. $\frac{y_{1}+2}{x_{1}-2} =\frac{y_2+2}{x_2-2}$ (by the definition of Ordered Pairs)
			1. $(y_1+2)(x_2-2)=(y_2+2)(x_1-2)$
			2. $y_1x_2-2y_1+2x_2-4=y_2x_1-2y_2+2x_1-4$
			3. $y_1(x_2-2)+2x_2=y_2(x_1-2)+2x_1$ (by basic algebra)
			4. Since $x_1=x_2$ (by 1.2.1.2)
			5. $y_1=y_2$
		6. Since $x_2=x_1$ and $y_1=y_2$,  $g$ is injective
7. Assume $g$ is surjective (to show $g$ is not surjective)
	1. Let $(x_2,y_{2})\in \mathbb{R}\times\mathbb{R}$
	2. Then $\exists (x_1,y_1)\in S$ such that  $\left(\frac{y_1+2}{x_1-2}, \frac{1}{x_1-2}\right)=(x_2,y_2)$ (by the definition of surjection)
		1. Then, $x_{2}= \frac{y_1+2}{x_1-2}$ and $y_{2} =\frac{1}{x_1-2}$ (by the equality of Ordered Pairs)
		2. $y_1=x_2x_1-2x_2-2$ and $x_1=\frac{1+2y_2}{y_2}$ (by basic algebra)
		3. $y_1=\frac{x_2+2y_2x_2}{y_2}-2x_2-2$ and $x_1=\frac{1+2y_2}{y_2}$ (by basic algebra)
	4. However, when $(x_2,y_{2}) = (0,0)$ which is a element in the co-domain $\mathbb{R}\times\mathbb{R}$
		1.  $y_1=\frac{0}{0}-0-2$ and $x_1=\frac{1+0}{0}$ which are not defined
		2. Hence there is no $(x_1,y_1)\in S$ such that  $\left(\frac{y_1+2}{x_1-2}, \frac{1}{x_1-2}\right)=(0,0)$
	3. Therefore, $g$ is not surjective


# Question 4

(a) True

1. To show $A\backslash B$ is countable
	1. $A\backslash B = A \cap \bar{B}$ (by set difference law)
	2. Let $x\in A \cap \bar{B}$
		1. Then $x\in A$ (by the definition of $\cap$)
		2. Therefore $A \cap \bar{B} \subseteq A$
		3. hence, $A\backslash B \subseteq A$
	3. Since $A$ is countable , $A\backslash B$ is countable  (Theorem 7.4.3)
4. To show $A\backslash B$ is infinite, Suppose $A\backslash B$ is finite
	1. $A=(A \backslash B) \cup(A \cap B)$
	2. Since $A \cap B\subseteq B$ (by Theorem 6.2.1 Inclusion of intersection)
		1. $A \cap B$ is finite as $B$ is finite (Any subset of a finite set is finite.)
	2. Therefore  $(A \backslash B) \cup(A \cap B)$ is finite, thus $A$ must be finite. (Theorem 9.2.5 Unions)
	3. However this contradicts that $A$ is infinite
	4. Therefore $A\backslash B$ must be infinite
5. Therefore, $A\backslash B$ is countably infinite (by 1.3 , 2.5)

(b) False

1. Take $\mathbb{Z^+}$ and $A = \{x\in \mathbb{Z}: x<2\}$
2. To show $A$ is countably infinite, define a function $f:\mathbb{Z^+}\to A$ , $f(x) = 2-x$
	1. To show $f$ is a bijection
		1. Show $f$ is a injection
			1. let $x_{1},x_{2}  \in \mathbb{Z^+}$ such that $f(x_{1})=f(x_{2})$
			2. Then $2-x_{1}=2-x_{2}$
			3. Therefore $x_{1} = x_{2}$ (by basic algebra)
			4. Hence, $f$ is injective
		5. Show $f$ is a surjection
			1. Take any $y\in A$
			2. Let $x = 2-y$
			3. Then $x\in \mathbb{Z^+}$ and $f(x) = 2-x=2-2+y=y$
			4. Hence, $f$ is surjective
	5. Therefore $f$ is bijective (by 2.1.1.4, 2.1.2.4)
	6. Since there is a bijection between $\mathbb{Z^+}$ and $A$, $A$ is countably infinite.
7.  $\mathbb{Z^{+}}\cap A=\{1\}$ which is finite
8. Therefore the statement "If $A$ and $B$ are countably infinite, then $A \cap B$ is countably infinite" is false.

(c) True

1. To show $B$ is countable
	1. Since $C$ countable and $B\subseteq C$, $B$ is countable (Theorem 7.4.3)
2. To Show $B$ is infinite
	1. Suppose $B$ is finite 
	2. Then since $A\subseteq B$, $A$ must be finite (Any subset of a finite set is finite)
	3. However, this contradicts that $A$ is infinite.
	4. Therefore, $B$ must be infinite
5. Therefore $B$ is countably infinite (by 1.1, 2.4)

# Question 5

(a) $5,006,710,800$
1. Dueet can only receive 1 Jack out of 4 and other 12 cards out of 36 (0 HCP)
2. Therefore, $4\times 36C12=5006710800$

(b) $8,611,542,576$
1. Dueet can either receive:
	1. Two Jacks out of 4 and other 11 cards out of 36 (0 HCP)
		1. $4C2\times36C11=3604831776$
	2. One queen out of 4 and other 12 cards out of 36 (0 HCP)
		1. $4\times36C12=5006710800$
2. Therefore, $5006710800+3604831776=8611542576$

(c) $15,929,042,976$
1. Duet can have 2 HCP or 1 HCP or 0 HCP
2. The number of ways is equal to 
	1. $5006710800+8611542576+36C13$
	2. $=15929042976$

# Question 6
(a) $184756$
There are 10 right and 10 up that can be used to reach the prize chest and since the order of up does not matter and order of right does not matter: $\frac{20!}{10!\times10!}=184756$

(b) 12012
1. To get to the key
	1. Aiken have to use 5 right and 9 up to reach to the key.
	2. Number of ways: $\frac{14!}{5!\times 9!}=2002$
3. To get to the chest from the key
	1. Aiken have to use 5 right and 1 up
	2. Number of ways: $\frac{6!}{5!\times 1!}=6$
3. Ways  Aiken can pick up the key first and then reach the chest: $2002\times6=12012$

(c) 6000
1. Let $A$ be the key on $(7,3)$ and $B$ be the key on $(8,7)$
2. Since Aiken can only move right and up, he has to collect $A$ first.
3. To get to $A$
	1. Aiken have to use 7 right and 3 up 
	2. Number of ways: $\frac{10!}{7!\times 3!}=120$
3. To get from $A$ to $B$
	1. Aiken have to use 1 right and 4 up
	2. Number of ways: $\frac{5!}{1!\times 4!}=5$
3. To get from $B$ to the chest
	1. Aiken have to use 2 right and 3 up
	2. Number of ways: $\frac{5!}{2!\times 3!}=10$
3. Number of ways to visit $A$ and $B$ and the chest: $120\times 5\times 10=6000$