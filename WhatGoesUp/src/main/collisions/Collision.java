package main.collisions;

import main.entities.Entity;

public class Collision {
	private double leftRightGraceHeight = 10;
	public Collision() {
	}
	
	public boolean isCollisionRight(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() < b.getX() ||
				a.getX() + a.getWidth() > b.getX() + b.getWidth() ||
				a.getY() + a.getHeight() - leftRightGraceHeight < b.getY() ||
				a.getY() + leftRightGraceHeight> b.getY() + b.getHeight()));
	}
	public boolean isCollisionLeft(Entity a, Entity b) {
		return (!(a.getX() < b.getX() ||
				a.getX() > b.getX() + b.getWidth() ||
				a.getY() + a.getHeight() - leftRightGraceHeight < b.getY() ||
				a.getY() + leftRightGraceHeight > b.getY() + b.getHeight()));
	}
	public boolean isCollisionTop(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() <= b.getX() ||
				a.getX() >= b.getX() + b.getWidth() ||
				a.getY() <= b.getY() ||
				a.getY() >= b.getY() + b.getHeight()));
	}
	public boolean isCollisionBottom(Entity a, Entity b) {
		return (!(a.getX() + a.getWidth() <= b.getX() ||
				a.getX() >= b.getX() + b.getWidth() ||
				a.getY() + a.getHeight() <= b.getY() ||
				a.getY() + a.getHeight() >= b.getY() + b.getHeight()));
	}

}
