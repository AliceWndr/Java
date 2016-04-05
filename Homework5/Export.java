package hu.bce.pm.hw5;

public class Export extends Trade {
	// stores a specific export measure
	
	public Export(String country, int year, String measureType, double measureValue, boolean estimated) {
		super(country, year, measureType, measureValue, estimated);
	}

}
