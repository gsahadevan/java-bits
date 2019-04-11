package com.shaangroups.practice.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.shaangroups.practice.test.Direction;
import com.shaangroups.practice.test.Robot;

public class RobotTests {
	
	private Robot robot;
	
	@Before
	public void setUp() {
		robot = new Robot();
	}

	@Test
	public void testLeftOfNorthReturnsWest() {
		Direction expected = Direction.WEST;
		robot.setDir(Direction.NORTH);
		robot.left();
		Direction actual = robot.getDir();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void testRightOfNorthReturnsEast() {
		Direction expected = Direction.EAST;
		robot.setDir(Direction.NORTH);
		robot.right();
		Direction actual = robot.getDir();
		Assert.assertEquals(actual, expected);
	}
}
