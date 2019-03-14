package Lab5.Queue;

import Lab5.Event.*;

/**
 * This class is a queue of events
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 */
public class EventQueue {
	private SortedSequence sequence = new SortedSequence();

	/**
	 * This method returns the next event
	 * 
	 * @return The next event
	 */
	public Event getNextEvent() {
		return sequence.getNextEvent();
	}

	/**
	 * This method adds an event
	 * 
	 * @param event An event
	 */
	public void addEvent(Event event) {
		sequence.addEvent(event);
	}

	/**
	 * This method checks if the sequence has a next element
	 * 
	 * @return True or False
	 */
	public boolean hasNext() {
		return sequence.hasNext();
	}

}
