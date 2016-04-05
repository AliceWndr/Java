package hu.bce.pm.hw4;

public class PlumSeed {

    private boolean hasSprouted;
    private boolean hasWorm;

    public PlumSeed() {
        hasSprouted = false;
        hasWorm = false;
    }
    
    public PlumTree water() {
        if(!hasSprouted && !hasWorm){
            hasSprouted = true;
            return new PlumTree();
        }
        return null;
    }
    
    public void wormify() {
    	hasWorm = true;
    }
    
    public boolean hasWorm() {
    	return hasWorm;
    }
	
}