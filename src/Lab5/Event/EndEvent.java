package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

/**
 * This class is an event that runs at the end of a simulation.
 * 
 * @author Victor Longberg, Tobias Heidlund Simon Lundberg och Klas Mannberg
 *
 */
public class EndEvent extends Event {
    MarketState state;
    /**
     * The EndEvent constructor.
     * 
     * @param startTime A double
     * @param queue An EventQueue
     * @param state A MarketState
     */
    public EndEvent(double startTime, EventQueue queue, MarketState state) {
        super(startTime, queue);
        this.state = state;
    }
    
    /**
     * This method executes the event
     */
    @Override
    public void ExecuteEvent() {
        state.observable(this);
    }

    /**
     * This method returns the start time of the event
     * 
     * @return The start time.
     */
    @Override
    public double getStartTime() {
        return startTime;
    }
}
