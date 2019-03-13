package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class PayEvent extends Event{
    private Customer customer;
    private MarketState marketState;
    
    public PayEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer)
    {
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
        PayEvent payEvent = new PayEvent(marketState.getTime().getNextCustomer(), queue,marketState,customer);
        queue.addEvent(payEvent);
        if (marketState. > 0) {
        	
        }
    }

    @Override
    public double getStartTime() {
        return startTime;
    }

    public Customer getCustomer(){
        return customer;
    }
}
