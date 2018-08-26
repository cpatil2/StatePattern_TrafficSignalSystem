package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for West Direction with Red Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class RedWest implements StartStateImpl {

	StretLightsContext stN;

	public RedWest(StretLightsContext st) {
		stN = st;
	}

	int numberOfCars = 0;

	public void addCar(int car) {
		stN.west = stN.west + car;
		stN.res.storeNewResult(car + " Cars Added to west");
		Logger.writeMessage(car + " Cars Added to west",Logger.DebugLevel.RedWest);
		
	}

	public void removeCar() {

	}

}
