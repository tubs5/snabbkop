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
	state.addTotalUnqueueTime();
		int id = 0;
		String open = (state.getStore()) ? "Ö" : "S";
		//double qtime = 0;
		//double stime = 0;
		// beroende på typ av event behövs olika medelanden,
		if (arg1 instanceof ArriveEvent) {
			ArriveEvent event = (ArriveEvent) arg1;
			action = "Ankomst";
			id = event.getCustomer().getID();
			//qtime = event.getCustomer().getTimeReturnQueue();
			//stime = event.getCustomer().getTimeReturnStore();
			double time = ((double)((int)(state.getTime().getTime()*100)))/100;
			double timeb = ((double)((int)(state.getTotalUnqueueTime()*100)))/100;
			double timec = ((double)((int)(state.getTotalQueueTime()*100)))/100;


			System.out.println(time + " \t " + action +"\t "+id + " \t "+ open+ " \t " + (state.getKassor() - state.getActiveKassor())+ " \t " + timeb + " \t " + state.getCurrentCustomers() + " \t " + state.getCompletedCustomers()+" \t "+ state.getMissedCustomers()+" \t " + state.getQueueingCustomers() + " \t "+ timec + " \t " + state.getFIFO().getSize() +" \t "+ state.getFIFO().toString());

		} else if (arg1 instanceof PayEvent) {
			PayEvent event = (PayEvent) arg1;
			action = "Betalning";
			id = event.getCustomer().getID();
			//qtime = event.getCustomer().getTimeReturnQueue();
			//stime = event.getCustomer().getTimeReturnStore();
			double time = ((double)((int)(state.getTime().getTime()*100)))/100;
			double timeb = ((double)((int)(state.getTotalUnqueueTime()*100)))/100;
			double timec = ((double)((int)(state.getTotalQueueTime()*100)))/100;
			

			System.out.println(time + " \t " + action +" \t "+id +" \t "+ open+ " \t " + (state.getKassor() - state.getActiveKassor())+ " \t " + timeb + " \t " + state.getCurrentCustomers() + " \t " + state.getCompletedCustomers()+" \t "+ state.getMissedCustomers()+" \t " + state.getQueueingCustomers() + " \t "+ timec + " \t " + state.getFIFO().getSize() +" \t "+ state.getFIFO().toString());

		} else if (arg1 instanceof PickupEvent) {
			PickupEvent event = (PickupEvent) arg1;
			action = "Plock";
			id = event.getCustomer().getID();
			//qtime = event.getCustomer().getTimeReturnQueue();
			//stime = event.getCustomer().getTimeReturnStore();

		} else if (arg1 instanceof CloseEvent) {
			//CloseEvent event = (CloseEvent) arg1;
			double a = state.getTime().getTime();
			double time = ((double)((int)(a*100)))/100;
			action = "Close";
			System.out.println(time +" \t " + action);
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
		//System.out.println("0,00" +" " + "Start");
	}
/**
 * Endprint
 */
	public void end() {
		System.out.println("");
		System.out.println("RESULTAT");
		System.out.println("==========");
		System.out.println("1) Av " + (state.getMissedCustomers()+state.getCompletedCustomers()) + " kunder behandlades " + state.getCompletedCustomers()
				+ " medans " + state.getMissedCustomers() + " kunder missades");
		System.out.println("2) Total ledig tid från " + state.getKassor() + " kassor blev " + state.getTimeWasted()
				+ ". Genomsnittlig ledig tid per kassa blev " + state.getTimeWasted() / state.getKassor());
		System.out.println("3) Total kötid för " + state.getMaxCustomers() + " kunder blev " + state.getTotalQueueTime()
				+ ". Genomsnittlig kötid blev " + state.getTotalQueueTime() / (state.getMissedCustomers()+state.getCompletedCustomers()));

	}



}
