package main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean up, down, left, right, upPressed, upHeld;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left= keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		if(up && !upPressed && !upHeld) {
			upPressed = true;
			upHeld = true;
		}
		else if(up && upPressed) {
			upPressed = false;
		}
		else if(!up && upHeld){
			upHeld = false;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	

}
