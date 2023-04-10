# <font style="color:#3258a8">Lecture 2 Intro to OOP</font>

## Tell, Don't Ask

The mutators and accessors above are pretty pointless. If we need to know the internal and do something with it, then we are breaking the abstraction barrier. The right approach is to implement a method within the class that does whatever we want the class to do.

The principle around which we can think about this is the "Tell, Don't Ask" principle. The client should tell a `Circle` object what to do (compute the circumference), instead of asking "what is your radius?" to get the value of a field then perform the computation on the object's behalf.

## Sharing References (aka Aliasing)

Recall that unlike primitive types, reference types may share the same reference values. This is called _aliasing_.

## Heap and Stack

The _heap_ is the region in memory where all objects are allocated in and stored, while the _stack_ is the region where all variables (including primitive types and object references) are allocated in and stored.

![[Lecture 2 Intro to OOP Stack and Heap.png|700]]

````col
```col-md
flexGrow=1
===
![[2 OOP Stack and heap.png|500]]
```
```col-md
flexGrow=1
===
![[2 OOP Stack and Heap Solution.png]]
```
````

## Composition

```java
class ColoredCircle {
  private Circle circle;
  private Color color;

  public ColoredCircle(Circle circle, Color color) {
    this.circle = circle;
    this.color = color;
  }

  public double getArea() {
    return circle.getArea();
  }
}
```

## Inheritance

```java
class ColoredCircle extends Circle {
  private Color color;

  public ColoredCircle(Point center, double radius, Color color) {
    super(center, radius);  // call the parent's constructor
    this.color = color;
  }
}
```
