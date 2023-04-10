public class JoinQueueEvent extends Event {
  /** The Shop containing available counters. */
  private Shop shop;
  /** The customer associated with this event. */
  private Customer customer;

  /**
   * Constructor for JoinQueueEvent.
   *
   * @param time     The time this event occurs.
   * @param customer The customer associated with this
   *                 event.
   * @param shop     The shop the event is taking place
   */
  public JoinQueueEvent(double time, Customer customer, Shop shop) {
    super(time);
    this.customer = customer;
    this.shop = shop;
  }

  /**
   * Return the string representation this event.
   *
   * @return A string consists of the time,
   *         customer and shop this event occurs.
   */
  @Override
  public String toString() {
    return super.toString() +
        String.format(
            ": %s joined shop queue %s",
            this.customer.toString(),
            this.shop.toString());
  }

  /**
   * Simulate this event.
   *
   * @return An array of new events to be scheduled by the simulator.
   */
  @Override
  public Event[] simulate() {
    this.shop.addToQueue(customer);
    return new Event[] {};
  }
}
