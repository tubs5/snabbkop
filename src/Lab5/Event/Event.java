package Lab5.Event;

import Lab5.Queue.EventQueue;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public abstract class Event {

    public boolean emergencyStop = false;
    protected double startTime;
    protected EventQueue queue;


    public Event(double startTime, EventQueue queue){
        this.startTime = startTime;
        this.queue = queue;
    }
    public abstract void ExecuteEvent();

    public abstract double getStartTime();
}
