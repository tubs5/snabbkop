package Lab5.Queue;

import Lab5.Event.*;

import java.util.ArrayList;

/**
 * Sorts events
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 */
public class SortedSequence {
	private ArrayList<Event> events = new ArrayList<Event>();

	public Event getNextEvent() {
		Event e = events.get(0);
		events.remove(0);
		return e;
	}

	public void addEvent(Event e) {
		double startTime = e.getStartTime();
		if (events.size() == 0) {
			events.add(e);
			return;
		}
		for (int i = 0; i < events.size(); i++) {
			if (events.get(i).getStartTime() >= startTime) {
				events.add(i, e);
				return;
			}
		}
		events.add(e);
	}

	public boolean hasNext() {
		return events.size() != 0;
	}

}
