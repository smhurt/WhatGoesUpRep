package main.entities.platforms;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;

public class MovingPlatformVert extends Platform{

	boolean reachedStart = false;
	
	double xStart, xEnd, yStart, yEnd;
	public MovingPlatformVert(Handler handler, double x, double y, int width, int height, double yStart,  double yEnd, double speed, boolean moving) {
		super(handler, x, y, width, height);
		if(yStart < yEnd) {
			this.yStart = yStart;
			this.yEnd = yEnd;
		}
		else {
			double place = yStart;
			yStart = yEnd;
			yEnd = place;
			
		}
		this.speed = speed;
}

	
	
	@Override
	public void tick() {
		if(y <= yStart) {
			reachedStart = true;
		}
		else if(y >= yEnd) {
			reachedStart = false;
		}
		if(reachedStart) {
			yMove = speed;
		}
		else {
			yMove = -speed;
		}
		move();
	}


	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.BLACK);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);		
	}
	
	
}
