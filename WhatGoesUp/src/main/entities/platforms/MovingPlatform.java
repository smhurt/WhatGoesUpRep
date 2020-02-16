package main.entities.platforms;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;

public class MovingPlatform extends Platform {
	boolean reachedStart = false, moving;
	
	double xStart, xEnd, yStart, yEnd;
	public MovingPlatform(Handler handler, double x, double y, int width, int height, double xStart, double yStart, double xEnd, double yEnd, boolean moving) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public MovingPlatform(Handler handler, double x, double y, double xStart, double yStart, double xEnd, double yEnd) {
		super(handler, x, y);
		// TODO Auto-generated constructor stub
	}

	public MovingPlatform(Handler handler, double x, double y, int width) {
		super(handler, x, y, width);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void tick() {
		if(x == xStart) {
			reachedStart = true;
		}
		else if(x == xEnd) {
			reachedStart = false;
		}
		if(reachedStart) {
			moveToward(xEnd, yEnd);
		}
		else {
			moveToward(xStart, yStart);
		}
	}


	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.BLACK);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);		
	}
	
	public void moveToward(double x, double y) {
		this.x += (x - this.x) / (y - this.y);
		this.y += (y - this.y) / (x - this.x);
	}

}
