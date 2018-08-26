package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for North Direction with Red Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class RedNorth implements StartStateImpl{

	StretLightsContext stN;

	public RedNorth(StretLightsContext st) {
		stN = st;
	}
  int numberOfCars = 0;
  

  public void addCar(int car){
	  stN.north = stN.north + car;
	  stN.res.storeNewResult(String.valueOf(car) + " Cars Added to North");
	  Logger.writeMessage(String.valueOf(car) + " Cars Added to North",Logger.DebugLevel.RedNorth);
  }

  public void removeCar(){
	  
  }

}
