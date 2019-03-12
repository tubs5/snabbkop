package Lab5.State;

public class Time {
	
	private double time;
	private MarketState marketState;
	private UniformRandomStream pickupTime;
	private UniformRandomStream payTime;
	private ExponentialRandomStream arrivalSpeed;

	public Time(MarketState state){
		this.marketState = state;
		this.pickupTime = new UniformRandomStream(marketState.getP_min(),marketState.getP_max(),marketState.getSeed());
		this.payTime = new UniformRandomStream(marketState.getB_min(),marketState.getB_max(),marketState.getSeed());
		this.arrivalSpeed = new ExponentialRandomStream(marketState.getArrivalSpeed(),marketState.getSeed());

	}



	public void setTime(double time) {
		this.time = time;
	}

	public double getTime() {
		return time;
	}

	public double getNextPickupTime(){
		return time+pickupTime.next();
	}

	public double getNextPayTime(){
		return time+payTime.next();
	}

	public double getNextCustomer(){
		return time+arrivalSpeed.next();
	}


}
