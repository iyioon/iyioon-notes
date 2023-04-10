package cs2030s.fp;

public abstract class Transformer<R, P> implements Immutator<R, P> {
  public <N> Transformer<R, N> after(Transformer<? extends P, ? super N> g) {
    // We chain Transformer<R,P> and Transformer<P,N>
    // to form Transformer<R,N>.
    Transformer<R, P> f = this;
    class FAfterG extends Transformer<R, N> {
      @Override
      public R invoke(N p) {
        return f.invoke(g.invoke(p));
      }
    }

    return new FAfterG();
  }

  public <T> Transformer<T, P> before(Transformer<? extends T, ? super R> g) {
    // We chain Transformer<T,R> and Transformer<R,P>
    // to form Transformer<T,P>.
    Transformer<R, P> f = this;
    class FBeforeG extends Transformer<T, P> {
      @Override
      public T invoke(P p) {
        return g.invoke(f.invoke(p));
      }
    }

    return new FBeforeG();
  }
}