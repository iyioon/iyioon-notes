/**
 * A non-generic Action to print the String
 * representation of the object.
 * <p> 
 * CS2030S Lab 4
 * AY22/23 Semester 1
 * </p>
 * @author Put Your Name (Lab Group)
 */
class Print implements Action<Object> {
  @Override
  public void call(Object o) {
    System.out.println(o.toString());
  }
}
