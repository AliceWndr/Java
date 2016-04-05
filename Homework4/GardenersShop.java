package hu.bce.pm.hw4;

public class GardenersShop {
    
    public final static int MAPLE_PRICE = 5;
    public final static int PLUM_PRICE = 3;
    
    public AppleSeed sellAppleSeed(Gardener gardener) {
        if(gardener.getMoney() >= MAPLE_PRICE){
            gardener.setMoney(gardener.getMoney()-MAPLE_PRICE);
            return new AppleSeed();
        }
        return null;
    }
    
    public PlumSeed sellPlumSeed(Gardener gardener) {
        if(gardener.getMoney() >= PLUM_PRICE){
            gardener.setMoney(gardener.getMoney()-PLUM_PRICE);
            return new PlumSeed();
        }
        return null;
    }

}
