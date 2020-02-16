package main.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import main.Handler;
import main.collisions.Collision;
import main.entities.platforms.MovingPlatformHor;
import main.entities.platforms.MovingPlatformVert;
import main.entities.platforms.Platform;
import main.gfx.Assets;
import main.gfx.Background;
import main.entities.Entity;
import main.entities.creatures.*;
import main.entities.items.Item;

import java.util.Random;

// random comment for github test
//another comment
//yet another change to test github
//fourth comment

public class GameState extends State{
	
	//private Background background;
	
	private Player player;
	
	//private Platform platform1, platform2;
	
	//private Enemy enemy;
	
	private ArrayList<Platform> p = new ArrayList<Platform>(100);
	private ArrayList<Item> i = new ArrayList<Item>(100);

	
	//Random r = new Random();
	public GameState(Handler handler) {
		super(handler);
		
		
		
		//background = new Background(handler, Assets.battlefieldSprite);
		
		//player = new Player(handler, 200, 0, 8);
		//p.add(new Platform(handler, 200, 550, 200, 50));
		//p.add(new MovingPlatformHor(handler, 200, 200, 200, 50, 400, 800, 3, true));
		//p.add(new MovingPlatformVert(handler, 0, 200, 200, 50, 120, 600, 3, true));
		//enemy = new Enemy(handler, 50, 50, 2, p.get(1));
		
		player = new Player(handler, 775, 4950, 8);
		p.add(new Platform(handler, 0, 0, 50, 10050));		// map boundary
		p.add(new Platform(handler, 1550, 0, 50, 10050));	// map boundary
		
		//heaven side
		i.add(new Item(handler, 790, 150, 20, 40, "Key", Assets.keySprite));
		p.add(new Platform(handler, 250, 200, 1100, 50));
		p.add(new Platform(handler, 0, 350, 750, 50));
		p.add(new Platform(handler, 1000, 550, 550, 50));
		p.add(new Platform(handler, 800, 700, 200, 50));
		p.add(new Platform(handler, 600, 850, 200, 50));
		p.add(new Platform(handler, 400, 1000, 200, 50));
		//p.add(new MovingPlatformHor(handler, 825, 1200, 150, 50, 50, 1350, 2, true));	//this is the moving platform nearest 'heaven' -- so make it moving
		p.add(new Platform(handler, 0, 1400, 100, 50));
		i.add(new Item(handler, 55, 1345, 35, 40, "Wings", Assets.wingsSprite));

		p.add(new Platform(handler, 1450, 1400, 100, 50));		// this will have a item/powerup
		p.add(new Platform(handler, 0, 1550, 200, 50));
		p.add(new MovingPlatformHor(handler, 700, 1650, 200, 50, 50, 1350, 2, true));	// another moving platform
		p.add(new Platform(handler, 600, 1800, 400, 50));
		p.add(new Platform(handler, 0, 2000, 400, 50));
		p.add(new Platform(handler, 400, 2150, 200, 50));
		p.add(new Platform(handler, 0, 2300, 400, 50));
		p.add(new Platform(handler, 1450, 2150, 100, 50));// platform for item/powerup		
		p.add(new Platform(handler, 400, 2450, 500, 50));
		p.add(new Platform(handler, 900, 2650, 200, 50));
		p.add(new Platform(handler, 1100, 2800, 200, 50));
		p.add(new Platform(handler, 1300, 2950, 250, 50));
		//p.add(new MovingPlatformHor(handler, 700, 3100, 200, 50, 50, 1350, 2, true));	// moving platform
		p.add(new Platform(handler, 50, 2950, 100, 50));
		p.add(new Platform(handler, 1450, 3250, 100, 50));
		p.add(new Platform(handler, 1350, 3450, 200, 50));
		p.add(new Platform(handler, 1150, 3600, 200, 50));
		p.add(new Platform(handler, 700, 3800, 200, 50));
		p.add(new Platform(handler, 600, 3950, 400, 50));
		
		i.add(new Item(handler, 75, 4045, 50, 50, "DoubleJump", Assets.doubleJumpSprite));

		p.add(new Platform(handler, 50, 4100, 100, 50));
		p.add(new Platform(handler, 200, 4250, 100, 50));
		p.add(new Platform(handler, 200, 4400, 400, 50));
		p.add(new Platform(handler, 600, 4550, 400, 50));
		p.add(new Platform(handler, 500, 4600, 600, 50));
		p.add(new Platform(handler, 400, 4650, 800, 50));
		p.add(new Platform(handler, 300, 4700, 1000, 50));
		p.add(new Platform(handler, 50, 4850, 100, 50));
		p.add(new Platform(handler, 1450, 4850, 100, 50));
		
		
		p.add(new Platform(handler, 250, 5000, 1100, 50));		// start/middle
		
		// demon side
		p.add(new Platform(handler, 1350, 5100, 100, 50));
		p.add(new Platform(handler, 50, 5200, 700, 50));
		p.add(new Platform(handler, 850, 5200, 700, 50));
		p.add(new Platform(handler, 200, 5400, 1200, 50));
		p.add(new Platform(handler, 50, 5600, 400, 50));
		p.add(new Platform(handler, 450, 5750, 200, 50));
		p.add(new Platform(handler, 1150, 5950, 400, 50));
		p.add(new MovingPlatformHor(handler, 700, 6100, 200, 50, 50, 1350, 2, true));		// moving platform
		p.add(new Platform(handler, 50, 6300, 300, 50));
		p.add(new Platform(handler, 350, 6300, 50, 600));
		p.add(new Platform(handler, 200, 6850, 200, 50));
		p.add(new Platform(handler, 50, 6950, 600, 50));
		p.add(new Platform(handler, 150, 6500, 50, 400));
		p.add(new Platform(handler, 1200, 7100, 350, 50));
		p.add(new MovingPlatformHor(handler, 800, 7300, 200, 50, 50, 1350, 2, true));		// moving platform
		p.add(new Platform(handler, 450, 7500, 50, 200));
		p.add(new Platform(handler, 50, 7200, 100, 50));
		p.add(new Platform(handler, 50, 7900, 150, 50));		// add "spikes"
		p.add(new Platform(handler, 1350, 7600, 200, 50));
		p.add(new Platform(handler, 1300, 7850, 250, 50));
		p.add(new Platform(handler, 200, 8100, 1350, 50));
		p.add(new Platform(handler, 50, 8300, 700, 50));
		p.add(new Platform(handler, 900, 8300, 650, 50));
		p.add(new Platform(handler, 750, 8550, 500, 200));
		p.add(new Platform(handler, 50, 8450, 100, 50));	// item/powerup
		p.add(new Platform(handler, 550, 8700, 200, 50));
		p.add(new Platform(handler, 1450, 8700, 100, 50));
		p.add(new Platform(handler, 750, 8900, 800, 50));
		p.add(new Platform(handler, 750, 8750, 50, 100));
		p.add(new Platform(handler, 700, 8900, 50, 300));
		p.add(new Platform(handler, 500, 9200, 250, 50));
		p.add(new Platform(handler, 450, 8950, 50, 300));
		p.add(new Platform(handler, 1350, 9350, 200, 50));
		p.add(new Platform(handler, 1400, 9100, 100, 50));		// item/powerup
		p.add(new Platform(handler, 500, 9500, 600, 50));
		p.add(new Platform(handler, 200, 9750, 1200, 50));
		p.add(new Platform(handler, 50, 9950, 150, 50));		// spikes
		p.add(new Platform(handler, 1400, 9950, 150, 50));		// spikes
		
		i.add(new Item(handler, 750, 9900, 100, 100, "Door", Assets.doorSprite));

		p.add(new Platform(handler, 50, 10000, 1500, 50));
	}

