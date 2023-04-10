public class Shop {
  /** List of counters. */
  private Array<Counter> counters;

  /** Queue in the shop. */
  private Queue<Customer> queue;

  /**
   * Constructor for Counters.
   * Create a list of counters with size
   * numOfCounters, where all counters
   * are set to available.
   * 
   * @param numOfCounters The number of counters in the shop.
   * @param l             Maximum length of the counter queue
   * @param m             Maximum allowed length of the entrance queue.
   */
  public Shop(int numOfCounters, int l, int m) {
    this.counters = new Array<Counter>(numOfCounters);
    for (int i = 0; i < numOfCounters; i++) {
      counters.set(i, new Counter(i, true, l));
    }
    this.queue = new Queue<Customer>(m);
  }

  /**
   * Find available Counter.
   * 
   * @return Return available counter.
   *         If not, return a counter with id:-1.
   */
  public Counter findAvaCounter() {
    // Find empty counter.
    for (int i = 0; i < counters.length(); i += 1) {
      if (counters.get(i).checkAvailability()) {
        return counters.get(i);
      }
    }
    // Else find counter with least queue.
    if (!counters.min().checkQueueStatus().equals("full")) {
      return counters.min();
    }
    return new Counter(-1, false, 0);
  }

  /**
   * Add the customer into the queue.
   * 
   * @param customer The customer instered into the queue.
   * @return the true if success.
   */
  public boolean addToQueue(Customer customer) {
    return queue.enq(customer);
  }

  /**
   * Returns the string representation of the queue.
   * 
   * @return A string consisting of the string representation of
   *         every customer in the queue.
   */
  @Override
  public String toString() {
    return queue.toString();
  }

  /**
   * Check the status of the queue.
   * 
   * @return Return full, empty and not full based on the queue size.
   */
  public String checkQueueStatus() {
    if (queue.isFull()) {
      return "full";
    } else if (queue.isEmpty()) {
      return "empty";
    } else {
      return "not full";
    }
  }

  /**
   * Find the next customer in the queue.
   * 
   * @return Return the next customer in the queue.
   */
  public Customer nextCustomer() {
    return this.queue.deq();
  }
}
