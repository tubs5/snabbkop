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
 * @version 0
 * @since 2019-03-08
 */
public class optimize {
	public static void main(String[] args) {
		int kassor  = 2;
		int maxCustomers = 7;
		double arrivalSpeed = 3;
		double P_min = 0.6;
		double P_max = 0.9;
		double B_min = 0.35;
		double B_max = 0.6;
		int seed = 13;
	}
	
	/**
	 * This method runs a simulation with fixed parameters and then returns the end state.
	 * 
	 * @return The end state
	 */
	MarketState one(int kassor, int maxCustomers, double arrivalSpeed, double P_min, double P_max, double B_min, double B_max, int seed) {
	
		EventQueue events = new EventQueue();
		MarketState state = new MarketState(kassor,maxCustomers,arrivalSpeed,P_min,P_max,B_min,B_max,seed);

        StartEvent startEvent = new StartEvent(0,events,state);
		events.addEvent(startEvent);

		CloseEvent closeEvent = new CloseEvent(8,events,state);
		events.addEvent(closeEvent);

		Simulator Market = new Simulator(null, events, state);
		Market.start();
		
		return state;
		
	}
	
	//Work in progress
	public int two(int maxCustomers, double arrivalSpeed, double P_min, double P_max, double B_min, double B_max, int seed) {
		int best = one(0, maxCustomers, arrivalSpeed, P_min, P_max, B_min, B_max, seed).getMissedCustomers();
		int idealKass = 0;
		for(int i = 1; i < 100; i++ ) {
			int j = one(i, maxCustomers, arrivalSpeed, P_min, P_max, B_min, B_max, seed).getMissedCustomers();
			if (j < best) {
				best = j;
				idealKass = i; 
			}
			
		}
		
		
		return 0; //Temporary
	}

	void three() {
		
	}
}
