package main.entities.platforms;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;
import main.entities.Entity;

public class Platform extends Entity {

	public Platform(Handler handler, double x, double y, int width, int height) {
		super(handler, x, y, width, height);
	}

	@Override
	public void tick() {
		
	}


	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.BLACK);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);		
	}

}
