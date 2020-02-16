package main.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Game;
import main.Handler;
import main.entities.platforms.Platform;

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
	protected boolean adjGround;
	protected Platform platOnBottom;
	protected Platform platOnTop;
	protected Platform platOnRight;
	protected Platform platOnLeft;


//github test
	
	
	public Entity(Handler handler, double x, double y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public abstract void tick();
	
	public abstract void render(Graphics g, double xOffset, double yOffset);
	
	

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


	public boolean getAdjGround() {
		return adjGround;
	}


	public void setAdjGround(boolean adjGround) {
		this.adjGround = adjGround;
	}


	public Platform getPlatOnLeft() {
		return platOnLeft;
	}


	public void setPlatOnLeft(Platform platOnLeft) {
		this.platOnLeft = platOnLeft;
	}


	public Platform getPlatOnBottom() {
		return platOnBottom;
	}


	public void setPlatOnBottom(Platform platOnBottom) {
		this.platOnBottom = platOnBottom;
	}


	public Platform getPlatOnTop() {
		return platOnTop;
	}


	public void setPlatOnTop(Platform platOnTop) {
		this.platOnTop = platOnTop;
	}


	public Platform getPlatOnRight() {
		return platOnRight;
	}


	public void setPlatOnRight(Platform platOnRight) {
		this.platOnRight = platOnRight;
	}
	
}
