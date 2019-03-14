package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

public class EndEvent extends Event {
    MarketState state;
    public EndEvent(double startTime, EventQueue queue, MarketState state) {
        super(startTime, queue);
        this.state = state;
    }

    @Override
    public void ExecuteEvent() {
        state.observable(this);
    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
