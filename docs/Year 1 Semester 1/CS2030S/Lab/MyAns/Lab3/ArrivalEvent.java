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
            this.shop.toString()));
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
    // If the counter is full and there are spaces in the shop queue
    if (avaCounter.toString().contains("S-1") && !this.shop.checkQueueStatus().equals("full")) {
      return new Event[] {
          // Customer waits in the shop queue
          new JoinQueueEvent(this.getTime(), this.customer, this.shop)
      };
    } else if (!avaCounter.toString().contains("S-1")) {
      // If there is available counter,
      // If the counter queue is empty, then ServiceBeginEvent.
      if (avaCounter.checkAvailability()) {
        return new Event[] {
            new ServiceBeginEvent(this.getTime(), this.customer, avaCounter, this.shop)
        };
      }
      // Else join queue.
      return new Event[] {
          new JoinCQueueEvent(this.getTime(), avaCounter, this.customer)
      };
    } else {
      // if there is no available counter and full queue
      return new Event[] {
          new DepartureEvent(this.getTime(), this.customer)
      };
    }
  }
}
