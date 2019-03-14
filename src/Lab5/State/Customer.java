package Lab5.State;

/**
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 *
 */
public class Customer {

	private int customerID;
	private static int customerids = 0;

	public Customer() {
		customerID = customerids++;
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
		return "" + customerID;
	}
}
