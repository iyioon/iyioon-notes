<span class="right-menu">My Solution to <br>[Week 3 Tutorial 1](CS2040_tut01.pdf)</span>

## Problem 1 Java Review

### (a) What is the difference between a class and an object? Illustrate with an example.

In Java, a class is a blueprint for creating objects, providing initial values for state (member variables or attributes), and implementations of behavior (member functions or methods). An object is an instance of a class and it contains the state and behavior defined in the class.

### (b)  Why does the main method come with a static modifier?

As soon as the Java runtime begins, there are no objects of the class present. The `main()` method must be static for the JVM to be able to load the class into memory and call the main function. JVM won't be able to call the main method if it's not static because the class's object isn't present.

### (c)  Give an example class (or classes) that uses the modifier private incorrectly (i.e., the program will not compile as it is, but would compile if private was changed to public)

```java
public class example1 {
	private int x = 1; 
}
```

```java
public class example2 {
	private example1 object = new example();
	private int val = object.x; // error 
}
```

### (d)  The following question is about Interfaces.

#### (d)(i) Why do we use interfaces?

Java interfaces are used to specify the set of methods that a class is required to implement. Interfaces are used to provide a common set of behaviors for different classes.

#### (d)(ii) Give an example of using an interface.

```java
interface GetAreable { 
	public abstract double getArea(); 
}
```

```java
public class Square {
	private int x = 10;

	@Override 
	public double getArea() {
		return this.x*this.x;
	}
}
```

#### (d)(iii) Can a method return an interface?

Yes, but the run time type of the object returned will be a subtype of the interface since interface cannot be instantiated.

#### (e)  Refer to IntegerExamination.java, which can be found in the same folder as this PDF. Without running the code, predict the output of the main method. Can you explain the outputs?

```
I am in addOne. The value of i is 8
I am in myIntAddOne. The value of j is 8
I am in myOtherIntAddOne. The value of k is 8
The final value of i back in main is 7
The final value of j back in main is 8
The final value of k back in main is 7
```

#### (f)  Can a variable in a parameter list for a method have the same name as a member (or static) variable in the class? If yes, how is the conflict of names resolved?

When a method is called, the values of the arguments passed to the method are assigned to the variables in the parameter list. If a variable in the parameter list has the same name as a member (or static) variable, the value of the member variable will be hidden by the value of the parameter variable within the scope of the method. The variable in the class can be accessed with `this` keyword.

## Problem 2 Asymptotic Analysis

This is a good time for a quick review of asymptotic big-O notation. For each of the expressions below, what is the best (i.e. tightest) asymptotic upper bound (in terms of n)?

(a) $f_1(n)=7.2+34 n^3+3254 n$
$O(n^3)$

(b) $f_2(n)=n^2 \log n+25 n \log ^2 n$
$O(n^2 \log n)$

(c) $f_3(n)=2^{4 \log n}+5 n^5$
$O(n^5)$

(d) $f_4(n)=2^{2 n^2+4 n+7}$
$O(2^{2n^2+4n})$ 

## Problem 3 More Asymptotic Analysis!

Let $f$ and $g$ be functions of $n$ where $f(n)=O(n)$ and $g(n)=O(\log n)$. Find the best asymptotic bound (if possible) of the following functions.

(a) $h_1(n)=f(n)+g(n)$
$O(n)$

(b) $h_2(n)=f(n) \times g(n)$
$O(n \log n)$

(c) $h_3(n)=\max (f(n), g(n))$
$O(n)$

(d) $h_4(n)=f(g(n))$
$O(\log n)$

(e) $h_5(n)=f(n)^{g(n)}$
The constant matters. Hence the problem cant be solved.

## Problem 4 Application of Binary Search

Given a sorted array of $n-1$ unique integers in the range $[1, n]$, how would you find the missing element? Discuss possible naive solutions and possibly faster solutions.

1.  Naive solution using a for loop:
   We can iterate through the array using a for loop and compare each element with the expected value (i.e. the current index + 1). Time complexity: $O(n)$.

2. Using Binary search:
   We can use binary search to find the missing element. We start by finding the middle element of the array and compare it with the middle element of the range $[1, n]$. If the middle element of the array is less than the middle element of the range, the missing element must be in the right half of the array. If the middle element of the array is greater than the middle element of the range, the missing element must be in the left half of the array. We continue the search in the half that the missing element could be in, until we find it. Time complexity: $O(\log n)$.
   
## Problem 5. Another Application of Binary Search

1.  Start by setting the lower bound k_min = 0 and upper bound k_max = sum of all the piles of homework.
2.  In each iteration, calculate the mid value of k_min and k_max and check if it is a valid k that allows you to complete all piles of homework within h hours.
3.  To check if k is a valid value, you can iterate through the piles of homework and check how many hours it would take to finish that pile with the current value of k. You can keep a running total of the hours and if that exceeds h hours, k is not a valid value.
4.  If k is a valid value, update k_max to mid-1, otherwise update k_min to mid+1.
5.  Repeat steps 2-4 until k_min is greater than or equal to k_max.
6.  The final value of k_min will be the minimum integer k that allows you to complete all your homework within h hours.

## Problem 6. Yet Another Application of Binary Search

(Optional) Given an array of $n$ $x$ and $y$-coordinates of an $n$-sided convex polygon in clockwise order, find a bounding box around the polygon. Discuss possible naive solutions and possibly faster solutions. A convex polygon is a polygon where all interior angles are less than 180 degrees.

- Use peak finding.