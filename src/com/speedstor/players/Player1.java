package com.speedstor.players;

import java.awt.Graphics;

import com.speedstor.Input.Input;
import com.speedstor.main.Handler;
import com.speedstor.main.Objects;
import com.speedstor.map.MapRender;

public class Player1 extends Objects{
	public static double speed = 0.5;
	public static int facing, facingTimer = 0;
	Handler handler;
	
	public Player1(Handler handler) {
		this.handler = handler;
	}

	public void tick() {
		
		//Directing the player to face the right direction before taking off
		if(facing != MapRender.direction && MapRender.direction != 0 && Input.keyChange == false) facingTimer++;
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
