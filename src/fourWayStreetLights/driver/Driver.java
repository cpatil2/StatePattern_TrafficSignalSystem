package fourWayStreetLights.driver;

import fourWayStreetLights.service.StretLightsContext;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;

/**
 * <h1>This is Driver class that interacts with Context class
 * @author Chetan Patil
 * @version 1.0
 * @since 2018-06-28
 */

public class Driver {


	//User defined Exception to handle abscence of any reuired runtime arguments 
	static class MissingArgumentException extends Exception {

		//private static final long serialVersionUID = 1L;
				public MissingArgumentException(String msg) {
						super(msg);
					}
	}


	public static void main(String[] args) {

		// Validate command line arguments
		try {
			if (args[0].equals("${arg0}"))
				throw new MissingArgumentException("Attention! Please provide input file name as args[0] ");
			if (args[1].equals("${arg1}"))
				throw new MissingArgumentException("Attention! Please provide output file name as args[1] ");
			if (args[2].equals("${arg2}"))
				throw new MissingArgumentException("Attention! Please provide debugLevel as args[2] ");

		} catch (MissingArgumentException MAE) {
			System.out.println(MAE.getMessage());
			System.exit(0);
		}

		int debugLevelValue = 15;
		try{
				debugLevelValue = Integer.parseInt(args[2]);
		}catch(NumberFormatException NFE){
			System.out.println("Sorry, debug level must be an integer value! Refer readme.");
			System.exit(0);
		}
		Logger.setDebugValue(debugLevelValue);
		Results results = new Results(args[1]);
		StretLightsContext SLC = new StretLightsContext();
		SLC.res = results;
		SLC.read(args[0]);

		// Get ready results to be calculated and then written to outputfile

		results.accessResultsToPrint();


	}

}
