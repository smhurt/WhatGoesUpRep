package main.gfx;

public class GameCamera {

	private double xOffset, yOffset;
	
	
	public GameCamera(double xOffset, double yOffset) {
		this.xOffset = xOffset;
		this.xOffset = yOffset;
	}

	public void move(double xAmt, double yAmt) {
		xOffset += xAmt;
		yOffset += yAmt;
	}
	public double getxOffset() {
		return xOffset;
	}


	public void setxOffset(double xOffset) {
		this.xOffset = xOffset;
	}


	public double getyOffset() {
		return yOffset;
	}


	public void setyOffset(double yOffset) {
		this.yOffset = yOffset;
	}

}
