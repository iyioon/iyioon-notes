public class ServiceEndEvent extends Event {

  /** The customer associated with this event. */
  private Customer customer;
  /** The counter associated with this event. */
  private Counter counter;
  /** The Shop containing available counters. */
  private Shop shop;

  /**
   * Constructor for ServiceEndEvent.
   *
   * @param time     The time this event occurs.
   * @param customer The customer associated with this
   *                 event.
   * @param counter  The counter associated with this event
   * @param shop     The shop the event is taking place
   */
  public ServiceEndEvent(double time, Customer customer, Counter counter, Shop shop) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.shop = shop;
  }

  /**
   * Return the string representation this event.
   *
   * @return A string consists of the time,
   *         customer, and counter this event occurs.
   */
  @Override
  public String toString() {
    return (super.toString() +
        String.format(
            ": %s service done (by %s)",
            this.customer.toString(),
            this.counter.toString()));
  }

  /**
   * Simulate this event.
   *
   * @return An array of new events to be scheduled by the simulator.
   */
  @Override
  public Event[] simulate() {
    // Mark the counter to available.
    this.counter.changeAvailability();
    // If there are customer in the shop queue and
    // in the counter queue.
    if (!this.shop.toString().contains("[ ]") &&
        !this.counter.toString().contains("[ ]")) {
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(
              this.getTime(),
              this.counter.nextCustomer(),
              this.counter,
              this.shop),
          new JoinCQueueEvent(
              this.getTime(),
              this.counter,
              this.shop.nextCustomer()),
      };
    } else if (!this.shop.toString().contains("[ ]")
        && this.counter.toString().contains("[ ]")) {
      // If there is a queue only in the counter.
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(
              this.getTime(),
              this.shop.nextCustomer(),
              this.counter,
              this.shop),
      };
    } else if (this.shop.toString().contains("[ ]") &&
        !this.counter.toString().contains("[ ]")) {
      // If there is a queue only in the shop
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(
              this.getTime(),
              this.counter.nextCustomer(),
              this.counter,
              this.shop),
      };
    } else {
      // No queue.
      return new Event[] { new DepartureEvent(this.getTime(), this.customer) };
    }
  }
}
