package com.speedstor.players;

import java.awt.Graphics;
import com.speedstor.Input.Input;
import com.speedstor.main.Handler;
import com.speedstor.main.LoadImage;
import com.speedstor.main.Main;
import com.speedstor.map.MapRender;

public class Player1 extends Characters{
	public static double speed = 0.5;
	public static int facingTimer = 0, xLocation = 16, yLocation = 16;
	Handler handler;

	private int xDisplayLocation = (int) (Main.width / 2) - 87, yDisplayLocation = (int) Main.height / 16 * 6;
	
	public Player1(String spriteSheet, Handler handler, LoadImage loader) {
		this.handler = handler;
		faceDirection = 2;
		
		//initialize the sprite sheet
		init("Player1", spriteSheet, loader);
		
	}

	public void tick() {
		//face the character graphics to the right direction
		if(facing != MapRender.direction && MapRender.direction != 0 && Input.keyChange == false && MapRender.xSpeed == 0 && MapRender.ySpeed == 0) faceDirection = MapRender.direction;
		
		//Directing the player to face the right direction before taking off
		if(facing != MapRender.direction && MapRender.direction != 0 && Input.keyChange == false) { facingTimer++; }
		if(facingTimer > 150 && MapRender.direction != 0) {
			facing = MapRender.direction;
			facingTimer = 0;
		}
		
	}
	
	
	//updates the location of the player in the array map
	public static void updateLocation() {
		if(MapRender.ySpeed > 0) yLocation--;
		else if(MapRender.ySpeed < 0) yLocation++;
		else if(MapRender.xSpeed < 0) xLocation++;
		else if(MapRender.xSpeed > 0) xLocation--;
	}
	
	
	public static int step = 0, xStep = 0, xSpeedStep = 0, xSpeedStep1 = 0, ySpeedStep = 0, ySpeedStep1 = 0;
	public void render(Graphics g) {
		//Switches to the slide of keyframes needed for the animation according to the direction the player is going to
		
		
			switch(faceDirection) {
				case 1:
					if(MapRender.ySpeed == 0.5 || MapRender.ySpeed == 0) g.drawImage(up.get(step/2), xDisplayLocation, yDisplayLocation, 169, 128, null);
					if(MapRender.ySpeed == 1.5) g.drawImage(sprintUp.get(ySpeedStep / 4), xDisplayLocation, yDisplayLocation, 169, 128, null);
					break;
				case 2:
					if(MapRender.ySpeed == -0.5 || MapRender.ySpeed == 0) g.drawImage(down.get(step/2), xDisplayLocation, yDisplayLocation, 169, 128, null);
					if(MapRender.ySpeed == -1.5) g.drawImage(sprintDown.get(ySpeedStep / 4), xDisplayLocation, yDisplayLocation, 169, 128, null);
					break;
				case 3:
					if(MapRender.xSpeed == 0.5 || MapRender.xSpeed == 0) g.drawImage(left.get(xStep/2), xDisplayLocation, yDisplayLocation, 169, 128, null);
					if(MapRender.xSpeed == 1.5) g.drawImage(sprintLeft.get(xSpeedStep/4 ), xDisplayLocation, yDisplayLocation, 169, 128, null);
					break;
				case 4:
					if(MapRender.xSpeed == -0.5 || MapRender.xSpeed == 0) g.drawImage(right.get(xStep/2), xDisplayLocation, yDisplayLocation, 169, 128, null);
					if(MapRender.xSpeed == -1.5) g.drawImage(sprintRight.get(xSpeedStep/4), xDisplayLocation, yDisplayLocation, 169, 128, null);
					break;
			}
			
	}
}






