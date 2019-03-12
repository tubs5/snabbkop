package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class ArriveEvent extends Event {
	private Customer customer;

	public ArriveEvent(int startTime, EventQueue queue, SimState simState, Customer customer) {
		super(startTime, queue, simState);
		this.customer = customer;
	}

	@Override
	public void ExecuteEvent() {
		if (isOpen = true) {
		if (maxCustomers <= currentCustomers) {

		} else {
			missedCustomers += 1;
		}
		}
	} 

	@Override
	public double getStartTime() {
		return startTime;
	}

	public Customer getCustomer() {
		return customer;
	}
}
