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