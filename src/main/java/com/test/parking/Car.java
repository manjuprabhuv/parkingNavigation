package com.test.parking;

import java.util.logging.Logger;

public class Car {
	
	private static final Logger LOGGER = Logger.getLogger( Car.class.getName() );

	private static final int INITIAL_DIRECTION = 90;
	private static final int MOVE_INCREMENT = 1;
	private static final int TURN_ANGLE = 90;

	private int currentDirection = INITIAL_DIRECTION;

	private Position position;

	public Car(int initposX, int initposY) throws ParkingNavigatorException {
		Position position = new Position(initposX, initposY);
		this.position = position;

	}

	public void turnRight() {
		currentDirection = currentDirection + TURN_ANGLE;
		if (currentDirection >= 360) {
			currentDirection = currentDirection - 360;
		}

	}

	public void turnLeft() {
		currentDirection = currentDirection - TURN_ANGLE;
		if (currentDirection < 0) {
			currentDirection = currentDirection + 360;
		}

	}

	public void moveForward() throws ParkingNavigatorException {
		if (currentDirection == 90) {
			position.setPosY(position.getPosY() + MOVE_INCREMENT);
			// posY = posY + MOVE_INCREMENT;
		}
		if (currentDirection == 180) {
			position.setPosX(position.getPosX() + MOVE_INCREMENT);
			// posX = posX + MOVE_INCREMENT;
		}
		if (currentDirection == 270) {
			position.setPosY(position.getPosY() - MOVE_INCREMENT);
			// posY = posY - MOVE_INCREMENT;
		}
		if (currentDirection == 0) {
			position.setPosX(position.getPosX() - MOVE_INCREMENT);
			// posX = posX - MOVE_INCREMENT;
		}

	}

	public void moveBack() throws ParkingNavigatorException {

		if (currentDirection == 90) {
			position.setPosY(position.getPosY() - MOVE_INCREMENT);
			// posY = posY + MOVE_INCREMENT;
		}
		if (currentDirection == 180) {
			position.setPosX(position.getPosX() - MOVE_INCREMENT);
			// posX = posX + MOVE_INCREMENT;
		}
		if (currentDirection == 270) {
			position.setPosY(position.getPosY() + MOVE_INCREMENT);
			// posY = posY - MOVE_INCREMENT;
		}
		if (currentDirection == 0) {
			position.setPosX(position.getPosX() + MOVE_INCREMENT);
			// posX = posX - MOVE_INCREMENT;
		}

	}

	public Position getCurrentPosition() {
		return position;
	}

	public class Position {
		public Position(int posX, int posY) throws ParkingNavigatorException {
			if (posX > ParkingNavigator.BOUNDRY_X || posY > ParkingNavigator.BOUNDRY_Y || posX < 1 || posY < 1) {
				LOGGER.severe("Invalid Input. Car placed outside boundry condition");
				throw new ParkingNavigatorException("Invalid Input. Car placed outside boundry condition");
			}
			this.posX = posX;
			this.posY = posY;
		}

		private int posX;
		private int posY;

		public int getPosX() {
			return posX;
		}

		public void setPosX(int posX) throws ParkingNavigatorException {
			if (posX > ParkingNavigator.BOUNDRY_X|| posX<1) {
				LOGGER.severe("Car cannot move byond boundry!");
				throw new ParkingNavigatorException("Car cannot move byond boundry!");
			}
			this.posX = posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) throws ParkingNavigatorException {
			if (posY > ParkingNavigator.BOUNDRY_Y || posY<1) {
				LOGGER.severe("Car cannot move byond boundry!");
				throw new ParkingNavigatorException("Car cannot move byond boundry!");
			}
			this.posY = posY;
		}

	}

}
