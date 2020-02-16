package main.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;

public class Player extends Creature {

	private static int playerHeight = 50;
	private static int playerWidth = 50;
	
	private static int viewShiftDistanceVert, viewShiftDistanceHor;
	
	private static boolean doubleJump = true;
	
	private static double chargeCount;
	
	
	public Player(Handler handler, double x, double y, double speed) {
		super(handler, x, y, playerHeight, playerWidth);
		this.speed = speed;
		this.jumpSpeed = 15;
		viewShiftDistanceVert = handler.getHeight()/4;
		viewShiftDistanceHor = handler.getWidth()/4;
	}

	@Override
	public void tick() {
		playerMovement();
		

	}

	
	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.BLUE);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);	
	}
	
	private void playerMovement() {
		xMove = 0;
		
		//left right movement
		if(handler.getKeyManager().left && !onLeft) {
			
			xMove = -speed;
		
		}
		if(handler.getKeyManager().right && !onRight) {			
		
			xMove = speed;
		
		}
		if(onLeft) {x++; System.out.println("left");}
		if(onRight) {x--; System.out.println("Right");}
		
		
		if(y > handler.getHeight()) y = -height;//wrap function (not for end product)
		
		//jump/accellerate
		if(!(onGround|| adjGround)) {
			if(yMove <= 20) {
				yMove += accel;
			}
			//double jump
			if(doubleJump && handler.getKeyManager().upPressed) {
				yMove = -jumpSpeed;
				doubleJump = false;
			}
		}
		
		//burst upward
		//prevents falling into ground
		if(onGround) {
			System.out.println("Ground");
			//if(handler.getKeyManager().up) {
				//yMove = -jumpSpeed;
			yMove = 0;
			y = platOnBottom.getY() - this.getHeight();
			
		}
		//normal ground state(slightly above the platform)
		if(adjGround) {
			if(handler.getKeyManager().up) {
				
				yMove = -jumpSpeed;
				doubleJump = true;
			}
			if(handler.getKeyManager().down) {
				
			}
		}
		//prevents going into ceiling
		if(onCeiling) {
			yMove = 0;
			y = platOnTop.getY() + platOnTop.getHeight();	
			System.out.println("Ceiling");
		}
		
		move();
		
		//posistions gameCamera correctly
		if(this.x + this.width/2.0 - handler.getGameCamera().getxOffset() > (handler.getWidth()- viewShiftDistanceHor)) {
			handler.getGameCamera().setxOffset(this.x + this.width/2.0 - (handler.getWidth()- viewShiftDistanceHor));
		}
		else if(this.x + this.width/2.0 - handler.getGameCamera().getxOffset() < viewShiftDistanceHor) {
			handler.getGameCamera().setxOffset(this.x + this.width/2.0 - viewShiftDistanceHor);
		}
		if(this.y + this.height/2.0 - handler.getGameCamera().getyOffset() > (handler.getHeight()- viewShiftDistanceVert)) {
			handler.getGameCamera().setyOffset(this.y + this.height/2.0 - (handler.getHeight()- viewShiftDistanceVert));
		}
		else if(this.y + this.height/2.0 - handler.getGameCamera().getyOffset() < viewShiftDistanceVert) {
			handler.getGameCamera().setyOffset(this.y + this.height/2.0 - viewShiftDistanceVert);
		}
		
	}

	

}
