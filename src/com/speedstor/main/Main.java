package com.speedstor.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.speedstor.Input.Input;
import com.speedstor.map.LoadMap;
import com.speedstor.map.MapRender;
import com.speedstor.players.Player1;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = -2578428780737535640L;
	
	//Variables
		//Global
			public boolean running = true;
			public static int frames = 0, runTime = 0;
			public static double width = 1200, height = width / 4 * 3; //Scene "blocks": 15 x 13
			public static int key = 0;
		
		//Private
			Handler handler;
			private Thread thread;
		

	
			
	
	//Initial Commit
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		handler = new Handler();
		
		//Creating window
		new Window((int) width, (int)height, "Pokemon is dumb", this);
		
		//Adding elements on screen
		handler.addObject(new LoadMap("res/Map1.txt", handler));
		handler.addObject(new MapRender(handler));
		handler.addObject(new Player1("/maleSprite.png", handler));
		
		//keyInput
		addKeyListener(new Input(handler));
		
		run();
	}

	//Game Engine
	public void run() {
		int frames = 0;
		
		requestFocus();
		System.out.println("The game had started on " + frames + ".");
		long delta = 0, timer;
		timer = System.currentTimeMillis();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60;
		double ns = 100000000 /amountOfTicks;
		
		
		
		while(running) {
			long now = System.nanoTime();
			
			delta += (now - lastTime) / ns;
			
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta --;
			}
			
			if(running) {
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer = System.currentTimeMillis();
				Main.frames = frames;
				System.out.println("Frames: " + frames + "       ||       Location: " + Player1.xLocation + " x " + Player1.yLocation);
				frames = 0;
				runTime++;
			}
		}
		stop();
	}
	public synchronized void start() {
		this.thread = new Thread();
		thread.start();
		running = true;
		System.out.println("running = " + running);
	}
	public void stop() {
		try {
			System.out.println("Bug spotted, porogram stopped");
			thread.join();
			running = false;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void tick() {
		handler.tick();
	}
	
	public void render() {
		BufferStrategy bs =  getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, (int)width, (int)height);
		
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
}
