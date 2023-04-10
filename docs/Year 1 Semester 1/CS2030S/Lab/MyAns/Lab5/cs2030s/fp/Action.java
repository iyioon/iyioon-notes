package cs2030s.fp;

/**
 * The Action interface that can be called
 * on an object of type T to act.
 * <p>
 * Contains a single abstract method call.
 * </p>
 * CS2030S Lab 4
 * AY22/23 Semester 1
 *
 * @author Put Your Name (Lab Group)
 */
public interface Action<T> {
  public void call(T o);
}
