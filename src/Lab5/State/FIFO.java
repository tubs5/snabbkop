package Lab5.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
/**
 * 
 * @author Simon Lundberg and Tobias Heidlund
 *
 */
public class FIFO{
	
	private ArrayList<Customer> queue = new ArrayList<Customer>();
	
	public Customer returnFIFO () { 
		Customer c =  queue.get(0);
		queue.remove(0);
		return c;
	}
	
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
	
	public Customer getFirst() {
		return queue.get(0);
	}
	
	public int getSize() {
		return queue.size();
	}
	
	public String toString() {
		return Arrays.toString(queue.toArray());
	}
}
