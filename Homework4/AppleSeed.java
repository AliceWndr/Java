package hu.bce.pm.hw4;

public class AppleSeed {

    private boolean hasSprouted;

    public AppleSeed() {
        hasSprouted = false;
    }
    
    public AppleTree water() {
        if(!hasSprouted){
            hasSprouted = true;
            return new AppleTree();
        }
        return null;
    }
    
}
