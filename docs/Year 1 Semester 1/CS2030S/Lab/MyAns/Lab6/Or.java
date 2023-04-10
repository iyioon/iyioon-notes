import cs2030s.fp.Memo;

class Or implements Cond {
  private Memo<Cond> lVal;
  private Memo<Cond> rVal;

  public Or(Cond lVal, Cond rVal) {
    this.lVal = Memo.from(lVal);
    this.rVal = Memo.from(rVal);
  }

  @Override
  public boolean eval() {
    return this.lVal.get().eval() || this.rVal.get().eval();
  }

  @Override
  public String toString() {
    return "(" + this.lVal + " | " + this.rVal + ")";
  }

  @Override
  public Cond neg() {
    return new And(lVal.get().neg(), rVal.get().neg());
  }
}