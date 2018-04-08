package com.test.parking;

import com.test.parking.Car.Position;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class ParkingNavigatorTest extends TestCase {

	ParkingNavigator navigator;

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 * @return
	 */
	public ParkingNavigatorTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ParkingNavigatorTest.class);
	}

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		super.setUp();
		navigator = new ParkingNavigator();
	}

	/**
	 * Test Invalid boundryConditions
	 * 
	 */

	public void testBoundryConditionZero() {
		try {
			navigator.startParking(0, 0, "FFFFFFFFFFFFF");
			assertTrue(false);
		} catch (ParkingNavigatorException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	/**
	 * Test Invalid boundryConditions
	 * 
	 */

	public void testBoundryConditionUpper() {
		try {
			navigator.startParking(67, 16, "FFFFFFFFFFFFF");
			assertTrue(false);
		} catch (ParkingNavigatorException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	/**
	 * Test Invalid boundryConditions
	 * 
	 */

	public void testBoundryConditionNegetive() {
		try {
			Position p = navigator.startParking(-5, -8, "FFFFFFFFFFFFF");
			assertTrue(false);
		} catch (ParkingNavigatorException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	/**
	 * Test null direction
	 * 
	 */

	public void testNullNavigationDirection() {
		try {
			Position p = navigator.startParking(5, 5, null);
			assertTrue(false);
		} catch (ParkingNavigatorException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}

	}

	/**
	 * Test Invalid Direction
	 * 
	 */

	public void testInvalidDirection() {
		try {
			Position p = navigator.startParking(5, 5, "FFFFFFFFSS");
			assertTrue(false);
		} catch (ParkingNavigatorException e) {
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}

	}
	
	/**
	 * Test Invalid boundryConditions
	 * 
	 */

	public void testValidDirection() {
		try {
			Position position =null;
			position = navigator.startParking(5, 5, "RFLFRFLF");
			assertEquals(position.getPosX(), 7);
			assertEquals(position.getPosY(), 7);
			
			position = navigator.startParking(6, 6, "FFLFFLFFLFF");
			assertEquals(position.getPosX(), 6);
			assertEquals(position.getPosY(), 6);
			
			position = navigator.startParking(5, 5, "FLFLFFRFFF");
			assertEquals(position.getPosX(), 1);
			assertEquals(position.getPosY(), 4);
			
			//FFRFFRLLFF
			position = navigator.startParking(3, 4, "FFRLLFFLLFF");
			assertEquals(position.getPosX(), 3);
			assertEquals(position.getPosY(), 6);
			
			position = navigator.startParking(5, 5, "FFRBBRFFLFF");
			assertEquals(position.getPosX(), 5);
			assertEquals(position.getPosY(), 5);
		} catch (ParkingNavigatorException e) {
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(false);
		}

	}


}
