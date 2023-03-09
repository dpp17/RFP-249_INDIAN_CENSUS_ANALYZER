package indianstatecensusanalyzer.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;

import indianstatecensusanalyzer.exceptions.SelfMadeRuntimeCustomExceptions;
import indianstatecensusanalyzer.model.IndianCensusData;
import indianstatecensusanalyzer.utility.ExceptionType;

public class StateCensusAnalyser {

	private static Scanner option = new Scanner(System.in);
    public static ArrayList<IndianCensusData> indianCensusList = new ArrayList<IndianCensusData>();

    private static void createFile(File file) {
    	try {
			if(file.createNewFile()) {
				System.out.println("  ---->>>>  File Created  <<<<---- ");
			}else {
				System.out.println("  :: File Already Exists ::");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static int loadCensusData(String filePath) throws Exception {
        try {
            indianCensusList = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> data = reader.readAll();
            data.stream().forEach(n -> {
                Iterator<String> iterate = Arrays.stream(n).iterator();
                String state = iterate.next();
                String population = iterate.next();
                String areaInSqKm = iterate.next();
                String densityPerSqKm = iterate.next();
                if (!population.equals("Population"))
                    indianCensusList.add(new IndianCensusData(state, Long.parseLong(population), Long.parseLong(areaInSqKm), Integer.parseInt(densityPerSqKm)));
            });
            reader.close();
        } catch (FileNotFoundException e) {
            throw new SelfMadeRuntimeCustomExceptions(e.getMessage(), ExceptionType.File_Not_Found);
        } catch (IllegalStateException e) {
            throw new SelfMadeRuntimeCustomExceptions(e.getMessage(), ExceptionType.Parse_Error);
        }
        return indianCensusList.size();
    }
    public static void main(String[] args) throws Exception {
		
    	final String filePath = "StateCensus.csv";
    	File file = new File(filePath);
    	
    	switch (option.nextByte()) {
		case 1:
			createFile(file);
			break;
		case 2:
			loadCensusData(filePath);
			break;
		case 3:
	
			break;

		default:
		}
    	
    	
	}
}