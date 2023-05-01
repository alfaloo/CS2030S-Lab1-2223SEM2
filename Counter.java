class Counter {
  /**
   * The id of the counter associated with this event.
   * This field only matters if the event type if 
   * SERVICE_BEGIN or SERVICE_END.
   */
  private int counterId;
  
  /**
   * This indicates the availability of this particular
   * counter. True means available, false means occupied.
   */
  private boolean available; 
  
  /**
   * Constructor for a Counter.
   * @param counterId   The id of the counter associated with
   *                    this event.
   */
  public Counter(int counterId) {
    this.counterId = counterId;
    this.available = true;
  }

  /**
   * Method to access counterId
   */
  public int getCounterId() {
    return this.counterId;
  }

  /**
   * Toggles the boolean value of this.available;
   */
  public void toggleAvailability() {
    this.available = !this.available;
  }

  /**
   * Returns the boolean value of this.available;
   */
  public boolean getAvailability() {
    return this.available;
  }
}
