## Immutability 

1.  Make every field immutable
	1. Optional to make class final to disallow inheritance.
2.  create new object when its changed

 Advantages
- Ease of Understanding
- Enabling safe sharing of objects
- Enabling safe sharing of internals
- Enabling Safe Concurrent Execution

## Nested Class [[R06_guide.pdf]]

### Inner Class (Class defined within another class and not static)

``````col
`````col-md
flexGrow=1
===
```java
class A {
  private int x;
  static int y;
  class B { //nested class
    void foo() {
      x = 1; // accessing x from A is OK inside B
      y = 1; // accessing y from A is OK inside B
    }
  }
}
```
`````
`````col-md
flexGrow=1
===
```java
class A {
  private int x;
  class B {
		int x;
    void foo() {
      this.x = 1; // error should be A.this.x
			B.this.x = 1; // OK
    }
  }
}
```
`````
``````

### Static nested class (Class defined within another class and static)

```java
class A {
  private int x;
  static int y;
  static class C { // static is just used to prevent accessing x.
    void foo() {
      x = 1; // accessing x from A is NOT OK inside C. x is non static but C is a static class
      y = 1; // accessing y from A is OK inside C
    }
  }
}
```
For each of the questions below, suppose the following is invoked: 
`B b = new B () ;` 
`b . f () ; `
Sketch the content of the stack, heap, and metaspace immediately after the line 
`A a = new A () ;`
![[Functional.png|500]]

### Local Class (Class defined within a method and not static)

```java
interface C { void g(); }
class A {
  int x = 1;
  C f() {
    int y = 2;
    class B implements C {
      void g() {
        x = y; // accessing x and y is OK. but modifying y is not okay.
      }
    }
    B b = new B();// In the stack and heap diagram. y is stored in the heap in object B
									// This is called variable capture.
									// The object B in the heap has A.this in the begining
    return b;
  }
}
```

![[Functional Local Class.png|500]]
![[Functional Inner Class.png|500]]

#### Effectively Final

```java
void sortNames(List<String> names) {
  boolean ascendingOrder = true;
  class NameComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
      if (ascendingOrder)
        return s1.length() - s2.length();
      else
        return s2.length() - s1.length();
    }
  }

  ascendingOrder = false;
  names.sort(new NameComparator());
}
```
Will `sort` sorts in ascending order or descending order?

To avoid confusing code like this, Java only allows a local class to access variables that are explicitly declared `final` or implicitly final (or _effectively_ final). An implicitly final variable does not change after initialization. Therefore, Java saves us from such a hair-pulling situation and disallows such code -- `ascendingOrder` is not effectively final so the code above does not compile.

### Anonymous Class

An anonymous class is one where you declare a class and instantiate it in a single statement. It's anonymous since We do not even have to give the class a name.

```java
names.sort(new Comparator<String>() {
  public int compare(String s1, String s2) {
    return s1.length() - s2.length();
 }
});
```

An anonymous class has the following format: `new X (arguments) { body }` where _X_ is a class that the anonymous class extends or an interface that the anonymous class implements.

An anonymous class is just like a local class, it captures the variables of the enclosing scope as well -- the same rules to variable access as local classes applies.

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

## Monad

A **monad** has two methods `of` and `flatMap` (`bind` or the operator `>>=` in Haskell) and obeys **three** laws:

1.  **Left Identity Law:**
    -   `Monad.of(x).flatMap(y ->f(y))` ≡ `f(x)`
2.  **Right Identity Law:**
    -   `monad.flatMap(y -> Monad.of(y))` ≡ `monad`
3.  **Associative Law:**
    -   `monad.flatMap(x -> f(x)).flatMap(x -> g(x))`  
        ≡  
        `monad.flatMap(x -> f(x).flatMap(x -> g(x)))`

### Functor
A **functor** has two methods `of` and `map` (`fmap` or the operator `<$>` in Haskell) and obeys **two** laws:

1.  **Identity Morphism:**
    -   `functor.map(x -> x)` ≡ `functor`
2.  **Composition Morphism:**
    -   `functor.map(x ->f(x)).map(x ->g(x))`  
        ≡  
        `functor.map(x ->g(f(x)))`

![[Monad Example.png|600]]

## CompletableFuture Monad

There are several ways we can create a `CompletableFuture<T>` instance:

-   Use the `completedFuture` method. This method is equivalent to creating a task that is already completed and return us a value.
-   Use the `runAsync` method that takes in a `Runnable` lambda expression. `runAsync` has the return type of `CompletableFuture<Void>`. The returned `CompletableFuture` instance completes when the given lambda expression finishes.
-   Use the `supplyAsync` method that takes in a `Supplier<T>` lambda expression. `supplyAsync` has the return type of `CompletableFuture<T>`. The returned `CompletableFuture` instance completes when the given lambda expression finishes.

We can also create a `CompletableFuture` that relies on other `CompletableFuture` instances. We can use `allOf` or `anyOf` methods for this. Both of these methods take in a variable number of other `CompletableFuture` instances. A new `CompletableFuture` created with `allOf` is completed only when all the given `CompletableFuture` completes. On the other hand, a new `CompletableFuture` created with `anyOf` is completed when any one of the given `CompletableFuture` completes.

### Chaining `CompletableFuture`

The usefulness of `CompletableFuture` comes from the ability to chain them up and specify a sequence of computations to be run. We have the following methods:

-   `thenApply`, which is analogous to `map`
-   `thenCompose`, which is analogous to `flatMap`
-   `thenCombine`, which is analogous to `combine`
-   `thenAccept` which does not return. Returns an instance of the Void type. 

The methods above run the given lambda expression in the same thread as the caller. There is also an asynchronous version (`thenApplyAsync`, `thenComposeAsync`, `thenCombineAsync`), which may cause the given lambda expression to run in a different thread (thus more concurrency).

```java
CompletableFuture<Integer> cf = ten.thenApply(plus(1));
cf = cf.thenApplyAsync(plus(10));
cf.thenApplyAsync(plus(5)).join();
```
`join` prints in order as completable future chains them in order,

```java
CompletableFuture.allOf(
	ten.thenApplyAsync(plus(1)),
	ten.thenApplyAsync(plus(10)),
	ten.thenApplyAsync(plus(5))
).join();
```
This does not. 