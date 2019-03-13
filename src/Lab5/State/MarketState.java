package Lab5.State;
/**
 * 
 * @author Simon Lundberg
 *
 */
public class MarketState extends SimState{
	
		private int currentCustomers = 0;
		private int maxCustomers;
		private double lastCheckedUnqueTime = 0;
		private boolean emergencyStop = false;
		private int kassor;
		private int activeKassor= 0;
		private boolean isOpen = false;
		private int completedCustomers = 0;
		private int missedCustomers = 0;
		private int queueingCustomers = 0;
		private Time time;
		private double timeWasted = 0;
		private double totalQueueTime = 0;
		private double totalUnqueueTime = 0;
		private double arrivalSpeed;
		private double P_min;
		private double P_max;
		private double b_min;
		private double b_max;
		private int seed;
		private FIFO f;



		public MarketState(int kassor,int maxCustomers,double arrivalSpeed, double P_min, double P_max,
						   double b_min, double b_max, int seed){
			this.kassor = kassor;
			this.maxCustomers = maxCustomers;
			this.seed = seed;
			this.b_min = b_min;
			this.b_max = b_max;
			this.P_max = P_max;
			this.P_min = P_min;
			this.arrivalSpeed = arrivalSpeed;
			f = new FIFO();
			time = new Time(this);
		}

		/**
		 * This method returns the time
		 *
		 * @return The time
		 */
		public Time getTime() {
			return time;
		}

		/**
		 * This method returns the FIFO queue.
		 * 
		 * @return The FIFO queue f.
		 */
		public FIFO getFIFO() {
			return f;
			
		}
		
		
		/**
		 * This method returns the current amount of customers
		 * 
		 * @return The amount of customers.
		 */
		public int getCurrentCustomers() {
			return currentCustomers;
		}
		
		
		/**
		 * This method sets the current amount of customers.
		 * 
		 * @param i An integer
		 */
		public void setCurrentCustomers(int i) {
			currentCustomers = i;
		}
		
		/**
		 * This method adds a current customer
		 * 
		 */
		public void removeCurrentCustomers() {
			currentCustomers--;
		}
		
		
		/**
		 * This method adds a current customer
		 * 
		 */
		public void addCurrentCustomers() {
			currentCustomers++;
		}
		
		/**
		 * This method returns the maximum amount of customers
		 * 
		 * @return maximum amount of customers
		 */
		public int getMaxCustomers() {
			return maxCustomers;
		}
		
		

		
		
		/**
		 * This method triggers an emergency stop.
		 * 
		 */
		public void emergencyStop() {
			emergencyStop = true;
		}
		
		
		/**
		 * This method returns the amount of checkouts.
		 * 
		 * @return the amount of checkouts
		 */
		public int getKassor() {
			return kassor;
		}
		


		
		
		/**
		 * This method adds an active checkout.
		 * 
		 */
		public void addActiveKassa() {
			activeKassor++;
		}
		
		
		/**
		 * This method removes an active checkout.
		 * 
		 */
		public void removeActiveKassa() {
			activeKassor--;
		}
		
		
		/**
		 * This method returns the active amount of checkouts
		 * 
		 * @return number of active checkouts.
		 */
		public int getActiveKassor() {
			return activeKassor;
		}
		/**
		 * This method returns the total amount of time spent in queues.
		 * 
		 * @return The total queue time
		 */
		public double getTotalQueueTime() {
			return totalQueueTime;
		}
		
		
		/**
		 * This method add the total amount of time spent in queues.
		 * 
		 * @param d A double
		 */
		public void addTotalQueueTime(double d) {
			totalQueueTime += d;
		}
		
		
		/**
		 * This method gets the total amount of time the checkouts were open but not in use 
		 * 
		 * @return the total "unqueue time"
		 */
		public double getTotalUnqueueTime() {
			return totalUnqueueTime;
		}
		
		
		/**
		 * This method add the total amount of time the checkouts were open but not in use
		 *
		 */
		public void addTotalUnqueueTime() {

			double timechecked = time.getTime()-lastCheckedUnqueTime;
			lastCheckedUnqueTime = time.getTime();
			totalUnqueueTime += timechecked*(kassor-activeKassor);
		}



		/**
		 * This method returns the total amount of time wasted.
		 * 
		 * @return amount of time wasted.
		 */
		public double getTimeWasted() {
			return timeWasted;
		}
		
		
		/**
		 * This method sets the total amount of time wasted.
		 * 
		 * @param d A double
		 */
		public void setTimeWasted(double d) {
			timeWasted = d;
		}
		
		/**
		 * This method returns the amount of missed customers.
		 * 
		 * @return Amount of missed customers.
		 */
		public int getMissedCustomers() {
			return missedCustomers;
		}

		
		/**
		 * This method adds a missed customer. 
		 * 
		 */
		public void addMissedCustomers() {
			missedCustomers++;
		}
		
		/**
		 * This method return the amount of completed customers.
		 * 
		 * @return amount of completed customers.
		 */
		public int getCompletedCustomers() {
			return completedCustomers;
		}
		
		

		
		/**
		 * This method adds a completed customer.
		 * 
		 */
		public void addCompletedCustomers() {
			completedCustomers++;
		}
		
		
		/**
		 * This method removes a completed customer.
		 * 
		 */
		public void removeCompletedCustomers() {
			completedCustomers--;
		}
		
		
		/**
		 * This method gets the amount of queueing customers
		 * 
		 * @return The amount of queueing customers
		 */
		public int getQueueingCustomers() {
			return queueingCustomers;
		}
		
		
		/**
		 * This method sets the amount of queueing customers
		 * 
		 * @param i An integer
		 */
		public void setQueueingCustomers(int i) {
			queueingCustomers = i;
		}
		
		
		/**
		 * This method adds a queueing customer
		 * 
		 */
		public void addQueueingCustomers() {
			queueingCustomers++;
		}
		
		
		/**
		 * This method removes a queueing customer
		 * 
		 */
		public void removeQueueingCustomers() {
			queueingCustomers--;
		}
		
		/**
		 * This method opens the store
		 * 
		 */
		public void openStore() {
			isOpen = true;
		}
		
		
		/**
		 * This method closes the store.
		 * 
		 */
		public void closeStore() {
			isOpen = false;
		}
		
		
		/**
		 * This method checks if the store is open or closed
		 * 
		 * @return The open/close state of the store
		 */
		public boolean getStore() {
			return isOpen;
		}
		
		/**
		 * This method returns the arrival speed.
		 * 
		 * @return The arrival speed
		 */
		public double getArrivalSpeed() {
			return arrivalSpeed;
		}
		
		/**
		 * This method returns the minimum pick time.
		 * 
		 * @return Minimum pick time.
		 */
		public double getP_min() {
			return P_min;
		}
		
		/**
		 * This method returns the maximum pick time.
		 * 
		 * @return Maximum pick time.
		 */
		public double getP_max() {
			return P_max;
		}
		
		/**
		 * This method returns the minimum paying time.
		 * 
		 * @return Minimum paying time.
		 */
		public double getB_min() {
			return b_min;
		}
		
		/**
		 * This method returns the maximum paying time.
		 * 
		 * @return Maximum paying time.
		 */
		public double getB_max() {
			return b_max;
		}
		
		/**
		 * This method returns the seed.
		 * 
		 * @return The seed
		 */
		public int getSeed() {
			return seed;
		}
}
