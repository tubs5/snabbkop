package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.FIFO;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class PickupEvent extends Event{
    private Customer customer;
    private MarketState marketState;
    public PickupEvent(double startTime, EventQueue queue, MarketState simState, Customer customer) {
        super(startTime, queue);
        this.customer = customer;
    }

    @Override
    public void ExecuteEvent() {
        if (marketState.ka)

    }

    @Override
    public double getStartTime() {
        return startTime;
    }

    public Customer getCustomer(){
        return customer;
    }
}
