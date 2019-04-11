package com.shaangroups.practice.test;

public class Robot {

	private int row;
	private int col;
	private Direction dir;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}

	void left() {
		int index = (dir.ordinal() - 1 < 0) ? 3 : dir.ordinal() - 1;
		this.dir = Direction.values()[index];
	}
	
	void right() {
		int index = (dir.ordinal() + 1 > 3) ? 0 : dir.ordinal() + 1;
		this.dir = Direction.values()[index];
	}
	
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.setRow(0);
		robot.setCol(0);
		robot.setDir(Direction.NORTH);
		robot.left();
		System.out.println(robot.dir);
		robot.right();
		System.out.println(robot.dir);
	}
}
