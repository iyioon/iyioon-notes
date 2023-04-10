public class Counter implements Comparable<Counter> {
  /** Id of the counter. */
  private int id;

  /** True if counter is available. */
  private boolean available;

  private Queue<Customer> queue;

  /**
   * Constructor for Counter.
   * 
   * @param id        The id of the counter.
   * @param available The status of the counter.
   * @param l         The maximum length of the queue
   */
  public Counter(int id, boolean available, int l) {
    this.id = id;
    this.available = available;
    this.queue = new Queue<>(l);
  }

  /**
   * Return true if available.
   * 
   * @return True if the counter is available.
   *         False otherwise.
   */
  public boolean checkAvailability() {
    return available;
  }

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
   * Switch availability.
   */
  public void changeAvailability() {
    this.available = !this.available;
  }

  /**
   * Return the Id of the counter.
   * 
   * @return A string consisting of S and
   *         the id of the counter.
   */
  @Override
  public String toString() {
    return "S" + String.valueOf(id) + " " + this.queue.toString();
  }

  public int getQueueLength() {
    return this.queue.length();
  }

  public boolean addToQueue(Customer customer) {
    return queue.enq(customer);
  }

  public Customer nextCustomer() {
    return this.queue.deq();
  }

  @Override
  public int compareTo(Counter counter) {
    return getQueueLength() - counter.getQueueLength();
  }
}
