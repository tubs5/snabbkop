package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class StartEvent extends Event{
    private MarketState marketState;
    private int test = 0;

    public StartEvent(double startTime, EventQueue queue, MarketState marketState) {
        super(startTime, queue);
        this.marketState = marketState;
    }

    @Override
    public void ExecuteEvent() {
        marketState.observable(this);
        marketState.openStore();


        Customer customer = new Customer();
        ArriveEvent arriveEvent = new ArriveEvent(marketState.getTime().getNextCustomer(),queue,marketState,customer);
        queue.addEvent(arriveEvent);

    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
