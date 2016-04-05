package hu.bce.pm.hw3;

public class Person {

    // Unmodifiable fields, assigned values upon object creation (the name of the person cannot be changed)
    private final String surname;
    private final String firstname;

    // Fields that are modifiable
    private int age;
    private double cash;
    
    public Person(String surname, String firstname, int age, double cash) {
        this.surname = surname;
        this.firstname = firstname;
        this.age = age;
        this.cash = cash;
    }

    public String getSurname() {
        return surname;
    }
    
    public String getFirstname() {
        return firstname;
    }
        
    public int getAge() {
        return age;
    }
    
    public double getCash() {
    	return cash;
    }
    
    public String getFullName() { // szarmaztatott ertekek, ne taroljuk valtozokent
        String fullName = firstname + " " + surname;
    	return fullName;
    }
    
    public void incrAge(int years) {
    	age += years;
    }
    
    public boolean earnCash(double value) {
    	cash += value;
    	return true;
    }
    
    public boolean spendCash(double value) {
    	if (cash >= value){
    		cash -= value;
    		return true;
    	} else {
    		System.out.println("You cannot spend more than " + cash + " dollars! "
    				+ "No change in cash.");
    		return false;
    	}
    }

    public boolean deposit(Bank myBank, double amount) {
        // * Check if this user has an account at the given bank
        // * Check if the amount given is a non-negative integer
        // * Check if the user has enough cash to deposit
        // * Add the money to the account
        // * Subtract the amount from the cash
        // * return true upon success
    	Account myAccount = myBank.getAccount(this);
    	if (myAccount != null
    	    && amount >= 0
    	    && (amount % 1) == 0
    	    && this.getCash() >= amount)
    	{	
    		this.spendCash(amount);
    		myAccount.modifyAmountBy(amount);
    		return true;
    	} else {
    		return false;
    	}

    }
    
    public boolean withdraw(Bank myBank, double amount) {
        // * Check if this user has an account at the given bank
        // * Check if the amount given is a non-negative integer
        // * Check that money on account >= amount
        // * Subtract the money to the account
        // * Add the amount from the cash
        // * return true upon success
    	Account myAccount = myBank.getAccount(this);
    	if (myAccount != null
    	    && amount >= 0
    	    && (amount % 1) == 0
    	    && myAccount.getAmount() >= amount)
    	{
    		this.earnCash(amount);
    		myAccount.modifyAmountBy(-amount);
    		return true;
    	} else {
    		return false;
    	}
    }

}
