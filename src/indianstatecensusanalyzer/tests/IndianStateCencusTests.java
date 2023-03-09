package indianstatecensusanalyzer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import indianstatecensusanalyzer.controller.StateCensusAnalyser;
import indianstatecensusanalyzer.exceptions.SelfMadeRuntimeCustomExceptions;

public class IndianStateCencusTests {

	 private static final String INDIA_CENSUS_CSV_FILE_PATH = "IndianCensusStateData.csv";
	    public StateCensusAnalyser analyser;
	 private static final String INDIAN_CSV_STATE_PATH = "IndianCensusStateData.csv";


	    @Test
	    public void returnSize() throws Exception {
	        try {
	        	assertEquals(29, analyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }

	    
	    ///////////////////////////////shouldExecuteProperly_IfRecordsAreEqual///////////////////
	    @Test
	    public void loadCensusDataTestOne() throws Exception {
	        try {
	            assertEquals(29, analyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }

	    /////////////////////shouldReturnRecordsif_CSVFileIsDetected///////////////////////
	    @Test
	    public void loadCensusDataTestTwo() throws Exception {
	        try {
	            assertEquals(29, analyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }

	    ///////////////////////shouldReturnCustomException_ifDelimiterIncorrect/////////////////////////
	    @Test
	    public void loadCensusDataTestThree() throws Exception {
	        try {
	            assertEquals(29, analyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }
	    
	    ///////////////////////////shouldReturCustomException_ifCSVHeaderIncorrect///////////////////////////
	    @Test
	    public void loadCensusDataTestFour() throws Exception {
	        try {
	            assertEquals(29, analyser.loadCensusData(INDIA_CENSUS_CSV_FILE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }


//State

	    ////////////////////////////returnSizeState//////////////////////////
	    @Test
	    public void loadStateDataOne() throws Exception {
	        try {

	            assertEquals(37, analyser.loadStateData(INDIAN_CSV_STATE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }

	    ///////////////////////////////shouldExecuteProperly_IfRecordsAreEqualState///////////////////
	    @Test
	    public void loadStateDataTwo() throws Exception {
	        try {
	            assertEquals(37, analyser.loadStateData(INDIAN_CSV_STATE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }
	    
	    //////////////////////////////shouldReturnRecordsif_CSVFileIsDetectedState//////////////////////
	    @Test
	    public void loadStateDataThree() throws Exception {
	        try {
	            assertEquals(37, analyser.loadStateData("xyz.csv"));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }

	    ////////////////////////////shouldReturnCustomException_ifDelimiterIncorrectState/////////////////
	    @Test
	    public void loadStateDataFour() throws Exception {
	        try {

	            assertEquals(37, analyser.loadStateData(INDIAN_CSV_STATE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }

	    /////////////////////////////////shouldRetureCustomException_ifCSVHeaderIncorrectState///////////////
	    @Test
	    public void loadStateDataFive() throws Exception {
	        try {
	            assertEquals(37, analyser.loadStateData(INDIA_CENSUS_CSV_FILE_PATH));
	        } catch (SelfMadeRuntimeCustomExceptions e) {
	            e.printStackTrace();
	        }
	    }
}
