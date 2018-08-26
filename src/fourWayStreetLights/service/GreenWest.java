package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for West Direction with Green Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class GreenWest implements StartStateImpl {
	StretLightsContext stN;

	public GreenWest(StretLightsContext st) {
		stN = st;
	}

	int numberOfCars = 0;

	public void addCar(int car) {
		stN.west = stN.west + car;
		stN.res.storeNewResult(car + " Cars Added to west");
		Logger.writeMessage(car + " Cars Added to west", Logger.DebugLevel.GreenWest);
	}

	public void removeCar() {

		if (stN.west >= 2) {
			stN.west -= 2;
			Logger.writeMessage("Signal was green so two cars removed from west", Logger.DebugLevel.GreenWest);
			stN.res.storeNewResult("Signal was green so two cars removed from west");

		} else if (stN.west == 1) {
			stN.west = 0;
			Logger.writeMessage("Signal was green so remaining one car removed from West", Logger.DebugLevel.GreenWest);
			stN.res.storeNewResult("Signal was green so remaining one car removed from West");

		} else {
			Logger.writeMessage("Signal was green but there was no car on West", Logger.DebugLevel.GreenWest);
			stN.res.storeNewResult("Signal was green but there was no car on West");
		}

		stN.light = "RED";

	}

}
