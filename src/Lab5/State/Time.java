package Lab5.State;

public class Time {
	
	private double timeStarted;
	private double timeNow;
	
	public double calculateTime() {
		return (timeNow-timeStarted);
	}
}
