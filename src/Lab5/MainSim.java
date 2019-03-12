package Lab5;

import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;
import Lab5.View.View;

/**
 * Creates new simulation
 * 
 * @author Klas Mannberg
 * @version 1.1
 * @since 2019-03-08
 */
public class MainSim {
	public static void main(String[] args) {
		EventQueue events = new EventQueue();
		MarketState state = new MarketState();
		View view = new View(state);
		
		Simulator Market = new Simulator(view, events, state);
		Market.start();
	}
}
