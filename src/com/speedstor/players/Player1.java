package com.speedstor.players;

import java.awt.Graphics;
import com.speedstor.Input.Input;
import com.speedstor.main.Handler;
import com.speedstor.main.Main;
import com.speedstor.map.MapRender;

public class Player1 extends Characters{
	public static double speed = 0.5;
	public static int facingTimer = 0;
	Handler handler;
	
	public Player1(String spriteSheet, Handler handler) {
		this.handler = handler;
		faceDirection = 2;
		
		init("Player1", spriteSheet);
		
	}

	public void tick() {
		//face the charcter graphics to the right direction
		if(facing != MapRender.direction && MapRender.direction != 0 && Input.keyChange == false && MapRender.xSpeed == 0 && MapRender.ySpeed == 0) faceDirection = MapRender.direction;
		
		//Directing the player to face the right direction before taking off
		if(facing != MapRender.direction && MapRender.direction != 0 && Input.keyChange == false) { facingTimer++; }
		if(facingTimer > 150 && MapRender.direction != 0) {
			facing = MapRender.direction;
			facingTimer = 0;
		}
		
		
		
	}
	
	
	public static int step = 0, xStep = 0;
	public void render(Graphics g) {
		//Switches to the slide of keyframes needed for the animation according to the direction the player is going to
		
			switch(faceDirection) {
				case 1:
					g.drawImage(up.get(step), (int) (Main.width / 2) - 87, (int) Main.height / 16 * 6, 169, 128, null);
					break;
				case 2:
					g.drawImage(down.get(step), (int) (Main.width / 2) - 87, (int) Main.height / 16 * 6, 169, 128, null);
					break;
				case 3:
					g.drawImage(left.get(xStep), (int) (Main.width / 2) - 87, (int) Main.height / 16 * 6, 169, 128, null);
					break;
				case 4:
					g.drawImage(right.get(xStep), (int) (Main.width / 2) - 87, (int) Main.height / 16 * 6, 169, 128, null);
					break;
			}
			
	}
}






