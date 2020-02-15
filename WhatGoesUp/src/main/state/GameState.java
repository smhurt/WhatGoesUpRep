package main.state;

import java.awt.Graphics;
import java.util.ArrayList;

import main.Handler;
import main.entities.platforms.Platform;
import main.gfx.Assets;
import main.gfx.Background;
import main.entities.creatures.*;

// random comment for github test
//another comment
//yet another change to test github
//fourth comment

public class GameState extends State{
	
	private Background background;
	
	private Player player;
	
	private Platform platform1, platform2;
	
	public GameState(Handler handler) {
		super(handler);
		
		background = new Background(handler, Assets.battlefieldSprite);
		
		player = new Player(handler, 200, 300, 4);
		
		platform1 = new Platform(handler, 200, 500, 200, 50);
		
		platform2 = new Platform(handler, 400, 450, 200, 50);

	}

	@Override
	public void tick() {
		player.tick();
		player.setOnGround(player.isCollisionBottom(platform1) || player.isCollisionBottom(platform2));
		player.setOnCeiling(player.isCollisionTop(platform1) || player.isCollisionTop(platform2));
		player.setOnLeft(player.isCollisionLeft(platform1) || player.isCollisionLeft(platform2));
		player.setOnRight(player.isCollisionRight(platform1) || player.isCollisionRight(platform2));

	}

	@Override
	public void render(Graphics g) {
		background.render(g);
		player.render(g);
		platform1.render(g);
		platform2.render(g);

	}
	
	
	
	

}
