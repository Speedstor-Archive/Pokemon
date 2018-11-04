package com.speedstor.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.speedstor.main.Handler;
import com.speedstor.main.LoadImage;
import com.speedstor.main.Main;
import com.speedstor.main.Objects;

public class Trees extends Objects{
	
	public static double xSpeed, ySpeed;
	private double x, y;
	LoadImage loader;
	Handler handler;
	BufferedImage img;
	private static double shx;
	
	public Trees(String path, Handler handler, LoadImage loader, double x, double y) {
		this.loader = loader;
		this.handler = handler;
		this.x = x - 1* 69;
		this.y = y + 0* 69;
		
		img = loader.Load(path);
		
	}

	private double yTransform;
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		shx = (x + 145 - (Main.width/2)) / 6500;
		yTransform = 220 + y / 20;
		g2.shear(shx, 0);
		g.drawImage(img, (int) x,(int)( y - yTransform/2), 255, (int)yTransform , null);
		g2.shear(-shx, 0);
		
		
	}

	@Override
	public void tick() {
		x += MapRender.xSpeed;
		y += MapRender.ySpeed;
		
		if(x < -440 || x > Main.width + 440 || y < -500 || y > Main.height + 500) handler.removeObject(this);
		
	}

}
