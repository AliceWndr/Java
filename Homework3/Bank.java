package hu.bce.pm.hw3;

public class Bank {

    private Account[] accounts;
    private int openedAccounts;
    private String name;
    private Person owner;
    
    public Bank(String bankName, Person bankOwner, int maxAccounts){
    	name = bankName;
    	owner = bankOwner;
        accounts = new Account[maxAccounts];
        openedAccounts = 0;
    }
    
    public boolean openAccount(Person p){
        // this method, that it only adds accounts, if 
        // * the accounts array is not full AND
        // * the user has no account AND
        // * the user is at least 21 years old
        // returns true if the creation was successful
    	if(accounts.length > openedAccounts
    	   && this.getAccount(p) == null
    	   && p.getAge() >= 21){
    		
    		accounts[openedAccounts] = new Account(p, this);
    		openedAccounts += 1;
    		// megsporolhato a kovetkezo syntax-szal:
    		// accounts[openedaccounts++] = = new Account(p, this);
    		// eloszor hozzarandel, majd megnoveli a szamlalot
    		return true;
    		
    	} else {
    		return false;
    	}
    }
    
    public boolean closeAccount(Person p){
    	if (this.getAccount(p) != null){
    		
    		p.withdraw(this, this.getAccount(p).getAmount());
    		
    		for (int i = getAccountIndex(p)+1; i < accounts.length; i++) {
    			accounts[i-1] = accounts[i];
    		}
    		accounts[accounts.length-1] = null;
        	openedAccounts -= 1;
        	return true;
        	
    	} else {
    		return false;
    	}
    }
    
    public Account getAccount(Person p) {	
    	boolean found = false;
    	int i = 0;
    	Account acc = null;
    	while (i < accounts.length && !found) {
    		if (accounts[i] != null && accounts[i].getOwner() == p) {
    			found = true;
    			acc = accounts[i];
    		} else {
    			i++;
    		}
    	}
    	return acc;
    }
    
    public int getAccountIndex(Person p) {
        // returns the index of the account that belongs to the person
    	boolean found = false;
    	int i = 0;
    	int index = -1;
    	while (i < accounts.length && !found) {
    		if (accounts[i].getOwner() == p) {
    			found = true;
    			index = i;
    		} else {
    			i++;
    		}
    	}
    	return index;
    }
    
    public long getMoneyOfBank() {
    	long sum = 0;	
    	for (int i = 0; i < openedAccounts; i++) {
    			sum += (long) accounts[i].getAmount();
    	}
        return sum;
    }
    
    public int getOpenedAccounts(){
    	return this.openedAccounts;
    }
    
    public Account[] getAccounts(){
    	return this.accounts;
    }
    
    public Person getOwner() {
    	return owner;
    }
    
    public String getName() {
    	return name;
    }
}
