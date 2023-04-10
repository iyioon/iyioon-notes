package cs2030s.fp;

/**
 * The Actionable interface that can
 * act when given an action.
 * <p>
 * Contains a single abstract method act.
 * </p>
 * CS2030S Lab 4
 * AY22/23 Semester 1
 *
 * @author Put Your Name (Lab Group)
 */

public interface Actionable<T> {
  public void act(Action<? super T> action);
}
