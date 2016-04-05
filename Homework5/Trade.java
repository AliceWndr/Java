package hu.bce.pm.hw5;

public abstract class Trade {

	private String country;
	private int year;
	private String measureType;
	private double measureValue;
	private boolean estimated;
	
	Trade(String country, int year, String measureType, double measureValue, boolean estimated) {
		this.country = country;
		this.year = year;
		this.measureType = measureType;
		this.measureValue = measureValue;
		this.estimated = estimated;
	}
	
	public String getCountry() {
		return this.country;
	}

	public int getYear() {
		return this.year;
	}
	
	public  String getMeasureType() {
		return this.measureType;
	}
	
	public double getMeasureValue() {
		return this.measureValue;
	}
	
	public boolean isEstimated() {
		return this.estimated;
	}
	
	//abstract protected Seed spawnSeed(); // abstract method -> no implementation
	
}
