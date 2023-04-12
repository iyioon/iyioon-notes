<span class="right-menu">My Solution to <br>[Week 4 Tutorial 2](CS2040_tut02.pdf)</span>

## Problem 1. Time Complexity Analysis

Analyze the following code snippets and find the best asymptotic bound for the time complexity of the following functions with respect to $n$.

(a) $O(n)$

```java
public int niceFunction(int n) {
  for (int i = 0; i < n; i++) {
    System.out.println("I am nice!");
  }
  return 42;
}
```

(b) $O(n)$

```java
public int meanFunction(int n) {
  if (n == 0) return 0;
  return 2 * meanFunction(n / 2) + niceFunction(n);
}
```

(c) $O(n^2)$

```java
public int strangerFunction(int n) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < i; j++) {
      System.out.println("Execute order?");

    }
  }
  return 66;
}
```

(d) $O(n\log n)$

```java
public int suspiciousFunction(int n) {
  if (n == 0) return 2040;
  int a = suspiciousFunction(n / 2);
  int b = suspiciousFunction(n / 2);
  return a + b + niceFunction(n);
}
```

(e) $O(2^n)$

```java
public int badFunction(int n) {
    if (n <= 0) return 2040;
    if (n == 1) return 2040;
    return badFunction(n - 1) + badFunction(n - 2) + 0;
}
```

(f) $O(n\log n)$

```java
public int metalGearFunction(int n) {
  for (int i = 0; i < n; i++) {
    for (int j = 1; j < i; j *= 2) {
      System.out.println("!");
    }
  }
  return 0;
}
```

(g) $O(n)$

```java
public String simpleFunction(int n) {
  String s = "";
  for (int i = 0; i < n; i++) {
    s += "?";
  }
  return s;
}
```

## Sorting Review

(a) How would you implement insertion sort recursively? Analyse the time complexity by formulating a recurrence relation.

```java
void insertionSortRecursive(int arr[], int n)
{
	// Base case
	if (n <= 1)
		return;

	// Sort first n-1 elements
	insertionSortRecursive( arr, n-1 );

	// Insert last element at its correct position
	// in sorted array.
	int last = arr[n-1];
	int j = n-2;

	/* Move elements of arr[0..i-1], that are
	greater than key, to one position ahead
	of their current position */
	while (j >= 0 && arr[j] > last)
	{
		arr[j+1] = arr[j];
		j--;
	}
	arr[j+1] = last;
}
```

Complexity $O(n^2)$

(b) Consider an array of pairs $(a, b)$. Your goal is to sort them by $a$ in ascending order. If there are any ties, we break them by sorting $b$ in ascending order. For example, $[(2,1),(1,4),(1$, $3)$ ] should be sorted into $[(1,3),(1,4),(2,1)]$.

You are given 2 sorting functions, which are a MergeSort and a SelectionSort. You can use each sort at most once. How would you sort the pairs? Assume you can only sort by one field at a time.

Use selection sort on $b$ and merge sort on $a$. Sort for $a$ must be stable to maintain the order of $b$

(c) We have learned how to implement MergeSort recursively. How would you implement MergeSort iteratively? Analyse the time and space complexity.

Do it bottom up


