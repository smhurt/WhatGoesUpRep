package main.entities.creatures;

import java.awt.Color;
import java.awt.Graphics;
import main.Handler;
import main.collisions.Collision;
import main.entities.platforms.Platform;

public class Enemy extends Creature{

	Platform platform;
	public Enemy(Handler handler, int width, int height, double speed, Platform platform) {
		super(handler, platform.getX() + platform.getWidth()/2 - width, platform.getY() - height, width, height);
		this.speed = speed;
		this.platform = platform;
		xMove = speed;
	}

	@Override
	public void tick() {
		adjGround = Collision.isAdjacentBottom(this, platform);
		/*if(!adjGround) {
			yMove = 0;
			y = platform.getY() - this.getHeight();
			x = platform.getX() + platform.getWidth()/2 - width;
			System.out.println("reset");
		}*/
		
		//normal ground state(slightly above the platform)
		if(adjGround) {
			//System.out.println("Normal");
			if(platform.getX() >= x) {
				//System.out.println("lefth");
				xMove = speed;

			}
			else if(platform.getX() + platform.getWidth() <= x + width) {
				//System.out.println("righth");
				xMove = -speed;
			}
		}
		xMove += platform.xMove;
		move();
		xMove -= platform.xMove;
	}

	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.setColor(Color.RED);
		g.fillRect((int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height);
	}

	
	

}
