# Lecture 11 Concurrent & Async

[Lecture Slide](https://www.comp.nus.edu.sg/~adi-yoga/CS2030S/Slides/L11.html#32)
[Website](https://www.comp.nus.edu.sg/~CS2030S/39-async.html)

## Threads


### Concurrent

![c|500](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20Concurrent.png)
### Parallel
![c|500](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20Parallel.png)
### Java Thread

<iframe src="https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html" width=100% height=300></iframe>

**Thread #1
**
```java
Thread thread1 = new Thread( () -> {
  for (int i=0; i<100; i++) {
    System.out.print("*");
  }
});
thread1.start();

```

**Thread #2**

```java
Thread thread2 = new Thread( () -> {
  for (int i=0; i<100; i++) {
    System.out.print("_");
  }
});
thread2.start();

```

#### Interleaving

Run thread 1 to some point of time and then run thread 2

![c|500](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20Interleaving.png)
The line is called contact switching 

### Why do we use thread?

```java
// Assume isPrime(int n) is defined
Thread findPrime = new Thread( () -> {
  System.out.println(
    Stream.iterate(2, i -> i + 1)
          .filter(x -> isPrime(x))
          .limit(500000)
          .reduce((x,y) -> y)
          .orElse(0)
  );
});
findPrime.start();
```

```java
// Find something to do until finished
while(findPrime.isAlive()) {
  try {
    System.out.print(".");
    Thread.sleep(1000); // busy-wait
  } catch(InterruptedException e) {
	  // Occures when the process is stoped while
    System.out.println(
      "who woke me up?!"
    );
  }
}

```

### Drawbacks of Programming with Thread Directly

-   Overhead
    -   Starting, scheduling, _etc_
-   Exception handling?
    -   Where should the exception be handled?
    -   Hard to construct a way to solve this for all possible cases
-   Not easy to pass information around
    -   `Thread` has no return value
-   Single use
    -   Cannot call `.start()` on a completed thread

![c|200](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20Overheads.png)

### Dependency

Example
```java
int foo(int x) {
  int a = taskA(x);
  int b = taskB(a);
  int c = taskC(a);
  int d = taskD(a);
  int e = taskE(b,c);
  return e;
}
```

Dependency
![c|500](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20Dependency%20graph.png)

#### As `Box<T>`

```java
Box<Integer> foo(int x) {
  Box<Integer> a = Box.of(taskA(x));
  Box<Integer> b = a.flatMap(i -> taskB(i));
  Box<Integer> c = a.flatMap(i -> taskC(i));
  Box<Integer> d = a.flatMap(i -> taskD(i));
  Box<Integer> e = b.combine(c, (i, j) -> taskE(i, j));
  return e;
}
```

#### As `Memo<T>`

```java
Memo<Integer> foo(int x) {
  Memo<Integer> a = Memo.of(taskA(x));
  Memo<Integer> b = a.flatMap(i -> taskB(i));
  Memo<Integer> c = a.flatMap(i -> taskC(i));
  Memo<Integer> d = a.flatMap(i -> taskD(i));
  Memo<Integer> e = b.combine(c, (i, j) -> taskE(i, j));
  return e;
}
```

#### As `CompletableFuture<T>`. 

```java
CompletableFuture<Integer> foo(int x) {
  CompletableFuture<Integer> a = CompletableFuture.of(taskA(x));
  CompletableFuture<Integer> b = a.thenComposeAsync(i -> taskB(i));
  CompletableFuture<Integer> c = a.thenComposeAsync(i -> taskC(i));
  CompletableFuture<Integer> d = a.thenComposeAsync(i -> taskD(i));
  CompletableFuture<Integer> e = b.thenCombineAsync(c, (i, j) -> taskE(i, j));
  return e;
}
```

### Completable Future

```java
class WithoutCF {
  public static void main(String[] args) {
    int i = 200_000;
    int j = 100_000;
    int ithPrime =
      findIthPrime(i);
    int jthPrime =
      findIthPrime(j);
    int diff = // This can only run after ithPrime and jthPrime is computed
      ithPrime - jthPrime;
    System.out.println(diff);
  }
}
```

```java 
class WithCF {
  public static void main(String[] args) {
    int i = 200_000;
    int j = 100_000;
    CompletableFuture<Integer> ithPrime =
      CompletableFuture.supplyAsync(() -> findIthPrime(i));
    CompletableFuture<Integer> jthPrime =
      CompletableFuture.supplyAsync(() -> findIthPrime(j));
    CompletableFuture<Integer>  diff =
      ithPrime.thenCombine(jthPrime, (x,y) -> x - y);
    System.out.println(diff.join()); //Getting the value only after the computation finishes. (block)
  }
}
```

#### Advantages

We can perform multi-threading operations without worrying about:

-   order of operations
-   communication between threads

In other words, we can simply talk about computations in terms of _"logical order"_ This is achieved by:

-  Composing/chaining `ComposableFuture`
- `cf1.thenCombine(cf2, op)` will be completed _after_ both `cf1` and `cf2` are completed
- `cf1.join()` requires `cf1` to be _have been_ completed (blocks)

#### Notes

-   `CompletableFuture` is a **monad**
    -   If you can chain monad, you can chain `CompletableFuture`
-   Some methods in `CompletableFuture` returns `CompletionStage` (interface implemented by `CompletableFuture`)
-   We can reduce overhead of thread using `ForkJoinPool` (will be discussed later, but this simply allows threads to be reused when not busy)
    -   This is called a **Thread Pool** (i.e., a collection of threads + a collection of tasks to be executed)
-   We can handle exception using `handle` method


## Fork and Join


### Basic

> A parallel **divide-and-conquer** model of computation
> 
> -   `fork()`: divides a problem
> -   `join()`: combines the result

#### Basically

-   Split the problem into smaller problems
    -   Solve the smaller (simpler) problems
-   Combine the result from the smaller problems to form the result

### Motivational Example

A bad practice
```java
Queue<Runnable> queue = new LinkedList<>();
Thread newThread = new Thread(() -> { // This is called a Thread pool
  while (true) {
    if (!queue.isEmpty()) {
      Runnable r = queue.remove();
      r.run();
    }
  }
});

for (int i = 0; i < 100; i++) {
  int count = i;
  queue.add(() -> System.out.println(count));
}
```

### ForkJoinPool

<iframe src="https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/RecursiveTask.html" width=100%></iframe>

> A thread pool for using `fork`/`join`

-   `fork()`: put it to the _deque_ (behaves like both stack and queue)
-   `join()`: waits until the task finished (blocks)

#### Example
```java
protected Integer compute() {
  if (hIdx - lIdx < FORK_THRESHOLD) {
    return summation(lIdx, hIdx, array);
  }
  int middle = (lIdx + hIdx) / 2;
  Summer lSum = new Summer(lIdx, middle, array);
  Summer rSum = new Summer(middle, hIdx, array);
  lSum.fork();
  return rSum.compute() + lSum.join();
}
```

![c|300](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20ForkJoinPool.png)

#### Order Matters

**More efficient**
```java
lSum.fork();
rSum.fork();
return rSum.join() + lSum.join();
```

**Less Efficient**
```java
lSum.fork();
rSum.fork();
return lSum.join() + rSum.join();
```

![c|300](../Attachment/Lecture%2011%20Concurrent%20&%20Async%20ForkJoinPool%20Order.png)

