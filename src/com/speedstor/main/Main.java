package com.speedstor.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.speedstor.input.Input;
import com.speedstor.map.LoadMap;
import com.speedstor.map.MapRender;

public class Main extends Canvas implements Runnable {
	private static final long serialVersionUID = -2578428780737535640L;
	
	//Variables
		//Global
			public boolean running = true;
			public int runTime = 0;
			public double width = 1200, height = width / 4 * 3;
			public static int key = 0;
		
		//Private
			Handler handler;
			private Thread thread;
		
		//Game Engine
			private long milTime, delta, timer;

		
			
	
	//Initial Commit
	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		handler = new Handler();
		
		new Window((int) width, (int)height, "Pokemon is dumb", this);
		handler.addObject(new LoadMap("src//com//speedstor//main/Map1.txt", handler));
		handler.addObject(new MapRender(handler));
		
		//keyInput
		addKeyListener(new Input());
		
		run();
	}

	//Game Engine
	public void run() {
		int frames = 0;
		
		requestFocus();
		System.out.println("The game had started on " + frames + ".");
		
		timer = System.currentTimeMillis();
		milTime = System.currentTimeMillis();
		
		while(running) {
			delta = System.currentTimeMillis() - milTime;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			
			if(running) {
				render();
				frames++;
			}
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer = System.currentTimeMillis();
				System.out.println("Frames: " + frames);
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
		
		g.setFont(new java.awt.Font("Calibre", 8, 30));
		g.setColor(Color.gray);
		g.drawString("Key: " + key, 30, 40);
		
		handler.render(g);
		
		g.dispose();
		bs.show();
	}
}
