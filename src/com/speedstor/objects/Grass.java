package com.speedstor.objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.speedstor.main.Handler;
import com.speedstor.main.LoadImage;
import com.speedstor.main.Main;
import com.speedstor.main.Objects;
import com.speedstor.map.MapRender;

public class Grass extends Objects{
	private double x, y;
	LoadImage loader;
	Handler handler;
	BufferedImage img;
	protected static double shx;	
	protected double yTransform;
	
	public Grass(String path, Handler handler, LoadImage loader, double x, double y) {
		
		this.loader = loader;
		this.handler = handler;
		this.x = x - 33;
		this.y = y + 10;
		
		img = loader.Load(path);
	}	
	
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		shx = (x + 145 - (Main.width/2)) / 6500;
		yTransform = 48 + y / 20;
		g2.shear(shx, 0);
		g.drawImage(img, (int) x,(int)( y - yTransform/2), 80, (int)yTransform , null);
		g2.shear(-shx, 0);
	}
	
	public void tick() {
		x = x + MapRender.xSpeed;
		y = y + MapRender.ySpeed;
		
		if(x < -230 || x > Main.width + 230 || y < -220 || y > Main.height + 220) handler.removeObject(this);
		
	}
	
	
	
}
