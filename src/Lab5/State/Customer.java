package Lab5.State;

/**
 * This class represents a customer
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 *
 */
public class Customer {
	
	private int customerID;
	private static int customerids = 0;

	/**
	 * Customer constructor, assigns an ID
	 */
	public Customer(){
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
	/**
	 * This method returns the customer ID as a string
	 */
	@Override
	public String toString() {
		return ""+customerID;
	}
}
