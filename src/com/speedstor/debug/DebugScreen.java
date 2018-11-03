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
	Runtime runtime;
	public static double Memory, Memorytotal;
	
	public DebugScreen(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void render(Graphics g) {		
		g.setColor(transparentGrey);
		g.fillRect(0, 0, 560, 60);
		g.fillRect(0, 60, 552, 60);
		g.fillRect(0, 120, 200, 60);
		g.fillRect((int)Main.width - 595, 0, 595, 60);
		
		g.setFont(defualtFont);
		g.setColor(transparentWhite);
		g.drawString("Memory: " + Math.round((Memory/Memorytotal) * 100)+ "% (" + Memory + "MB) of " + Memorytotal + "MB", 615,42);
		g.drawString("Speedstor \u00a9 PokemonRipoff v2.1.0", 8, 42);
		g.drawString("Location: " + Player1.xLocation +  " x " + Player1.yLocation + "  ||  runTime: " + Main.runTime, 8, 100);
		g.drawString("FPS: " + Main.frames , 8, 158);
	}

	@Override
	public void tick() {
		Memory = Math.round(Runtime.getRuntime().freeMemory()/ 100000) / 1e+1;
		Memorytotal = Math.round(Runtime.getRuntime().totalMemory()/ 100000) / 10;
	}

}




//Notes:
	//full transparence is 255
