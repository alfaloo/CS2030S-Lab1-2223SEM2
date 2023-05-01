class ServiceEnd extends Event {
  /** 
   * Customer is now a separate class, currently
   * it only has one attribute, which is the
   * customerId. Can expand in the future with
   * other attributes such as the customer's age,
   * gender, service type, etc.
   */
  private Customer customer;

  /**
   * Bank is now a separate class, currently it
   * only has one purpose, which is to keep track
   * of the availability of the counters as
   * represented by a boolean array. Can expand
   * in the future with other futionalities
   * such as waiting rooms, atms, etc.
   */
  private Bank bank;

  /**
   * Counter is now a separate class, currently
   * it only has one attribute, which is the
   * counterId. Can expand in the future with
   * other attributes such as the counter's servant
   * details, service types, etc.
   */
  private Counter counter;
  
  /**
   * Constructor for a ServiceEnd event.
   *
   * @param time        The time this event occurs.
   * @param customer    The customer associated with this
   *                    event.
   * @param counter     The counter associated with
   *                    this event.
   * @param bank        The indicator of which bank is
   *                    visited
   */
  public ServiceEnd(double time, Customer customer,
		  Counter counter, Bank bank) {
    super(time);
    this.customer = customer;
    this.bank = bank;
    this.counter = counter;
  }

  @Override
  public Event[] simulate() {
    // Mark the counter is available, then schedule
    // a departure event at the current time.
    this.counter.toggleAvailability();
    return new Event[] {
      new Departure(this.getTime(), this.customer)
    };
  }

  @Override
  public String toString() {
    String str = String.format(": Customer %d service done (by Counter %d)",
          this.customer.getCustomerId(), this.counter.getCounterId());
    return super.toString() + str;
  }
}
