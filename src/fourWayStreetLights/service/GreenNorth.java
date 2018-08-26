package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for North Direction with Green Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class GreenNorth implements StartStateImpl{

	StretLightsContext stN;

	public GreenNorth(StretLightsContext st) {
		stN = st;
	}
  int numberOfCars = 0;
  

  public void addCar(int car){
	  stN.north = stN.north + car;
	  stN.res.storeNewResult(car + " Cars Added to North");
	  stN.res.storeNewResult(car + " Cars Added to North");
  }

  public void removeCar(){

    if(stN.north>=2){
    	stN.north-=2;
    	Logger.writeMessage("Signal was green so two cars removed from North",Logger.DebugLevel.GreenNorth);
    	stN.res.storeNewResult("Signal was green so two cars removed from North");
    }
    else if(stN.north==1){
    	stN.north=0;
    	stN.res.storeNewResult("Signal was green so remaining one car removed from North");
    	Logger.writeMessage("Signal was green so remaining one car removed from North",Logger.DebugLevel.GreenNorth);
    }
    else{
    	stN.res.storeNewResult("Signal was green but there was no car on North");
    	Logger.writeMessage("Signal was green but there was no car on North",Logger.DebugLevel.GreenNorth);
    }
    
    stN.light = "RED";


  }

}
