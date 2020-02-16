package main.state;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Handler;
import main.collisions.Collision;
import main.entities.platforms.Platform;
import main.gfx.Assets;
import main.gfx.Background;
import main.entities.Entity;
import main.entities.creatures.*;
import java.util.Random;

// random comment for github test
//another comment
//yet another change to test github
//fourth comment

public class GameState extends State{
	
	private Background background;
	
	private Player player;
	
	private Platform platform1, platform2;
	
	private ArrayList<Platform> p = new ArrayList<Platform>(100);
	
	Random r = new Random();
	public GameState(Handler handler) {
		super(handler);
		
		
		
		background = new Background(handler, Assets.battlefieldSprite);
		
		player = new Player(handler, 0, 0, 8);
		
		p.add(new Platform(handler, 200, 550, 200, 50));
		
		p.add(new Platform(handler, 400, 450, 200, 50));

		p.add(new Platform(handler, 0, 450, 200, 50));
		
		p.add(new Platform(handler, 200,200, 200, 50));
		
		p.add(new Platform(handler, 600, 400, 200, 50));

		p.add(new Platform(handler, -200, 400, 200, 50));
		
		p.add(new Platform(handler, r.nextInt(handler.getWidth()) , r.nextInt(handler.getHeight()) - 300, 200, 50));

		p.add(new Platform(handler, r.nextInt(handler.getWidth()) - 600, r.nextInt(handler.getHeight()), 200, 50));

		p.add(new Platform(handler, r.nextInt(handler.getWidth()), r.nextInt(handler.getHeight()), 200, 50));


	}

	@Override
	public void tick() {
		player.tick();
		
		
		player.setOnGround(false);
		player.setAdjGround(false);
		player.setOnCeiling(false);
		player.setOnLeft(false);
		player.setOnRight(false);
		
		for (Platform plat: p) {
			if (Collision.isCollisionBottom(player, plat)) {
				player.setOnGround(true);
				player.setPlatOnBottom(plat);
			}
			if (Collision.isAdjacentBottom(player, plat)) {
				player.setAdjGround(true);
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
		}
	}

	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		background.render(g);//, xOffset, yOffset);
		player.render(g, xOffset, yOffset);
		for (Platform plat:p) {
			plat.render(g, xOffset, yOffset);
		}
	}
	
	
	
	

}
