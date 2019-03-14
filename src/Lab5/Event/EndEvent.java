package Lab5.Event;

import Lab5.Queue.EventQueue;

public class EndEvent extends Event {
    public EndEvent(double startTime, EventQueue queue) {
        super(startTime, queue);
    }

    @Override
    public void ExecuteEvent() {

    }

    @Override
    public double getStartTime() {
        return startTime;
    }
}
