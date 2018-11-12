package com.speedstor.main;

import java.awt.Color;
import java.awt.Graphics;

public class ChangeScene extends Objects{
	int r, gg, b, buff;
	double transparency;
	Handler handler;
		
	public ChangeScene(int r, int gg, int b, Handler handler) {
		this.r = r;
		this.gg = gg;
		this.b = b;
		this.handler = handler;
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(new Color(r, gg, b, (int) transparency));
		g.fillRect(0,  0, (int) Main.width,(int) Main.height);
	}

	@Override
	public void tick() {
		transparency += 0.25;
		
		if(transparency > 255) {
			transparency = 255;
			buff++;
		}
		if(buff == 1) {
			handler.HaHaHardCodingWhatYouGonnaDo();
		}
		if(buff > 500) {
			handler.removeObject(this);
		}
	}
	
}
