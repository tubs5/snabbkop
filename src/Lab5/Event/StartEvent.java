package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.MarketState;

/**
 * This class is an event that occurs at the start of the simulation
 *
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 */
public class StartEvent extends Event {
	private MarketState marketState;
	private int test = 0;

	/**
	 * This is the StartEvent constructor
	 * 
	 * @param startTime   A double
	 * @param queue       An EventQueue
	 * @param marketState A MarketState
	 */
	public StartEvent(double startTime, EventQueue queue, MarketState marketState) {
		super(startTime, queue);
		this.marketState = marketState;
	}

	/**
	 * This method creates a new customer and then an arriveEvent, which is the
	 * added to the event queue.
	 */
	@Override
	public void ExecuteEvent() {
		marketState.observable(this);
		marketState.openStore();

		Customer customer = new Customer();
		ArriveEvent arriveEvent = new ArriveEvent(marketState.getTime().getNextCustomer(), queue, marketState,
				customer);
		queue.addEvent(arriveEvent);

	}

	/**
	 * This method returns the start time.
	 * 
	 * @return The start time
	 */
	@Override
	public double getStartTime() {
		return startTime;
	}
}
