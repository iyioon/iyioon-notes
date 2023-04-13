package cs2030s.fp;

public abstract class Actually<T> implements Immutatorable<T> {
  static class Success<T> extends Actually<T> {
    // May be null.
    private final T val;

    private Success(T val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "<" + this.val + ">";
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Success<?>) {
        Success<?> temp = (Success<?>) o;
        if (temp.val == null && this.val == null) {
          return true;
        } else if (o == null || this.val == null) {
          return false;
        }
        if (this.val.equals(temp.val)) {
          return true;
        }
      }
      return false;
    }

    @Override
    public T unwrap() {
      return this.val;
    }

    @Override
    public T except(Constant<? extends T> constant) {
      return this.val;
    }

    @Override
    public void finish(Action<? super T> action) {
      action.call(this.val);
    }

    @Override
    public <U extends T> T unless(U unless) {
      return this.val;
    }

    @Override
    public <R> Actually<R> transform(Immutator<? extends R, ? super T> i) {
      try {
        return new Success<R>(i.invoke(this.val));
      } catch (Exception e) {
        return Actually.<R>err(e);
      }
    }

    @Override
    public <R> Actually<R> next(Immutator<? extends Actually<? extends R>, ? super T> i) {
      try {
        @SuppressWarnings("unchecked")
        Actually<R> res = (Actually<R>) i.invoke(this.val);
        return res;
      } catch (Exception e) {
        return Actually.<R>err(e);
      }
    }
  }

  static class Failure extends Actually<Object> {
    // Will never be null as failure is always
    // accompanied with an exception.
    private final Exception exc;

    private Failure(Exception exc) {
      this.exc = exc;
    }

    @Override
    public String toString() {
      return "[" + this.exc.getClass().getName() + "]"
          + " " + this.exc.getMessage();
    }

    @Override
    public boolean equals(Object o) {
      if (o instanceof Failure) {
        Failure temp = (Failure) o;
        if (this.exc.getMessage() == null
            || temp.exc.getMessage() == null) {
          return false;
        }
        if (this.exc.getMessage()
            .equals(temp.exc.getMessage())) {
          return true;
        }
      }
      return false;
    }

    @Override
    public Object unwrap() throws Exception {
      throw this.exc;
    }

    @Override
    public Object except(Constant<?> constant) {
      return constant.init();
    }

    @Override
    public void finish(Action<Object> action) {
    }

    @Override
    public <U extends Object> Object unless(U unless) {
      return unless;
    }

    @Override
    public <R> Actually<R> transform(Immutator<? extends R, ? super Object> i) {
      return Actually.<R>err(this.exc);
    }

    @Override
    public <R> Actually<R> next(Immutator<? extends Actually<? extends R>, ? super Object> i) {
      return Actually.<R>err(this.exc);
    }
  }

  public static <T> Actually<T> ok(T res) {
    return new Success<T>(res);
  }

  @SuppressWarnings("unchecked")
  public static <T> Actually<T> err(Exception exc) {
    return (Actually<T>) new Failure(exc);
  }

  public abstract T unwrap() throws Exception;

  public abstract T except(Constant<? extends T> constant);

  public abstract void finish(Action<? super T> action);

  public abstract <U extends T> T unless(U unless);

  public abstract <R> Actually<R> next(Immutator<? extends Actually<? extends R>, ? super T> i);
}