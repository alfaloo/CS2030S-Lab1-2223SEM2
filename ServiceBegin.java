class ServiceBegin extends Event {
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
   * Constructor for ServiceBegin event.
   *
   * @param time        The time this event occurs.
   * @param customer    The customer associated with this
   *                    event.
   * @param serviceTime The time this customer takes 
   *                    for service.
   * @param counter     The counter associated with
   *                    this event.
   * @param bank        The indicator of which bank is
   *                    visited
   */
  public ServiceBegin(double time, Customer customer,
      double serviceTime, Counter counter, Bank bank) {
    super(time);
    this.customer = customer;
    this.serviceTime = serviceTime;
    this.counter = counter;
    this.bank = bank;
  }

  @Override
  public Event[] simulate() {
    // Mark the counter is unavailable, then schedule
    // a service-end event at the current time + service time.
    this.counter.toggleAvailability();
    double endTime = this.getTime() + this.serviceTime;
    return new Event[] {
      new ServiceEnd(endTime, this.customer,
          this.counter, this.bank)
    };
  }

  @Override
  public String toString() {
    String str = String.format(": Customer %d service begin (by Counter %d)",
          this.customer.getCustomerId(), this.counter.getCounterId());
    return super.toString() + str;
  }
}
