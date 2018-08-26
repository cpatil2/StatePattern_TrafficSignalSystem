package fourWayStreetLights.service;

import fourWayStreetLights.service.StartStateImpl;
import fourWayStreetLights.util.FileProcessor;
import fourWayStreetLights.util.Logger;
import fourWayStreetLights.util.Results;

/**
 * This is Context class which is interacted by Driver class 
 * It maintains the current state of the application
 * According to input string read it forwards calls to appropriate state
 * @author Chetan
 * 
 */

public class StretLightsContext {

	StartStateImpl currentState;
	public Results res;
	String direction;
	String light;
	int newcarsToAdd;
	int east = 0;
	int west = 0;
	int south = 0;
	int north = 0;
	StartStateImpl greenEast;
	StartStateImpl greenWest;
	StartStateImpl greenNorth;
	StartStateImpl greenSouth;
	StartStateImpl redEast;
	StartStateImpl redWest;
	StartStateImpl redNorth;
	StartStateImpl redSouth;

	public StretLightsContext() {
		Logger.writeMessage("In StretLightsContext constructor", Logger.DebugLevel.StretLightsContext);

		// Initializing all substates in each Direction State

		greenEast = new GreenEast(this);
		greenWest = new GreenWest(this);
		greenNorth = new GreenNorth(this);
		greenSouth = new GreenSouth(this);
		redEast = new RedEast(this);
		redWest = new RedWest(this);
		redNorth = new RedNorth(this);
		redSouth = new RedSouth(this);

		// Before Any userInput
		direction = "NORTH";
		light = "RED";
		newcarsToAdd = 0;
	}

	public void read(String fileName) {

		// Read data from input file using utility class FileProcessor
		// and then pass it to the context class
		FileProcessor FP = new FileProcessor(fileName);
		String line;
		while ((line = FP.readLine()) != null) {
			Logger.writeMessage("Reading one line", Logger.DebugLevel.StretLightsContext);
			setUserInput(line);
		}
	}

	private void setUserInput(String userInput) {
		Logger.writeMessage("Parsing line", Logger.DebugLevel.StretLightsContext);
		int flag = 0;
		String[] words = userInput.split(" ");
		if (words[0].equals("ADD")) {
			direction = words[1];
			newcarsToAdd = Integer.parseInt(words[2]);
			flag = 1;

		} else {
			direction = words[0];
			light = words[1];
			flag = 0;
		}
		
		switch (direction) {
		case "NORTH":
			if (light.equals("GREEN")) {
				Logger.writeMessage("Setting current State to Green north", Logger.DebugLevel.StretLightsContext);
				currentState = greenNorth;
			}else {
				Logger.writeMessage("Setting current State to Red north", Logger.DebugLevel.StretLightsContext);
				currentState = redNorth;
			}
				
			break;

		case "SOUTH":
			if (light.equals("GREEN")) {
				currentState = greenSouth;
				Logger.writeMessage("Setting current State to Green south", Logger.DebugLevel.StretLightsContext);
			}else {
				currentState = redSouth;
				Logger.writeMessage("Setting current State to Red south", Logger.DebugLevel.StretLightsContext);
			}
				
			break;

		case "EAST":
			if (light.equals("GREEN")) {
				Logger.writeMessage("Setting current State to green east", Logger.DebugLevel.StretLightsContext);
				currentState = greenEast;
			}
				
			else {
				Logger.writeMessage("Setting current State to red east", Logger.DebugLevel.StretLightsContext);
				currentState = redEast;
			}
				
			break;
		case "WEST":
			if (light.equals("GREEN")) {
				Logger.writeMessage("Setting current State to Green west", Logger.DebugLevel.StretLightsContext);
				currentState = greenWest;
			}else {
				Logger.writeMessage("Setting current State to red west", Logger.DebugLevel.StretLightsContext);
				currentState = redWest;
			}
				
			break;
		}

		if (flag == 1) {
			addCar(newcarsToAdd);
		} else {
			removeCar();
		}

	}

	public void addCar(int newcarsToAdd) {
		Logger.writeMessage("Calling add car method for current state", Logger.DebugLevel.StretLightsContext);
		currentState.addCar(newcarsToAdd);
	}

	public void removeCar() {
		Logger.writeMessage("Calling remove car method for current state", Logger.DebugLevel.StretLightsContext);
		currentState.removeCar();
	}

}
