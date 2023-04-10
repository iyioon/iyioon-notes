# <font style="color:#3258a8">Lecture 5 Generic</font>
---

## Declaring a Generic Type

```java
class Pair<S,T> {
  private S first;
  private T second;

  public Pair(S first, T second) {
      this.first = first;
      this.second = second;
  }

  S getFirst() {
      return this.first;
  }

  T getSecond() {
      return this.second;
  }
}
```

We declare a generic type by specifying its type parameters between `<` and `>` when we declare the type. By convention, we use a single capital letter to name each type parameter. These type parameters are scoped within the definition of the type. In the example above, we have a generic class `Pair<S,T>` (read "pair of S and T") with `S` and `T` as type parameters. We use `S` and `T` as the type of the fields `first` and `second`. We ensure that `getFirst()` returns type `S` and `getSecond()` returns type `T`, so that the compiler will give an error if we mix up the types.

Note that the constructor is still declared as `Pair` (without the type parameters).

## Using / Instanting a Generic Type

To use a generic type, we have to pass in _type arguments_, which itself can be a non-generic type, a generic type, or another type parameter that has been declared. Once a generic type is instantiated, it is called a _parameterized type_.

To avoid potential human errors leading to `ClassCastException` in the example above, we can use the generic version of `Pair` as follows, taking in two non-generic types:

```java
Pair<String,Integer> foo() {
  return new Pair<String,Integer>("hello", 4);
}

Pair<String,Integer> p = foo();
Integer i = (Integer) p.getFirst(); // compile-time error
```

With the parameterized type `Pair<String,Integer>`, the return type of `getFirst` is bound to `String`, and the compiler now have enough type information to check and give us an error since we try to cast a `String` to an `Integer`.

Note that we use `Integer` instead of `int`, since _only reference types_ can be used as type arguments.

Just like you can pass a parameter of a method to another method, we can pass the type parameter of a generic type to another:

```java
class DictEntry<T> extends Pair<String,T> {
     :
}
```

We define a generic class called `DictEntry<T>` with a single type parameter `T` that extends from `Pair<String,T>`, where `String` is the first type argument (in place of `S`), while the type parameter `T` from `DictEntry<T>` is passed as the type argument for `T` of `Pair<String,T>`.

## Generic Methods

Methods can be parameterized with a type parameter as well. Consider the `contains` method, which we now put within a class for clarity.

```java
class A {
    // version 0.1 (with polymorphism)
    public static boolean contains(Object[] array, Object obj) {
      for (Object curr : array) {
        if (curr.equals(obj)) {
          return true;
        }
      }
      return false;
    }
}
```

While using this method does not involve narrowing type conversion and type casting, it is a little to general -- it allows us to call `contains` in a nonsensical way, like this:

```java
String[] strArray = new String[] { "hello", "world" };
A.contains(strArray, 123);
```

Searching for an integer within an array of strings is a futile attempt! Let's constrain the type of the object to search for to be the same as the type of the array. We can make this type the parameter to this method:

```java
class A {
    // version 0.4 (with generics)
    public static <T> boolean contains(T[] array, T obj) {
      for (T curr : array) {
        if (curr.equals(obj)) {
          return true;
        }
      }
      return false;
    }
}
```

The above shows an example of a _generic method_. The type parameter `T` is declared within `<`and `>` and is added before the return type of the method. This parameter `T` is then scoped within the whole method.

To call a generic method, we need to pass in the type argument placed before the name of the method (Java actually can infer the type using the _type inference_ mechanism and allows us to skip the type argument, but for clarity, we insist on specifying the type explicitly until students get used to the generic types and reasoning about types).  For instance,

```java
String[] strArray = new String[] { "hello", "world" };
A.<String>contains(strArray, 123); // type mismatch error
```

The code above won't compile since the compiler expects the second argument to also be a `String`.

## Bounded Type Parameters

```java
class Pair<S extends Comparable<S>,T> implements Comparable<Pair<S,T>> {
  private S first;
  private T second;

  public Pair(S first, T second) {
      this.first = first;
      this.second = second;
  }

  S getFirst() {
      return this.first;
  }

  T getSecond() {
      return this.second;
  }

  @Override
  public int compareTo(Pair<S,T> s1) {
      return this.first.compareTo(s1.first);
  }

  @Override
  public String toString() {
    return this.first + " " + this.second;
  }
}
```

## How Generic Ensure type safety
Allow classes/methods that use any reference type to be defined without resorting to using the object type. It enforce type safety by binding the generic type to a specific given type argument at compile time. Attempt to pass in an incompatible type would lead to compilation error. 

```java
A<Double> = new A<Integer> // Error because generics is invariant
A<Double> = new B<Double> // Ok if B is a subtype of A. B<T> <: A<T>
```

