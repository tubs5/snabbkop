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
        marketState.closeStore();
        marketState.notifyObservers(this);
    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
