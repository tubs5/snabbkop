package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

public class EndEvent extends Event {
    public EndEvent(double startTime, EventQueue queue, MarketState marketState) {
        super(startTime, queue);
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
