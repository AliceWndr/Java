package hu.bce.pm.hw4;

public class Gardener {
    
    private int money;
    private String name;
    
    public Gardener(String name) {
        this.name = name;
        money = 0;
    }
    
    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
    public AppleSeed buyAppleSeed(GardenersShop shop) {
        return shop.sellAppleSeed(this);
    }
    
    public PlumSeed buyPlumSeed(GardenersShop shop) {
        return shop.sellPlumSeed(this);
    }
    
}
