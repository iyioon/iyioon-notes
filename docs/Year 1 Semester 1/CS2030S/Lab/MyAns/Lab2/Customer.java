public class Customer {
  /** Id of the Customer. */
  private int id;
  /** Service time of the Customer. */
  private double serviceTime;

  /**
   * Constructor for Customer.
   * 
   * @param id          Unique id of the customer.
   * @param serviceTime Service time of the customer.
   */
  public Customer(int id, double serviceTime) {
    this.id = id;
    this.serviceTime = serviceTime;
  }

  /**
   * Return the id of this Customer.
   */
  @Override
  public String toString() {
    return "C" + String.valueOf(id);
  }

  /**
   * Find the end time of the service.
   * 
   * @param startTime the time the service starts.
   * @return end Time the service ends.
   */
  public double findEndTime(double startTime) {
    return this.serviceTime + startTime;
  }

}
