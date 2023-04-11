# Boolean Algebra


## Precedence of Operators

1. Not
2. And
3. Or

Use parenthesis to overwrite precedence

## Proof using Truth Table

Use truth table to show the two results are the same. Visit [](Lect13_Boolean_Algebra_full.pdf#page=9%5C%7Cpage%209)
## Laws of Boolean Algebra

![Boolean Algebra Laws of Boolean Algebra](../Attachments/Boolean%20Algebra%20Laws%20of%20Boolean%20Algebra.png)

## Duality 

Switching `AND` and `OR` remains the equation valid

The dual equation of 

$$a+(b \cdot c)=(a+b) \cdot(a+c)$$
is
$$a \cdot(b+c)=(a \cdot b)+(a \cdot c)$$

## Theorems

![Boolean Algebra Theorems](../Attachments/Boolean%20Algebra%20Theorems.png)

## Boolean Functions

Visit [](Lect13_Boolean_Algebra_full.pdf#page=15)

## Complement Functions

Visit [](Lect13_Boolean_Algebra_full.pdf#page=16)

## Standard Forms

Certain types of Boolean expressions lead to circuits that are desirable from an implementation viewpoint.

There are two standard forms:
- [Sum-of-Products (SOP) expression](#Sum-of-Products%20(SOP)%20expression)
- [Product-of-Sums (POS) expression](#Product-of-Sums%20(POS)%20expression)

Every boolean expression can be expressed in SOP or POS form.

First lets start with the basic terms:

### Literals

- A boolean variable on its own or in its complemented form
- Example: $x$, $x'$

### Product term

- A single literal or a logical product (`AND`) of several literals
- Examples: $x,x \cdot y \cdot z',A' \cdot B$

### Sum term

- A single literal or a logical sum (`OR`) of several literals
- Examples: $x,x+y+z,A'+B$

### Sum-of-Products (SOP) expression

- A product term or a logical sum (OR) of several product terms
- Examples $x,x+y \cdot z'$

### Product-of-Sums (POS) expression

- A sum term or a logical product (AND) of several sum terms
- Examples $x,x \cdot(x+z'),(x+y) \cdot (x'+y+z)$


Quiz [](Lect13_Boolean_Algebra_full.pdf#page=19)

## Minterms and Maxterms

Visit [](Lect13_Boolean_Algebra_full.pdf#page=20)

![Boolean Algebra Minterms and Maxterms](../Attachments/Boolean%20Algebra%20Minterms%20and%20Maxterms.png)

Each minterm is the complement of its corresponding maxterm.

Example : [](Lect13_Boolean_Algebra_full.pdf#page=22)

### How to convert Boolean expression to Minterm and Maxterm.

Take (1) from Minterm. Represent the expression into binary by setting complement to 0 and the others to 1. This gives $A' \cdot B' \cdot C \cdot D \to 0011$. Which in decimal is 3. Hence the minterm notation is m3. 

For Maxterm, do the opposit by setting the complement to 1.

## Canonical Forms

> A unique form of representation

- Sum-of-minterms = Canonical sum-of-products
- Product-of-maxterms = Canonical product-ofsums

### Sum-of-Minterms

Visit [](Lect13_Boolean_Algebra_full.pdf#page=24)

### Product-of-Maxterms

Visit [](Lect13_Boolean_Algebra_full.pdf#page=25)

## Conversion of Standard Forms

$$\mathrm{F} 2=\Sigma \mathrm{m}(1,4,5,6,7)=\Pi \mathrm{M}(0,2,3)$$

We see that the list of $\Pi \mathrm{M}(0,2,3)$ is complementary to $\Sigma \mathrm{m}(1,4,5,6,7)$.
