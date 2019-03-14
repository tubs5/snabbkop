package Lab5;

import Lab5.Event.CloseEvent;
import Lab5.Event.EndEvent;
import Lab5.Event.StartEvent;
import Lab5.Queue.EventQueue;
import Lab5.State.MarketState;
import Lab5.View.View;

import java.util.Random;

/**
 * Optimizes the amount of kassor som behövs
 *
 * @author Victor Longberg, Tobias Heidlund, Simon Lundberg och Klas Mannberg
 */
public class Optimize {


    Random rand = new Random();
    private int maxCustomers = 5;
    private double arrivalSpeed = 1;
    private double P_min = 0.5;
    private double P_max = 1;
    private double B_min = 2;
    private double B_max = 3;
    private int seed = 1234;
    private int closeTime = 10;
    private int missade;


    public static void main(String[] args) {
        Optimize optimize = new Optimize();


    }

    //runs optimisation
    public Optimize(){
        seedOptimze();
        System.out.println("Max Customers, M\t"+ maxCustomers);
        System.out.println("Ankomsthastighet,A\t "+ arrivalSpeed);
        System.out.println("Plocktid,[P_min..P_max]\t"+ P_min +"\t"+P_max);
        System.out.println("Betaltid,[B_min..B_max]\t"+ B_min +"\t"+B_max);
        System.out.println("frö,f\t"+ seed);
        System.out.println("StängningsTid\t" + closeTime);
        System.out.println("Minst kassor \t" + this.seedOptimze());
        System.out.println("missade kunder \t"+ missade);
    }


    //sets up the simulations
    private MarketState simSetup(int kassor,int seed){
        EventQueue events = new EventQueue();
        MarketState state = new MarketState(kassor,maxCustomers,arrivalSpeed,P_min,P_max,B_min,B_max,seed);
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

    //runs the optimisations for kassor
    private int kassaOptimze(int seed){
        int gap = maxCustomers/2;
        int kassor = maxCustomers;
        missade = benchmark(seed);
        int missadeCurr;

         while (true){
             missadeCurr = simSetup(kassor,seed).getMissedCustomers();
             if(gap > 1) {

                     if (missade < missadeCurr) {
                         kassor = kassor + gap;
                         gap = gap/2;
                     } else {
                         kassor = kassor - gap;
                         gap = gap/2;
                     }
             }else {
                 if (missadeCurr == missade){
                     if(simSetup(kassor-1,seed).getMissedCustomers()>missade){
                         return kassor;
                     }else {
                         kassor--;
                     }
                 }else if(missadeCurr  > missade){
                     kassor++;
                 }
             }


         }
    }



    private int benchmark(int seed) {
        return simSetup(maxCustomers,seed).getMissedCustomers();
    }


    //finds the best amount of kassor for several seeds
    public int seedOptimze(){
        int minstaKassor = 1;
        for (int i = 0; i < 10; i++) {
            int nuvarandeMinKassor = kassaOptimze(seed);
            if( nuvarandeMinKassor> minstaKassor){
                minstaKassor = nuvarandeMinKassor;
                i = 0;
            }
        }
        return minstaKassor;
    }
}
