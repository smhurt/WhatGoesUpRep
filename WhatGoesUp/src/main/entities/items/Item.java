package main.entities.items;

import main.Handler;
import main.entities.Entity;

public abstract class Item extends Entity{

	public Item(Handler handler, double x, double y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
