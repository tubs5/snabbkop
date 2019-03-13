package Lab5.State;

import java.util.Observable;

import Lab5.Event.Event;

/**
 * Updates and returns running status of current state
 * 
 * @author Klas Mannberg
 * @version 1.0
 * @since 2019-03-08
 */

public class SimState extends Observable {

	private boolean running;

	/*
	 * Returns running status
	 */
	private boolean isRunning() {
		return running;
	}

	public void observable(Event eventname) {
		setChanged();
		notifyObservers(eventname);
	}
}