public class Counters {
  /**
   * List of counters 
   */
  private Counter[] counters;
   /** 
   * Constructor for Counters
   * Create a list of counters with size
   * numOfCounters, where all counters
   * are set to available 
   */
  public Counters(int numOfCounters){
    this.counters = new Counter[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new Counter(i,true);
    }
  }

    /** 
   * Return the first available counter
   * if not, return a counter with id:-1.
   */
  public Counter findAvaCounter(){
    for (int i = 0; i < this.counters.length; i += 1) {
      if (this.counters[i].checkAvailability()) {
        return counters[i];
      }
    }
    return new Counter(-1,false);
  }
}
