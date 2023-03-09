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
import indianstatecensusanalyzer.model.StateCSV;
import indianstatecensusanalyzer.utility.ExceptionType;

public class StateCensusAnalyser {

	private static Scanner option = new Scanner(System.in);
    public static ArrayList<IndianCensusData> indianCensusList = new ArrayList<IndianCensusData>();
    public static List<StateCSV> stateCodeList = new ArrayList<>();
    public static int i = 0;
    
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
    

    public static int loadStateData(String filePath) throws Exception {
        try {
            i = 0;
            stateCodeList = new ArrayList<>();
            CSVReader reader = new CSVReader(new FileReader(filePath));
            List<String[]> data = reader.readAll();
            data.stream().forEach(n -> {
                Iterator<String> iterate = Arrays.stream(n).iterator();
                String srNo = iterate.next();
                String state = iterate.next();
                String TIN = iterate.next();
                String stateCode = iterate.next();
                if (i == 0)
                    i = 1;
                else
                    stateCodeList.add(new StateCSV(Integer.valueOf(srNo), state, Integer.valueOf(TIN), stateCode));
            });
            reader.close();
        } catch (FileNotFoundException e) {
            throw new SelfMadeRuntimeCustomExceptions(e.getMessage(), ExceptionType.File_Not_Found);
        } catch (IllegalStateException e) {
            throw new SelfMadeRuntimeCustomExceptions(e.getMessage(), ExceptionType.Parse_Error);
        }
        return stateCodeList.size();
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
    	
    	System.out.println("Press 1: create file"+'\n'+"Press 2: Load CensusData"+'\n'+"Press 3:load State Data");
    	switch (option.nextByte()) {
		case 1:
			createFile(file);
			break;
		case 2:
			loadCensusData(filePath);
			break;
		case 3:
			loadStateData(filePath);
			break;
		default:
		}
    	
    	
	}
}