package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;

/**
 * This class is an event that represents the store closing.
 * 
 * Victor Longberg, Tobias Heidlund Simon Lundberg och Klas Mannberg.
 */
public class CloseEvent extends Event{

    MarketState marketState;
    
    /**
     * This is the CloseEvent constructor
     * 
     * @param startTime An integer
     * @param queue An EventQueue
     * @param marketState A MarketState
     */
    public CloseEvent(int startTime, EventQueue queue, MarketState marketState) {
        super(startTime, queue);
        this.marketState = marketState;
    }
    
    /**
     * This method executes the event.
     */
    @Override
    public void ExecuteEvent() {
        marketState.getTime().setTime(startTime);
        marketState.observable(this);
        marketState.closeStore();

    }
    /**
     * This method returns the event's start time.
     * 
     * @return the start time
     */
    @Override
    public double getStartTime() {
        return startTime;
    }
}
