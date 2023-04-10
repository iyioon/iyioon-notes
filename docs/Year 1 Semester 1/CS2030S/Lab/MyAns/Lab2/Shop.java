public class Shop {
  /** List of counters. */
  private Counter[] counters;

  /** Queue in the shop. */
  private Queue queue;

  /**
   * Constructor for Counters.
   * Create a list of counters with size
   * numOfCounters, where all counters
   * are set to available.
   * 
   * @param numOfCounters The number of counters in the shop.
   * @param m             Maximum allowed length of the entrance queue.
   */
  public Shop(int numOfCounters, int m) {
    this.counters = new Counter[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      counters[i] = new Counter(i, true);
    }
    queue = new Queue(m);
  }

  /**
   * Find available Counter.
   * 
   * @return Return the first available counter.
   *         if not, return a counter with id:-1.
   */
  public Counter findAvaCounter() {
    for (int i = 0; i < this.counters.length; i += 1) {
      if (this.counters[i].checkAvailability()) {
        return counters[i];
      }
    }
    return new Counter(-1, false);
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
  public String printQueue() {
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
    return (Customer) this.queue.deq();
  }
}
