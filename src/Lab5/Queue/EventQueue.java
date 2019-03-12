package Lab5.Queue;

import Lab5.Event.*;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class EventQueue {
    private SortedSequence sequence = new SortedSequence();

    public Event getNextEvent(){
        return sequence.getNextEvent();
    }

    public void addEvent(Event event){
        sequence.addEvent(event);
    }

}
