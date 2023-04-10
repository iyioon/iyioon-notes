public class ServiceBeginEvent extends Event{
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
     * The counter associated with this event.
     */
    private Counter counter;
    /** 
     * Constructor for a ServiceBeginEvent 
     */
    public ServiceBeginEvent(double time,Customer customer,double serviceTime,Counter counter){
      super(time);
      this.customer = customer;
      this.serviceTime = serviceTime;
      this.counter = counter;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(": Customer %s service begin (by Counter %s)", 
        this.customer.toString(), this.counter.toString());
    }

    @Override
    public Event[] simulate(){
      // Mark the counter is unavailable, then schedule
      // a service-end event at the current time + service time.
      this.counter.changeAvailability();
      double endTime = this.getTime() + this.serviceTime;
      return new Event[] { 
        new ServiceEndEvent(endTime, this.customer, this.counter)
      };
    }
}
