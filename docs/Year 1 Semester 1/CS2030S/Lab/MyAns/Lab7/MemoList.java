import cs2030s.fp.Combiner;
import cs2030s.fp.Constant;
import cs2030s.fp.Immutator;
import cs2030s.fp.Memo;
import java.util.ArrayList;
import java.util.List;

/**
 * A wrapper around a lazily evaluated and memoized
 * list that can be generated with a lambda expression.
 *
 * @author Adi Yoga S. Prabawa
 * @version CS2030S AY 22/23 Sem 1
 */
class MemoList<T> {
  /** The wrapped java.util.List object */
  private List<Memo<? extends T>> list;

  /**
   * A private constructor to initialize the list to the given one.
   *
   * @param list The given java.util.List to wrap around.
   */
  private MemoList(List<Memo<? extends T>> list) {
    this.list = list;
  }

  /**
   * Generate the content of the list. Given x and a lambda f,
   * generate the list of n elements as [x, f(x), f(f(x)), f(f(f(x))),
   * ... ]
   *
   * @param <T>  The type of the elements in the list.
   * @param n    The number of elements.
   * @param seed The first element.
   * @param f    The immutator function on the elements.
   * @return The created list.
   */
  public static <T> MemoList<T> generate(int n, T seed, Immutator<? extends T, ? super T> f) {
    MemoList<T> memoList = new MemoList<>(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        memoList.list.add(Memo.from(seed));
      } else {
        int location = i - 1;
        memoList.list.add(Memo.from(() -> f.invoke(memoList.get(location))));
      }
    }
    return memoList;
  }

  /**
   * Overload generate method to accomdate two elements.
   * 
   * @param <T> The type of the elements in the list.
   * @param n   The number of elements in the list.
   * @param fst The first element in the list.
   * @param snd The second element in the list.
   * @param f   A combiner.
   * 
   * @return a new MemoList generated as:
   *         let fst = x and snd = y
   *         the result is [x, y, f(x, y), f(y, f(x, y)), f(f(x, y), f(y, f(x,
   *         y))), ...]
   */
  public static <T> MemoList<T> generate(
      int n, T fst, T snd, Combiner<? extends T, ? super T, ? super T> f) {
    MemoList<T> memoList = new MemoList<>(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      if (i == 0) {
        memoList.list.add(Memo.from(fst));
      } else if (i == 1) {
        memoList.list.add(Memo.from(snd));
      } else {
        int first = i - 2;
        int second = i - 1;
        memoList.list.add(Memo.from(() -> f.combine(memoList.get(first), memoList.get(second))));
      }
    }
    return memoList;
  }

  /**
   * The map method (lazily) applies the given Immutator on each element in the
   * list and returns the resulting MemoList.
   * 
   * @param <R> Type of MemoList.
   * @param im  A function that immutate one value into another, possible of
   *            different types.
   * @return Returns the resulting MemoList.
   */
  public <R> MemoList<R> map(Immutator<? extends R, ? super T> im) {
    MemoList<R> memoList = new MemoList<>(new ArrayList<>());
    for (int i = 0; i < this.list.size(); i++) {
      int index = i;
      memoList.list.add(Memo.from(() -> im.invoke(this.get(index))));
    }
    return memoList;
  }

  /**
   * The flatMap will flatten a nested list.
   * 
   * @param <R> Type of MemoList.
   * @param im  Immutaor that returns a MemoList.
   * @return Flattened list.
   */
  public <R> MemoList<R> flatMap(Immutator<? extends MemoList<R>, ? super T> im) {
    MemoList<R> memoList = new MemoList<>(new ArrayList<>());
    for (int i = 0; i < this.list.size(); i++) {
      MemoList<R> secondList = im.invoke(this.get(i));
      for (int k = 0; k < secondList.list.size(); k++) {
        memoList.list.add(secondList.list.get(k));
      }
    }
    return memoList;
  }

  /**
   * Return the element at index i of the list.
   *
   * @param i The index of the element to retrieved (0 for the 1st element).
   * @return The element at index i.
   */
  public T get(int i) {
    return this.list.get(i).get();
  }

  /**
   * Find the index of a given element.
   *
   * @param v The value of the element to look for.
   * @return The index of the element in the list. -1 is element is not in the
   *         list.
   */
  public int indexOf(T v) {
    for (int i = 0; i < list.size(); i++) {
      T curr = this.get(i);
      if (curr == v) {
        return i;
      }
    }
    return -1;
    // return this.list.indexOf(v);
  }

  /**
   * Return the string representation of the list.
   *
   * @return The string representation of the list.
   */
  @Override
  public String toString() {
    return this.list.toString();
  }
}
