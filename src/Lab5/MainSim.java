package Lab5;

import Lab5.Event.CloseEvent;
import Lab5.Event.StartEvent;
import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;
import Lab5.View.View;

/**
 * Creates new simulation
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg.
 * @version 1.1
 * @since 2019-03-08
 */
public class MainSim {
	public static void main(String[] args) {
		int kassor  = 10;
		int maxCustomers = 10;
		double arrivalSpeed = 2;
		double P_min = 3;
		double P_max = 5;
		double B_min = 3;
		double B_max = 4;
		int seed = 1234;

	
		EventQueue events = new EventQueue();
		MarketState state = new MarketState(kassor,maxCustomers,arrivalSpeed,P_min,P_max,B_min,B_max,seed);
		View view = new View(state);
		state.addObserver(view);

        StartEvent startEvent = new StartEvent(0,events,state);
		events.addEvent(startEvent);

		CloseEvent closeEvent = new CloseEvent(2000,events,state);
		events.addEvent(closeEvent);

		Simulator Market = new Simulator(view, events, state);
		Market.start();
	}
}