	@Override
	public void tick() {
		player.tick();
		
		
		player.setOnGround(false);
		player.setAdjGround(false);
		player.setOnCeiling(false);
		player.setOnLeft(false);
		player.setOnRight(false);
		
		player.setPlatOnBottom(null);
		player.setPlatOnTop(null);
		player.setPlatOnLeft(null);
		player.setPlatOnRight(null);
		
		for (Platform plat: p) {
			if(Math.abs(plat.getY() - player.getY()) < 2 * handler.getHeight() || plat.getHeight() > handler.getHeight()){
				if (Collision.isCollisionBottom(player, plat)) {
					player.setOnGround(true);
					player.setPlatOnBottom(plat);
				}
				if (Collision.isAdjacentBottom(player, plat)) {
					player.setAdjGround(true);
					player.setPlatOnBottom(plat);
				}
				if (Collision.isCollisionTop(player, plat)) {
					player.setOnCeiling(true);
					player.setPlatOnTop(plat);
				}
				if (Collision.isCollisionLeft(player, plat)) {
					player.setOnLeft(true);
					player.setPlatOnLeft(plat);
	
				}
				if (Collision.isCollisionRight(player, plat)) {
					player.setOnRight(true);
					player.setPlatOnRight(plat);
				}
				plat.tick();
			}
		}
		ArrayList<Item> itemp = new ArrayList<Item>(100);
		for (Item item:i) {
			if(Collision.isCollision(player, item)) {
				player.addPower(item.getName());
				//i.remove(item);
				if(item.getName().equals("Door")) {
					itemp.add(item);
				}		
			}
			else{
				itemp.add(item);
			}
			
		}
		i = itemp;
		
	}

	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		//background.render(g, xOffset, yOffset);
		player.render(g, xOffset, yOffset);
		for (Platform plat:p) {
			if(Math.abs(plat.getY() - player.getY()) < 2 * handler.getHeight() || plat.getHeight() > handler.getHeight()){
				plat.render(g, xOffset, yOffset);
			}
		}
		for(Item item: i) {
			
			item.render(g, xOffset, yOffset);
		}
		Font font = new Font("Verdana", Font.BOLD, 14);
	    g.setFont(font);
	    g.setColor(Color.RED);
	    g.drawString("Enter Hell.   No Return.", (int)(710 - xOffset), (int)(5300 - yOffset));
	    if(player.gameWon) {
	    	Font endfont = new Font("Verdana", Font.BOLD, 50);
		    g.setFont(endfont);
		    g.drawString("YOU WIN", handler.getWidth()/2, handler.getHeight()/2);
	    }
	}
	
	
	
	

}
