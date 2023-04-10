/**
 * The Array for CS2030S.
 *
 * @author XXX.
 * @version CS2030S AY21/22 Semester 2.
 */
class Array<T extends Comparable<T>> {

  private T[] array;

  Array(int size) {
    // The only way we can put an object into array is through
    // the method set() and we only put object of type T inside.
    // So it is safe.
    @SuppressWarnings({ "unchecked", "rawtypes" })
    T[] tmp = (T[]) new Comparable[size];
    this.array = tmp;
  }

  public void set(int index, T item) {
    this.array[index] = item;
  }

  public T get(int index) {
    return this.array[index];
  }

  public T min() {
    // But, assume that there will always be a element.
    if (array.length == 0) {
      return null;
    } else {
      T min = array[0];
      for (int i = 0; i < array.length; i++) {
        if (array[i].compareTo(min) < 0) {
          min = array[i];
        }
      }
      return min;
    }
  }

  public int length() {
    return array.length;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder("[ ");
    for (int i = 0; i < array.length; i++) {
      s.append(i + ":" + array[i]);
      if (i != array.length - 1) {
        s.append(", ");
      }
    }
    return s.append(" ]").toString();
  }
}
