package Lab5;

import Lab5.Event.CloseEvent;
import Lab5.Event.EndEvent;
import Lab5.Event.StartEvent;
import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;
import Lab5.View.View;

import java.util.Random;

public class Optimize {
    Random rand = new Random();
    int kassor  = 2;
    int maxCustomers = 5;
    double arrivalSpeed = 1;
    double P_min = 0.5;
    double P_max = 1;
    double B_min = 2;
    double B_max = 3;
    int seed = 1234;
    int closeTime = 10;


    public static void main(String[] args) {
        Optimize optimize = new Optimize();


    }
    public Optimize(){
        seedOptimze();
        System.out.println("Max Customers, M\t"+ maxCustomers);
        System.out.println("Ankomsthastighet,A\t "+ arrivalSpeed);
        System.out.println("Plocktid,[P_min..P_max]\t"+ P_min +"\t"+P_max);
        System.out.println("Betaltid,[B_min..B_max]\t"+ B_min +"\t"+B_max);
        System.out.println("frö,f\t"+ seed);
        System.out.println("StängningsTid\t" + closeTime);
        System.out.println("Minst kassor \t" + this.seedOptimze());
    }


    public MarketState simSetup(int kassor){
        EventQueue events = new EventQueue();
        MarketState state = new MarketState(kassor,maxCustomers,arrivalSpeed,P_min,P_max,B_min,B_max,seed);
        View view = new View(state);
        StartEvent startEvent = new StartEvent(0,events,state);
        events.addEvent(startEvent);
        CloseEvent closeEvent = new CloseEvent(closeTime,events,state);
        events.addEvent(closeEvent);
        EndEvent endEvent = new EndEvent(999,events,state);
        events.addEvent(endEvent);
        Simulator Market = new Simulator(view, events, state);
        Market.start();
        return state;
    }

    public int kassaOptimze(){
        seed = rand.nextInt();
        int lost;
        int lastcashiers = 0;
        int kassor = maxCustomers / 2;
        while (kassor != lastcashiers) {
            lost = simSetup(kassor).getMissedCustomers();
            lastcashiers = kassor;
            if (lost > 0) {
                kassor += kassor / 2;
            } else {
                kassor -= kassor / 2;
            }
            kassor = kassor == 0 ? 1 : kassor;
        }
        return kassor;
    }

    public int seedOptimze(){
        int minstaKassor = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            int nuvarandeMinKassor = kassaOptimze();
            if( nuvarandeMinKassor> minstaKassor){
                minstaKassor = nuvarandeMinKassor;
                i = 0;
            }
        }
        return minstaKassor;
    }
}
