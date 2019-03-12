package Lab5.View;

import java.util.Observable;

import Lab5.Event.ArriveEvent;
import Lab5.Event.PayEvent;
import Lab5.State.MarketState;
import Lab5.State.SimState;

/**
 * Prints start parameters, results and events
 * 
 * @author Klas Mannberg
 * @version 0.9
 * @since 2019-03-08
 * 
 */
public class View extends SimView {

	private MarketState state;

	/**
	 * View gets called with a state parameter and sets super class variable with
	 * constructor
	 * 
	 * @param update
	 */
	public View(SimState update) {
		super(update);
	}

	public void update(Observable arg0, Object arg1) {
	
		//beroende på typ av event behövs olika medelanden, 
		//eller så kan eventen ha en getstring metod som jag kan ta ut här
		if (event is arrive) {
			ArriveEvent arrive = (ArriveEvent) arg1;
			String action = "Ankomst";
			arrive.getCustomer().getID();
			arrive.getCustomer().getTimeReturnQueue();
			arrive.getCustomer().getTimeReturnStore();
			System.out.println(state.getTime() + " " + arg1 +);
		} else if (event is pay) {
			PayEvent arrive = (PayEvent) arg1;
			String action = "Betalning";
			arrive.getCustomer().getID();
			arrive.getCustomer().getTimeReturnQueue();
			arrive.getCustomer().getTimeReturnStore();
			System.out.println(state.getTime() + " " + arg1 +);
			
		} else if (event is pickup) {
			PayEvent arrive = (PayEvent) arg1;
			String action = "Plock";
			arrive.getCustomer().getID();
			arrive.getCustomer().getTimeReturnQueue();
			arrive.getCustomer().getTimeReturnStore();
			System.out.println(state.getTime() + " " + arg1 +);
			
		} else if (event is close) {
			
		}
	}

	public void start() {
		System.out.println("PARAMETRAR");
		System.out.println("==========");
		System.out.println("Antal kassor: " + state.getKassor());
		System.out.println("Max kunder: " + state.getMaxCustomers());
		System.out.println("Ankomsthastighet: " + state.getArrivalSpeed());
		System.out.println("MIN plocktid: " + state.getP_min());
		System.out.println("MAX Plocktid: " + state.getP_max());
		System.out.println("Slumpad seed: " + state.getSeed());
		System.out.println("");
		System.out.println("HÄNDELSER");
		System.out.println("==========");
	}

	public void end() {
		System.out.println("");
		System.out.println("RESULTAT");
		System.out.println("==========");
		System.out.println("1) Av " + state.getMaxCustomers() + " kunder behandlades " + state.getCompletedCustomers()
				+ " medans " + state.getMissedCustomers() + " kunder missades");
		System.out.println("2) Total ledig tid från " + state.getKassor() + " kassor blev " + state.getTimeWasted()
				+ ". Genomsnittlig ledig tid blev " + state.getTimeWasted() / state.getKassor());
		System.out.println("3) Total kötid för " + state.getMaxCustomers() + " kunder blev " + state.getTotalQueueTime()
				+ ". Genomsnittlig ledig tid blev " + state.getTotalQueueTime() / state.getMaxCustomers());

	}

}
