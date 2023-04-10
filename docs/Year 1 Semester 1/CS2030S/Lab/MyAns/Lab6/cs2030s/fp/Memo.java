package cs2030s.fp;

/**
 * Class to encapsulate a value.
 */
public class Memo<T> extends Lazy<T> {
  /** Actually to store the value. */
  private Actually<T> value;

  /**
   * Constructor for Memo.
   * 
   * @param c Constant that produces the value when needed.
   */
  protected Memo(Constant<? extends T> c) {
    super(c);
  }

  /**
   * Method that initializes the Memo object with the given value.
   * 
   * @param v   Value.
   * @param <T> Type of the value.
   * @return Memo Return new Memo.
   */
  public static <T> Memo<T> from(T v) {
    Memo<T> memo = new Memo<>(() -> v);
    memo.value = Actually.ok(v);
    return memo;
  }

  /**
   * Method that takes in a constant that produces
   * the value when needed.
   * 
   * @param c   Constant that produces the value when needed.
   * @param <T> Type of the Constant.
   * @return Memo Return new Memo.
   */
  public static <T> Memo<T> from(Constant<? extends T> c) {
    return new Memo<T>(c);
  }

  /**
   * Method that is called when the value is needed.
   * 
   * @return T If the value is already available, return that value; otherwise,
   *         compute the value and return it. The computation should only be done
   *         once for the same value.
   */
  @Override
  public T get() {
    Actually<T> res = (Actually<T>) Actually.ok(this.value)
        .transform(v -> v.except(() -> super.get()));
    T res2 = res.except(() -> super.get());
    this.value = Actually.ok(res2);
    return res2;
  }

  /**
   * Method that returns the string representation of the value.
   * 
   * @return String Returns "?" if the value is not yet available; returns the
   *         string representation of the value otherwise.
   */
  @Override
  public String toString() {
    Actually<String> res = (Actually<String>) Actually.ok(this.value)
        .transform(v -> v.except(() -> super.get()).toString());
    String res2 = res.except(() -> "?");
    return res2;
  }

  /**
   * Override transform from Immutatorable.
   * 
   * @param <R> The return type of the Immutator.
   * @param f   Immutator.
   * @return Memo.
   */
  @Override
  public <R> Memo<R> transform(Immutator<? extends R, ? super T> f) {
    return Memo.<R>from(() -> f.invoke(this.get()));
  }

  /**
   * Next method that takes in Immutator and returns new Memo.
   * 
   * @param <R> Immutator return a type Memo.
   * @param i   Immutator.
   * @return Memo.
   */
  @Override
  public <R> Memo<R> next(Immutator<? extends Lazy<? extends R>, ? super T> i) {
    return Memo.<R>from(() -> i.invoke(this.get()).get());
  }

  /**
   * Method takes in another Memo object and a Combiner implementation to lazily
   * combine the two Memo objects (which may contain values of different types)
   * and return a new Memo object.
   * 
   * @param <R> Return type of Memo.
   * @param <S> Type of Memo.
   * @param m   Memo.
   * @param c   Combiner.
   * @return Memo.
   */
  public <R, S> Memo<R> combine(Memo<S> m,
      Combiner<? extends R, ? super T, ? super S> c) {
    return Memo.<R>from(() -> c.combine(this.get(), m.get()));
  }
}