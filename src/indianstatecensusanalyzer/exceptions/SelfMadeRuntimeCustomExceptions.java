package indianstatecensusanalyzer.exceptions;

import indianstatecensusanalyzer.utility.ExceptionType;

public class SelfMadeRuntimeCustomExceptions extends RuntimeException {

	
	    public SelfMadeRuntimeCustomExceptions(String message, ExceptionType type) {
	        super(message);
	    }	  
	   
}
