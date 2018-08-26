package fourWayStreetLights.service;

import fourWayStreetLights.util.Logger;


/**
* <h1>A class representing a state for South Direction with Green Signal </h1>
*
*
* @author  Chetan Patil
* @version 1.0
* @since   2018-08-07
*/

public class GreenSouth implements StartStateImpl {

	StretLightsContext stN;

	public GreenSouth(StretLightsContext st) {
		stN = st;
	}

	int numberOfCars = 0;

	public void addCar(int car) {
		stN.south = stN.south + car;
		Logger.writeMessage(car + " Cars Added to South", Logger.DebugLevel.GreenSouth);
		stN.res.storeNewResult(car + " Cars Added to South");
	}

	public void removeCar() {

		if (stN.south >= 2) {
			stN.south -= 2;
			Logger.writeMessage("Signal was green so two cars removed from South", Logger.DebugLevel.GreenSouth);
			stN.res.storeNewResult("Signal was green so two cars removed from South");

		} else if (stN.south == 1) {
			stN.south = 0;
			Logger.writeMessage("Signal was green so remaining one car removed from South",
					Logger.DebugLevel.GreenSouth);
			stN.res.storeNewResult("Signal was green so remaining one car removed from South");

		} else {
			Logger.writeMessage("Signal was green but there was no car on South", Logger.DebugLevel.GreenSouth);
			stN.res.storeNewResult("Signal was green but there was no car on South");
		}

		stN.light = "RED";

	}

}
