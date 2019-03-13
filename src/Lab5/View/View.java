package Lab5.View;

import java.util.Observable;

import Lab5.Event.ArriveEvent;
import Lab5.Event.CloseEvent;
import Lab5.Event.PayEvent;
import Lab5.Event.PickupEvent;
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
/**
 * 
 */
	public void update(Observable arg0, Object arg1) {
		String action = null;
		int id = 0;
		//double qtime = 0;
		//double stime = 0;

		// beroende på typ av event behövs olika medelanden,
		if (arg1 instanceof ArriveEvent) {
			ArriveEvent event = (ArriveEvent) arg1;
			action = "Ankomst";
			id = event.getCustomer().getID();
			//qtime = event.getCustomer().getTimeReturnQueue();
			//stime = event.getCustomer().getTimeReturnStore();

		} else if (arg1 instanceof PayEvent) {
			PayEvent event = (PayEvent) arg1;
			action = "Betalning";
			id = event.getCustomer().getID();
			//qtime = event.getCustomer().getTimeReturnQueue();
			//stime = event.getCustomer().getTimeReturnStore();

		} else if (arg1 instanceof PickupEvent) {
			PickupEvent event = (PickupEvent) arg1;
			action = "Plock";
			id = event.getCustomer().getID();
			//qtime = event.getCustomer().getTimeReturnQueue();
			//stime = event.getCustomer().getTimeReturnStore();

		} else if (arg1 instanceof CloseEvent) {
			//CloseEvent event = (CloseEvent) arg1;
			action = "Close";
			System.out.println(action);
		}
		if (!(arg1 instanceof CloseEvent)) {
			System.out.println(state.getTime() + " " + action + " " +id + state.getStore()+ "" + state.getActiveKassor()+ " " + state.getTotalUnqueueTime() + " " + state.getCurrentCustomers() + " " + state.getCompletedCustomers()+" "+ state.getMissedCustomers()+" " + state.getQueueingCustomers() + " "+ state.getTotalQueueTime() + " " + state.getFIFO().getSize() +" "+ state.getFIFO().toString());
		}

	}
/**
 * Startprint
 */
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
		System.out.println("Tid  Händelse  Kund  Öppet  LedKas  LedKasT  Kunder  CompKunder  MissKunder  KöKunder  TotKötid  KöLängd  Kö");
		System.out.println(state.getTime() +" " + "Start");
	}
/**
 * Endprint
 */
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
