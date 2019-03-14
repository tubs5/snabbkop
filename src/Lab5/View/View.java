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
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg.
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
		this.state = (MarketState) update;
	}
/**
 * 
 */
	@Override
	public void update(Observable o, Object arg1) {
	String action = "Start";

		int id = 0;
		String open = (state.getStore()) ? "Ö" : "S";
		double time = ((double)((int)(state.getTime().getTime()*100)))/100;
		double timenoqueue = ((double)((int)(state.getTotalUnqueueTime()*100)))/100;
		double timequeue = ((double)((int)(state.getTotalQueueTime()*100)))/100;
		
		//double qtime = 0;
		//double stime = 0;
		// beroende på typ av event behövs olika medelanden,
		if (arg1 instanceof ArriveEvent) {
			ArriveEvent event = (ArriveEvent) arg1;
			id = event.getCustomer().getID();
			action = "Ankomst";
			System.out.println(time + " \t " + action +"\t "+id + " \t "+ open+ " \t " + (state.getKassor() - state.getActiveKassor())+ " \t " + timenoqueue + " \t " + state.getCurrentCustomers() + " \t " + state.getCompletedCustomers()+" \t "+ state.getMissedCustomers()+" \t " + state.getQueueingCustomers() + " \t "+ timequeue + " \t " + state.getFIFO().getSize() +" \t "+ state.getFIFO().toString());

		} else if (arg1 instanceof PayEvent) {
			PayEvent event = (PayEvent) arg1;
			id = event.getCustomer().getID();
			action = "Betalning";
			System.out.println(time + " \t " + action +" \t "+id +" \t "+ open+ " \t " + (state.getKassor() - state.getActiveKassor())+ " \t " + timenoqueue + " \t " + state.getCurrentCustomers() + " \t " + state.getCompletedCustomers()+" \t "+ state.getMissedCustomers()+" \t " + state.getQueueingCustomers() + " \t "+ timequeue + " \t " + state.getFIFO().getSize() +" \t "+ state.getFIFO().toString());

		} else if (arg1 instanceof PickupEvent) {
			PickupEvent event = (PickupEvent) arg1;
			id = event.getCustomer().getID();
			action = "Plock";
			System.out.println(time + " \t " + action +" \t  \t "+ id +" \t " + open+ " \t " + (state.getKassor() - state.getActiveKassor())+ " \t " + timenoqueue + " \t " + state.getCurrentCustomers() + " \t " + state.getCompletedCustomers()+" \t "+ state.getMissedCustomers()+" \t " + state.getQueueingCustomers() + " \t "+ timequeue + " \t " + state.getFIFO().getSize() +" \t "+ state.getFIFO().toString());
		} else if (arg1 instanceof CloseEvent) {
			//CloseEvent event = (CloseEvent) arg1;
			action = "Close";
			System.out.println(time + " \t " + action +" \t \t "+"---" +" \t "+ open+ " \t " + (state.getKassor() - state.getActiveKassor())+ " \t " + timenoqueue + " \t " + state.getCurrentCustomers() + " \t " + state.getCompletedCustomers()+" \t "+ state.getMissedCustomers()+" \t " + state.getQueueingCustomers() + " \t "+ timequeue + " \t " + state.getFIFO().getSize() +" \t "+ state.getFIFO().toString());
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
		System.out.println("Tid \t Händelse \t Kund \t Öppet \t LedKas  LedKaT  Kunder  CKund   MKund   KKunder TKötid  KöL     Kö");
		System.out.println("0.00" +" " + " \t Start");
	}
/**
 * Endprint
 */
	public void end() {
		//double time = ((double)((int)(state.getTotalQueueTime() / (state.getMissedCustomers()+state.getCompletedCustomers())*100)))/100;
		double timequeue = ((double)((int)(state.getTotalQueueTime()*100)))/100;
		double timenoqueue = ((double)((int)((state.getTotalUnqueueTime())*100)))/100;
		double timequeueavg =((double)((int)((timequeue/state.getQueueingCustomers())*100)))/100;
		double timenoqueueavg = ((double)((int)((timenoqueue/state.getKassor())*100)))/100;
		System.out.println("");
		System.out.println("RESULTAT");
		System.out.println("==========");
		System.out.println("1) Av " + (state.getMissedCustomers()+state.getCompletedCustomers()) + " kunder behandlades " + state.getCompletedCustomers()
				+ " medans " + state.getMissedCustomers() + " kunder missades");
		System.out.println("2) Total ledig tid från " + state.getKassor() + " kassor blev " + timenoqueue
				+ ". Genomsnittlig ledig tid per kassa blev " + timenoqueueavg);
		System.out.println("3) Total kötid för " + state.getQueueingCustomers() + " kunder blev " + timequeue
				+ ". Genomsnittlig kötid blev " + timequeueavg) ;

	}



}
