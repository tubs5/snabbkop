package Lab5.State;

/**
 * Creates random times for events
 * 
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 *
 */
public class Time {

	private double time;
	private UniformRandomStream pickupTime;
	private UniformRandomStream payTime;
	private ExponentialRandomStream arrivalSpeed;

	/**
	 * The Time constructor
	 * 
	 * @param state A MarketState
	 */
	public Time(MarketState state) {
		//These uses the randomizers to get values
		this.pickupTime = new UniformRandomStream(state.getP_min(), state.getP_max(), state.getSeed());
		this.payTime = new UniformRandomStream(state.getB_min(), state.getB_max(), state.getSeed());
		this.arrivalSpeed = new ExponentialRandomStream(state.getArrivalSpeed(), state.getSeed());

	}
	
	/**
	 * This method sets the time
	 * 
	 * @param time A double
	 */
	public void setTime(double time) {
		this.time = time;
	}
	
	/**
	 * This method gets the time
	 * 
	 * @return the time
	 */
	public double getTime() {
		return time;
	}
	
	/**
	 * This method gets the next pickup time
	 * 
	 * @return the next pickup time
	 */
	public double getNextPickupTime() {
		return time + pickupTime.next();
	}
	
	/**
	 * This method gets the next paytime
	 * 
	 * @return the next paytime
	 */
	public double getNextPayTime() {
		return time + payTime.next();
	}
	
	/**
	 * This method gets the next customer time
	 * 
	 * @return The next customer time
	 */
	public double getNextCustomer() {
		return time + arrivalSpeed.next();
	}

}
