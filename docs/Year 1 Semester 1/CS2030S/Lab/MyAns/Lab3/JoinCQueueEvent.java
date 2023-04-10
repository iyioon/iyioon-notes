public class JoinCQueueEvent extends Event {
  /** The Shop containing available counters. */
  private Counter counter;
  /** The customer associated with this event. */
  private Customer customer;

  public JoinCQueueEvent(double time, Counter counter, Customer customer) {
    super(time);
    this.counter = counter;
    this.customer = customer;
  }

  @Override
  public String toString() {
    return super.toString() +
        String.format(
            ": %s joined counter queue (at %s)",
            this.customer.toString(),
            this.counter.toString());
  }

  @Override
  public Event[] simulate() {
    this.counter.addToQueue(customer);
    return new Event[] {};
  }

}
