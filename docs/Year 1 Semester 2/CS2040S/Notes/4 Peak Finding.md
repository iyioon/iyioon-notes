# Peak Finding

``` java
FindPeak(A,n)
	if A[n/2 + 1] > A[n/2] then
		FindPeak (A[n/2 + 1 . . n], n/2)
	else if A[n/2 - 1] > A[n/2] then
		FindPeak (A[1 . . n/2 - 1], n/2)
	else A[n/2] is a peak; return n/2
```

## Key Invariants

1. There exists a peak in the range `[begin,end]`
2. Every peak in `[begin,end]` is a peak in `[1,n]`

## Running Time

![[04.PeakFinding.pdf#page=68]]
