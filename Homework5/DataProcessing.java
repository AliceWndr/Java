package hu.bce.pm.hw5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class DataProcessing {

	private static final String SEPARATOR = ",";

	public static void main(String[] args) throws IOException {

		// Read
		File data = new File("C:\\Users\\Aliz\\Desktop\\Java_ws\\indicator-data.csv");
		FileReader fileReader = new FileReader(data);
		BufferedReader fileBufferedReader = new BufferedReader(fileReader);

		String line = fileBufferedReader.readLine();
		line = fileBufferedReader.readLine(); // skip header
		
		List<Trade> records = new ArrayList<>();
		
		while (line != null) {
			String[] fieldsOfRecord = line.split(SEPARATOR);
			for (int i = 0; i < fieldsOfRecord.length; i++) { // removing double quotes
				fieldsOfRecord[i] = fieldsOfRecord[i].replace("\"", "");
			}
			String country = fieldsOfRecord[0];
			if (country.length() == 3) { // filtering out aggregated records (such as EU, OECD)
				
				// getting fields
				int year = Integer.parseInt(fieldsOfRecord[5]);
				String measureType = fieldsOfRecord[3];
				double measureValue = Double.parseDouble(fieldsOfRecord[6]);
				boolean estimated;
				if (fieldsOfRecord.length==8) {
					estimated = true;
				} else {
					estimated = false;
				}
				
				// instantiation
				String subject = fieldsOfRecord[2];
				if (subject.equals("EXP")) {
					records.add(new Export(country, year, measureType, measureValue, estimated));
				} else {
					records.add(new Import(country, year, measureType, measureValue, estimated));
				}
				
			}
			
			line = fileBufferedReader.readLine();
		}

		fileBufferedReader.close();
		
		
		///////
		
		int countAll = 0;
		int countEst = 0;
		for ( Trade rec : records) {
			countAll +=1;
			if (rec.isEstimated()){
				countEst += 1;
				}
		}
		
		System.out.println(countAll);
		System.out.println(countEst);
		
		///////
			
			
		Map<String, Double> biggestTrade = new HashMap<>();
		Map<String, Double> biggestImport = new HashMap<>();
		Map<String, Double> sumExport = new HashMap<>();
		
		for ( Trade rec : records){
		if (rec.getMeasureType().equals("MLN_USD")) {
				
			String country = rec.getCountry();
			double measureValue = rec.getMeasureValue();
			
			// biggest trade
			if (!biggestTrade.containsKey(country)) {
				biggestTrade.put(country, measureValue);
			} else if (biggestTrade.get(country) < measureValue) {
				biggestTrade.replace(country, measureValue);
			}
			
			// biggest import
			if (rec instanceof Import) {
				
				if (!biggestImport.containsKey(country)) {
					biggestImport.put(country, measureValue);
				} else if (biggestImport.get(country) < measureValue) {
					biggestImport.replace(country, measureValue);
				}
			
			}
			
			// sum of export
			if (rec instanceof Export) {
				
				if (!sumExport.containsKey(country)) {
					sumExport.put(country, measureValue);
				} else {
					sumExport.replace(country, sumExport.get(country)+ measureValue);
				}
				
			}
			
		}
		}
		

/*		// Write
		File output = new File("C:\\Users\\Aliz\\Desktop\\Java_ws\\biggestImp.txt");
		FileWriter fw = new FileWriter(output);
		BufferedWriter bufferedFileWriter = new BufferedWriter(fw);
		for (Map.Entry<String, Double> entry : biggestImport.entrySet()) {
		    String key = entry.getKey();
		    Double value = entry.getValue();
			bufferedFileWriter.write(key + " " + value);
			bufferedFileWriter.newLine();
		}
		bufferedFileWriter.close();*/
		
	}

	
	
}
