package main.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Game;
import main.Handler;
import main.entities.Entity;
import main.state.GameState;

public abstract class Creature extends Entity{
	
	public static final double DEFAULT_SPEED = 3.0f,
								DEFAULT_CREATURE_ACCEL = 1,
								DEFAULT_JUMP_SPEED = 10;
	public static final int DEFAULT_CREATURE_WIDTH = 128, 
							DEFAULT_CREATURE_HEIGHT = 128;
							
	protected double speed, xMove, yMove, jumpSpeed, accel;

	
	
	public Creature(Handler handler, double x, double y, int width, int height) {
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
		
		jumpSpeed = DEFAULT_JUMP_SPEED;
		accel = DEFAULT_CREATURE_ACCEL;
	}

	

	public void move() {
		
		x += xMove;
		y += yMove;
	}
	
	
	
	//Getters and setters
	public double getxMove() {
		return xMove;
	}

	public void setxMove(double xMove) {
		this.xMove = xMove;
	}

	public double getyMove() {
		return yMove;
	}

	public void setyMove(double yMove) {
		this.yMove = yMove;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
}
