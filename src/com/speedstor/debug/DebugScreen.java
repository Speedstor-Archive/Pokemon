package com.speedstor.debug;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.speedstor.main.Handler;
import com.speedstor.main.Main;
import com.speedstor.main.Objects;
import com.speedstor.players.Player1;

public class DebugScreen extends Objects{
	Color transparentGrey = new Color(0, 0, 0, 170);
	Color transparentWhite = new Color(255, 255, 255, 190);
	Font defualtFont = new Font("Calibre", 8, 35);
	Handler handler;
	
	public DebugScreen(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void render(Graphics g) {		
		g.setColor(transparentGrey);
		g.fillRect(0, 0, 600, 60);
		g.fillRect(0, 60, 200, 60);
		
		g.setFont(defualtFont);
		g.setColor(transparentWhite);
		g.drawString("Location: " + Player1.xLocation +  " x " + Player1.yLocation + "   ||   runTime: " + Main.runTime, 20, 42);
		g.drawString("FPS: " + Main.frames , 20, 100);
	}

	@Override
	public void tick() {
		
	}

}

//Notes:
	//full transparence is 255
