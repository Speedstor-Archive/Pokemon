package com.speedstor.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.speedstor.Input.Input;
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
		
	public MapRender(Handler handler, LoadImage loader) {
		this.handler = handler;
		this.loader = loader;
		
		int xStart = Player1.xLocation - 9;
		int yStart = Player1.yLocation - 7;
		
		for(int i = 0; i < 19; i++) {
			int xx = xStart + i;
			for(int u = 0; u < 15; u++) {
				int yy = yStart + u;
				if(LoadMap.map[xx][yy] == 88) {
					handler.addObject(new Trees("/testTree.png", handler, loader, - 40 + (xx - xStart - 1) * 69, - 60 + (yy - yStart - 1) * 69));
				}
				
				
			}
		}
		
		/*for(int i = 0; i < LoadMap.col; i++) {
			int xx = xStart + i;
			for(int u = 0; u < LoadMap.row; u++) {
				int yy = yStart + u;
				if(LoadMap.map[i][u] == 88) {
					handler.addObject(new Trees("/testTree.png", handler, loader, - 40 + (xx - Player1.xLocation + 1) * 69, - 60 + (yy - Player1.yLocation - 1) * 69));
				}
				
				
			}
		}*/
		
		
		image = loader.Load("/testMap2.png");
	}
	
	public void tick() {		
		//Counts the pixels to blocks passed && handles animation frames
		if(xSpeed != 0) { 
			xBuff += Math.abs(xSpeed);
			if(xBuff == 1.5) Player1.xStep++;
			else if(xBuff == 24) Player1.xStep++;
			else if(xBuff == 46.5) Player1.xStep++;
			if(Player1.xStep >= 8) Player1.xStep = 0;
		}else Player1.xStep = 0;
		if (ySpeed != 0 ) {
			yBuff += Math.abs(ySpeed);
			if(yBuff == 1.5) Player1.step++;
			else if(yBuff == 24) Player1.step++;
			else if(yBuff == 46.5) Player1.step++;
			if(Player1.step >= 8) Player1.step = 0;
		}else Player1.step = 0;
		
		if(Player1.xSpeedStep1 != Player1.xStep) { Player1.xSpeedStep1 = Player1.xStep; Player1.xSpeedStep++; if(Player1.xSpeedStep >= 16) Player1.xSpeedStep = 0;}
		else if(Player1.ySpeedStep1 != Player1.step) { Player1.ySpeedStep1 = Player1.step; Player1.ySpeedStep++; if(Player1.ySpeedStep >= 16) Player1.ySpeedStep = 0;}
		
		
		
		//stops actions in blocks
		if(yBuff >= 69) {
			yBuff = 0; Player1.updateLocation(); LoadMap.barrier();
			updateDisplayObj();
		}else if(xBuff >= 69) {
			xBuff = 0; Player1.updateLocation(); LoadMap.barrier();
			updateDisplayObj();
		}
		

		//Resets direction
		if(up == false && down == false && left == false && right == false) direction = 0;
		
		
		//Handles double clicks
		if(xBuff == 0 && yBuff == 0 && direction == Player1.facing) {
			Input.keyChange = false;
			if(direction != 0) Player1.faceDirection = direction;
				switch(direction) {
					case 1:
						//if(LoadMap.upBlock == false) {
							xSpeed = 0;
							ySpeed = Player1.speed;
						//}else ySpeed = 0;
							if(LoadMap.upBlock) ySpeed = 0;
						break;
					case 2:
						//if(LoadMap.downBlock == false) {
							xSpeed = 0;
							ySpeed = -Player1.speed;
						//}else ySpeed = 0;
							if(LoadMap.downBlock) ySpeed = 0;
						break;
					case 3:
						//if(LoadMap.leftBlock == false) {
							ySpeed = 0;
							xSpeed = Player1.speed;
						//}else xSpeed = 0;
							if(LoadMap.leftBlock) xSpeed = 0;
						break;
					case 4:
						//if(LoadMap.rightBlock == false) {
							ySpeed = 0;
							xSpeed = -Player1.speed;
						//}else xSpeed = 0;
							if(LoadMap.rightBlock) xSpeed = 0;
						break;
				}
		}else if(xBuff == 0 && yBuff == 0 && direction == 0) {
						xSpeed = 0;
						ySpeed = 0;
		}
		

		x += xSpeed;
		y += ySpeed;
		
	}
	
	
	int xx, yy, xStart, yStart;
	private void updateDisplayObj() {
		xStart = Player1.xLocation - 9;
		yStart = Player1.yLocation - 7;
		
		if(ySpeed > 0) {
			for(int i = 0; i < 19; i++) {
				xx = xStart + i;
				if(LoadMap.map[xx][yStart] == 88) {
					handler.addObject(new Trees("/testTree.png", handler, loader, - 40 + (xx - xStart - 1) * 69, - 60 + (-1 * 69)));
				}
			}
		}else if(ySpeed < 0) {
		yy = yStart + 15;
		for(int i = 0; i < 19; i++) {
			xx = xStart + i;
			if(LoadMap.map[xx][yy] == 88) {
				handler.addObject(new Trees("/testTree.png", handler, loader, - 40 + (xx - xStart - 1) * 69, - 60 + (14 * 69)));
			}
		}
		}else if(xSpeed > 0) {
		for(int i = 0; i < 15; i++) {
			yy = yStart + i;
			if(LoadMap.map[xStart][yy] == 88) {
				handler.addObject(new Trees("/testTree.png", handler, loader, - 40 + -1 * 69, - 60 + (yy - yStart - 1) * 69));
			}
		}
		}else if(xSpeed < 0) {
		xx = xStart + 19;
		for(int i = 0; i < 15; i++) {
			yy = yStart + i;
			if(LoadMap.map[xx][yy] == 88) {
				handler.addObject(new Trees("/testTree.png", handler, loader, - 40 + (18 * 69), - 60 + (yy - yStart - 1) * 69));
			}
		}
		}
		
	}

	public void render(Graphics g) {
		
		//g.drawImage(image, (int)x + 34, (int)y, (int)(image.getWidth() * 4.8),(int)( image.getHeight() * 4.8), null);
		
	}
}
