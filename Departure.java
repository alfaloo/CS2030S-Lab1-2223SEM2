class Departure extends Event {
  /** 
   * Customer is now a separate class, currently
   * it only has one attribute, which is the
   * customerId. Can expand in the future with
   * other attributes such as the customer's age,
   * gender, service type, etc.
   */
  private Customer customer;
  
  /**
   * Constructor for a Departure event.
   *
   * @param time        The time this event occurs.
   * @param customer    The customer associated with this
   *                    event.
   */
  public Departure(double time, Customer customer) {
    super(time);
    this.customer = customer;
  }

  @Override
  public Event[] simulate() {
    return new Event[] {};
  }

  @Override
  public String toString() {
    String str = String.format(": Customer %d departed",
		    this.customer.getCustomerId());
    return super.toString() + str;
  }   
}
