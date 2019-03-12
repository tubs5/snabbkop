package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.SimState;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public abstract class Event {

    public boolean emergencyStop = false;
    protected double startTime;
    protected EventQueue queue;
    protected SimState simState;


    public Event(int startTime, EventQueue queue, SimState simState){
        this.startTime = startTime;
        this.queue = queue;
        this.simState = simState;
    }
    public abstract void ExecuteEvent();

    public abstract double getStartTime();
}
