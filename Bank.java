class Bank {
  /**
   * An array containing all the counters. Each
   * counter will have an int id attribute and
   * a boolean available attribute.
   */
  private Counter[] allCounters;
 
  /**
   * Bank constructor to initialise the counters
   */ 
  public Bank(int numOfCounters) {
    this.allCounters = new Counter[numOfCounters];
    for (int i = 0; i < numOfCounters; i++) {
      this.allCounters[i] = new Counter(i);
    }
  }

  /**
   * Method to retrieve the first available
   * counter. If there are no available counter,
   * then return a counter with counterId as -1
   */
  public Counter findCounter() {
    // Find the first available counter.
    for (Counter i: allCounters) {
      if (i.getAvailability()) {
        return i;
      }
    }
    return null;
  }
}
