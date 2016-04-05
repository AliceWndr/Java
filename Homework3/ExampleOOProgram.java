package hu.bce.pm.hw3;

import java.io.IOException;

public class ExampleOOProgram {

    public static void main(String[] args) throws IOException {
        // A simple test application for our classes

        // This is a verbose way now to define an array of Person in our case
        Person aladar = new Person("Nagy", "Aladar", 24, 23.2);
        Person bela = new Person("Kis", "Bela", 25, 50.0);
        Person conrad = new Person("Bernath", "Conrad", 31, 123.2);
        Person tulaj = new Person("xx", "yy", 31, 123.2);
        
        Person[] people = new Person[3];
        people[0] = aladar;
        people[1] = bela;
        people[2] = conrad;
        
        
        System.out.println("Osszesen " + people.length + " embert tartunk szamon:");
        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            System.out.println(person.getFullName()+ ", " +
            				   person.getAge() + " years, " +
            				   person.getCash() + " dollars");
        }

        System.out.println();
        
        System.out.println(aladar.getCash());
        System.out.println(aladar.earnCash(5.2));
        System.out.println(aladar.getCash());
        System.out.println(aladar.spendCash(30));
        System.out.println(aladar.getCash());
        
        
        
        int maxAccounts = 3;
        Bank myBank = new Bank("Erste", tulaj, maxAccounts);

        for (int i = 0; i < people.length; i++) {
            Person person = people[i];
            boolean isAccountOpened = myBank.openAccount(person);
            System.out.println(person.getFullName() +" szamlanyitasa sikerult: " + isAccountOpened);
            if(isAccountOpened){
                person.deposit(myBank, 10);
            }
        }
        
        System.out.println(myBank.getMoneyOfBank());
        
        System.out.println(bela.deposit(myBank, 32.0));
        
        System.out.println(myBank.getAccount(bela).getAmount());
        System.out.println(myBank.getAccount(conrad).getAmount());
        System.out.println(bela.getCash());
        System.out.println(myBank.getMoneyOfBank());
        System.out.println(bela.getCash());
        System.out.println(myBank.getOpenedAccounts());
        System.out.println(myBank.closeAccount(bela));
        System.out.println(bela.getCash());
        
        System.out.println(myBank.getMoneyOfBank());
        System.out.println(myBank.getAccount(aladar).getAmount());
        System.out.println(myBank.getAccount(aladar).getAmount());
        System.out.println(myBank.getOpenedAccounts());
        System.out.println(myBank.openAccount(bela));
        System.out.println(bela.deposit(myBank, 5));
        System.out.println(bela.withdraw(myBank, 2));
        System.out.println(myBank.closeAccount(aladar));
        System.out.println(myBank.openAccount(aladar));
        System.out.println(conrad.deposit(myBank, 4));
       
//        for (Account acc : myBank.getAccounts()){
//        	if (acc != null){
//        			System.out.print(acc.getAmount()+ " ");
//        			System.out.println(acc.getOwner().getFullName());
//        	}
//        }
        
        System.out.println(conrad.getCash());
        System.out.println(bela.getCash());
        System.out.println(aladar.getCash());
        System.out.println(myBank.getMoneyOfBank());
        
        
        System.out.println(467.0/900.0*Math.pow(1.1, 3));

    }

}
