package Lab5.State;

public class MarketState {
	
		private int currentCustomers = 0;
		private int maxCustomers;
		
		private boolean emergencyStop = false;
		private int kassor;
		private boolean isOpen = false;
		
		private int completedCustomers;
		private int missedCustomers;
		
		private double timeWasted;
		private double totalQueueTime;
		
		private int seed;
		
		public FIFO customerQueue() {
			return null;  //Need to fix
			
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
		 * This method returns the maximum amount of customers
		 * 
		 * @return maximum amount of customers
		 */
		public int getMaxCustomers() {
			return maxCustomers;
		}
		
		
		/**
		 * This method sets the maximum amount of customers
		 * 
		 * @param i An integer
		 */
		public void setMaxCustomers(int i) {
			maxCustomers = i;
		}
		
		
		/**
		 * gets the total time of the simulation
		 * 
		 * @return total time of simulation
		 */
		public double totalTime() {
			
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
		 * This method sets the total amount of time spent in queues.
		 * 
		 * @param d A double
		 */
		public void setTotalQueueTime(double d) {
			totalQueueTime = d;
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
		 * This method sets the amount of missed customers.
		 * 
		 * @param i An integer
		 */
		public void setMissedCustomers(int i) {
			missedCustomers = i;
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
		 * This method sets the amount of completed customers.
		 * 
		 * @param i An integer
		 */
		public void setCompletedCustomers(int i) {
			completedCustomers = i;
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
		 * This method returns a generated seed
		 * 
		 * @return generated seed
		 */
		public int generateSeed() {
			
		}
}
