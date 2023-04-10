## Dynamic vs Static Type

**Dynamic Typed**: The same variable can hold values of different types, and checking if the right type is used is done during the execution of the program.

**Static Type:** <font style="color:#3258a8"></font> <u>Java is a statically typed language</u>. A variable can only hold values of the same type as the type of the variable.

## Strong Typing vs Weak Typing

A  **type system** of a programming language is a set of rules that govern how the types can interact with each other.

**Strongly typed** programming language enforces strict rules in its type system, to ensure  **type safety**, i.e., to catch type errors during compile time rather than leaving it to runtime.

**Weakly typed** programming language is more permissive in terms of typing checking. C is an example of a static, weakly typed language. In C, the following is possible:

## Types in Java

### Primitive Type

Primitive types are types that holds numeric values (integers, floating-point numbers) as well as boolean values (`true` and `false`).

### Reference Type

A reference variable stores only the reference to the value, and therefore two reference variables can share the same value.

![500](../../Attachment/1%20Introduction.png)

Small number are cached. == Checks for same reference location. Hence if `i` is small, `x == y` returns true and vice versa.

## Subtypes

Let S and T be two types. We say that T is a **_subtype_** of S if _a piece of code written for variables of type S can also safely be used on variables of type T_. 

We use the notation T<:S or S:>T to denote that T is subtype of S. Or S is a supertype of T.

The subtype relationship is
- **transitive**, i.e., if S<:T and T<:U, then S<:U
- **reflexive**, for any type S, S<:S.

