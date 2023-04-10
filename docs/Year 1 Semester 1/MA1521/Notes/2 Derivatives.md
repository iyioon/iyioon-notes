# 2 Derivatives
---

## 2.6 Parametric Equations

A curve defined by the parametric equations
$$
x=f(t) \text { and } y=g(t),(t \text { is the parameter })
$$
is differentiable at point where $t=t_0$ if both $f$ and $g$ are differentiable at $t=t_0$. Usually we also assume $f^{\prime}\left(t_0\right) \neq 0$ or $g^{\prime}\left(t_0\right) \neq 0$.
By chain rule,
$$
\frac{d y}{d x}=\frac{d y}{d t} \div \frac{d x}{d t}=\frac{g^{\prime}(t)}{f^{\prime}(t)},
$$
and
$$
\frac{d^2 y}{d x^2}=\frac{d}{d t}\left(\frac{d y}{d x}\right) \div \frac{d x}{d t}=\frac{\frac{d}{d t}\left(\frac{g^{\prime}(t)}{f^{\prime}(t)}\right)}{f^{\prime}(t)}=\frac{g^{\prime \prime}(t) f^{\prime}(t)-g^{\prime}(t) f^{\prime \prime}(t)}{f^{\prime}(t)^3}
$$