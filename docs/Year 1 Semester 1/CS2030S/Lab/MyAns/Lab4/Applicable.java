/**
 * The Applicable interface that can probably
 * transform if given something that is
 * probably an Immutator.
 * <p>
 * Contains a single abstract method apply.
 * </p>
 * CS2030S Lab 4
 * AY22/23 Semester 1
 *
 * @author Put Your Name (Lab Group)
 */
public interface Applicable<T> {
  public <R> Probably<R> apply(Probably<? extends Immutator<? extends R, ? super T>> a);
}