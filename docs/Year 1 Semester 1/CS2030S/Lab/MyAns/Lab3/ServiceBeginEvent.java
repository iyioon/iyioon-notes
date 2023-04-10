public class ServiceBeginEvent extends Event {
  /** The customer associated with this event. */
  private Customer customer;
  /** The counter associated with this event. */
  private Counter counter;
  /** The Shop containing available counters. */
  private Shop shop;

  /**
   * Constructor for ServiceBeginEvent.
   *
   * @param time     The time this event occurs.
   * @param customer The customer associated with this
   *                 event.
   * @param counter  The counter associated with this event
   * @param shop     The shop the event is taking place
   */
  public ServiceBeginEvent(double time, Customer customer, Counter counter, Shop shop) {
    super(time);
    this.customer = customer;
    this.counter = counter;
    this.shop = shop;
  }

  /**
   * Return the string representation this event.
   *
   * @return A string consists of the time,
   *         customer and counter this event occurs.
   */
  @Override
  public String toString() {
    return super.toString() + String.format(": %s service begin (by %s)",
        this.customer.toString(), this.counter.toString());
  }

  /**
   * Simulate this event.
   *
   * @return An array of new events to be scheduled by the simulator.
   */
  @Override
  public Event[] simulate() {
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    this.counter.changeAvailability();
    return new Event[] {
        new ServiceEndEvent(
            this.customer.findEndTime(this.getTime()), this.customer, this.counter, this.shop)
    };
  }
}
