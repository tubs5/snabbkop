package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.*;

/**
 * ArriveEvent signals that a customer has arrived to the store and checks if
 * he can fit inside the store. It also checks for the potential customers lost
 * due to a full store.
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg.
 *
 */
public class ArriveEvent extends Event {

	private Customer customer;
	private MarketState marketState;

	/**
	 * 
	 * @param startTime, The time the event is called.
	 * @param queue, the queue of events.
	 * @param marketState, the state of the market.
	 * @param customer, the customer id.
	 */
	public ArriveEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer) {
		super(startTime, queue);
		this.customer = customer;
		this.marketState = marketState;
	}

	/**
	 * Executes the Events and is notifying the observer of all changes.
	 */
	@Override
	public void ExecuteEvent() {

		marketState.getTime().setTime(startTime);
		marketState.observable(this);
		if (marketState.getStore()) {
			Customer customer2 = new Customer();
			ArriveEvent arriveEvent = new ArriveEvent(marketState.getTime().getNextCustomer(), queue, marketState,
					customer2);
			queue.addEvent(arriveEvent);

			if (marketState.getMaxCustomers() > marketState.getCurrentCustomers()) {
				marketState.addCurrentCustomers();
				PickupEvent pickupEvent = new PickupEvent(marketState.getTime().getNextPickupTime(), queue, marketState,
						customer);
				queue.addEvent(pickupEvent);
			} else {
				marketState.addMissedCustomers();
			}
		}

	}

	/**
	 * Sends over information about the time.
	 * 
	 * @return startTime.
	 */
	@Override
	public double getStartTime() {
		return startTime;
	}

	/**
	 * Sends over information about the customer.
	 * 
	 * @return customer.
	 */
	public Customer getCustomer() {
		return customer;
	}
}
