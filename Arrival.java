class Arrival extends Event {
  /** 
   * Customer is now a separate class, currently
   * it only has one attribute, which is the
   * customerId. Can expand in the future with
   * other attributes such as the customer's age,
   * gender, service type, etc.
   */
  private Customer customer;
  
  /**
   * The service time of the customer associated
   * this event.  This field matters only if the
   * event type is ARRIVAL or SERVICE_BEGIN.
   */
  private double serviceTime;

  /**
   * Bank is now a separate class, currently it
   * only has one function, which is the set of
   * counters represented as a boolean array.
   * Can expand in the future with other futionalities
   * such as waiting rooms, atms, etc.
   */
  private Bank bank;

  /**
   * Constructor for an Arrival event.
   *
   * @param time        The time this event occurs.
   * @param customer    The customer associated with this
   *                    event.
   * @param serviceTime The time this customer takes 
   *                    for service.
   * @param bank        The indicator of which bank is
   *                    visited
   */
  public Arrival(double time, Customer customer,
      double serviceTime, Bank bank) {
    super(time);
    this.customer = customer;
    this.serviceTime = serviceTime;
    this.bank = bank;
  }

  @Override
  public Event[] simulate() {
    Counter counter = bank.findCounter();  
    if (counter == null) {
      // If no such counter can be found, the customer
      // should depart.
      return new Event[] {
        new Departure(this.getTime(), this.customer)
      };
    } else {
      // Else, the customer should go the the first 
      // available counter and get served.
      return new Event[] {
      new ServiceBegin(this.getTime(), this.customer,
            this.serviceTime, counter, this.bank)
      };
    }
  }

  @Override
  public String toString() {
    String str = String.format(": Customer %d arrives", this.customer.getCustomerId());
    return super.toString() + str;
  }
}

