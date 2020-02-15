package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import main.display.Display;
import main.gfx.Assets;
import main.input.KeyManager;
import main.state.*;
import main.gfx.*;

//test123
public class Game implements Runnable{
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	
	//States
	private State gameState;
	private State menuState;
	
	//input
	private KeyManager keyManager;
	
	//camera
	
	//handler
	private Handler handler;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	
	//At Start
	private void init() {
		display = new Display(title, width, height);
		display.getJFRame().addKeyListener(keyManager);
		Assets.init();
		
		
		handler = new Handler(this);
		
		setGameState(new GameState(handler));
		menuState = new MenuState(handler);
		State.setState(getGameState());
	}
	
	//At new frame/ update method
	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	//At new frame/ update method but only for rendering
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clear screen
		g.clearRect(0,0,width,height);
		//Draw Here
		if(State.getState() != null) {
			State.getState().render(g);
		}
		
		//end Drawing
		bs.show();
		g.dispose();
	}
	
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		//test
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			if(delta>= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer>= 1000000000) {
				System.out.println("Ticks and Frames:" + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
	}
	
	
	public int getWidth() {
		return width;
	}

	
	public int getHeight() {
		return height;
	}


	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	public GameState getGameState() {
		return (GameState)gameState;
	}


	public void setGameState(State gameState) {
		this.gameState = gameState;
	}


	public synchronized void start() {
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if(!running) return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
