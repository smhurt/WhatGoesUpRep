package main.collisions;

import main.entities.Entity;

public class Collision {
	private static double leftRightGraceHeight = 10;
	private static double upDownGraceLength = 10;
	public Collision() {
	}
	
	public static boolean isCollisionRight(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() - 1 < b.getX() ||
				a.getX() + a.getWidth() + 1 > b.getX() + b.getWidth() ||
				a.getY() + a.getHeight() - leftRightGraceHeight < b.getY() ||
				a.getY() + leftRightGraceHeight> b.getY() + b.getHeight()));
	}
	public static boolean isCollisionLeft(Entity a, Entity b) {
		return (!(a.getX() - 1 < b.getX() ||
				a.getX()  + 1 > b.getX() + b.getWidth() ||
				a.getY() + a.getHeight() - leftRightGraceHeight < b.getY() ||
				a.getY() + leftRightGraceHeight > b.getY() + b.getHeight()));
	}
	public static boolean isCollisionTop(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() - upDownGraceLength < b.getX() ||
				a.getX() + upDownGraceLength > b.getX() + b.getWidth() ||
				a.getY() <= b.getY() ||
				a.getY() >= b.getY() + b.getHeight()));
	}
	public static boolean isCollisionBottom(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() - upDownGraceLength < b.getX() ||
				a.getX() + upDownGraceLength > b.getX() + b.getWidth() ||
				a.getY() + a.getHeight()    <=  b.getY()  ||
				a.getY() + a.getHeight()  >= b.getY() + b.getHeight()));
	}
	
	public static boolean isAdjacentBottom(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() - upDownGraceLength < b.getX() ||
				a.getX() + upDownGraceLength > b.getX() + b.getWidth() ||
				a.getY() + a.getHeight() != b.getY()  //||
				));
	}
}
