# 10.5 Reduction to Separable Form

### Example:
Solve $2xyy'-y^{2}+x^{2}=0$.

**Solution:** We may rewrite the equation as $y^{\prime}=\frac{-1+\left(\frac{y}{x}\right)^2}{2\left(\frac{y}{x}\right)}$. Let $v=\frac{y}{x}$. Then the equation can be written as $v+x v^{\prime}=\frac{-1+v^2}{2 v}$. That is $x v^{\prime}=\frac{-1-v^2}{2 v} \Leftrightarrow \frac{2 v d v}{1+v^2}=-\frac{d x}{x}$. Integrating, $\ln \left|1+v^2\right|=-\ln |x|+C$. That is $1+v^2=K e^{-\ln |x|}=\frac{K}{|x|}$. Therefore, $1+\frac{y^2}{x^2}=\frac{A}{x}$, or equivalently, $x^2+y^2=A x$.

# 10.6 Reduction to Separable Form

### Example 10.6. 
Solve $(2 x-4 y+5) y^{\prime}+x-2 y+3=0$.

**Solution**. Let $u=x-2 y$. Then $u^{\prime}=1-2 y^{\prime}$. Thus the equation becomes $(2 u+5) \frac{1}{2}\left(1-u^{\prime}\right)+u+3=$ $0 \Leftrightarrow(2 u+5) u^{\prime}=4 u+11$
Separating variables, and integrating, $\left(1-\frac{1}{4 u+11}\right) d u=2 d x$. Thus $u-\frac{1}{4} \ln |4 u+11|=2 x+C_1$, or $4 x+8 y+\ln |4 x-8 y+11|=C$.

---

