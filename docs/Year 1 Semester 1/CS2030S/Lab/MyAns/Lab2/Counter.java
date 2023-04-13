public class Counter {
  /** Id of the counter. */
  private int id;

  /** True if counter is available. */
  private boolean available;

  /**
   * Constructor for Counter.
   * 
   * @param id        The id of the counter.
   * @param available The status of the counter.
   */
  public Counter(int id, boolean available) {
    this.id = id;
    this.available = available;
  }

  /**
   * Return true if available.
   * 
   * @return True if the counter is available.
   *         False otherwise.
   */
  public boolean checkAvailability() {
    return available;
  }

  /**
   * Switch availability.
   */
  public void changeAvailability() {
    this.available = !this.available;
  }

  /**
   * Return the Id of the counter.
   * 
   * @return A string consisting of S and
   *         the id of the counter.
   */
  @Override
  public String toString() {
    return "S" + String.valueOf(id);
  }
}
