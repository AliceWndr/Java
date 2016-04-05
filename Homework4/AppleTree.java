package hu.bce.pm.hw4;
import java.util.ArrayList;

public class AppleTree {
    
    private int waterTimes;
    
    public AppleTree() {
    	waterTimes = 0;
    }

    public void water() {
        waterTimes++;
    }
    
    public ArrayList<AppleSeed> harvest() {
    	ArrayList<AppleSeed> mapleSeeds = new ArrayList<AppleSeed>();
        for (int i = 0; i < waterTimes; i++) {
            mapleSeeds.add(new AppleSeed());
        }
        waterTimes = waterTimes/2;
        return mapleSeeds;
    }
    
}
