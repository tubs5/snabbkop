package Lab5.State;

import java.util.ArrayList;
import java.util.Queue;

public class FIFO{
	
	private ArrayList<Customer> queue = new ArrayList<Customer>();
	
	public Customer returnFIFO () { 
		Customer c =  queue.get(0);
		queue.remove(0);
		return c;
	}
	
	public void add(Customer c) {
		queue.add(c);
	}
	
	public void remove(Customer c) {
		queue.remove(c);
	}
}
