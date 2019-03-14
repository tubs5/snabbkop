package Lab5.State;

import java.util.Observable;

import Lab5.Event.Event;

/**
 * Updates and returns running status of current state
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 * @version 1.0
 * @since 2019-03-13
 */

public class SimState extends Observable {

	private boolean running = false;

	/*
	 * Returns running status
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * This method runs the state
	 * 
	 */
	public void run() {
		running = true;
	}

	/**
	 * 
	 * This method stops the state
	 */
	public void stop() {
		running = false;
	}

	/**
	 * This method updates the state
	 *
	 */
	public void update() {

	}

	/**
	 * This method takes an Event and notifies observers
	 *
	 * @param eventname An Event
	 */
	public void observable(Event eventname) {
		setChanged();
		notifyObservers(eventname);
	}
}