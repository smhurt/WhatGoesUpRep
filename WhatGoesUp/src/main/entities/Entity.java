package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Game;
import main.Handler;

public abstract class Entity {
	
	protected Handler handler;
	public double x;
	public double y;
	protected int width, height;
	protected BufferedImage image;
	protected boolean gravity,
	 				onGround,
	 				onCeiling;
	protected boolean onLeft;
	protected boolean onRight;

//github test
	
	
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
	
	public boolean isCollisionBottom(Entity o) {
		if(this.x + this.width <= o.x ||
				this.x >= o.x + o.width ||
				this.y + this.height <= o.y ||
				this.y  + this.height >= o.y + o.height) {
			
			return  false;
		}
		else {
			
			return  true;
		}
	}
	public boolean isCollisionTop(Entity o) {
		if(this.x + this.width <= o.x ||
				this.x >= o.x + o.width ||
				this.y <= o.y ||
				this.y >= o.y + o.height) {
			
			return  false;
		}
		else {
			
			return  true;
		}
	}
	public boolean isCollisionLeft(Entity o) {
		if(this.x < o.x ||
				this.x > o.x + o.width ||
				this.y + this.height - 10 < o.y ||
				this.y > o.y + o.height) {
			
			return  false;
		}
		else {
			
			return  true;
		}
	}
	public boolean isCollisionRight(Entity o) {
		if(this.x + width < o.x||
				this.x + width > o.x + o.width ||
				this.y + this.height - 10 < o.y ||
				this.y > o.y + o.height) {
			
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


	public boolean getOnCeiling() {
		return onCeiling;
	}


	public void setOnCeiling(boolean onCeiling) {
		this.onCeiling = onCeiling;
	}


	public boolean getOnLeft() {
		return onLeft;
	}


	public void setOnLeft(boolean onLeft) {
		this.onLeft = onLeft;
	}


	public boolean getOnRight() {
		return onRight;
	}


	public void setOnRight(boolean onRight) {
		this.onRight = onRight;
	}
	
}
