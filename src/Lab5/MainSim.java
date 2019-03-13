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
		int kassor  = 2;
		int maxCustomers = 5;
		double arrivalSpeed = 1;
		double P_min = 0.5;
		double P_max = 1.0;
		double B_min = 2;
		double B_max = 3;
		int seed = 1234;

	
		EventQueue events = new EventQueue();
		MarketState state = new MarketState(kassor,maxCustomers,arrivalSpeed,P_min,P_max,B_min,B_max,seed);
		View view = new View(state);
		state.addObserver(view);

        StartEvent startEvent = new StartEvent(0,events,state);
		events.addEvent(startEvent);

		CloseEvent closeEvent = new CloseEvent(10,events,state);
		events.addEvent(closeEvent);

		Simulator Market = new Simulator(view, events, state);
		Market.start();
	}
}
