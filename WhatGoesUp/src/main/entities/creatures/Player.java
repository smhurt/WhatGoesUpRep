package main.entities.creatures;

import java.awt.Graphics;

import main.Handler;

public class Player extends Creature {

	private static int playerHeight = 50;
	private static int playerWidth = 50;
	private static double playerSpeed;
	private static double playerJumpSpeed;
	private static double playerAccel;
	
	public Player(Handler handler, double x, double y) {
		super(handler, x, y, playerHeight, playerWidth);
		
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
		if(handler.getKeyManager().left) {
			
			xMove = -speed;
		
		}
		if(handler.getKeyManager().right) {			
		
			xMove = speed;
		
		}
		
		//jump/accellerate
		if(!onGround) {
			yMove += accel;
		}
		else if(handler.getKeyManager().up) {
			yMove = -jumpSpeed;
		}
		
		move();
		
	}

}
