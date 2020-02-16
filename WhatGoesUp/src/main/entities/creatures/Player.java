package main.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;

import main.Handler;
import main.gfx.Assets;

public class Player extends Creature {

	private static int playerHeight = 50;
	private static int playerWidth = 30;
	
	private static int viewShiftDistanceVert, viewShiftDistanceHor;
	
	public static boolean gameWon = false;
	private static boolean doubleJump = true;
	private static boolean doubleJumpUnlock = false;
	private static boolean burstUnlock = false;
	private static boolean faceRight = true;
	private static boolean hasKey = false;
	
	private static double chargeTime = 20, chargeCount = 0, chargeStrength = 30;
	
	public Player(Handler handler, double x, double y, double speed) {
		super(handler, x, y, playerWidth, playerHeight);
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
		//g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);
		if(faceRight) {
			if(y > 6500) {
				g.drawImage(Assets.playerSpriteDemonRight, (int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height, null);
			}
			else if(y < 3500) {
				g.drawImage(Assets.playerSpriteAngelRight, (int)(x + 1 - xOffset - width), (int)(y + 1 - yOffset - height*.25), (int)(width * 2), (int)(height * 1.25), null);
			}
			else {
			g.drawImage(Assets.playerSpriteRight, (int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height, null);
			}
		}
		else {
			if(y > 6500) {
				g.drawImage(Assets.playerSpriteDemon, (int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height, null);
			}
			else if(y < 3500) {
				g.drawImage(Assets.playerSpriteAngel, (int)(x + 1 - xOffset), (int)(y + 1 - yOffset - height*.25), (int)(width * 2), (int)(height * 1.25), null);
			}
			else {
			g.drawImage(Assets.playerSprite, (int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height, null);
			}
		}
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
		
		
		//if(y > handler.getHeight()) y = -height;//wrap function (not for end product)
		
		//jump/accellerate
		if(!(onGround|| adjGround)) {
			if(yMove <= 20) {
				yMove += accel;
			}
			//double jump
			if(doubleJumpUnlock && doubleJump && handler.getKeyManager().upPressed) {
				yMove = -jumpSpeed;
				doubleJump = false;
			}
		}
		else doubleJump = true;
		
		//burst upward
		if(burstUnlock && chargeCount >= chargeTime && !handler.getKeyManager().down) {
			yMove = -chargeStrength;
			chargeCount = 0;
			doubleJump = false;
		}
		else if(!handler.getKeyManager().down) {
			chargeCount = 0;
		}
		//prevents falling into ground
		if(onGround) {
			//System.out.println("Ground");
			//if(handler.getKeyManager().up) {
				//yMove = -jumpSpeed;
			yMove = 0;
			y = platOnBottom.getY() - this.getHeight();
			
		}
		//normal ground state(slightly above the platform)
		if(adjGround) {
			if(handler.getKeyManager().upPressed) {
				
				yMove = -jumpSpeed;
			}
			if(handler.getKeyManager().down) {
				chargeCount++;
			}
		}
		//prevents going into ceiling
		if(onCeiling) {
			yMove = 0;
			y = platOnTop.getY() + platOnTop.getHeight();	
			System.out.println("Ceiling");
		}
		if(xMove > 0) {
			faceRight = true;
		}
		else if(xMove < 0) {
			faceRight = false;
		}
		if(platOnBottom != null) {
			xMove += platOnBottom.xMove;
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
	
	public void addPower(String name) {
		if(name.equals("DoubleJump")) {
			doubleJumpUnlock = true;
		}
		else if(name.equals("Wings")) {
			burstUnlock = true;
		}
		else if(name.equals("Key")) {
			hasKey = true;
		}
		else if(name.equals("Door") && hasKey) {
			gameWon = true;
		}
	}
	

}
