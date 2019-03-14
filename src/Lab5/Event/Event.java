package Lab5.Event;

import Lab5.Queue.EventQueue;

/**
 * This class is an event and represents them on a general level.
 * 
 * Victor Longberg, Tobias Heidlund Simon Lundberg och Klas Mannberg
 */
public abstract class Event {

    public boolean emergencyStop = false;
    protected double startTime;
    protected EventQueue queue;

    /**
     * This is the Event constructor
     * 
     * @param startTime A double
     * @param queue An EventQueue
     */
    public Event(double startTime, EventQueue queue){
        this.startTime = startTime;
        this.queue = queue;
    }
    /**
     * This method Executes the event
     */
    public abstract void ExecuteEvent();
    
    /**
     * This method gets the start time of the event
     * 
     * @return the start time
     */
    public abstract double getStartTime();
}
