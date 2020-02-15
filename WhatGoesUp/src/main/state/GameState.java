package main.state;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Handler;
import main.entities.creatures.Enemy;
import main.entities.platforms.Platform;
import main.gfx.Assets;
import main.gfx.Background;
import main.entities.creatures.*;

// random comment for github test

public class GameState extends State{
	
	private Background background;
	
	private Player player;
	
	private Platform platform1;
	
	public GameState(Handler handler) {
		super(handler);
		
		background = new Background(handler, Assets.battlefieldSprite);
		
		player = new Player(handler, 200, 300);
		
		platform1 = new Platform(handler, 200, 500, 200, 50);
		
		
	}

	@Override
	public void tick() {
		player.tick();
		if(player.isCollision(platform1)) {
			player.setOnGround(true);
		}
		else {
			player.setOnGround(false);
		
		}
	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		player.render(g);
		platform1.render(g);
	}
	
	
	
	

}
