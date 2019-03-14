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
 
/**
package main;
import java.util.Random;

import generalDEDS.DEDS;
import generalDEDS.EventQueue;
import snabbkop.SnabbState;
import snabbkop.SnabbEvents.StartEvent;

 
public class Optimize {
	final private static int OPTIMALLOST = 5273; 
	final private static int MAXCUSTOMERS = 1400;
	final private static double LAMBDA = 2000.0;
	final private static double PICKTIME1 = 0.45;
	final private static double PICKTIME2 = 0.65;
	final private static double PAYTIME1 = 0.2;
	final private static double PAYTIME2 = 0.3;
	final private static double CLOSINGTIME = 20.00;
	final private static long SEED = 42;
	
	
	private static int runOptimal(int cashiers, long seed) {
		EventQueue eventQueue = new EventQueue();
		SnabbState state = new snabbkop.SnabbState(cashiers, Optimize.LAMBDA,
				Optimize.PICKTIME1, Optimize.PICKTIME2, Optimize.PAYTIME1,
				Optimize.PAYTIME2, Optimize.MAXCUSTOMERS, Optimize.CLOSINGTIME, seed);
		StartEvent startingEvent = new StartEvent(eventQueue);
		DEDS simulator = new DEDS(eventQueue, state);
		eventQueue.enqueue(startingEvent);
		simulator.run();
		
		return state.getNMissed();

	}
	
	private int runSim(int cashiers, long seed) {
		return runOptimal(cashiers, seed);
		
	}
	
	private int optimizeSeed(long seed) {
		int lost;
		for (int n = MAXCUSTOMERS; n > 0; n--) {
			lost = runSim(n, seed);
			if (lost > OPTIMALLOST) {
				return n + 1;
			}
		}
		return 1;
	}
	
	private int binOptimizeSeed(long seed) {
		int lost;
		int lastcashiers = 0;
		int cashiers = MAXCUSTOMERS / 2;
		while (cashiers != lastcashiers) {
			lost = runSim(cashiers, seed);
			lastcashiers = cashiers;
			if (lost > 0) {
				cashiers += cashiers / 2;
			} else {
				cashiers -= cashiers / 2;
			}
			cashiers = cashiers == 0 ? 1 : cashiers;
		}
		return cashiers;
	}
	
	private int optimizer() {
		int count = 0;
		int highest, last;
		int lastHighest;
		Random rng = new Random();
		
		highest = optimizeSeed(rng.nextLong());
		while (count < 100) {
			last = optimizeSeed(rng.nextLong());
			lastHighest = highest;	
			highest = last > highest ? last : highest;
			if (highest == lastHighest) {
				count++;
			} else {
				count = 0;
			}
		}
		return highest;
	}
	

	public static void main(String[] args) {
		Optimize opt = new Optimize();
		System.out.println("Max som ryms, M..........: " + MAXCUSTOMERS);
		System.out.println("Ankomshastighet, lambda..: " + LAMBDA);
		System.out.println("Plocktider, [P_min..Pmax]: [" + PICKTIME1 + ".." + PICKTIME2 +"]");
		System.out.println("Betaltider, [K_min..Kmax]: [" + PAYTIME1 + ".." + PAYTIME2 + "]");
		System.out.println("Fr�, f...................: " + SEED);
		System.out.println("St�ngning sker " + CLOSINGTIME + " och stoph�ndelsen sker tiden 999.0.");
		System.out.println("Minst antal kassor som ger minimalt antal missade (" + OPTIMALLOST + "): " + opt.optimizeSeed(SEED));
	}
	
	
}
*/