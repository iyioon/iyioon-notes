# Heaps

## Basics

Visit [[12.TreesandHeaps.pdf#page=112]]

### Orders

**Maximum height**: floor($\log n$)

## Heap Operations

### Insert

- Step one: add a new leaf 
- Bubble up

Note that bubble up method also works with increase key

Visit [[12.TreesandHeaps.pdf#page=125]]

### Delete

- Swap the element with the last element
- Remove the last element
- Bubble down (left)

### Store Tree in an Array

Visit [[12.TreesandHeaps.pdf#page=160]]

**Unsorted list -> Sorted**

- Step 1: build a heap
- Step 2: Turn the heap to a stored list
	- Extract the max item and put it at the end of the array

$n\log n$ cost operation