### Exercise 10.3.
Solve the initial value problem $y^{\prime}=\frac{y}{x}+\frac{2 x^3 \cos \left(x^2\right)}{y}, y(\sqrt{\pi})=0$.
This involves converting into exact equations. See [[10 Ordinary Differential Equations#Exact Equations]]
$$
\begin{align*}
&yy'=\frac{y^2}{x}+2x^3\cos x^{2}\\
&yy'-\frac{y^2}{x}=2x^3\cos x^2\\
&\frac{yy'}{x^2}-\frac{y^2}{x^3}=2x\cos x^2\\
\\
&h_{x} = -\frac{y^{2}}{x^{3}}\implies h(x,y)=\frac{y^{2}}{2x^{2}}+g(y)\\
&h_{y} = \frac{2yy'}{2x^{2}}+g'(y)=\frac{yy'}{x^{2}}\\
&\implies g'(y) = 0 \implies g(y)=c\\
&z=\frac{y^{2}}{2x^{2}}\\
&dz = 2x\cos x^2dx\\
&z = \sin x^2+c \\
&y^2 = 2x^2\sin x^2+c\\
&y=2x \sqrt{ 2\sin x^2+c }
\end{align*}
$$


Ans: $y=\pm x \sqrt{2 \sin \left(x^2\right)}$

---

### Exercise 10.4
Solve $(x+2 y-1)+3(x+2 y) y^{\prime}=0$.


Ans: $x+3 y+C=3 \ln |x+2 y+2|, x+2 y+2=0$.

# 10.7 Linear First Order ODE

### Example 10.7
Solve $x y^{\prime}-3 y=x^2, x>0$.

**Solution**. Rewrite the DE in the standard form $y^{\prime}-\frac{3}{x} y=x$. An integrating factor is $e^{\int-\frac{3}{x} d x}=$ $e^{-3 \ln x}=\frac{1}{x^3}$. Multiplying the DE (the standard form) by this integrating factor, we have $\left(\frac{y}{x^3}\right)^{\prime}=\frac{1}{x^2}$. Integrating, we have $\frac{y}{x^3}=-\frac{1}{x}+C$. That is $y=-x^2+C x^3$.

---

### Example 10.8
Solve $y^{\prime}-y=e^{2 x}$.

**Solution**. An integrating factor is $e^{\int-1 d x}=e^{-x}$. Multiplying the DE by this integrating factor, we have $\left(y e^{-x}\right)^{\prime}=e^x$. Integrating, we obtain $y e^{-x}=e^x+C$. That is $y=e^{2 x}+C e^x$.

---

### Exercise 10.5
Solve the differential equation
$$
(x+1)^2 \frac{d y}{d x}-(x+1) y=2, x>-1 .
$$
Ans: $y=-\frac{1}{x+1}+C(x+1)$.

---

### Exercise 10.6
Solve the differential equation
$$
\frac{d y}{d x}=\frac{4+y \sin x}{\cos x},-\frac{\pi}{2}<x<\frac{\pi}{2},
$$
given that $y=6$ when $x=0$.
Ans: $y=\frac{4 x+6}{\cos x}$.

---

### Exercise 10.7
An object of mass $m$ dropped from rest in a medium that offers a resistance proportional to the magnitude of the instantaneous velocity of the object. Let $x(t)$ be the displacement of the object measured vertically downward at time $t$ so that $x(0)=0$. Show that
$$
x(t)=\frac{m g}{k} t+\frac{m^2 g}{k^2}\left(e^{-\frac{k}{m} t}-1\right),
$$
where $k$ is the proportional (positive) constant of the force of resistance of the medium.

# 10.8 The Bernoulli Equation

### Example 10.9
Solve $y^{\prime}+y=x^2 y^2$.

**Solution**. Let $z=y^{1-2}=y^{-1}$. Then $z^{\prime}=-y^{-2} y^{\prime}$. Thus the given Bernoulli equation can be written as $-y^2 z^{\prime}+y=x^2 y^2 \Leftrightarrow z^{\prime}-y^{-1}=-x^2 \Leftrightarrow z^{\prime}-z=-x^2$. This is a first order linear equation. Multiplying by the integrating factor $e^{\int-d x}=e^{-x}$, we have $\left(z e^{-x}\right)^{\prime}=-x^2 e^{-x}$. Integrating, $z e^{-x}=\int-x^2 e^{-x} d x$. Using integration by parts, we have $\int-x^2 e^{-x} d x=x^2 e^{-x}+2 x e^{-x}+2 e^{-x}+C$. Thus $z=e^x\left(x^2 e^{-x}+2 x e^{-x}+2 e^{-x}+C\right)$. Therefore, $\frac{1}{y}=x^2+2 x+2+C e^x$. Consequently, $y=$ $\frac{1}{x^2+2 x+2+C e^x}$.

---

### Exercise 10.8
Solve $x y^{\prime}+y=x^4 y^3$.
Ans: $\frac{1}{y^2}=-x^4+c x^2$, or $y=0$.

# Applications of ODE

### Example 10.10
At time $t=0$, a tank contains $20 \mathrm{~kg}$ of salt dissolved in 100 litres of water. Assume that water containing $\frac{1}{4} \mathrm{~kg}$ of salt per litre is entering the tank at the rate of 3 litre per min, and the well-stirred solution is leaving the tank at the same rate. Find the amount of salt at any time $t$.

![[Applications of ODE.png|c|500]]
**Solution**. First note that the volume of the solution remains constant which is 100 litres. Let $Q$ be the amount of salt in $\mathrm{kg}$ at time $t$. The concentration of salt in the solution is $Q / 100 \mathrm{~kg}$ per litre. Suppose at time $t+d t$, the amount of salt is $Q+d Q$. Then
$$
d Q=\text { salt input }-\text { salt output }=3 \times \frac{1}{4} \times d t-3 \times \frac{Q}{100} \times d t
$$
Thus
$$
\frac{d Q}{d t}=\frac{3}{4}-\frac{3 Q}{100} .
$$
The general solution to this first order linear DE is $Q=25+C e^{-\frac{3 t}{100}}$. Since $Q(0)=20$, we have $20=25+C$ so that $C=-5$. Consequently, $Q=25-5 e^{-\frac{3 t}{100}}$.

Note that $\lim _{t \rightarrow \infty} Q(t)=25$. Thus after sufficiently long time, the salt concentration remains constant at $25 \mathrm{~kg}$ per 100 litres.

---

### Example 10.11
A body was found at a crime scene. You are a member of the CSI team and you arrived at the crime scene at $8 A M$. Immediately upon arrival, you took the temperature of the victim and found that it was $26^{\circ} \mathrm{C}$. At $9 A M$, you took the temperature of the victim again and found that it was $24^{\circ} \mathrm{C}$. You estimate that the victim's temperature was $37^{\circ} \mathrm{C}$ just before death and that the temperature at the crime scene stayed approximately constant at $21^{\circ} \mathrm{C}$. What is your estimate on the time of death?

**Solution**. Set time $t=0$ at $8 \mathrm{AM}$, where $t$ is measured in hours. Let $T$ be the temperature of the body at time $t$. We have $\frac{d T}{d t}=k(T-21)$. The general solution is $T=21+A e^{k t}$. As $T(0)=26$, we have $26=21+A$ so that $A=5$. Therefore, $T=21+5 e^{k t}$. At $9 \mathrm{AM}$, that is 1 hour later, $T(1)=24$. Thus $24=21+5 e^k$ so that $k=\ln \left(\frac{3}{5}\right)$. Hence
$$
T=21+5 e^{\ln \left(\frac{3}{5}\right) t}=21+5\left(\frac{3}{5}\right)^t .
$$
If $\tau$ is the time of death, then $T(\tau)=37$. Therefore,
$$
37=21+5\left(\frac{3}{5}\right)^\tau .
$$
That is $\frac{16}{5}=\left(\frac{3}{5}\right)^\tau \Leftrightarrow \ln \left(\frac{16}{5}\right)=\tau \ln \left(\frac{3}{5}\right) \Leftrightarrow \tau=\ln \left(\frac{16}{5}\right) / \ln \left(\frac{3}{5}\right)=-2.277$ hours, (or equivalently negative 2 hour $17 \mathrm{mins}$ ). Thus time of death is about $5: 43 \mathrm{AM}$.

