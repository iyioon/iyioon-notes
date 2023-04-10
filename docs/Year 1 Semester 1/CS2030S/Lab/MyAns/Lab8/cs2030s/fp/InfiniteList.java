package cs2030s.fp;

import java.util.ArrayList;
import java.util.List;

/**
 * Class InfiniteList.
 */
public class InfiniteList<T> {
  /** Head of the InfiniteList. */
  private Memo<Actually<T>> head;
  /** Tail of the InfiniteList. */
  private Memo<InfiniteList<T>> tail;

  /**
   * Private constructor for Infinite List.
   * 
   * @param head The head of the Infinite List.
   * @param tail The Tail of the Infinite List.
   */
  private InfiniteList(Memo<Actually<T>> head, Memo<InfiniteList<T>> tail) {
    this.head = head;
    this.tail = tail;
  }

  /**
   * Generate a InfiniteList with a Constant.
   * 
   * @param <T>  Type of the value inside the InfiniteList.
   * @param prod Producer that creates the value.
   * @return A new InfiniteList using a private constructor.
   */
  public static <T> InfiniteList<T> generate(Constant<T> prod) {
    return new InfiniteList<>(
        Memo.from(() -> Actually.ok(prod.init())),
        Memo.from(() -> InfiniteList.generate(prod)));
  }

  /**
   * Generate a InfiniteList through literation.
   * 
   * @param <T>  Type of the value inside the InfiniteList.
   * @param seed Starting value of the InfiniteList.
   * @param func Function applied to the previous value.
   * @return A new InfiniteList using a private constructor.
   */
  public static <T> InfiniteList<T> iterate(T seed, Immutator<T, T> func) {
    return new InfiniteList<>(
        Memo.from(Actually.ok(seed)),
        Memo.from(() -> InfiniteList.iterate(func.invoke(seed), func)));
  }

  /**
   * Returns the head.
   * 
   * @return the current head if Actually is not err. Else recurse the method on
   *         the head of the current tail.
   */
  public T head() {
    return this.head.get().except(() -> this.tail.get().head());
  }

  /**
   * Returns the tail of the infinite list.
   * 
   * @return InfiniteList.
   */
  public InfiniteList<T> tail() {
    return this.head.get()
        .transform(x -> this.tail.get())
        .except(() -> this.tail.get().tail());
  }

  /**
   * The map method (lazily) applies the given Immutator to each element in the
   * list and returns the resulting InfiniteList.
   * 
   * @param <R> Type of the value inside a new InfiniteList.
   * @param f   Funtion applied to the value inside the current InfiniteList.
   * @return A new InfiniteList.
   */
  public <R> InfiniteList<R> map(Immutator<? extends R, ? super T> f) {
    return new InfiniteList<>(
        Memo.from(() -> this.head.get().transform(f)),
        Memo.from(() -> this.tail.get().map(f)));
  }

  /**
   * Method to filter out elements in the list that fail a given
   * Immutator. filter should mark any filtered (i.e., removed or missing) element
   * as Actually.err() instead of null. The resulting (lazily) filtered
   * 
   * @param pred Condition for filter.
   * @return InfiniteList.
   */
  public InfiniteList<T> filter(Immutator<Boolean, ? super T> pred) {
    return new InfiniteList<>(
        Memo.from(() -> this.head.get().check(pred)),
        Memo.from(() -> this.tail.get().filter(pred)));
  }

  /**
   * Method that takes in a value n and truncate the InfiniteList to a finite
   * list with at most n elements.
   * 
   * @param n Number of elements in the InfiniteList.
   * @return A finite List.
   */
  public InfiniteList<T> limit(long n) {
    // If the head is err, do not decrement n.
    return n <= 0 ? InfiniteList.end()
        : new InfiniteList<T>(
            this.head,
            Memo.from(() -> this.tail.get()
                .limit(this.head.get().transform(x -> n - 1).except(() -> n))));
  }

  /**
   * Truncates the list as soon as it finds an element that evaluates the
   * condition to false.
   * 
   * @param pred Condition.
   * @return A new InfiniteList.
   */
  public InfiniteList<T> takeWhile(Immutator<Boolean, ? super T> pred) {
    Memo<Actually<T>> check = Memo.from(() -> Actually.ok(this.head()).check(pred));
    return new InfiniteList<T>(
        Memo.from(() -> check.get()),
        Memo.from(() -> check.get().transform(x -> this.tail().takeWhile(pred))
            .except(() -> InfiniteList.end())));
  }

  /**
   * Method that collects the elements in the InfiniteList into a
   * java.util.List.
   * 
   * @return List.
   */
  public List<T> toList() {
    List<T> result = new ArrayList<T>();
    this.head.get().finish(x -> result.add(x));
    Actually.ok(this.tail.get()).finish(x -> result.addAll(x.toList()));
    return result;
  }

  /**
   * Reduce the InfiniteList.
   * 
   * @param <U> Type of the final value.
   * @param id  Starting value.
   * @param acc Combiner.
   * @return the combined value.
   */
  public <U> U reduce(U id, Combiner<U, U, ? super T> acc) {
    U temp = id;
    id = this.head.get()
        .transform(x -> acc.combine(temp, x)).except(() -> temp);
    return this.tail.get().reduce(id, acc);
  }

  /**
   * Count the heads in the Infinite List.
   * 
   * @return number of elements in the InfiniteList.
   */
  public long count() {
    return this.reduce(0, (a, b) -> a + 1);
  }

  @Override
  public String toString() {
    return "[" + this.head + " " + this.tail + "]";
  }

  /**
   * Method that checks if this is a End.
   * 
   * @return true if the list is an instance of End and returns false
   *         otherwise.
   */
  public boolean isEnd() {
    return this instanceof End;
  }

  /**
   * End method that returns an end.
   * 
   * @param <T> Used to typecast into InfiniteList.
   * @return End.
   */
  @SuppressWarnings("unchecked")
  public static <T> InfiniteList<T> end() {
    return (InfiniteList<T>) new End();
  }

  /**
   * represent a list that contains nothing and is used to mark the end of the
   * list.
   */
  public static class End extends InfiniteList<Object> {
    /**
     * Constructor.
     */
    private End() {
      super(null, null);
    }

    @Override
    public Object head() {
      throw new java.util.NoSuchElementException();
    }

    @Override
    public InfiniteList<Object> tail() {
      throw new java.util.NoSuchElementException();
    }

    @Override
    public <R> InfiniteList<R> map(Immutator<? extends R, ? super Object> f) {
      return super.end();
    }

    @Override
    public InfiniteList<Object> filter(Immutator<Boolean, ? super Object> pred) {
      return super.end();
    }

    @Override
    public InfiniteList<Object> limit(long n) {
      return super.end();
    }

    @Override
    public InfiniteList<Object> takeWhile(Immutator<Boolean, ? super Object> pred) {
      return super.end();
    }

    @Override
    public List<Object> toList() {
      return new ArrayList<>();
    }

    @Override
    public <U> U reduce(U id, Combiner<U, U, ? super Object> acc) {
      return id;
    }

    @Override
    public String toString() {
      return "-";
    }
  }
}
