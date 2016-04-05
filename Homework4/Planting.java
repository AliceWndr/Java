package hu.bce.pm.hw4;
import java.util.ArrayList;

public class Planting {

    public static void main(String[] args) {
    	// PARAMETERS:
    	
    	int nrOfYears = 5;
    	int wateringPerYear = 4;     // per each tree
    	int seedsBoughtPerYear = 2;  // of each seed type
    	double probOfPlumWorm = 0.5;
    	
    	// SIMULATION:

        Gardener gardener = new Gardener("Peti");
        gardener.setMoney(60);
        GardenersShop shop1 = new GardenersShop();

        ArrayList<AppleSeed> appleSeeds = new ArrayList<AppleSeed>();
        ArrayList<AppleTree> appleTrees = new ArrayList<AppleTree>();
        ArrayList<PlumSeed> plumSeeds = new ArrayList<PlumSeed>();
        ArrayList<PlumTree> plumTrees = new ArrayList<PlumTree>();
        
        for (int year = 0; year < nrOfYears; year++) { 
        	
	        // 1. buying the seeds
        	int a = 0;
        	int p = 0;
	        for (int purchase = 0; purchase < seedsBoughtPerYear; purchase++) {
	        	AppleSeed purchAppleSeed = gardener.buyAppleSeed(shop1);
	        	PlumSeed purchPlumSeed = gardener.buyPlumSeed(shop1);

	        	if (purchAppleSeed != null) {
	        		appleSeeds.add(purchAppleSeed);
	        		a++;
	        	}
	        	if (purchPlumSeed != null) {
	        		plumSeeds.add(purchPlumSeed);
	        		p++;
	        	}
	        }
	        
	        // 2. watering the seeds --> trees
	        for (AppleSeed seed : appleSeeds) {
	        	AppleTree newTree = seed.water();
	        	appleTrees.add(newTree);
	        }
	        appleSeeds.clear();
	        
	        for (PlumSeed seed : plumSeeds) {
	        	PlumTree newTree = seed.water();
	        	if (newTree != null) {
	        		plumTrees.add(newTree);
	        	}
	        }
	        plumSeeds.clear();
	        
	        // 3. watering the trees + harvesting
	        for (AppleTree tree : appleTrees) {
		        for (int watering = 0; watering < wateringPerYear; watering++) {
		        	tree.water();
		        }
		        appleSeeds.addAll(tree.harvest());
	        }
	        
	        for (PlumTree tree : plumTrees) {
		        for (int watering = 0; watering < wateringPerYear; watering++) {
		        	tree.water();
		        }
		        plumSeeds.addAll(tree.harvest(probOfPlumWorm));
	        }
	        
	        // 4. How many worms?
	        int worms = 0;
	        for (PlumSeed seed : plumSeeds) {
	        	if (seed.hasWorm()) {worms++;}
	        }
	        
	        // Outcome:
	        System.out.println("Year " + (year+1) + ":" );
	        System.out.println("Purchased seeds: apple - " + a + ", plum - " + p);
	        System.out.println("Number of apple trees:  " + appleTrees.size());
	        System.out.println("Number of apple seeds harvested: " + appleSeeds.size());
	        System.out.println("Number of plum trees:  " + plumTrees.size());
			System.out.println("Number of plum seeds harvested: " + plumSeeds.size() + " (" + worms + " of them has a worm)");
	        System.out.println();
	        
        }
	}
    
}
