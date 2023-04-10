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
    return super.toString() + String.format(": %s service done (by %s)",
        this.customer.toString(), this.counter.toString());
  }

  /**
   * Simulate this event.
   *
   * @return An array of new events to be scheduled by the simulator.
   */
  @Override
  public Event[] simulate() {
    // Mark the counter is available, then schedule
    // a departure event at the current time.
    // If queue is not empty, schedule a ArrivalEvent at the current time,taken from
    // the queue.
    this.counter.changeAvailability();
    if (!this.shop.checkQueueStatus().equals("empty")) {
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
          new ServiceBeginEvent(this.getTime(), this.shop.nextCustomer(), this.counter, this.shop),
      };
    } else {
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer),
      };
    }
  }
}