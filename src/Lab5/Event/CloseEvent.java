package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class CloseEvent extends Event{

    MarketState marketState;

    public CloseEvent(int startTime, EventQueue queue, MarketState marketState) {
        super(startTime, queue);
        this.marketState = marketState;
    }

    @Override
    public void ExecuteEvent() {
        marketState.getTime().setTime(startTime);
        marketState.observable(this);
        marketState.closeStore();

    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
