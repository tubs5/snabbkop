package Lab5;

import Lab5.Event.CloseEvent;
import Lab5.Event.EndEvent;
import Lab5.Event.StartEvent;
import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;
import Lab5.View.View;

import java.util.Random;

public class Optimize2 {
    Random rand = new Random();
	int maxCustomers = 10;
	double arrivalSpeed = 2;
	double P_min = 0.5;
	double P_max = 1;
	double B_min = 2;
	double B_max = 3;
	int closeTime = 100;


    public static void main(String[] args) {
    	new Optimize2();


    }
    public Optimize2(){
        seedOptimize();
    	//kassaOptimize(12390);
    }


    public MarketState simSetup(int kassor, int seed){
        EventQueue events = new EventQueue();
        MarketState state = new MarketState(kassor,maxCustomers,arrivalSpeed,P_min,P_max,B_min,B_max,seed);
       // View view = new View(state);
        StartEvent startEvent = new StartEvent(0,events,state);
        events.addEvent(startEvent);
        CloseEvent closeEvent = new CloseEvent(closeTime,events,state);
        events.addEvent(closeEvent);
        EndEvent endEvent = new EndEvent(999,events,state);
        events.addEvent(endEvent);
        Simulator Market = new Simulator(null, events, state);
        Market.start();
        return state;
    }
    public int kassaOptimize(int seed){
    	
    	int bestkassor = 1;
    	//int missedc = simSetup(bestkassor, seed).getMissedCustomers();
    	
        for (int i = 0; i < 100; i++) {
        	//System.out.println("Kör kassor," + simSetup(bestkassor-i).getKassor() + "  " +simSetup(bestkassor).getKassor() + " Missed c is" + missedc);
        	if (simSetup(bestkassor+i, seed).getMissedCustomers()<simSetup(bestkassor, seed).getMissedCustomers()) {
        		//missedc = simSetup(bestkassor+i, seed).getMissedCustomers();
        		bestkassor++;
        		
        	}
        }
        System.out.println("Best kassor för seed " + seed + " is " + bestkassor);
        return bestkassor;
    }

    public int seedOptimize(){
    	int bestseed = 0;
    	int bestkassor = kassaOptimize(123);
        for (int i = 0; i < 100; i++) {
        	
        	int tempseed = rand.nextInt();
        	//System.out.println(tempseed + "  " +kassaOptimize(bestseed) + " > " + kassaOptimize(tempseed));
        	if(kassaOptimize(bestseed)>kassaOptimize(tempseed)) {
        		bestseed = tempseed;
        	} else if (bestseed == 0) {
        		bestseed = rand.nextInt();
        	}
            
        }
        System.out.println("Best seed är " + bestseed + " med " + bestkassor + " kassor");
        return bestseed;
    }
}
