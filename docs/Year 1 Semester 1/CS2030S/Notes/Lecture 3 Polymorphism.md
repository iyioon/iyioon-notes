# <font style="color:#3258a8">Lecture 3 Polymorphism</font>
---

## Abstract class & Method

```java
abstract class Shape { // Cannot instantiate
  private int v;
  public Shape(int v) { //constructor exist because the subclass can use it
    this.v = v;
  }
  public int getV () {
    return this.v;
  }
  abstract public double getArea(); //abstract method is a method without an implementation. //So if circle extends Shape, circle can overide this function.
}`
```

## Final class

```java
public final class Point { // Point cannot be inherited from
  private final double x;  // x is immutable. 
  private final double y;    //   - i.e., set once and never again
	public Point(){
		x = 1; //works until here
	}
  @Override
  public final String toString() { // cannot be overridden in subclass
    return "(" + this.x + ", " + this.y + ")";
  }
}
```

## Method overriding

> When a subclass defines an instance method with the same method descriptor. Can return subtype

## Method overloading

> Two or more methods in the same class with the same name but a different method signature.

## Dynamic binding

1.  Identify the compile-time type T of obj
2.  Check the class T and the superclasses of T for all accessible methods called foo
    1.  The method must have an implementation and be able to take the argument arg
3.  Select the method with most specific method signature
    1.  If there is No accessible methods or there is an ambiguity, stop with Compile Error
4.  Store this method descriptor in the generated ByteCode.

**Step 2: Run-Time :Decide during run time. It is guaranteed because step 1 is passed**

1.  Retrieve the method descriptor from step 1
2.  Determine the run-time type of T of the target of invocation obj
3.  Select the nearest method with matching signature in the class hierarchy - Same method signature found in Step 1

## Liskov Substitution Principle

Existing code that has been written to invoke A's copy would no longer work if the code invokes B's copy instead after B inherits from A

```java
class A {
	void f(A a1, A a2){
	}
}

class B extends A {
	@Override
	void f(B b1, B b2){
	}
}
```

The code violates LSP. Consider the code

```java
void g(A a){
	a.foo(new A(),new A())
}
```
which works with `A`, but when an instance of `B` is passed into `g`, it would not work, since we are now passing `A` as `B` into `foo`.
