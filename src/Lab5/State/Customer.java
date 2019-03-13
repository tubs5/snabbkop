package Lab5.State;

/**
 * 
 * @author Simon Lundberg
 *
 */
public class Customer {
	
	private int customerID;
	private double timeInStore;
	private double timeInQueue;
	private static int customerids = 0;

	public Customer(){
		customerID = customerids++;
	}

	/**
	 * This method return the total time the customer spent in the store.
	 * 
	 * @return Total time spent in store.
	 */
	public double getTimeReturnStore() {
		return timeInStore;
	}
	
	
	/**
	 * This method sets the total time the customer spent in the store
	 * 
	 * @param d A double
	 */
	public void setTimeReturnStore(double d) {
		timeInStore = d;
	}
	
	
	/**
	 * This method returns the total time the customer spent in the queue.
	 * 
	 * @return Total time spent in queue.
	 */
	public double getTimeReturnQueue() {
		return timeInQueue;
	}
	
	
	/**
	 * This method sets the total time the customer spent in the queue.
	 * 
	 * @param d A double
	 */
	public void setTimeReturnQueue(double d) {
		timeInQueue = d;
	}
	
	/**
	 * This method returns the customers ID.
	 * 
	 * @return Customer ID.
	 */
	public int getID() {
		return customerID;
	}

	@Override
	public String toString() {
		return ""+customerID;
	}
}
