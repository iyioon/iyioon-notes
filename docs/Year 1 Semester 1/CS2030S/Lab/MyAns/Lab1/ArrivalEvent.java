class ArrivalEvent extends Event {
    /** 
     * The Customer associated with this event.  
     */
    private Customer customer;
    /**
     * The service time of the customer associated
     * this event.
     */
    private double serviceTime;
    /**
     * A list of Counters to indicate if a service counter is
     * available. Counters has a counter
     */
    private Counters counters;
    /**
     * Constructor for ArrivalEvent.
     *
     * @param time       The time this event occurs.
     * @param customer The customer associated with this
     *                   event.
     * @param serviceTime The time this customer takes 
     *                    for service.
     * @param counter   The indicator of which counter is
     *                    available.
     */
    public ArrivalEvent(double time,Customer customer,double serviceTime,Counters counters){
        super(time);
        this.customer = customer;
        this.serviceTime = serviceTime;
        this.counters = counters;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(": Customer %s arrives", this.customer.toString());
    }

    @Override
    public Event[] simulate(){
      // Find the first available counter.
      Counter avaCounter = counters.findAvaCounter();

      if (avaCounter.toString().equals("-1")) {
        // If no such counter can be found, the customer
        // should depart.
        return new Event[] { 
          new DepartureEvent(this.getTime(), this.customer)
        };
      } else {
        // Else, the customer should go the the first 
        // available counter and get served.
        return new Event[] { 
          new ServiceBeginEvent(this.getTime(), this.customer, 
              this.serviceTime, avaCounter)
        };
      }
    }
}