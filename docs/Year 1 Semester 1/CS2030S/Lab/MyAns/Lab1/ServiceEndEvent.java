public class ServiceEndEvent extends Event{
    /** 
     * The Customer associated with this event.  
     */
    private Customer customer;
    /**
     * The counter associated with this event.
     */
    private Counter counter;
    /** 
     * Constructor for a ServiceEndEvent
     */
    public ServiceEndEvent(double time,Customer customer,Counter counter){
      super(time);
      this.customer = customer;
      this.counter = counter;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(": Customer %s service done (by Counter %s)", 
        this.customer.toString(), this.counter.toString());
    }

    @Override
    public Event[] simulate(){
      // Mark the counter is available, then schedule
      // a departure event at the current time.
      this.counter.changeAvailability();
      return new Event[] { 
        new DepartureEvent(this.getTime(), this.customer),
      };
    }
}