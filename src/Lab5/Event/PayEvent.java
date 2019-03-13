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
	private FIFO fifo;

	public PayEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer) {
		super(startTime, queue);
		this.customer = customer;
		this.marketState = marketState;
	}

	@Override
	public void ExecuteEvent() {
		marketState.addCompletedCustomers();
		marketState.removeCurrentCustomers();
		if (marketState.getActiveKassor() > 0) {
			marketState.removeActiveKassa();
		}
		PayEvent payEvent = new PayEvent(marketState.getTime().getNextPayTime(), queue, marketState, customer);
		queue.addEvent(payEvent);
		if (fifo.getSize() < 0) {
			Customer customer2 = fifo.getFirst();
			PayEvent payEvent2 = new PayEvent(marketState.getTime().getNextPayTime(), queue, marketState, customer2);
			queue.addEvent(payEvent2);
		}
		marketState.notifyObservers(this);
	}

	@Override
	public double getStartTime() {
		return startTime;
	}

	public Customer getCustomer() {
		return customer;
	}
}
