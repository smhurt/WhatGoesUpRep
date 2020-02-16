package main.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Handler;

public class Background {
	
	Handler handler;
	BufferedImage bi;
	
	public Background(Handler handler, BufferedImage bi) {
		this.bi = bi;
		this.handler = handler;
	}
	
	public void render(Graphics g, double xOffset, double yOffset){
		g.drawImage(bi, (int)-xOffset, (int)-yOffset, handler.getWidth(), handler.getHeight(), null);
	}
}
