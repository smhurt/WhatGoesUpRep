package main.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage playerSprite,
								playerSpriteAngel,
								playerSpriteDemon,
								playerSpriteRight,
								playerSpriteAngelRight,
								playerSpriteDemonRight,
								doubleJumpSprite,
								wingsSprite,
								
								keySprite,
								doorSprite
								;
	
	public static void init() {
		playerSprite = ImageLoader.loadImage("/characterSprites/Normal_FemaleStand.gif");
		
		playerSpriteAngel = ImageLoader.loadImage("/characterSprites/Angel_FemaleStand.gif");

		playerSpriteDemon = ImageLoader.loadImage("/characterSprites/Hell_FemaleStand.gif");

		playerSpriteRight = ImageLoader.loadImage("/characterSprites/Normal_FemaleStandRight.png");
		
		playerSpriteAngelRight = ImageLoader.loadImage("/characterSprites/Angel_FemaleStandRight.png");

		playerSpriteDemonRight = ImageLoader.loadImage("/characterSprites/Hell_FemaleStandRight.png");
		
		
		doubleJumpSprite = ImageLoader.loadImage("/textures/PowerUp_DoubleJump.gif");

		wingsSprite = ImageLoader.loadImage("/textures/PowerUp_Wings.gif");
		
		keySprite = ImageLoader.loadImage("/textures/Key.png");
		
		doorSprite = ImageLoader.loadImage("/textures/Door.png");
	}
}
