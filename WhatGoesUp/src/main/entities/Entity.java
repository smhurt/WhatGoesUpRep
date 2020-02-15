package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Game;
import main.Handler;

public abstract class Entity {
	
	protected Handler handler;
	protected double x;
	public double y;
	protected int width, height;
	protected BufferedImage image;
	protected boolean gravity;
	protected boolean onGround;

	
	
	public Entity(Handler handler, double x, double y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	
	public Rectangle getBound() {
		return new Rectangle((int)x,(int)y, width, height);
	}
	
	public boolean isCollision(Entity o) {
		if(this.x + this.width <= o.x ||
				this.x >= o.x + o.width ||
				this.y + this.width <= o.y ||
				this.y >= o.y + o.height) {
			
			return  false;
		}
		else {
			
			return  true;
		}
	}
	
	
	

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setImage(BufferedImage bi) {
		this.image = bi;
	}


	public boolean getOnGround() {
		return onGround;
	}


	public void setOnGround(boolean onGround) {
		this.onGround = onGround;
	}
	
}
