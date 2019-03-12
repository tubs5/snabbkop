package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class CloseEvent extends Event{

    public CloseEvent(int startTime, EventQueue queue, MarketState marketState) {
        super(startTime, queue);
    }

    @Override
    public void ExecuteEvent() {

    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
