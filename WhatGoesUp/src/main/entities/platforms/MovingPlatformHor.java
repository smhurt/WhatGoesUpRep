package main.entities.platforms;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;

public class MovingPlatformHor extends Platform {
	boolean reachedStart = false;
	double xStart, xEnd, yStart, yEnd;
	public MovingPlatformHor(Handler handler, double x, double y, int width, int height, double xStart,  double xEnd, double speed, boolean moving) {
		super(handler, x, y, width, height);
		if(xStart < xEnd) {
			this.xStart = xStart;
			this.xEnd = xEnd;
		}
		else {
			double place = xStart;
			xStart = xEnd;
			xEnd = place;
		}
		this.speed = speed;
	}

	
	
	@Override
	public void tick() {
		if(x <= xStart) {
			reachedStart = true;
			
		}
		else if(x >= xEnd) {
			reachedStart = false;
		}
		if(reachedStart) {
			xMove = speed;
		}
		else {
			xMove = -speed;
		}
		move();
	}


	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.BLACK);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);		
	}
	
	

}
