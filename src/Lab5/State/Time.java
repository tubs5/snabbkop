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

	public Time(MarketState state) {
		this.pickupTime = new UniformRandomStream(state.getP_min(), state.getP_max(), state.getSeed());
		this.payTime = new UniformRandomStream(state.getB_min(), state.getB_max(), state.getSeed());
		this.arrivalSpeed = new ExponentialRandomStream(state.getArrivalSpeed(), state.getSeed());

	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getTime() {
		return time;
	}

	public double getNextPickupTime() {
		return time + pickupTime.next();
	}

	public double getNextPayTime() {
		return time + payTime.next();
	}

	public double getNextCustomer() {
		return time + arrivalSpeed.next();
	}

}
