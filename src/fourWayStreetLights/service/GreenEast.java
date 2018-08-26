package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;

/**
* <h1>A class representing a state for East Direction with Green Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class GreenEast implements StartStateImpl {
	static StretLightsContext stN;

	public GreenEast(StretLightsContext st) {
		stN = st;
	}

	int numberOfCars = 0;

	public void addCar(int car) {
		stN.east = stN.east + car;
		stN.res.storeNewResult(car + " Cars Added to East");
		Logger.writeMessage(car + " Cars Added to East",Logger.DebugLevel.GreenEast);
	}

	public void removeCar() {
		
		if (stN.east >= 2) {
			stN.east -= 2;
			stN.res.storeNewResult("Signal was green so two cars removed from East");
			Logger.writeMessage("Signal was green so two cars removed from East",Logger.DebugLevel.GreenEast);
		} else if (stN.east == 1) {
			stN.east = 0;
			Logger.writeMessage("Signal was green so remaining one car removed from East",Logger.DebugLevel.GreenEast);
			stN.res.storeNewResult("Signal was green so remaining one car removed from East");
		} else {
			Logger.writeMessage("Signal was green but there was no car on East",Logger.DebugLevel.GreenEast);
			stN.res.storeNewResult("Signal was green but there was no car on East");
		}
		stN.light = "RED";

	}

}
