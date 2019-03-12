package Lab5.State;
import java.util.Random;

public class RandomStream {
	
	public class ExponentialRandomStream {
	    
	    private Random rand;
	    private double lambda;
	      
	    public ExponentialRandomStream(double lambda, long seed) {
	          rand = new Random(seed);
	          this.lambda = lambda;
	    }
	      
	    public ExponentialRandomStream(double lambda) {
	        rand = new Random();
	        this.lambda = lambda;
	    }
	      
	    public double next() {
	          return -Math.log(rand.nextDouble())/lambda;
	    }
	}


	public class UniformRandomStream {

	    private Random rand;
	    private double lower, width;
	    
	    public UniformRandomStream(double lower, double upper, long seed) {
	        rand = new Random(seed);
	        this.lower = lower;
	        this.width = upper-lower;
	    }
	    
	    public UniformRandomStream(double lower, double upper) {
	        rand = new Random();
	        this.lower = lower;
	        this.width = upper-lower;
	    }
	    
	    public double next() {
	        return lower+rand.nextDouble()*width;
	    }
	}
	
	public int returnRandom() {
		
	}
}
