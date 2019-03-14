package Lab5.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
/**
 * This class is a "First in, First out" queue that simulates the queue to the checkouts.
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 *
 */
public class FIFO{
	
	private ArrayList<Customer> queue = new ArrayList<Customer>();
	
	
	/**
	 * This method adds a customer to the queue.
	 * 
	 * @param c A customer
	 */
	public void add(Customer c) {
		queue.add(c);
	}
	
	/**
	 * This method removes a customer to the queue.
	 * 
	 * @param c A customer
	 */
	public void remove(Customer c) {
		queue.remove(c);
	}
	
	
	/**
	 * This method gets the first item in the queue and also removes it.
	 * 
	 * @return First item in the queue.
	 */
	public Customer getFirst() {
		Customer c = queue.get(0);
		queue.remove(0);
		return c ;
		
	}
	
	
	/**
	 * This method returns the size of the queue
	 * 
	 * @return Queue Size
	 */
	public int getSize() {
		return queue.size();
	}
	
	
	/**
	 * This method returns the queu as a list
	 * 
	 */
	public String toString() {
		return Arrays.toString(queue.toArray());
	}
}
