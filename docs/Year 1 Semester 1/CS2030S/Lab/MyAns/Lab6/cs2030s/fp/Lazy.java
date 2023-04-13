package cs2030s.fp;

/**
 * Generic class to encapsulate a value.
 */
public class Lazy<T> implements Immutatorable<T> {
  /** Constant that produces the value when needed. */
  private final Constant<? extends T> init;

  /**
   * Constructor for Lazy.
   * 
   * @param c Constant that produces the value when needed.
   */
  protected Lazy(Constant<? extends T> c) {
    this.init = c;
  }

  /**
   * Method that instantiate the Lazy object with the given value
   * using the protected constructor above.
   * 
   * @param v   Value.
   * @param <T> Type of the value.
   * @return Lazy Return new Lazy.
   */
  public static <T> Lazy<T> from(T v) {
    return new Lazy<T>(() -> v);
  }

  /**
   * Method that takes in a constant that produces
   * the value when needed and instantiate the Lazy object.
   * 
   * @param c   Constant that produces the value when needed.
   * @param <T> Type of the Constant.
   * @return Lazy Return new Lazy.
   */
  public static <T> Lazy<T> from(Constant<? extends T> c) {
    return new Lazy<T>(c);
  }

  /**
   * Method that is called when the value is needed.
   * 
   * @return T Compute the value and return.
   */
  public T get() {
    return this.init.init();
  }

  /**
   * Return the string representation of the value.
   * 
   * @return String The string representation of the value.
   */
  @Override
  public String toString() {
    return get().toString();
  }

  /**
   * Override transform from Immutatorable.
   * 
   * @param <R> The return type of the Immutator.
   * @param f   Immutator.
   * @return Lazy.
   */
  @Override
  public <R> Lazy<R> transform(Immutator<? extends R, ? super T> f) {
    return Lazy.<R>from(() -> f.invoke(this.get()));
  }

  /**
   * Next method that takes in Immutator and returns new Lazy.
   * 
   * @param <R> Immutator return a type Lazy.
   * @param i   Immutator.
   * @return Lazy.
   */
  public <R> Lazy<R> next(Immutator<? extends Lazy<? extends R>, ? super T> i) {
    return Lazy.<R>from(() -> i.invoke(this.get()).get());
  }
}