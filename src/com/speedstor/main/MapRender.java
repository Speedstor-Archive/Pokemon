package com.speedstor.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MapRender extends Objects{
	//Variables
		Handler handler;
		public static boolean up = false, down = false, right = false, left = false;
		LoadImage loader;
		BufferedImage image;
		public static float x = 0, y = 0, xSpeed = 0, ySpeed = 0;
		
	public MapRender(Handler handler) {
		this.handler = handler;
		loader = new LoadImage();
		
		image = loader.Load("/testMap.png");
	}
	
	public void tick() {
		x += xSpeed;
		y += ySpeed;
		
		/*
		if(up == true) {ySpeed = 1;} else if(up ==false) ySpeed = 0;
		if(down == true) {ySpeed = -1;} else if(down == false) ySpeed = 0;
		if(left == true) {xSpeed = 1;} else if(left == false) xSpeed = 0;
		if(right == true) {xSpeed = -1;} else if(right == false) xSpeed = 0;*/
	}

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, image.getWidth() * 6, image.getHeight() * 6, null);
	}
}
