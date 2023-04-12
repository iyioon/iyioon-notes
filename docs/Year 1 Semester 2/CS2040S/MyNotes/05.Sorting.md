# Sorting


## Bubble Sort

``` java
BubbleSort(A, n)
	repeat (until no swaps): 
		for j = 1 to n-1
			if A[j] > A[j+1] then swap(A[j], A[j+1])
```

Best: $O(n)$
Average & Worst: $O(n^2)$
Stable

## Selection Sort

```java
SelectionSort(A, n)
	for j = 1 to n-1:  
		find minimum element A[j] in A[j..n] 
		swap(A[j], A[k])
```

Best & Worst & Average: $O(n^2)$
Not stable

## Insertion Sort

```java
InsertionSort(A, n)
	for j = 2 to n 
		key = A[j]
		i = j-1  
		while (i > 0) and (A[i] > key)
			A[i+1] = A[i]
			i = i-1 
		A[i+1] = key
```

Best: $O(n)$
Worst & Average: $O(n^2)$
Stable

## Merge Sort

Best & Worst, Average: $O(n\log n)$
Stable
## Quick Sort

Best, Average: $O(n\log n)$
Worst: $O(n^2)$
Not stable