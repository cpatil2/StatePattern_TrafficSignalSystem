package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for South Direction with Red Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class RedSouth implements StartStateImpl{

	StretLightsContext stN;

	public RedSouth(StretLightsContext st) {
		stN = st;
	}
  int numberOfCars = 0;
  

  public void addCar(int car){
    stN.south=stN.south + car;
    stN.res.storeNewResult(car + " Cars Added to South");
    Logger.writeMessage(car + " Cars Added to South",Logger.DebugLevel.RedSouth);
  }

  public void removeCar(){
	  
  }

}
