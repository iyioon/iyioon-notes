class ArrivalEvent extends Event {
  /** The Customer associated with this event. */
  private Customer customer;
  /** The Shop containing available counters. */
  private Shop shop;

  /**
   * Constructor for ArrivalEvent.
   *
   * @param time     The time this event occurs.
   * @param customer The customer associated with this
   *                 event.
   * @param shop     The shop the event is taking place
   */
  public ArrivalEvent(double time, Customer customer, Shop shop) {
    super(time);
    this.customer = customer;
    this.shop = shop;
  }

  @Override
  public String toString() {
    return (super.toString() +
        String.format(
            ": %s arrived %s",
            this.customer.toString(),
            this.shop.printQueue()));
  }

  /**
   * Simulate this event.
   *
   * @return An array of new events to be scheduled by the simulator.
   */
  @Override
  public Event[] simulate() {
    // Find the first available counter.
    Counter avaCounter = shop.findAvaCounter();
    // If the counter is full and there are spaces in the queue
    if (avaCounter.toString().equals("S-1") && !this.shop.checkQueueStatus().equals("full")) {
      return new Event[] {
          // Customer waits in the queue
          new JoinQueueEvent(this.getTime(), this.customer, this.shop)
      };
    } else if (!avaCounter.toString().equals("S-1")) {
      // if there is available counter, the customer should go the the first
      // available counter and get served.
      return new Event[] {
          new ServiceBeginEvent(this.getTime(), this.customer, avaCounter, this.shop)
      };
    } else {
      // if there is no available counter and full queue
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer)
      };
    }
  }
}
