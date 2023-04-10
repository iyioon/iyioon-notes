# Binary Search

## Complexity

**Big-O Notation**: $T(\mathrm{n})=\mathrm{O}(f(n))$ if $T$ grows no faster than $f$

$T(n)=\mathrm{O}(f(n)) \text { if: }$

- there exists a constant $c>0$
- there exists a constant $n_0>0$

such that for all $n>n_0$ :
$T(n) \leq c f(n)$

**Omega Notation**: $T(n)=\Omega(f(n))$ if $T$ grows no slower than $\mathrm{f}$

$T(n)=\Omega(f(n)) \text { if: }$

- there exists a constant $c>0$
- there exists a constant $n_0>0$ such that for all $n>n_0$ :

$T(n) \geq c f(n)$

**Theta Notation**: $T(n)=\Theta(f(n))$ if $T$ grows at the same rate as $\mathrm{f}$

$T(n)=\Theta(f(n)) \text { if and only if: }$

- $T(n)=\mathrm{O}(f(n)) \text { and }$
- $T(n)=\Omega(f(n))$


### Rules

| Notation                                         | Example                                                                                                                                                                    |
| ------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| $T(n)=\mathrm{O}\left(n^k\right)$                | $10 n^5+50 n^3+10 n+17=\mathrm{O}\left(n^5\right)$                                                                                                                         |
| $T(n)+S(n)=O(f(n)+g(n))$                         | $10 n^2=\mathrm{O}\left(n^2\right)$<br>$5 n \log (n)=\mathrm{O}(n \log (n))$<br>$10 n^2+5 n \log (n)=\mathrm{O}\left(n^2+n \log (n)\right)=\mathrm{O}\left(n^2\right)$<br> |
| $T(n) * S(n)=\mathrm{O}\left(f(n)^* g(n)\right)$ | $10 n^2=\mathrm{O}\left(n^2\right)$<br>$5 n=\mathrm{O}(n)$<br>$\left(10 n^2\right)(5 n)=50 n^3=\mathrm{O}\left(n^* n^2\right)=\mathrm{O}\left(n^3\right)$                                                                                                                                                                           |

Difficult Example: $\log (n !)= O(n \log n)$

## Algorithm Analysis

![[03.Searching.pdf#page=46]]

## Binary Search

Given a sorted array $A$, search for $k$ in array $A$.

### Using recursion

```java
public static int binarySearch(int[] array, int target, int low, int high) {
    if (low > high) {
        return -1;
    }
    int mid = (low + high) / 2;
    if (array[mid] == target) {
        return mid;
    }
    if (array[mid] > target) {
        return binarySearch(array, target, low, mid - 1);
    } else {
        return binarySearch(array, target, mid + 1, high);
    }
}
```

### Using iterative method

```java
public static int binarySearch(int[] array, int target) {
    int low = 0;
    int high = array.length - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}
```

## Precondition and Postcondition

Precondition:

- Fact that is true when the function begins.
- Usually important for it to work correctly.

Postcondition:

- Fact that is true when the function ends.
- Usually useful to show that the computation was done correctly.

## Invariants

Invariant:

- relationship between variables that is always true.

Loop Invariant:

- relationship between variables that is true at the beginning (or end) of each iteration of a loop.