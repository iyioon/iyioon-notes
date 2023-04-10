# Linear Systems & Gaussian Elimination

<span class="center-menu">[](MA2001-Chapter1.pdf#page=28%7CSolving%20linear%20system%20in%20row-echelon%20form)
[](MA2001-Chapter1.pdf#page=30%7CMethod%20of%20turning%20a%20augmented%20matrix%20into%20row-echelon%20form)
[](MA2001-Chapter1.pdf#page=33%7CFrom%20row-echelon%20form%20to%20reduced%20row-echelon%20form)
[](MA2001-Chapter1.pdf#page=35%7CConsistency)
[](MA2001-Chapter1.pdf#page=38%7CNotations)
[](MA2001-Chapter1.pdf#page=50%7CHomogeneous%20Linear%20Systems)
</span>

## Consistency 

### No Solution (Inconsistent)

There is a row in $\boldsymbol{R}$ with the form
- $\left(\begin{array}{llll}0 & 0 & \cdots & 0\end{array} \mid \otimes\right)$, where $\otimes$ is nonzero.

Or equivalently,_ the last column is a pivot column_.
Note: Such a row must be the last nonzero row of $\boldsymbol{R}$.

Example:

$\left(\begin{array}{lll|l}3 & 2 & 3 & 4 \\ 0 & 0 & 1 & 1 \\ 0 & 0 & 0 & 2\end{array}\right), \quad\left(\begin{array}{lll|l}3 & 2 & 3 & 4 \\ 0 & 0 & 0 & 5 \\ 0 & 0 & 0 & 0\end{array}\right)$

### One Solution (Consistent)

- The last column is a non-pivot column, and
- All other columns are pivot columns.

Example: (Here $\otimes$ are pivot points, which are nonzero.)

$\left(\begin{array}{ccccc|c}\otimes & * & * & \cdots & * & * \\ 0 & \otimes & * & \cdots & * & * \\ 0 & 0 & \otimes & \cdots & * & * \\ \vdots & \vdots & \vdots & \ddots & * & * \\ 0 & 0 & 0 & \cdots & \otimes & * \\ 0 & 0 & 0 & \cdots & 0 & 0 \\ 0 & 0 & 0 & \cdots & 0 & 0\end{array}\right)$

### Infinite Solution (Consistent)

- The last column is a non-pivot column, and
- Some other columns are non-pivot columns.

Note: The number of arbitrary parameters is the same as the number of non-pivot columns (except the last column).

Examples:

$\left(\begin{array}{cccc|c}5 & 1 & 2 & 3 & 4 \\ 0 & 0 & -1 & 0 & 1 \\ 0 & 0 & 0 & 1 & 2\end{array}\right),\left(\begin{array}{cccc|c}0 & 1 & 2 & 3 & 4 \\ 0 & 0 & -1 & 0 & 1 \\ 0 & 0 & 0 & 0 & 0\end{array}\right)$
