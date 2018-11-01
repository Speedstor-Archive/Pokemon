package com.speedstor.main;

import java.awt.Graphics;

public class Player1 extends Objects{
	public static double speed = 0.5;
	public static int facing, facingTimer = 0;
	Handler handler;
	
	public Player1(Handler handler) {
		this.handler = handler;
	}

	public void tick() {
		
		//Directing the player to face the right direction before taking off
		if(facing != MapRender.direction && MapRender.direction != 0) facingTimer++;
		if(facingTimer > 200 && MapRender.direction != 0) {
			facing = MapRender.direction;
			facingTimer = 0;
		}
		
		//Switches to the slide of keyframes needed for the animation according to the direction the player is going to
		switch(MapRender.direction) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
		}
		
	}
	
	
	public void render(Graphics g) {
		
		
	}
}
