package main.entities.platforms;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;
import main.entities.Entity;

public class Platform extends Entity {
	public boolean moving = false;
	public double speed = 0, xMove, yMove;
	public Platform(Handler handler, double x, double y, int width, int height) {
		super(handler, x, y, width, height);
	}
	public Platform(Handler handler, double x, double y) {
		super(handler, x, y, 200, 25);
	}
	public Platform(Handler handler, double x, double y, int width) {
		super(handler, x, y, width, 25);
	}

	@Override
	public void tick() {
		
	}


	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.BLACK);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);		
	}
	
	public void move() {
		x += xMove;
		y += yMove;
	}
}
