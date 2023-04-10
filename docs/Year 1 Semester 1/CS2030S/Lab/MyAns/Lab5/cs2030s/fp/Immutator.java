package cs2030s.fp;

/**
 * The Immutator interface that can transform
 * to type T2, an object of type T1.
 * <p>
 * Contains a single abstract method invoke.
 * </p>
 * CS2030S Lab 4
 * AY22/23 Semester 1
 *
 * @author Put Your Name (Lab Group)
 */
public interface Immutator<R, P> {
  public R invoke(P p);
}