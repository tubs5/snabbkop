package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class StartEvent extends Event{

    public StartEvent(int startTime, EventQueue queue, MarketState marketState) {
        super(startTime, queue);
    }

    @Override
    public void ExecuteEvent() {
        Customer customer = new Customer();
        ArriveEvent arriveEvent = new ArriveEvent( ,queue, marketState, customer);
        queue.addEvent(arriveEvent);
    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
