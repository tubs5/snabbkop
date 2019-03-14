package Lab5.Event;

import Lab5.Queue.EventQueue;
import Lab5.State.Customer;
import Lab5.State.FIFO;
import Lab5.State.MarketState;

/**
 * This event simulates a customer picking up an item
 * 
 * @author Victor Longberg, Tobias Heidlund Simon Lundberg och Klas Mannberg
 */
public class PickupEvent extends Event{
    private Customer customer;
    private MarketState marketState;
    
    /**
     * This is the PickupEvent constructor
     * 
     * @param startTime A double
     * @param queue An EventQueue
     * @param marketState A MarketState
     * @param customer A Customer
     */
    public PickupEvent(double startTime, EventQueue queue, MarketState marketState, Customer customer) {
        super(startTime, queue);
        this.customer = customer;
        this.marketState = marketState;
    }
    
    /**
     * This method executes the event
     */
    @Override
    public void ExecuteEvent() {
        marketState.getTime().setTime(startTime);
        marketState.observable(this);
        if (marketState.getActiveKassor() < marketState.getKassor()){
            marketState.addActiveKassa();
            PayEvent payEvent = new PayEvent(marketState.getTime().getNextPayTime(),queue,marketState,customer);
            queue.addEvent(payEvent);
        }else{
            marketState.getFIFO().add(customer);
            marketState.addQueueingCustomers();
        }


    }
    /**
     * This method returns the start time
     * 
     * @return The start time
     */
    @Override
    public double getStartTime() {
        return startTime;
    }
    /**
     * This method returns the Customer
     * 
     * @return The Customer
     */
    public Customer getCustomer(){
        return customer;
    }
}
