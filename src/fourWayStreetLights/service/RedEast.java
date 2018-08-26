package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for East Direction with Red Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class RedEast implements StartStateImpl {

	StretLightsContext stN;

	public RedEast(StretLightsContext st) {
		stN = st;
	}

	int numberOfCars = 0;

	public void addCar(int car) {
		stN.east = stN.east + car;
		stN.res.storeNewResult(car + " Cars Added to east ");
		Logger.writeMessage(car + " Cars Added to east ",Logger.DebugLevel.RedEast);
	}

	public void removeCar() {

	}

}
