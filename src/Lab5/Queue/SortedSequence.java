package Lab5.Queue;

import Lab5.Event.*;

import java.util.ArrayList;

/**
 * Sorts events
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 */
public class SortedSequence {
	private ArrayList<Event> events = new ArrayList<Event>();
	
	/**
	 * This method gets the next Event while also removing it from the queue
	 * 
	 * @return the next event
	 */
	public Event getNextEvent() {
		Event e = events.get(0);
		events.remove(0);
		return e;
	}
	
	/**
	 * This method adds events to the queue
	 * 
	 * @param e An Event
	 */
	public void addEvent(Event e) {
		double startTime = e.getStartTime();
		if (events.size() == 0) { //If queue is empty, simply adds
			events.add(e);
			return;
		}
		for (int i = 0; i < events.size(); i++) { // looks through the queue and places the event based on time.
			if (events.get(i).getStartTime() >= startTime) {
				events.add(i, e);
				return;
			}
		}
		events.add(e);
	}
	
	/**
	 * Checks if the queue has a next element.
	 * 
	 * @return True or False
	 */
	public boolean hasNext() {
		return events.size() != 0;
	}

}
