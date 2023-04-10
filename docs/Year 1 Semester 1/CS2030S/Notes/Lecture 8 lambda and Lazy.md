## Pure Functions

1. Deterministic: Same input -> Same output
2.  No side effect f(x) = y everywhere
    -   We say that the return value of the function is the “main” effect and anything else is a side effect.
    -   Side effects include
        -   print to the screen,
        -   write to files,
        -   Throw exceptions,
        -   Change/mutate fields,
        -   Mutate the argument.
3.  Referential transparency (Anytime we have f(x) we can replace with y and anytime we have y we can replace with f(x))

## Function as First-Class Citizen in Java

Function behave just like any other value

###  Functional Interface

A interface with a single abstract method and can be used as the assignment target for a lambda expression or method reference.

```java 
@FunctionalInterface
interface Immutator<R,P> {
  R invoke(P p);
}
```

### Lambda Expression
```java
Transformer<Integer, Integer> square = new Transformer<>() {
  @Override
  public Integer transform(Integer x) {
    return x * x;
  }
};
Transformer<Integer, Integer> incr = new Transformer<>() {
  @Override
  public Integer transform(Integer x) {
    return x + 1;
  }
};
```

```java
Transformer<Integer, Integer> square = x -> x * x;
Transformer<Integer, Integer> incr = x -> x + 1;
```

### Method Reference

The double-colon notation `::` is used to specify a _method reference_. We can use method references to refer to a (i) static method in a class, (ii) instance method of a class or interface, (iii) constructor of a class.

```java
Box::of            // x -> Box.of(x)
Box::new           // x -> new Box(x)
x::compareTo       // y -> x.compareTo(y)
A::foo             // (x, y) -> x.foo(y) or (x, y) -> A.foo(x,y)
```

### Curried Functions

A technique to convert a function that takes multiple argument into a sequence of functions that takes each takes a single argument.

```java
int add(int x, int y) {
  return x + y;
}
// Can be written as
// Interpreted as Take in a Integer and return a new Transformer
Transformer<Integer, Transformer<Integer, Integer>> add = x -> y -> (x + y);
// To calculate 1+1 we call
add.transform(1).transform(1);
```

### Lambda as a Closure

```java
Point origin = new Point(0, 0);
Transformer<Point, Double> dist = origin::distanceTo;
```

The variable `origin` is captured by the lambda expression `dist`. Just like in local and anonymous classes, a captured variable must be either explicitly declared as `final` or is effectively final.

A lambda expression stores more than just the function to invoke -- it also stores the data from the environment where it is defined. We call such a construct that stores a function together with the enclosing environment a _closure_.