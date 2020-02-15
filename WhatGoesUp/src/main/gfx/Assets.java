package main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage playerSprite,
								playerBowDrawnSprite,
								playerReleasedSprite,
								battlefieldSprite,
								pickaxeEnemySprite,
								arrowSprite;
	
	public static void init() {
		playerSprite = ImageLoader.loadImage("/textures/player.png");
		
		playerBowDrawnSprite = ImageLoader.loadImage("/textures/playerBowDrawn.png");
		
		playerReleasedSprite = ImageLoader.loadImage("/textures/playerReleased.png");
		
		battlefieldSprite = ImageLoader.loadImage("/textures/battlefield.jpg");
		
		arrowSprite = ImageLoader.loadImage("/textures/Arrow.png");
		
		pickaxeEnemySprite = ImageLoader.loadImage("/textures/pickaxeEnemy.png");
	}
}
