public class DepartureEvent extends Event {
  /** The customer associated with this event. */
  private Customer customer;

  /**
   * Constructor for a DepartureEvent.
   * 
   * @param time     The departure time of the customer.
   * @param customer Customer associated with this event.
   */
  public DepartureEvent(double time, Customer customer) {
    super(time);
    this.customer = customer;
  }

  /**
   * Return the string representation this event.
   *
   * @return A string consists of the time,
   *         and customer this event occurs.
   */
  @Override
  public String toString() {
    return super.toString() + String.format(": %s departed", this.customer.toString());
  }

  /**
   * Simulate this event.
   *
   * @return An array of new events to be scheduled by the simulator.
   */
  @Override
  public Event[] simulate() {
    return new Event[] {};
  }
}
