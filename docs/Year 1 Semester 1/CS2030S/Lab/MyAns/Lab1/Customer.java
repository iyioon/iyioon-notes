public class Customer {
  /**
   * Id of the Customer
   */
  private int id;
   /**
   * Constructor for Customer
   */
  public Customer(int id){
    this.id = id; 
  }
  /**
   * Return the Id of this Customer
   */
  @Override
  public String toString(){
    return String.valueOf(id);
  }

}
