package Lab5.View;

import java.util.Observer;

import Lab5.State.SimState;

/**
 * Abstract class for simulator views
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg.
 * @version 1.0
 * @since 2019-03-08
 * 
 */
public abstract class SimView implements Observer {

	protected SimState sState;

	/**
	 * Takes parameter to update sState
	 */
	protected SimView(SimState update) {
		this.sState = update;
	}

	public abstract void start();

	public abstract void end();

}
