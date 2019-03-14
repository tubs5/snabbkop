package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.MarketState;
import Lab5.State.FIFO;

/**
 * PayEvent signals that a customer has made a purchase and informs the program
 * that a customer has left the store and that a new cashier is available.
 * 
 * @author Victor Longberg, Tobias Heidlund Simon Lundberg och Klas Mannberg. *
 */
public class PayEvent extends Event {
	private Customer customer;
	private MarketState marketState;
	
	/**
	 * This is the PayEvent Constructor
	 * 
	 * @param startTime A double
	 * @param queue An EventQueue
	 * @param marketState A MarketState
	 * @param customer A Customer
	 */
	public PayEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer) {
		super(startTime, queue);
		this.customer = customer;
		this.marketState = marketState;
	}
	
	/**
	 * This method executes the event.
	 */
	@Override
	public void ExecuteEvent() {
		marketState.getTime().setTime(startTime);
		marketState.observable(this);
		marketState.addCompletedCustomers();
		marketState.removeCurrentCustomers();
		marketState.removeActiveKassa();

		if (marketState.getFIFO().getSize() > 0) { //Checks if the Checkout queue has Customers.
			marketState.addActiveKassa();
			Customer customer2 = marketState.getFIFO().getFirst();
			PayEvent payEvent2 = new PayEvent(marketState.getTime().getNextPayTime(), queue, marketState, customer2);
			queue.addEvent(payEvent2);
		}

	}
	/**
	 * This method gets the start time of the event.
	 * 
	 * @return The start time
	 */
	@Override
	public double getStartTime() {
		return startTime;
	}
	
	/**
	 * This method returns the customer
	 * 
	 * @return The customer
	 */
	public Customer getCustomer() {
		return customer;
	}
}
