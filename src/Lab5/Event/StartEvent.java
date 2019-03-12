package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class StartEvent extends Event{

    public StartEvent(int startTime, EventQueue queue, SimState simState) {
        super(startTime, queue, simState);
    }

    @Override
    public void ExecuteEvent() {
        Customer customer = new Customer();
        ArriveEvent arriveEvent = new ArriveEvent(,queue,simState,customer);
        queue.addEvent(arriveEvent);
    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
