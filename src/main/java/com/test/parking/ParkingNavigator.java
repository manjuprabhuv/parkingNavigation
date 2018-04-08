package com.test.parking;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.test.parking.Car.Position;

/**
 * Cars are placed on a 15 by 15 grid at particular co-ordinates heading north,
 * and the simple commands Left, right and forward are transmitted to them. The
 * commands must be executed and the final position calculated. The following
 * examples should be used to demonstrate your code: For the input
 * "5,5:RFLFRFLF" We should get the position "7,7" For the input
 * "6,6:FFLFFLFFLFF" We should get the position "6,6" For the input
 * "5,5:FLFLFFRFFF" We should get the position "4,1"
 *
 */
public class ParkingNavigator {
	
	private static final Logger LOGGER = Logger.getLogger( ParkingNavigator.class.getName() );

	public static final String NAV_COMMAND_PATTERN = "^[FBRL]+$";
	public static final int BOUNDRY_X = 15;
	public static final int BOUNDRY_Y = 15;

	public Position startParking(int posX, int posY, String direction) throws ParkingNavigatorException {
		LOGGER.log(Level.INFO, "Entering startParking method");
		checkNavigationDirection(direction);
		Car car = new Car(posX, posY);

		char[] chars = direction.toCharArray();
		for (int i = 0; i < chars.length; i++) {

			switch (chars[i]) {
			case 'R':
				car.turnRight();
				break;
			case 'L':
				car.turnLeft();
				break;
			case 'F':
				car.moveForward();
				break;
			case 'B':
				car.moveBack();
				break;
			default:
				break;
			}

		}
		LOGGER.log(Level.INFO, "End startParking method");
		return car.getCurrentPosition();

	}

	private void checkNavigationDirection(String direction) throws ParkingNavigatorException {
		try {
			direction = direction.toUpperCase();
		} catch (NullPointerException e) {
			LOGGER.severe("No direction provided");
			throw new ParkingNavigatorException("No direction provided");
		}

		Pattern r = Pattern.compile(NAV_COMMAND_PATTERN);
		Matcher m = r.matcher(direction);
		if (!m.matches()) {
			LOGGER.severe("Invalid direction provided");
			throw new ParkingNavigatorException("Invalid direction provided");
		}

	}
}
