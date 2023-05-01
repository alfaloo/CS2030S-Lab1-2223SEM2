class Customer {
  /** 
   * The id of a customer associated with this event.  
   * First customer has id 0. Next is 1, 2, etc. 
   */
  private int customerId;
 
  /**
   * Constructor for a Customer.
   * @param customerId The customer associated with this
   *                   event.
   */
  public Customer(int customerId) {
    this.customerId = customerId;
  }
 
  /**
   * Method to access customerId
   */
  public int getCustomerId() {
    return this.customerId;
  }
}
