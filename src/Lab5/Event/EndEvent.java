package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

public class EndEvent extends Event {
    private MarketState state;
    public EndEvent(double startTime, EventQueue queue,MarketState state) {
        super(startTime, queue);
        this.state = state;
    }

    @Override
    public void ExecuteEvent() {
        
    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
