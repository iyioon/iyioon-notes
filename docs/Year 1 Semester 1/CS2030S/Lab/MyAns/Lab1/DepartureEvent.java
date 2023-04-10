public class DepartureEvent extends Event{
    /** 
     * The customer associated with this event.  
     */
    private Customer customer;
    /** 
     * Constructor for a DepartureEvent
     */
    public DepartureEvent(double time,Customer customer){
      super(time);
      this.customer = customer;
    }

    @Override
    public String toString(){
        return super.toString() + String.format(": Customer %s departed", this.customer.toString());
    }

    @Override
    public Event[] simulate(){
      return new Event[] {};
    }
}
