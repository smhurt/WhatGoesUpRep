package main.entities.items;

import java.awt.Graphics;
import java.awt.Image;

import main.Handler;
import main.entities.Entity;
import main.gfx.Assets;

public class Item extends Entity{
	private Image img;
	private String name;
	public Item(Handler handler, double x, double y, int width, int height, String name, Image img) {
		super(handler, x, y, width, height);
		this.img = img;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void tick() {
		
	}
	@Override
	public void render(Graphics g, double xOffset, double yOffset) {
		g.drawImage(img, (int)(x + 1 - xOffset), (int)(y + 1 - yOffset), width, height, null);

	}
	
	
}
