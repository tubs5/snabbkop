package Lab5.View;

import java.util.Observer;

/**
 * Abstract class for simulator views, informs current view to extending
 * classes
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

	/**
	 * State could be relayed in parameter for printing
	 */
	public abstract void start();

	public abstract void print();

	public abstract void end();
}
