package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class PayEvent extends Event{
    private Customer customer;

    public PayEvent(int startTime, EventQueue queue, MarketState marketState)
    {
        super(startTime, queue);
    }

    @Override
    public void ExecuteEvent() {

    }

    @Override
    public double getStartTime() {
        return startTime;
    }

    public Customer getCustomer(){
        return customer;
    }
}
