

package fourWayStreetLights.util;


/**
* <h1> Log all your activities during execution! </h1>
* The Logger class for debugging purpose
* line by line
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class Logger{


    public static enum DebugLevel { CONSTRUCTOR, FILE_PROCESSOR,
                                    GreenEast, GreenWest, GreenSouth, GreenNorth,
                                    RedEast, RedWest, RedSouth, RedNorth, StretLightsContext, NONE
                                   };

    private static DebugLevel debugLevel;



    public static void setDebugValue (int levelIn) {
      	switch (levelIn) {
            case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
          	case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
          	case 3: debugLevel = DebugLevel.GreenEast; break;
            case 4: debugLevel = DebugLevel.GreenWest; break;
            case 5: debugLevel = DebugLevel.GreenSouth; break;
            case 6: debugLevel = DebugLevel.GreenNorth; break;
            case 7: debugLevel = DebugLevel.RedEast; break;
            case 8: debugLevel = DebugLevel.RedWest; break;
            case 9: debugLevel = DebugLevel.RedNorth; break;
            case 10: debugLevel = DebugLevel.RedSouth; break;
            case 11: debugLevel = DebugLevel.StretLightsContext; break;

          	default: debugLevel = DebugLevel.NONE; break;
      	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	       debugLevel = levelIn;
    }

    public static void writeMessage (String message, DebugLevel levelIn ) {
    	Results res = new Results();
      	if (levelIn == debugLevel)
      		res.writeToStdout(message);
    }

    public String toString() {
    	     return "The debug level has been set to the following " + debugLevel;
    }
}
