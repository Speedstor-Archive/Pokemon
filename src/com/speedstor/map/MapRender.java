package com.speedstor.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.speedstor.main.Handler;
import com.speedstor.main.LoadImage;
import com.speedstor.main.Objects;
import com.speedstor.players.Player1;

public class MapRender extends Objects{
	//Variables
		Handler handler;
		public static boolean up = false, down = false, right = false, left = false;
		LoadImage loader;
		BufferedImage image;
		public static double x = 0, y = 0, xSpeed = 0, ySpeed = 0, buff, xBuff, yBuff;
		public static int direction, location;
		
		//up: 1
		//down: 2
		//left: 3
		//right: 4
		
	public MapRender(Handler handler) {
		this.handler = handler;
		loader = new LoadImage();
		
		image = loader.Load("/testMap.png");
	}
	
	public void tick() {
		x += xSpeed;
		y += ySpeed;
		
		if(xSpeed != 0) { xBuff += Math.abs(xSpeed);}
		if (ySpeed != 0 ) yBuff += Math.abs(ySpeed);
		
		
		//stops actions in blocks
		if(yBuff >= 80) {yBuff = 0;}
		else if(xBuff >= 80) {xBuff = 0;}
		
		
		//Handles double clicks
		if(xBuff == 0 && yBuff == 0) {
			if(direction == Player1.facing) {
				switch(direction) {
					case 1:
						buff = xSpeed;
						xSpeed = 0;
						ySpeed = Player1.speed;
						break;
					case 2:
						buff = xSpeed;
						xSpeed = 0;
						ySpeed = -Player1.speed;
						break;
					case 3:
						buff = ySpeed;
						ySpeed = 0;
						xSpeed = Player1.speed;
						break;
					case 4:
						buff = ySpeed;
						ySpeed = 0;
						xSpeed = -Player1.speed;
						break;
				}
			}else if(direction == 0) {
						xSpeed = 0;
						ySpeed = 0;
			}
		}
	
		//Resets direction
		if(up == false && down == false && left == false && right == false) direction = 0;
		
		
	}
	
	

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, image.getWidth() * 6, image.getHeight() * 6, null);
	}
}
