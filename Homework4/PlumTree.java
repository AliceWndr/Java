package hu.bce.pm.hw4;
import java.util.ArrayList;
import java.util.Random;

public class PlumTree {

    private int waterTimes;
    
    public PlumTree() {
    	waterTimes = 0;
    }

    public void water() {
        waterTimes++;
    }
    
    public ArrayList<PlumSeed> harvest(double prob) {
    	ArrayList<PlumSeed> plumSeeds = new ArrayList<PlumSeed>();
        for (int i = 0; i < waterTimes; i++) {
        	PlumSeed newSeed = new PlumSeed();
        	
        	Random r = new Random();
        	if (r.nextDouble() < prob) {
        		newSeed.wormify();
        	}
        	
            plumSeeds.add(newSeed);
        }
        waterTimes = waterTimes/2;
        return plumSeeds;
    }
    
}
