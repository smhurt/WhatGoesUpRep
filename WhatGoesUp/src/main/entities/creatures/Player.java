package main.entities.creatures;

import java.awt.Graphics;

import main.Handler;

public class Player extends Creature {

	private static int playerHeight = 50;
	private static int playerWidth = 50;
	
	
	
	public Player(Handler handler, double x, double y, double speed) {
		super(handler, x, y, playerHeight, playerWidth);
		this.speed = speed;
		this.jumpSpeed = 20;
	}

	@Override
	public void tick() {
		playerMovement();
	}

	@Override
	public void render(Graphics g) {
		g.fillRect((int)x + 1, (int)y + 1, width - 2, height - 2);
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
		
		//jump/accellerate
		
		if(y > handler.getHeight()) y = -height;//wrap function (not for end product)
		
		if(!onGround && yMove <= 20) {
			yMove += accel;
		}
		if(onGround) {
			System.out.println("Ground");
			if(handler.getKeyManager().up) {
			yMove = -jumpSpeed;
			}
			else {
				yMove = 0;
			}
		}
		
		if(onCeiling) {
			yMove = 0;
			y++;	
			System.out.println("Ceiling");
		}
		
		move();
		
	}

}
