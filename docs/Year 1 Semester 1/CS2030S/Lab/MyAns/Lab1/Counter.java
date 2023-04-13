public class Counter {
  /**
   * Id of the counter
   */
  private int id;
  /**
   * True if counter is available
   */
  private boolean available;
   /**
   * Constructor for Counter
   */
  public Counter(int id,boolean available){
    this.id = id;
    this.available = available;
  }
   /**
   * Return true if available
   */
  public boolean checkAvailability(){
    return available;
  }
   /**
   * Switch availability
   */
  public void changeAvailability(){
    this.available = !this.available;
  }
  /**
   * Return the Id of the counter
   */
  @Override
  public String toString(){
    return String.valueOf(id);
  }
}
