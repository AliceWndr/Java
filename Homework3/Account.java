package hu.bce.pm.hw3;

public class Account {

    private Person owner;
    private Bank bank;

    private double amount;

    public Account(Person givenOwner, Bank hostBank) {
        owner = givenOwner;
        bank = hostBank;
    	amount = 0.0;
    }

    public boolean modifyAmountBy(double value) {
        amount += value;
        return true;
    }

    public Person getOwner() {
    	return owner;
    }
    
    public Bank getBank() {
    	return bank;
    }
    
    public double getAmount() {
    	return amount;
    }
}
