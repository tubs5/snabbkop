package Lab5.Queue;

import Lab5.Event.*;

import java.util.ArrayList;

/**
 * This class holds the functionality of an event queue.
 * 
 * @author Victor Longberg, Tobias Heidlund Simon Lundberg och Klas Mannberg
 */
public class SortedSequence {
    private ArrayList<Event> events = new ArrayList<Event>();
    /**
     * This method gets the next event and removes it from the queue
     * 
     * @return an Event
     */
    public Event getNextEvent(){
        Event e = events.get(0);
        events.remove(0);
        return e;
    }

    /**
     * This method adds an event to the queue
     * 
     * @param e An Event
     */
    public void addEvent(Event e){
       double startTime = e.getStartTime();
       if(events.size() == 0){ //if the queue is empty, simply adds the event.
           events.add(e);
           return;
       }
        for (int i = 0; i < events.size(); i++) { // Checks the queue and places the event in the correct position based on start times. 
            if(events.get(i).getStartTime()>=startTime){
                events.add(i,e);
                return;
            }
        }
        events.add(e);
    }
    /**
     * This method checks if the the queue has a next element
     * 
     * @return True or False
     */
    public boolean hasNext(){
        return events.size() != 0;
    }


}
