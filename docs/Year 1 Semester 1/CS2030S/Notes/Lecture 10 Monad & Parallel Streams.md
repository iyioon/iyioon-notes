# <font style="color:#3258a8">Lecture 10 Monad & Parallel Streams</font>
---
## <u>Recap: Pure Functions</u>

### Definition:
>$f:X \to Y$
>where $X$ is the domain and $Y$ is the codomain and $f(x)$ is [[JAVA#Deterministic|deterministic]] ($f(x)$ always return the same value for the same value $x$)

### Properties:
1. No side effect *($f(x)=y$ everywhere)*
	1. We say that the return value of the function is the **_"main"_** effect and anything else is a side effect. 
	2. Side effects
		- Print to the screen
		- Write to files
		- Throw exceptions
		- Change/mutate fields
		- Mutate the arguments *(the changes is visible by the caller)*
1. Referential transparency (anytime we have $f(x)$ we can actually replace it with $y$ and anytime we have $y$ we can replace it with $f(x)$)

### Pure functions and immutability:
$x$ must be unchanged *ie immutable*
- Assume otherwise, then $f(x) == f(x)$ can be false
- Because the second call $f(x)$ is on a mutated x.

### Interface for Pure Functions
#### Function<T,R>
```java
interface Function<T,R> {
	R apply(T t);
}
```
#### Immutator<R,T>
```java
interface Immutator<R,T> {
	R invoke(T t);
}
```

## <u>BOX</u>
>A simple container of immutable object

### Basic code
```java
class Box<T> {
  protected final T val; //Use protected
  public Box(T val) {
    this.val = val;
  }
}
```

### Operating on Box
```java
  <R> Box<R> map(Function<T,R> f) { //map is a naming convention
    // Emulating f(Box<T>) -> Box<R>
    return new Box<R>(
      f.apply(this.val)
    );
  }
```
Note: [[JAVA#JAVA Types|Protected]] because we want to extend Box 
![[Box.png|300]]

### Capturing side effect with box
Recap: The following function is Not a pure function
```java
int incr(int i) {
  return this.count + i;
}
```
because `this.count` is not inside the box! This means that:
```java
this.count = 0
	incr(1) -> 1
this.count = 2
	incr(1) -> 3
```
Which is not [[JAVA#Deterministic|deterministic]]
Question: How do we make this into a pure function?
Answer: Insert any side effect into the box.
![[ImputeAndPure.png|800]]
Every time you transform `Box { val: i ; ctx: c }`, you will get exactly the same `Box { val: val + ctx ; ctx: c }`

### Box with Counter
*To capture side-effect -> Put the side effect into the box.*
```java
class BoxCtx<T> extends Box<T> {
  protected final int ctx;
  public BoxCtx(T val, int ctx) {
    super(val);
    this.ctx = ctx;
  }
  <R> BoxCtx<R> map(Function<T,R> f) {
    return new BoxCtx<R>(
      f.apply(this.val) + this.ctx,
      this.ctx
    );
  }
}
```
##### Note
`f` must be a function from `Integer` to `Integer` (i.e., `T := Integer` and `R := Integer`)

### Capturing Exception side Effect
![[Actually.png|700]]
![[Container.png|700]]![[Container2.png||700]]
### Box as Value + Context

#### Factory Method
**Idea**: To prevent an unintended creation (e.g., creating `Actually<T>` with both `val` and `err`), we make the constructor `private` (or `protected`).

This is done via **factory method** that performs the construction correctly (e.g., does not allow both `val` and `err` to be set).

##### Typical Name
-   `of` : Java convention
-   `from` : Rust convention

##### `Box<T>`
```java
class Box<T> {
  :
  static <T> Box<T> of(T val) {
    return new Box<T>(val);
  }
  :
}
```
##### `BoxCtx<T>`
```java
class BoxCtx<T> extends Box<T> {
  :
  static <T> BoxCtx<T> of(T val) {
    return new BoxCtx<T>(val, 0);
  }
  static <T> BoxCtx<T> of(T val, int ctx) {
    return new BoxCtx<T>(val, ctx);
  }
  :
}
```

##### `Actually<T>`
```java
class Actually<T> extends Box<T> {
  :
  static <T> Actually<T> of(T val) {         // ok
    return new Actually<T>(val, null);
  }
  static <T> Actually<T> of(Exception err) { // err
    return new Actually<T>(null, err);
  }
  :
}
```
#### Transformation Method
Idea: We let the _client_ to provide a function to operate on the data using _lambda_. We provide a method `map` to use this function on data.

Operation:
1.  Open the box (`this.val`)
2.  Transform (invoke lambda)
3.  Put into new box (`.of(...)`)

```java
T arg = this.val;
R res = f.apply(arg);
return Box.of(res);
// return Box.of(f.apply(this.val)); Basically writing them in one line
```

Advantage:
-   We can **"compose"** transformation `box.map(f).map(g)`
    -   Simply because `map` returns another `Box`
    -   If `f` and `g` are pure, if is the same as  
        `box.map(x ->f(g(x)))`

Limitation:
-   We cannot change the **"context"** (e.g., `ctx` in `BoxCtx`) using `map` (solved by adding `flatMap`)
-   We cannot access the "content" or the "context" (solved by adding `get`)

#### Creating new context
Idea: We let the _client_ to provide a function to operate on the data **AND** provide new context! We provide a method `flatMap` to use this function on data.

Operation
1.  Open the box (`this.val`)
2.  Transform (invoke lambda)
3.  Return the result (modify context?)
```java
  T arg = this.val;
  Box<R> res = f.apply(arg);
  return mod(res);
  // return mod(f.apply(this.val));

```

## Logger

### Motivational Example
> **Logger**
> We want to create an _immutable_ class called `Logger` that:
> 
> -   stores an integer value `val`
> -   has two operations `inc` (increment, or `+1`) and `abs` (absolute value)
> -   records _all_ previous operations done to reach the current value (as a string)
> 
> Good to have feature:
> 
> -   We can add more operations easily
>     -   and still log the operation

#### Function Composition
Functions:
```java
int inc(int x) {
  return x + 1;
}
int abs(int x) {
  return x > 0 ? x : -x;
}
```
Usage:
```shell
inc(1)
$.. ==> 2
abs(-1)
$.. ==> 1
abs(inc(inc(-5)))
$.. ==> 3
```
#### Pair as a State
Pair Class:
```java
class Pair<T,S> {
  private final T fst;
  private final S snd;
  :
  @Override
  String toString() {
    return "[" + this.fst +
           "," + this.snd + "]";
  }
}
```
Pure Function on Logger as Pair:
```java
Pair<Integer,String> incWithLog(int x) {
  return Pair.of(inc(x), "; inc: " + x);
}
Pair<Integer,String> absWithLog(int x) {
  return Pair.of(abs(x), "; abs: " + x);
}
```
However these two function cannot be composed.

##### Making it Composable
> All _composable_ function must:
> 
> -   take in as argument the type `T` (i.e., `Pair`)
> -   returns the same type `T` (i.e., `Pair`)
```java
Pair<Integer,String> incWithLog(Pair<Integer,String> p) {
  return Pair.of(inc(p.getFst()), p.getSnd() + "; inc: " + p.getFst());
}
Pair<Integer,String> absWithLog(Pair<Integer,String> p) {
  return Pair.of(abs(p.getFst()), p.getSnd() + "; abs: " + p.getFst());
}
```

#### Loggable Class
```java
class Loggable<T> {
  private final T val;
  private final String log;
  :
  public <R> Loggable<R> flatMap(Function<? super T, ? extends Loggable<? extends R>> f) {
    Loggable<? extends R> l = f.apply(this.val);
    return new Loggable<>(l.val, this.log + l.log);
  }
}

```


## <u>Monad</u>

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


## <u>Parallel and Concurrent</u>

### <u>IntStream</u>

#### Sequential Int Stream
IsPrime
```java
boolean isPrime(int n) {
  return IntStream.range(2, ((int)Math.sqrt(n))+1)
                  .noneMatch(x -> n%x == 0);
}
```
Prime in Range
```java
IntStream.range(2030000, 2040000)

         .filter(x -> isPrime(x))
         .forEach(System.out::println);

```
![[Sequential.png|400]]
The bottom part shows the number of process
#### Parallel Int Stream
Prime in Range
```java
IntStream.range(2030000, 2040000)
					.parallel()
         .filter(x -> isPrime(x))
         .forEach(System.out::println);

```
Parallel allows us to compute them concurrently. Therefore, the order of `System.out.println` may be different every time as one computation may finish earlier than others. This is called [[JAVA#Embarrassingly Parallel|Embarrassingly Parallel]]. To make it sequential again, add `.sequential()` next to `.filter()`.

All parallel is concurrent but not all concurrent parallel.
![[Concurrent.png|400]]
![[Parallel.png|400]]

#### Considerations
<u>Interference</u>
```java
List<String> list = new ArrayList<>(List.of("Luke", "Leia", "Han"));
list.stream().peek(name -> {
      if (name.equals("Han")) {
        list.add("Chewie");
      }
    }).forEach(x -> {});
```
Java does not allow to change whatever datasource you are using as you are processing the stream. There must not be any interference.

<u>Side Effect</u>
```java
List<Integer> list = new ArrayList<>(
  Arrays.asList(1,3,5,7,9,11,13,15,17,19,21,23,25,27,29)
);
List<Integer> result = new ArrayList<>();

list.parallelStream().filter(x -> isPrime(x)).forEach(System.out::println);

list.parallelStream().filter(x -> isPrime(x)).forEach(x -> result.add(x));

```

#### Collectors
<u>Collect</u>
```java
List<Integer> list = new ArrayList<>(
  Arrays.asList(1,3,5,7,9,11,13,15,17,19,21,23,25,27,29)
);
List<Integer> result =
  list.parallelStream().filter(x -> isPrime(x)).collect(Collectors.toList());

```

#### Reduce
![[SequentialReduce.png|400]]
![[ParallelisingReduce.png|400]]

Parallelising Reduce
> `<U> U reduce(U ε, BiFunction<U,? super T,U> acc, BinaryOperator<U> ⊕)`
> 
> Let's call `ε` as `identity`, `acc` as `accumulator`, and `⊕` as `combiner`

-   `combiner.apply(identity, i)` must be equal to `i`
-   The `combiner` and the `accumulator` must be _associative_
-   The `combiner` and the `accumulator` must be _compatible_

