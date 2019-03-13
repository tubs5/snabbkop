package Lab5.Queue;

import Lab5.Event.*;

/**
 * Created by Tobias Heidlund on 2019-03-08.
 */
public class EventQueue {
    private SortedSequence sequence = new SortedSequence();
    
    /**
     * This method returns the next event
     * 
     * @return The next event
     */
    public Event getNextEvent(){
        return sequence.getNextEvent();
    }
    
    /**
     * This method adds an event
     * 
     * @param event An event
     */
    public void addEvent(Event event){
        sequence.addEvent(event);
    }

    public boolean hasNext(){
        return sequence.hasNext();
    }

}
