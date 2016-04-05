package hu.bce.pm.hw5;

public class Import extends Trade {
	// stores a specific import measure 
	
	public Import(String country, int year, String measureType, double measureValue, boolean estimated){
		super(country, year, measureType, measureValue, estimated);
	}

}
