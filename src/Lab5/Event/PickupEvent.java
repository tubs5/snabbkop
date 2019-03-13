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
    public PickupEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer) {
        super(startTime, queue);
        this.customer = customer;
        this.marketState = marketState;
    }

    @Override
    public void ExecuteEvent() {
        marketState.getTime().setTime(startTime);
        if (marketState.getActiveKassor() <= marketState.getKassor()){
            marketState.addActiveKassa();


            PayEvent payEvent = new PayEvent(marketState.getTime().getNextPayTime(),queue,marketState,customer);
            queue.addEvent(payEvent);
        }else{
            marketState.getFIFO().add(customer);
            marketState.addQueueingCustomers();
        }

        marketState.observable(this);
    }

    @Override
    public double getStartTime() {
        return startTime;
    }

    public Customer getCustomer(){
        return customer;
    }
}
