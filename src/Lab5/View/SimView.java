package Lab5.View;

import java.util.Observer;

import Lab5.State.SimState;

/**
 * Abstract class for simulator views
 * 
 * @author Klas Mannberg
 * @version 1.0
 * @since 2019-03-08
 * 
 */
public abstract class SimView implements Observer {

	protected SimState sState;

	/**
	 * Takes parameter to update sState
	 */
	public SimView(SimState update) {
		this.sState = update;
	}

	public abstract void start();

	public abstract void print();

	public abstract void end();
}
